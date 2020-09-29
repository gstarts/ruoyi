package com.ruoyi.stations_management.declare.controller;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.declare.domain.AnimalsBody;
import com.ruoyi.stations_management.declare.domain.AnimalsHead;
import com.ruoyi.stations_management.declare.service.IAnimalsBodyService;
import com.ruoyi.stations_management.declare.service.IAnimalsHeadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 动物头Controller
 *
 * @author qishuai
 * @date 2020-04-07
 */
@Api("动植物申报管理")
@RestController
@RequestMapping("/animal")
public class AnimalsDeclareController extends BaseController {
    @Autowired
    private IAnimalsHeadService animalsHeadService;

    @Autowired
    private IAnimalsBodyService animalsBodyService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询动物头列表
     */
    @ApiOperation("查询动物头列表")
    @ApiImplicitParam(name = "AnimalsHead", value = "查询动物头列表", dataType = "animalsHead")
    @PreAuthorize("@ss.hasPermi('declare:head:list')")
    @GetMapping("/head/list")
    public TableDataInfo list(AnimalsHead animalsHead) {
        startPage();
        List<AnimalsHead> list = animalsHeadService.selectAnimalsHeadList(animalsHead);
        return getDataTable(list);
    }

    /**
     * 导出动物头列表
     */
    @ApiOperation("导出动物头列表")
    @ApiImplicitParam(name = "AnimalsHead", value = "导出动物头列表", dataType = "animalsHead")
    @PreAuthorize("@ss.hasPermi('animal:head:export')")
    @Log(title = "动物头", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(AnimalsHead animalsHead) {
        List<AnimalsHead> list = animalsHeadService.selectAnimalsHeadList(animalsHead);
        ExcelUtil<AnimalsHead> util = new ExcelUtil<>(AnimalsHead.class);
        return util.exportExcel(list, "head");
    }

    /**
     * 获取动物头详细信息
     */
    @ApiOperation("获取动物头详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('animals:declare:query')")
    @GetMapping(value = "/head/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(animalsHeadService.selectAnimalsHeadById(id));
    }

    /**
     * 新增动物头
     */
    @ApiOperation("新增动物头")
    @ApiImplicitParam(name = "AnimalsHead", value = "新增动物头", dataType = "animalsHead")
    @PreAuthorize("@ss.hasPermi('animals:head:add')")
    @Log(title = "动物头", businessType = BusinessType.INSERT)
    @PostMapping("/head")
    public AjaxResult add(@RequestBody AnimalsHead animalsHead) {
//        return toAjax(animalsHeadService.insertAnimalsHead(animalsHead));
        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        animalsHead.setCruser(userName);
        // 查询 是否存在
        AnimalsHead head = animalsHeadService.selectAnimalsHeadById(animalsHead.getId());

        if (head != null) {
            int updateRows = animalsHeadService.updateAnimalsHead(animalsHead);
            if (updateRows > 0) {
                return AjaxResult.success("修改成功");
            } else {
                return AjaxResult.success("修改失败");
            }
        } else {
            int addRows = animalsHeadService.insertAnimalsHead(animalsHead);
            if (addRows > 0) {
                return AjaxResult.success("新增成功");
            } else {
                return AjaxResult.error("新增失败");
            }
        }
    }


    /**
     * 修改动物头
     */
    @ApiOperation("修改动物头")
    @ApiImplicitParam(name = "AnimalsHead", value = "修改动物头", dataType = "animalsHead")
    @PreAuthorize("@ss.hasPermi('animals:head:edit')")
    @Log(title = "动物头", businessType = BusinessType.UPDATE)
    @PutMapping("/head")
    public AjaxResult edit(@RequestBody AnimalsHead animalsHead) {
        return toAjax(animalsHeadService.updateAnimalsHead(animalsHead));
    }

    /**
     * 动植物批量申报
     */
    @ApiOperation("动植物批量申报")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('animals:query:declare')")
    @Log(title = "动植物批量申报", businessType = BusinessType.UPDATE)
    @DeleteMapping("head/{ids}")
    public AjaxResult declareAnimals(@PathVariable Long[] ids) {
        return toAjax(animalsHeadService.declareAnimals(ids));
    }


    /**
     * 查询动物体列表
     */
    @ApiOperation("查询动物体列表")
    @ApiImplicitParam(name = "AnimalsBody", value = "查询动物体列表", dataType = "animalsBody")
    @PreAuthorize("@ss.hasPermi('declare:head:list')")
    @GetMapping("body/list")
    public TableDataInfo list(AnimalsBody animalsBody) {
        startPage();
        List<AnimalsBody> list = animalsBodyService.selectAnimalsBodyList(animalsBody);
        return getDataTable(list);
    }

    /**
     * 获取动物体详细信息
     */
    @ApiOperation("获取动物体详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('animals:body:query')")
    @GetMapping(value = "/body/{id}")
    public AjaxResult getBodyInfo(@PathVariable("id") Long id) {

        return AjaxResult.success(animalsBodyService.selectAnimalsBodyById(id));
    }

    /**
     * 新增动物体
     */
    @ApiOperation("新增动物体")
    @ApiImplicitParam(name = "AnimalsBody", value = "新增动物体", dataType = "animalsBody")
    @PreAuthorize("@ss.hasPermi('animals:body:add')")
    @Log(title = "动物体", businessType = BusinessType.INSERT)
    @PostMapping("/body")
    public AjaxResult add(@RequestBody AnimalsBody animalsBody) {
        AnimalsHead animalsHead = animalsHeadService.selectAnimalsHeadById(animalsBody.getHeadId());
        if (animalsHead == null) {
            return toAjax(0, "请先保存该记录的基础信息");
        }
        return toAjax(animalsBodyService.insertAnimalsBody(animalsBody));
    }

    /**
     * 修改动物体
     */
    @ApiOperation("修改动物体")
    @ApiImplicitParam(name = "AnimalsBody", value = "修改动物体", dataType = "animalsBody")
    @PreAuthorize("@ss.hasPermi('animals:body:edit')")
    @Log(title = "动物体", businessType = BusinessType.UPDATE)
    @PutMapping("/body")
    public AjaxResult edit(@RequestBody AnimalsBody animalsBody) {
        return toAjax(animalsBodyService.updateAnimalsBody(animalsBody));
    }

    /**
     * 删除动物体
     */
    @ApiOperation("删除动物体")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('animals:body:remove')")
    @Log(title = "动物体", businessType = BusinessType.DELETE)
    @DeleteMapping("/body/{ids}")
    public AjaxResult bodyRemove(@PathVariable Long[] ids) {
        return toAjax(animalsBodyService.deleteAnimalsBodyByIds(ids));
    }

    @ApiOperation("初始化")
    @ApiImplicitParam(name = "stationId", value = "场站id", required = true, dataType = "int", paramType = "path")
    @GetMapping("/init")
    public AjaxResult init() {
//        根据用户信息获取场站信息
//        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        // 默认场站id =1
        String stationId = "1";
        return AjaxResult.success(animalsHeadService.init(stationId));
    }

    @ApiOperation("批量导入数据")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, String headId) throws Exception {
        ExcelUtil<AnimalsBody> util = new ExcelUtil<>(AnimalsBody.class);
        List<AnimalsBody> animalsList = util.importExcel(file.getInputStream());
        return AjaxResult.success(animalsBodyService.importAnimals(animalsList, Long.valueOf(headId)));
    }

    @ApiOperation("下载模板")
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<AnimalsBody> util = new ExcelUtil<>(AnimalsBody.class);
        return util.importTemplateExcel("动植物申报信息");
    }

}
