package com.ruoyi.stations_management.coal.mapper;

import java.util.List;

import com.ruoyi.stations_management.coal.domain.CoalNumber;

/**
 * 大提煤单 Mapper接口
 *
 * @author songqingchuan
 * @date 2020-06-02
 */
public interface CoalNumberMapper {
    /**
     * 根据单号 查询
     *
     * @param coalNumber 单号
     * @return 结果
     */
    public CoalNumber selectCoalNumberById(String coalNumber);

    /**
     * 查询列表
     *
     * @param coalNumber 单号
     * @return 集合
     */
    public List<CoalNumber> selectCoalNumberList(CoalNumber coalNumber);


    public List<CoalNumber> selectCoalNumber(CoalNumber coalNumber);

    /**
     * 查询是否有重复的大提煤单
     * @param coalNumber 大提煤单
     * @return 返回查询到的条数
     */
    public List<CoalNumber> selectCoalNumberAll(CoalNumber coalNumber);
    /**
     * 新增大提煤单
     *
     * @param coalNumber 大提煤单实体类
     * @return 结果
     */
    public int insertCoalNumber(CoalNumber coalNumber);

    /**
     * 修改【请填写功能名称】
     *
     * @param coalNumber 【请填写功能名称】
     * @return 结果
     */
    public int updateCoalNumber(CoalNumber coalNumber);

    /**
     * 删除【请填写功能名称】
     *
     * @param coalNumber 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCoalNumberById(String coalNumber);

    /**
     * @param coalNumber
     * @return
     */

    public int updateCoalNumberByIds(String coalNumber);


    /**
     * 批量删除【请填写功能名称】
     *
     * @param coalNumbers 需要删除的数据ID
     * @return 结果
     */
    public int deleteCoalNumberByIds(String[] coalNumbers);


    /**
     * 执行成功
     *
     * @param ids
     * @return
     */

    public int updateCoalNumberByNum(String[] ids);
}
