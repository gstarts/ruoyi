package com.ruoyi.stations_management.emptycar.service.impl;

import java.util.List;

import com.ruoyi.stations_management.report.domain.MtBorderTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.emptycar.mapper.IMtBorderTransport06Mapper;
import com.ruoyi.stations_management.emptycar.domain.IMtBorderTransport06;
import com.ruoyi.stations_management.emptycar.service.IIMtBorderTransport06Service;

/**
 * 运输工具信息 Service业务层处理
 *
 * @author songqingchuan
 * @date 2020-06-15
 */
@Service
public class IMtBorderTransport06ServiceImpl implements IIMtBorderTransport06Service {
    @Autowired
    private IMtBorderTransport06Mapper iMtBorderTransport06Mapper;

    /**
     * 查询运输工具信息
     *
     * @param key 运输工具信息 ID
     * @return 运输工具信息
     */
    @Override
    public IMtBorderTransport06 selectIMtBorderTransport06ById(Long key) {
        return iMtBorderTransport06Mapper.selectIMtBorderTransport06ById(key);
    }

    /**
     * 查询运输工具信息 列表
     *
     * @param iMtBorderTransport06 运输工具信息
     * @return 运输工具信息
     */
    @Override
    public List<IMtBorderTransport06> selectIMtBorderTransport06List(IMtBorderTransport06 iMtBorderTransport06) {
        return iMtBorderTransport06Mapper.selectIMtBorderTransport06List(iMtBorderTransport06);
    }

    /**
     * 查询异常车辆信息
     *
     * @param iMtBorderTransport06 运输工具信息
     * @return 异常车辆信息 集合
     */
    @Override
    public List<IMtBorderTransport06> selectErrList(IMtBorderTransport06 iMtBorderTransport06) {
        return iMtBorderTransport06Mapper.selectErrList(iMtBorderTransport06);
    }

    /**
     * 新增运输工具信息
     *
     * @param iMtBorderTransport06 运输工具信息
     * @return 结果
     */
    @Override
    public int insertIMtBorderTransport06(IMtBorderTransport06 iMtBorderTransport06) {
        return iMtBorderTransport06Mapper.insertIMtBorderTransport06(iMtBorderTransport06);
    }

    /**
     * 修改运输工具信息
     *
     * @param iMtBorderTransport06 运输工具信息
     * @return 结果
     */
    @Override
    public int updateIMtBorderTransport06(IMtBorderTransport06 iMtBorderTransport06) {
        return iMtBorderTransport06Mapper.updateIMtBorderTransport06(iMtBorderTransport06);
    }

    /**
     * 批量删除运输工具信息
     *
     * @param keys 需要删除的运输工具信息 ID
     * @return 结果
     */
    @Override
    public int deleteIMtBorderTransport06ByIds(Long[] keys) {
        return iMtBorderTransport06Mapper.deleteIMtBorderTransport06ByIds(keys);
    }

    /**
     * 删除运输工具信息 信息
     *
     * @param key 运输工具信息 ID
     * @return 结果
     */
    @Override
    public int deleteIMtBorderTransport06ById(Long key) {
        return iMtBorderTransport06Mapper.deleteIMtBorderTransport06ById(key);
    }
}
