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
import com.ruoyi.stations_management.depot.domain.SGoodsInfos;
import com.ruoyi.stations_management.depot.service.ISGoodsInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 仓库货物Controller
 *
 * @author qishuai
 * @date 2020-01-01
 */
@Api("仓库货物")
@RestController
@RequestMapping("/depot/goods")
public class SGoodsInfoController extends BaseController
{
    @Autowired
    private ISGoodsInfoService sGoodsInfoService;

    /**
     * 查询仓库货物列表
     */
    @ApiOperation("获取仓库货物列表")
    @PreAuthorize("@ss.hasPermi('depot:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(SGoodsInfos sGoodsInfos)
    {
        startPage();
        List<SGoodsInfos> list = sGoodsInfoService.selectSGoodsInfoList(sGoodsInfos);
        return getDataTable(list);
    }

    /**
     * 导出仓库货物列表
     */
    @ApiOperation("导出仓库货物列表")
    @PreAuthorize("@ss.hasPermi('depot:goods:export')")
    @Log(title = "仓库货物", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SGoodsInfos sGoodsInfos)
    {
        List<SGoodsInfos> list = sGoodsInfoService.selectSGoodsInfoList(sGoodsInfos);
        ExcelUtil<SGoodsInfos> util = new ExcelUtil<>(SGoodsInfos.class);
        return util.exportExcel(list, "goods");
    }

    /**
     * 获取仓库货物详细信息
     */
    @ApiOperation("获取仓库货物详细信息")
    @ApiImplicitParam(name = "Id", value = "货物ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('depot:goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sGoodsInfoService.selectSGoodsInfoById(id));
    }

    /**
     * 新增仓库货物
     */
    @ApiOperation("新增仓库货物")
    @ApiImplicitParam(name = "sGoodsInfo", value = "新增仓库货物", dataType = "SGoodsInfo")
    @PreAuthorize("@ss.hasPermi('depot:goods:add')")
    @Log(title = "仓库货物", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SGoodsInfos sGoodsInfos)
    {
        return toAjax(sGoodsInfoService.insertSGoodsInfo(sGoodsInfos));
    }

    /**
     * 修改仓库货物
     */
    @ApiOperation("修改仓库货物")
    @ApiImplicitParam(name = "sGoodsInfo", value = "修改仓库货物", dataType = "SGoodsInfo")
    @PreAuthorize("@ss.hasPermi('depot:goods:edit')")
    @Log(title = "仓库货物", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SGoodsInfos sGoodsInfos)
    {
        return toAjax(sGoodsInfoService.updateSGoodsInfo(sGoodsInfos));
    }

    /**
     * 删除仓库货物
     */
    @ApiOperation("删除仓库货物")
    @ApiImplicitParam(name = "Id", value = "货物ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('depot:goods:remove')")
    @Log(title = "仓库货物", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sGoodsInfoService.deleteSGoodsInfoByIds(ids));
    }
}
