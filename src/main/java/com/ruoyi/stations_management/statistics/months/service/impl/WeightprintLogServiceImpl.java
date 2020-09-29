package com.ruoyi.stations_management.statistics.months.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.statistics.months.mapper.WeightprintLogMapper;
import com.ruoyi.stations_management.statistics.months.domain.WeightprintLog;
import com.ruoyi.stations_management.statistics.months.service.IWeightprintLogService;

/**
 * 打印日志Service业务层处理
 * 
 * @author songqingchuan
 * @date 2020-05-20
 */
@Service
public class WeightprintLogServiceImpl implements IWeightprintLogService 
{
    @Autowired
    private WeightprintLogMapper weightprintLogMapper;

    /**
     * 查询打印日志
     * 
     * @param id 打印日志ID
     * @return 打印日志
     */
    @Override
    public WeightprintLog selectWeightprintLogById(Long id)
    {
        return weightprintLogMapper.selectWeightprintLogById(id);
    }

    /**
     * 查询打印日志列表
     * 
     * @param weightprintLog 打印日志
     * @return 打印日志
     */
    @Override
    public List<WeightprintLog> selectWeightprintLogList(WeightprintLog weightprintLog)
    {
        return weightprintLogMapper.selectWeightprintLogList(weightprintLog);
    }

    /**
     * 新增打印日志
     * 
     * @param weightprintLog 打印日志
     * @return 结果
     */
    @Override
    public int insertWeightprintLog(WeightprintLog weightprintLog)
    {
        return weightprintLogMapper.insertWeightprintLog(weightprintLog);
    }

    /**
     * 修改打印日志
     * 
     * @param weightprintLog 打印日志
     * @return 结果
     */
    @Override
    public int updateWeightprintLog(WeightprintLog weightprintLog)
    {
        return weightprintLogMapper.updateWeightprintLog(weightprintLog);
    }

    /**
     * 批量删除打印日志
     * 
     * @param ids 需要删除的打印日志ID
     * @return 结果
     */
    @Override
    public int deleteWeightprintLogByIds(Long[] ids)
    {
        return weightprintLogMapper.deleteWeightprintLogByIds(ids);
    }

    /**
     * 删除打印日志信息
     * 
     * @param id 打印日志ID
     * @return 结果
     */
    @Override
    public int deleteWeightprintLogById(Long id)
    {
        return weightprintLogMapper.deleteWeightprintLogById(id);
    }
}
