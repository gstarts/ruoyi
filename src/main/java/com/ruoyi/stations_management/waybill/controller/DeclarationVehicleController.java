package com.ruoyi.stations_management.waybill.controller;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.waybill.domain.DeclarationVehicle;
import com.ruoyi.stations_management.waybill.service.IDeclarationVehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 申报车辆Controller
 *
 * @author qishuai
 * @date 2020-03-01
 */
@Api("申报车辆")
@RestController
@RequestMapping("/waybill/vehicle")
public class DeclarationVehicleController extends BaseController
{
    @Autowired
    private IDeclarationVehicleService sDeclarationVehicleService;

    private TokenService tokenService;
    /**
     * 查询申报车辆列表
     */
    @ApiOperation("查询申报车辆列表")
    @ApiImplicitParam(name = "declarationVehicle", value = "查询申报车辆列表", dataType = "DeclarationVehicle")
    @PreAuthorize("@ss.hasPermi('waybill:vehicle:list')")
    @GetMapping("/list")
    public TableDataInfo list(DeclarationVehicle declarationVehicle)
    {
        startPage();
        List<DeclarationVehicle> list = sDeclarationVehicleService.selectSDeclarationVehicleList(declarationVehicle);
        return getDataTable(list);
    }

    /**
     * 导出申报车辆列表
     */
    @ApiOperation("导出申报车辆列表")
    @ApiImplicitParam(name = "declarationVehicle", value = "导出申报车辆列表", dataType = "DeclarationVehicle")
    @PreAuthorize("@ss.hasPermi('waybill:vehicle:export')")
    @Log(title = "申报车辆", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DeclarationVehicle declarationVehicle)
    {
        List<DeclarationVehicle> list = sDeclarationVehicleService.selectSDeclarationVehicleList(declarationVehicle);
        ExcelUtil<DeclarationVehicle> util = new ExcelUtil<DeclarationVehicle>(DeclarationVehicle.class);
        return util.exportExcel(list, "vehicle");
    }

    /**
     * 获取申报车辆详细信息
     */
    @ApiOperation("获取申报车辆详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('waybill:vehicle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sDeclarationVehicleService.selectSDeclarationVehicleById(id));
    }

    /**
     * 新增申报车辆
     */
    @ApiOperation("新增申报车辆")
    @ApiImplicitParam(name = "declarationVehicle", value = "新增申报车辆", dataType = "DeclarationVehicle")
    @PreAuthorize("@ss.hasPermi('waybill:vehicle:add')")
    @Log(title = "申报车辆", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DeclarationVehicle declarationVehicle)
    {
        return toAjax(sDeclarationVehicleService.insertSDeclarationVehicle(declarationVehicle));
    }

    /**
     * 修改申报车辆
     */
    @ApiOperation("修改申报车辆")
    @ApiImplicitParam(name = "declarationVehicle", value = "修改申报车辆", dataType = "DeclarationVehicle")
    @PreAuthorize("@ss.hasPermi('waybill:vehicle:edit')")
    @Log(title = "申报车辆", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DeclarationVehicle declarationVehicle)
    {
        return toAjax(sDeclarationVehicleService.updateSDeclarationVehicle(declarationVehicle));
    }

    /**
     * 删除申报车辆
     */
    @ApiOperation("删除申报车辆")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('waybill:vehicle:remove')")
    @Log(title = "申报车辆", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sDeclarationVehicleService.deleteSDeclarationVehicleByIds(ids));
    }
    @ApiOperation("导入数据")
    @PreAuthorize("@ss.hasPermi('waybill:vehicle:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, int corporation) throws Exception
    {
        ExcelUtil<DeclarationVehicle> util = new ExcelUtil<>(DeclarationVehicle.class);
        List<DeclarationVehicle> vehicleList = util.importExcel(file.getInputStream());
        String username = SecurityUtils.getUsername();
        String message = sDeclarationVehicleService.importVehicle(vehicleList, corporation, username);
        return AjaxResult.success(message);
    }

    /***
     * 下载模板
     * @return
     */
    @ApiOperation("下载模板")
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<DeclarationVehicle> util = new ExcelUtil<>(DeclarationVehicle.class);
        return util.importTemplateExcel("货运车辆导入");
    }

}
