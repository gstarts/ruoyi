package com.ruoyi.stations_management.declare.service;

import java.util.List;

import com.ruoyi.stations_management.declare.domain.AnimalsHead;
import com.ruoyi.stations_management.declare.domain.ContainerHead;
import com.ruoyi.stations_management.waybill.domain.WaybillHead;

/**
 * 集装箱头Service接口
 *
 * @author songqingchuan
 * @date 2020-04-07
 */
public interface IContainerHeadService
{
    /**
     * 查询集装箱头
     *
     * @param id 集装箱头ID
     * @return 集装箱头
     */
    public ContainerHead selectContainerHeadById(Long id);

    /**
     * 查询集装箱头列表
     *
     * @param containerHead 集装箱头
     * @return 集装箱头集合
     */
    public List<ContainerHead> selectContainerHeadList(ContainerHead containerHead);

    /**
     * 新增集装箱头
     *
     * @param containerHead 集装箱头
     * @return 结果
     */
    public int insertContainerHead(ContainerHead containerHead);

    /**
     * 修改集装箱头
     *
     * @param containerHead 集装箱头
     * @return 结果
     */
    public int updateContainerHead(ContainerHead containerHead);

    /**
     * 批量删除集装箱头
     *
     * @param ids 需要删除的集装箱头ID
     * @return 结果
     */
    public int declareContainers(Long[] ids);

    /**
     * 删除集装箱头信息
     *
     * @param id 集装箱头ID
     * @return 结果
     */
    public int deleteContainerHeadById(Long id);

    /***
     * 初始化场站信息
     * @param stationId  场站id
     * @return 结果
     */
    public ContainerHead init(String stationId);

}
