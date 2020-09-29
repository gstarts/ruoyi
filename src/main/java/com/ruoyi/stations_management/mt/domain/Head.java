package com.ruoyi.stations_management.mt.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.List;

/**
 * 报文头信息对象
 * 
 * @author songqingchuan
 * @date 2020-07-27
 */
public class Head extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 报文编号
     */
    private String messageId;

    /**
     * 报文功能代码
     */
    @Excel(name = "报文功能代码")
    private String functionCode;

    /**
     * 报文类型代码
     */
    @Excel(name = "报文类型代码")
    private String messageType;

    /**
     * 发送方代码
     */
    @Excel(name = "发送方代码")
    private String senderId;

    /**
     * 接收方代码
     */
    @Excel(name = "接收方代码")
    private String receiverId;

    /**
     * 发送时间
     */
    @Excel(name = "发送时间")
    private String sendTime;

    /**
     * 报文版本号
     */
    @Excel(name = "报文版本号")
    private String version;

    /**
     * 进出境口岸海关代码
     */
    @Excel(name = "进出境口岸海关代码")
    private String declarationOfficeId;

    /**
     * 货物运输批次号
     */
    @Excel(name = "货物运输批次号")
    private String id;

    /**
     * 补充信息数据
     */
    @Excel(name = "补充信息数据")
    private String additionalInformation;

    /**
     * 承运人数据
     */
    @Excel(name = "承运人数据")
    private String carrier;

    /**
     * 装货地数据
     */
    @Excel(name = "装货地数据")
    private String loadingLocation;

    /**
     * 进出境承运确报传输人数据
     */
    @Excel(name = "进出境承运确报传输人数据")
    private String representativePerson;

    /**
     * 卸货地数据
     */
    @Excel(name = "卸货地数据")
    private String unloadingLocation;

    /**
     * 海关回执
     */
    @Excel(name = "海关回执")
    private String statementCode;

    /**
     * 海关回执说明
     */
    @Excel(name = "海关回执说明")
    private String statementDescription;
    /**
     * 托架或拖挂车信息
     */
    private List<BorderTransportEquipment> borderTransportEquipments;
    /**
     * 驾驶员信息
     */
    private BorderTransportMeans borderTransportMeans;
    /**
     * 提(运)单数据
     */
    private Consignment consignment;

    /**
     * 申报地海关
     */
    private String customsMaster;
    /**
     * 统一社会信用代码
     */
    private String contractorCodeScc;

    /**
     * 进出境承运确报传输人数据
     */
    private String StationPersonName;

    /**
     * iRmft4404Consignment里的name
     *
     * @return
     */
    private String Name;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeclarationOfficeId() {
        return declarationOfficeId;
    }

    public void setDeclarationOfficeId(String declarationOfficeId) {
        this.declarationOfficeId = declarationOfficeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getLoadingLocation() {
        return loadingLocation;
    }

    public void setLoadingLocation(String loadingLocation) {
        this.loadingLocation = loadingLocation;
    }

    public String getRepresentativePerson() {
        return representativePerson;
    }

    public void setRepresentativePerson(String representativePerson) {
        this.representativePerson = representativePerson;
    }

    public String getUnloadingLocation() {
        return unloadingLocation;
    }

    public void setUnloadingLocation(String unloadingLocation) {
        this.unloadingLocation = unloadingLocation;
    }

    public String getStatementCode() {
        return statementCode;
    }

    public void setStatementCode(String statementCode) {
        this.statementCode = statementCode;
    }

    public String getStatementDescription() {
        return statementDescription;
    }

    public void setStatementDescription(String statementDescription) {
        this.statementDescription = statementDescription;
    }

    public List<BorderTransportEquipment> getBorderTransportEquipments() {
        return borderTransportEquipments;
    }

    public void setBorderTransportEquipments(List<BorderTransportEquipment> borderTransportEquipments) {
        this.borderTransportEquipments = borderTransportEquipments;
    }

    public BorderTransportMeans getBorderTransportMeans() {
        return borderTransportMeans;
    }

    public void setBorderTransportMeans(BorderTransportMeans borderTransportMeans) {
        this.borderTransportMeans = borderTransportMeans;
    }

    public Consignment getConsignment() {
        return consignment;
    }

    public void setConsignment(Consignment consignment) {
        this.consignment = consignment;
    }

    public String getCustomsMaster() {
        return customsMaster;
    }

    public void setCustomsMaster(String customsMaster) {
        this.customsMaster = customsMaster;
    }

    public String getContractorCodeScc() {
        return contractorCodeScc;
    }

    public void setContractorCodeScc(String contractorCodeScc) {
        this.contractorCodeScc = contractorCodeScc;
    }

    public String getStationPersonName() {
        return StationPersonName;
    }

    public void setStationPersonName(String stationPersonName) {
        StationPersonName = stationPersonName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}