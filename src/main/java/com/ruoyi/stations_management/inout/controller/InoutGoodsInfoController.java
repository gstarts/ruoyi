package com.ruoyi.stations_management.inout.controller;

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
import com.ruoyi.stations_management.inout.domain.InoutGoodsInfo;
import com.ruoyi.stations_management.inout.service.IInoutGoodsInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 进出场货物Controller
 * 
 * @author qishuai
 * @date 2020-01-02
 */
@Api("进出场货物")
@RestController
@RequestMapping("/inout/goods")
public class InoutGoodsInfoController extends BaseController
{
    @Autowired
    private IInoutGoodsInfoService inoutGoodsInfoService;

    /**
     * 查询进出场货物列表
     */
    @ApiOperation("查询进出场货物列表")
    @ApiImplicitParam(name = "inoutGoodsInfo", value = "查询进出场货物列表", dataType = "InoutGoodsInfo")
    @PreAuthorize("@ss.hasPermi('inout:goods:list')")
    @GetMapping("/list")
    public TableDataInfo list(InoutGoodsInfo inoutGoodsInfo)
    {
        startPage();
        List<InoutGoodsInfo> list = inoutGoodsInfoService.selectInoutGoodsInfoList(inoutGoodsInfo);
        return getDataTable(list);
    }

    /**
     * 导出进出场货物列表
     */
    @ApiOperation("查询进出场货物列表")
    @ApiImplicitParam(name = "inoutGoodsInfo", value = "导出进出场货物列表", dataType = "InoutGoodsInfo")
    @PreAuthorize("@ss.hasPermi('inout:goods:export')")
    @Log(title = "进出场货物", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(InoutGoodsInfo inoutGoodsInfo)
    {
        List<InoutGoodsInfo> list = inoutGoodsInfoService.selectInoutGoodsInfoList(inoutGoodsInfo);
        ExcelUtil<InoutGoodsInfo> util = new ExcelUtil<>(InoutGoodsInfo.class);
        return util.exportExcel(list, "goods");
    }

    /**
     * 获取进出场货物详细信息
     */
    @ApiOperation("获取进出场货物详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('inout:goods:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(inoutGoodsInfoService.selectInoutGoodsInfoById(id));
    }

    /**
     * 新增进出场货物
     */
    @ApiOperation("新增进出场货物")
    @ApiImplicitParam(name = "inoutGoodsInfo", value = "新增进出场货物", dataType = "InoutGoodsInfo")
    @PreAuthorize("@ss.hasPermi('inout:goods:add')")
    @Log(title = "进出场货物", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InoutGoodsInfo inoutGoodsInfo)
    {
        return toAjax(inoutGoodsInfoService.insertInoutGoodsInfo(inoutGoodsInfo));
    }

    /**
     * 修改进出场货物
     */
    @ApiOperation("修改进出场货物")
    @ApiImplicitParam(name = "inoutGoodsInfo", value = "修改进出场货物", dataType = "InoutGoodsInfo")
    @PreAuthorize("@ss.hasPermi('inout:goods:edit')")
    @Log(title = "进出场货物", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InoutGoodsInfo inoutGoodsInfo)
    {
        return toAjax(inoutGoodsInfoService.updateInoutGoodsInfo(inoutGoodsInfo));
    }

    /**
     * 删除进出场货物
     */
    @ApiOperation("删除进出场货物")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('inout:goods:remove')")
    @Log(title = "进出场货物", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(inoutGoodsInfoService.deleteInoutGoodsInfoByIds(ids));
    }

    /**
     * 同意申请
     */
    @ApiOperation("同意申请")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('inout:goods:consentApply')")
    @Log(title = "进出场货物")
    @GetMapping("/consentApply/{id}")
    public AjaxResult consentApply(@PathVariable Long id)
    {
        return toAjax(inoutGoodsInfoService.consentApply(id));
    }

    /**
     * 撤销同意申请
     */
    @ApiOperation("撤销同意申请")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('inout:goods:cancellationApply')")
    @Log(title = "进出场货物")
    @GetMapping("/cancellationApply/{id}")
    public AjaxResult cancellationApply(@PathVariable Long id)
    {
        return toAjax(inoutGoodsInfoService.cancellationApply(id));
    }
}
