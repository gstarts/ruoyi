package com.ruoyi.stations_management.waybill.mapper;

import com.ruoyi.stations_management.waybill.domain.DeclarationVehicle;
import java.util.List;

/**
 * 申报车辆Mapper接口
 *
 * @author qishuai
 * @date 2020-03-01
 */
public interface DeclarationVehicleMapper
{
    /**
     * 查询申报车辆
     *
     * @param id 申报车辆ID
     * @return 申报车辆
     */
     DeclarationVehicle selectDeclarationVehicleById(Long id);

    /**
     * 查询申报车辆列表
     *
     * @param declarationVehicle 申报车辆
     * @return 申报车辆集合
     */
     List<DeclarationVehicle> selectDeclarationVehicleList(DeclarationVehicle declarationVehicle);

    /**
     * 新增申报车辆
     *
     * @param declarationVehicle 申报车辆
     * @return 结果
     */
     int insertDeclarationVehicle(DeclarationVehicle declarationVehicle);

    /**
     * 修改申报车辆
     *
     * @param declarationVehicle 申报车辆
     * @return 结果
     */
     int updateDeclarationVehicle(DeclarationVehicle declarationVehicle);

    /**
     * 删除申报车辆
     *
     * @param id 申报车辆ID
     * @return 结果
     */
     int deleteDeclarationVehicleById(Long id);

    /**
     * 批量删除申报车辆
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteDeclarationVehicleByIds(Long[] ids);
}
