package com.ruoyi.stations_management.mt.service.impl;

import com.ruoyi.stations_management.mt.domain.BorderTransportMeans;
import com.ruoyi.stations_management.mt.mapper.IBorderTransportMeansMapper;
import com.ruoyi.stations_management.mt.service.IBorderTransportMeansService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 驾驶员信息Service业务层处理
 * 
 * @author songqingchuan
 * @date 2020-07-27
 */
@Service
public class BorderTransportMeansServiceImpl implements IBorderTransportMeansService
{
    @Resource
    private IBorderTransportMeansMapper iBorderTransportMeansMapper;

    /**
     * 查询驾驶员信息
     * 
     * @param id 驾驶员信息ID
     * @return 驾驶员信息
     */
    @Override
    public BorderTransportMeans selectBorderTransportMeansById(Long id)
    {
        return iBorderTransportMeansMapper.selectBorderTransportMeansById(id);
    }

    /**
     * 查询驾驶员信息列表
     * 
     * @param borderTransportMeans 驾驶员信息
     * @return 驾驶员信息
     */
    @Override
    public List<BorderTransportMeans> selectBorderTransportMeansList(BorderTransportMeans borderTransportMeans)
    {
        return iBorderTransportMeansMapper.selectBorderTransportMeansList(borderTransportMeans);
    }

    /**
     * 新增驾驶员信息
     * 
     * @param borderTransportMeans 驾驶员信息
     * @return 结果
     */
    @Override
    public int insertBorderTransportMeans(BorderTransportMeans borderTransportMeans)
    {
        return iBorderTransportMeansMapper.insertBorderTransportMeans(borderTransportMeans);
    }

    /**
     * 修改驾驶员信息
     * 
     * @param borderTransportMeans 驾驶员信息
     * @return 结果
     */
    @Override
    public int updateBorderTransportMeans(BorderTransportMeans borderTransportMeans)
    {
        return iBorderTransportMeansMapper.updateBorderTransportMeans(borderTransportMeans);
    }

    /**
     * 批量删除驾驶员信息
     * 
     * @param ids 需要删除的驾驶员信息ID
     * @return 结果
     */
    @Override
    public int deleteBorderTransportMeansByIds(Long[] ids)
    {
        return iBorderTransportMeansMapper.deleteBorderTransportMeansByIds(ids);
    }

}
