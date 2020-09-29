package com.ruoyi.stations_management.stock.service;

import com.ruoyi.stations_management.stock.domain.StockFlow;
import com.ruoyi.stations_management.stock.domain.StockInfo;

import java.util.List;

/**
 * 库存信息Service接口
 *
 * @author qishuai
 * @date 2020-03-31
 */
public interface IStockInfoService {


    /**
     * 查询库存信息列表
     *
     * @param stockInfo 库存信息
     * @return 库存信息集合
     */
    public List<StockInfo> selectStockInfoList(StockInfo stockInfo);

    List<StockFlow> selectStockFlowList(StockInfo stockInfo);
}
