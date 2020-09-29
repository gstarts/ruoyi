package com.ruoyi.stations_management.beltscale.controller;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.stations_management.beltscale.domain.BeltScale;
import com.ruoyi.stations_management.beltscale.service.IBeltScaleService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 皮带秤Controller
 *
 * @author qishuai
 * @date 2020-07-24
 */
@RestController
@RequestMapping("/beltscale/beltscale")
public class BeltScaleController extends BaseController {
    @Autowired
    private IBeltScaleService beltScaleService;

    /**
     * 查询皮带秤列表
     */
    @PreAuthorize("@ss.hasPermi('beltscale:beltscale:list')")
    @GetMapping("/list")
    public TableDataInfo list(BeltScale beltScale) {
        startPage();
        List<BeltScale> list = beltScaleService.selectBeltScaleList(beltScale);
        return getDataTable(list);
    }

    /**
     * 导出皮带秤列表
     */
    @PreAuthorize("@ss.hasPermi('beltscale:beltscale:export')")
    @Log(title = "皮带秤", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BeltScale beltScale) {
        List<BeltScale> list = beltScaleService.selectBeltScaleList(beltScale);
        ExcelUtil<BeltScale> util = new ExcelUtil<BeltScale>(BeltScale.class);
        return util.exportExcel(list, "beltscale");
    }

    /**
     * 获取皮带秤详细信息
     */
    @PreAuthorize("@ss.hasPermi('beltscale:beltscale:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(beltScaleService.selectBeltScaleById(id));
    }

    /**
     * 新增皮带秤
     */
    @PreAuthorize("@ss.hasPermi('beltscale:beltscale:add')")
    @Log(title = "皮带秤", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BeltScale beltScale) {
        beltScale.setCreateBy(SecurityUtils.getUsername());
        return toAjax(beltScaleService.insertBeltScale(beltScale));
    }

    /**
     * 修改皮带秤
     */
    @PreAuthorize("@ss.hasPermi('beltscale:beltscale:edit')")
    @Log(title = "皮带秤", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BeltScale beltScale) {
        beltScale.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(beltScaleService.updateBeltScale(beltScale));
    }

    /**
     * 删除皮带秤
     */
    @PreAuthorize("@ss.hasPermi('beltscale:beltscale:remove')")
    @Log(title = "皮带秤", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(beltScaleService.deleteBeltScaleByIds(ids));
    }
}
