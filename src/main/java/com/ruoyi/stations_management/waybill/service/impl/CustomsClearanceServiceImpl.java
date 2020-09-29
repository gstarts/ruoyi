package com.ruoyi.stations_management.waybill.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.stations_management.waybill.domain.CustomsClearance;
import com.ruoyi.stations_management.waybill.mapper.CustomsClearanceMapper;
import com.ruoyi.stations_management.waybill.service.ICustomsClearanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 通关单Service业务层处理
 *
 * @author qishuai
 * @date 2020-02-25
 */
@Service
public class CustomsClearanceServiceImpl implements ICustomsClearanceService {
    private static final Logger log = LoggerFactory.getLogger(CustomsClearanceServiceImpl.class);

    @Resource
    private CustomsClearanceMapper customsClearanceMapper;

    /**
     * 查询通关单
     *
     * @param id 通关单ID
     * @return 通关单
     */
    @Override
    public CustomsClearance selectSCustomsClearanceById(Long id) {
        return customsClearanceMapper.selectCustomsClearanceById(id);
    }

    /**
     * 查询通关单列表
     *
     * @param customsClearance 通关单
     * @return 通关单
     */
    @Override
    public List<CustomsClearance> selectSCustomsClearanceList(CustomsClearance customsClearance) {

        return customsClearanceMapper.selectCustomsClearanceList(customsClearance);
    }

    /**
     * 新增通关单
     *
     * @param customsClearance 通关单
     * @return 结果
     */
    @Override
    @Transactional
    public int insertSCustomsClearance(CustomsClearance customsClearance) {
        customsClearance.setCcLastWieght(customsClearance.getCcCustomsWieght());
        return customsClearanceMapper.insertCustomsClearance(customsClearance);
    }

    /**
     * 修改通关单
     *
     * @param customsClearance 通关单
     * @return 结果
     */
    @Override
    public int updateSCustomsClearance(CustomsClearance customsClearance) {
        customsClearance.setCcLastWieght(customsClearance.getCcCustomsWieght());
        return customsClearanceMapper.updateCustomsClearance(customsClearance);
    }

    /**
     * 批量删除通关单
     *
     * @param ids 需要删除的通关单ID
     * @return 结果
     */
    @Override
    public int deleteSCustomsClearanceByIds(Long[] ids) {
        return customsClearanceMapper.deleteCustomsClearanceByIds(ids);
    }

    /**
     * 删除通关单信息
     *
     * @param id 通关单ID
     * @return 结果
     */
    @Override
    public int deleteSCustomsClearanceById(Long id) {
        return customsClearanceMapper.deleteCustomsClearanceById(id);
    }

    @Override
    @Transactional
    public String importCustoms(List<CustomsClearance> list, int corporationId, String opeName) {
        if (StringUtils.isNull(list) || list.size() == 0) {
            throw new CustomException("导入用户数据不能为空！");
        }
        Set<String> hashSet = new HashSet<>();
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            CustomsClearance customs = list.get(i);
            try {
                if (check(customs)) {
                    customs.setCcCorporation(corporationId);
                    // 设置初始剩余重量
                    customs.setCcLastWieght(StringUtils.trim(customs.getCcCustomsWieght()));
                } else {
                    failureNum++;
                    int num = i + 1;
                    String msg = "<br/>第" + num + " 条导入失败：";
                    failureMsg.append(msg).append("通关单重量不是数字");
                }
                // 利用set 校验通关单-通关单批次号重复数据
                if (!hashSet.add(customs.getCcCustomsNumber() + customs.getCcCustomsBatchNumber())) {
                    failureNum++;
                    int num = i + 1;
                    String msg = "<br/>第" + num + " 条导入失败：";
                    failureMsg.append(msg).append("通关单-通关单批次号重复");
                }

            } catch (Exception e) {
                failureNum++;
                int num = i + 1;
                String msg = "<br/>第" + num + " 条导入失败：";
                failureMsg.append(msg).append(e.getMessage());
                log.error(msg, e);
            }

        }
        // 异常情况抛出
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        //  通过校验的数据入库
        else {
            successMsg.append(insertData(list));
        }
        return successMsg.toString();
    }


    private boolean check(CustomsClearance cus) {

        // 校验是否为空
        if (StringUtils.isEmpty(cus.getCcCustomsNumber()) || StringUtils.isEmpty(cus.getCcCustomsBatchNumber()) || StringUtils.isEmpty(cus.getCcCustomsWieght())) {
            return false;
        }
        // 校验重量是否是数字
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(cus.getCcCustomsWieght()).matches();

    }

    /**
     * 将数据入库
     *
     * @param list 数据集
     * @return 结果
     */
    private String insertData(List<CustomsClearance> list) {
        // 进行插入
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (CustomsClearance customs : list) {
            //放入货物对象中
            this.insertSCustomsClearance(customs);
            successNum++;
            successMsg.append("<br/>").append(successNum).append(" 导入成功");
        }
        return successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：").toString();
    }

}

