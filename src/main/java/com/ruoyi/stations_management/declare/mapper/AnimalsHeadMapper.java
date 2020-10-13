package com.ruoyi.stations_management.declare.mapper;

import java.util.List;
import com.ruoyi.stations_management.declare.domain.AnimalsHead;

/**
 * 动物头Mapper接口
 *
 * @author qishuai
 * @date 2020-04-07
 */
public interface AnimalsHeadMapper
{
    /**
     * 查询动物头
     *
     * @param id 动物头ID
     * @return 动物头
     */
     AnimalsHead selectAnimalsHeadById(Long id);

    /**
     * 查询动物头列表
     *
     * @param animalsHead 动物头
     * @return 动物头集合
     */
     List<AnimalsHead> selectAnimalsHeadList(AnimalsHead animalsHead);

    /**
     * 新增动物头
     *
     * @param animalsHead 动物头
     * @return 结果
     */
     int insertAnimalsHead(AnimalsHead animalsHead);

    /**
     * 修改动物头
     *
     * @param animalsHead 动物头
     * @return 结果
     */
     int updateAnimalsHead(AnimalsHead animalsHead);

    /**
     * 删除动物头
     *
     * @param id 动物头ID
     * @return 结果
     */
     int deleteAnimalsHeadById(Long id);

    /**
     * 批量删除动物头
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int declareAnimals(Long[] ids);

    /**
     *  统计申报成功总数
     * @return 结果
     */
    int statistics();
}
