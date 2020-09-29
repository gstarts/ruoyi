package com.ruoyi.stations_management.declare.domain;

import com.ruoyi.stations_management.common.domain.StationInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 动物头对象 i_animals_head
 *
 * @author qishuai
 * @date 2020-04-07
 */
@ApiModel("动物头对象")
public class AnimalsHead extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty("主键")
    private Long id;

    /** 报文编码(业务类型（2位）＋作业场所（场地）代码＋四位年＋两位月＋两位日＋两位小时（24小时制）＋两位分钟＋两位秒＋三位毫秒。业务类型默认值： 01高风险动植物及其产品数据。如申报数据需拆成多个报文发送时（每个报文不得大于4m），多个报文的msgid保持一致) */
    @ApiModelProperty("主键")
    @Excel(name = "报文编码(业务类型", readConverterExp = "2=位")
    private String msgid;

    /** 报文类型csa03 */
    @ApiModelProperty("报文类型")
    @Excel(name = "报文类型csa03")
    private String msgtype;

    /** 关卡代码场所现场海关代码（4位代码） */
    @ApiModelProperty("关卡代码场所现场海关代码")
    @Excel(name = "关卡代码场所现场海关代码", readConverterExp = "4=位代码")
    private String customscode;

    /** 作业场所编号作业场所（场地）编码 */
    @ApiModelProperty("作业场所编号作业场所")
    @Excel(name = "作业场所编号作业场所", readConverterExp = "场=地")
    private String supvloctcode;

    /** 报文发送时间yyyy-mm-dd hh:mm:ss */
    @ApiModelProperty("报文发送时间")
    @Excel(name = "报文发送时间yyyy-mm-dd hh:mm:ss")
    private String decldate;

    /** 申报数据类型0:全量数据1:增量数据（暂不需要传该种数据） */
    @ApiModelProperty("申报数据类型")
    @Excel(name = "申报数据类型0:全量数据1:增量数据", readConverterExp = "暂=不需要传该种数据")
    private String declaredatatype;

    /** 申报数据报文总数 */
    @ApiModelProperty("申报数据报文总数")
    @Excel(name = "申报数据报文总数")
    private String totalmsgno;

    /** 当前报文序号申报数据分多个报文发送时，填写当前报文序号 */
    @ApiModelProperty("当前报文序号申报数据分多个报文发送时，填写当前报文序号")
    @Excel(name = "当前报文序号申报数据分多个报文发送时，填写当前报文序号")
    private String curmsgno;

    /** 接收反馈报文时间 */
    @ApiModelProperty("接收反馈报文时间")
    @Excel(name = "接收反馈报文时间")
    private String recvdecldata;

    /** 1表示成功  0表示失败 */
    @ApiModelProperty("1表示成功  0表示失败")
    @Excel(name = "1表示成功  0表示失败")
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
    @ApiModelProperty("场站")
    private StationInfo station;

    /** 是否删除状态 */
    @ApiModelProperty("是否删除状态")
    @Excel(name = "是否删除状态")
    private Long del;


    public StationInfo getStation() {
        return station;
    }

    public void setStation(StationInfo station) {
        this.station = station;
    }

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
    public void setRecvdecldata(String recvdecldata)
    {
        this.recvdecldata = recvdecldata;
    }

    public String getRecvdecldata()
    {
        return recvdecldata;
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
            .append("recvdecldata", getRecvdecldata())
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
