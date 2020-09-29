package com.ruoyi.stations_management.depot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.depot.mapper.SGoodsInfoMapper;
import com.ruoyi.stations_management.depot.domain.SGoodsInfos;
import com.ruoyi.stations_management.depot.service.ISGoodsInfoService;

/**
 * 仓库货物Service业务层处理
 *
 * @author qishuai
 * @date 2020-01-01
 */
@Service
public class SGoodsInfoServiceImpl implements ISGoodsInfoService
{
    @Autowired(required=true)
    private SGoodsInfoMapper sGoodsInfoMapper;

    /**
     * 查询仓库货物
     *
     * @param id 仓库货物ID
     * @return 仓库货物
     */
    @Override
    public SGoodsInfos selectSGoodsInfoById(Long id)
    {
        return sGoodsInfoMapper.selectSGoodsInfoById(id);
    }

    /**
     * 查询仓库货物列表
     *
     * @param sGoodsInfos 仓库货物
     * @return 仓库货物
     */
    @Override
    public List<SGoodsInfos> selectSGoodsInfoList(SGoodsInfos sGoodsInfos)
    {
        return sGoodsInfoMapper.selectSGoodsInfoList(sGoodsInfos);
    }

    /**
     * 新增仓库货物
     *
     * @param sGoodsInfos 仓库货物
     * @return 结果
     */
    @Override
    public int insertSGoodsInfo(SGoodsInfos sGoodsInfos)
    {
        return sGoodsInfoMapper.insertSGoodsInfo(sGoodsInfos);
    }

    /**
     * 修改仓库货物
     *
     * @param sGoodsInfos 仓库货物
     * @return 结果
     */
    @Override
    public int updateSGoodsInfo(SGoodsInfos sGoodsInfos)
    {
        return sGoodsInfoMapper.updateSGoodsInfo(sGoodsInfos);
    }

    /**
     * 批量删除仓库货物
     *
     * @param ids 需要删除的仓库货物ID
     * @return 结果
     */
    @Override
    public int deleteSGoodsInfoByIds(Long[] ids)
    {
        return sGoodsInfoMapper.deleteSGoodsInfoByIds(ids);
    }

    /**
     * 删除仓库货物信息
     *
     * @param id 仓库货物ID
     * @return 结果
     */
    @Override
    public int deleteSGoodsInfoById(Long id)
    {
        return sGoodsInfoMapper.deleteSGoodsInfoById(id);
    }
}
