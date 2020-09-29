package com.ruoyi.stations_management.common.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.common.mapper.StationInfoMapper;
import com.ruoyi.stations_management.common.domain.StationInfo;
import com.ruoyi.stations_management.common.service.IStationInfoService;

/**
 * 场站的基本信息Service业务层处理
 *
 * @author qishuai
 * @date 2020-03-27
 */
@Service
public class StationInfoServiceImpl implements IStationInfoService
{
    @Autowired
    private StationInfoMapper stationInfoMapper;

    /**
     * 查询场站的基本信息
     *
     * @param id 场站的基本信息ID
     * @return 场站的基本信息
     */
    @Override
    public StationInfo selectStationInfoById(Long id)
    {
        return stationInfoMapper.selectStationInfoById(id);
    }

    /**
     * 查询场站的基本信息列表
     *
     * @param stationInfo 场站的基本信息
     * @return 场站的基本信息
     */
    @Override
    public List<StationInfo> selectStationInfoList(StationInfo stationInfo)
    {
        return stationInfoMapper.selectStationInfoList(stationInfo);
    }

    @Override
    public List<StationInfo> selectStationList() {
        return stationInfoMapper.selectStationList();
    }

    @Override
    public  StationInfo selectStation() {
        return stationInfoMapper.selectStation();
    }


    /**
     * 新增场站的基本信息
     *
     * @param stationInfo 场站的基本信息
     * @return 结果
     */
    @Override
    public int insertStationInfo(StationInfo stationInfo)
    {
        return stationInfoMapper.insertStationInfo(stationInfo);
    }

    /**
     * 修改场站的基本信息
     *
     * @param stationInfo 场站的基本信息
     * @return 结果
     */
    @Override
    public int updateStationInfo(StationInfo stationInfo)
    {
        return stationInfoMapper.updateStationInfo(stationInfo);
    }

    /**
     * 批量删除场站的基本信息
     *
     * @param ids 需要删除的场站的基本信息ID
     * @return 结果
     */
    @Override
    public int deleteStationInfoByIds(Long[] ids)
    {
        return stationInfoMapper.deleteStationInfoByIds(ids);
    }

    /**
     * 删除场站的基本信息信息
     *
     * @param id 场站的基本信息ID
     * @return 结果
     */
    @Override
    public int deleteStationInfoById(Long id)
    {
        return stationInfoMapper.deleteStationInfoById(id);
    }
}
