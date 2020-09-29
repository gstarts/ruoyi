package com.ruoyi.stations_management.coal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.coal.mapper.CoalNumberPlateMapper;
import com.ruoyi.stations_management.coal.domain.CoalNumberPlate;
import com.ruoyi.stations_management.coal.service.ICoalNumberPlateService;

/**
 * 小提煤单 Service业务层处理
 *
 * @author songqingchuan
 * @date 2020-06-02
 */
@Service
public class CoalNumberPlateServiceImpl implements ICoalNumberPlateService {
    @Autowired
    private CoalNumberPlateMapper coalNumberPlateMapper;

    /**
     * 根据大提煤单号查询
     *
     * @param coalNumber 大提煤单号
     * @return 结果
     */
    @Override
    public List<CoalNumberPlate> selectCoalNumberPlateById(String coalNumber) {
        return coalNumberPlateMapper.selectCoalNumberPlateById(coalNumber);
    }

    /**
     * 查询小提煤单列表
     *
     * @param coalNumberPlate 小提煤单实体类
     * @return 结果
     */
    @Override
    public List<CoalNumberPlate> selectCoalNumberPlateList(CoalNumberPlate coalNumberPlate) {
        return coalNumberPlateMapper.selectCoalNumberPlateList(coalNumberPlate);
    }

    /**
     * 新增小提煤单
     *
     * @param coalNumberPlate 小提煤单实体类
     * @return 结果
     */
    @Override
    public int insertCoalNumberPlate(CoalNumberPlate coalNumberPlate) {
        return coalNumberPlateMapper.insertCoalNumberPlate(coalNumberPlate);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param coalNumberPlate 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCoalNumberPlate(CoalNumberPlate coalNumberPlate) {
        return coalNumberPlateMapper.updateCoalNumberPlate(coalNumberPlate);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCoalNumberPlateByIds(Long[] ids) {
        return coalNumberPlateMapper.deleteCoalNumberPlateByIds(ids);
    }

    /**
     * @param ids
     * @return 作废
     */
    @Override
    public int updateCoalNumberPlateByIds(Long[] ids) {
        return coalNumberPlateMapper.updateCoalNumberPlateByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCoalNumberPlateById(Long id) {
        return coalNumberPlateMapper.deleteCoalNumberPlateById(id);
    }
}
