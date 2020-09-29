package com.ruoyi.stations_management.waybill.service;

import com.ruoyi.stations_management.waybill.domain.Waybill;
import com.ruoyi.stations_management.waybill.domain.WaybillHead;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * 提运单申报Service接口
 *
 * @author qishuai
 * @date 2020-03-02
 */
public interface IWaybillHeadService
{
    /**
     * 查询提运单申报列表
     *
     * @param waybillHead 提运单申报
     * @return 提运单申报集合
     */
     List<WaybillHead> selectSWaybillHeadList(WaybillHead waybillHead);

    /**
     * 查询提运单申报
     *
     * @param id 提运单申报ID
     * @return 提运单申报
     */
     WaybillHead selectSWaybillHeadById(Long id);

    /**
     * 新增提运单申报
     *
     * @param waybillHead 提运单申报
     * @return 结果
     */
     int insertSWaybillHead(WaybillHead waybillHead);

    /**
     * 修改提运单申报
     *
     * @param waybillHead 提运单申报
     * @return 结果
     */
     int updateSWaybillHead(WaybillHead waybillHead);

    /**
     * 批量提交提运单申报
     *
     * @param ids 需要申报的提运单申报ID
     * @return 结果
     */
     int decSWaybillHeadByIds(Long[] ids) throws JAXBException;

    /**
     * 删除提运单申报信息
     *
     * @param id 提运单申报ID
     * @return 结果
     */
     int deleteSWaybillHeadById(Long id);

    /**
     * 暂存提运单
     * @param waybill 提运单
     * @return 结果
     */
     int insertSWaybill(Waybill waybill);

    /**
     *  获取场站信息
     */




     WaybillHead init(Long stationId);

    /**
     * 车辆是否有未完成记录校验
     * @param vehicleNo 车牌号
     * @return 校验结果
     */
     String vehicleNoCheck(String vehicleNo ,Long headId);

    /**
     * 驳回
     * @param id 主键
     * @param message 驳回信息
     * @return 结果
     */
     int reject(String id , String message);

    /**
     * 场站人工办结
     * @param id 主键
     * @return 结果
     */

     int artificial(String id);
}

