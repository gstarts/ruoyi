package com.ruoyi.stations_management.monitor.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;

import com.ruoyi.stations_management.monitor.domain.ChnlInfo;




import com.ruoyi.stations_management.monitor.domain.SStationInfo;
import com.ruoyi.stations_management.monitor.mapper.ChnlInfoMapper;
import com.ruoyi.stations_management.monitor.mapper.SStationInfoMapper;
import com.ruoyi.stations_management.montroller.mapper.IcInfoMapper;
import com.ruoyi.stations_management.montroller.mapper.VeRfidMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.monitor.mapper.GatherDataLogMapper;
import com.ruoyi.stations_management.monitor.domain.GatherDataLog;
import com.ruoyi.stations_management.monitor.service.IGatherDataLogService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 数据监控Service业务层处理
 *
 * @author qishuai
 * @date 2020-03-30
 */
@Service
public class GatherDataLogServiceImpl implements IGatherDataLogService {
    @Autowired
    private GatherDataLogMapper gatherdataLogMapper;
    @Autowired
    private IcInfoMapper icInfoMapper;
    @Autowired
    private VeRfidMapper veRfidMapper;
    @Autowired
    private SStationInfoMapper sStationInfoMapper;
    @Autowired
    private ChnlInfoMapper chnlInfoMapper;

    /**
     * 查询数据监控
     *
     * @param sessionId 数据监控ID
     * @return 数据监控
     */
    @Override
    public GatherDataLog selectGatherDataLogById(String sessionId) {
        return gatherdataLogMapper.selectGatherDataLogById(sessionId);
    }

    /**
     * 查询数据监控列表
     *
     * @param gatherdataLog 数据监控
     * @return 数据监控
     */
    @Override
    public List<GatherDataLog> selectGatherDataLogList(GatherDataLog gatherdataLog) {
        return gatherdataLogMapper.selectGatherDataLogList(gatherdataLog);
    }

    @Override
    public List<GatherDataLog> selectErrGatherDataLogList(GatherDataLog gatherdataLog) {
        return gatherdataLogMapper.selectErrGatherDataLogList(gatherdataLog);
    }

    @Override
    public GatherDataLog selectErrDetails(String sessionId) {
        return gatherdataLogMapper.selectErrDetails(sessionId);
    }


    @Override
    public List<GatherDataLog> selectDuringGatherDataLogList(GatherDataLog gatherdataLog) {
        return gatherdataLogMapper.selectDuringGatherDataLogList(gatherdataLog);
    }

