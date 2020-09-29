package com.ruoyi.stations_management.mt.mapper;

import java.util.List;

import com.ruoyi.stations_management.mt.domain.BorderTransportEquipment;

/**
 * 托架或拖挂车信息Mapper接口
 *
 * @author songqingchuan
 * @date 2020-07-27
 */
public interface IBorderTransportEquipmentMapper {
    /**
     * 查询托架或拖挂车信息
     *
     * @param id 托架或拖挂车信息ID
     * @return 托架或拖挂车信息
     */
     BorderTransportEquipment selectBorderTransportEquipmentById(Long id);

    /**
     * 查询托架或拖挂车信息列表
     *
     * @param Lid 关联ID
     * @return 托架或拖挂车信息集合
     */
     List<BorderTransportEquipment> selectBorderTransportEquipmentList(Long Lid);

    /**
     * 新增托架或拖挂车信息
     *
     * @param borderTransportEquipment 托架或拖挂车信息
     * @return 结果
     */
     int insertBorderTransportEquipment(BorderTransportEquipment borderTransportEquipment);

    /**
     * 修改托架或拖挂车信息
     *
     * @param borderTransportEquipment 托架或拖挂车信息
     * @return 结果
     */
     int updateBorderTransportEquipment(BorderTransportEquipment borderTransportEquipment);

    /**
     * 删除托架或拖挂车信息
     *
     * @param id 托架或拖挂车信息ID
     * @return 结果
     */
     int deleteBorderTransportEquipmentById(Long id);

    /**
     * 批量删除托架或拖挂车信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteBorderTransportEquipmentByIds(Long[] ids);
}
