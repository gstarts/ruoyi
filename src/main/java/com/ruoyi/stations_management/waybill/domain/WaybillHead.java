package com.ruoyi.stations_management.waybill.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 提运单申报对象 s_waybill_head
 *
 * @author qishuai
 * @date 2020-03-02
 */
@ApiModel("提运单申报对象")
public class WaybillHead  extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty("ID")
    private Long id;

    /** 系统自动生成唯一编号：年月6位+13位卡号+13位流水号 */
    @ApiModelProperty("系统自动生成唯一编号")
    @Excel(name = "系统自动生成唯一编号：年月6位+13位卡号+13位流水号")
    private String sureid;

    /**
     * 报文功能
     */
    @ApiModelProperty("报文功能")
    private String functionCode;

    /** 操作时间(格式：2019-03-14 16:27:46) */
    @ApiModelProperty("操作时间")
    @Excel(name = "操作时间(格式：2019-03-14 16:27:46)")
    private String optime;

    /** 操作人员操作人ID(操作人员编号) */
    @ApiModelProperty("操作人员操作人ID")
    @Excel(name = "操作人员操作人ID(操作人员编号)")
    private String opuserid;

    /** 绑定介质类型(VN车牌号/VE电子车牌号/IC卡/BC条形码) */
    @ApiModelProperty("绑定介质类型")
    @Excel(name = "绑定介质类型(VN车牌号/VE电子车牌号/IC卡/BC条形码)")
    private String bindkeytype;

    /** 绑定介质关键信息（车牌号、电子车牌序列号、IC卡号、条形码序列号，对应绑定介质类型） */
    @ApiModelProperty("绑定介质关键信息")
    @Excel(name = "绑定介质关键信息", readConverterExp = "车=牌号、电子车牌序列号、IC卡号、条形码序列号，对应绑定介质类型")
    private String bindkeyinfo;

    /** 业务类型100000000报关、010000000转关、0010000000查验分流、0001000000分拨分流、0000100000空箱、0000000100空车、0000010000集中查验、0000001000多式联运) */
    @ApiModelProperty("业务类型100000000报关")
    @Excel(name = "业务类型100000000报关、010000000转关、0010000000查验分流、0001000000分拨分流、0000100000空箱、0000000100空车、0000010000集中查验、0000001000多式联运)")
    private String rdcode;

    /** 运输方式(2海运，5航空，4公路) */
    @ApiModelProperty("运输方式")
    @Excel(name = "运输方式(2海运，5航空，4公路)")
    private String decltrafmode;

    /** I-进口,E-出口 */
    @ApiModelProperty("I-进口,E-出口")
    @Excel(name = "I-进口,E-出口")
    private String ieflag;

    /** 申报地海关 */
    @ApiModelProperty("用户名称")
    @Excel(name = "申报地海关")
    private String customsmaster;

    /** 组织机构代码 */
    @ApiModelProperty("组织机构代码")
    @Excel(name = "组织机构代码")
    private String contractorcode;

    /** 统一信用代码 */
    @ApiModelProperty("统一信用代码")
    @Excel(name = "统一信用代码")
    private String contractorcodescc;

    /** 过卡车辆类型01 重进空出，02 空进重出，03 重进重出，04 空进空出 */
    @ApiModelProperty("过卡车辆类型01")
    @Excel(name = "过卡车辆类型01 重进空出，02 空进重出，03 重进重出，04 空进空出")
    private String bayonetrdcode;

    /** 车辆重量 */
    @ApiModelProperty("车辆重量")
    @Excel(name = "车辆重量")
    private String vehicleweight;

    /** 挂车重量 */
    @ApiModelProperty("挂车重量")
    @Excel(name = "挂车重量")
    private String trailerweight;

    /** 集装箱重量 */
    @ApiModelProperty("集装箱重量")
    @Excel(name = "集装箱重量")
    private String contaweight;

    /** 回执状态(0:待申报 1:可申报 2:已上传 3:审批通过 4:审批退单 5:已完成) */
    @ApiModelProperty("回执状态")
    @Excel(name = "回执状态(0:待申报 1:可申报 2:已上传 3:审批通过 4:审批退单 5:已完成)")
    private String feedback;

    /** 回执说明 */
    @ApiModelProperty("回执说明")
    @Excel(name = "回执说明")
    private String feedbackMsg;

    /** 回执时间 */
    @ApiModelProperty("回执时间")
    @Excel(name = "回执时间")
    private String feedbackTime;

    /** 所属企业id */
    @ApiModelProperty("所属企业id")
    @Excel(name = "所属企业id")
    private Long enterpriseId;

    /** 企业ID */
    @ApiModelProperty("企业ID")
    @Excel(name = "企业ID")
    private Long version;

    /** $column.columnComment */
    @ApiModelProperty("crtime")
    @Excel(name = "企业ID", width = 30, dateFormat = "yyyy-MM-dd")
    private Date crtime;

    /** 创建人 */
    @ApiModelProperty("创建人")
    @Excel(name = "创建人")
    private String cruser;

    /** 创建人名称 */
    @ApiModelProperty("创建人名称")
    @Excel(name = "创建人名称")
    private String crusername;

    /** 是否删除状态 */
    @ApiModelProperty("是否删除状态")
    @Excel(name = "是否删除状态")
    private Long del;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public void setSureid(String sureid)
    {
        this.sureid = sureid;
    }

    public String getSureid()
    {
        return sureid;
    }
    public void setOptime(String optime)
    {
        this.optime = optime;
    }

    public String getOptime()
    {
        return optime;
    }
    public void setOpuserid(String opuserid)
    {
        this.opuserid = opuserid;
    }

    public String getOpuserid()
    {
        return opuserid;
    }
    public void setBindkeytype(String bindkeytype)
    {
        this.bindkeytype = bindkeytype;
    }

    public String getBindkeytype()
    {
        return bindkeytype;
    }
    public void setBindkeyinfo(String bindkeyinfo)
    {
        this.bindkeyinfo = bindkeyinfo;
    }

    public String getBindkeyinfo()
    {
        return bindkeyinfo;
    }
    public void setRdcode(String rdcode)
    {
        this.rdcode = rdcode;
    }

    public String getRdcode()
    {
        return rdcode;
    }
    public void setDecltrafmode(String decltrafmode)
    {
        this.decltrafmode = decltrafmode;
    }

    public String getDecltrafmode()
    {
        return decltrafmode;
    }
    public void setIeflag(String ieflag)
    {
        this.ieflag = ieflag;
    }

    public String getIeflag()
    {
        return ieflag;
    }
    public void setCustomsmaster(String customsmaster)
    {
        this.customsmaster = customsmaster;
    }

    public String getCustomsmaster()
    {
        return customsmaster;
    }
    public void setContractorcode(String contractorcode)
    {
        this.contractorcode = contractorcode;
    }

    public String getContractorcode()
    {
        return contractorcode;
    }
    public void setContractorcodescc(String contractorcodescc)
    {
        this.contractorcodescc = contractorcodescc;
    }

    public String getContractorcodescc()
    {
        return contractorcodescc;
    }
    public void setBayonetrdcode(String bayonetrdcode)
    {
        this.bayonetrdcode = bayonetrdcode;
    }

    public String getBayonetrdcode()
    {
        return bayonetrdcode;
    }
    public void setVehicleweight(String vehicleweight)
    {
        this.vehicleweight = vehicleweight;
    }

    public String getVehicleweight()
    {
        return vehicleweight;
    }
    public void setTrailerweight(String trailerweight)
    {
        this.trailerweight = trailerweight;
    }

    public String getTrailerweight()
    {
        return trailerweight;
    }
    public void setContaweight(String contaweight)
    {
        this.contaweight = contaweight;
    }

    public String getContaweight()
    {
        return contaweight;
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
    public void setFeedbackTime(String feedbackTime)
    {
        this.feedbackTime = feedbackTime;
    }

    public String getFeedbackTime()
    {
        return feedbackTime;
    }
    public void setEnterpriseId(Long enterpriseId)
    {
        this.enterpriseId = enterpriseId;
    }

    public Long getEnterpriseId()
    {
        return enterpriseId;
    }
    public void setVersion(Long version)
    {
        this.version = version;
    }

    public Long getVersion()
    {
        return version;
    }
    public void setCrtime(Date crtime)
    {
        this.crtime = crtime;
    }

    public Date getCrtime()
    {
        return crtime;
    }
    public void setCruser(String cruser)
    {
        this.cruser = cruser;
    }

    public String getCruser()
    {
        return cruser;
    }
    public void setCrusername(String crusername)
    {
        this.crusername = crusername;
    }

    public String getCrusername()
    {
        return crusername;
    }
    public void setDel(Long del)
    {
        this.del = del;
    }

    public Long getDel()
    {
        return del;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("sureid", getSureid())
                .append("optime", getOptime())
                .append("opuserid", getOpuserid())
                .append("bindkeytype", getBindkeytype())
                .append("bindkeyinfo", getBindkeyinfo())
                .append("rdcode", getRdcode())
                .append("decltrafmode", getDecltrafmode())
                .append("ieflag", getIeflag())
                .append("customsmaster", getCustomsmaster())
                .append("contractorcode", getContractorcode())
                .append("contractorcodescc", getContractorcodescc())
                .append("bayonetrdcode", getBayonetrdcode())
                .append("vehicleweight", getVehicleweight())
                .append("trailerweight", getTrailerweight())
                .append("contaweight", getContaweight())
                .append("feedback", getFeedback())
                .append("feedbackMsg", getFeedbackMsg())
                .append("feedbackTime", getFeedbackTime())
                .append("remark", getRemark())
                .append("enterpriseId", getEnterpriseId())
                .append("version", getVersion())
                .append("crtime", getCrtime())
                .append("cruser", getCruser())
                .append("crusername", getCrusername())
                .append("del", getDel())
                .toString();
    }
}
