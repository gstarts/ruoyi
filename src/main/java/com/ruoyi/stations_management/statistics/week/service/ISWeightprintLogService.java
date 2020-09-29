package com.ruoyi.stations_management.statistics.week.service;

import java.util.List;
import com.ruoyi.stations_management.statistics.week.domain.SWeightprintLog;

/**
 * 打印日志Service接口
 * 
 * @author lanzhenyuan
 * @date 2020-05-20
 */
public interface ISWeightprintLogService 
{
    /**
     * 查询打印日志
     * 
     * @param id 打印日志ID
     * @return 打印日志
     */
    public SWeightprintLog selectSWeightprintLogById(Long id);

    /**
     * 查询打印日志列表
     * 
     * @param sWeightprintLog 打印日志
     * @return 打印日志集合
     */
    public List<SWeightprintLog> selectSWeightprintLogList(SWeightprintLog sWeightprintLog);

    /**
     * 新增打印日志
     * 
     * @param sWeightprintLog 打印日志
     * @return 结果
     */
    public int insertSWeightprintLog(SWeightprintLog sWeightprintLog);

    /**
     * 修改打印日志
     * 
     * @param sWeightprintLog 打印日志
     * @return 结果
     */
    public int updateSWeightprintLog(SWeightprintLog sWeightprintLog);

    /**
     * 批量删除打印日志
     * 
     * @param ids 需要删除的打印日志ID
     * @return 结果
     */
    public int deleteSWeightprintLogByIds(Long[] ids);

    /**
     * 删除打印日志信息
     * 
     * @param id 打印日志ID
     * @return 结果
     */
    public int deleteSWeightprintLogById(Long id);
}
