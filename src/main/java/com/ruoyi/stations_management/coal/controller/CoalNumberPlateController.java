package com.ruoyi.stations_management.coal.controller;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.coal.domain.CoalNumber;
import com.ruoyi.stations_management.coal.domain.CoalNumberPlate;
import com.ruoyi.stations_management.coal.service.ICoalNumberPlateService;
import com.ruoyi.stations_management.coal.service.ICoalNumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小提煤单 Controller
 *
 * @author songqingchuan
 * @date 2020-06-02
 */
@Api(tags = "小提煤单")
@RestController
@RequestMapping("/coal/plate")
public class CoalNumberPlateController extends BaseController {
    @Autowired
    private ICoalNumberPlateService coalNumberPlateService;
    @Autowired
    private ICoalNumberService coalNumberService;
    @Autowired
    private TokenService tokenService;

    /**
     * 查询小提煤单列表
     */
    @ApiOperation("查询小提煤单列表")
    @ApiImplicitParam(name = "coalNumber", value = "CoalNumber", required = true, dataType = "String", paramType = "path")
    @PreAuthorize("@ss.hasPermi('coal:plate:list')")
    @GetMapping("/list/{coalNumber}")
    public TableDataInfo list(@PathVariable("coalNumber") String coalNumber) {
        startPage();
        List<CoalNumberPlate> list = coalNumberPlateService.selectCoalNumberPlateById(coalNumber);
        return getDataTable(list);
    }

    /**
     * 导出小提煤单列表
     */
    @ApiOperation("导出小提煤单列表")
    @ApiImplicitParam(name = "coalNumberPlate",value = "导出小提煤单列表",dataType = "CoalNumberPlate")
    @PreAuthorize("@ss.hasPermi('coal:plate:export')")
    @Log(title = "小提煤单列表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CoalNumberPlate coalNumberPlate) {
        List<CoalNumberPlate> list = coalNumberPlateService.selectCoalNumberPlateById(coalNumberPlate.getCoalNumber());
        ExcelUtil<CoalNumberPlate> util = new ExcelUtil<>(CoalNumberPlate.class);
        return util.exportExcel(list, "plate");
    }

    /**
     * 获取小提煤单详细信息
     */
    @ApiOperation("获取小提煤单详细信息")
    @ApiImplicitParam(name = "coalNumber", value = "CoalNumber", required = true, dataType = "String", paramType = "path")
    @PreAuthorize("@ss.hasPermi('coal:plate:query')")
    @GetMapping("/info/{coalNumber}")
    public AjaxResult getInfo(@PathVariable("coalNumber") String coalNumber) {

        startPage();
        List<CoalNumberPlate> list = coalNumberPlateService.selectCoalNumberPlateById(coalNumber);
        CoalNumber number = coalNumberService.selectCoalNumberById(coalNumber);
        Map<String, Object> map = new HashMap<>();
        map.put("info", number);
        map.put("rows", list);
        return AjaxResult.success(map);
    }

    /**
     * 新增小提煤单
     */
    @ApiOperation("新增小提煤单")
    @ApiImplicitParam(name = "coalNumberPlate",value = "新增小提煤单",dataType = "CoalNumberPlate")
    @PreAuthorize("@ss.hasPermi('coal:plate:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CoalNumberPlate coalNumberPlate) {
        //获取当前登录用户名
        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        coalNumberPlate.setOperator(userName);
        //获取当前系统时间
        Date date = new Date();
        //转换时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //set进实体类 录入时间
        coalNumberPlate.setDateTime(sdf.format(date));
        //判断是否有大提煤单
        if (coalNumberPlate.getCoalNumber() == null) {
            return toAjax(0, "请先保存大提煤单的基础信息");
        }
        return toAjax(coalNumberPlateService.insertCoalNumberPlate(coalNumberPlate));
    }

    /**
     * 修改 小提煤单
     */
    @ApiOperation("修改小提煤单")
    @ApiImplicitParam(name = "coalNumberPlate",value = "修改小提煤单",dataType = "CoalNumberPlate")
    @PreAuthorize("@ss.hasPermi('coal:plate:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CoalNumberPlate coalNumberPlate) {
        return toAjax(coalNumberPlateService.updateCoalNumberPlate(coalNumberPlate));
    }

    /**
     * 作废车号
     */
    @ApiOperation("作废车号")
    @ApiImplicitParam(name = "ids", value = "ids", required = true, dataType = "Long", paramType = "path")
    @PreAuthorize("@ss.hasPermi('coal:plate:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(coalNumberPlateService.updateCoalNumberPlateByIds(ids));
    }
}