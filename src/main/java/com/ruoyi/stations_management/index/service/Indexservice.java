package com.ruoyi.stations_management.index.service;

import com.ruoyi.stations_management.index.domain.MainPicture;
import com.ruoyi.stations_management.index.domain.Vehicle;
import com.ruoyi.stations_management.stock.domain.StockFlow;

import java.util.List;
import java.util.Map;

public interface Indexservice {

    Long getGoodsNum();
    Map<String, Integer> getDeclareNum();

    List<StockFlow> getGoodsDetails();

    Map<String, Integer>  getAbnormalData();

    List<MainPicture> getMainPicture();

    List<Vehicle> getSiteVehicles();
}
