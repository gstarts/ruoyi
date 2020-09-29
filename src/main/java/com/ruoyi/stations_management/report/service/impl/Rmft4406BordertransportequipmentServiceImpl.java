package com.ruoyi.stations_management.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.report.mapper.Rmft4406BordertransportequipmentMapper;
import com.ruoyi.stations_management.report.domain.Rmft4406Bordertransportequipment;
import com.ruoyi.stations_management.report.service.IRmft4406BordertransportequipmentService;

/**
 * Service业务层处理
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
@Service
public class Rmft4406BordertransportequipmentServiceImpl implements IRmft4406BordertransportequipmentService 
{
    @Autowired
    private Rmft4406BordertransportequipmentMapper rmft4406BordertransportequipmentMapper;

    /**
     * 查询
     * 
     * @param id ID
     * @return
     */
    @Override
    public Rmft4406Bordertransportequipment selectRmft4406BordertransportequipmentById(Long id)
    {
        return rmft4406BordertransportequipmentMapper.selectRmft4406BordertransportequipmentById(id);
    }

    @Override
    public List<Rmft4406Bordertransportequipment> selectRmft4406BordertransportequipmentByBordertransportmeansId(Long bordertransportmeansId)
    {
        return rmft4406BordertransportequipmentMapper.selectRmft4406BordertransportequipmentByBordertransportmeansId(bordertransportmeansId);
    }


    @Override
    public List<Rmft4406Bordertransportequipment> selectRmft4406Bordertransportequipment()
    {
        return rmft4406BordertransportequipmentMapper.selectRmft4406Bordertransportequipment();
    }


    /**
     * 查询
     * 
     * @param rmft4406Bordertransportequipment
     * @return
     */
    @Override
    public List<Rmft4406Bordertransportequipment> selectRmft4406BordertransportequipmentList(Rmft4406Bordertransportequipment rmft4406Bordertransportequipment)
    {
        return rmft4406BordertransportequipmentMapper.selectRmft4406BordertransportequipmentList(rmft4406Bordertransportequipment);
    }

    /**
     * 新增
     * 
     * @param rmft4406Bordertransportequipment
     * @return 结果
     */
    @Override
    public int insertRmft4406Bordertransportequipment(Rmft4406Bordertransportequipment rmft4406Bordertransportequipment)
    {
        return rmft4406BordertransportequipmentMapper.insertRmft4406Bordertransportequipment(rmft4406Bordertransportequipment);
    }

    /**
     * 修改
     * 
     * @param rmft4406Bordertransportequipment
     * @return 结果
     */
    @Override
    public int updateRmft4406Bordertransportequipment(Rmft4406Bordertransportequipment rmft4406Bordertransportequipment)
    {
        return rmft4406BordertransportequipmentMapper.updateRmft4406Bordertransportequipment(rmft4406Bordertransportequipment);
    }

    /**
     * 批量删除
     * 
     * @param ids 需要删除的ID
     * @return 结果
     */
    @Override
    public int deleteRmft4406BordertransportequipmentByIds(Long[] ids)
    {
        return rmft4406BordertransportequipmentMapper.deleteRmft4406BordertransportequipmentByIds(ids);
    }

    /**
     * 删除信息
     * 
     * @param id ID
     * @return 结果
     */
    @Override
    public int deleteRmft4406BordertransportequipmentById(Long id)
    {
        return rmft4406BordertransportequipmentMapper.deleteRmft4406BordertransportequipmentById(id);
    }
}
