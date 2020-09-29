package com.ruoyi.stations_management.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.report.mapper.Rmft4406TransportequipmentMapper;
import com.ruoyi.stations_management.report.domain.Rmft4406Transportequipment;
import com.ruoyi.stations_management.report.service.IRmft4406TransportequipmentService;

/**
 * 集装箱（器）信息Service业务层处理
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
@Service
public class Rmft4406TransportequipmentServiceImpl implements IRmft4406TransportequipmentService 
{
    @Autowired
    private Rmft4406TransportequipmentMapper rmft4406TransportequipmentMapper;

    /**
     * 查询集装箱（器）信息
     * 
     * @param id 集装箱（器）信息ID
     * @return 集装箱（器）信息
     */
    @Override
    public Rmft4406Transportequipment selectRmft4406TransportequipmentById(Long id)
    {
        return rmft4406TransportequipmentMapper.selectRmft4406TransportequipmentById(id);
    }

    @Override
    public List<Rmft4406Transportequipment> selectRmft4406TransportequipmentByConsignmentId(Long consignmentId)
    {
        return rmft4406TransportequipmentMapper.selectRmft4406TransportequipmentByConsignmentId(consignmentId);
    }


    /**
     * 查询集装箱（器）信息列表
     * 
     * @param rmft4406Transportequipment 集装箱（器）信息
     * @return 集装箱（器）信息
     */
    @Override
    public List<Rmft4406Transportequipment> selectRmft4406TransportequipmentList(Rmft4406Transportequipment rmft4406Transportequipment)
    {
        return rmft4406TransportequipmentMapper.selectRmft4406TransportequipmentList(rmft4406Transportequipment);
    }

    /**
     * 新增集装箱（器）信息
     * 
     * @param rmft4406Transportequipment 集装箱（器）信息
     * @return 结果
     */
    @Override
    public int insertRmft4406Transportequipment(Rmft4406Transportequipment rmft4406Transportequipment)
    {
        return rmft4406TransportequipmentMapper.insertRmft4406Transportequipment(rmft4406Transportequipment);
    }

    /**
     * 修改集装箱（器）信息
     * 
     * @param rmft4406Transportequipment 集装箱（器）信息
     * @return 结果
     */
    @Override
    public int updateRmft4406Transportequipment(Rmft4406Transportequipment rmft4406Transportequipment)
    {
        return rmft4406TransportequipmentMapper.updateRmft4406Transportequipment(rmft4406Transportequipment);
    }

    /**
     * 批量删除集装箱（器）信息
     * 
     * @param ids 需要删除的集装箱（器）信息ID
     * @return 结果
     */
    @Override
    public int deleteRmft4406TransportequipmentByIds(Long[] ids)
    {
        return rmft4406TransportequipmentMapper.deleteRmft4406TransportequipmentByIds(ids);
    }

    /**
     * 删除集装箱（器）信息信息
     * 
     * @param id 集装箱（器）信息ID
     * @return 结果
     */
    @Override
    public int deleteRmft4406TransportequipmentById(Long id)
    {
        return rmft4406TransportequipmentMapper.deleteRmft4406TransportequipmentById(id);
    }
}
