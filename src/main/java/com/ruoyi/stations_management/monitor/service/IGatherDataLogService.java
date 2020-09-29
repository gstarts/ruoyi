package com.ruoyi.stations_management.monitor.service;

import java.util.List;
import com.ruoyi.stations_management.monitor.domain.GatherDataLog;

/**
 * 数据监控Service接口
 *
 * @author qishuai
 * @date 2020-03-30
 */
  public interface IGatherDataLogService
{
    /**
     * 查询数据监控
     *
     * @param sessionId 数据监控ID
     * @return 数据监控
     */
     GatherDataLog selectGatherDataLogById(String sessionId);

    /**
     * 查询数据监控列表
     *
     * @param gatherdataLog 数据监控
     * @return 数据监控集合
     */
     List<GatherDataLog> selectGatherDataLogList(GatherDataLog gatherdataLog);
    /**
     * 查询数据监控列表
     *
     * @param gatherdataLog 数据监控
     * @return 数据监控集合
     */
     List<GatherDataLog> selectErrGatherDataLogList(GatherDataLog gatherdataLog);

    /**
     * 查询通关异常详情
     * @param sessionId
     * @return 数据详情
     */
     GatherDataLog selectErrDetails(String sessionId);
    /**
     * 查询数据监控列表
     *
     * @param gatherdataLog 数据监控
     * @return 数据监控集合
     */
     List<GatherDataLog> selectDuringGatherDataLogList(GatherDataLog gatherdataLog);

    /**
     * 新增数据监控
     *
     * @param gatherdataLog 数据监控
     * @return 结果
     */
     int insertGatherdataLog(GatherDataLog gatherdataLog);

    /**
     * 人工抬杆操作
     * @param gatherdataLog 操作数据
     * @return 结果
     */

     int artificial(GatherDataLog gatherdataLog);

    /**
     * 修改数据监控
     *
     * @param gatherdataLog 数据监控
     * @return 结果
     */
     int updateGatherdataLog(GatherDataLog gatherdataLog);

    /**
     * 补采操作
     *
     * @param gatherdataLog 数据监控
     * @return 结果
     */
     int supplementCollection(GatherDataLog gatherdataLog) throws Exception;

    /**
     * 人工抬杆
     *
     * @param gatherdataLog 数据监控
     * @return 结果
     */
     int updateGatherDataLogLift(GatherDataLog gatherdataLog);

    /**
     * 批量删除数据监控
     *
     * @param sessionIds 需要删除的数据监控ID
     * @return 结果
     */
     int deleteGatherDataLogByIds(String[] sessionIds);

    /**
     * 删除数据监控信息
     *
     * @param sessionId 数据监控ID
     * @return 结果
     */
     int deleteGatherDataLogById(String sessionId);
}
