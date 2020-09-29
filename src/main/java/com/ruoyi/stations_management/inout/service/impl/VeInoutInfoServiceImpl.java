package com.ruoyi.stations_management.inout.service.impl;

import com.ruoyi.stations_management.inout.domain.VeInoutInfo;
import com.ruoyi.stations_management.inout.mapper.VeInoutInfoMapper;
import com.ruoyi.stations_management.inout.service.IVeInoutInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 进出场查询Service业务层处理
 *
 * @author qishuai
 * @date 2020-01-02
 */
@Service
public class VeInoutInfoServiceImpl implements IVeInoutInfoService
{
    @Autowired
    private VeInoutInfoMapper veInoutInfoMapper;



    /**
     * 查询进出场查询列表
     *
     * @param veInoutInfo 进出场查询
     * @return 进出场查询
     */
    @Override
    public List<VeInoutInfo> selectVeInoutInfoList(VeInoutInfo veInoutInfo)
    {
        return veInoutInfoMapper.selectVeInoutInfoList(veInoutInfo);
    }


}
