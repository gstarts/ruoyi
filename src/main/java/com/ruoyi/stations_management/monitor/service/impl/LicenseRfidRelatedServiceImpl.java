package com.ruoyi.stations_management.monitor.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.stations_management.monitor.domain.LicenseRfidRelated;
import com.ruoyi.stations_management.monitor.mapper.LicenseRfidRelatedMapper;
import com.ruoyi.stations_management.monitor.service.ILicenseRfidRelatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 车牌号与电子车牌号对照Service业务层处理
 * 
 * @author lanzhenyuan
 * @date 2021-02-05
 */
@Service
public class LicenseRfidRelatedServiceImpl implements ILicenseRfidRelatedService
{
    @Resource
    private LicenseRfidRelatedMapper licenseRfidRelatedMapper;

    /**
     * 查询车牌号与电子车牌号对照
     * 
     * @param id 车牌号与电子车牌号对照ID
     * @return 车牌号与电子车牌号对照
     */
    @Override
    public LicenseRfidRelated selectLicenseRfidRelatedById(Long id)
    {
        return licenseRfidRelatedMapper.selectLicenseRfidRelatedById(id);
    }

    /**
     * 查询车牌号与电子车牌号对照列表
     * 
     * @param licenseRfidRelated 车牌号与电子车牌号对照
     * @return 车牌号与电子车牌号对照
     */
    @Override
    public List<LicenseRfidRelated> selectLicenseRfidRelatedList(LicenseRfidRelated licenseRfidRelated)
    {
        return licenseRfidRelatedMapper.selectLicenseRfidRelatedList(licenseRfidRelated);
    }

    @Override
    public List<LicenseRfidRelated> selectAll() {
        return licenseRfidRelatedMapper.selectALL();
    }

    /**
     * 新增车牌号与电子车牌号对照
     * 
     * @param licenseRfidRelated 车牌号与电子车牌号对照
     * @return 结果
     */
    @Override
    public int insertLicenseRfidRelated(LicenseRfidRelated licenseRfidRelated)
    {
        licenseRfidRelated.setCreateTime(DateUtils.getNowDate());
        return licenseRfidRelatedMapper.insertLicenseRfidRelated(licenseRfidRelated);
    }

    /**
     * 修改车牌号与电子车牌号对照
     * 
     * @param licenseRfidRelated 车牌号与电子车牌号对照
     * @return 结果
     */
    @Override
    public int updateLicenseRfidRelated(LicenseRfidRelated licenseRfidRelated)
    {
        licenseRfidRelated.setUpdateTime(DateUtils.getNowDate());
        return licenseRfidRelatedMapper.updateLicenseRfidRelated(licenseRfidRelated);
    }

    /**
     * 批量删除车牌号与电子车牌号对照
     * 
     * @param ids 需要删除的车牌号与电子车牌号对照ID
     * @return 结果
     */
    @Override
    public int deleteLicenseRfidRelatedByIds(Long[] ids)
    {
        return licenseRfidRelatedMapper.deleteLicenseRfidRelatedByIds(ids);
    }

    /**
     * 删除车牌号与电子车牌号对照信息
     * 
     * @param id 车牌号与电子车牌号对照ID
     * @return 结果
     */
    @Override
    public int deleteLicenseRfidRelatedById(Long id)
    {
        return licenseRfidRelatedMapper.deleteLicenseRfidRelatedById(id);
    }
}
