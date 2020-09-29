package com.ruoyi.stations_management.report.service;

import java.util.List;
import com.ruoyi.stations_management.report.domain.Rmft4406Bordertransportequipment;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
public interface IRmft4406BordertransportequipmentService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Rmft4406Bordertransportequipment selectRmft4406BordertransportequipmentById(Long id);
    public List<Rmft4406Bordertransportequipment> selectRmft4406BordertransportequipmentByBordertransportmeansId(Long bordertransportmeansId);
    public List<Rmft4406Bordertransportequipment> selectRmft4406Bordertransportequipment();
    /**
     * 查询【请填写功能名称】列表
     * 
     * @param rmft4406Bordertransportequipment 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Rmft4406Bordertransportequipment> selectRmft4406BordertransportequipmentList(Rmft4406Bordertransportequipment rmft4406Bordertransportequipment);

    /**
     * 新增【请填写功能名称】
     * 
     * @param rmft4406Bordertransportequipment 【请填写功能名称】
     * @return 结果
     */
    public int insertRmft4406Bordertransportequipment(Rmft4406Bordertransportequipment rmft4406Bordertransportequipment);

    /**
     * 修改【请填写功能名称】
     * 
     * @param rmft4406Bordertransportequipment 【请填写功能名称】
     * @return 结果
     */
    public int updateRmft4406Bordertransportequipment(Rmft4406Bordertransportequipment rmft4406Bordertransportequipment);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRmft4406BordertransportequipmentByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRmft4406BordertransportequipmentById(Long id);
}
