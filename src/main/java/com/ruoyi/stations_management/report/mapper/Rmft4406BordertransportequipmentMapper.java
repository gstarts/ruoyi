package com.ruoyi.stations_management.report.mapper;

import java.util.List;

import com.ruoyi.stations_management.report.domain.Rmft4406Bordertransportequipment;

/**
 * Mapper接口
 *
 * @author songxiangyang
 * @date 2020-07-27
 */
public interface Rmft4406BordertransportequipmentMapper {
    /**
     * 查询
     *
     * @param id ID
     * @return
     */
    public Rmft4406Bordertransportequipment selectRmft4406BordertransportequipmentById(Long id);


    public List<Rmft4406Bordertransportequipment> selectRmft4406BordertransportequipmentByBordertransportmeansId(Long bordertransportmeansId);

    public List<Rmft4406Bordertransportequipment> selectRmft4406Bordertransportequipment();

    /**
     * 查询列表
     *
     * @param rmft4406Bordertransportequipment
     * @return 集合
     */
    public List<Rmft4406Bordertransportequipment> selectRmft4406BordertransportequipmentList(Rmft4406Bordertransportequipment rmft4406Bordertransportequipment);

    /**
     * 新增
     *
     * @param rmft4406Bordertransportequipment
     * @return 结果
     */
    public int insertRmft4406Bordertransportequipment(Rmft4406Bordertransportequipment rmft4406Bordertransportequipment);

    /**
     * 修改
     *
     * @param rmft4406Bordertransportequipment
     * @return 结果
     */
    public int updateRmft4406Bordertransportequipment(Rmft4406Bordertransportequipment rmft4406Bordertransportequipment);

    /**
     * 删除
     *
     * @param id ID
     * @return 结果
     */
    public int deleteRmft4406BordertransportequipmentById(Long id);

    /**
     * 批量删除
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRmft4406BordertransportequipmentByIds(Long[] ids);
}
