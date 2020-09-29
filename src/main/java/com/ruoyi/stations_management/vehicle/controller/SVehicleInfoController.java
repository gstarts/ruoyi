package com.ruoyi.stations_management.vehicle.controller;

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
import com.ruoyi.stations_management.vehicle.domain.SVehicleInfo;
import com.ruoyi.stations_management.vehicle.service.ISVehicleInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 车辆备案Controller
 *
 * @author qishuai
 * @date 2020-01-01
 */
@Api("车辆备案管理")
@RestController
@RequestMapping("/vehicle/record")
public class SVehicleInfoController extends BaseController
{
    @Autowired
    private ISVehicleInfoService sVehicleInfoService;


    /**
     * 查询车牌号列表
     */
    @ApiOperation("查询车牌号列表")
    @GetMapping("/licenselist")
    public TableDataInfo licenselist(){
        startPage();
        List<Map<String,String>> list = sVehicleInfoService.selectLicenseList();
        return getDataTable(list);
    }


    /**
     * 查询车辆备案列表
     */
    @ApiOperation("查询车辆备案列表")
    @ApiImplicitParam(name = "sVehicleInfo", value = "查询车辆备案列表", dataType = "SVehicleInfo")
    @PreAuthorize("@ss.hasPermi('vehicle:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(SVehicleInfo sVehicleInfo)
    {
        startPage();
        List<SVehicleInfo> list = sVehicleInfoService.selectSVehicleInfoList(sVehicleInfo);
        return getDataTable(list);
    }

    /**
     * 导出车辆备案列表
     */
    @ApiOperation("导出车辆备案列表")
    @ApiImplicitParam(name = "sVehicleInfo", value = "导出车辆备案列表", dataType = "SVehicleInfo")
    @PreAuthorize("@ss.hasPermi('vehicle:record:export')")
    @Log(title = "车辆备案", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SVehicleInfo sVehicleInfo)
    {
        List<SVehicleInfo> list = sVehicleInfoService.selectSVehicleInfoList(sVehicleInfo);
        ExcelUtil<SVehicleInfo> util = new ExcelUtil<>(SVehicleInfo.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 获取车辆备案详细信息
     */
    @ApiOperation("获取车辆备案详细信息")
    @ApiImplicitParam(name = "Id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('vehicle:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sVehicleInfoService.selectSVehicleInfoById(id));
    }

    /**
     * 新增车辆备案
     */
    @ApiOperation("新增车辆备案")
    @ApiImplicitParam(name = "sVehicleInfo", value = "新增车辆备案", dataType = "SVehicleInfo")
    @PreAuthorize("@ss.hasPermi('vehicle:record:add')")
    @Log(title = "车辆备案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SVehicleInfo sVehicleInfo)
    {
        return toAjax(sVehicleInfoService.insertSVehicleInfo(sVehicleInfo));
    }

    /**
     * 修改车辆备案
     */
    @ApiOperation("修改车辆备案")
    @ApiImplicitParam(name = "sVehicleInfo", value = "修改车辆备案", dataType = "SVehicleInfo")
    @PreAuthorize("@ss.hasPermi('vehicle:record:edit')")
    @Log(title = "车辆备案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SVehicleInfo sVehicleInfo)
    {
        return toAjax(sVehicleInfoService.updateSVehicleInfo(sVehicleInfo));
    }

    /**
     * 删除车辆备案
     */
    @ApiOperation("删除车辆备案")
    @ApiImplicitParam(name = "Ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('vehicle:record:remove')")
    @Log(title = "车辆备案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sVehicleInfoService.deleteSVehicleInfoByIds(ids));
    }



    /**
     * 绑定IC卡
     */
    @ApiOperation("绑定IC卡")
    @ApiImplicitParam(name = "sVehicleInfo", value = "绑定IC卡", dataType = "SVehicleInfo")
    @Log(title = "绑定IC卡")
    @PutMapping("/bind")
    public AjaxResult bind(@RequestBody SVehicleInfo sVehicleInfo)
    {
        System.out.println(sVehicleInfo);
        return toAjax(sVehicleInfoService.bindSVehicleInfo(sVehicleInfo));
    }

    /**
     * 解除绑定的IC卡
     */
    @ApiOperation("解除绑定的IC卡")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @Log(title = "解除绑定IC卡")
    @GetMapping("/unite/{id}")
    public AjaxResult unite( @PathVariable Long id)
    {
        System.out.println("参数时什么"+id);
        return toAjax(sVehicleInfoService.uniteSVehicleInfo(id));
    }
}
