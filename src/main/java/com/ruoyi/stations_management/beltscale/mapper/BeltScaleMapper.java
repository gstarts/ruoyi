package com.ruoyi.stations_management.beltscale.mapper;

import java.util.List;
import com.ruoyi.stations_management.beltscale.domain.BeltScale;

/**
 * 皮带秤Mapper接口
 * 
 * @author qishuai
 * @date 2020-07-24
 */
public interface BeltScaleMapper 
{
    /**
     * 查询皮带秤
     * 
     * @param id 皮带秤ID
     * @return 皮带秤
     */
    public BeltScale selectBeltScaleById(String id);

    /**
     * 查询皮带秤列表
     * 
     * @param beltScale 皮带秤
     * @return 皮带秤集合
     */
    public List<BeltScale> selectBeltScaleList(BeltScale beltScale);

    /**
     * 新增皮带秤
     * 
     * @param beltScale 皮带秤
     * @return 结果
     */
    public int insertBeltScale(BeltScale beltScale);

    /**
     * 修改皮带秤
     * 
     * @param beltScale 皮带秤
     * @return 结果
     */
    public int updateBeltScale(BeltScale beltScale);

    /**
     * 删除皮带秤
     * 
     * @param id 皮带秤ID
     * @return 结果
     */
    public int deleteBeltScaleById(String id);

    /**
     * 批量删除皮带秤
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBeltScaleByIds(String[] ids);
}
