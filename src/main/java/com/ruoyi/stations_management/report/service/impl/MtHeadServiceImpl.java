package com.ruoyi.stations_management.report.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.stations_management.common.domain.StationInfo;
import com.ruoyi.stations_management.common.mapper.StationInfoMapper;
import com.ruoyi.stations_management.report.domain.*;
import com.ruoyi.stations_management.report.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.report.service.IMtHeadService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
@Service
public class MtHeadServiceImpl implements IMtHeadService {
    @Autowired
    private MtHeadMapper mtHeadMapper;
    @Autowired
    private Rmft4406HeadMapper rmft4406HeadMapper;
    @Autowired
    private Rmft4406ConsignmentMapper rmft4406ConsignmentMapper;
    @Autowired
    private Rmft4406TransportequipmentMapper rmft4406TransportequipmentMapper;
    @Autowired
    private Rmft4406BordertransportmeansMapper rmft4406BordertransportmeansMapper;
    @Autowired
    private Rmft4406BordertransportequipmentMapper rmft4406BordertransportequipmentMapper;
    @Autowired
    private StationInfoMapper stationInfoMapper;



    /**
     * 查询【确报表头详细信息】
     *
     * @param messageid ID
     * @return
     */
    @Override
    public Rmft4406Head selectMtHeadById(String messageId) {
        // 将StationInfo数据插入到相应字段
        StationInfo stationInfo = stationInfoMapper.selectStation();
        Rmft4406Head rmft4406Head = mtHeadMapper.selectMtHeadById(messageId);
        rmft4406Head.setCustomsMaster(stationInfo.getCustomsmaster());
        rmft4406Head.setStationPersonName(stationInfo.getStationPersonName());
        rmft4406Head.setContractorCodeScc(stationInfo.getContractorcodescc());
        return rmft4406Head;
    }

    @Override
    public Rmft4406Head select() {
        // 新增页面的getList方法，回填的三个字段
        // 将StationInfo数据插入到相应字段
        StationInfo stationInfo = stationInfoMapper.selectStation();
        Rmft4406Head rmft4406Head = new Rmft4406Head();
        rmft4406Head.setCustomsMaster(stationInfo.getCustomsmaster());
        rmft4406Head.setStationPersonName(stationInfo.getStationPersonName());
        rmft4406Head.setContractorCodeScc(stationInfo.getContractorcodescc());
        return rmft4406Head;
    }


    @Override
    public List<Rmft4406Head> selectXml() {
        return mtHeadMapper.selectXml();
    }

    @Override
    public List<Rmft4406Transportequipment> selectRmft4406Transportequipment(String messageid) {
        return mtHeadMapper.selectRmft4406Transportequipment(messageid);
    }

    @Override
    public List<Rmft4406Bordertransportequipment> selectRmft4406Bordertransportequipment(String messageid) {
        return mtHeadMapper.selectRmft4406Bordertransportequipment(messageid);
    }

    /**
     * 获取托架或拖挂车信息 详细信息
     *
     * @param borderTransportMeansId
     * @return
     */
    @Override
    public List<Rmft4406Bordertransportequipment> selectMtTransportById(Long borderTransportMeansId) {
        return mtHeadMapper.selectMtTransportById(borderTransportMeansId);
    }

    @Override
    public Rmft4406Bordertransportequipment MtTransportByIdDetail(Long id) {
        return mtHeadMapper.MtTransportByIdDetail(id);
    }

    /**
     * 获取集装箱信息 详细信息
     *
     * @param consignmentId
     * @return
     */
    @Override
    public List<Rmft4406Transportequipment> selectCoaltById(Long consignmentId) {
        return mtHeadMapper.selectCoaltById(consignmentId);
    }

