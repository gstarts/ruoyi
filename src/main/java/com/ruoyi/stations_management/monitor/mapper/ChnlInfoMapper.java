package com.ruoyi.stations_management.monitor.mapper;

import com.ruoyi.project.system.domain.SysDictData;
import com.ruoyi.stations_management.monitor.domain.ChnlInfo;
import java.util.List;

/**
 * 通道配置Mapper接口
 *
 * @author qishuai
 * @date 2020-03-24
 */
public interface ChnlInfoMapper
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
     * 删除通道配置
     *
     * @param id 通道配置ID
     * @return 结果
     */
    public int deleteChnlInfoById(Long id);

    /**
     * 批量删除通道配置
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteChnlInfoByIds(Long[] ids);

    /**
     * 获取通道列表
     * @return 结果
     */
    public  List<ChnlInfo>chnlList();

    List<SysDictData>getChnlOptions();

    public ChnlInfo getCChnlType(String chnlInfo);
}
