package com.ruoyi.stations_management.index.service.impl;

import com.ruoyi.stations_management.declare.mapper.AnimalsHeadMapper;
import com.ruoyi.stations_management.declare.mapper.ContainerHeadMapper;
import com.ruoyi.stations_management.index.domain.IndexDao;
import com.ruoyi.stations_management.index.domain.MainPicture;
import com.ruoyi.stations_management.index.domain.Vehicle;
import com.ruoyi.stations_management.index.service.Indexservice;
import com.ruoyi.stations_management.monitor.domain.GatherDataLog;
import com.ruoyi.stations_management.monitor.mapper.GatherDataLogMapper;
import com.ruoyi.stations_management.stock.domain.StockFlow;
import com.ruoyi.stations_management.stock.mapper.StockFlowMapper;
import com.ruoyi.stations_management.stock.mapper.StockInfoMapper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImpl implements Indexservice {
    @Resource
    private StockInfoMapper stockInfoMapper;
    @Resource
    private AnimalsHeadMapper animalsHeadMapper;
    @Resource
    private ContainerHeadMapper containerHeadMapper;
    @Resource
    private StockFlowMapper stockFlowMapper;
    @Resource
    private GatherDataLogMapper gatherDataLogMapper;

    @Override
    public Long getGoodsNum() {
        return stockInfoMapper.stockTotal();
    }

    @Override
    public Map<String, Integer> getDeclareNum() {
        //集装箱申报数
        Map<String, Integer> map = new HashedMap();
        int conNum = containerHeadMapper.statistics();
        // 动植物申报数
        int aniNum = animalsHeadMapper.statistics();
        map.put("conNum", conNum);
        map.put("aniNum", aniNum);
        return map;

    }

    @Override
    public List<StockFlow> getGoodsDetails() {
        return stockFlowMapper.cargoDetails();
    }

    @Override
    public Map<String, Integer> getAbnormalData() {
        Map<String, Integer> map = new HashedMap();
        IndexDao abnormal = gatherDataLogMapper.abnormal();
        if (null == abnormal) {
            map.put("first", 0);
            map.put("second", 0);
            map.put("third", 0);
            map.put("fourth", 0);
        } else {
            map.put("first", abnormal.getFirstNum());
            map.put("second", abnormal.getSecondNum());
            map.put("third", abnormal.getThirdNum());
            map.put("fourth", abnormal.getFourthNum());
        }

        return map;
    }

    @Override
    public List<MainPicture> getMainPicture() {
        return gatherDataLogMapper.mainPicture();
    }

    @Override
    public List<Vehicle> getSiteVehicles() {
        return gatherDataLogMapper.siteVehicleInformation();
    }
}
