package com.ruoyi.stations_management.statistics.week.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.statistics.week.mapper.SWeightprintLogMapper;
import com.ruoyi.stations_management.statistics.week.domain.SWeightprintLog;
import com.ruoyi.stations_management.statistics.week.service.ISWeightprintLogService;

/**
 * 打印日志Service业务层处理
 * 
 * @author lanzhenyuan
 * @date 2020-05-20
 */
@Service
public class SWeightprintLogServiceImpl implements ISWeightprintLogService
{
    @Autowired
    private SWeightprintLogMapper sWeightprintLogMapper;

    /**
     * 查询打印日志
     * 
     * @param id 打印日志ID
     * @return 打印日志
     */
    @Override
    public SWeightprintLog selectSWeightprintLogById(Long id)
    {
        return sWeightprintLogMapper.selectSWeightprintLogById(id);
    }

    /**
     * 查询打印日志列表
     * 
     * @param sWeightprintLog 打印日志
     * @return 打印日志
     */
    @Override
    public List<SWeightprintLog> selectSWeightprintLogList(SWeightprintLog sWeightprintLog)
    {
        return sWeightprintLogMapper.selectSWeightprintLogList(sWeightprintLog);
    }

    /**
     * 新增打印日志
     * 
     * @param sWeightprintLog 打印日志
     * @return 结果
     */
    @Override
    public int insertSWeightprintLog(SWeightprintLog sWeightprintLog)
    {
        return sWeightprintLogMapper.insertSWeightprintLog(sWeightprintLog);
    }

    /**
     * 修改打印日志
     * 
     * @param sWeightprintLog 打印日志
     * @return 结果
     */
    @Override
    public int updateSWeightprintLog(SWeightprintLog sWeightprintLog)
    {
        return sWeightprintLogMapper.updateSWeightprintLog(sWeightprintLog);
    }

    /**
     * 批量删除打印日志
     * 
     * @param ids 需要删除的打印日志ID
     * @return 结果
     */
    @Override
    public int deleteSWeightprintLogByIds(Long[] ids)
    {
        return sWeightprintLogMapper.deleteSWeightprintLogByIds(ids);
    }

    /**
     * 删除打印日志信息
     * 
     * @param id 打印日志ID
     * @return 结果
     */
    @Override
    public int deleteSWeightprintLogById(Long id)
    {
        return sWeightprintLogMapper.deleteSWeightprintLogById(id);
    }
}
