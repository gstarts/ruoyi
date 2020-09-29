package com.ruoyi.stations_management.report.controller;

import java.util.List;

import com.ruoyi.stations_management.report.domain.Rmft4406Head;
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
import com.ruoyi.stations_management.report.domain.MtBorderTransport;
import com.ruoyi.stations_management.report.service.IMtBorderTransportService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 运输工具信息 Controller
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
@Api(tags = "运输工具信息")
@RestController
@RequestMapping("/report/transport")
public class MtBorderTransportController extends BaseController {
    @Autowired
    private IMtBorderTransportService mtBorderTransportService;

    /**
     * 查询运输工具信息 列表
     */
    @ApiOperation("查询运输工具信息 列表")
    @ApiImplicitParam(name = "mtBorderTransport", value = "查询运输工具信息", dataType = "MtBorderTransport")
    @PreAuthorize("@ss.hasPermi('report:transport:list')")
    @GetMapping("/list")
    public TableDataInfo list(MtBorderTransport mtBorderTransport) {
        startPage();
        List<MtBorderTransport> list = mtBorderTransportService.selectMtBorderTransportList(mtBorderTransport);
        return getDataTable(list);
    }

    /**
     * 查询异常车辆 列表
     *
     * @param rmft4406Head
     * @return
     */
    @ApiOperation("查询异常车辆 列表")
    @GetMapping("/Err")
    public TableDataInfo ErrList(Rmft4406Head rmft4406Head) {
        startPage();
        List<Rmft4406Head> ErrList = mtBorderTransportService.selectErrList(rmft4406Head);
        return getDataTable(ErrList);
    }

    /**
     * 导出运输工具信息 列表
     */
    @ApiOperation("导出大提煤单列表 列表")
    @ApiImplicitParam(name = "mtBorderTransport", value = "导出运输工具信息", dataType = "MtBorderTransport")
    @PreAuthorize("@ss.hasPermi('report:transport:export')")
    @Log(title = "运输工具信息 ", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MtBorderTransport mtBorderTransport) {
        List<MtBorderTransport> list = mtBorderTransportService.selectMtBorderTransportList(mtBorderTransport);
        ExcelUtil<MtBorderTransport> util = new ExcelUtil<MtBorderTransport>(MtBorderTransport.class);
        return util.exportExcel(list, "transport");
    }

    /**
     * 获取运输工具信息 详细信息
     */
    @ApiOperation("获取运输工具信息 详细信息")
    @ApiImplicitParam(name = "pId", value = "pId", required = true, dataType = "Long", paramType = "path")
    @PreAuthorize("@ss.hasPermi('report:transport:query')")
    @GetMapping(value = "/{pId}")
    public AjaxResult getInfo(@PathVariable("pId") Long pId) {
        return AjaxResult.success(mtBorderTransportService.selectMtBorderTransportById(pId));
    }

    /**
     * 新增运输工具信息
     */
    @ApiOperation("新增运输工具信息")
    @ApiImplicitParam(name = "mtBorderTransport", value = "新增运输工具信息", dataType = "MtBorderTransport")
    @PreAuthorize("@ss.hasPermi('report:transport:add')")
    @Log(title = "运输工具信息 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MtBorderTransport mtBorderTransport) {
        return toAjax(mtBorderTransportService.insertMtBorderTransport(mtBorderTransport));
    }

    /**
     * 修改运输工具信息
     */
    @ApiOperation("修改运输工具信息")
    @ApiImplicitParam(name = "mtBorderTransport", value = "修改运输工具信息", dataType = "MtBorderTransport")
    @PreAuthorize("@ss.hasPermi('report:transport:edit')")
    @Log(title = "运输工具信息 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MtBorderTransport mtBorderTransport) {
        return toAjax(mtBorderTransportService.updateMtBorderTransport(mtBorderTransport));
    }

    /**
     * 删除运输工具信息
     */
    @ApiOperation("删除运输工具信息")
    @ApiImplicitParam(name = "pIds", value = "pIds", required = true, dataType = "Long", paramType = "path")
    @PreAuthorize("@ss.hasPermi('report:transport:remove')")
    @Log(title = "运输工具信息 ", businessType = BusinessType.DELETE)
    @DeleteMapping("/{pIds}")
    public AjaxResult remove(@PathVariable Long[] pIds) {
        return toAjax(mtBorderTransportService.deleteMtBorderTransportByIds(pIds));
    }
}
