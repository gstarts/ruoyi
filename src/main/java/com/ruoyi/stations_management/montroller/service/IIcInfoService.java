package com.ruoyi.stations_management.montroller.service;

import java.util.List;
import com.ruoyi.stations_management.montroller.domain.IcInfo;

/**
 * 车辆通关信息中ic卡信息Service接口
 * 
 * @author songxiangyang
 * @date 2020-06-28
 */
public interface IIcInfoService 
{
    /**
     * 查询车辆通关信息中ic卡信息
     * 
     * @param id 车辆通关信息中ic卡信息ID
     * @return 车辆通关信息中ic卡信息
     */
    public IcInfo selectIcInfoById(Long id);

    /**
     * 查询车辆通关信息中ic卡信息列表
     * 
     * @param icInfo 车辆通关信息中ic卡信息
     * @return 车辆通关信息中ic卡信息集合
     */
    public List<IcInfo> selectIcInfoList(IcInfo icInfo);

    /**
     * 新增车辆通关信息中ic卡信息
     * 
     * @param icInfo 车辆通关信息中ic卡信息
     * @return 结果
     */
    public int insertIcInfo(IcInfo icInfo);

    /**
     * 修改车辆通关信息中ic卡信息
     * 
     * @param icInfo 车辆通关信息中ic卡信息
     * @return 结果
     */
    public int updateIcInfo(IcInfo icInfo);

    /**
     * 批量删除车辆通关信息中ic卡信息
     * 
     * @param ids 需要删除的车辆通关信息中ic卡信息ID
     * @return 结果
     */
    public int deleteIcInfoByIds(Long[] ids);

    /**
     * 删除车辆通关信息中ic卡信息信息
     * 
     * @param id 车辆通关信息中ic卡信息ID
     * @return 结果
     */
    public int deleteIcInfoById(Long id);
}
