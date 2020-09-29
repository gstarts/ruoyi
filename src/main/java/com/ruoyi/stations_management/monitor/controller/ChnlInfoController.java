package com.ruoyi.stations_management.monitor.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.framework.web.domain.TreeSelect;
import com.ruoyi.stations_management.common.domain.StationInfo;
import com.ruoyi.stations_management.common.service.IStationInfoService;
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
import com.ruoyi.stations_management.monitor.domain.ChnlInfo;
import com.ruoyi.stations_management.monitor.service.IChnlInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 通道配置Controller
 *
 * @author qishuai
 * @date 2020-03-24
 */
@Api("通道配置")
@RestController
@RequestMapping("/monitor/chnlConfig")
public class ChnlInfoController extends BaseController {
    @Autowired
    private IChnlInfoService chnlInfoService;
    @Autowired
    private IStationInfoService stationInfoService;

    /**
     * 查询通道配置列表
     */
    @ApiOperation("查询通道配置列表")
    @ApiImplicitParam(name = "chnlInfo", value = "查询通道配置列表", dataType = "ChnlInfo")
    @PreAuthorize("@ss.hasPermi('chnl:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChnlInfo chnlInfo) {
        startPage();
        List<ChnlInfo> list = chnlInfoService.selectChnlInfoList(chnlInfo);
        return getDataTable(list);
    }

    /**
     * 导出通道配置列表
     */
    @ApiOperation("导出通道配置列表")
    @ApiImplicitParam(name = "chnlInfo", value = "导出通道配置列表", dataType = "ChnlInfo")
    @PreAuthorize("@ss.hasPermi('chnl:chnlConfig:export')")
    @Log(title = "通道配置", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ChnlInfo chnlInfo) {
        List<ChnlInfo> list = chnlInfoService.selectChnlInfoList(chnlInfo);
        ExcelUtil<ChnlInfo> util = new ExcelUtil<>(ChnlInfo.class);
        return util.exportExcel(list, "chnlConfig");
    }

    /**
     * 获取通道配置详细信息
     */
    @ApiOperation("获取通道配置详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('chnl:config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(chnlInfoService.selectChnlInfoById(id));
    }

    /**
     * 新增通道配置
     */
    @ApiOperation("新增通道配置")
    @ApiImplicitParam(name = "chnlInfo", value = "新增通道配置", dataType = "ChnlInfo")
    @PreAuthorize("@ss.hasPermi('chnl:config:add')")
    @Log(title = "通道配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChnlInfo chnlInfo) {
        return toAjax(chnlInfoService.insertChnlInfo(chnlInfo));
    }

    /**
     * 修改通道配置
     */
    @ApiOperation("修改通道配置")
    @ApiImplicitParam(name = "chnlInfo", value = "修改通道配置", dataType = "ChnlInfo")
    @PreAuthorize("@ss.hasPermi('chnl:config:edit')")
    @Log(title = "通道配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChnlInfo chnlInfo) {
        return toAjax(chnlInfoService.updateChnlInfo(chnlInfo));
    }

    /**
     * 删除通道配置
     */
    @ApiOperation("删除通道配置")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('chnl:config:remove')")
    @Log(title = "通道配置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(chnlInfoService.deleteChnlInfoByIds(ids));
    }

    /**
     * 获取场站通道列表树
     */
    @ApiOperation("获取场站通道列表树")
    @ApiImplicitParam(name = "chnl", value = "获取场站通道列表树", dataType = "ChnlInfo")
    @GetMapping("/chnllist")
    public AjaxResult treeselect(ChnlInfo chnl) {
        List<ChnlInfo> list = chnlInfoService.selectChnlInfoList(chnl);
        // 获取通道树
        List<TreeSelect> treeSelects = chnlInfoService.buildChnlTreeSelect(list);
        TreeSelect tree = new TreeSelect();
        // 根据用户获取场站的相关信息
        tree.setLabel("场站name");
        // 将通道树作为产站的子节点
        tree.setChildren(treeSelects);
        List<TreeSelect> resoultList = new ArrayList<>();
        resoultList.add(tree);
        return AjaxResult.success(resoultList);
    }

    /**
     * 更改通道使用状态
     */
    @ApiOperation("更改通道使用状态")
    @ApiImplicitParam(name = "chnl", value = "更改通道使用状态", dataType = "ChnlInfo")
    @PutMapping("/changeStatus")
    public AjaxResult changeStatus(@RequestBody ChnlInfo chnl) {
        return AjaxResult.success(chnlInfoService.updateChnlInfo(chnl));
    }


    /**
     * 获取场站通道列表树
     */
    @ApiOperation("获取场站通道列表树")
    @ApiImplicitParam(name = "chnl", value = "获取场站通道列表树", dataType = "ChnlInfo")
    @GetMapping("/chnlTree")
    public AjaxResult chnlTree() {
        // 获取全部场站
        List<StationInfo> stationList = stationInfoService.selectStationList();
        // 获取通道树
        List<TreeSelect> treeSelects = chnlInfoService.buildStationTree(stationList);
        TreeSelect tree = new TreeSelect();
        // 设置平台为树的根节点
        tree.setId((long) -1);
        tree.setLabel("LH");
        // 将通道树作为产站的子节点
        tree.setChildren(treeSelects);
        List<TreeSelect> resoultList = new ArrayList<>();
        resoultList.add(tree);
        return AjaxResult.success(resoultList);
    }

    /**
     * 通道下拉列表
     */
    @GetMapping("/aisleList")
    public AjaxResult getAisleList() {
        return AjaxResult.success(chnlInfoService.getChnlOptions());
    }
}
