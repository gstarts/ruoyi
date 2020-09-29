package com.ruoyi.stations_management.vehicle.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.vehicle.mapper.SVehicleInfoMapper;
import com.ruoyi.stations_management.vehicle.domain.SVehicleInfo;
import com.ruoyi.stations_management.vehicle.service.ISVehicleInfoService;

/**
 * 车辆备案Service业务层处理
 *
 * @author qishuai
 * @date 2020-01-01
 */
@Service
public class SVehicleInfoServiceImpl implements ISVehicleInfoService
{
    @Autowired
    private SVehicleInfoMapper sVehicleInfoMapper;

    /**
     * 查询车辆备案
     *
     * @param id 车辆备案ID
     * @return 车辆备案
     */
    @Override
    public SVehicleInfo selectSVehicleInfoById(Long id)
    {
        return sVehicleInfoMapper.selectSVehicleInfoById(id);
    }

    /**
     * 查询车辆备案列表
     *
     * @param sVehicleInfo 车辆备案
     * @return 车辆备案
     */
    @Override
    public List<SVehicleInfo> selectSVehicleInfoList(SVehicleInfo sVehicleInfo)
    {
        return sVehicleInfoMapper.selectSVehicleInfoList(sVehicleInfo);
    }

    /**
     * 新增车辆备案
     *
     * @param sVehicleInfo 车辆备案
     * @return 结果
     */
    @Override
    public int insertSVehicleInfo(SVehicleInfo sVehicleInfo)
    {
        return sVehicleInfoMapper.insertSVehicleInfo(sVehicleInfo);
    }

    /**
     * 修改车辆备案
     *
     * @param sVehicleInfo 车辆备案
     * @return 结果
     */
    @Override
    public int updateSVehicleInfo(SVehicleInfo sVehicleInfo)
    {
        return sVehicleInfoMapper.updateSVehicleInfo(sVehicleInfo);
    }

    /**
     * 批量删除车辆备案
     *
     * @param ids 需要删除的车辆备案ID
     * @return 结果
     */
    @Override
    public int deleteSVehicleInfoByIds(Long[] ids)
    {
        return sVehicleInfoMapper.deleteSVehicleInfoByIds(ids);
    }

    /**
     * 删除车辆备案信息
     *
     * @param id 车辆备案ID
     * @return 结果
     */
    @Override
    public int deleteSVehicleInfoById(Long id)
    {
        return sVehicleInfoMapper.deleteSVehicleInfoById(id);
    }

    @Override
    public List<Map<String,String>> selectLicenseList() {
        return sVehicleInfoMapper.selectLicenseList();
    }

    @Override
    public int uniteSVehicleInfo(Long id) {
        return sVehicleInfoMapper.uniteSVehicleInfo(id);
    }

    @Override
    public int bindSVehicleInfo(SVehicleInfo sVehicleInfo) {
        return sVehicleInfoMapper.bindSVehicleInfo(sVehicleInfo);
    }
}
