package com.ruoyi.stations_management.coal.service;

import java.util.List;

import com.ruoyi.stations_management.coal.domain.CoalNumberPlate;

/**
 * 小提煤单 Service接口
 *
 * @author songqingchuan
 * @date 2020-06-02
 */
public interface ICoalNumberPlateService {
    /**
     * 查询小提煤单列表
     *
     * @param coalNumber 大提煤单号
     * @return 结果
     */
    public List<CoalNumberPlate> selectCoalNumberPlateById(String coalNumber);

    /**
     * 查询小提煤单列表
     *
     * @param coalNumberPlate 小提煤单实体类
     * @return 小提煤单集合
     */
    public List<CoalNumberPlate> selectCoalNumberPlateList(CoalNumberPlate coalNumberPlate);

    /**
     * 新增小提煤单
     *
     * @param coalNumberPlate 小提煤单实体类
     * @return 结果
     */
    public int insertCoalNumberPlate(CoalNumberPlate coalNumberPlate);

    /**
     * 修改【请填写功能名称】
     *
     * @param coalNumberPlate 【请填写功能名称】
     * @return 结果
     */
    public int updateCoalNumberPlate(CoalNumberPlate coalNumberPlate);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCoalNumberPlateByIds(Long[] ids);


    /**
     * @param ids
     * @return 作废
     */

    public int updateCoalNumberPlateByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCoalNumberPlateById(Long id);
}
