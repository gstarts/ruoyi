package com.ruoyi.stations_management.container.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.project.monitor.service.ISysOperLogService;
import com.ruoyi.project.system.service.ISysUserOnlineService;
import com.ruoyi.project.system.service.ISysUserService;
import com.ruoyi.stations_management.coal.domain.CoalNumber;
import com.ruoyi.stations_management.coal.domain.CoalNumberPlate;
import com.ruoyi.stations_management.container.domain.MbContainer;
import com.ruoyi.stations_management.container.service.IMbContainerService;
import com.ruoyi.stations_management.waybill.domain.WaybillBody;
import com.ruoyi.stations_management.waybill.domain.WaybillHead;
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
import com.ruoyi.stations_management.container.domain.MhContainer;
import com.ruoyi.stations_management.container.service.IMhContainerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 集装箱管理HeadController
 *
 * @author songxiangyang
 * @date 2020-06-11
 */
@RestController
@RequestMapping("/container/container")
public class MhContainerController extends BaseController {
    @Autowired
    private IMhContainerService mhContainerService;

    @Autowired
    private IMbContainerService mbContainerService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询集装箱管理Head列表
     */
    @PreAuthorize("@ss.hasPermi('container:container:list')")
    @GetMapping("/list")
    public TableDataInfo list(MhContainer mhContainer) {
        startPage();
        List<MhContainer> list = mhContainerService.selectMhContainerList(mhContainer);
        return getDataTable(list);
    }

    /**
     * 导出集装箱管理Head列表
     */
    @PreAuthorize("@ss.hasPermi('container:container:export')")
    @Log(title = "集装箱管理Head", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MhContainer mhContainer) {
        List<MhContainer> list = mhContainerService.selectMhContainerList(mhContainer);
        ExcelUtil<MhContainer> util = new ExcelUtil<MhContainer>(MhContainer.class);
        return util.exportExcel(list, "container");
    }

    /**
     * 获取集装箱管理Head详细信息
     */
    @PreAuthorize("@ss.hasPermi('container:container:query')")
    @GetMapping("/info/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        startPage();
        List<MbContainer> list = mbContainerService.selectMbContainerById(id);
        MhContainer container = mhContainerService.selectMhContainerById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("info", container);
        map.put("rows", list);
        return AjaxResult.success(map);
    }

    /**
     * 获取修改后集装箱体详细信息
     */
    @GetMapping("/infoBody/{id}")
    public AjaxResult getInfoBody(@PathVariable("id") Long id) {
        startPage();
        List<MbContainer> list = mbContainerService.selectMbContainerById(id);
        MhContainer container = mhContainerService.selectMhContainerById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("info", container);
        map.put("rows", list);
        return AjaxResult.success(map);
    }

    /**
     * 新增集装箱管理Head
     */
    @PreAuthorize("@ss.hasPermi('container:container:add')")
    @Log(title = "集装箱管理Head", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MhContainer mhContainer) {
        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        mhContainer.setOperator(userName);
        // 查询 基础信息是否存在
        MhContainer container = mhContainerService.selectMhContainerById(mhContainer.getId());
        if (container != null) {
            int updateRows = mhContainerService.updateMhContainer(mhContainer);
            if (updateRows > 0) {
                return AjaxResult.success("修改成功");
            } else {
                return AjaxResult.error("修改失败");
            }
        } else {
            int addRows = mhContainerService.insertMhContainer(mhContainer);
            if (addRows > 0) {

                return AjaxResult.success("新增成功");
            } else {
                return AjaxResult.success("新增失败");
            }
        }
    }

    /**
     * 新增集装箱表体信息
     */
    @PostMapping("/body")
    public AjaxResult add(@RequestBody MbContainer mbContainer) {
        MhContainer Container = mhContainerService.selectMhContainerById(mbContainer.getHeadId());
        if (Container == null) {
            return AjaxResult.error("请先保存该记录的基础信息");
        }

        /** 判断是否有未出场的集装箱记录 */
        MbContainer codes = mbContainerService.selectMbContainerCode(mbContainer.getCode());
        if (codes != null) {
            return AjaxResult.error("有未出场的集装箱记录");
        }


        int rows = mbContainerService.insertMbContainer(mbContainer);
        if (rows == 0) {
            return AjaxResult.error("新增失败");

        } else if (rows == -1) {
            return AjaxResult.error("新增失败,请先添加通关单信息");

        } else if (rows == -2) {
            return AjaxResult.error("新增失败,提货重量大于剩余重量");
        }
        return AjaxResult.success("新增成功");
    }

    /**
     * 修改集装箱表体
     */
    @Log(title = "集装箱体", businessType = BusinessType.UPDATE)
    @PutMapping("/body")
    public AjaxResult editBody(@RequestBody MbContainer mbContainer) {
        return toAjax(mbContainerService.updateMbContainer(mbContainer));
    }

    /**
     * 获取集装箱体详细信息
     */

    @GetMapping(value = "/body/{id}")
    public AjaxResult getBodyInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(mbContainerService.selectMbContainerBodyById(id));
    }


    /**
     * 修改集装箱管理Head
     */
    @PreAuthorize("@ss.hasPermi('container:container:edit')")
    @Log(title = "集装箱管理Head", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MhContainer mhContainer) {
        return toAjax(mhContainerService.updateMhContainer(mhContainer));
    }

    /**
     * 删除集装箱管理Head
     */
    @PreAuthorize("@ss.hasPermi('container:container:remove')")
    @Log(title = "集装箱管理Head", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(mhContainerService.deleteMhContainerByIds(ids));
    }

    /**
     * 初始化登录人页面信息
     */
    @GetMapping("/init")
    @ApiOperation("初始化页面信息")
    public AjaxResult init() {
        MhContainer mhContainer = mhContainerService.init();
        return AjaxResult.success(mhContainer);
    }
}
