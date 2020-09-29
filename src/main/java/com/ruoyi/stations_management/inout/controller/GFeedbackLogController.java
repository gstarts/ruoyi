package com.ruoyi.stations_management.inout.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.inout.domain.GFeedbackLog;
import com.ruoyi.stations_management.inout.service.IGFeedbackLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 进出场查询Controller
 *
 * @author qishuai
 * @date 2020-01-02
 */
@Api("货运车辆管理")
@RestController
@RequestMapping("/inout/vehicle")

public class GFeedbackLogController extends BaseController
{
    @Autowired
    private IGFeedbackLogService gFeedbackLogService;

    /**
     * 查询进出场查询列表
     */
    @ApiOperation("查询进出场查询列表")
    @ApiImplicitParam(name = "gFeedbackLog", value = "查询进出场查询列表", dataType = "GFeedbackLog")
    @PreAuthorize("@ss.hasPermi('inout:vehicle:list')")
    @GetMapping("/list")
    public TableDataInfo list(GFeedbackLog gFeedbackLog)
    {
        startPage();
        List<GFeedbackLog> list = gFeedbackLogService.selectGFeedbackLogList(gFeedbackLog);
        return getDataTable(list);
    }

}
