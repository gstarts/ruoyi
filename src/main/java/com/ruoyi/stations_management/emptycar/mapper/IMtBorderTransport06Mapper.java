package com.ruoyi.stations_management.emptycar.mapper;

import java.util.List;

import com.ruoyi.stations_management.emptycar.domain.IMtBorderTransport06;
import com.ruoyi.stations_management.report.domain.MtBorderTransport;

/**
 * 运输工具信息 Mapper接口
 *
 * @author songqingchuan
 * @date 2020-06-15
 */
public interface IMtBorderTransport06Mapper {
    /**
     * 查询运输工具信息
     *
     * @param key 运输工具信息 ID
     * @return 运输工具信息
     */
    public IMtBorderTransport06 selectIMtBorderTransport06ById(Long key);

    /**
     * 查询运输工具信息 列表
     *
     * @param iMtBorderTransport06 运输工具信息
     * @return 运输工具信息 集合
     */
    public List<IMtBorderTransport06> selectIMtBorderTransport06List(IMtBorderTransport06 iMtBorderTransport06);

    /**
     * 查询异常车辆信息
     *
     * @param iMtBorderTransport06 运输工具信息
     * @return 异常车辆信息 集合
     */
    public List<IMtBorderTransport06> selectErrList(IMtBorderTransport06 iMtBorderTransport06);

    /**
     * 新增运输工具信息
     *
     * @param iMtBorderTransport06 运输工具信息
     * @return 结果
     */
    public int insertIMtBorderTransport06(IMtBorderTransport06 iMtBorderTransport06);

    /**
     * 修改运输工具信息
     *
     * @param iMtBorderTransport06 运输工具信息
     * @return 结果
     */
    public int updateIMtBorderTransport06(IMtBorderTransport06 iMtBorderTransport06);

    /**
     * 删除运输工具信息
     *
     * @param key 运输工具信息 ID
     * @return 结果
     */
    public int deleteIMtBorderTransport06ById(Long key);

    /**
     * 批量删除运输工具信息
     *
     * @param keys 需要删除的数据ID
     * @return 结果
     */
    public int deleteIMtBorderTransport06ByIds(Long[] keys);
}
