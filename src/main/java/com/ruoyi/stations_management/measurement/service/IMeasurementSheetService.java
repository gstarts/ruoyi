package com.ruoyi.stations_management.measurement.service;

import java.util.List;
import com.ruoyi.stations_management.measurement.domain.MeasurementSheet;

/**
 * 计量单Service接口
 * 
 * @author lanzhenyuan
 * @date 2020-08-17
 */
public interface IMeasurementSheetService 
{
    /**
     * 查询计量单
     * 
     * @param id 计量单ID
     * @return 计量单
     */
     MeasurementSheet selectMeasurementSheetById(Long id);

    /**
     * 查询计量单列表
     * 
     * @param measurementSheet 计量单
     * @return 计量单集合
     */
     List<MeasurementSheet> selectMeasurementSheetList(MeasurementSheet measurementSheet);

    /**
     * 新增计量单
     * 
     * @param measurementSheet 计量单
     * @return 结果
     */
     int insertMeasurementSheet(MeasurementSheet measurementSheet);

    /**
     * 修改计量单
     * 
     * @param measurementSheet 计量单
     * @return 结果
     */
     int updateMeasurementSheet(MeasurementSheet measurementSheet);

    /**
     * 批量删除计量单
     * 
     * @param ids 需要删除的计量单ID
     * @return 结果
     */
     int deleteMeasurementSheetByIds(Long[] ids);

    /**
     * 删除计量单信息
     * 
     * @param id 计量单ID
     * @return 结果
     */
     int deleteMeasurementSheetById(Long id);
}
