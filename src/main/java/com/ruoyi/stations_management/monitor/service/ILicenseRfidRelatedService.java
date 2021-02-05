package com.ruoyi.stations_management.monitor.service;

import com.ruoyi.stations_management.monitor.domain.LicenseRfidRelated;

import java.util.List;

/**
 * 车牌号与电子车牌号对照Service接口
 * 
 * @author lanzhenyuan
 * @date 2021-02-05
 */
public interface ILicenseRfidRelatedService 
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
     * 获取全部关联数据
     * @return
     */
     List<LicenseRfidRelated> selectAll();

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
     * 批量删除车牌号与电子车牌号对照
     * 
     * @param ids 需要删除的车牌号与电子车牌号对照ID
     * @return 结果
     */
     int deleteLicenseRfidRelatedByIds(Long[] ids);

    /**
     * 删除车牌号与电子车牌号对照信息
     * 
     * @param id 车牌号与电子车牌号对照ID
     * @return 结果
     */
     int deleteLicenseRfidRelatedById(Long id);
}
