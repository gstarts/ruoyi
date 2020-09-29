package com.ruoyi.stations_management.emptycar.controller;

import java.util.List;

import com.ruoyi.stations_management.report.domain.MtBorderTransport;
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
import com.ruoyi.stations_management.emptycar.domain.IMtBorderTransport06;
import com.ruoyi.stations_management.emptycar.service.IIMtBorderTransport06Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 运输工具信息 Controller
 *
 * @author songqingchuan
 * @date 2020-06-15
 */
@Api(tags = "运输工具信息")
@RestController
@RequestMapping("/emptycar/06")
public class IMtBorderTransport06Controller extends BaseController {
    @Autowired
    private IIMtBorderTransport06Service iMtBorderTransport06Service;

    /**
     * 查询运输工具信息 列表
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:list')")
    @GetMapping("/list")
    public TableDataInfo list(IMtBorderTransport06 iMtBorderTransport06) {
        startPage();
        List<IMtBorderTransport06> list = iMtBorderTransport06Service.selectIMtBorderTransport06List(iMtBorderTransport06);
        return getDataTable(list);
    }

    /**
     * 查询异常车辆 列表
     *
     * @param iMtBorderTransport06
     * @return
     */
    @ApiOperation("查询异常车辆 列表")
    @ApiImplicitParam(name = "iMtBorderTransport06", value = "查询异常车辆", dataType = "IMtBorderTransport06")
    @GetMapping("/Err")
    public TableDataInfo ErrList(IMtBorderTransport06 iMtBorderTransport06) {
        startPage();
        List<IMtBorderTransport06> ErrList = iMtBorderTransport06Service.selectErrList(iMtBorderTransport06);
        return getDataTable(ErrList);
    }

    /**
     * 导出运输工具信息 列表
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:export')")
    @Log(title = "运输工具信息 ", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(IMtBorderTransport06 iMtBorderTransport06) {
        List<IMtBorderTransport06> list = iMtBorderTransport06Service.selectIMtBorderTransport06List(iMtBorderTransport06);
        ExcelUtil<IMtBorderTransport06> util = new ExcelUtil<IMtBorderTransport06>(IMtBorderTransport06.class);
        return util.exportExcel(list, "06");
    }

    /**
     * 获取运输工具信息 详细信息
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:query')")
    @GetMapping(value = "/{key}")
    public AjaxResult getInfo(@PathVariable("key") Long key) {
        return AjaxResult.success(iMtBorderTransport06Service.selectIMtBorderTransport06ById(key));
    }

    /**
     * 新增运输工具信息
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:add')")
    @Log(title = "运输工具信息 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IMtBorderTransport06 iMtBorderTransport06) {
        return toAjax(iMtBorderTransport06Service.insertIMtBorderTransport06(iMtBorderTransport06));
    }

    /**
     * 修改运输工具信息
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:edit')")
    @Log(title = "运输工具信息 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IMtBorderTransport06 iMtBorderTransport06) {
        return toAjax(iMtBorderTransport06Service.updateIMtBorderTransport06(iMtBorderTransport06));
    }

    /**
     * 删除运输工具信息
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:remove')")
    @Log(title = "运输工具信息 ", businessType = BusinessType.DELETE)
    @DeleteMapping("/{keys}")
    public AjaxResult remove(@PathVariable Long[] keys) {
        return toAjax(iMtBorderTransport06Service.deleteIMtBorderTransport06ByIds(keys));
    }
}
