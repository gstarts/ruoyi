package com.ruoyi.stations_management.declare.service;

import java.util.List;

import com.ruoyi.stations_management.declare.domain.ContainerBody;

/**
 * 集装箱体Service接口
 * 
 * @author songqingchaun
 * @date 2020-04-07
 */
public interface IContainerBodyService 
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
     * 修改集装箱体
     * 
     * @param containerBody 集装箱体
     * @return 结果
     */
    public int updateContainerBody(ContainerBody containerBody);

    /**
     * 批量删除集装箱体
     * 
     * @param ids 需要删除的集装箱体ID
     * @return 结果
     */
    public int deleteContainerBodyByIds(Long[] ids);

    /**
     * 删除集装箱体信息
     * 
     * @param id 集装箱体ID
     * @return 结果
     */
    public int deleteContainerBodyById(Long id);

    /**
     * 批量插入集装箱
     * @param list
     * @param headId
     * @return 结果
     */

    public String importContainer(List<ContainerBody> list , Long headId);

}
