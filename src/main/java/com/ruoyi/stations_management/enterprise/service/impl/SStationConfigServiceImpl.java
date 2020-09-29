package com.ruoyi.stations_management.enterprise.service.impl;

import java.util.List;

import com.ruoyi.stations_management.enterprise.domain.SStationConfig;
import com.ruoyi.stations_management.enterprise.mapper.SStationConfigMapper;
import com.ruoyi.stations_management.enterprise.service.ISStationConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 * 场站配置Service业务层处理
 * 
 * @author qishuai
 * @date 2020-04-30
 */
@Service
public class SStationConfigServiceImpl implements ISStationConfigService
{
    @Autowired
    private SStationConfigMapper sStationConfigMapper;

    /**
     * 查询场站配置信息(id)
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public SStationConfig selectSStationConfigById(Long id)
    {
        return sStationConfigMapper.selectSStationConfigById(id);
    }

    /**
     * 查询场站列表
     * 
     * @param sStationConfig 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SStationConfig> selectSStationConfigList(SStationConfig sStationConfig)
    {
        return sStationConfigMapper.selectSStationConfigList(sStationConfig);
    }

    /**
     * 新增场站配置
     * 
     * @param sStationConfig 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSStationConfig(SStationConfig sStationConfig)
    {
        return sStationConfigMapper.insertSStationConfig(sStationConfig);
    }

    /**
     * 修改场站配置
     * 
     * @param sStationConfig 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSStationConfig(SStationConfig sStationConfig)
    {
        return sStationConfigMapper.updateSStationConfig(sStationConfig);
    }

    /**
     * 批量删除
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSStationConfigByIds(Long[] ids)
    {
        return sStationConfigMapper.deleteSStationConfigByIds(ids);
    }

    /**
     * 删除场站配置
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSStationConfigById(Long id)
    {
        return sStationConfigMapper.deleteSStationConfigById(id);
    }
}
