package com.ruoyi.stations_management.depot.service;

import com.ruoyi.stations_management.depot.domain.SWarehouseContract;
import java.util.List;

/**
 * 仓库合同Service接口
 * 
 * @author qishuai
 * @date 2020-01-04
 */
public interface ISWarehouseContractService 
{
    /**
     * 查询仓库合同
     * 
     * @param id 仓库合同ID
     * @return 仓库合同
     */
    public SWarehouseContract selectSWarehouseContractById(Long id);

    /**
     * 查询仓库合同列表
     * 
     * @param sWarehouseContract 仓库合同
     * @return 仓库合同集合
     */
    public List<SWarehouseContract> selectSWarehouseContractList(SWarehouseContract sWarehouseContract);

    /**
     * 新增仓库合同
     * 
     * @param sWarehouseContract 仓库合同
     * @return 结果
     */
    public int insertSWarehouseContract(SWarehouseContract sWarehouseContract);

    /**
     * 修改仓库合同
     * 
     * @param sWarehouseContract 仓库合同
     * @return 结果
     */
    public int updateSWarehouseContract(SWarehouseContract sWarehouseContract);

    /**
     * 批量删除仓库合同
     * 
     * @param ids 需要删除的仓库合同ID
     * @return 结果
     */
    public int deleteSWarehouseContractByIds(Long[] ids);

    /**
     * 删除仓库合同信息
     * 
     * @param id 仓库合同ID
     * @return 结果
     */
    public int deleteSWarehouseContractById(Long id);
}
