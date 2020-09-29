package com.ruoyi.stations_management.coal.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.coal.domain.CoalNumber;
import com.ruoyi.stations_management.coal.service.ICoalNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 大提煤单 Controller
 *
 * @author songqingchuan
 * @date 2020-06-02
 */
@Api(tags = "大提煤单")
@RestController
@RequestMapping("/coal/number")
public class CoalNumberController extends BaseController {
    @Autowired
    private ICoalNumberService coalNumberService;
//    @Autowired
//    private TokenService tokenService;

    /**
     * 查询大提煤单列表
     */
    @ApiOperation("查询大提煤单列表")
    @ApiImplicitParam(name = "coalNumber",value = "查询大提煤单列表",dataType = "CoalNumber")
    @PreAuthorize("@ss.hasPermi('coal:number:list')")
    @GetMapping("/list")
    public TableDataInfo list(CoalNumber coalNumber) {
        startPage();
        List<CoalNumber> list = coalNumberService.selectCoalNumberList(coalNumber);
        return getDataTable(list);
    }

    /**
     * 导出大提煤单列表
     */
    @ApiOperation("导出大提煤单列表")
    @ApiImplicitParam(name = "coalNumber",value = "导出大提煤单列表",dataType = "CoalNumber")
    @PreAuthorize("@ss.hasPermi('coal:number:export')")
    @Log(title = "导出大提煤单列表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CoalNumber coalNumber) {
        List<CoalNumber> list = coalNumberService.selectCoalNumberList(coalNumber);
        ExcelUtil<CoalNumber> util = new ExcelUtil<>(CoalNumber.class);
        return util.exportExcel(list, "number");
    }

    /**
     * 获取详细信息
     */
    @ApiOperation("获取详细信息")
    @ApiImplicitParam(name = "coalNumber", value = "CoalNumber", required = true, dataType = "String", paramType = "path")
    @PreAuthorize("@ss.hasPermi('coal:number:query')")
    @GetMapping(value = "/{coalNumber}")
    public AjaxResult getInfo(@PathVariable("coalNumber") String coalNumber) {
        return AjaxResult.success(coalNumberService.selectCoalNumberById(coalNumber));
    }

    /**
     * 新增提煤单
     */
    @ApiOperation("新增提煤单")
    @ApiImplicitParam(name = "coalNumber",value = "新增提煤单",dataType = "CoalNumber")
    @PreAuthorize("@ss.hasPermi('coal:number:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CoalNumber coalNumber) {

        return toAjax(coalNumberService.insertCoalNumber(coalNumber));
    }
//
//    /**
//     * 作废【提煤单信息作废】
//     */
//    @PreAuthorize("@ss.hasPermi('coal:number:edit')")
//    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
//    @PutMapping
//    public AjaxResult edit(@RequestBody CoalNumber coalNumber)
//    {
//        return toAjax(coalNumberService.updateCoalNumber(coalNumber));
//    }

    /**
     * 作废 大提煤单信息作废
     */
    @ApiOperation("大提煤单信息作废")
    @ApiImplicitParam(name = "coalNumber", value = "coalNumber", required = true, dataType = "String", paramType = "path")
    @PreAuthorize("@ss.hasPermi('coal:number:remove')")
    @Log(title = "大提煤单信息作废", businessType = BusinessType.DELETE)
    @PutMapping("/{coalNumber}")
    public AjaxResult remove(@PathVariable String coalNumber) {
        return toAjax(coalNumberService.updateCoalNumberByIds(coalNumber));
    }


    /**
     * 执行完成
     *
     */
    @ApiOperation("执行完成")
    @ApiImplicitParam(name = "ids", value = "ids", required = true, dataType = "String", paramType = "path")
    @PreAuthorize("@ss.hasPermi('coal:number:remove')")
    @Log(title = "【执行完成】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult finish(@PathVariable String[] ids) {
        return toAjax(coalNumberService.updateCoalNumberPlateByNum(ids));
    }

    /**
     * 初始化大提煤单时间与登录人页面信息
     *
     */
    @GetMapping("/init")
    @ApiOperation("初始化页面信息")
    public AjaxResult init() {
//        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        CoalNumber coalNumber = coalNumberService.init();
        return AjaxResult.success(coalNumber);
    }

}
