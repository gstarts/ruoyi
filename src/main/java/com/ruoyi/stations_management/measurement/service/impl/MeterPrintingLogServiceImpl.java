package com.ruoyi.stations_management.measurement.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.stations_management.measurement.domain.MeterPrintingLog;
import com.ruoyi.stations_management.measurement.mapper.MeterPrintingLogMapper;
import com.ruoyi.stations_management.measurement.service.IMeterPrintingLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 计量单打印日志Service业务层处理
 * 
 * @author lanzhenyuan
 * @date 2020-08-28
 */
@Service
public class MeterPrintingLogServiceImpl implements IMeterPrintingLogService 
{
    @Resource
    private MeterPrintingLogMapper meterPrintingLogMapper;

    /**
     * 查询计量单打印日志
     * 
     * @param id 计量单打印日志ID
     * @return 计量单打印日志
     */
    @Override
    public MeterPrintingLog selectMeterPrintingLogById(Long id)
    {
        return meterPrintingLogMapper.selectMeterPrintingLogById(id);
    }

    /**
     * 查询计量单打印日志列表
     * 
     * @param meterPrintingLog 计量单打印日志
     * @return 计量单打印日志
     */
    @Override
    public List<MeterPrintingLog> selectMeterPrintingLogList(MeterPrintingLog meterPrintingLog)
    {
        return meterPrintingLogMapper.selectMeterPrintingLogList(meterPrintingLog);
    }

    /**
     * 新增计量单打印日志
     * 
     * @param meterPrintingLog 计量单打印日志
     * @return 结果
     */
    @Override
    public int insertMeterPrintingLog(MeterPrintingLog meterPrintingLog)
    {
        meterPrintingLog.setCreateTime(DateUtils.getNowDate());
        return meterPrintingLogMapper.insertMeterPrintingLog(meterPrintingLog);
    }

    /**
     * 修改计量单打印日志
     * 
     * @param meterPrintingLog 计量单打印日志
     * @return 结果
     */
    @Override
    public int updateMeterPrintingLog(MeterPrintingLog meterPrintingLog)
    {
        return meterPrintingLogMapper.updateMeterPrintingLog(meterPrintingLog);
    }

    /**
     * 批量删除计量单打印日志
     * 
     * @param ids 需要删除的计量单打印日志ID
     * @return 结果
     */
    @Override
    public int deleteMeterPrintingLogByIds(Long[] ids)
    {
        return meterPrintingLogMapper.deleteMeterPrintingLogByIds(ids);
    }

    /**
     * 删除计量单打印日志信息
     * 
     * @param id 计量单打印日志ID
     * @return 结果
     */
    @Override
    public int deleteMeterPrintingLogById(Long id)
    {
        return meterPrintingLogMapper.deleteMeterPrintingLogById(id);
    }
}
