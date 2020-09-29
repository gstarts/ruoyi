package com.ruoyi.stations_management.monitor.controller;

import java.util.List;
import java.util.Map;

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
import com.ruoyi.stations_management.monitor.domain.SStationInfo;
import com.ruoyi.stations_management.monitor.service.ISStationInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 场站管理Controller
 * 
 * @author qishuai
 * @date 2020-06-11
 */
@Api("场站管理")
@RestController
@RequestMapping("/monitor/info")
public class SStationInfoController extends BaseController
{
    @Autowired
    private ISStationInfoService sStationInfoService;

    /**
     * 查询场站管理列表
     */
    @ApiOperation("查询场站名称列表")
    @PreAuthorize("@ss.hasPermi('monitor:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(SStationInfo sStationInfo)
    {
        startPage();
        List<SStationInfo> list = sStationInfoService.selectSStationInfoList(sStationInfo);
        return getDataTable(list);
    }

    /**
     * 导出场站管理列表
     */
    @ApiOperation("查询场站名称列表")
    @PreAuthorize("@ss.hasPermi('monitor:info:export')")
    @Log(title = "场站管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SStationInfo sStationInfo)
    {
        List<SStationInfo> list = sStationInfoService.selectSStationInfoList(sStationInfo);
        ExcelUtil<SStationInfo> util = new ExcelUtil<SStationInfo>(SStationInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取产站管理详细信息
     */
    @ApiOperation("获取场站详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('monitor:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sStationInfoService.selectSStationInfoById(id));
    }

    /**
     * 新增场站管理
     */
    @ApiOperation("新增场站管理")
    @ApiImplicitParam(name = "sStationInfo", value = "新增场站信息", dataType = "SStationInfo")
    @PreAuthorize("@ss.hasPermi('monitor:info:add')")
    @Log(title = "场站管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SStationInfo sStationInfo)
    {
        return toAjax(sStationInfoService.insertSStationInfo(sStationInfo));
    }


    /**
     * 修改【请填写功能名称】
     */
    @ApiOperation("修改场站信息")
    @ApiImplicitParam(name = "sStationInfo", value = "新增场站信息", dataType = "SStationInfo")
    @PreAuthorize("@ss.hasPermi('monitor:info:update')")
    @Log(title = "场站管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SStationInfo sStationInfo)
    {
        return toAjax(sStationInfoService.updateSStationInfo(sStationInfo));
    }

    /**
     * 删除【请填写功能名称】
     */
    @ApiOperation("删除场站信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('monitor:info:del')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sStationInfoService.deleteSStationInfoByIds(ids));
    }
}