    /**
     * 新增数据监控
     *
     * @param gatherdataLog 数据监控
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertGatherdataLog(GatherDataLog gatherdataLog) {
        int row = 0;
        try {
            Date date = new Date();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String Times = sf.format(date);
            String time = Times.replaceAll("[[\\s-:punct:]]","");

            String session = gatherdataLog.getChnlNo() + time;
            // 取8位后的20位字符
            String str = session.substring(8);
            // 给operate_time当前时间，精确至毫秒
            sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            String operateTime = sf.format(date);

            // 把Supvloctcode插入到Areaid字段
            SStationInfo station = new SStationInfo();
            List<SStationInfo> list = sStationInfoMapper.selectSStationInfoList(station);

            ChnlInfo type = chnlInfoMapper.getCChnlType(gatherdataLog.getChnlNo());
            gatherdataLog.setAreaId(type.getcChnlType());
            // 报文
            String code = list.get(0).getCustomsmaster();

            //session_id为通道号+时间戳取后20位
            gatherdataLog.setSessionId(str);
            gatherdataLog.setGatheralldataFlg("10");
            gatherdataLog.setOperateTime(operateTime);
            //给关联表插入session_id
            gatherdataLog.getInfo().setSessionId(str);
            gatherdataLog.getRfid().setSessionId(str);
            if (StringUtils.isNull(gatherdataLog.getRpbType())) {
                gatherdataLog.setRpbType("1");
            }
           // String xml = create81Xml(gatherdataLog, code);
            //报文字段
           // gatherdataLog.setX81Command(xml);
            gatherdataLog.setGetherMode("B");

            //调用不同Mapper将获取到的信息分别set进三张表
            row = icInfoMapper.insertIcInfo(gatherdataLog.getInfo());
            row = veRfidMapper.insertVeRfid(gatherdataLog.getRfid());
            row = gatherdataLogMapper.insertGatherDataLog(gatherdataLog);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return row;
    }

    @Override
    public int artificial(GatherDataLog gatherdataLog) {
        // 生成sessionId
        gatherdataLog.setSessionId(gatherdataLog.getChnlNo()+ DateUtils.dateTimeNow("yyyyMMddHHmmssSSS"));
        gatherdataLog.setOperateTime(DateUtils.dateTimeNow("yyyy-MM-dd HH:mm:ss SSS"));
        gatherdataLog.setGatheralldataFlg("20");
        gatherdataLog.setCheckResult("Y");
        gatherdataLog.setOpHint("人工抬杆,放行");
        return  gatherdataLogMapper.insertGatherDataLog(gatherdataLog);
    }

//    public String create81Xml(GatherDataLog gatherdataLog, String code) {
//        Photo photo = new Photo();
//
//
//        // 创建一个Document实例
//        Document doc = DocumentHelper.createDocument();
//
//        // 添加根节点
//        Element root = doc.addElement("GATHER_INFO");
//        Element root01 = root.addElement("I_E_FLAG").addText(StringUtils.replaceNullString(gatherdataLog.getiEFlag()));
//
//        Element root02 = root.addElement("AREA_ID").addText(StringUtils.replaceNullString(gatherdataLog.getAreaId()));
//
//        Element root03 = root.addElement("CHNL_NO").addText(StringUtils.replaceNullString(gatherdataLog.getChnlNo()));
//
//
//        Element root05 = root.addElement("CUS_CODE").addText(StringUtils.replaceNullString(code));
//
//        Element root06 = root.addElement("SESSION_ID").addText(StringUtils.replaceNullString(gatherdataLog.getSessionId()));
//
//        Element root13 = root.addElement("RPB_TYPE").addText(StringUtils.replaceNullString(gatherdataLog.getRpbType()));
//
//
//        // 在根节点下添加第一个子节点
//        Element oneChildElement = root.addElement("IC_INFO");
//        oneChildElement.addElement("IC_ID")
//                .addText(StringUtils.replaceNullString(gatherdataLog.getInfo().getIcId()));
//        oneChildElement.addElement("IC_NO")
//                .addText(StringUtils.replaceNullString(gatherdataLog.getInfo().getIcNo()));
//        oneChildElement.addElement("IC_Type")
//                .addText(StringUtils.replaceNullString(gatherdataLog.getInfo().getIcType()));
//        oneChildElement.addElement("IC_EXTENDED_CONTENT")
//                .addText(StringUtils.replaceNullString(gatherdataLog.getInfo().getIcExtendedContent()));
//
//
//        Element root07 = root.addElement("DR_CUSTOMS_NO").addText(StringUtils.replaceNullString(gatherdataLog.getDrCustomsNo()));
//        Element root08 = root.addElement("VE_CUSTOMS_NO").addText(StringUtils.replaceNullString(gatherdataLog.getVeCustomsNo()));
//        Element root09 = root.addElement("VE_LICENSE_NO").addText(StringUtils.replaceNullString(gatherdataLog.getVeLicenseNo()));
//        Element root10 = root.addElement("CONTA_ID").addText(StringUtils.replaceNullString(gatherdataLog.getContaId()));
//        Element root11 = root.addElement("ESEAL_ID").addText(StringUtils.replaceNullString(gatherdataLog.getEsealId()));
//        Element root12 = root.addElement("GROSS_WT").addText(StringUtils.replaceNullString(gatherdataLog.getGrossWt()));
//
//
//        // 在根节点下添加第一个子节点
//        Element twoChildElement = root.addElement("VE_RFID");
//        twoChildElement.addElement("RFID_ID")
//                .addText(StringUtils.replaceNullString(gatherdataLog.getRfid().getRfidId()));
//        twoChildElement.addElement("VE_LICENSE_NO")
//                .addText(StringUtils.replaceNullString(gatherdataLog.getRfid().getVeLicenseNo()));
//        twoChildElement.addElement("VE_CUSTOMS_NO")
//                .addText(StringUtils.replaceNullString(gatherdataLog.getRfid().getVeCustomsNo()));
//        twoChildElement.addElement("VE_WT")
//                .addText(StringUtils.replaceNullString(gatherdataLog.getRfid().getVeWt()));
//        twoChildElement.addElement("VE_COMPANY")
//                .addText(StringUtils.replaceNullString(gatherdataLog.getRfid().getVeCompany()));
//        twoChildElement.addElement("VE_PERFORMANCE")
//                .addText(StringUtils.replaceNullString(gatherdataLog.getRfid().getVePerformance()));
//
//        // FORM_INFO
//        Element threeChildElement = root.addElement("FORM_INFO");
//        threeChildElement.addElement("FORM_TYPE")
//                .addText("");
//        threeChildElement.addElement("FORM_ID")
//                .addText("");
//
//        // DR_RFID
//        Element fourChildElement = root.addElement("DR_RFID");
//        fourChildElement.addElement("RFID_ID")
//                .addText("");
//        fourChildElement.addElement("DR_NAME")
//                .addText("");
//        fourChildElement.addElement("DR_CUSTOMS_NO")
//                .addText("");
//        fourChildElement.addElement("DR_COMPANY")
//                .addText("");
//        fourChildElement.addElement("DR_PERFORMANCE")
//                .addText("");
//
//        // photo
//        Element fiveChildElement = root.addElement("PHOTO");
//        fiveChildElement.addElement("PHOTO_GUID")
//                .addText(StringUtils.replaceNullString(photo.getPhotoGuid()));
//        fiveChildElement.addElement("PHOTO_PERSPECTIVE")
//                .addText(StringUtils.replaceNullString(photo.getPhotoPerspective()));
//
//        Element root14 = root.addElement("OPERATOR_ID").addText(StringUtils.replaceNullString(gatherdataLog.getOperatorId()));
//        Element root15 = root.addElement("OPERATE_TIME").addText(StringUtils.replaceNullString(gatherdataLog.getOperateTime()));
//
//        // EXTEND
//        Element sixChildElement = root.addElement("EXTEND");
//        sixChildElement.addElement("NAME")
//                .addText("");
//        sixChildElement.addElement("VALUE")
//                .addText("");
//
//        // CONTA_RECOGNITION
//        Element sevenChildElement = root.addElement("CONTA_RECOGNITION");
//        sevenChildElement.addElement("CONTA_ID")
//                .addText("");
//        sevenChildElement.addElement("CONTA_TYPE")
//                .addText("");
//        sevenChildElement.addElement("CONTA_LOCK")
//                .addText("");
//        sevenChildElement.addElement("CONFIDENCE_RATIO")
//                .addText("");
//
//        Element eightChildElement = root.addElement("VE_LICENSE_RECOGNITION");
//        eightChildElement.addElement("DOMESTIC_LICENSE_NO")
//                .addText("");
//        eightChildElement.addElement("DOMESTIC_LICENSE_COLOR")
//                .addText("");
//        eightChildElement.addElement("FOREIGN_LICENSE_NO")
//                .addText("");
//        eightChildElement.addElement("FOREIGN_LICENSE_COLOR")
//                .addText("");
//        eightChildElement.addElement("CONFIDENCE_RATIO")
//                .addText("");
//
//
//        // xml格式化样式
//
//        // 自定义xml样式
//        OutputFormat format = new OutputFormat();
//        format.setIndentSize(2);  // 行缩进
//        format.setNewlines(true); // 一个结点为一行
//        format.setTrimText(true); // 去重空格
//        format.setPadText(true);
//        format.setNewLineAfterDeclaration(false); // 放置xml文件中第二行为空白行
//
//        // 输出xml文件
//        String StringXml = doc.asXML();
//        System.out.println("dom4j CreateDom4j success!");
//        return StringXml;
//    }


    /**
     * 修改数据监控
     *
     * @param gatherdataLog 数据监控
     * @return 结果
     */
    @Override
    public int updateGatherdataLog(GatherDataLog gatherdataLog) {
        return gatherdataLogMapper.updateGatherDataLog(gatherdataLog);

    }

