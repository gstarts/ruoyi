package com.ruoyi.stations_management.inout.mapper;

import com.ruoyi.stations_management.inout.domain.VeInoutInfo;

import java.util.List;

/**
 * 进出场查询Mapper接口
 *
 * @author qishuai
 * @date 2020-01-02
 */
public interface VeInoutInfoMapper
{


    /**
     * 查询进出场查询列表
     *
     * @param veInoutInfo 进出场查询
     * @return 进出场查询集合
     */
    public List<VeInoutInfo> selectVeInoutInfoList(VeInoutInfo veInoutInfo);


}
