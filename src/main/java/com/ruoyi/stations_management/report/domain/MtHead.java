package com.ruoyi.stations_management.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 【请填写功能名称】对象 s_mt_head
 * 
 * @author songqingchuan
 * @date 2020-06-09
 */
public class MtHead extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long pid;

    /** 货物运输批次号 */
    @Excel(name = "货物运输批次号")
    private String id;

    /** $column.columnComment */
    @Excel(name = "货物运输批次号")
    private String messageid;

    /** $column.columnComment */
    @Excel(name = "货物运输批次号")
    private String functioncode;

    /** $column.columnComment */
    @Excel(name = "货物运输批次号")
    private String messagetype;

    /** $column.columnComment */
    @Excel(name = "货物运输批次号")
    private String senderid;

    /** $column.columnComment */
    @Excel(name = "货物运输批次号")
    private String receiverid;

    /** $column.columnComment */
    @Excel(name = "货物运输批次号")
    private String sendtime;

    /** $column.columnComment */
    @Excel(name = "货物运输批次号")
    private String version;

    /** 进出境口岸海关代码 */
    @Excel(name = "进出境口岸海关代码")
    private String declarationofficeid;

    /** 海关回执 */
    @Excel(name = "海关回执")
    private String feedback;

    /** 海关回执说明 */
    @Excel(name = "海关回执说明")
    private String feedbackMsg;

    /** 运输信息表 */
    private MtBorderTransport mtBorderTransport;

    /**承运人信息*/
    private MtCarrier mtCarrier;
    /**
     * 集装箱
     */
    private List<MtCoal> mtCoal;
    /**
     * 装货地信息对象
     */
    private MtLoading mtLoading;
    /**
     * 驾驶员信息
     */
    private  MtMaster master;
    /**
     *确认人
     */
    private  MtRepresen mtRepresen;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     *托架或拖挂车信息
     */
    private List<MtTransport> mtTransport;


    /**
     * 海关货物通关代码
     */
     private IMtGovernmentprocedure iMtGovernmentprocedure;

    /** 运输工具 */
    private String name;

    /** 抵境第一时间 */
    private Date arrivalDateTime;

    /** 补充信息数据 */
    private MtInformation mtInformation;

    public List<MtTransport> getMtTransport() {
        return mtTransport;
    }

    public void setMtTransport(List<MtTransport> mtTransport) {
        this.mtTransport = mtTransport;
    }

    public MtInformation getMtInformation() {
        return mtInformation;
    }

    public void setMtInformation(MtInformation mtInformation) {
        this.mtInformation = mtInformation;
    }

    public IMtGovernmentprocedure getiMtGovernmentprocedure() {
        return iMtGovernmentprocedure;
    }

    public void setiMtGovernmentprocedure(IMtGovernmentprocedure iMtGovernmentprocedure) {
        this.iMtGovernmentprocedure = iMtGovernmentprocedure;
    }



    public MtCarrier getMtCarrier() {
        return mtCarrier;
    }

    public void setMtCarrier(MtCarrier mtCarrier) {
        this.mtCarrier = mtCarrier;
    }

    public List<MtCoal> getMtCoal() {
        return mtCoal;
    }

    public void setMtCoal(List<MtCoal> mtCoal) {
        this.mtCoal = mtCoal;
    }

    public MtLoading getMtLoading() {
        return mtLoading;
    }

    public void setMtLoading(MtLoading mtLoading) {
        this.mtLoading = mtLoading;
    }

    public MtMaster getMaster() {
        return master;
    }

    public void setMaster(MtMaster master) {
        this.master = master;
    }

    public MtRepresen getMtRepresen() {
        return mtRepresen;
    }

    public void setMtRepresen(MtRepresen mtRepresen) {
        this.mtRepresen = mtRepresen;
    }




    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MtBorderTransport getMtBorderTransport() {
        return mtBorderTransport;
    }

    public void setMtBorderTransport(MtBorderTransport mtBorderTransport) {
        this.mtBorderTransport = mtBorderTransport;
    }

    public void setPid(Long pid)
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setMessageid(String messageid) 
    {
        this.messageid = messageid;
    }

    public String getMessageid() 
    {
        return messageid;
    }
    public void setFunctioncode(String functioncode) 
    {
        this.functioncode = functioncode;
    }

    public String getFunctioncode() 
    {
        return functioncode;
    }
    public void setMessagetype(String messagetype) 
    {
        this.messagetype = messagetype;
    }

    public String getMessagetype() 
    {
        return messagetype;
    }
    public void setSenderid(String senderid) 
    {
        this.senderid = senderid;
    }

    public String getSenderid() 
    {
        return senderid;
    }
    public void setReceiverid(String receiverid) 
    {
        this.receiverid = receiverid;
    }

    public String getReceiverid() 
    {
        return receiverid;
    }
    public void setSendtime(String sendtime) 
    {
        this.sendtime = sendtime;
    }

    public String getSendtime() 
    {
        return sendtime;
    }
    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }
    public void setDeclarationofficeid(String declarationofficeid) 
    {
        this.declarationofficeid = declarationofficeid;
    }

    public String getDeclarationofficeid() 
    {
        return declarationofficeid;
    }
    public void setFeedback(String feedback) 
    {
        this.feedback = feedback;
    }

    public String getFeedback() 
    {
        return feedback;
    }
    public void setFeedbackMsg(String feedbackMsg) 
    {
        this.feedbackMsg = feedbackMsg;
    }

    public String getFeedbackMsg() 
    {
        return feedbackMsg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pid", getPid())
            .append("id", getId())
            .append("messageid", getMessageid())
            .append("functioncode", getFunctioncode())
            .append("messagetype", getMessagetype())
            .append("senderid", getSenderid())
            .append("receiverid", getReceiverid())
            .append("sendtime", getSendtime())
            .append("version", getVersion())
            .append("declarationofficeid", getDeclarationofficeid())
            .append("feedback", getFeedback())
            .append("feedbackMsg", getFeedbackMsg())
            .append("remark", getRemark())
            .toString();
    }
}
