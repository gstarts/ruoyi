package com.ruoyi.stations_management.mt.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.mt.domain.BorderTransportMeans;
import com.ruoyi.stations_management.mt.service.IBorderTransportMeansService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 驾驶员信息Controller
 * 
 * @author songqingchuan
 * @date 2020-07-27
 */
@RestController
@RequestMapping("/newemptycar/bordertransportmeans")
public class BorderTransportMeansController extends BaseController
{
    @Resource
    private IBorderTransportMeansService borderTransportMeansService;

    /**
     * 查询驾驶员信息列表
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportmeans:list')")
    @GetMapping("/list")
    public TableDataInfo list(BorderTransportMeans borderTransportMeans)
    {
        startPage();
        List<BorderTransportMeans> list = borderTransportMeansService.selectBorderTransportMeansList(borderTransportMeans);
        return getDataTable(list);
    }

    /**
     * 导出驾驶员信息列表
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportmeans:export')")
    @Log(title = "驾驶员信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BorderTransportMeans borderTransportMeans)
    {
        List<BorderTransportMeans> list = borderTransportMeansService.selectBorderTransportMeansList(borderTransportMeans);
        ExcelUtil<BorderTransportMeans> util = new ExcelUtil<>(BorderTransportMeans.class);
        return util.exportExcel(list, "bordertransportmeans");
    }

    /**
     * 获取驾驶员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportmeans:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(borderTransportMeansService.selectBorderTransportMeansById(id));
    }

    /**
     * 新增驾驶员信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportmeans:add')")
    @Log(title = "驾驶员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BorderTransportMeans borderTransportMeans)
    {
        return toAjax(borderTransportMeansService.insertBorderTransportMeans(borderTransportMeans));
    }

    /**
     * 修改驾驶员信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportmeans:edit')")
    @Log(title = "驾驶员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BorderTransportMeans borderTransportMeans)
    {
        return toAjax(borderTransportMeansService.updateBorderTransportMeans(borderTransportMeans));
    }

    /**
     * 删除驾驶员信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportmeans:remove')")
    @Log(title = "驾驶员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(borderTransportMeansService.deleteBorderTransportMeansByIds(ids));
    }
}
