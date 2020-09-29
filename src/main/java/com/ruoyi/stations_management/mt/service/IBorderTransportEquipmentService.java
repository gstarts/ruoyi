package com.ruoyi.stations_management.mt.service;

import java.util.List;

import com.ruoyi.stations_management.mt.domain.BorderTransportEquipment;

/**
 * 托架或拖挂车信息Service接口
 *
 * @author songqingchuan
 * @date 2020-07-27
 */
public interface IBorderTransportEquipmentService {
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
     * @param Lid 管理ID
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
     * 批量删除托架或拖挂车信息
     *
     * @param ids 需要删除的托架或拖挂车信息ID
     * @return 结果
     */
     int deleteBorderTransportEquipmentByIds(Long[] ids);

}
