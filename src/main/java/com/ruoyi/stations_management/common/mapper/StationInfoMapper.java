package com.ruoyi.stations_management.common.mapper;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.ruoyi.stations_management.common.domain.StationInfo;
import java.util.List;

/**
 * 场站的基本信息Mapper接口
 *
 * @author qishuai
 * @date 2020-03-27
 */
public interface StationInfoMapper
{
    /**
     * 查询场站的基本信息
     *
     * @param id 场站的基本信息ID
     * @return 场站的基本信息
     */
    public StationInfo selectStationInfoById(Long id);

    /**
     * 查询场站信息
     * @param init
     * @return
     */
    public StationInfo init();

    /**
     * 查询场站的基本信息列表
     *
     * @param stationInfo 场站的基本信息
     * @return 场站的基本信息集合
     */
    public List<StationInfo> selectStationInfoList(StationInfo stationInfo);


    public List<StationInfo> selectStationList();

    public StationInfo selectStation();
    /**
     * 新增场站的基本信息
     *
     * @param stationInfo 场站的基本信息
     * @return 结果
     */
    public int insertStationInfo(StationInfo stationInfo);

    /**
     * 修改场站的基本信息
     *
     * @param stationInfo 场站的基本信息
     * @return 结果
     */
    public int updateStationInfo(StationInfo stationInfo);

    /**
     * 删除场站的基本信息
     *
     * @param id 场站的基本信息ID
     * @return 结果
     */
    public int deleteStationInfoById(Long id);

    /**
     * 批量删除场站的基本信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStationInfoByIds(Long[] ids);
}
