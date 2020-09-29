package com.ruoyi.stations_management.enterprise.mapper;

import com.ruoyi.stations_management.enterprise.domain.SQualificationsInfo;
import java.util.List;
import java.util.Map;

/**
 * 企业资质管理Mapper接口
 *
 * @author qishuai
 * @date 2020-01-02
 */
public interface SQualificationsInfoMapper
{
    /**
     * 查询企业资质管理
     *
     * @param id 企业资质管理ID
     * @return 企业资质管理
     */
    public SQualificationsInfo selectSQualificationsInfoById(Long id);

    /**
     * 查询企业资质管理列表
     *
     * @param sQualificationsInfo 企业资质管理
     * @return 企业资质管理集合
     */
    public List<SQualificationsInfo> selectSQualificationsInfoList(SQualificationsInfo sQualificationsInfo);

    /**
     * 新增企业资质管理
     *
     * @param sQualificationsInfo 企业资质管理
     * @return 结果
     */
    public int insertSQualificationsInfo(SQualificationsInfo sQualificationsInfo);

    /**
     * 修改企业资质管理
     *
     * @param sQualificationsInfo 企业资质管理
     * @return 结果
     */
    public int updateSQualificationsInfo(SQualificationsInfo sQualificationsInfo);

    /**
     * 删除企业资质管理
     *
     * @param id 企业资质管理ID
     * @return 结果
     */
    public int deleteSQualificationsInfoById(Long id);

    /**
     * 批量删除企业资质管理
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSQualificationsInfoByIds(Long[] ids);

   public List<Map<String, String>> selectRecordCompanyList();
}
