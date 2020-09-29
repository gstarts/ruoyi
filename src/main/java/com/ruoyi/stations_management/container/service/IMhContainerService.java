package com.ruoyi.stations_management.container.service;

import java.util.List;

import com.ruoyi.stations_management.coal.domain.CoalNumber;
import com.ruoyi.stations_management.container.domain.MhContainer;

/**
 * 集装箱管理HeadService接口
 *
 * @author songxiangyang
 * @date 2020-06-11
 */
public interface IMhContainerService {
    /**
     * 查询集装箱管理Head
     *
     * @param id 集装箱管理HeadID
     * @return 集装箱管理Head
     */
    public MhContainer selectMhContainerById(Long id);

    /**
     * 查询集装箱管理Head列表
     *
     * @param mhContainer 集装箱管理Head
     * @return 集装箱管理Head集合
     */
    public List<MhContainer> selectMhContainerList(MhContainer mhContainer);

    /**
     * 新增集装箱管理Head
     *
     * @param mhContainer 集装箱管理Head
     * @return 结果
     */
    public int insertMhContainer(MhContainer mhContainer);

    /**
     * 修改集装箱管理Head
     *
     * @param mhContainer 集装箱管理Head
     * @return 结果
     */
    public int updateMhContainer(MhContainer mhContainer);

    /**
     * 批量删除集装箱管理Head
     *
     * @param ids 需要删除的集装箱管理HeadID
     * @return 结果
     */
    public int deleteMhContainerByIds(Long[] ids);

    /**
     * 删除集装箱管理Head信息
     *
     * @param id 集装箱管理HeadID
     * @return 结果
     */
    public int deleteMhContainerById(Long id);

    /**
     * 初始化页面
     *
     * @return
     */
    public MhContainer init();
}