    /**
     * 补采插回
     *
     * @param gatherDataLog 数据监控
     * @return 结果
     */
    @Override
    @Transactional
    public int supplementCollection(GatherDataLog gatherDataLog) {
        // 保存当前记录的sessionId 为后续更新当前记录使用
        String sessionId = gatherDataLog.getSessionId();
        // 通道号后四位
        String chnlNo = gatherDataLog.getChnlNo().substring(gatherDataLog.getChnlNo().length() - 4);
        //获取当前时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String dateTime = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);
        // 形成新的的 sessionId 插入使用
        String newSessionIde = chnlNo + dateTime;
        gatherDataLog.setSessionId(newSessionIde);
        gatherDataLog.setGatheralldataFlg("10");
        gatherDataLog.getRfid().setRfidId(gatherDataLog.getSealId());
        gatherDataLog.getRfid().setSessionId(newSessionIde);
        // 清空原纪录的处理结果
        gatherDataLog.setCheckResult("");
        // 新增要补采的记录
        int rows = gatherdataLogMapper.insertGatherDataLog(gatherDataLog);
         rows = veRfidMapper.insertVeRfid(gatherDataLog.getRfid());
        // 设置原记录为失效
        gatherdataLogMapper.updateErrGatherDataLog(sessionId);

        return rows;
    }

    /**
     * 修改系统处理状态
     *
     * @param gatherdataLog 数据监控
     * @return 结果
     */
    @Override
    public int updateGatherDataLogLift(GatherDataLog gatherdataLog) {

        return gatherdataLogMapper.updateGatherDataLog(gatherdataLog);
    }

    /**
     * 批量删除数据监控
     *
     * @param sessionIds 需要删除的数据监控ID
     * @return 结果
     */
    @Override
    public int deleteGatherDataLogByIds(String[] sessionIds) {
        return gatherdataLogMapper.deleteGatherDataLogByIds(sessionIds);
    }

    /**
     * 删除数据监控信息
     *
     * @param sessionId 数据监控ID
     * @return 结果
     */
    @Override
    public int deleteGatherDataLogById(String sessionId) {
        return gatherdataLogMapper.deleteGatherDataLogById(sessionId);
    }
}
