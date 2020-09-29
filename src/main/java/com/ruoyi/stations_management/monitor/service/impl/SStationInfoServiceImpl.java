package com.ruoyi.stations_management.monitor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.monitor.mapper.SStationInfoMapper;
import com.ruoyi.stations_management.monitor.domain.SStationInfo;
import com.ruoyi.stations_management.monitor.service.ISStationInfoService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author qishuai
 * @date 2020-06-11
 */
@Service
public class SStationInfoServiceImpl implements ISStationInfoService 
{
    @Autowired
    private SStationInfoMapper sStationInfoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public SStationInfo selectSStationInfoById(Long id)
    {
        return sStationInfoMapper.selectSStationInfoById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sStationInfo 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SStationInfo> selectSStationInfoList(SStationInfo sStationInfo)
    {
        return sStationInfoMapper.selectSStationInfoList(sStationInfo);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sStationInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSStationInfo(SStationInfo sStationInfo)
    {
        return sStationInfoMapper.insertSStationInfo(sStationInfo);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sStationInfo 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSStationInfo(SStationInfo sStationInfo)
    {
        return sStationInfoMapper.updateSStationInfo(sStationInfo);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSStationInfoByIds(Long[] ids)
    {
        return sStationInfoMapper.deleteSStationInfoByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSStationInfoById(Long id)
    {
        return sStationInfoMapper.deleteSStationInfoById(id);
    }
}
