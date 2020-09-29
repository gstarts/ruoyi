package com.ruoyi.stations_management.report.service.impl;

import java.util.List;

import com.ruoyi.stations_management.report.domain.Rmft4406Bordertransportequipment;
import com.ruoyi.stations_management.report.domain.Rmft4406Head;
import com.ruoyi.stations_management.report.domain.Rmft4406Transportequipment;
import com.ruoyi.stations_management.report.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.report.domain.MtBorderTransport;
import com.ruoyi.stations_management.report.service.IMtBorderTransportService;

/**
 * 运输工具信息 Service业务层处理
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
@Service
public class MtBorderTransportServiceImpl implements IMtBorderTransportService {
    @Autowired
    private MtBorderTransportMapper mtBorderTransportMapper;
    @Autowired
    private MtHeadMapper mtHeadMapper;


    /**
     * 查询运输工具信息
     *
     * @param pId 运输工具信息 ID
     * @return 运输工具信息
     */
    @Override
    public MtBorderTransport selectMtBorderTransportById(Long pId) {
        return mtBorderTransportMapper.selectMtBorderTransportById(pId);
    }

    /**
     * 查询运输工具信息 列表
     *
     * @param mtBorderTransport 运输工具信息
     * @return 运输工具信息
     */
    @Override
    public List<MtBorderTransport> selectMtBorderTransportList(MtBorderTransport mtBorderTransport) {
        return mtBorderTransportMapper.selectMtBorderTransportList(mtBorderTransport);
    }

    /**
     * 查询异常车辆信息
     *
     * @param rmft4406Head 运输工具信息
     * @return 异常车辆信息 集合
     */
    @Override
    public List<Rmft4406Head> selectErrList(Rmft4406Head rmft4406Head) {
        List<Rmft4406Head> rmft4406Head1 = mtBorderTransportMapper.selectErrList(rmft4406Head);
        for (Rmft4406Head rh:rmft4406Head1) {
            List<Rmft4406Transportequipment> rmft = mtHeadMapper.selectRmft4406Transportequipment(rh.getMessageId());
            List<Rmft4406Bordertransportequipment> rmfbt = mtHeadMapper.selectRmft4406Bordertransportequipment(rh.getMessageId());
            for (Rmft4406Bordertransportequipment rbt:rmfbt) {
                rh.setBorderTransportMeansId(rbt.getBorderTransportMeansId().toString());
            }
            for (Rmft4406Transportequipment rt:rmft) {
                rh.setConsignmentId(rt.getConsignmentId().toString());
            }
        }

        return rmft4406Head1;
    }

    /**
     * 新增运输工具信息
     *
     * @param mtBorderTransport 运输工具信息
     * @return 结果
     */
    @Override
    public int insertMtBorderTransport(MtBorderTransport mtBorderTransport) {
        return mtBorderTransportMapper.insertMtBorderTransport(mtBorderTransport);
    }

    /**
     * 修改运输工具信息
     *
     * @param mtBorderTransport 运输工具信息
     * @return 结果
     */
    @Override
    public int updateMtBorderTransport(MtBorderTransport mtBorderTransport) {
        return mtBorderTransportMapper.updateMtBorderTransport(mtBorderTransport);
    }

    /**
     * 批量删除运输工具信息
     *
     * @param pIds 需要删除的运输工具信息 ID
     * @return 结果
     */
    @Override
    public int deleteMtBorderTransportByIds(Long[] pIds) {
        return mtBorderTransportMapper.deleteMtBorderTransportByIds(pIds);
    }

    /**
     * 删除运输工具信息 信息
     *
     * @param pId 运输工具信息 ID
     * @return 结果
     */
    @Override
    public int deleteMtBorderTransportById(Long pId) {
        return mtBorderTransportMapper.deleteMtBorderTransportById(pId);
    }
}
