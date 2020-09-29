package com.ruoyi.stations_management.monitor.service;

import com.ruoyi.framework.web.domain.TreeSelect;
import com.ruoyi.project.system.domain.SysDictData;
import com.ruoyi.stations_management.monitor.domain.ChnlInfo;
import com.ruoyi.stations_management.common.domain.StationInfo;

import java.util.List;

/**
 * 通道配置Service接口
 *
 * @author qishuai
 * @date 2020-03-24
 */
public interface IChnlInfoService
{
    /**
     * 查询通道配置
     *
     * @param id 通道配置ID
     * @return 通道配置
     */
    public ChnlInfo selectChnlInfoById(Long id);

    /**
     * 查询通道配置列表
     *
     * @param chnlInfo 通道配置
     * @return 通道配置集合
     */
    public List<ChnlInfo> selectChnlInfoList(ChnlInfo chnlInfo);


    /**
     * 新增通道配置
     *
     * @param chnlInfo 通道配置
     * @return 结果
     */
    public int insertChnlInfo(ChnlInfo chnlInfo);

    /**
     * 修改通道配置
     *
     * @param chnlInfo 通道配置
     * @return 结果
     */
    public int updateChnlInfo(ChnlInfo chnlInfo);

    /**
     * 批量删除通道配置
     *
     * @param ids 需要删除的通道配置ID
     * @return 结果
     */
    public int deleteChnlInfoByIds(Long[] ids);

    /**
     * 删除通道配置信息
     *
     * @param id 通道配置ID
     * @return 结果
     */
    public int deleteChnlInfoById(Long id);
    /**
     * 构建前端所需要下拉树结构
     *
     * @param chnl 通道列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildChnlTreeSelect(List<ChnlInfo> chnl);

    public List<TreeSelect> buildStationTree(List<StationInfo> list);
    /**
     * 构建前端所需要树结构
     *
     * @param chnl 通道列表
     * @return 树结构列表
     */
    public List<ChnlInfo> buildChnlTree(List<ChnlInfo> chnl);

    /**
     *获取该场站下的通道
     */
    public List<SysDictData> getChnlOptions();

    public ChnlInfo getCChnlType(String chnlInfo);

}
