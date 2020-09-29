package com.ruoyi.stations_management.declare.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.stations_management.declare.domain.AnimalsBody;
import org.apache.poi.ss.formula.functions.T;

/**
 * 动物体Service接口
 *
 * @author qishuai
 * @date 2020-04-07
 */
public interface IAnimalsBodyService
{
    /**
     * 查询动物体
     *
     * @param id 动物体ID
     * @return 动物体
     */
    public AnimalsBody selectAnimalsBodyById(Long id);

    /**
     * 查询动物体列表
     *
     * @param animalsBody 动物体
     * @return 动物体集合
     */
    public List<AnimalsBody> selectAnimalsBodyList(AnimalsBody animalsBody);

    /**
     * 新增动物体
     *
     * @param animalsBody 动物体
     * @return 结果
     */
    public int insertAnimalsBody(AnimalsBody animalsBody);

    /**
     * 修改动物体
     *
     * @param animalsBody 动物体
     * @return 结果
     */
    public int updateAnimalsBody(AnimalsBody animalsBody);

    /**
     * 批量删除动物体
     *
     * @param ids 需要删除的动物体ID
     * @return 结果
     */
    public int deleteAnimalsBodyByIds(Long[] ids);

    /**
     * 删除动物体信息
     *
     * @param id 动物体ID
     * @return 结果
     */
    public int deleteAnimalsBodyById(Long id);

    /**
     *  校验导入数据是否符合规定
     * @param list 导入数据列表
     * @return 返回错误信息
     */
    public String validationRules(List<AnimalsBody> list);

    /**
     *  批量导入数据
     * @param list 数据列表
     * @param headId 基础信息主键
     * @return 返回导入结果
     */
    public String importAnimals(List<AnimalsBody> list ,Long headId);
}
