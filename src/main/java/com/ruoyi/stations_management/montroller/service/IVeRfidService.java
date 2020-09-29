package com.ruoyi.stations_management.montroller.service;

import java.util.List;
import com.ruoyi.stations_management.montroller.domain.VeRfid;

/**
 * 车辆通关时电子车牌信息Service接口
 * 
 * @author songxiangyang
 * @date 2020-06-28
 */
public interface IVeRfidService 
{
    /**
     * 查询车辆通关时电子车牌信息
     * 
     * @param id 车辆通关时电子车牌信息ID
     * @return 车辆通关时电子车牌信息
     */
    public VeRfid selectVeRfidById(Long id);

    /**
     * 查询车辆通关时电子车牌信息列表
     * 
     * @param veRfid 车辆通关时电子车牌信息
     * @return 车辆通关时电子车牌信息集合
     */
    public List<VeRfid> selectVeRfidList(VeRfid veRfid);

    /**
     * 新增车辆通关时电子车牌信息
     * 
     * @param veRfid 车辆通关时电子车牌信息
     * @return 结果
     */
    public int insertVeRfid(VeRfid veRfid);

    /**
     * 修改车辆通关时电子车牌信息
     * 
     * @param veRfid 车辆通关时电子车牌信息
     * @return 结果
     */
    public int updateVeRfid(VeRfid veRfid);

    /**
     * 批量删除车辆通关时电子车牌信息
     * 
     * @param ids 需要删除的车辆通关时电子车牌信息ID
     * @return 结果
     */
    public int deleteVeRfidByIds(Long[] ids);

    /**
     * 删除车辆通关时电子车牌信息信息
     * 
     * @param id 车辆通关时电子车牌信息ID
     * @return 结果
     */
    public int deleteVeRfidById(Long id);
}
