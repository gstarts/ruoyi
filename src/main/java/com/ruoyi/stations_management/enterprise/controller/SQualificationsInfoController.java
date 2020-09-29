package com.ruoyi.stations_management.enterprise.controller;

import java.util.List;
import java.util.Map;

import com.ruoyi.stations_management.declare.domain.ContainerBody;
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
import com.ruoyi.stations_management.enterprise.domain.SQualificationsInfo;
import com.ruoyi.stations_management.enterprise.service.ISQualificationsInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 企业资质管理Controller
 *
 * @author qishuai
 * @date 2020-01-02
 */
@Api("企业资质管理")
@RestController
@RequestMapping("/enterprise/qualification")
public class SQualificationsInfoController extends BaseController
{
    @Autowired
    private ISQualificationsInfoService sQualificationsInfoService;

    /**
     * 查询备案公司列表
     */
    @ApiOperation("获取备案公司列表")
    @GetMapping("/data/list")
    public TableDataInfo companyList()
    {
        startPage();
        List<Map<String,String>> list = sQualificationsInfoService.selectRecordCompanyList();
        return getDataTable(list);
    }

    /**
     * 查询企业资质管理列表
     */
    @ApiOperation("查询企业资质管理列表")
    @PreAuthorize("@ss.hasPermi('enterprise:qualification:list')")
    @GetMapping("/list")
    public TableDataInfo list(SQualificationsInfo sQualificationsInfo)
    {
        startPage();
        List<SQualificationsInfo> list = sQualificationsInfoService.selectSQualificationsInfoList(sQualificationsInfo);
        return getDataTable(list);
    }

    /**
     * 导出企业资质管理列表
     */
    @ApiOperation("导出企业资质管理列表")
    @PreAuthorize("@ss.hasPermi('enterprise:qualification:export')")
    @Log(title = "企业资质管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SQualificationsInfo sQualificationsInfo)
    {
        List<SQualificationsInfo> list = sQualificationsInfoService.selectSQualificationsInfoList(sQualificationsInfo);
        ExcelUtil<SQualificationsInfo> util = new ExcelUtil<SQualificationsInfo>(SQualificationsInfo.class);
        return util.exportExcel(list, "qualification");
    }

    /**
     * 获取企业资质管理详细信息
     */
    @ApiOperation("获取企业资质管理详细信息")
    @ApiImplicitParam(name = "id", value = "企业资质ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('enterprise:qualification:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sQualificationsInfoService.selectSQualificationsInfoById(id));
    }

    /**
     * 新增企业资质管理
     */
    @ApiOperation("新增企业资质管理")
    @ApiImplicitParam(name = "sQualificationsInfo", value = "新增企业资质管理", dataType = "SQualificationsInfo")
    @PreAuthorize("@ss.hasPermi('enterprise:qualification:add')")
    @Log(title = "企业资质管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SQualificationsInfo sQualificationsInfo)
    {
        return toAjax(sQualificationsInfoService.insertSQualificationsInfo(sQualificationsInfo));
    }

    /**
     * 修改企业资质管理
     */
    @ApiOperation("修改企业资质管理")
    @ApiImplicitParam(name = "sQualificationsInfo", value = "修改企业资质管理", dataType = "SQualificationsInfo")
    @PreAuthorize("@ss.hasPermi('enterprise:qualification:edit')")
    @Log(title = "企业资质管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SQualificationsInfo sQualificationsInfo)
    {
        return toAjax(sQualificationsInfoService.updateSQualificationsInfo(sQualificationsInfo));
    }

    /**
     * 删除企业资质管理
     */
    @ApiOperation("删除企业资质管理")
    @ApiImplicitParam(name = "ids", value = "企业资质ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('enterprise:qualification:remove')")
    @Log(title = "企业资质管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sQualificationsInfoService.deleteSQualificationsInfoByIds(ids));
    }

    /***
     * 下载模板
     * @return
     */
    @ApiOperation("下载模板")
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<SQualificationsInfo> util = new ExcelUtil<>(SQualificationsInfo.class);
        return util.importTemplateExcel("通关单新增信息");
    }
}