    @Override
    public Rmft4406Transportequipment getCoalDetail(Long id) {
        return mtHeadMapper.getCoalDetail(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<Rmft4406Head> selectMtHeadList(Rmft4406Head rmft4406Head) {
        return mtHeadMapper.selectMtHeadList(rmft4406Head);
    }

    /**
     * 新增页面新增表头信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map insertMtHead(Rmft4406Head rmft4406Head) {
        Rmft4406Consignment rmft4406Consignment = new Rmft4406Consignment();
        List<Rmft4406Transportequipment> rmft4406Transportequipment = new ArrayList<Rmft4406Transportequipment>();
        Rmft4406Bordertransportmeans rmft4406Bordertransportmeans = new Rmft4406Bordertransportmeans();
        List<Rmft4406Bordertransportequipment> rmft4406Bordertransportequipment = new ArrayList<Rmft4406Bordertransportequipment>();
        // 写入head表的固定信息等
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String Times = sf.format(date);
        String time = Times.replaceAll("[[\\s-:punct:]]", "");
        StationInfo info = stationInfoMapper.selectStation();
        // 将StationInfo数据插入到相应字段
        StationInfo stationInfo = stationInfoMapper.selectStation();
        rmft4406Head.setRepresentativePerson(stationInfo.getStationPersonName());
        rmft4406Head.setContractorCodeScc(stationInfo.getContractorcodescc());
        // MessageId
        String mesId = "CN_MT4406_1p0_" + info.getCustomsmaster() + info.getContractorcode() + "_" + info.getSenderid() + "_" + time;
        rmft4406Head.setMessageId(mesId);
        rmft4406Head.setFunctionCode("2");
        rmft4406Head.setMessageType("MT4406");
        // SenderId
        String sender = info.getCustomsmaster() + info.getContractorcode() + "_" + info.getSenderid();
        rmft4406Head.setSenderId(sender);
        rmft4406Head.setReceiverId(info.getReceiverid());
        rmft4406Head.setSendTime(time);
        rmft4406Head.setVersion(info.getVersion());

        // 写入governmentprocedure
        rmft4406Consignment.setGovernmentProcedure(rmft4406Head.getConsignment().getGovernmentProcedure());
        // 写入i_rmft4406_bordertransportmeans表六个字段数据
        rmft4406Bordertransportmeans.setBorderId(rmft4406Head.getBorderTransportMeans().getBorderId());
        rmft4406Bordertransportmeans.setMasterId(rmft4406Head.getBorderTransportMeans().getMasterId());
        rmft4406Bordertransportmeans.setMasterName(rmft4406Head.getBorderTransportMeans().getMasterName());
        rmft4406Bordertransportmeans.setName(rmft4406Head.getBorderTransportMeans().getName());
        rmft4406Bordertransportmeans.setTypeCode(rmft4406Head.getBorderTransportMeans().getTypeCode());
        rmft4406Bordertransportmeans.setArrivalDateTime(rmft4406Head.getBorderTransportMeans().getArrivalDateTime());

        // 写入各个表的关联条件
        rmft4406Consignment.setMessageId(mesId);
        rmft4406Consignment.setId(date.getTime());
        rmft4406Bordertransportmeans.setConsignmentId(date.getTime());
        // 因为主键不能重复，所以重新 new date
        Date datetime = new Date();

        rmft4406Bordertransportmeans.setId(datetime.getTime());

        // list是空集，需要添加一个list
        rmft4406Transportequipment.add(new Rmft4406Transportequipment());
        for (Rmft4406Transportequipment tran : rmft4406Transportequipment) {
            tran.setConsignmentId(date.getTime());
        }
        rmft4406Bordertransportequipment.add(new Rmft4406Bordertransportequipment());
        for (Rmft4406Bordertransportequipment border : rmft4406Bordertransportequipment) {
            border.setBorderTransportMeansId(datetime.getTime());
        }

        // 各个表分别写入信息
        mtHeadMapper.insertMtHead(rmft4406Head);
        rmft4406ConsignmentMapper.insertRmft4406Consignment(rmft4406Consignment);
        for (Rmft4406Transportequipment transport : rmft4406Transportequipment) {
            rmft4406TransportequipmentMapper.insertRmft4406Transportequipment(transport);
        }
        rmft4406BordertransportmeansMapper.insertRmft4406Bordertransportmeans(rmft4406Bordertransportmeans);
        for (Rmft4406Bordertransportequipment border : rmft4406Bordertransportequipment) {
            rmft4406BordertransportequipmentMapper.insertRmft4406Bordertransportequipment(border);
        }
        // 将表体所需要的id信息put进map传回给前台，用于获取
        Map map = new HashMap();
        map.put("Mid", mesId);
        map.put("Bid", datetime.getTime());
        map.put("Cid", date.getTime());
        return map;
    }


    /**
     * 修改页面修改【表头信息】
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateMtHead(Rmft4406Head rmft4406Head) {
        int row = 0;
        Rmft4406Consignment rmft4406Consignment = rmft4406Head.getConsignment();
        List<Rmft4406Transportequipment> rmft4406Transportequipment = rmft4406Head.getTransportEquipment();
        Rmft4406Bordertransportmeans rmft4406Bordertransportmeans = rmft4406Head.getBorderTransportMeans();
        List<Rmft4406Bordertransportequipment> rmft4406Bordertransportequipment = rmft4406Head.getBorderTransportEquipment();
        row = mtHeadMapper.updateRmft4406Head(rmft4406Head);
        row = rmft4406ConsignmentMapper.updateRmft4406Consignment(rmft4406Consignment);
        for (Rmft4406Transportequipment transport : rmft4406Transportequipment) {
            row = rmft4406TransportequipmentMapper.updateRmft4406Transportequipment(transport);
        }
        row = rmft4406BordertransportmeansMapper.updateRmft4406Bordertransportmeans(rmft4406Bordertransportmeans);
        for (Rmft4406Bordertransportequipment border : rmft4406Bordertransportequipment) {
            row = rmft4406BordertransportequipmentMapper.updateRmft4406Bordertransportequipment(border);
        }
        return row;
    }

    /**
     * 申报前状态修改
     */
    @Override
    public int updateRmft4406Declare(Rmft4406Head rmft4406Head) {
        return mtHeadMapper.updateRmft4406Declare(rmft4406Head);
    }

    /**
     * 修改申报后，并回复成功的状态
     */
    @Override
    public int updateRmft4406(Rmft4406Head rmft4406Head) {
        return mtHeadMapper.updateRmft4406(rmft4406Head);
    }

    /**
     * 修改上传中的状态
     */
    @Override
    public int updateRmft4406Statementcode(Rmft4406Head rmft4406Head) {
        return mtHeadMapper.updateRmft4406Statementcode(rmft4406Head);
    }


    /**
     * 修改【异常修改页面表头信息】
     *
     * @param rmft4406Head 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRmft4406Head(Rmft4406Head rmft4406Head) {
        return mtHeadMapper.updateRmft4406Head(rmft4406Head);
    }

    //    // 修改挂车信息
//    @Override
//    public int updateMtTransport(Rmft4406Head rmft4406Head) {
//        return mtHeadMapper.updateMtTransport(rmft4406Head);
//    }
    // 修改集装箱信息
    @Override
    public int updateMtCoal(MtCoal mtCoal) {
        return mtHeadMapper.updateMtCoal(mtCoal);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param pids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteMtHeadByIds(Long[] pids) {
        return mtHeadMapper.deleteMtHeadByIds(pids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param pid 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteMtHeadById(Long pid) {
        return mtHeadMapper.deleteMtHeadById(pid);
    }
}
