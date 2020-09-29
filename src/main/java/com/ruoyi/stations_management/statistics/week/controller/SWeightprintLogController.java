package com.ruoyi.stations_management.statistics.week.controller;

import java.util.List;
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
import com.ruoyi.stations_management.statistics.week.domain.SWeightprintLog;
import com.ruoyi.stations_management.statistics.week.service.ISWeightprintLogService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 打印日志Controller
 * 
 * @author lanzhenyuan
 * @date 2020-05-20
 */
@RestController
@RequestMapping("/week/log")
public class SWeightprintLogController extends BaseController
{
    @Autowired
    private ISWeightprintLogService sWeightprintLogService;

    /**
     * 查询打印日志列表
     */
    @PreAuthorize("@ss.hasPermi('week:log:list')")
    @GetMapping("/list")
    public TableDataInfo list(SWeightprintLog sWeightprintLog)
    {
        startPage();
        List<SWeightprintLog> list = sWeightprintLogService.selectSWeightprintLogList(sWeightprintLog);
        return getDataTable(list);
    }

    /**
     * 导出打印日志列表
     */
    @PreAuthorize("@ss.hasPermi('week:log:export')")
    @Log(title = "打印日志", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SWeightprintLog sWeightprintLog)
    {
        List<SWeightprintLog> list = sWeightprintLogService.selectSWeightprintLogList(sWeightprintLog);
        ExcelUtil<SWeightprintLog> util = new ExcelUtil<SWeightprintLog>(SWeightprintLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 获取打印日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('week:log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sWeightprintLogService.selectSWeightprintLogById(id));
    }

    /**
     * 新增打印日志
     */
    @PreAuthorize("@ss.hasPermi('week:log:add')")
    @Log(title = "打印日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SWeightprintLog sWeightprintLog)
    {
        return toAjax(sWeightprintLogService.insertSWeightprintLog(sWeightprintLog));
    }

    /**
     * 修改打印日志
     */
    @PreAuthorize("@ss.hasPermi('week:log:edit')")
    @Log(title = "打印日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SWeightprintLog sWeightprintLog)
    {
        return toAjax(sWeightprintLogService.updateSWeightprintLog(sWeightprintLog));
    }

    /**
     * 删除打印日志
     */
    @PreAuthorize("@ss.hasPermi('week:log:remove')")
    @Log(title = "打印日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sWeightprintLogService.deleteSWeightprintLogByIds(ids));
    }
}
