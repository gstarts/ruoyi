package com.ruoyi.stations_management.monitor.mapper;

import com.ruoyi.stations_management.monitor.domain.EquipmentInfo;
import java.util.List;

/**
 * 设备
Mapper接口
 *
 * @author qishuai
 * @date 2020-03-26
 */
public interface EquipmentInfoMapper
{
    /**
     * 查询设备

     *
     * @param id 设备
ID
     * @return 设备

     */
    public EquipmentInfo selectEquipmentInfoById(Long id);

    /**
     * 查询设备列表
     *
     * @param equipmentInfo 设备

     * @return 设备集合
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
     * 删除设备

     *
     * @param id 设备
ID
     * @return 结果
     */
    public int deleteEquipmentInfoById(Long id);

    /**
     * 批量删除设备

     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEquipmentInfoByIds(Long[] ids);

    public int restartEquipmentById(Long id);
}
