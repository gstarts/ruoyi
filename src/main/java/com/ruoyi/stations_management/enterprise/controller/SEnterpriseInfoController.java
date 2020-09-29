package com.ruoyi.stations_management.enterprise.controller;

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
import com.ruoyi.stations_management.enterprise.domain.SEnterpriseInfo;
import com.ruoyi.stations_management.enterprise.service.ISEnterpriseInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 企业信息备案Controller
 * 
 * @author qishuai
 * @date 2020-01-02
 */
@RestController
@RequestMapping("/enterprise/record")
@Api("企业信息备案管理")
public class SEnterpriseInfoController extends BaseController
{
    @Autowired
    private ISEnterpriseInfoService sEnterpriseInfoService;

    /**
     * 查询企业信息备案列表
     */
    @ApiOperation("查询企业信息备案列表")
    @PreAuthorize("@ss.hasPermi('enterprise:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(SEnterpriseInfo sEnterpriseInfo)
    {
        startPage();
        List<SEnterpriseInfo> list = sEnterpriseInfoService.selectSEnterpriseInfoList(sEnterpriseInfo);
        return getDataTable(list);
    }

    /**
     * 导出企业信息备案列表
     */
    @ApiOperation("导出企业信息备案列表")
    @PreAuthorize("@ss.hasPermi('enterprise:record:export')")
    @Log(title = "企业信息备案", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SEnterpriseInfo sEnterpriseInfo)
    {
        List<SEnterpriseInfo> list = sEnterpriseInfoService.selectSEnterpriseInfoList(sEnterpriseInfo);
        ExcelUtil<SEnterpriseInfo> util = new ExcelUtil<>(SEnterpriseInfo.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 获取企业信息备案详细信息
     */
    @ApiOperation("获取企业信息备案详细信息")
    @ApiImplicitParam(name = "id", value = "企业ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('enterprise:record:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sEnterpriseInfoService.selectSEnterpriseInfoById(id));
    }

    /**
     * 新增企业信息备案
     */
    @ApiOperation("新增企业信息备案")
    @ApiImplicitParam(name = "sEnterpriseInfo", value = "新增企业信息备案", dataType = "SEnterpriseInfo")
    @PreAuthorize("@ss.hasPermi('enterprise:record:add')")
    @Log(title = "企业信息备案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SEnterpriseInfo sEnterpriseInfo)
    {
        return toAjax(sEnterpriseInfoService.insertSEnterpriseInfo(sEnterpriseInfo));
    }

    /**
     * 修改企业信息备案
     */
    @ApiOperation("修改企业信息备案")
    @ApiImplicitParam(name = "sEnterpriseInfo", value = "修改企业信息备案", dataType = "SEnterpriseInfo")
    @PreAuthorize("@ss.hasPermi('enterprise:record:edit')")
    @Log(title = "企业信息备案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SEnterpriseInfo sEnterpriseInfo)
    {
        return toAjax(sEnterpriseInfoService.updateSEnterpriseInfo(sEnterpriseInfo));
    }

    /**
     * 删除企业信息备案
     */
    @ApiOperation("删除企业信息备案")
    @ApiImplicitParam(name = "ids", value = "企业ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('enterprise:record:remove')")
    @Log(title = "企业信息备案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sEnterpriseInfoService.deleteSEnterpriseInfoByIds(ids));
    }
}
