package com.ruoyi.stations_management.declare.mapper;

import java.util.List;
import com.ruoyi.stations_management.declare.domain.AnimalsBody;
import org.apache.ibatis.annotations.Param;

/**
 * 动物体Mapper接口
 *
 * @author qishuai
 * @date 2020-04-07
 */
public interface AnimalsBodyMapper
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

    public int insertBatchAnimalsBody(@Param("items") List<AnimalsBody> items);

    /**
     * 修改动物体
     *
     * @param animalsBody 动物体
     * @return 结果
     */
    public int updateAnimalsBody(AnimalsBody animalsBody);

    /**
     * 删除动物体
     *
     * @param id 动物体ID
     * @return 结果
     */
    public int deleteAnimalsBodyById(Long id);

    /**
     * 批量删除动物体
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAnimalsBodyByIds(Long[] ids);
}
