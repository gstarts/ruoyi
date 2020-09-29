package com.ruoyi.stations_management.depot.controller;

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
import com.ruoyi.stations_management.depot.domain.SWarehouseContract;
import com.ruoyi.stations_management.depot.service.ISWarehouseContractService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 仓库合同Controller
 * 
 * @author qishuai
 * @date 2020-01-04
 */
@Api("仓库合同管理")
@RestController
@RequestMapping("/depot/contract")
public class SWarehouseContractController extends BaseController
{
    @Autowired
    private ISWarehouseContractService sWarehouseContractService;

    /**
     * 查询仓库合同列表
     */
    @ApiOperation("查询仓库合同列表")
    @PreAuthorize("@ss.hasPermi('depot:contract:list')")
    @GetMapping("/list")
    public TableDataInfo list(SWarehouseContract sWarehouseContract)
    {
        startPage();
        List<SWarehouseContract> list = sWarehouseContractService.selectSWarehouseContractList(sWarehouseContract);
        return getDataTable(list);
    }

    /**
     * 导出仓库合同列表
     */
    @ApiOperation("导出仓库合同列表")
    @PreAuthorize("@ss.hasPermi('depot:contract:export')")
    @Log(title = "仓库合同", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SWarehouseContract sWarehouseContract)
    {
        List<SWarehouseContract> list = sWarehouseContractService.selectSWarehouseContractList(sWarehouseContract);
        ExcelUtil<SWarehouseContract> util = new ExcelUtil<>(SWarehouseContract.class);
        return util.exportExcel(list, "contract");
    }

    /**
     * 获取仓库合同详细信息
     */
    @ApiOperation("获取仓库合同详细信息")
    @PreAuthorize("@ss.hasPermi('depot:contract:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sWarehouseContractService.selectSWarehouseContractById(id));
    }

    /**
     * 新增仓库合同
     */
    @ApiOperation("新增仓库合同")
    @ApiImplicitParam(name = "sWarehouseContract", value = "新增仓库合同", dataType = "SWarehouseContract")
    @PreAuthorize("@ss.hasPermi('depot:contract:add')")
    @Log(title = "仓库合同", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SWarehouseContract sWarehouseContract)
    {
        return toAjax(sWarehouseContractService.insertSWarehouseContract(sWarehouseContract));
    }

    /**
     * 修改仓库合同
     */@ApiOperation("修改仓库合同")
    @ApiImplicitParam(name = "sWarehouseContract", value = "修改仓库合同", dataType = "SWarehouseContract")
    @PreAuthorize("@ss.hasPermi('depot:contract:edit')")
    @Log(title = "仓库合同", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SWarehouseContract sWarehouseContract)
    {
        return toAjax(sWarehouseContractService.updateSWarehouseContract(sWarehouseContract));
    }

    /**
     * 删除仓库合同
     */
    @ApiOperation("删除仓库合同")
    @ApiImplicitParam(name = "id", value = "合同ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('depot:contract:remove')")
    @Log(title = "仓库合同", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sWarehouseContractService.deleteSWarehouseContractByIds(ids));
    }
}
