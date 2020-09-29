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
import com.ruoyi.stations_management.montroller.domain.VeRfid;
import com.ruoyi.stations_management.montroller.service.IVeRfidService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 车辆通关时电子车牌信息Controller
 * 
 * @author songxiangyang
 * @date 2020-06-28
 */
@RestController
@RequestMapping("/montroller/rfid")
public class VeRfidController extends BaseController
{
    @Autowired
    private IVeRfidService veRfidService;

    /**
     * 查询车辆通关时电子车牌信息列表
     */
    @PreAuthorize("@ss.hasPermi('montroller:rfid:list')")
    @GetMapping("/list")
    public TableDataInfo list(VeRfid veRfid)
    {
        startPage();
        List<VeRfid> list = veRfidService.selectVeRfidList(veRfid);
        return getDataTable(list);
    }

    /**
     * 导出车辆通关时电子车牌信息列表
     */
    @PreAuthorize("@ss.hasPermi('montroller:rfid:export')")
    @Log(title = "车辆通关时电子车牌信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(VeRfid veRfid)
    {
        List<VeRfid> list = veRfidService.selectVeRfidList(veRfid);
        ExcelUtil<VeRfid> util = new ExcelUtil<VeRfid>(VeRfid.class);
        return util.exportExcel(list, "rfid");
    }

    /**
     * 获取车辆通关时电子车牌信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('montroller:rfid:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(veRfidService.selectVeRfidById(id));
    }

    /**
     * 新增车辆通关时电子车牌信息
     */
    @PreAuthorize("@ss.hasPermi('montroller:rfid:add')")
    @Log(title = "车辆通关时电子车牌信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VeRfid veRfid)
    {
        return toAjax(veRfidService.insertVeRfid(veRfid));
    }

    /**
     * 修改车辆通关时电子车牌信息
     */
    @PreAuthorize("@ss.hasPermi('montroller:rfid:edit')")
    @Log(title = "车辆通关时电子车牌信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VeRfid veRfid)
    {
        return toAjax(veRfidService.updateVeRfid(veRfid));
    }

    /**
     * 删除车辆通关时电子车牌信息
     */
    @PreAuthorize("@ss.hasPermi('montroller:rfid:remove')")
    @Log(title = "车辆通关时电子车牌信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(veRfidService.deleteVeRfidByIds(ids));
    }
}
