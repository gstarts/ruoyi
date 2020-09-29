package com.ruoyi.stations_management.depot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.depot.mapper.SWarehouseContractMapper;
import com.ruoyi.stations_management.depot.domain.SWarehouseContract;
import com.ruoyi.stations_management.depot.service.ISWarehouseContractService;

/**
 * 仓库合同Service业务层处理
 * 
 * @author qishuai
 * @date 2020-01-04
 */
@Service
public class SWarehouseContractServiceImpl implements ISWarehouseContractService 
{
    @Autowired
    private SWarehouseContractMapper sWarehouseContractMapper;

    /**
     * 查询仓库合同
     * 
     * @param id 仓库合同ID
     * @return 仓库合同
     */
    @Override
    public SWarehouseContract selectSWarehouseContractById(Long id)
    {
        return sWarehouseContractMapper.selectSWarehouseContractById(id);
    }

    /**
     * 查询仓库合同列表
     * 
     * @param sWarehouseContract 仓库合同
     * @return 仓库合同
     */
    @Override
    public List<SWarehouseContract> selectSWarehouseContractList(SWarehouseContract sWarehouseContract)
    {
        return sWarehouseContractMapper.selectSWarehouseContractList(sWarehouseContract);
    }

    /**
     * 新增仓库合同
     * 
     * @param sWarehouseContract 仓库合同
     * @return 结果
     */
    @Override
    public int insertSWarehouseContract(SWarehouseContract sWarehouseContract)
    {
        return sWarehouseContractMapper.insertSWarehouseContract(sWarehouseContract);
    }

    /**
     * 修改仓库合同
     * 
     * @param sWarehouseContract 仓库合同
     * @return 结果
     */
    @Override
    public int updateSWarehouseContract(SWarehouseContract sWarehouseContract)
    {
        return sWarehouseContractMapper.updateSWarehouseContract(sWarehouseContract);
    }

    /**
     * 批量删除仓库合同
     * 
     * @param ids 需要删除的仓库合同ID
     * @return 结果
     */
    @Override
    public int deleteSWarehouseContractByIds(Long[] ids)
    {
        return sWarehouseContractMapper.deleteSWarehouseContractByIds(ids);
    }

    /**
     * 删除仓库合同信息
     * 
     * @param id 仓库合同ID
     * @return 结果
     */
    @Override
    public int deleteSWarehouseContractById(Long id)
    {
        return sWarehouseContractMapper.deleteSWarehouseContractById(id);
    }
}
