package com.ruoyi.stations_management.mt.service.impl;

import com.ruoyi.stations_management.mt.domain.Consignment;
import com.ruoyi.stations_management.mt.mapper.IConsignmentMapper;
import com.ruoyi.stations_management.mt.service.IConsignmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 提（运）单数据Service业务层处理
 * 
 * @author songqingchuan
 * @date 2020-07-27
 */
@Service
public class ConsignmentServiceImpl implements IConsignmentService
{
    @Resource
    private IConsignmentMapper iConsignmentMapper;

    /**
     * 查询提（运）单数据
     * 
     * @param id 提（运）单数据ID
     * @return 提（运）单数据
     */
    @Override
    public Consignment selectConsignmentById(Long id)
    {
        return iConsignmentMapper.selectConsignmentById(id);
    }

    /**
     * 查询提（运）单数据列表
     * 
     * @param consignment 提（运）单数据
     * @return 提（运）单数据
     */
    @Override
    public List<Consignment> selectConsignmentList(Consignment consignment)
    {
        return iConsignmentMapper.selectConsignmentList(consignment);
    }

    /**
     * 新增提（运）单数据
     * 
     * @param consignment 提（运）单数据
     * @return 结果
     */
    @Override
    public int insertConsignment(Consignment consignment)
    {
        return iConsignmentMapper.insertConsignment(consignment);
    }

    /**
     * 修改提（运）单数据
     * 
     * @param consignment 提（运）单数据
     * @return 结果
     */
    @Override
    public int updateConsignment(Consignment consignment)
    {
        return iConsignmentMapper.updateConsignment(consignment);
    }

    /**
     * 批量删除提（运）单数据
     * 
     * @param ids 需要删除的提（运）单数据ID
     * @return 结果
     */
    @Override
    public int deleteConsignmentByIds(Long[] ids)
    {
        return iConsignmentMapper.deleteConsignmentByIds(ids);
    }

}
