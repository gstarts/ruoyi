package com.ruoyi.stations_management.statistics.months.mapper;

import java.util.List;
import com.ruoyi.stations_management.statistics.months.domain.WeightprintLog;

/**
 * 打印日志Mapper接口
 * 
 * @author songqingchuan
 * @date 2020-05-20
 */
public interface WeightprintLogMapper 
{
    /**
     * 查询打印日志
     * 
     * @param id 打印日志ID
     * @return 打印日志
     */
    public WeightprintLog selectWeightprintLogById(Long id);

    /**
     * 查询打印日志列表
     * 
     * @param weightprintLog 打印日志
     * @return 打印日志集合
     */
    public List<WeightprintLog> selectWeightprintLogList(WeightprintLog weightprintLog);

    /**
     * 新增打印日志
     * 
     * @param weightprintLog 打印日志
     * @return 结果
     */
    public int insertWeightprintLog(WeightprintLog weightprintLog);

    /**
     * 修改打印日志
     * 
     * @param weightprintLog 打印日志
     * @return 结果
     */
    public int updateWeightprintLog(WeightprintLog weightprintLog);

    /**
     * 删除打印日志
     * 
     * @param id 打印日志ID
     * @return 结果
     */
    public int deleteWeightprintLogById(Long id);

    /**
     * 批量删除打印日志
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWeightprintLogByIds(Long[] ids);
}
