package com.ruoyi.stations_management.container.mapper;

import java.util.List;

import com.ruoyi.stations_management.container.domain.MbContainer;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author songxiangyang
 * @date 2020-06-11
 */
public interface MbContainerMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public List<MbContainer> selectMbContainerById(Long id);

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public MbContainer selectMbContainerBodyById(Long id);

    /**
     * 查询集装箱号
     */
    public MbContainer selectMbContainerCode(String code);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param mbContainer 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<MbContainer> selectMbContainerList(MbContainer mbContainer);

    /**
     * 新增【请填写功能名称】
     *
     * @param mbContainer 【请填写功能名称】
     * @return 结果
     */
    public int insertMbContainer(MbContainer mbContainer);

    /**
     * 修改【请填写功能名称】
     *
     * @param mbContainer 【请填写功能名称】
     * @return 结果
     */
    public int updateMbContainer(MbContainer mbContainer);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteMbContainerById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMbContainerByIds(Long[] ids);
}
