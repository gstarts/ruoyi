package com.ruoyi.stations_management.montroller.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.montroller.mapper.VeRfidMapper;
import com.ruoyi.stations_management.montroller.domain.VeRfid;
import com.ruoyi.stations_management.montroller.service.IVeRfidService;

/**
 * 车辆通关时电子车牌信息Service业务层处理
 * 
 * @author songxiangyang
 * @date 2020-06-28
 */
@Service
public class VeRfidServiceImpl implements IVeRfidService 
{
    @Autowired
    private VeRfidMapper veRfidMapper;

    /**
     * 查询车辆通关时电子车牌信息
     * 
     * @param id 车辆通关时电子车牌信息ID
     * @return 车辆通关时电子车牌信息
     */
    @Override
    public VeRfid selectVeRfidById(Long id)
    {
        return veRfidMapper.selectVeRfidById(id);
    }

    /**
     * 查询车辆通关时电子车牌信息列表
     * 
     * @param veRfid 车辆通关时电子车牌信息
     * @return 车辆通关时电子车牌信息
     */
    @Override
    public List<VeRfid> selectVeRfidList(VeRfid veRfid)
    {
        return veRfidMapper.selectVeRfidList(veRfid);
    }

    /**
     * 新增车辆通关时电子车牌信息
     * 
     * @param veRfid 车辆通关时电子车牌信息
     * @return 结果
     */
    @Override
    public int insertVeRfid(VeRfid veRfid)
    {
        return veRfidMapper.insertVeRfid(veRfid);
    }

    /**
     * 修改车辆通关时电子车牌信息
     * 
     * @param veRfid 车辆通关时电子车牌信息
     * @return 结果
     */
    @Override
    public int updateVeRfid(VeRfid veRfid)
    {
        return veRfidMapper.updateVeRfid(veRfid);
    }

    /**
     * 批量删除车辆通关时电子车牌信息
     * 
     * @param ids 需要删除的车辆通关时电子车牌信息ID
     * @return 结果
     */
    @Override
    public int deleteVeRfidByIds(Long[] ids)
    {
        return veRfidMapper.deleteVeRfidByIds(ids);
    }

    /**
     * 删除车辆通关时电子车牌信息信息
     * 
     * @param id 车辆通关时电子车牌信息ID
     * @return 结果
     */
    @Override
    public int deleteVeRfidById(Long id)
    {
        return veRfidMapper.deleteVeRfidById(id);
    }
}
