package com.ruoyi.stations_management.container.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.container.mapper.MbContainerMapper;
import com.ruoyi.stations_management.container.domain.MbContainer;
import com.ruoyi.stations_management.container.service.IMbContainerService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author songxiangyang
 * @date 2020-06-11
 */
@Service
public class MbContainerServiceImpl implements IMbContainerService {
    @Autowired
    private MbContainerMapper mbContainerMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public List<MbContainer> selectMbContainerById(Long id) {
        return mbContainerMapper.selectMbContainerById(id);
    }

    /**
     * 查询集装箱体信息
     */
    @Override
    public MbContainer selectMbContainerBodyById(Long id) {
        return mbContainerMapper.selectMbContainerBodyById(id);
    }

    /**
     * 查询集装箱号
     */
    @Override
    public MbContainer selectMbContainerCode(String code) {
        return mbContainerMapper.selectMbContainerCode(code);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param mbContainer 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<MbContainer> selectMbContainerList(MbContainer mbContainer) {
        return mbContainerMapper.selectMbContainerList(mbContainer);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param mbContainer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertMbContainer(MbContainer mbContainer) {
        return mbContainerMapper.insertMbContainer(mbContainer);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param mbContainer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateMbContainer(MbContainer mbContainer) {
        return mbContainerMapper.updateMbContainer(mbContainer);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteMbContainerByIds(Long[] ids) {
        return mbContainerMapper.deleteMbContainerByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteMbContainerById(Long id) {
        return mbContainerMapper.deleteMbContainerById(id);
    }
}
