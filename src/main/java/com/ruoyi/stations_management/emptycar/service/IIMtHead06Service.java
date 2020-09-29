package com.ruoyi.stations_management.emptycar.service;

import java.util.List;
import com.ruoyi.stations_management.emptycar.domain.IMtHead06;
import com.ruoyi.stations_management.emptycar.domain.IMtTransport06;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author songqingchuan
 * @date 2020-06-15
 */
public interface IIMtHead06Service 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param pid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public IMtHead06 selectIMtHead06ById(Long pid);

    /**
     * 查询空车列表
     * 
     * @param iMtHead06 i_mt_head_06实体类
     * @return 【请填写功能名称】集合
     */
    public List<IMtHead06> selectIMtHead06List(IMtHead06 iMtHead06);

    /**
     * 新增【请填写功能名称】
     * 
     * @param iMtHead06 【请填写功能名称】
     * @return 结果
     */
    public int insertIMtHead06(IMtHead06 iMtHead06);

    /**
     * 修改【请填写功能名称】
     * 
     * @param iMtHead06 【请填写功能名称】
     * @return 结果
     */
    public int updateIMtHead06(IMtHead06 iMtHead06);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param pids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteIMtHead06ByIds(Long[] pids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param pid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteIMtHead06ById(Long pid);


    /**
     * 查询挂车信息
     */
    public List<IMtTransport06> selectMtTransportById(Long pid);

    /**
     * 查询挂车信息详细
     * @param key
     * @return
     */
    public IMtTransport06  MtTransportByIdDetail (Long key);


    // 修改挂车信息
    public int updateMtTransport (IMtTransport06 mtTransport06);
}
