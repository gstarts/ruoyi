package com.ruoyi.stations_management.enterprise.service;

import com.ruoyi.stations_management.enterprise.domain.SEnterpriseInfo;
import java.util.List;

/**
 * 企业信息备案Service接口
 * 
 * @author qishuai
 * @date 2020-01-02
 */
public interface ISEnterpriseInfoService 
{
    /**
     * 查询企业信息备案
     * 
     * @param id 企业信息备案ID
     * @return 企业信息备案
     */
    public SEnterpriseInfo selectSEnterpriseInfoById(Long id);

    /**
     * 查询企业信息备案列表
     * 
     * @param sEnterpriseInfo 企业信息备案
     * @return 企业信息备案集合
     */
    public List<SEnterpriseInfo> selectSEnterpriseInfoList(SEnterpriseInfo sEnterpriseInfo);

    /**
     * 新增企业信息备案
     * 
     * @param sEnterpriseInfo 企业信息备案
     * @return 结果
     */
    public int insertSEnterpriseInfo(SEnterpriseInfo sEnterpriseInfo);

    /**
     * 修改企业信息备案
     * 
     * @param sEnterpriseInfo 企业信息备案
     * @return 结果
     */
    public int updateSEnterpriseInfo(SEnterpriseInfo sEnterpriseInfo);

    /**
     * 批量删除企业信息备案
     * 
     * @param ids 需要删除的企业信息备案ID
     * @return 结果
     */
    public int deleteSEnterpriseInfoByIds(Long[] ids);

    /**
     * 删除企业信息备案信息
     * 
     * @param id 企业信息备案ID
     * @return 结果
     */
    public int deleteSEnterpriseInfoById(Long id);
}
