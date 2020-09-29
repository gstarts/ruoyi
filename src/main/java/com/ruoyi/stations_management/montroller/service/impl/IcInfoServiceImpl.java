package com.ruoyi.stations_management.montroller.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.montroller.mapper.IcInfoMapper;
import com.ruoyi.stations_management.montroller.domain.IcInfo;
import com.ruoyi.stations_management.montroller.service.IIcInfoService;

/**
 * 车辆通关信息中ic卡信息Service业务层处理
 * 
 * @author songxiangyang
 * @date 2020-06-28
 */
@Service
public class IcInfoServiceImpl implements IIcInfoService 
{
    @Autowired
    private IcInfoMapper icInfoMapper;

    /**
     * 查询车辆通关信息中ic卡信息
     * 
     * @param id 车辆通关信息中ic卡信息ID
     * @return 车辆通关信息中ic卡信息
     */
    @Override
    public IcInfo selectIcInfoById(Long id)
    {
        return icInfoMapper.selectIcInfoById(id);
    }

    /**
     * 查询车辆通关信息中ic卡信息列表
     * 
     * @param icInfo 车辆通关信息中ic卡信息
     * @return 车辆通关信息中ic卡信息
     */
    @Override
    public List<IcInfo> selectIcInfoList(IcInfo icInfo)
    {
        return icInfoMapper.selectIcInfoList(icInfo);
    }

    /**
     * 新增车辆通关信息中ic卡信息
     * 
     * @param icInfo 车辆通关信息中ic卡信息
     * @return 结果
     */
    @Override
    public int insertIcInfo(IcInfo icInfo)
    {
        return icInfoMapper.insertIcInfo(icInfo);
    }

    /**
     * 修改车辆通关信息中ic卡信息
     * 
     * @param icInfo 车辆通关信息中ic卡信息
     * @return 结果
     */
    @Override
    public int updateIcInfo(IcInfo icInfo)
    {
        return icInfoMapper.updateIcInfo(icInfo);
    }

    /**
     * 批量删除车辆通关信息中ic卡信息
     * 
     * @param ids 需要删除的车辆通关信息中ic卡信息ID
     * @return 结果
     */
    @Override
    public int deleteIcInfoByIds(Long[] ids)
    {
        return icInfoMapper.deleteIcInfoByIds(ids);
    }

    /**
     * 删除车辆通关信息中ic卡信息信息
     * 
     * @param id 车辆通关信息中ic卡信息ID
     * @return 结果
     */
    @Override
    public int deleteIcInfoById(Long id)
    {
        return icInfoMapper.deleteIcInfoById(id);
    }
}
