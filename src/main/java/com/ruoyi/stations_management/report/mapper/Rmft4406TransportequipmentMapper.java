package com.ruoyi.stations_management.report.mapper;

import java.util.List;
import com.ruoyi.stations_management.report.domain.Rmft4406Transportequipment;

/**
 * 集装箱（器）信息Mapper接口
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
public interface Rmft4406TransportequipmentMapper 
{
    /**
     * 查询集装箱（器）信息
     * 
     * @param id 集装箱（器）信息ID
     * @return 集装箱（器）信息
     */
    public Rmft4406Transportequipment selectRmft4406TransportequipmentById(Long id);

    public List<Rmft4406Transportequipment> selectRmft4406TransportequipmentByConsignmentId(Long consignmentId);
    /**
     * 查询集装箱（器）信息列表
     * 
     * @param rmft4406Transportequipment 集装箱（器）信息
     * @return 集装箱（器）信息集合
     */
    public List<Rmft4406Transportequipment> selectRmft4406TransportequipmentList(Rmft4406Transportequipment rmft4406Transportequipment);

    /**
     * 新增集装箱（器）信息
     * 
     * @param rmft4406Transportequipment 集装箱（器）信息
     * @return 结果
     */
    public int insertRmft4406Transportequipment(Rmft4406Transportequipment rmft4406Transportequipment);

    /**
     * 修改集装箱（器）信息
     * 
     * @param rmft4406Transportequipment 集装箱（器）信息
     * @return 结果
     */
    public int updateRmft4406Transportequipment(Rmft4406Transportequipment rmft4406Transportequipment);

    /**
     * 删除集装箱（器）信息
     * 
     * @param id 集装箱（器）信息ID
     * @return 结果
     */
    public int deleteRmft4406TransportequipmentById(Long id);

    /**
     * 批量删除集装箱（器）信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRmft4406TransportequipmentByIds(Long[] ids);
}
