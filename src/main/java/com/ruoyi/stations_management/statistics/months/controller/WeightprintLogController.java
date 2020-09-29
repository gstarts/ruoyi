package com.ruoyi.stations_management.statistics.months.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.stations_management.statistics.months.domain.WeightprintLog;
import com.ruoyi.stations_management.statistics.months.service.IWeightprintLogService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 月统计Controller
 *
 * @author songqingchuan
 * @date 2020-05-20
 */
@Api(tags = "月统计")
@RestController
@RequestMapping("/months/log")
public class WeightprintLogController extends BaseController {
    @Autowired
    private IWeightprintLogService weightprintLogService;

    /**
     * 查询打印月统计列表
     */
    @ApiOperation("查询打印月统计列表")
    @ApiImplicitParam(name = "weightprintLog", value = "查询打印月统计列表", dataType = "WeightprintLog")
    @PreAuthorize("@ss.hasPermi('months:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(WeightprintLog weightprintLog) {
        startPage();
        List<WeightprintLog> list = weightprintLogService.selectWeightprintLogList(weightprintLog);
        return getDataTable(list);
    }

    /**
     * 导出打印月统计列表
     */
    @ApiOperation("导出打印月统计列表")
    @ApiImplicitParam(name = "weightprintLog", value = "导出打印月统计列表", dataType = "WeightprintLog")
    @PreAuthorize("@ss.hasPermi('months:log:export')")
    @Log(title = "打印月统计", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WeightprintLog weightprintLog) {
        List<WeightprintLog> list = weightprintLogService.selectWeightprintLogList(weightprintLog);
        ExcelUtil<WeightprintLog> util = new ExcelUtil<WeightprintLog>(WeightprintLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 获取打印月统计详细信息
     */
    @ApiOperation("获取打印月统计详细信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "path")
    @PreAuthorize("@ss.hasPermi('months:log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(weightprintLogService.selectWeightprintLogById(id));
    }

    /**
     * 新增打印月统计
     */
    @ApiOperation("新增打印月统计")
    @ApiImplicitParam(name = "weightprintLog", value = "新增打印月统计", dataType = "WeightprintLog")
    @PreAuthorize("@ss.hasPermi('months:log:add')")
    @Log(title = "打印月统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WeightprintLog weightprintLog) {
        return toAjax(weightprintLogService.insertWeightprintLog(weightprintLog));
    }

    /**
     * 修改打印月统计
     */
    @ApiOperation("修改打印月统计")
    @ApiImplicitParam(name = "weightprintLog", value = "修改打印月统计", dataType = "WeightprintLog")
    @PreAuthorize("@ss.hasPermi('months:log:edit')")
    @Log(title = "打印月统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WeightprintLog weightprintLog) {
        return toAjax(weightprintLogService.updateWeightprintLog(weightprintLog));
    }

    /**
     * 删除打印月统计
     */
    @ApiOperation("删除打印月统计")
    @ApiImplicitParam(name = "ids", value = "ids", required = true, dataType = "Long", paramType = "path")
    @PreAuthorize("@ss.hasPermi('months:log:remove')")
    @Log(title = "打印月统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(weightprintLogService.deleteWeightprintLogByIds(ids));
    }
}
