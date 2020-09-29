package com.ruoyi.stations_management.depot.controller;

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
import com.ruoyi.stations_management.depot.domain.SWarehouseInfo;
import com.ruoyi.stations_management.depot.service.ISWarehouseInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 仓库管理Controller
 *
 * @author qishuai
 * @date 2020-01-01
 */
@Api("仓库管理")
@RestController
@RequestMapping("/depot/management")
public class SWarehouseInfoController extends BaseController
{
    @Autowired
    private ISWarehouseInfoService sWarehouseInfoService;

    @ApiOperation("查询仓库名称列表")
    @GetMapping("/deoptNamelist")
    public TableDataInfo deoptNamelist(){
        startPage();
        List<Map<String,String>> list = sWarehouseInfoService.selectDeoptNameList();
        return getDataTable(list);
    }

    /**
     * 查询仓库管理列表
     */
    @ApiOperation("查询仓库管理列表")
    @PreAuthorize("@ss.hasPermi('depot:management:list')")
    @GetMapping("/list")
    public TableDataInfo list(SWarehouseInfo sWarehouseInfo)
    {
        startPage();
        List<SWarehouseInfo> list = sWarehouseInfoService.selectSWarehouseInfoList(sWarehouseInfo);
        return getDataTable(list);
    }

    /**
     * 导出仓库管理列表
     */
    @ApiOperation("导出仓库名称列表")
    @PreAuthorize("@ss.hasPermi('depot:management:export')")
    @Log(title = "仓库管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SWarehouseInfo sWarehouseInfo)
    {
        List<SWarehouseInfo> list = sWarehouseInfoService.selectSWarehouseInfoList(sWarehouseInfo);
        ExcelUtil<SWarehouseInfo> util = new ExcelUtil<>(SWarehouseInfo.class);
        return util.exportExcel(list, "management");
    }

    /**
     * 获取仓库管理详细信息
     */
    @ApiOperation("获取仓库管理详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('depot:management:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sWarehouseInfoService.selectSWarehouseInfoById(id));
    }

    /**
     * 新增仓库管理
     */
    @ApiOperation("新增仓库管理")
    @ApiImplicitParam(name = "sWarehouseInfo", value = "新增用户信息", dataType = "SWarehouseInfo")
    @PreAuthorize("@ss.hasPermi('depot:management:add')")
    @Log(title = "仓库管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SWarehouseInfo sWarehouseInfo)
    {
        return toAjax(sWarehouseInfoService.insertSWarehouseInfo(sWarehouseInfo));
    }

    /**
     * 修改仓库管理
     */
    @ApiOperation("修改仓库管理")
    @ApiImplicitParam(name = "sWarehouseInfo", value = "新增用户信息", dataType = "SWarehouseInfo")
    @PreAuthorize("@ss.hasPermi('depot:management:edit')")
    @Log(title = "仓库管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SWarehouseInfo sWarehouseInfo)
    {
        return toAjax(sWarehouseInfoService.updateSWarehouseInfo(sWarehouseInfo));
    }

    /**
     * 删除仓库管理
     */
    @ApiOperation("删除仓库管理")
    @ApiImplicitParam(name = "id", value = "仓库ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('depot:management:remove')")
    @Log(title = "仓库管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sWarehouseInfoService.deleteSWarehouseInfoByIds(ids));
    }
}
