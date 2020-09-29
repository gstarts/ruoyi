package com.ruoyi.stations_management.coal.service;

import java.util.List;

import com.ruoyi.stations_management.coal.domain.CoalNumber;

/**
 * 大提煤单 Service接口
 *
 * @author songqingchuan
 * @date 2020-06-02
 */
public interface ICoalNumberService {
    /**
     * 查询 根据ID
     *
     * @param coalNumber coalNumber
     * @return 返回结果
     */
    public CoalNumber selectCoalNumberById(String coalNumber);

    /**
     * 查询列表
     *
     * @param coalNumber 单号
     * @return 集合
     */
    public List<CoalNumber> selectCoalNumberList(CoalNumber coalNumber);

    /**
     * 新增 大提煤单
     *
     * @param coalNumber  单号
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
     * 批量删除【请填写功能名称】
     *
     * @param coalNumbers 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCoalNumberByIds(String[] coalNumbers);


    /**
     * 大提煤单作废
     *
     * @param coalNumber
     * @return
     */

    public int updateCoalNumberByIds(String coalNumber);

    /**
     * 执行成功
     *
     * @param ids
     * @return
     */


    public int updateCoalNumberPlateByNum(String[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param coalNumber 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteCoalNumberById(String coalNumber);

    /**
     * 初始化页面
     *
     * @return
     */
    public CoalNumber init();
}
