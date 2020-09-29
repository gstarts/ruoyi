package com.ruoyi.stations_management.emptycar.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 对象 i_mt_head_06
 *
 * @author songqingchuan
 * @date 2020-06-15
 */
public class IMtHead06 extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long pid;

    /**
     * 货物运输批次号
     */
    @Excel(name = "货物运输批次号")
    private String id;

    /**
     * $column.columnComment
     */
    @Excel(name = "货物运输批次号")
    private String messageid;

    /**
     * $column.columnComment
     */
    @Excel(name = "货物运输批次号")
    private String functioncode;

    /**
     * $column.columnComment
     */
    @Excel(name = "货物运输批次号")
    private String messagetype;

    /**
     * $column.columnComment
     */
    @Excel(name = "货物运输批次号")
    private String senderid;

    /**
     * $column.columnComment
     */
    @Excel(name = "货物运输批次号")
    private String receiverid;

    /**
     * $column.columnComment
     */
    @Excel(name = "货物运输批次号")
    private String sendtime;

    /**
     * $column.columnComment
     */
    @Excel(name = "货物运输批次号")
    private String version;

    /**
     * 进出境口岸海关代码
     */
    @Excel(name = "进出境口岸海关代码")
    private String declarationofficeid;

    /**
     * 海关回执
     */
    @Excel(name = "海关回执")
    private String feedback;

    /**
     * 海关回执说明
     */
    @Excel(name = "海关回执说明")
    private String feedbackMsg;
    /**
     * iMtBorderTransport06 内的name
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 运输工具信息
     */
    private IMtBorderTransport06 iMtBorderTransport06;

    private IMtCarrier06 iMtCarrier06;

    private IMtGovernmentprocedure06 iMtGovernmentprocedure06;

    private IMtMaster06 mtMaster06;

    private IMtLoading06 iMtLoading06;

    private IMtRepresen06 iMtRepresen06;

    private IMtTransport06 iMtTransport06;

    public IMtBorderTransport06 getiMtBorderTransport06() {
        return iMtBorderTransport06;
    }

    public void setiMtBorderTransport06(IMtBorderTransport06 iMtBorderTransport06) {
        this.iMtBorderTransport06 = iMtBorderTransport06;
    }

    public IMtCarrier06 getiMtCarrier06() {
        return iMtCarrier06;
    }

    public void setiMtCarrier06(IMtCarrier06 iMtCarrier06) {
        this.iMtCarrier06 = iMtCarrier06;
    }

    public IMtGovernmentprocedure06 getiMtGovernmentprocedure06() {
        return iMtGovernmentprocedure06;
    }

    public void setiMtGovernmentprocedure06(IMtGovernmentprocedure06 iMtGovernmentprocedure06) {
        this.iMtGovernmentprocedure06 = iMtGovernmentprocedure06;
    }

    public IMtMaster06 getMtMaster06() {
        return mtMaster06;
    }

    public void setMtMaster06(IMtMaster06 mtMaster06) {
        this.mtMaster06 = mtMaster06;
    }

    public IMtLoading06 getiMtLoading06() {
        return iMtLoading06;
    }

    public void setiMtLoading06(IMtLoading06 iMtLoading06) {
        this.iMtLoading06 = iMtLoading06;
    }

    public IMtRepresen06 getiMtRepresen06() {
        return iMtRepresen06;
    }

    public void setiMtRepresen06(IMtRepresen06 iMtRepresen06) {
        this.iMtRepresen06 = iMtRepresen06;
    }

    public IMtTransport06 getiMtTransport06() {
        return iMtTransport06;
    }

    public void setiMtTransport06(IMtTransport06 iMtTransport06) {
        this.iMtTransport06 = iMtTransport06;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getPid() {
        return pid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setFunctioncode(String functioncode) {
        this.functioncode = functioncode;
    }

    public String getFunctioncode() {
        return functioncode;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype;
    }

    public String getMessagetype() {
        return messagetype;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid;
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setDeclarationofficeid(String declarationofficeid) {
        this.declarationofficeid = declarationofficeid;
    }

    public String getDeclarationofficeid() {
        return declarationofficeid;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedbackMsg(String feedbackMsg) {
        this.feedbackMsg = feedbackMsg;
    }

    public String getFeedbackMsg() {
        return feedbackMsg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("pid", getPid()).append("id", getId()).append("messageid", getMessageid()).append("functioncode", getFunctioncode()).append("messagetype", getMessagetype()).append("senderid", getSenderid()).append("receiverid", getReceiverid()).append("sendtime", getSendtime()).append("version", getVersion()).append("declarationofficeid", getDeclarationofficeid()).append("feedback", getFeedback()).append("feedbackMsg", getFeedbackMsg()).append("remark", getRemark()).toString();
    }
}
