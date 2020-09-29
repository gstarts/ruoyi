package com.ruoyi.stations_management.mt.mapper;

import java.util.List;

import com.ruoyi.stations_management.mt.domain.BorderTransportMeans;

/**
 * 驾驶员信息Mapper接口
 * 
 * @author songqingchuan
 * @date 2020-07-27
 */
public interface IBorderTransportMeansMapper
{
    /**
     * 查询驾驶员信息
     * 
     * @param id 驾驶员信息ID
     * @return 驾驶员信息
     */
     BorderTransportMeans selectBorderTransportMeansById(Long id);

    /**
     * 查询驾驶员信息列表
     * 
     * @param borderTransportMeans 驾驶员信息
     * @return 驾驶员信息集合
     */
     List<BorderTransportMeans> selectBorderTransportMeansList(BorderTransportMeans borderTransportMeans);

    /**
     * 新增驾驶员信息
     * 
     * @param borderTransportMeans 驾驶员信息
     * @return 结果
     */
     int insertBorderTransportMeans(BorderTransportMeans borderTransportMeans);

    /**
     * 修改驾驶员信息
     * 
     * @param borderTransportMeans 驾驶员信息
     * @return 结果
     */
     int updateBorderTransportMeans(BorderTransportMeans borderTransportMeans);

    /**
     * 删除驾驶员信息
     * 
     * @param id 驾驶员信息ID
     * @return 结果
     */
     int deleteBorderTransportMeansById(Long id);

    /**
     * 批量删除驾驶员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteBorderTransportMeansByIds(Long[] ids);
}
