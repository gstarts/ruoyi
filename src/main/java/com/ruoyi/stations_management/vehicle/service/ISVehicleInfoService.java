package com.ruoyi.stations_management.vehicle.service;

import com.ruoyi.stations_management.vehicle.domain.SVehicleInfo;
import java.util.List;
import java.util.Map;

/**
 * 车辆备案Service接口
 *
 * @author qishuai
 * @date 2020-01-01
 */
public interface ISVehicleInfoService
{
    /**
     * 查询车辆备案
     *
     * @param id 车辆备案ID
     * @return 车辆备案
     */
    public SVehicleInfo selectSVehicleInfoById(Long id);

    /**
     * 查询车辆备案列表
     *
     * @param sVehicleInfo 车辆备案
     * @return 车辆备案集合
     */
    public List<SVehicleInfo> selectSVehicleInfoList(SVehicleInfo sVehicleInfo);

    /**
     * 新增车辆备案
     *
     * @param sVehicleInfo 车辆备案
     * @return 结果
     */
    public int insertSVehicleInfo(SVehicleInfo sVehicleInfo);

    /**
     * 修改车辆备案
     *
     * @param sVehicleInfo 车辆备案
     * @return 结果
     */
    public int updateSVehicleInfo(SVehicleInfo sVehicleInfo);

    /**
     * 批量删除车辆备案
     *
     * @param ids 需要删除的车辆备案ID
     * @return 结果
     */
    public int deleteSVehicleInfoByIds(Long[] ids);

    /**
     * 删除车辆备案信息
     *
     * @param id 车辆备案ID
     * @return 结果
     */
    public int deleteSVehicleInfoById(Long id);

    public List<Map<String,String>> selectLicenseList();

    /**
     * 解除绑定IC卡
     *
     * @param id 车辆备案ID
     * @return 结果
     */
    public int uniteSVehicleInfo(Long id);

    /**
     * 绑定IC卡
     * @param sVehicleInfo 车辆备案
     * @return 结果
     */
    public int bindSVehicleInfo(SVehicleInfo sVehicleInfo);
}
