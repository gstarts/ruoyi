package com.ruoyi.stations_management.common.controller;

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
import com.ruoyi.stations_management.common.domain.StationInfo;
import com.ruoyi.stations_management.common.service.IStationInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 场站的基本信息 Controller
 *
 * @author qishuai
 * @date 2020-03-27
 */
@Api(tags = "场站的基本信息")
@RestController
@RequestMapping("/station/common")
public class StationInfoController extends BaseController
{
    @Autowired
    private IStationInfoService stationInfoService;

    /**
     * 查询场站的基本信息列表
     */
    @ApiOperation("查询场站的基本信息列表")
    @ApiImplicitParam(name = "stationInfo",value = "查询场站的基本信息列表",dataType = "StationInfo")
    @GetMapping("/list")
    public TableDataInfo list(StationInfo stationInfo)
    {
        startPage();
        List<StationInfo> list = stationInfoService.selectStationInfoList(stationInfo);
        return getDataTable(list);
    }

    /**
     * 导出场站的基本信息列表
     */
    @ApiOperation("导出场站的基本信息列表")
    @ApiImplicitParam(name = "stationInfo",value = "导出场站的基本信息列表",dataType = "StationInfo")
    @PreAuthorize("@ss.hasPermi('common:info:export')")
    @Log(title = "场站的基本信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(StationInfo stationInfo)
    {
        List<StationInfo> list = stationInfoService.selectStationInfoList(stationInfo);
        ExcelUtil<StationInfo> util = new ExcelUtil<>(StationInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取场站的基本信息详细信息
     */
    @ApiOperation("获取场站的基本信息详细信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "path")
    @PreAuthorize("@ss.hasPermi('common:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(stationInfoService.selectStationInfoById(id));
    }

    /**
     * 新增场站的基本信息
     */
    @ApiOperation("新增场站的基本信息")
    @ApiImplicitParam(name = "stationInfo",value = "新增场站的基本信息",dataType = "StationInfo")
    @PreAuthorize("@ss.hasPermi('common:info:add')")
    @Log(title = "场站的基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StationInfo stationInfo)
    {
        return toAjax(stationInfoService.insertStationInfo(stationInfo));
    }

    /**
     * 修改场站的基本信息
     */
    @ApiOperation("修改场站的基本信息")
    @ApiImplicitParam(name = "stationInfo",value = "修改场站的基本信息",dataType = "StationInfo")
    @PreAuthorize("@ss.hasPermi('common:info:edit')")
    @Log(title = "场站的基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StationInfo stationInfo)
    {
        return toAjax(stationInfoService.updateStationInfo(stationInfo));
    }

    /**
     * 删除场站的基本信息
     */
    @ApiOperation("删除场站的基本信息")
    @ApiImplicitParam(name = "ids", value = "ids", required = true, dataType = "Long", paramType = "path")
    @PreAuthorize("@ss.hasPermi('common:info:remove')")
    @Log(title = "场站的基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stationInfoService.deleteStationInfoByIds(ids));
    }
}
