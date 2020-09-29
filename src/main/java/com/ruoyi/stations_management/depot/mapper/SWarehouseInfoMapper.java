package com.ruoyi.stations_management.depot.mapper;

import com.ruoyi.stations_management.depot.domain.SWarehouseInfo;
import java.util.List;
import java.util.Map;

/**
 * 仓库管理Mapper接口
 *
 * @author qishuai
 * @date 2020-01-01
 */
public interface SWarehouseInfoMapper
{
    /**
     * 查询仓库管理
     *
     * @param id 仓库管理ID
     * @return 仓库管理
     */
    public SWarehouseInfo selectSWarehouseInfoById(Long id);

    /**
     * 查询仓库管理列表
     *
     * @param sWarehouseInfo 仓库管理
     * @return 仓库管理集合
     */
    public List<SWarehouseInfo> selectSWarehouseInfoList(SWarehouseInfo sWarehouseInfo);

    /**
     * 新增仓库管理
     *
     * @param sWarehouseInfo 仓库管理
     * @return 结果
     */
    public int insertSWarehouseInfo(SWarehouseInfo sWarehouseInfo);

    /**
     * 修改仓库管理
     *
     * @param sWarehouseInfo 仓库管理
     * @return 结果
     */
    public int updateSWarehouseInfo(SWarehouseInfo sWarehouseInfo);

    /**
     * 删除仓库管理
     *
     * @param id 仓库管理ID
     * @return 结果
     */
    public int deleteSWarehouseInfoById(Long id);

    /**
     * 批量删除仓库管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSWarehouseInfoByIds(Long[] ids);

    public List<Map<String, String>> selectDeoptNameList();
}
