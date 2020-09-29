package com.ruoyi.stations_management.report.mapper;

import java.util.List;

import com.ruoyi.stations_management.report.domain.MtBorderTransport;
import com.ruoyi.stations_management.report.domain.Rmft4406Head;

/**
 * 运输工具信息 Mapper接口
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
public interface MtBorderTransportMapper {
    /**
     * 查询运输工具信息
     *
     * @param pId 运输工具信息 ID
     * @return 运输工具信息
     */
    public MtBorderTransport selectMtBorderTransportById(Long pId);

    /**
     * 查询运输工具信息 列表
     *
     * @param mtBorderTransport 运输工具信息
     * @return 运输工具信息 集合
     */
    public List<MtBorderTransport> selectMtBorderTransportList(MtBorderTransport mtBorderTransport);

    /**
     * 查询异常车辆信息
     *
     * @param rmft4406Head 运输工具信息
     * @return 异常车辆信息 集合
     */
    public List<Rmft4406Head> selectErrList(Rmft4406Head rmft4406Head);

    /**
     * 新增运输工具信息
     *
     * @param mtBorderTransport 运输工具信息
     * @return 结果
     */
    public int insertMtBorderTransport(MtBorderTransport mtBorderTransport);

    /**
     * 修改运输工具信息
     *
     * @param mtBorderTransport 运输工具信息
     * @return 结果
     */
    public int updateMtBorderTransport(MtBorderTransport mtBorderTransport);

    /**
     * 删除运输工具信息
     *
     * @param pId 运输工具信息 ID
     * @return 结果
     */
    public int deleteMtBorderTransportById(Long pId);

    /**
     * 批量删除运输工具信息
     *
     * @param pIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMtBorderTransportByIds(Long[] pIds);
}
