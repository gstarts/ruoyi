package com.ruoyi.stations_management.waybill.service.impl;

import com.ruoyi.stations_management.waybill.domain.CustomsClearance;
import com.ruoyi.stations_management.waybill.domain.WaybillBody;
import com.ruoyi.stations_management.waybill.mapper.CustomsClearanceMapper;
import com.ruoyi.stations_management.waybill.mapper.WaybillBodyMapper;
import com.ruoyi.stations_management.waybill.mapper.WaybillHeadMapper;
import com.ruoyi.stations_management.waybill.service.IWaybillBodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提运单申报Service业务层处理
 *
 * @author qishuai
 * @date 2020-03-03
 */
@Service
public class WaybillBodyServiceImpl implements IWaybillBodyService {
    @Autowired
    private WaybillBodyMapper waybillBodyMapper;
    @Autowired
    private WaybillHeadMapper waybillHeadMapper;
    @Autowired
    private CustomsClearanceMapper customsClearanceMapper;

    /**
     * 查询提运单申报
     *
     * @param id 提运单申报ID
     * @return 提运单申报
     */
    @Override
    public WaybillBody selectSWaybillBodyById(Long id) {
        return waybillBodyMapper.selectWaybillBodyById(id);
    }

    /**
     * 查询提运单申报列表
     *
     * @param headId 头id
     * @return 提运单申报
     */
    @Override
    public List<WaybillBody> selectSWaybillBodyList(Long headId) {
        return waybillBodyMapper.selectWaybillBodyList(headId);
    }

    /**
     * 新增提运单申报
     *
     * @param waybillBody 提运单申报
     * @return 结果
     */
    @Override
    public int insertSWaybillBody(WaybillBody waybillBody) {
        // 计算表体序号
        int gon = waybillBodyMapper.selectMaxGnoByHeadId(waybillBody.getHeadId());
        waybillBody.setOutRealityWt(waybillBody.getGoodswt());
        waybillBody.setGno(gon + 1);
        CustomsClearance cc = new CustomsClearance();
        cc.setCcCustomsNumber(waybillBody.getBindobjid());
        cc.setCcCustomsBatchNumber(waybillBody.getVoyageno());
        cc.setCcLastWieght(waybillBody.getGoodswt());
        CustomsClearance customsClearance = customsClearanceMapper.selectwaybillBodyadd(cc);
        // 通关单不存在返回-1
        if (null == customsClearance) {
            return -1;
        }
        // 通关单剩余重量不足在返回-2
        else if (Integer.parseInt(customsClearance.getCcLastWieght()) - Integer.parseInt(waybillBody.getGoodswt()) < 0) {
            return -2;
        } else {
            return waybillBodyMapper.insertWaybillBody(waybillBody);
        }

    }

    /**
     * 修改提运单申报
     *
     * @param waybillBody 提运单申报
     * @return 结果
     */
    @Override
    public int updateSWaybillBody(WaybillBody waybillBody) {
        int result = 0;
        waybillBody.setOutRealityWt(waybillBody.getGoodswt());
        result = waybillBodyMapper.updateWaybillBody(waybillBody);
        if (result > 0) {
            // 修改成功后记录更新为待审报状态
            waybillHeadMapper.updateFeedback(waybillBody.getHeadId());
        }
        return result;
    }

    /**
     * 批量删除提运单申报
     *
     * @param ids 需要删除的提运单申报ID
     * @return 结果
     */
    @Override
    public int deleteSWaybillBodyByIds(Long[] ids) {
        for (int i = 0; i < ids.length; i++) {
            deleteBefore(ids[i]);
        }
        return waybillBodyMapper.deleteWaybillBodyByIds(ids);
    }

    /**
     * 删除提运单申报信息
     *
     * @param id 提运单申报ID
     * @return 结果
     */
    @Override
    public int deleteSWaybillBodyById(Long id) {
        WaybillBody body = waybillBodyMapper.selectWaybillBodyById(id);
        Map map = new HashMap();
        map.put("headId", body.getHeadId());
        map.put("Gno", body.getGno());
        waybillBodyMapper.delBefore(map);
        return waybillBodyMapper.deleteWaybillBodyById(id);
    }

    private int deleteBefore(Long id) {
        WaybillBody body = waybillBodyMapper.selectWaybillBodyById(id);
        Map map = new HashMap();
        map.put("headId", body.getHeadId());
        map.put("Gno", body.getGno());
        return waybillBodyMapper.delBefore(map);
    }

}
