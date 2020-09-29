package com.ruoyi.stations_management.enterprise.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.enterprise.mapper.SEnterpriseInfoMapper;
import com.ruoyi.stations_management.enterprise.domain.SEnterpriseInfo;
import com.ruoyi.stations_management.enterprise.service.ISEnterpriseInfoService;

/**
 * 企业信息备案Service业务层处理
 * 
 * @author qishuai
 * @date 2020-01-02
 */
@Service
public class SEnterpriseInfoServiceImpl implements ISEnterpriseInfoService 
{
    @Autowired
    private SEnterpriseInfoMapper sEnterpriseInfoMapper;

    /**
     * 查询企业信息备案
     * 
     * @param id 企业信息备案ID
     * @return 企业信息备案
     */
    @Override
    public SEnterpriseInfo selectSEnterpriseInfoById(Long id)
    {
        return sEnterpriseInfoMapper.selectSEnterpriseInfoById(id);
    }

    /**
     * 查询企业信息备案列表
     * 
     * @param sEnterpriseInfo 企业信息备案
     * @return 企业信息备案
     */
    @Override
    public List<SEnterpriseInfo> selectSEnterpriseInfoList(SEnterpriseInfo sEnterpriseInfo)
    {
        return sEnterpriseInfoMapper.selectSEnterpriseInfoList(sEnterpriseInfo);
    }

    /**
     * 新增企业信息备案
     * 
     * @param sEnterpriseInfo 企业信息备案
     * @return 结果
     */
    @Override
    public int insertSEnterpriseInfo(SEnterpriseInfo sEnterpriseInfo)
    {
        return sEnterpriseInfoMapper.insertSEnterpriseInfo(sEnterpriseInfo);
    }

    /**
     * 修改企业信息备案
     * 
     * @param sEnterpriseInfo 企业信息备案
     * @return 结果
     */
    @Override
    public int updateSEnterpriseInfo(SEnterpriseInfo sEnterpriseInfo)
    {
        return sEnterpriseInfoMapper.updateSEnterpriseInfo(sEnterpriseInfo);
    }

    /**
     * 批量删除企业信息备案
     * 
     * @param ids 需要删除的企业信息备案ID
     * @return 结果
     */
    @Override
    public int deleteSEnterpriseInfoByIds(Long[] ids)
    {
        return sEnterpriseInfoMapper.deleteSEnterpriseInfoByIds(ids);
    }

    /**
     * 删除企业信息备案信息
     * 
     * @param id 企业信息备案ID
     * @return 结果
     */
    @Override
    public int deleteSEnterpriseInfoById(Long id)
    {
        return sEnterpriseInfoMapper.deleteSEnterpriseInfoById(id);
    }
}
