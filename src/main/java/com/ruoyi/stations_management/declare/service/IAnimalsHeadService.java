package com.ruoyi.stations_management.declare.service;

import java.util.List;
import com.ruoyi.stations_management.declare.domain.AnimalsHead;

/**
 * 动物头Service接口
 *
 * @author qishuai
 * @date 2020-04-07
 */
public interface IAnimalsHeadService
{
    /**
     * 查询动物头
     *
     * @param id 动物头ID
     * @return 动物头
     */
    public AnimalsHead selectAnimalsHeadById(Long id);

    /**
     * 查询动物头列表
     *
     * @param animalsHead 动物头
     * @return 动物头集合
     */
    public List<AnimalsHead> selectAnimalsHeadList(AnimalsHead animalsHead);

    /**
     * 新增动物头
     *
     * @param animalsHead 动物头
     * @return 结果
     */
    public int insertAnimalsHead(AnimalsHead animalsHead);

    /**
     * 修改动物头
     *
     * @param animalsHead 动物头
     * @return 结果
     */
    public int updateAnimalsHead(AnimalsHead animalsHead);

    /**
     * 动植物批量申报
     *
     * @param ids 申报数据ID
     * @return 结果
     */
    public int declareAnimals(Long[] ids);

    /**
     * 删除动物头信息
     *
     * @param id 动物头ID
     * @return 结果
     */
    public int deleteAnimalsHeadById(Long id);

    /**
     *  初始化 动植物申报页面
     * @param stationId 场站id
     * @return 结果
     */
    public AnimalsHead init(String stationId);
}
