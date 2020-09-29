package com.ruoyi.stations_management.inout.service;

import com.ruoyi.stations_management.inout.domain.GFeedbackLog;
import java.util.List;

/**
 * 进出场查询Service接口
 *
 * @author qishuai
 * @date 2020-01-02
 */
public interface IGFeedbackLogService
{


    /**
     * 查询进出场查询列表
     *
     * @param gFeedbackLog 进出场查询
     * @return 进出场查询集合
     */
    public List<GFeedbackLog> selectGFeedbackLogList(GFeedbackLog gFeedbackLog);

}
