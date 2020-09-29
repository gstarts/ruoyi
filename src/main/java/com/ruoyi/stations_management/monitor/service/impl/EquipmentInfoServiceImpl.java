package com.ruoyi.stations_management.monitor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.monitor.mapper.EquipmentInfoMapper;
import com.ruoyi.stations_management.monitor.domain.EquipmentInfo;
import com.ruoyi.stations_management.monitor.service.IEquipmentInfoService;

/**
 * 设备
Service业务层处理
 *
 * @author qishuai
 * @date 2020-03-26
 */
@Service
public class EquipmentInfoServiceImpl implements IEquipmentInfoService
{
    @Autowired
    private EquipmentInfoMapper equipmentInfoMapper;

    /**
     * 查询设备

     *
     * @param id 设备
ID
     * @return 设备

     */
    @Override
    public EquipmentInfo selectEquipmentInfoById(Long id)
    {
        return equipmentInfoMapper.selectEquipmentInfoById(id);
    }

    /**
     * 查询设备
列表
     *
     * @param equipmentInfo 设备

     * @return 设备

     */
    @Override
    public List<EquipmentInfo> selectEquipmentInfoList(EquipmentInfo equipmentInfo)
    {
        return equipmentInfoMapper.selectEquipmentInfoList(equipmentInfo);
    }

    /**
     * 新增设备

     *
     * @param equipmentInfo 设备

     * @return 结果
     */
    @Override
    public int insertEquipmentInfo(EquipmentInfo equipmentInfo)
    {
        return equipmentInfoMapper.insertEquipmentInfo(equipmentInfo);
    }

    /**
     * 修改设备

     *
     * @param equipmentInfo 设备

     * @return 结果
     */
    @Override
    public int updateEquipmentInfo(EquipmentInfo equipmentInfo)
    {
        return equipmentInfoMapper.updateEquipmentInfo(equipmentInfo);
    }

    /**
     * 批量删除设备

     *
     * @param ids 需要删除的设备
ID
     * @return 结果
     */
    @Override
    public int deleteEquipmentInfoByIds(Long[] ids)
    {
        return equipmentInfoMapper.deleteEquipmentInfoByIds(ids);
    }

    /**
     * 删除设备
信息
     *
     * @param id 设备
ID
     * @return 结果
     */
    @Override
    public int deleteEquipmentInfoById(Long id)
    {
        return equipmentInfoMapper.deleteEquipmentInfoById(id);
    }

    @Override
    public int restartEquipmentById(Long id) {
        return equipmentInfoMapper.restartEquipmentById(id);
    }
}
