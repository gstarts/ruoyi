package com.ruoyi.stations_management.monitor.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.monitor.domain.EquipmentInfo;
import com.ruoyi.stations_management.monitor.service.IEquipmentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 设备Controller
 *
 * @author qishuai
 * @date 2020-03-26
 */
@Api("设备")
@RestController
@RequestMapping("/setting")
public class EquipmentInfoController extends BaseController {
    @Autowired
    private IEquipmentInfoService equipmentInfoService;

    /**
     * 查询设备列表
     */
    @ApiOperation("查询设备列表")
    @ApiImplicitParam(name = "equipmentInfo", value = "查询设备列表", dataType = "EquipmentInfo")
    @PreAuthorize("@ss.hasPermi('monitor:info:list')")
    @GetMapping("/equipment/list")
    public TableDataInfo equipmentList(EquipmentInfo equipmentInfo) {
        startPage();
        List<EquipmentInfo> list = equipmentInfoService.selectEquipmentInfoList(equipmentInfo);
        return getDataTable(list);
    }

    /**
     * 导出设备列表
     *
     */
    @ApiOperation("导出设备列表")
    @ApiImplicitParam(name = "equipmentInfo", value = "导出设备列表", dataType = "EquipmentInfo")
    @PreAuthorize("@ss.hasPermi('monitor:info:export')")
    @Log(title = "设备", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(EquipmentInfo equipmentInfo) {
        List<EquipmentInfo> list = equipmentInfoService.selectEquipmentInfoList(equipmentInfo);
        ExcelUtil<EquipmentInfo> util = new ExcelUtil<>(EquipmentInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取设备详细信息
     *
     */
    @ApiOperation("获取设备详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('monitor:device:query')")
    @GetMapping(value = "/equipment/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(equipmentInfoService.selectEquipmentInfoById(id));
    }

    /**
     * 新增设备
     */
    @ApiOperation("新增设备")
    @ApiImplicitParam(name = "equipmentInfo", value = "新增设备", dataType = "EquipmentInfo")
    @PreAuthorize("@ss.hasPermi('monitor:device:add')")
    @Log(title = "设备 ", businessType = BusinessType.INSERT)
    @PostMapping("/equipment")
    public AjaxResult add(@RequestBody EquipmentInfo equipmentInfo) {
        return toAjax(equipmentInfoService.insertEquipmentInfo(equipmentInfo));
    }

    /**
     * 修改设备
     */
    @ApiOperation("修改设备")
    @ApiImplicitParam(name = "equipmentInfo", value = "修改设备", dataType = "EquipmentInfo")
    @PreAuthorize("@ss.hasPermi('monitor:device:edit')")
    @Log(title = "设备 ", businessType = BusinessType.UPDATE)
    @PutMapping("/equipment")
    public AjaxResult edit(@RequestBody EquipmentInfo equipmentInfo) {
        return toAjax(equipmentInfoService.updateEquipmentInfo(equipmentInfo));
    }

    /**
     * 删除设备
     */
    @ApiOperation("删除设备")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('monitor:device:remove')")
    @Log(title = "设备", businessType = BusinessType.DELETE)
    @DeleteMapping("/equipment/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(equipmentInfoService.deleteEquipmentInfoByIds(ids));
    }


    /**
     * 重启设备
     */
    @ApiOperation("重启设备")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('monitor:device:rstatr')")
    @Log(title = "重启", businessType = BusinessType.UPDATE)
    @GetMapping("/equipment/restart/{id}")
    public  AjaxResult restart(@PathVariable Long id){
        return toAjax(equipmentInfoService.restartEquipmentById(id));
    }
}
