package com.ruoyi.stations_management.enterprise.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.enterprise.domain.SStationConfig;
import com.ruoyi.stations_management.enterprise.service.ISStationConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 场站配置 Controller
 *
 * @author qishuai
 * @date 2020-04-30
 */
@Api(tags = "场站配置")
@RestController
@RequestMapping("/enterprise/config")
public class SStationConfigController extends BaseController {
    @Autowired
    private ISStationConfigService sStationConfigService;

    /**
     * 查询场站列表
     */
    @ApiOperation("查询场站列表")
    @ApiImplicitParam(name = "sStationConfig", value = "查询场站列表", dataType = "SStationConfig")
    @PreAuthorize("@ss.hasPermi('monitor:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(SStationConfig sStationConfig) {
        startPage();
        List<SStationConfig> list = sStationConfigService.selectSStationConfigList(sStationConfig);
        return getDataTable(list);
    }

    /**
     * 修改场站配置
     */
    @ApiOperation("修改场站配置")
    @ApiImplicitParam(name = "sStationConfig", value = "导出大提煤单列表", dataType = "SStationConfig")
    @PreAuthorize("@ss.hasPermi('monitor:config:edit')")
    @Log(title = "修改场站配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SStationConfig sStationConfig) {
        return toAjax(sStationConfigService.updateSStationConfig(sStationConfig));
    }
//    /**
//     * 导出场站列表
//     */
//    @PreAuthorize("@ss.hasPermi('monitor:config:export')")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(SStationConfig sStationConfig) {
//        List<SStationConfig> list = sStationConfigService.selectSStationConfigList(sStationConfig);
//        ExcelUtil<SStationConfig> util = new ExcelUtil<SStationConfig>(SStationConfig.class);
//        return util.exportExcel(list, "config");
//    }

//    /**
//     * 查询场站配置信息(id)
//     */
//    @PreAuthorize("@ss.hasPermi('monitor:config:query')")
//    @GetMapping(value = "/{id}")
//    public AjaxResult getInfo(@PathVariable("id") Long id) {
//        return AjaxResult.success(sStationConfigService.selectSStationConfigById(id));
//    }

//    /**
//     * 新增场站配置
//     */
//    @PreAuthorize("@ss.hasPermi('monitor:config:add')")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody SStationConfig sStationConfig) {
//        return toAjax(sStationConfigService.insertSStationConfig(sStationConfig));
//    }


//    /**
//     * 删除场站配置
//     */
//    @PreAuthorize("@ss.hasPermi('monitor:config:remove')")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
//    @DeleteMapping("/{ids}")
//    public AjaxResult remove(@PathVariable Long[] ids) {
//        return toAjax(sStationConfigService.deleteSStationConfigByIds(ids));
//    }
}
