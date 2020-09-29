package com.ruoyi.stations_management.enterprise.service;

import java.util.List;

import com.ruoyi.stations_management.enterprise.domain.SStationConfig;


/**
 * 场站配置Service接口
 * 
 * @author qishuai
 * @date 2020-04-30
 */
public interface ISStationConfigService 
{
    /**
     * 查询场站配置信息(id)
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public SStationConfig selectSStationConfigById(Long id);

    /**
     * 查询场站列表
     * 
     * @param sStationConfig 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SStationConfig> selectSStationConfigList(SStationConfig sStationConfig);

    /**
     * 新增场站配置
     * 
     * @param sStationConfig 【请填写功能名称】
     * @return 结果
     */
    public int insertSStationConfig(SStationConfig sStationConfig);

    /**
     * 修改场站配置
     * 
     * @param sStationConfig 【请填写功能名称】
     * @return 结果
     */
    public int updateSStationConfig(SStationConfig sStationConfig);

    /**
     * 批量删除
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSStationConfigByIds(Long[] ids);

    /**
     * 删除场站配置
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSStationConfigById(Long id);
}
