package com.ruoyi.stations_management.declare.mapper;

import java.util.List;
import com.ruoyi.stations_management.declare.domain.ContainerHead;

/**
 * 集装箱头Mapper接口
 *
 * @author songqingchuan
 * @date 2020-04-07
 */
public interface ContainerHeadMapper
{
    /**
     * 查询集装箱头
     *
     * @param id 集装箱头ID
     * @return 集装箱头
     */
     ContainerHead selectContainerHeadById(Long id);

    /**
     * 查询集装箱头列表
     *
     * @param containerHead 集装箱头
     * @return 集装箱头集合
     */
     List<ContainerHead> selectContainerHeadList(ContainerHead containerHead);

    /**
     * 新增集装箱头
     *
     * @param containerHead 集装箱头
     * @return 结果
     */
     int insertContainerHead(ContainerHead containerHead);

    /**
     * 修改集装箱头
     *
     * @param containerHead 集装箱头
     * @return 结果
     */
     int updateContainerHead(ContainerHead containerHead);

    /**
     * 删除集装箱头
     *
     * @param id 集装箱头ID
     * @return 结果
     */
     int deleteContainerHeadById(Long id);

    /**
     * 批量申报集装箱头
     *
     * @param ids 需要申报的数据ID
     * @return 结果
     */
     int declareContainers(Long[] ids);

    /**
     *  统计申报成功总数
     * @return 结果
     */
    int statistics();
}
