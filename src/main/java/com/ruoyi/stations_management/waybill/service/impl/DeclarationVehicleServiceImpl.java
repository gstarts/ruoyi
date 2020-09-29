package com.ruoyi.stations_management.waybill.service.impl;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.stations_management.waybill.domain.DeclarationVehicle;
import com.ruoyi.stations_management.waybill.mapper.DeclarationVehicleMapper;
import com.ruoyi.stations_management.waybill.service.IDeclarationVehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 申报车辆Service业务层处理
 *
 * @author qishuai
 * @date 2020-03-01
 */
@Service
public class DeclarationVehicleServiceImpl implements IDeclarationVehicleService {
    private static final Logger log = LoggerFactory.getLogger(DeclarationVehicleServiceImpl.class);
    @Resource
    private DeclarationVehicleMapper declarationVehicleMapper;

    /**
     * 查询申报车辆
     *
     * @param id 申报车辆ID
     * @return 申报车辆
     */
    @Override
    public DeclarationVehicle selectSDeclarationVehicleById(Long id) {
        return declarationVehicleMapper.selectDeclarationVehicleById(id);
    }

    /**
     * 查询申报车辆列表
     *
     * @param declarationVehicle 申报车辆
     * @return 申报车辆
     */
    @Override
    public List<DeclarationVehicle> selectSDeclarationVehicleList(DeclarationVehicle declarationVehicle) {
        return declarationVehicleMapper.selectDeclarationVehicleList(declarationVehicle);
    }

    /**
     * 新增申报车辆
     *
     * @param declarationVehicle 申报车辆
     * @return 结果
     */
    @Override
    public int insertSDeclarationVehicle(DeclarationVehicle declarationVehicle) {
        return declarationVehicleMapper.insertDeclarationVehicle(declarationVehicle);
    }

    /**
     * 修改申报车辆
     *
     * @param declarationVehicle 申报车辆
     * @return 结果
     */
    @Override
    public int updateSDeclarationVehicle(DeclarationVehicle declarationVehicle) {
        return declarationVehicleMapper.updateDeclarationVehicle(declarationVehicle);
    }

    /**
     * 批量删除申报车辆
     *
     * @param ids 需要删除的申报车辆ID
     * @return 结果
     */
    @Override
    public int deleteSDeclarationVehicleByIds(Long[] ids) {
        return declarationVehicleMapper.deleteDeclarationVehicleByIds(ids);
    }

    @Override
    public String importVehicle(List<DeclarationVehicle> list, int corporationId, String opeName) {
        if (StringUtils.isNull(list) || list.size() == 0) {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            DeclarationVehicle vehicle = list.get(i);
            try {
                if (check(vehicle)) {
                    vehicle.setDvCorporation(corporationId);
                } else {
                    failureNum++;
                    int no = i + 1;
                    String msg = "<br/>第" + no + "条导入失败：";
                    failureMsg.append(msg).append("导入字段不能为空");
                }

            } catch (Exception e) {
                failureNum++;
                int no = i + 1;
                String msg = "<br/>第" + no + "条导入失败：";
                failureMsg.append(msg).append(e.getMessage());
                log.error(msg, e);
            }

        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        } else {
            for (DeclarationVehicle vehicle : list) {
                this.insertSDeclarationVehicle(vehicle);
                successNum++;
                successMsg.append("<br/>").append(successNum).append(" 导入成功");
            }
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    private Boolean check(DeclarationVehicle dv) {
        return !StringUtils.isEmpty(dv.getDvLicense()) && !StringUtils.isNull(dv.getDvTransportNumber()) && !StringUtils.isNull(dv.getDvLoad()) && !StringUtils.isNull(dv.getDvWeight());
    }
}
