package com.ruoyi.stations_management.monitor.mapper;

import com.ruoyi.stations_management.monitor.domain.LicenseRfidRelated;

import java.util.List;

/**
 * 车牌号与电子车牌号对照Mapper接口
 * 
 * @author lanzhenyuan
 * @date 2021-02-05
 */
public interface LicenseRfidRelatedMapper 
{
    /**
     * 查询车牌号与电子车牌号对照
     * 
     * @param id 车牌号与电子车牌号对照ID
     * @return 车牌号与电子车牌号对照
     */
     LicenseRfidRelated selectLicenseRfidRelatedById(Long id);

    /**
     * 查询车牌号与电子车牌号对照列表
     * 
     * @param licenseRfidRelated 车牌号与电子车牌号对照
     * @return 车牌号与电子车牌号对照集合
     */
     List<LicenseRfidRelated> selectLicenseRfidRelatedList(LicenseRfidRelated licenseRfidRelated);

    /**
     * 获当前表全部数据
     * @return 结果
     */
     List<LicenseRfidRelated> selectALL();


    /**
     * 新增车牌号与电子车牌号对照
     * 
     * @param licenseRfidRelated 车牌号与电子车牌号对照
     * @return 结果
     */
     int insertLicenseRfidRelated(LicenseRfidRelated licenseRfidRelated);

    /**
     * 修改车牌号与电子车牌号对照
     * 
     * @param licenseRfidRelated 车牌号与电子车牌号对照
     * @return 结果
     */
     int updateLicenseRfidRelated(LicenseRfidRelated licenseRfidRelated);

    /**
     * 删除车牌号与电子车牌号对照
     * 
     * @param id 车牌号与电子车牌号对照ID
     * @return 结果
     */
     int deleteLicenseRfidRelatedById(Long id);

    /**
     * 批量删除车牌号与电子车牌号对照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteLicenseRfidRelatedByIds(Long[] ids);
}
