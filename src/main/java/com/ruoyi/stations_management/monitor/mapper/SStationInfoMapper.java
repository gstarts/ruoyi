package com.ruoyi.stations_management.monitor.mapper;

import java.util.List;
import com.ruoyi.stations_management.monitor.domain.SStationInfo;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author qishuai
 * @date 2020-06-11
 */
public interface SStationInfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public SStationInfo selectSStationInfoById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sStationInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<SStationInfo> selectSStationInfoList(SStationInfo sStationInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sStationInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertSStationInfo(SStationInfo sStationInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sStationInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateSStationInfo(SStationInfo sStationInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteSStationInfoById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSStationInfoByIds(Long[] ids);
}
