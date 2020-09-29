package com.ruoyi.stations_management.waybill.mapper;

import com.ruoyi.stations_management.waybill.domain.WaybillBody;

import java.util.List;
import java.util.Map;

/**
 * 提运单申报Mapper接口
 *
 * @author qishuai
 * @date 2020-03-03
 */
public interface WaybillBodyMapper
{
    /**
     * 查询提运单申报
     *
     * @param id 提运单申报ID
     * @return 提运单申报
     */
    public WaybillBody selectWaybillBodyById(Long id);

    /**
     * 查询提运单申报列表
     *
     * @param id 表头主键
     * @return 提运单申报集合
     */
    public List<WaybillBody> selectWaybillBodyList(Long id);

    /**
     * 新增提运单申报
     *
     * @param waybillBody 提运单申报
     * @return 结果
     */
    public int insertWaybillBody(WaybillBody waybillBody);

    /**
     * 修改提运单申报
     *
     * @param waybillBody 提运单申报
     * @return 结果
     */
    public int updateWaybillBody(WaybillBody waybillBody);

    /**
     * 删除提运单申报
     *
     * @param id 提运单申报ID
     * @return 结果
     */
    public int deleteWaybillBodyById(Long id);

    /**
     * 批量删除提运单申报
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWaybillBodyByIds(Long[] ids);

    public int delBefore(Map map);

    public int selectMaxGnoByHeadId(Long id);
}
