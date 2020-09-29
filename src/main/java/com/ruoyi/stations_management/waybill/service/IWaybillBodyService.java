package com.ruoyi.stations_management.waybill.service;

import com.ruoyi.stations_management.waybill.domain.WaybillBody;
import java.util.List;

/**
 * 提运单申报Service接口
 *
 * @author qishuai
 * @date 2020-03-03
 */
public interface IWaybillBodyService
{
    /**
     * 查询提运单申报
     *
     * @param id 提运单申报ID
     * @return 提运单申报
     */
    public WaybillBody selectSWaybillBodyById(Long id);


    /**
     *  查询提运单申报列表
     * @param headId 表头id
     * @return 提运单表体列表
     */
    public List<WaybillBody> selectSWaybillBodyList(Long headId);

    /**
     * 新增提运单申报
     *
     * @param waybillBody 提运单申报
     * @return 结果
     */
    public int insertSWaybillBody(WaybillBody waybillBody);

    /**
     * 修改提运单申报
     *
     * @param waybillBody 提运单申报
     * @return 结果
     */
    public int updateSWaybillBody(WaybillBody waybillBody);

    /**
     * 批量删除提运单申报
     *
     * @param ids 需要删除的提运单申报ID
     * @return 结果
     */
    public int deleteSWaybillBodyByIds(Long[] ids);

    /**
     * 删除提运单申报信息
     *
     * @param id 提运单申报ID
     * @return 结果
     */
    public int deleteSWaybillBodyById(Long id);
}
