package com.ruoyi.stations_management.emptycar.service.impl;

import java.util.List;

import com.ruoyi.stations_management.emptycar.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.emptycar.mapper.IMtHead06Mapper;
import com.ruoyi.stations_management.emptycar.service.IIMtHead06Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author songqingchuan
 * @date 2020-06-15
 */
@Service
public class IMtHead06ServiceImpl implements IIMtHead06Service {
    @Autowired
    private IMtHead06Mapper iMtHead06Mapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param pid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public IMtHead06 selectIMtHead06ById(Long pid) {
        return iMtHead06Mapper.selectIMtHead06ById(pid);
    }

    /**
     * 查询空车列表
     *
     * @param iMtHead06 i_mt_head_06实体类
     * @return 结果集合
     */
    @Override
    public List<IMtHead06> selectIMtHead06List(IMtHead06 iMtHead06) {
        return iMtHead06Mapper.selectIMtHead06List(iMtHead06);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param iMtHead06 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertIMtHead06(IMtHead06 iMtHead06) {
        return iMtHead06Mapper.insertIMtHead06(iMtHead06);
    }

    /**
     * 修改【空车表头信息】
     *
     * @param iMtHead06
     * @return 结果
     */
    @Override
    @Transactional
    public int updateIMtHead06(IMtHead06 iMtHead06) {
        IMtBorderTransport06 mtBorderTransport06 = iMtHead06.getiMtBorderTransport06();
        IMtCarrier06 mtCarrier06 = iMtHead06.getiMtCarrier06();
        IMtGovernmentprocedure06 mtGovernmentprocedure06 = iMtHead06.getiMtGovernmentprocedure06();
        IMtLoading06 mtLoading06 = iMtHead06.getiMtLoading06();
        IMtMaster06 mtMaster06 = iMtHead06.getMtMaster06();
        IMtRepresen06 iMtRepresen06 = iMtHead06.getiMtRepresen06();
        int row = 0;
        try {
            row = iMtHead06Mapper.updateIMtBorderTransport06(mtBorderTransport06);
            row = iMtHead06Mapper.updateIMtCarrier06(mtCarrier06);
            row = iMtHead06Mapper.updateIMtGovernmentprocedure06(mtGovernmentprocedure06);
            row = iMtHead06Mapper.updateIMtLoading06(mtLoading06);
            row = iMtHead06Mapper.updateIMtMaster06(mtMaster06);
            row = iMtHead06Mapper.updateIMtRepresen06(iMtRepresen06);
            row = iMtHead06Mapper.updateIMtHead06(iMtHead06);
        } catch (Exception e){
            throw new RuntimeException();
        }

        return row;
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param pids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteIMtHead06ByIds(Long[] pids) {
        return iMtHead06Mapper.deleteIMtHead06ByIds(pids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param pid 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteIMtHead06ById(Long pid) {
        return iMtHead06Mapper.deleteIMtHead06ById(pid);
    }

    @Override
    public List<IMtTransport06> selectMtTransportById(Long pid) {
        return iMtHead06Mapper.selectMtTransportById(pid);
    }

    // 查询挂车信息详细
    @Override
    public IMtTransport06 MtTransportByIdDetail(Long key) {
        return iMtHead06Mapper.MtTransportByIdDetail(key);
    }

    // 修改挂车信息
    @Override
    public int updateMtTransport(IMtTransport06 mtTransport06) {
        return iMtHead06Mapper.updateMtTransport(mtTransport06);
    }
}
