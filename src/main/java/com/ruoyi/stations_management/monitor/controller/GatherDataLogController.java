package com.ruoyi.stations_management.monitor.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.monitor.domain.GatherDataLog;
import com.ruoyi.stations_management.monitor.service.IGatherDataLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据监控Controller
 *
 * @author qishuai
 * @date 2020-03-30
 */
@Api("数据监控")
@RestController
@RequestMapping("/monitor/data")
public class GatherDataLogController extends BaseController {
    @Autowired
    private IGatherDataLogService gatherDataLogService;

    /**
     * 查询数据监控列表
     */
    @ApiOperation("查询数据监控列表")
    @ApiImplicitParam(name = "gatherDataLog", value = "查询数据监控列表", dataType = "gatherDataLog")
    @PreAuthorize("@ss.hasPermi('monitor:data:list')")
    @GetMapping("/list")
    public AjaxResult list(GatherDataLog gatherdataLog) {
        startPage();
        // 放行数据
        List<GatherDataLog> list = gatherDataLogService.selectGatherDataLogList(gatherdataLog);
        TableDataInfo listTable = getDataTable(list);
        //  通关中数据
        startPage();
        List<GatherDataLog> durList = gatherDataLogService.selectDuringGatherDataLogList(gatherdataLog);
        TableDataInfo durTable = getDataTable(durList);
        // 未放行数据
        startPage();
        List<GatherDataLog> errList = gatherDataLogService.selectErrGatherDataLogList(gatherdataLog);
        TableDataInfo errTable = getDataTable(errList);
        Map<String, TableDataInfo> retMap = new HashMap<>(3);
        retMap.put("list", listTable);
        retMap.put("dur", durTable);
        retMap.put("err", errTable);
        return AjaxResult.success(retMap);
    }

    /**
     * 导出数据监控列表
     */
    @ApiOperation("导出数据监控列表")
    @ApiImplicitParam(name = "gatherdataLog", value = "导出数据监控列表", dataType = "GatherdataLog")
    @PreAuthorize("@ss.hasPermi('monitor:data:export')")
    @Log(title = "数据监控", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(GatherDataLog gatherdataLog) {
        List<GatherDataLog> list = gatherDataLogService.selectGatherDataLogList(gatherdataLog);
        ExcelUtil<GatherDataLog> util = new ExcelUtil<>(GatherDataLog.class);
        return util.exportExcel(list, "data");
    }

    /**
     * 获取数据监控详细信息
     */
    @ApiOperation("获取数据监控详细信息")
    @ApiImplicitParam(name = "sessionId", value = "sessionId", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('monitor:data:query')")
    @GetMapping(value = "/{sessionId}")
    public AjaxResult getInfo(@PathVariable("sessionId") String sessionId) {
        return AjaxResult.success(gatherDataLogService.selectGatherDataLogById(sessionId));
    }

    /**
     * 新增数据监控
     */
    @ApiOperation("新增数据监控")
    @ApiImplicitParam(name = "gatherdataLog", value = "新增数据监控", dataType = "GatherdataLog")
    @PreAuthorize("@ss.hasPermi('monitor:data:add')")
    @Log(title = "数据监控", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GatherDataLog gatherdataLog) {
        return toAjax(gatherDataLogService.insertGatherdataLog(gatherdataLog));
    }

    /**
     * 人工抬杆方法
     */
    @PreAuthorize("@ss.hasPermi('monitor:data:artificial')")
    @Log(title = "人工抬杆", businessType = BusinessType.INSERT)
    @PostMapping("/artificial")
    public AjaxResult artificial(@RequestBody GatherDataLog gatherdataLog) {
        return toAjax(gatherDataLogService.artificial(gatherdataLog));
    }



    /**
     * 修改数据监控
     */
    @ApiOperation("修改数据监控")
    @ApiImplicitParam(name = "gatherdataLog", value = "修改数据监控", dataType = "GatherdataLog")
    @PreAuthorize("@ss.hasPermi('monitor:data:edit')")
    @Log(title = "数据监控", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GatherDataLog gatherdataLog) {
        return toAjax(gatherDataLogService.updateGatherdataLog(gatherdataLog));
    }

    /**
     * 补采操作
     */

    @PreAuthorize("@ss.hasPermi('monitor:data:edit')")

    @PutMapping("/set")
    public AjaxResult set(@RequestBody GatherDataLog gatherdataLog) {
        try {
            gatherDataLogService.supplementCollection(gatherdataLog);
        } catch (Exception e) {
            return AjaxResult.error("补采失败");
        }
        return AjaxResult.success();
    }


    /**
     * 人工抬杆
     */
    @PreAuthorize("@ss.hasPermi('monitor:data:edit')")
    @PutMapping("/Lifter")
    public AjaxResult lift(@RequestBody GatherDataLog gatherdataLog) {
        return toAjax(gatherDataLogService.updateGatherDataLogLift(gatherdataLog));
    }

    /**
     * 删除数据监控
     */
    @ApiOperation("删除数据监控")
    @ApiImplicitParam(name = "sessionIds", value = "sessionId", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('monitor:data:remove')")
    @Log(title = "数据监控", businessType = BusinessType.DELETE)
    @DeleteMapping("/{sessionIds}")
    public AjaxResult remove(@PathVariable String[] sessionIds) {
        return toAjax(gatherDataLogService.deleteGatherDataLogByIds(sessionIds));
    }

    /**
     * 获取放行异常信息
     */
    @ApiOperation("获取放行异常信息")
    @ApiImplicitParam(name = "sessionIds", value = "sessionId", required = true, dataType = "int", paramType = "path")
    @GetMapping("/details/{sessionId}")
    public AjaxResult getDetail(@PathVariable("sessionId") String sessionId) {
        GatherDataLog errDetails = gatherDataLogService.selectErrDetails(sessionId);
        return AjaxResult.success(errDetails);
    }


}
