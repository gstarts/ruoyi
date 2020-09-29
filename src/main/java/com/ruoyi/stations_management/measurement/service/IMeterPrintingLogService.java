package com.ruoyi.stations_management.measurement.service;

import java.util.List;
import com.ruoyi.stations_management.measurement.domain.MeterPrintingLog;

/**
 * 计量单打印日志Service接口
 * 
 * @author lanzhenyuan
 * @date 2020-08-28
 */
public interface IMeterPrintingLogService 
{
    /**
     * 查询计量单打印日志
     * 
     * @param id 计量单打印日志ID
     * @return 计量单打印日志
     */
     MeterPrintingLog selectMeterPrintingLogById(Long id);

    /**
     * 查询计量单打印日志列表
     * 
     * @param meterPrintingLog 计量单打印日志
     * @return 计量单打印日志集合
     */
     List<MeterPrintingLog> selectMeterPrintingLogList(MeterPrintingLog meterPrintingLog);

    /**
     * 新增计量单打印日志
     * 
     * @param meterPrintingLog 计量单打印日志
     * @return 结果
     */
     int insertMeterPrintingLog(MeterPrintingLog meterPrintingLog);

    /**
     * 修改计量单打印日志
     * 
     * @param meterPrintingLog 计量单打印日志
     * @return 结果
     */
     int updateMeterPrintingLog(MeterPrintingLog meterPrintingLog);

    /**
     * 批量删除计量单打印日志
     * 
     * @param ids 需要删除的计量单打印日志ID
     * @return 结果
     */
     int deleteMeterPrintingLogByIds(Long[] ids);

    /**
     * 删除计量单打印日志信息
     * 
     * @param id 计量单打印日志ID
     * @return 结果
     */
     int deleteMeterPrintingLogById(Long id);
}
