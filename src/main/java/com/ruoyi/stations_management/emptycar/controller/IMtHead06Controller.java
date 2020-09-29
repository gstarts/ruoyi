package com.ruoyi.stations_management.emptycar.controller;

import java.util.List;

import com.ruoyi.stations_management.emptycar.domain.IMtTransport06;
import com.ruoyi.stations_management.report.domain.MtTransport;
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
import com.ruoyi.stations_management.emptycar.domain.IMtHead06;
import com.ruoyi.stations_management.emptycar.service.IIMtHead06Service;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 空车查询Head Controller
 *
 * @author songqingchuan
 * @date 2020-06-15
 */
@RestController
@RequestMapping("/emptycar/06/head")
public class IMtHead06Controller extends BaseController {
    @Autowired
    private IIMtHead06Service iMtHead06Service;

    /**
     * 查询空车列表
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:list')")
    @GetMapping("/list")
    public TableDataInfo list(IMtHead06 iMtHead06) {
        startPage();
        List<IMtHead06> list = iMtHead06Service.selectIMtHead06List(iMtHead06);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(IMtHead06 iMtHead06) {
        List<IMtHead06> list = iMtHead06Service.selectIMtHead06List(iMtHead06);
        ExcelUtil<IMtHead06> util = new ExcelUtil<IMtHead06>(IMtHead06.class);
        return util.exportExcel(list, "06");
    }

    /**
     * 获取空车表头详细信息
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:query')")
    @GetMapping(value = "/{pid}")
    public AjaxResult getInfo(@PathVariable("pid") Long pid) {
        return AjaxResult.success(iMtHead06Service.selectIMtHead06ById(pid));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IMtHead06 iMtHead06) {
        return toAjax(iMtHead06Service.insertIMtHead06(iMtHead06));
    }

    /**
     * 修改【空车表头信息】
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IMtHead06 iMtHead06) {
        return toAjax(iMtHead06Service.updateIMtHead06(iMtHead06));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('emptycar:06:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{pids}")
    public AjaxResult remove(@PathVariable Long[] pids) {
        return toAjax(iMtHead06Service.deleteIMtHead06ByIds(pids));
    }

    // 查询挂车信息
    @PreAuthorize("@ss.hasPermi('report:transport:query')")
    @GetMapping("/transport")
    public TableDataInfo list(IMtTransport06 mtTransport06, Long pid) {
        startPage();
        List<IMtTransport06> list = iMtHead06Service.selectMtTransportById(pid);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('report:transport:query')")
    @GetMapping(value = "/transportDetail/{key}")
    public AjaxResult getInfoMtDetail(@PathVariable("key") Long key) {
        return AjaxResult.success(iMtHead06Service.MtTransportByIdDetail(key));
    }


    /**
     * 修改托架或拖挂车信息
     */
    @PreAuthorize("@ss.hasPermi('report:transport:edit')")
    @Log(title = "托架或拖挂车信息 ", businessType = BusinessType.UPDATE)
    @PutMapping("/transport")
    public AjaxResult edit(@RequestBody IMtTransport06 mtTransport06) {

        if (null == mtTransport06.getKey()) {
            return AjaxResult.error("请先双击要修改的信息");
        } else {
            return toAjax(iMtHead06Service.updateMtTransport(mtTransport06));
        }

    }

}
