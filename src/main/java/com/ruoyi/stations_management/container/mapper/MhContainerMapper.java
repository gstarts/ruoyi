package com.ruoyi.stations_management.container.mapper;

import java.util.List;
import com.ruoyi.stations_management.container.domain.MhContainer;

/**
 * 集装箱管理HeadMapper接口
 * 
 * @author songxiangyang
 * @date 2020-06-11
 */
public interface MhContainerMapper 
{
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
     * 删除集装箱管理Head
     * 
     * @param id 集装箱管理HeadID
     * @return 结果
     */
    public int deleteMhContainerById(Long id);

    /**
     * 批量删除集装箱管理Head
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMhContainerByIds(Long[] ids);
}
