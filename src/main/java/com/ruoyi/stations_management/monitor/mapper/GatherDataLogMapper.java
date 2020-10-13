package com.ruoyi.stations_management.monitor.mapper;

import java.util.List;

import com.ruoyi.stations_management.index.domain.IndexDao;
import com.ruoyi.stations_management.index.domain.MainPicture;
import com.ruoyi.stations_management.index.domain.Vehicle;
import com.ruoyi.stations_management.monitor.domain.GatherDataLog;

/**
 * 数据监控Mapper接口
 *
 * @author qishuai
 * @date 2020-03-30
 */
public interface GatherDataLogMapper
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
     * @param gatherDataLog 数据监控
     * @return 数据监控集合
     */
     List<GatherDataLog> selectGatherDataLogList(GatherDataLog gatherDataLog);

    /**
     * 查询数据监控列表
     *
     * @param gatherDataLog 数据监控
     * @return 数据监控集合
     */
     List<GatherDataLog> selectErrGatherDataLogList(GatherDataLog gatherDataLog);

    /**
     * 查询通关异常详情
     * @param sessionId 数据监控
     * @return 数据详情
     */
     GatherDataLog selectErrDetails(String sessionId);
    /**
     * 查询数据监控列表
     *
     * @param gatherDataLog 数据监控
     * @return 数据监控集合
     */
     List<GatherDataLog> selectDuringGatherDataLogList(GatherDataLog gatherDataLog);

    /**
     * 新增数据监控
     *
     * @param gatherDataLog 数据监控
     * @return 结果
     */
     int insertGatherDataLog(GatherDataLog gatherDataLog);

    /**
     * 修改数据监控
     *
     * @param gatherDataLog 数据监控
     * @return 结果
     */
     int updateGatherDataLog(GatherDataLog gatherDataLog);

    /**
     *  设置原数据为失效状态
     * @param sessionId  主键
     * @return 结果
     */
     int updateErrGatherDataLog(String sessionId);


    /**
     * 删除数据监控
     *
     * @param sessionId 数据监控ID
     * @return 结果
     */
     int deleteGatherDataLogById(String sessionId);

    /**
     * 批量删除数据监控
     *
     * @param sessionIds 需要删除的数据ID
     * @return 结果
     */
     int deleteGatherDataLogByIds(String[] sessionIds);

    IndexDao abnormal();

    List<MainPicture> mainPicture();

    List<Vehicle> siteVehicleInformation();
}
