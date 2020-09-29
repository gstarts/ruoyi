package com.ruoyi.stations_management.vehicle.mapper;

import com.ruoyi.stations_management.vehicle.domain.SVehicleInfo;
import java.util.List;
import java.util.Map;

/**
 * 车辆备案Mapper接口
 *
 * @author qishuai
 * @date 2020-01-01
 */
public interface SVehicleInfoMapper
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
     * 删除车辆备案
     *
     * @param id 车辆备案ID
     * @return 结果
     */
    public int deleteSVehicleInfoById(Long id);

    /**
     * 批量删除车辆备案
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSVehicleInfoByIds(Long[] ids);

    /**
     *  查询车牌号列表
     * @return
     */
    public List<Map<String,String>> selectLicenseList();

    /**
     * 绑定IC卡
     * @return
     */
    public int bindSVehicleInfo( SVehicleInfo sVehicleInfo);

    public  int uniteSVehicleInfo(Long id);
}
