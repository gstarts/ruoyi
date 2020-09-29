package com.ruoyi.stations_management.mt.service;

import java.util.List;
import com.ruoyi.stations_management.mt.domain.Consignment;

/**
 * 提（运）单数据Service接口
 * 
 * @author songqingchuan
 * @date 2020-07-27
 */
public interface IConsignmentService
{
    /**
     * 查询提（运）单数据
     * 
     * @param id 提（运）单数据ID
     * @return 提（运）单数据
     */
     Consignment selectConsignmentById(Long id);

    /**
     * 查询提（运）单数据列表
     * 
     * @param consignment 提（运）单数据
     * @return 提（运）单数据集合
     */
     List<Consignment> selectConsignmentList(Consignment consignment);

    /**
     * 新增提（运）单数据
     * 
     * @param consignment 提（运）单数据
     * @return 结果
     */
     int insertConsignment(Consignment consignment);

    /**
     * 修改提（运）单数据
     * 
     * @param consignment 提（运）单数据
     * @return 结果
     */
     int updateConsignment(Consignment consignment);

    /**
     * 批量删除提（运）单数据
     * 
     * @param ids 需要删除的提（运）单数据ID
     * @return 结果
     */
     int deleteConsignmentByIds(Long[] ids);

}
