package com.ruoyi.stations_management.measurement.controller;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.measurement.domain.MeasurementSheet;
import com.ruoyi.stations_management.measurement.domain.MeterPrintingLog;
import com.ruoyi.stations_management.measurement.service.IMeasurementSheetService;
import com.ruoyi.stations_management.measurement.service.IMeterPrintingLogService;
import com.ruoyi.stations_management.measurement.service.impl.Sequence;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 计量单Controller
 *
 * @author lanzhenyuan
 * @date 2020-08-17
 */
@RestController
@RequestMapping("/measurement/sheet")
public class MeasurementSheetController extends BaseController {
    @Resource
    private IMeasurementSheetService measurementSheetService;
    @Resource
    private TokenService tokenService;
    @Resource
    private IMeterPrintingLogService meterPrintingLogService;
    @Resource
    private Sequence sequence;
    /**
     * 查询计量单列表
     */
    @PreAuthorize("@ss.hasPermi('measurement:sheet:list')")
    @GetMapping("/list")
    public TableDataInfo list(MeasurementSheet measurementSheet) {
        startPage();
        List<MeasurementSheet> list = measurementSheetService.selectMeasurementSheetList(measurementSheet);
        return getDataTable(list);
    }

    /**
     * 导出计量单列表
     */
    @PreAuthorize("@ss.hasPermi('measurement:sheet:export')")
    @Log(title = "计量单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MeasurementSheet measurementSheet) {
        List<MeasurementSheet> list = measurementSheetService.selectMeasurementSheetList(measurementSheet);
        ExcelUtil<MeasurementSheet> util = new ExcelUtil<MeasurementSheet>(MeasurementSheet.class);
        return util.exportExcel(list, "sheet");
    }

    /**
     * 获取计量单详细信息
     */
    @PreAuthorize("@ss.hasPermi('measurement:sheet:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(measurementSheetService.selectMeasurementSheetById(id));
    }

    /**
     * 新增计量单
     */
    @PreAuthorize("@ss.hasPermi('measurement:sheet:add')")
    @Log(title = "计量单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MeasurementSheet measurementSheet) {
        //获取当前登录人信息
        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        measurementSheet.setMeasurer(userName);
        // 获取计量单号
        System.out.println(sequence.getOrderNo("QH"));
        // 记录 打印日志
        Date nowDate = DateUtils.getNowDate();
        MeterPrintingLog meterPrintingLog = new MeterPrintingLog();
        meterPrintingLog.setMeasurementNum(measurementSheet.getMeasurementNum());
        meterPrintingLog.setCreateBy(userName);
        meterPrintingLog.setCreateTime(nowDate);
        meterPrintingLog.setPrintTime(nowDate);
        meterPrintingLogService.insertMeterPrintingLog(meterPrintingLog);
        return toAjax(measurementSheetService.insertMeasurementSheet(measurementSheet));
    }

    /**
     * 修改计量单
     */
    @PreAuthorize("@ss.hasPermi('measurement:sheet:edit')")
    @Log(title = "计量单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MeasurementSheet measurementSheet) {
        return toAjax(measurementSheetService.updateMeasurementSheet(measurementSheet));
    }

    /**
     * 删除计量单
     */
    @PreAuthorize("@ss.hasPermi('measurement:sheet:remove')")
    @Log(title = "计量单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(measurementSheetService.deleteMeasurementSheetByIds(ids));
    }
}
