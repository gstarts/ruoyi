package com.ruoyi.stations_management.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.report.mapper.Rmft4406ConsignmentMapper;
import com.ruoyi.stations_management.report.domain.Rmft4406Consignment;
import com.ruoyi.stations_management.report.service.IRmft4406ConsignmentService;

/**
 * 提（运）单数据Service业务层处理
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
@Service
public class Rmft4406ConsignmentServiceImpl implements IRmft4406ConsignmentService 
{
    @Autowired
    private Rmft4406ConsignmentMapper rmft4406ConsignmentMapper;

    /**
     * 查询提（运）单数据
     * 
     * @param id 提（运）单数据ID
     * @return 提（运）单数据
     */
    @Override
    public Rmft4406Consignment selectRmft4406ConsignmentById(Long id)
    {
        return rmft4406ConsignmentMapper.selectRmft4406ConsignmentById(id);
    }

    /**
     * 查询提（运）单数据列表
     * 
     * @param rmft4406Consignment 提（运）单数据
     * @return 提（运）单数据
     */
    @Override
    public List<Rmft4406Consignment> selectRmft4406ConsignmentList(Rmft4406Consignment rmft4406Consignment)
    {
        return rmft4406ConsignmentMapper.selectRmft4406ConsignmentList(rmft4406Consignment);
    }

    /**
     * 新增提（运）单数据
     * 
     * @param rmft4406Consignment 提（运）单数据
     * @return 结果
     */
    @Override
    public int insertRmft4406Consignment(Rmft4406Consignment rmft4406Consignment)
    {
        return rmft4406ConsignmentMapper.insertRmft4406Consignment(rmft4406Consignment);
    }

    /**
     * 修改提（运）单数据
     * 
     * @param rmft4406Consignment 提（运）单数据
     * @return 结果
     */
    @Override
    public int updateRmft4406Consignment(Rmft4406Consignment rmft4406Consignment)
    {
        return rmft4406ConsignmentMapper.updateRmft4406Consignment(rmft4406Consignment);
    }

    /**
     * 批量删除提（运）单数据
     * 
     * @param ids 需要删除的提（运）单数据ID
     * @return 结果
     */
    @Override
    public int deleteRmft4406ConsignmentByIds(Long[] ids)
    {
        return rmft4406ConsignmentMapper.deleteRmft4406ConsignmentByIds(ids);
    }

    /**
     * 删除提（运）单数据信息
     * 
     * @param id 提（运）单数据ID
     * @return 结果
     */
    @Override
    public int deleteRmft4406ConsignmentById(Long id)
    {
        return rmft4406ConsignmentMapper.deleteRmft4406ConsignmentById(id);
    }
}
