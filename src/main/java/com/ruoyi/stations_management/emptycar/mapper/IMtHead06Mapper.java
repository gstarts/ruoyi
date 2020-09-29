package com.ruoyi.stations_management.emptycar.mapper;

import java.util.List;

import com.ruoyi.stations_management.emptycar.domain.*;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author songqingchuan
 * @date 2020-06-15
 */
public interface IMtHead06Mapper {
    /**
     * 查询空车表头信息
     *
     * @param pid
     * @return
     */
    public IMtHead06 selectIMtHead06ById(Long pid);

    /**
     * 查询空车列表
     *
     * @param iMtHead06 i_mt_head_06实体类
     * @return 结果集合
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
     * 删除【请填写功能名称】
     *
     * @param pid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteIMtHead06ById(Long pid);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param pids 需要删除的数据ID
     * @return 结果
     */
    public int deleteIMtHead06ByIds(Long[] pids);


    /**
     * 查询挂车信息
     */

    public List<IMtTransport06> selectMtTransportById(Long pid);

    // 查询挂车详细信息
    public IMtTransport06 MtTransportByIdDetail(Long key);

    // 修改挂车信息
    public int updateMtTransport(IMtTransport06 mtTransport06);


    // 修改挂车表头信息

    public int updateIMtBorderTransport06(IMtBorderTransport06 mtBorderTransport06);

    public int updateIMtCarrier06(IMtCarrier06 mtCarrier06);

    public int updateIMtGovernmentprocedure06(IMtGovernmentprocedure06 mtGovernmentprocedure06);

    public int updateIMtLoading06(IMtLoading06 mtLoading06);

    public int updateIMtMaster06(IMtMaster06 mtMaster06);

    public int updateIMtRepresen06(IMtRepresen06 iMtRepresen06);


}
