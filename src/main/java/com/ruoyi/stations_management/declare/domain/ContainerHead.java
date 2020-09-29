package com.ruoyi.stations_management.declare.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 集装箱头对象 i_container_head
 * 
 * @author songqingchuan
 * @date 2020-04-07
 */
@ApiModel("集装箱头对象")
public class ContainerHead extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty("主键")
    private Long id;

    /** 报文编码 */
    @ApiModelProperty("报文编码")
    @Excel(name = "报文编码")
    private String msgid;

    /** 报文类型'csa01' */
    @ApiModelProperty("报文类型")
    @Excel(name = "报文类型'csa01'")
    private String msgtype;

    /** 关卡代码 */
    @ApiModelProperty("关卡代码")
    @Excel(name = "关卡代码")
    private String customscode;

    /** 作业场所编号 */
    @ApiModelProperty("作业场所编号")
    @Excel(name = "作业场所编号")
    private String supvloctcode;

    /** 报文发送时间 */
    @ApiModelProperty("报文发送时间")
    @Excel(name = "报文发送时间")
    private String decldate;

    /** 申报数据类型0 */
    @ApiModelProperty("申报数据类型0")
    @Excel(name = "申报数据类型0")
    private String declaredatatype;

    /** 申报数据报文总数1 */
    @ApiModelProperty("申报数据报文总数1")
    @Excel(name = "申报数据报文总数1")
    private String totalmsgno;

    /** 当前报文序号1 */
    @ApiModelProperty("当前报文序号1")
    @Excel(name = "当前报文序号1")
    private String curmsgno;

    /** 申报状态0 */
    @ApiModelProperty("申报状态0")
    @Excel(name = "申报状态0")
    private String status;

    /** 报文回执时间 */
    @ApiModelProperty("报文回执时间")
    @Excel(name = "报文回执时间")
    private String receiptdecldate;

    /** 处理结果 */
    @ApiModelProperty("处理结果")
    @Excel(name = "处理结果")
    private String result;

    /** 系统：版本号 */
    @ApiModelProperty("版本号")
    @Excel(name = "系统：版本号")
    private Long version;

    /** 创建时间 */
    @ApiModelProperty("创建时间")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
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
    public void setMsgid(String msgid) 
    {
        this.msgid = msgid;
    }

    public String getMsgid() 
    {
        return msgid;
    }
    public void setMsgtype(String msgtype) 
    {
        this.msgtype = msgtype;
    }

    public String getMsgtype() 
    {
        return msgtype;
    }
    public void setCustomscode(String customscode) 
    {
        this.customscode = customscode;
    }

    public String getCustomscode() 
    {
        return customscode;
    }
    public void setSupvloctcode(String supvloctcode) 
    {
        this.supvloctcode = supvloctcode;
    }

    public String getSupvloctcode() 
    {
        return supvloctcode;
    }
    public void setDecldate(String decldate) 
    {
        this.decldate = decldate;
    }

    public String getDecldate() 
    {
        return decldate;
    }
    public void setDeclaredatatype(String declaredatatype) 
    {
        this.declaredatatype = declaredatatype;
    }

    public String getDeclaredatatype() 
    {
        return declaredatatype;
    }
    public void setTotalmsgno(String totalmsgno) 
    {
        this.totalmsgno = totalmsgno;
    }

    public String getTotalmsgno() 
    {
        return totalmsgno;
    }
    public void setCurmsgno(String curmsgno) 
    {
        this.curmsgno = curmsgno;
    }

    public String getCurmsgno() 
    {
        return curmsgno;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setReceiptdecldate(String receiptdecldate) 
    {
        this.receiptdecldate = receiptdecldate;
    }

    public String getReceiptdecldate() 
    {
        return receiptdecldate;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
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
            .append("msgid", getMsgid())
            .append("msgtype", getMsgtype())
            .append("customscode", getCustomscode())
            .append("supvloctcode", getSupvloctcode())
            .append("decldate", getDecldate())
            .append("declaredatatype", getDeclaredatatype())
            .append("totalmsgno", getTotalmsgno())
            .append("curmsgno", getCurmsgno())
            .append("status", getStatus())
            .append("receiptdecldate", getReceiptdecldate())
            .append("result", getResult())
            .append("remark", getRemark())
            .append("version", getVersion())
            .append("crtime", getCrtime())
            .append("cruser", getCruser())
            .append("crusername", getCrusername())
            .append("del", getDel())
            .toString();
    }
}
