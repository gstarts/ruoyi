package com.ruoyi.stations_management.waybill.service;

import com.ruoyi.stations_management.waybill.domain.CustomsClearance;

import java.util.List;

/**
 * 通关单Service接口
 *
 * @author qishuai
 * @date 2020-02-25
 */
 public  interface ICustomsClearanceService
{
    /**
     * 查询通关单
     *
     * @param id 通关单ID
     * @return 通关单
     */
     CustomsClearance selectSCustomsClearanceById(Long id);

    /**
     * 查询通关单列表
     *
     * @param customsClearance 通关单
     * @return 通关单集合
     */
     List<CustomsClearance> selectSCustomsClearanceList(CustomsClearance customsClearance);

    /**
     * 新增通关单
     *
     * @param customsClearance 通关单
     * @return 结果
     */
     int insertSCustomsClearance(CustomsClearance customsClearance) throws Exception;


    /**
     * 修改通关单
     *
     * @param customsClearance 通关单
     * @return 结果
     */
     int updateSCustomsClearance(CustomsClearance customsClearance);

    /**
     * 批量删除通关单
     *
     * @param ids 需要删除的通关单ID
     * @return 结果
     */
     int deleteSCustomsClearanceByIds(Long[] ids);

    /**
     * 删除通关单信息
     *
     * @param id 通关单ID
     * @return 结果
     */
     int deleteSCustomsClearanceById(Long id);

    /**
     *  导入通关单数据
     * @param list 通关单数据列表
     * @param corporationId 所属公司id
     * @param opeName 操作人
     * @return 结果
     */
     String importCustoms(List<CustomsClearance> list, int corporationId, String opeName);

}
