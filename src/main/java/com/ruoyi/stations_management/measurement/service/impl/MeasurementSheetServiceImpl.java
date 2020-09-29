package com.ruoyi.stations_management.measurement.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.stations_management.measurement.domain.MeasurementSheet;
import com.ruoyi.stations_management.measurement.mapper.MeasurementSheetMapper;
import com.ruoyi.stations_management.measurement.service.IMeasurementSheetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 计量单Service业务层处理
 * 
 * @author lanzhenyuan
 * @date 2020-08-17
 */
@Service
public class MeasurementSheetServiceImpl implements IMeasurementSheetService 
{
    @Resource
    private MeasurementSheetMapper measurementSheetMapper;

    /**
     * 查询计量单
     * 
     * @param id 计量单ID
     * @return 计量单
     */
    @Override
    public MeasurementSheet selectMeasurementSheetById(Long id)
    {
        return measurementSheetMapper.selectMeasurementSheetById(id);
    }

    /**
     * 查询计量单列表
     * 
     * @param measurementSheet 计量单
     * @return 计量单
     */
    @Override
    public List<MeasurementSheet> selectMeasurementSheetList(MeasurementSheet measurementSheet)
    {
        return measurementSheetMapper.selectMeasurementSheetList(measurementSheet);
    }

    /**
     * 新增计量单
     * 
     * @param measurementSheet 计量单
     * @return 结果
     */
    @Override
    public int insertMeasurementSheet(MeasurementSheet measurementSheet)
    {
        measurementSheet.setCreateTime(DateUtils.getNowDate());
        return measurementSheetMapper.insertMeasurementSheet(measurementSheet);
    }

    /**
     * 修改计量单
     * 
     * @param measurementSheet 计量单
     * @return 结果
     */
    @Override
    public int updateMeasurementSheet(MeasurementSheet measurementSheet)
    {
        measurementSheet.setUpdateTime(DateUtils.getNowDate());
        return measurementSheetMapper.updateMeasurementSheet(measurementSheet);
    }

    /**
     * 批量删除计量单
     * 
     * @param ids 需要删除的计量单ID
     * @return 结果
     */
    @Override
    public int deleteMeasurementSheetByIds(Long[] ids)
    {
        return measurementSheetMapper.deleteMeasurementSheetByIds(ids);
    }

    /**
     * 删除计量单信息
     * 
     * @param id 计量单ID
     * @return 结果
     */
    @Override
    public int deleteMeasurementSheetById(Long id)
    {
        return measurementSheetMapper.deleteMeasurementSheetById(id);
    }
}
