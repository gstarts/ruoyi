package com.ruoyi.stations_management.stock.service.impl;

import com.ruoyi.stations_management.stock.domain.StockFlow;
import com.ruoyi.stations_management.stock.domain.StockInfo;
import com.ruoyi.stations_management.stock.mapper.StockFlowMapper;
import com.ruoyi.stations_management.stock.mapper.StockInfoMapper;
import com.ruoyi.stations_management.stock.service.IStockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库存信息Service业务层处理
 *
 * @author qishuai
 * @date 2020-03-31
 */
@Service
public class StockInfoServiceImpl implements IStockInfoService {
    @Autowired
    private StockInfoMapper stockInfoMapper;
    @Autowired
    private StockFlowMapper StockFlowMapper;
    /**
     * 查询库存信息列表
     *
     * @param stockInfo 库存信息
     * @return 库存信息
     */
    @Override
    public List<StockInfo> selectStockInfoList(StockInfo stockInfo) {
        List<StockInfo> stockInfos = stockInfoMapper.selectStockInfoList(stockInfo);
        for (StockInfo stock:stockInfos) {
                    stock.setzWeingt(String.valueOf(Integer.parseInt(stock.getiWeight())-Integer.parseInt(stock.geteWeight())));
        }
        return stockInfos;
    }

    @Override
    public List<StockFlow> selectStockFlowList(StockInfo stockInfo) {
        return StockFlowMapper.selectStockFlowList(stockInfo);
    }

}
