package com.ruoyi.stations_management.monitor.service;

import com.ruoyi.stations_management.monitor.domain.EquipmentInfo;

import java.util.List;

/**
 * 设备
 * Service接口
 *
 * @author qishuai
 * @date 2020-03-26
 */
public interface IEquipmentInfoService {
    /**
     * 查询设备
     *
     * @param id 设备
     *           ID
     * @return 设备
     */
    public EquipmentInfo selectEquipmentInfoById(Long id);

    /**
     * 查询设备列表
     *
     * @param equipmentInfo 设备
     * @return 设备
     * 集合
     */
    public List<EquipmentInfo> selectEquipmentInfoList(EquipmentInfo equipmentInfo);

    /**
     * 新增设备
     *
     * @param equipmentInfo 设备
     * @return 结果
     */
    public int insertEquipmentInfo(EquipmentInfo equipmentInfo);

    /**
     * 修改设备
     *
     * @param equipmentInfo 设备
     * @return 结果
     */
    public int updateEquipmentInfo(EquipmentInfo equipmentInfo);

    /**
     * 批量删除设备
     *
     * @param ids 需要删除的设备
     *            ID
     * @return 结果
     */
    public int deleteEquipmentInfoByIds(Long[] ids);

    /**
     * 删除设备信息
     *
     * @param id 设备ID
     * @return 结果
     */
    public int deleteEquipmentInfoById(Long id);

    /**
     *  重启设备
     * @param id 设备ID
     * @return 结果
     */
    public int restartEquipmentById(Long id);
}
