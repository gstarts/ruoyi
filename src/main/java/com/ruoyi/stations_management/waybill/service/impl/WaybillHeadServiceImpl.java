package com.ruoyi.stations_management.waybill.service.impl;

import com.ruoyi.common.constant.DeclareStatus;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.stations_management.common.domain.StationInfo;
import com.ruoyi.stations_management.common.mapper.StationInfoMapper;
import com.ruoyi.stations_management.waybill.domain.Waybill;
import com.ruoyi.stations_management.waybill.domain.WaybillBody;
import com.ruoyi.stations_management.waybill.domain.WaybillHead;
import com.ruoyi.stations_management.waybill.mapper.WaybillBodyMapper;
import com.ruoyi.stations_management.waybill.mapper.WaybillHeadMapper;
import com.ruoyi.stations_management.waybill.service.IWaybillHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提运单申报Service业务层处理
 *
 * @author qishuai
 * @date 2020-03-02
 */
@Service
public class WaybillHeadServiceImpl implements IWaybillHeadService {
    @Autowired
    private WaybillHeadMapper waybillHeadMapper;
    @Autowired
    private WaybillBodyMapper waybillBodyMapper;
    @Autowired
    private StationInfoMapper stationInfoMapper;

    /**
     * 查询提运单申报
     *
     * @param id 提运单申报ID
     * @return 提运单申报
     */
    @Override
    public WaybillHead selectSWaybillHeadById(Long id) {
        return waybillHeadMapper.selectWaybillHeadById(id);
    }

    /**
     * 查询提运单申报列表
     *
     * @param waybillHead 提运单申报
     * @return 提运单申报
     */
    @Override
    public List<WaybillHead> selectSWaybillHeadList(WaybillHead waybillHead) {
        return waybillHeadMapper.selectWaybillHeadList(waybillHead);
    }

    /**
     * 新增提运单申报
     *
     * @param waybillHead 提运单申报
     * @return 结果
     */
    @Override
    public int insertSWaybillHead(WaybillHead waybillHead) {
        if (DeclareStatus.DECLARE_ALREADY.equals(waybillHead.getFeedback())) {
            declareCheck(waybillHead);
        } else if (waybillHead.getFeedback() == null || DeclareStatus.DECLARE_ERR.equals(waybillHead.getFeedback()) ) {
            waybillHead.setFeedback(DeclareStatus.DECLARE_WAIT);
        }
        return waybillHeadMapper.insertWaybillHead(waybillHead);
    }

    /**
     * 修改提运单申报
     *
     * @param waybillHead 提运单申报
     * @return 结果
     */
    @Override
    public int updateSWaybillHead(WaybillHead waybillHead) {
        if (DeclareStatus.DECLARE_ALREADY.equals(waybillHead.getFeedback())) {
            declareCheck(waybillHead);
        } else if (waybillHead.getFeedback() == null || DeclareStatus.DECLARE_ERR.equals( waybillHead.getFeedback())) {
            waybillHead.setFeedback(DeclareStatus.DECLARE_WAIT);
        }
        waybillHead.setFeedbackMsg("");
        return waybillHeadMapper.updateWaybillHead(waybillHead);
    }

    /**
     * 申报前进行校验
     *
     * @param waybillHead 申报数据
     *                    返回申报结果
     */
    private void declareCheck(WaybillHead waybillHead) {
        List<WaybillBody> list = waybillBodyMapper.selectWaybillBodyList(waybillHead.getId());
        if (null == list || list.size() == 0) {
            throw new CustomException("申报失败,该数据没有表体信息！");
        }

    }

    /**
     * 批量提交提运单申报
     *
     * @param ids 需要删除的提运单申报ID
     * @return 结果
     */
    @Override
    public int decSWaybillHeadByIds(Long[] ids){

        return waybillHeadMapper.decWaybillHeadByIds(ids);
    }

    /**
     * 删除提运单申报信息
     *
     * @param id 提运单申报ID
     * @return 结果
     */
    @Override
    public int deleteSWaybillHeadById(Long id) {
        Map mp =new HashMap(2);
        mp.put("id",String.valueOf(id));
        mp.put("res","");
        waybillHeadMapper.deleteWaybillHeadById(mp);
        return (int)mp.get("res");
    }

    @Override
    @Transactional
    public int insertSWaybill(Waybill waybill) {
        // 根据头id 查询
        int head ;
        int body = 0;
        WaybillHead result = waybillHeadMapper.selectWaybillHeadById(waybill.getHead().getId());
        if (result != null) {
            head = waybillHeadMapper.updateWaybillHead(waybill.getHead());
            if (waybill.getBody() != null) {
                body = waybillBodyMapper.updateWaybillBody(waybill.getBody());
            }
        } else {
            head = waybillHeadMapper.insertWaybillHead(waybill.getHead());
            if (waybill.getBody() != null) {
                body = waybillBodyMapper.insertWaybillBody(waybill.getBody());
            }
        }

        return head > 0 && body > 0 ? head + body : 0;
    }


    @Override
    public WaybillHead init(Long stationId) {
        WaybillHead head = new WaybillHead();
        StationInfo stationInfo = stationInfoMapper.selectStationInfoById(stationId);
        head.setContractorcode(stationInfo.getContractorcode());
        head.setContractorcodescc(stationInfo.getContractorcodescc());
        head.setOpuserid(stationInfo.getOpuserid());
        head.setCustomsmaster(stationInfo.getCustomsmaster());
        // 获取当前时间 转为YYYY-MM-DD HH:mm:ss
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        String nowDate = sdf.format(date);
        head.setOptime(nowDate);
        head.setId(date.getTime());
        head.setTrailerweight("0");
        head.setVehicleweight("0");
        head.setContaweight("0");
        return head;
    }

    @Override
    public String vehicleNoCheck(String vehicleNo ,Long headId) {
        if(waybillHeadMapper.selectWaybillHeadById(headId)==null && waybillHeadMapper.undoneWaybillByVehicleNo(vehicleNo)>0){
            return "该车有未完成记录";
        }
        return null;
    }

    @Override
    public int reject(String id, String message) {
        return waybillHeadMapper.reject(id,message);
    }

    @Override
    public int artificial(String id) {
        return waybillHeadMapper.artificial(id);
    }

}
