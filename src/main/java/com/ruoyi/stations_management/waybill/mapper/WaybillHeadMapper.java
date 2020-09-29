package com.ruoyi.stations_management.waybill.mapper;

import com.ruoyi.stations_management.waybill.domain.WaybillHead;

import java.util.List;
import java.util.Map;

/**
 * 提运单申报Mapper接口
 *
 * @author qishuai
 * @date 2020-03-02
 */
public interface WaybillHeadMapper
{
    /**
     * 查询提运单申报
     *
     * @param id 提运单申报ID
     * @return 提运单申报
     */
    public WaybillHead selectWaybillHeadById(Long id);

    /**
     * 查询提运单申报列表
     *
     * @param waybillHead 提运单申报
     * @return 提运单申报集合
     */
    public List<WaybillHead> selectWaybillHeadList(WaybillHead waybillHead);

    /**
     * 新增提运单申报
     *
     * @param waybillHead 提运单申报
     * @return 结果
     */
    public int insertWaybillHead(WaybillHead waybillHead);

    /**
     * 修改提运单申报
     *
     * @param waybillHead 提运单申报
     * @return 结果
     */
    public int updateWaybillHead(WaybillHead waybillHead);

    /**
     * 删除提运单申报
     *
     * @param mp 提运单申报ID
     * @return 结果
     */
    void deleteWaybillHeadById(Map mp);

    /**
     * 批量申报提运单申报
     *
     * @param ids 需要申报的数据ID
     * @return 结果
     */
    public int decWaybillHeadByIds(Long[] ids);


   public int undoneWaybillByVehicleNo(String vehicleNo );

   public int updateFeedback(Long id);

    public int reject(String id, String message);

    public int artificial(String id);
}
