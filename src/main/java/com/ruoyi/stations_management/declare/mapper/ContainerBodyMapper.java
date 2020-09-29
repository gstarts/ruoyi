package com.ruoyi.stations_management.declare.mapper;

import java.util.List;
import com.ruoyi.stations_management.declare.domain.ContainerBody;
import org.apache.ibatis.annotations.Param;

/**
 * 集装箱体Mapper接口
 * 
 * @author songqingchuan
 * @date 2020-04-07
 */
public interface ContainerBodyMapper 
{
    /**
     * 查询集装箱体
     * 
     * @param id 集装箱体ID
     * @return 集装箱体
     */
    public ContainerBody selectContainerBodyById(Long id);

    /**
     * 查询集装箱体列表
     * 
     * @param containerBody 集装箱体
     * @return 集装箱体集合
     */
    public List<ContainerBody> selectContainerBodyList(ContainerBody containerBody);

    /**
     * 新增集装箱体
     * 
     * @param containerBody 集装箱体
     * @return 结果
     */
    public int insertContainerBody(ContainerBody containerBody);

    /**
     * 批量增加集装箱体
     * @return 结果
     */
    public int insertContainerBodys(@Param("items") List<ContainerBody>items);

    /**
     * 修改集装箱体
     * 
     * @param containerBody 集装箱体
     * @return 结果
     */
    public int updateContainerBody(ContainerBody containerBody);

    /**
     * 删除集装箱体
     * 
     * @param id 集装箱体ID
     * @return 结果
     */
    public int deleteContainerBodyById(Long id);

    /**
     * 批量删除集装箱体
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteContainerBodyByIds(Long[] ids);
}
