package com.ruoyi.stations_management.inout.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.inout.mapper.GFeedbackLogMapper;
import com.ruoyi.stations_management.inout.domain.GFeedbackLog;
import com.ruoyi.stations_management.inout.service.IGFeedbackLogService;

/**
 * 进出场查询Service业务层处理
 *
 * @author qishuai
 * @date 2020-01-02
 */
@Service
public class GFeedbackLogServiceImpl implements IGFeedbackLogService
{
    @Autowired
    private GFeedbackLogMapper gFeedbackLogMapper;



    /**
     * 查询进出场查询列表
     *
     * @param gFeedbackLog 进出场查询
     * @return 进出场查询
     */
    @Override
    public List<GFeedbackLog> selectGFeedbackLogList(GFeedbackLog gFeedbackLog)
    {
        return gFeedbackLogMapper.selectGFeedbackLogList(gFeedbackLog);
    }


}
