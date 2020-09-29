package com.ruoyi.stations_management.declare.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.declare.mapper.AnimalsBodyMapper;
import com.ruoyi.stations_management.declare.domain.AnimalsBody;
import com.ruoyi.stations_management.declare.service.IAnimalsBodyService;

/**
 * 动物体Service业务层处理
 *
 * @author qishuai
 * @date 2020-04-07
 */
@Service
public class AnimalsBodyServiceImpl implements IAnimalsBodyService {
    @Autowired
    private AnimalsBodyMapper animalsBodyMapper;

    /**
     * 查询动物体
     *
     * @param id 动物体ID
     * @return 动物体
     */
    @Override
    public AnimalsBody selectAnimalsBodyById(Long id) {
        return animalsBodyMapper.selectAnimalsBodyById(id);
    }

    /**
     * 查询动物体列表
     *
     * @param animalsBody 动物体
     * @return 动物体
     */
    @Override
    public List<AnimalsBody> selectAnimalsBodyList(AnimalsBody animalsBody) {
        return animalsBodyMapper.selectAnimalsBodyList(animalsBody);
    }

    /**
     * 新增动物体
     *
     * @param animalsBody 动物体
     * @return 结果
     */
    @Override
    public int insertAnimalsBody(AnimalsBody animalsBody) {
        return animalsBodyMapper.insertAnimalsBody(animalsBody);
    }

    /**
     * 修改动物体
     *
     * @param animalsBody 动物体
     * @return 结果
     */
    @Override
    public int updateAnimalsBody(AnimalsBody animalsBody) {
        return animalsBodyMapper.updateAnimalsBody(animalsBody);
    }

    /**
     * 批量删除动物体
     *
     * @param ids 需要删除的动物体ID
     * @return 结果
     */
    @Override
    public int deleteAnimalsBodyByIds(Long[] ids) {
        return animalsBodyMapper.deleteAnimalsBodyByIds(ids);
    }

    /**
     * 删除动物体信息
     *
     * @param id 动物体ID
     * @return 结果
     */
    @Override
    public int deleteAnimalsBodyById(Long id) {
        return animalsBodyMapper.deleteAnimalsBodyById(id);
    }

    @Override
    public String validationRules(List<AnimalsBody> list) {
        StringBuilder failureMsg = new StringBuilder();
        String[] comment = {"商品类别", "商品子类", "商品名称", "数量", "单位kg", "数据处理标识",};
        if (StringUtils.isNull(list) || list.size() == 0) {
            return failureMsg.append("导入数据不能为空").toString();
        }
        int row = 1;
        for (AnimalsBody animals : list) {
            if (StringUtils.isEmpty(animals.getGoodscode())) {
                failureMsg.append("第" + row + "行数据不正确" + comment[0] + "不能为空");
            }
            if (StringUtils.isEmpty(animals.getGoodssubclass())) {
                failureMsg.append("第" + row + "行数据不正确" + comment[1] + "不能为空");
            }
            if (StringUtils.isEmpty(animals.getGoodsname())) {
                failureMsg.append("第" + row + "行数据不正确" + comment[2] + "不能为空");
            }
            if (StringUtils.isEmpty(animals.getQuantity())) {
                failureMsg.append("第" + row + "行数据不正确" + comment[3] + "不能为空");
            }
            if (StringUtils.isEmpty(animals.getUnit())) {
                failureMsg.append("第" + row + "行数据不正确" + comment[4] + "不能为空");
            }
            if (StringUtils.isEmpty(animals.getDatadealflag())) {
                failureMsg.append("第" + row + "行数据不正确" + comment[5] + "不能为空");
            }
            if (!animals.getDatadealflag().equals("A") && (!animals.getDatadealflag().equals("M")) && (!animals.getDatadealflag().equals("D"))) {
                failureMsg.append("第" + row + "行数据不正确" + comment[5] + "无效" + "有效为：A:增加；M:修改；D:删除");
            }
            if(StringUtils.isNotEmpty(failureMsg.toString())){
                failureMsg.append("<br/>");
            }
            row++;
        }
        if(StringUtils.isNotEmpty(failureMsg.toString())){
            failureMsg.insert(0, "很抱歉，导入失败！ 数据格式不正确，错误如下：<br/>");
        }
        return failureMsg.toString();
    }

    @Override
    public String importAnimals(List<AnimalsBody> list, Long headId) {

        String errMsg = validationRules(list);
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        if (StringUtils.isEmpty(errMsg)) {
            for (AnimalsBody animalsBody : list) {
                animalsBody.setHeadId(headId);
            }

            try {
                animalsBodyMapper.insertBatchAnimalsBody(list);
                successMsg.append("数据导入成功").toString();
            } catch (Exception e) {
                failureMsg.append("导入失败");
                failureMsg.append(e.getMessage());
                throw new CustomException(failureMsg.toString());
            }
        } else {
            return failureMsg.append(errMsg).toString();
        }

        return successMsg.toString();
    }
}
