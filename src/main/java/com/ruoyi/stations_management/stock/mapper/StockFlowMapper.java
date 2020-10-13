package com.ruoyi.stations_management.stock.mapper;

import java.util.List;
import com.ruoyi.stations_management.stock.domain.StockFlow;
import com.ruoyi.stations_management.stock.domain.StockInfo;

/**
 * 库存流水Mapper接口
 *
 * @author qishuai
 * @date 2020-07-24
 */
public interface StockFlowMapper
{
    /**
     * 查询库存流水
     *
     * @param id 库存流水ID
     * @return 库存流水
     */
     StockFlow selectStockFlowById(Long id);

    /**
     * 查询库存流水列表
     *
     * @param stockInfo 库存流水
     * @return 库存流水集合
     */
     List<StockFlow> selectStockFlowList(StockInfo stockInfo);

    /**
     * 新增库存流水
     *
     * @param stockFlow 库存流水
     * @return 结果
     */
     int insertStockFlow(StockFlow stockFlow);

    /**
     * 修改库存流水
     *
     * @param stockFlow 库存流水
     * @return 结果
     */
     int updateStockFlow(StockFlow stockFlow);


     int updateStockFlowBySourceId(StockFlow stockFlow);

    /**
     * 删除库存流水
     *
     * @param id 库存流水ID
     * @return 结果
     */
     int deleteStockFlowById(Long id);

     int deleteStockFlowBySourceId(String id);

    /**
     * 批量删除库存流水
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteStockFlowByIds(Long[] ids);

     int  deleteStockFlowBySourceIds(String[] ids);

    /**
     * 仓库商品详情
     * @return 结果
     */
    List<StockFlow> cargoDetails();
}
