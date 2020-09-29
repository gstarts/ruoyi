package com.ruoyi.stations_management.report.mapper;

import java.util.List;
import com.ruoyi.stations_management.report.domain.Rmft4406Consignment;

/**
 * 提（运）单数据Mapper接口
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
public interface Rmft4406ConsignmentMapper 
{
    /**
     * 查询提（运）单数据
     * 
     * @param id 提（运）单数据ID
     * @return 提（运）单数据
     */
    public Rmft4406Consignment selectRmft4406ConsignmentById(Long id);

    /**
     * 查询提（运）单数据列表
     * 
     * @param rmft4406Consignment 提（运）单数据
     * @return 提（运）单数据集合
     */
    public List<Rmft4406Consignment> selectRmft4406ConsignmentList(Rmft4406Consignment rmft4406Consignment);

    /**
     * 新增提（运）单数据
     * 
     * @param rmft4406Consignment 提（运）单数据
     * @return 结果
     */
    public int insertRmft4406Consignment(Rmft4406Consignment rmft4406Consignment);

    /**
     * 修改提（运）单数据
     * 
     * @param rmft4406Consignment 提（运）单数据
     * @return 结果
     */
    public int updateRmft4406Consignment(Rmft4406Consignment rmft4406Consignment);

    /**
     * 删除提（运）单数据
     * 
     * @param id 提（运）单数据ID
     * @return 结果
     */
    public int deleteRmft4406ConsignmentById(Long id);

    /**
     * 批量删除提（运）单数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRmft4406ConsignmentByIds(Long[] ids);
}
