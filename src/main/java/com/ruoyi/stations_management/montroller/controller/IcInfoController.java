package com.ruoyi.stations_management.montroller.controller;

import java.util.List;
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
import com.ruoyi.stations_management.montroller.domain.IcInfo;
import com.ruoyi.stations_management.montroller.service.IIcInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 车辆通关信息中ic卡信息Controller
 * 
 * @author songxiangyang
 * @date 2020-06-28
 */
@RestController
@RequestMapping("/montroller/info")
public class IcInfoController extends BaseController
{
    @Autowired
    private IIcInfoService icInfoService;

    /**
     * 查询车辆通关信息中ic卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('montroller:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(IcInfo icInfo)
    {
        startPage();
        List<IcInfo> list = icInfoService.selectIcInfoList(icInfo);
        return getDataTable(list);
    }

    /**
     * 导出车辆通关信息中ic卡信息列表
     */
    @PreAuthorize("@ss.hasPermi('montroller:info:export')")
    @Log(title = "车辆通关信息中ic卡信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(IcInfo icInfo)
    {
        List<IcInfo> list = icInfoService.selectIcInfoList(icInfo);
        ExcelUtil<IcInfo> util = new ExcelUtil<IcInfo>(IcInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取车辆通关信息中ic卡信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('montroller:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(icInfoService.selectIcInfoById(id));
    }

    /**
     * 新增车辆通关信息中ic卡信息
     */
    @PreAuthorize("@ss.hasPermi('montroller:info:add')")
    @Log(title = "车辆通关信息中ic卡信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IcInfo icInfo)
    {
        return toAjax(icInfoService.insertIcInfo(icInfo));
    }

    /**
     * 修改车辆通关信息中ic卡信息
     */
    @PreAuthorize("@ss.hasPermi('montroller:info:edit')")
    @Log(title = "车辆通关信息中ic卡信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IcInfo icInfo)
    {
        return toAjax(icInfoService.updateIcInfo(icInfo));
    }

    /**
     * 删除车辆通关信息中ic卡信息
     */
    @PreAuthorize("@ss.hasPermi('montroller:info:remove')")
    @Log(title = "车辆通关信息中ic卡信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(icInfoService.deleteIcInfoByIds(ids));
    }
}
