package com.ruoyi.stations_management.beltscale.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.stations_management.beltscale.domain.BeltScale;
import com.ruoyi.stations_management.beltscale.mapper.BeltScaleMapper;
import com.ruoyi.stations_management.beltscale.service.IBeltScaleService;
import com.ruoyi.stations_management.stock.domain.StockFlow;
import com.ruoyi.stations_management.stock.mapper.StockFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

/**
 * 皮带秤Service业务层处理
 *
 * @author qishuai
 * @date 2020-07-24
 */
@Service
public class BeltScaleServiceImpl implements IBeltScaleService {
    @Autowired
    private BeltScaleMapper beltScaleMapper;
    @Autowired
    private StockFlowMapper stockFlowMapper;

    /**
     * 查询皮带秤
     *
     * @param id 皮带秤ID
     * @return 皮带秤
     */
    @Override
    public BeltScale selectBeltScaleById(String id) {
        return beltScaleMapper.selectBeltScaleById(id);
    }

    /**
     * 查询皮带秤列表
     *
     * @param beltScale 皮带秤
     * @return 皮带秤
     */
    @Override
    public List<BeltScale> selectBeltScaleList(BeltScale beltScale) {
        return beltScaleMapper.selectBeltScaleList(beltScale);
    }

    /**
     * 新增皮带秤
     *
     * @param beltScale 皮带秤
     * @return 结果
     */
    @Override
    @Transactional
    public int insertBeltScale(BeltScale beltScale) {
        beltScale.setCreateTime(DateUtils.getNowDate());
        String uuid = UUID.randomUUID().toString();
        beltScale.setId(uuid);
        StockFlow stockFlow = new StockFlow();
        BeanUtils.copyBeanProp(stockFlow, beltScale);
        stockFlow.setSourceId(uuid);
        stockFlow.setDirection("E");
        Date date = DateUtils.dateTime(DateUtils.YYYYMMDDHHMMSS, beltScale.getTime() + "08:00:00");
        stockFlow.setOptime(DateUtils.parseDateToStr(DateUtils.TIME_FORMAT_ISO,date));
        stockFlow.setVeLicenseNo("皮带秤");
        stockFlowMapper.insertStockFlow(stockFlow);
        return beltScaleMapper.insertBeltScale(beltScale);
    }

    /**
     * 修改皮带秤
     *
     * @param beltScale 皮带秤
     * @return 结果
     */
    @Override
    @Transactional
    public int updateBeltScale(BeltScale beltScale) {
        beltScale.setUpdateTime(DateUtils.getNowDate());
        StockFlow stockFlow = new StockFlow();
        BeanUtils.copyBeanProp(stockFlow, beltScale);
        stockFlow.setSourceId(beltScale.getId());
        stockFlowMapper.updateStockFlowBySourceId(stockFlow);

        return beltScaleMapper.updateBeltScale(beltScale);
    }

    /**
     * 批量删除皮带秤
     *
     * @param ids 需要删除的皮带秤ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteBeltScaleByIds(String[] ids) {
        stockFlowMapper.deleteStockFlowBySourceIds(ids);
        return beltScaleMapper.deleteBeltScaleByIds(ids);
    }

    /**
     * 删除皮带秤信息
     *
     * @param id 皮带秤ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteBeltScaleById(String id) {
        stockFlowMapper.deleteStockFlowBySourceId(id);
        return beltScaleMapper.deleteBeltScaleById(id);
    }
}
