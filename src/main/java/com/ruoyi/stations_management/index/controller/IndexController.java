package com.ruoyi.stations_management.index.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.index.service.Indexservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/index")
public class IndexController extends BaseController {
   @Resource
    private Indexservice indexservice;

    /**
     * 获取货物数
     * @return 货物总数
     */
    @GetMapping("/goodsNum")
    public AjaxResult getGoodsNum(){
        return AjaxResult.success(indexservice.getGoodsNum());
    }

    /**
     * 获取申报数据
     * @return 申报数据
     */
    @GetMapping("/declareNum")
    public AjaxResult getDeclareNum(){
        return AjaxResult.success(indexservice.getDeclareNum());
    }

    /**
     * 仓库货物详情
     * @return 结果
     */
    @GetMapping("/details")
    public TableDataInfo getGoodsDetails(){
        return getDataTable(indexservice.getGoodsDetails());
    }

    /**
     * 通关异常车辆统计
     * @return 结果
     */
    @GetMapping("/abnormal")
    public AjaxResult getAbnormalData(){
        return AjaxResult.success(indexservice.getAbnormalData());
    }

    /**
     * 主图数据
     * @return 结果
     */
    @GetMapping("/mainPicture")
    public TableDataInfo getMainPicture(){
        return getDataTable(indexservice.getMainPicture());
    }
    /**
     * 车辆信息
     */
    @GetMapping("siteVehicles")
    public TableDataInfo getSiteVehicles(){
        return getDataTable(indexservice.getSiteVehicles());
    }
}
