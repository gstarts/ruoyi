package com.ruoyi.stations_management.waybill.mapper;

import com.ruoyi.stations_management.waybill.domain.CustomsClearance;

import java.util.List;

/**
 * 通关单Mapper接口
 *
 * @author qishuai
 * @date 2020-02-25
 */
 public  interface CustomsClearanceMapper
{
    /**
     * 查询通关单
     *
     * @param id 通关单ID
     * @return 通关单
     */
     CustomsClearance selectCustomsClearanceById(Long id);

    /**
     * 查询通关单列表
     *
     * @param customsClearance 通关单
     * @return 通关单集合
     */
     List<CustomsClearance> selectCustomsClearanceList(CustomsClearance customsClearance);

    /**
     * 新增通关单
     *
     * @param customsClearance 通关单
     * @return 结果
     */
     int insertCustomsClearance(CustomsClearance customsClearance);


    /**
     * 修改通关单
     *
     * @param customsClearance 通关单
     * @return 结果
     */
     int updateCustomsClearance(CustomsClearance customsClearance);

    /**
     * 删除通关单
     *
     * @param id 通关单ID
     * @return 结果
     */
     int deleteCustomsClearanceById(Long id);

    /**
     * 批量删除通关单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
     int deleteCustomsClearanceByIds(Long[] ids);



    /**
     * 判断表体增加
     */
    CustomsClearance selectwaybillBodyadd(CustomsClearance customsClearance);


}
