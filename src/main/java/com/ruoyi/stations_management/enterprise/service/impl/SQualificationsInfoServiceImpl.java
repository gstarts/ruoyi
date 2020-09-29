package com.ruoyi.stations_management.enterprise.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.enterprise.mapper.SQualificationsInfoMapper;
import com.ruoyi.stations_management.enterprise.domain.SQualificationsInfo;
import com.ruoyi.stations_management.enterprise.service.ISQualificationsInfoService;

/**
 * 企业资质管理Service业务层处理
 *
 * @author qishuai
 * @date 2020-01-02
 */
@Service
public class SQualificationsInfoServiceImpl implements ISQualificationsInfoService
{
    @Autowired
    private SQualificationsInfoMapper sQualificationsInfoMapper;

    /**
     * 查询企业资质管理
     *
     * @param id 企业资质管理ID
     * @return 企业资质管理
     */
    @Override
    public SQualificationsInfo selectSQualificationsInfoById(Long id)
    {
        return sQualificationsInfoMapper.selectSQualificationsInfoById(id);
    }

    /**
     * 查询企业资质管理列表
     *
     * @param sQualificationsInfo 企业资质管理
     * @return 企业资质管理
     */
    @Override
    public List<SQualificationsInfo> selectSQualificationsInfoList(SQualificationsInfo sQualificationsInfo)
    {
        return sQualificationsInfoMapper.selectSQualificationsInfoList(sQualificationsInfo);
    }

    /**
     * 新增企业资质管理
     *
     * @param sQualificationsInfo 企业资质管理
     * @return 结果
     */
    @Override
    public int insertSQualificationsInfo(SQualificationsInfo sQualificationsInfo)
    {
        return sQualificationsInfoMapper.insertSQualificationsInfo(sQualificationsInfo);
    }

    /**
     * 修改企业资质管理
     *
     * @param sQualificationsInfo 企业资质管理
     * @return 结果
     */
    @Override
    public int updateSQualificationsInfo(SQualificationsInfo sQualificationsInfo)
    {
        return sQualificationsInfoMapper.updateSQualificationsInfo(sQualificationsInfo);
    }

    /**
     * 批量删除企业资质管理
     *
     * @param ids 需要删除的企业资质管理ID
     * @return 结果
     */
    @Override
    public int deleteSQualificationsInfoByIds(Long[] ids)
    {
        return sQualificationsInfoMapper.deleteSQualificationsInfoByIds(ids);
    }

    /**
     * 删除企业资质管理信息
     *
     * @param id 企业资质管理ID
     * @return 结果
     */
    @Override
    public int deleteSQualificationsInfoById(Long id)
    {
        return sQualificationsInfoMapper.deleteSQualificationsInfoById(id);
    }

    @Override
    public List<Map<String,String>> selectRecordCompanyList() {
        return sQualificationsInfoMapper.selectRecordCompanyList();
    }
}
