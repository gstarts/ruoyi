package com.ruoyi.stations_management.mt.controller;

import java.util.List;

import com.ruoyi.stations_management.mt.domain.Consignment;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.ruoyi.stations_management.mt.service.IConsignmentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.annotation.Resource;

/**
 * 提（运）单数据Controller
 * 
 * @author songqingchuan
 * @date 2020-07-27
 */
@RestController
@RequestMapping("/newemptycar/consignment")
public class ConsignmentController extends BaseController
{
    @Resource
    private IConsignmentService ConsignmentService;

    /**
     * 查询提（运）单数据列表
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:consignment:list')")
    @GetMapping("/list")
    public TableDataInfo list(Consignment consignment)
    {
        startPage();
        List<Consignment> list = ConsignmentService.selectConsignmentList(consignment);
        return getDataTable(list);
    }

    /**
     * 导出提（运）单数据列表
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:consignment:export')")
    @Log(title = "提（运）单数据", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Consignment consignment)
    {
        List<Consignment> list = ConsignmentService.selectConsignmentList(consignment);
        ExcelUtil<Consignment> util = new ExcelUtil<>(Consignment.class);
        return util.exportExcel(list, "consignment");
    }

    /**
     * 获取提（运）单数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:consignment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(ConsignmentService.selectConsignmentById(id));
    }

    /**
     * 新增提（运）单数据
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:consignment:add')")
    @Log(title = "提（运）单数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Consignment consignment)
    {
        return toAjax(ConsignmentService.insertConsignment(consignment));
    }

    /**
     * 修改提（运）单数据
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:consignment:edit')")
    @Log(title = "提（运）单数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Consignment consignment)
    {
        return toAjax(ConsignmentService.updateConsignment(consignment));
    }

    /**
     * 删除提（运）单数据
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:consignment:remove')")
    @Log(title = "提（运）单数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ConsignmentService.deleteConsignmentByIds(ids));
    }
}
