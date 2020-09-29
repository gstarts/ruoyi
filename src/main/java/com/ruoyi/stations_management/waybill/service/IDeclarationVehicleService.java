package com.ruoyi.stations_management.waybill.service;

import com.ruoyi.stations_management.waybill.domain.DeclarationVehicle;
import java.util.List;

/**
 * 申报车辆Service接口
 *
 * @author qishuai
 * @date 2020-03-01
 */
 public interface IDeclarationVehicleService
{
    /**
     * 查询申报车辆
     *
     * @param id 申报车辆ID
     * @return 申报车辆
     */
     DeclarationVehicle selectSDeclarationVehicleById(Long id);

    /**
     * 查询申报车辆列表
     *
     * @param declarationVehicle 申报车辆
     * @return 申报车辆集合
     */
     List<DeclarationVehicle> selectSDeclarationVehicleList(DeclarationVehicle declarationVehicle);

    /**
     * 新增申报车辆
     *
     * @param declarationVehicle 申报车辆
     * @return 结果
     */
     int insertSDeclarationVehicle(DeclarationVehicle declarationVehicle);

    /**
     * 修改申报车辆
     *
     * @param declarationVehicle 申报车辆
     * @return 结果
     */
     int updateSDeclarationVehicle(DeclarationVehicle declarationVehicle);

    /**
     * 批量删除申报车辆
     *
     * @param ids 需要删除的申报车辆ID
     * @return 结果
     */
     int deleteSDeclarationVehicleByIds(Long[] ids);



    /**
     * 申报车辆导入
     * @param list 申报车辆数据
     * @param corporationId  所属公司ID
     * @param opeName 操作人名称
     * @return 导入结果
     */
     String importVehicle(List<DeclarationVehicle> list, int corporationId, String opeName);
}
