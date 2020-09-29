package com.ruoyi.stations_management.declare.controller;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.declare.domain.ContainerBody;
import com.ruoyi.stations_management.declare.domain.ContainerHead;
import com.ruoyi.stations_management.declare.service.IContainerBodyService;
import com.ruoyi.stations_management.declare.service.IContainerHeadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 集装箱头Controller
 *
 * @author songqingchuan
 * @date 2020-04-07
 */
@Api("集装箱管理")
@RestController
@RequestMapping("/container/info")
public class ContainerDeclareController extends BaseController {
    @Autowired
    private IContainerHeadService containerHeadService;
    @Autowired
    private IContainerBodyService containerBodyService;
    @Autowired
    private TokenService tokenService;

    /**
     * 查询集装箱头列表
     */
    @ApiOperation("查询集装箱头列表")
    @ApiImplicitParam(name = "containerHead", value = "查询集装箱头列表", dataType = "ContainerHead")
    @PreAuthorize("@ss.hasPermi('declare:head:list')")
    @GetMapping("/head/list")
    public TableDataInfo list(ContainerHead containerHead) {
        startPage();
        List<ContainerHead> list = containerHeadService.selectContainerHeadList(containerHead);
        return getDataTable(list);
    }


    /**
     * 获取集装箱头详细信息
     */
    @ApiOperation("获取集装箱头详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('container:head:query')")
    @GetMapping(value = "head/{id}")
    public AjaxResult getHeadInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(containerHeadService.selectContainerHeadById(id));
    }

    /**
     * 新增集装箱头
     */
    @ApiOperation("新增集装箱头")
    @ApiImplicitParam(name = "containerHead", value = "新增集装箱头", dataType = "ContainerHead")
    @PreAuthorize("@ss.hasPermi('container:head:add')")
    @Log(title = "集装箱头", businessType = BusinessType.INSERT)
    @PostMapping("/head")

    public AjaxResult add(@RequestBody ContainerHead containerHead) {
        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        containerHead.setCrusername(userName);
        ContainerHead head = containerHeadService.selectContainerHeadById(containerHead.getId());

        if (head != null) {
            int updateRows = containerHeadService.updateContainerHead(containerHead);
            if (updateRows > 0) {
                return AjaxResult.success("修改成功");
            } else {
                return AjaxResult.error("修改失败");
            }

        } else {
            int addRows = containerHeadService.insertContainerHead(containerHead);
            if (addRows > 0) {
                return AjaxResult.success("新增成功");
            } else {
                return AjaxResult.error("新增失败");
            }
        }

    }

    /**
     * 修改集装箱头
     */
    @ApiOperation("修改集装箱头")
    @ApiImplicitParam(name = "containerHead", value = "修改集装箱头", dataType = "ContainerHead")
    @PreAuthorize("@ss.hasPermi('container:head:edit')")
    @Log(title = "集装箱头", businessType = BusinessType.UPDATE)
    @PutMapping("/head")
    public AjaxResult edit(@RequestBody ContainerHead containerHead) {
        return toAjax(containerHeadService.updateContainerHead(containerHead));
    }

    /**
     * 集装箱批量申报
     */
    @ApiOperation("集装箱批量申报")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('container:head:declare')")
    @Log(title = "集装箱批量申报", businessType = BusinessType.UPDATE)
    @DeleteMapping("/head/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(containerHeadService.declareContainers(ids));
    }


    /**
     * 查询集装箱体列表
     */
    @ApiOperation("查询集装箱体列表")
    @ApiImplicitParam(name = "containerBody", value = "查询集装箱体列表", dataType = "ContainerBody")
    @PreAuthorize("@ss.hasPermi('declare:head:list')")
    @GetMapping("/body/list")
    public TableDataInfo list(ContainerBody containerBody) {
        startPage();
        List<ContainerBody> list = containerBodyService.selectContainerBodyList(containerBody);
        return getDataTable(list);
    }

    /**
     * 获取集装箱体详细信息
     */
    @ApiOperation("获取集装箱体详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('container:body:query')")
    @GetMapping(value = "/body/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(containerBodyService.selectContainerBodyById(id));
    }

    /**
     * 新增集装箱体
     */
    @ApiOperation("新增集装箱体")
    @ApiImplicitParam(name = "containerBody", value = "新增集装箱体", dataType = "ContainerBody")
    @PreAuthorize("@ss.hasPermi('container:body:add')")
    @Log(title = "集装箱体", businessType = BusinessType.INSERT)
    @PostMapping("/body")
    public AjaxResult add(@RequestBody ContainerBody containerBody) {
        ContainerHead containerHead = containerHeadService.selectContainerHeadById(containerBody.getHeadId());
        if (containerHead == null) {
            return toAjax(0, "请先保存该记录的基础信息");
        }
        return toAjax(containerBodyService.insertContainerBody(containerBody));
    }

    /**
     * 修改集装箱体
     */
    @ApiOperation("修改集装箱体")
    @ApiImplicitParam(name = "containerBody", value = "修改集装箱体", dataType = "ContainerBody")
    @PreAuthorize("@ss.hasPermi('container:body:edit')")
    @Log(title = "集装箱体", businessType = BusinessType.UPDATE)
    @PutMapping("/body")
    public AjaxResult edit(@RequestBody ContainerBody containerBody) {
        return toAjax(containerBodyService.updateContainerBody(containerBody));
    }

    /**
     * 删除集装箱体
     */
    @ApiOperation("删除集装箱体")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('container:body:remove')")
    @Log(title = "集装箱体", businessType = BusinessType.DELETE)
    @DeleteMapping("/body/{ids}")
    public AjaxResult bodyRemove(@PathVariable Long[] ids) {
        return toAjax(containerBodyService.deleteContainerBodyByIds(ids));
    }

    /***
     * 页面初始化方法
     */
    @ApiOperation("页面初始化方法")
    @ApiImplicitParam(name = "stationId", value = "场站ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/init")
    public AjaxResult init() {
        // 根据用户信息获取场站信息
//        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        // 默认场站id =1
        String stationId = "1";
        return AjaxResult.success(containerHeadService.init(stationId));
    }

    /***
     * 下载模板
     */
    @ApiOperation("下载模板")
    @GetMapping("/body/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<ContainerBody> util = new ExcelUtil<>(ContainerBody.class);
        return util.importTemplateExcel("集装箱申报信息");
    }

    /***
     * 批量插入data
     */
    @ApiOperation("批量插入data")
    @PostMapping("/body/importData")
    @PreAuthorize("@ss.hasPermi('container:body:import')")
    public AjaxResult importData(MultipartFile file, String headId) throws Exception {
        ExcelUtil<ContainerBody> util = new ExcelUtil<>(ContainerBody.class);
        List<ContainerBody> containerBodyList = util.importExcel(file.getInputStream());
        return AjaxResult.success(containerBodyService.importContainer(containerBodyList, Long.valueOf(headId)));
    }
}
