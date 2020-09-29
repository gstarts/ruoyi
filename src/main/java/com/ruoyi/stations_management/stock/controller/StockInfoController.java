package com.ruoyi.stations_management.stock.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.stock.domain.StockFlow;
import com.ruoyi.stations_management.stock.domain.StockInfo;
import com.ruoyi.stations_management.stock.service.IStockInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 库存信息 Controller
 *
 * @author qishuai
 * @date 2020-03-31
 */
@Api(tags = "库存信息管理")
@RestController
@RequestMapping("/stock")
public class StockInfoController extends BaseController {
    @Autowired
    private IStockInfoService stockInfoService;

    /**
     * 查询库存信息列表
     */
    @ApiOperation("查询库存信息列表")
    @ApiImplicitParam(name = "stockInfo", value = "查询库存信息列表", dataType = "StockInfo")
    @PreAuthorize("@ss.hasPermi('stock:info:list')")
    @GetMapping("/info/list")
    public TableDataInfo list(StockInfo stockInfo) {
        startPage();
        List<StockInfo> list = stockInfoService.selectStockInfoList(stockInfo);
        return getDataTable(list);
    }

    @GetMapping("/flow/list")
    public TableDataInfo flowList(StockInfo stockInfo) {
        startPage();
        List<StockFlow> list = stockInfoService.selectStockFlowList(stockInfo);
        return getDataTable(list);
    }
}
