package com.ruoyi.stations_management.depot.mapper;

import com.ruoyi.stations_management.depot.domain.SGoodsInfos;
import java.util.List;

/**
 * 仓库货物Mapper接口
 *
 * @author qishuai
 * @date 2020-01-01
 */
public interface SGoodsInfoMapper
{
    /**
     * 查询仓库货物
     *
     * @param id 仓库货物ID
     * @return 仓库货物
     */
    public SGoodsInfos selectSGoodsInfoById(Long id);

    /**
     * 查询仓库货物列表
     *
     * @param sGoodsInfos 仓库货物
     * @return 仓库货物集合
     */
    public List<SGoodsInfos> selectSGoodsInfoList(SGoodsInfos sGoodsInfos);

    /**
     * 新增仓库货物
     *
     * @param sGoodsInfos 仓库货物
     * @return 结果
     */
    public int insertSGoodsInfo(SGoodsInfos sGoodsInfos);

    /**
     * 修改仓库货物
     *
     * @param sGoodsInfos 仓库货物
     * @return 结果
     */
    public int updateSGoodsInfo(SGoodsInfos sGoodsInfos);

    /**
     * 删除仓库货物
     *
     * @param id 仓库货物ID
     * @return 结果
     */
    public int deleteSGoodsInfoById(Long id);

    /**
     * 批量删除仓库货物
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSGoodsInfoByIds(Long[] ids);
}
