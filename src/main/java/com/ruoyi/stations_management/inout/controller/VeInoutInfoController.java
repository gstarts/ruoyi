package com.ruoyi.stations_management.inout.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.inout.domain.VeInoutInfo;
import com.ruoyi.stations_management.inout.service.IVeInoutInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 进出场查询Controller
 *
 * @author qishuai
 * @date 2020-01-02
 */
@Api("进出场查询")
@RestController
@RequestMapping("/inout/inoutinfo")
public class VeInoutInfoController extends BaseController
{
    @Autowired
    private IVeInoutInfoService veInoutInfoService;

    /**
     * 查询进出场查询列表
     */
    @ApiOperation("查询进出场查询列表")
    @ApiImplicitParam(name = "veInoutInfo", value = "查询进出场查询列表", dataType = "VeInoutInfo")
    @PreAuthorize("@ss.hasPermi('inout:inoutinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(VeInoutInfo veInoutInfo)
    {
        startPage();
        List<VeInoutInfo> list = veInoutInfoService.selectVeInoutInfoList(veInoutInfo);
        return getDataTable(list);
    }

}
