package com.ruoyi.stations_management.depot.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.depot.mapper.SWarehouseInfoMapper;
import com.ruoyi.stations_management.depot.domain.SWarehouseInfo;
import com.ruoyi.stations_management.depot.service.ISWarehouseInfoService;

/**
 * 仓库管理Service业务层处理
 *
 * @author qishuai
 * @date 2020-01-01
 */
@Service
public class SWarehouseInfoServiceImpl implements ISWarehouseInfoService
{
    @Autowired
    private SWarehouseInfoMapper sWarehouseInfoMapper;

    /**
     * 查询仓库管理
     *
     * @param id 仓库管理ID
     * @return 仓库管理
     */
    @Override
    public SWarehouseInfo selectSWarehouseInfoById(Long id)
    {
        return sWarehouseInfoMapper.selectSWarehouseInfoById(id);
    }

    /**
     * 查询仓库管理列表
     *
     * @param sWarehouseInfo 仓库管理
     * @return 仓库管理
     */
    @Override
    public List<SWarehouseInfo> selectSWarehouseInfoList(SWarehouseInfo sWarehouseInfo)
    {
        return sWarehouseInfoMapper.selectSWarehouseInfoList(sWarehouseInfo);
    }

    /**
     * 新增仓库管理
     *
     * @param sWarehouseInfo 仓库管理
     * @return 结果
     */
    @Override
    public int insertSWarehouseInfo(SWarehouseInfo sWarehouseInfo)
    {
        return sWarehouseInfoMapper.insertSWarehouseInfo(sWarehouseInfo);
    }

    /**
     * 修改仓库管理
     *
     * @param sWarehouseInfo 仓库管理
     * @return 结果
     */
    @Override
    public int updateSWarehouseInfo(SWarehouseInfo sWarehouseInfo)
    {
        return sWarehouseInfoMapper.updateSWarehouseInfo(sWarehouseInfo);
    }

    /**
     * 批量删除仓库管理
     *
     * @param ids 需要删除的仓库管理ID
     * @return 结果
     */
    @Override
    public int deleteSWarehouseInfoByIds(Long[] ids)
    {
        return sWarehouseInfoMapper.deleteSWarehouseInfoByIds(ids);
    }

    /**
     * 删除仓库管理信息
     *
     * @param id 仓库管理ID
     * @return 结果
     */
    @Override
    public int deleteSWarehouseInfoById(Long id)
    {
        return sWarehouseInfoMapper.deleteSWarehouseInfoById(id);
    }

    @Override
    public List<Map<String, String>> selectDeoptNameList() {
        return sWarehouseInfoMapper.selectDeoptNameList();
    }

}
