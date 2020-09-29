package com.ruoyi.stations_management.waybill.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.waybill.domain.CustomsClearance;
import com.ruoyi.stations_management.waybill.service.ICustomsClearanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 通关单Controller
 *
 * @author qishuai
 * @date 2020-02-25
 */
@Api("通关单")
@RestController
@RequestMapping("/waybill/customs")
public class CustomsClearanceController extends BaseController {
    @Autowired
    private ICustomsClearanceService sCustomsClearanceService;

    /**
     * 查询通关单列表
     */
    @ApiOperation("查询通关单列表")
    @ApiImplicitParam(name = "customsClearance", value = "查询通关单列表", dataType = "CustomsClearance")
    @PreAuthorize("@ss.hasPermi('waybill:customs:list')")
    @GetMapping("/list")
    public TableDataInfo list(CustomsClearance customsClearance) {
        startPage();
        List<CustomsClearance> list = sCustomsClearanceService.selectSCustomsClearanceList(customsClearance);
        return getDataTable(list);
    }

    /**
     * 导出通关单列表
     */
    @ApiOperation("导出通关单列表")
    @ApiImplicitParam(name = "customsClearance", value = "导出通关单列表", dataType = "CustomsClearance")
    @PreAuthorize("@ss.hasPermi('waybill:customs:export')")
    @Log(title = "通关单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CustomsClearance customsClearance) {
        List<CustomsClearance> list = sCustomsClearanceService.selectSCustomsClearanceList(customsClearance);
        ExcelUtil<CustomsClearance> util = new ExcelUtil<>(CustomsClearance.class);
        return util.exportExcel(list, "customs");
    }

    /**
     * 获取通关单详细信息
     */
    @ApiOperation("获取通关单详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('waybill:customs:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sCustomsClearanceService.selectSCustomsClearanceById(id));
    }

    /**
     * 新增通关单
     */
    @ApiOperation("新增通关单")
    @ApiImplicitParam(name = "customsClearance", value = "新增通关单", dataType = "CustomsClearance")
    @PreAuthorize("@ss.hasPermi('waybill:customs:add')")
    @Log(title = "通关单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CustomsClearance customsClearance) throws Exception {
        return toAjax(sCustomsClearanceService.insertSCustomsClearance(customsClearance));
    }


    /**
     * 修改通关单
     */
    @ApiOperation("修改通关单")
    @ApiImplicitParam(name = "customsClearance", value = "修改通关单", dataType = "CustomsClearance")
    @PreAuthorize("@ss.hasPermi('waybill:customs:edit')")
    @Log(title = "通关单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CustomsClearance customsClearance) {
        return toAjax(sCustomsClearanceService.updateSCustomsClearance(customsClearance));
    }

    /**
     * 删除通关单
     */
    @ApiOperation("删除通关单")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('waybill:customs:remove')")
    @Log(title = "通关单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sCustomsClearanceService.deleteSCustomsClearanceByIds(ids));
    }

    @ApiOperation("批量导入数据")
    @PreAuthorize("@ss.hasPermi('waybill:customs:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, int corporation) throws Exception {
        ExcelUtil<CustomsClearance> util = new ExcelUtil<>(CustomsClearance.class);
        List<CustomsClearance> sCustomsList = util.importExcel(file.getInputStream());
        String username = SecurityUtils.getUsername();
        String message = "";
        try {
            message = sCustomsClearanceService.importCustoms(sCustomsList, corporation, username);
        } catch (Exception e) {
            message = e.toString();
        }
        return AjaxResult.success(message);
    }

    /***
     * 下载模板
     * @return 结果
     */
    @ApiOperation("下载模板")
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<CustomsClearance> util = new ExcelUtil<>(CustomsClearance.class);
        return util.importTemplateExcel("通关单新增信息");
    }

}
