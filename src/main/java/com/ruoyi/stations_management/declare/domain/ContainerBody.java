package com.ruoyi.stations_management.declare.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 集装箱体对象 i_container_body
 * 
 * @author songqingchuan
 * @date 2020-04-07
 */
@ApiModel("集装箱体对象")
public class ContainerBody extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty("主键")
    private Long id;

    /** 报文头id */
    @ApiModelProperty("报文头id")
// @Excel(name = "报文头id")
    private Long headId;

    /** 集装箱号 */
    @ApiModelProperty("集装箱号")
    @Excel(name = "集装箱号")
    private String contaid;

    /** 集装箱尺寸 */
    @ApiModelProperty("集装箱尺寸")
    @Excel(name = "集装箱尺寸")
    private String contatypecode;

    /** 箱位代码 */
    @ApiModelProperty("箱位代码")
    @Excel(name = "箱位代码")
    private String seat;

    /** 内外贸标识 */
    @ApiModelProperty("内外贸标识")
    @Excel(name = "内外贸标识")
    private String trademark;

    /** 进出口标识 */
    @ApiModelProperty("进出口标识")
    @Excel(name = "进出口标识")
    private String ieflag;

    /** 拼箱状态 */
    @ApiModelProperty("拼箱状态")
    @Excel(name = "拼箱状态")
    private String contamark;

    @ApiModelProperty("装载状态")
    @Excel(name = "装载状态")
    private String loadmark;

    /** 危品柜状态 */
    @ApiModelProperty("危品柜状态")
    @Excel(name = "危品柜状态")
    private String dangermark;

    /** 进场时间 */
    @ApiModelProperty("进场时间")
    @Excel(name = "进场时间")
    private String entrancedate;

    /** 出场时间（海关放行后实际出场时间） */
    @ApiModelProperty("出场时间")
    @Excel(name = "出场时间", readConverterExp = "海=关放行后实际出场时间")
    private String departturedate;

    /** 当前状态 */
    @ApiModelProperty("当前状态")
    @Excel(name = "当前状态")
    private String workmark;

    /** 数据处理标识 */
    @ApiModelProperty("数据处理标识")
    @Excel(name = "数据处理标识")
    private String datadealflag;

    /** 提单号 */
    @ApiModelProperty("提单号")
    @Excel(name = "提单号")
    private String billno;

    /** 报关单号 */
    @ApiModelProperty("报关单号")
    @Excel(name = "报关单号")
    private String entryid;

    /** 转关单号 */
    @ApiModelProperty("转关单号")
    @Excel(name = "转关单号")
    private String preno;

    /** 多式联运单号 */
    @ApiModelProperty("多式联运单号")
    @Excel(name = "多式联运单号")
    private String mtapplyblno;

    /** 系统：版本号 */
    @ApiModelProperty("版本号")
    //  @Excel(name = "系统：版本号")
    private Long version;

    /** 创建时间 */
    @ApiModelProperty("创建时间")
// @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date crtime;

    /** 创建人 */
    @ApiModelProperty("创建人")
 //   @Excel(name = "创建人")
    private String cruser;

    /** 创建人名称 */
    @ApiModelProperty("创建人名称")
 //   @Excel(name = "创建人名称")
    private String crusername;

    /** 是否删除状态 */
    @ApiModelProperty("是否删除状态")
 //   @Excel(name = "是否删除状态")
    private Long del;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHeadId(Long headId) 
    {
        this.headId = headId;
    }

    public Long getHeadId() 
    {
        return headId;
    }
    public void setContaid(String contaid) 
    {
        this.contaid = contaid;
    }

    public String getContaid() 
    {
        return contaid;
    }
    public void setContatypecode(String contatypecode) 
    {
        this.contatypecode = contatypecode;
    }

    public String getContatypecode() 
    {
        return contatypecode;
    }
    public void setSeat(String seat) 
    {
        this.seat = seat;
    }

    public String getSeat() 
    {
        return seat;
    }
    public void setTrademark(String trademark) 
    {
        this.trademark = trademark;
    }

    public String getTrademark() 
    {
        return trademark;
    }
    public void setIeflag(String ieflag) 
    {
        this.ieflag = ieflag;
    }

    public String getIeflag() 
    {
        return ieflag;
    }
    public void setContamark(String contamark) 
    {
        this.contamark = contamark;
    }

    public String getContamark() 
    {
        return contamark;
    }
    public void setLoadmark(String loadmark) 
    {
        this.loadmark = loadmark;
    }

    public String getLoadmark() 
    {
        return loadmark;
    }
    public void setDangermark(String dangermark) 
    {
        this.dangermark = dangermark;
    }

    public String getDangermark() 
    {
        return dangermark;
    }
    public void setEntrancedate(String entrancedate) 
    {
        this.entrancedate = entrancedate;
    }

    public String getEntrancedate() 
    {
        return entrancedate;
    }
    public void setDepartturedate(String departturedate) 
    {
        this.departturedate = departturedate;
    }

    public String getDepartturedate() 
    {
        return departturedate;
    }
    public void setWorkmark(String workmark) 
    {
        this.workmark = workmark;
    }

    public String getWorkmark() 
    {
        return workmark;
    }
    public void setDatadealflag(String datadealflag) 
    {
        this.datadealflag = datadealflag;
    }

    public String getDatadealflag() 
    {
        return datadealflag;
    }
    public void setBillno(String billno) 
    {
        this.billno = billno;
    }

    public String getBillno() 
    {
        return billno;
    }
    public void setEntryid(String entryid) 
    {
        this.entryid = entryid;
    }

    public String getEntryid() 
    {
        return entryid;
    }
    public void setPreno(String preno) 
    {
        this.preno = preno;
    }

    public String getPreno() 
    {
        return preno;
    }
    public void setMtapplyblno(String mtapplyblno) 
    {
        this.mtapplyblno = mtapplyblno;
    }

    public String getMtapplyblno() 
    {
        return mtapplyblno;
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
            .append("headId", getHeadId())
            .append("contaid", getContaid())
            .append("contatypecode", getContatypecode())
            .append("seat", getSeat())
            .append("trademark", getTrademark())
            .append("ieflag", getIeflag())
            .append("contamark", getContamark())
            .append("loadmark", getLoadmark())
            .append("dangermark", getDangermark())
            .append("entrancedate", getEntrancedate())
            .append("departturedate", getDepartturedate())
            .append("workmark", getWorkmark())
            .append("datadealflag", getDatadealflag())
            .append("billno", getBillno())
            .append("entryid", getEntryid())
            .append("preno", getPreno())
            .append("mtapplyblno", getMtapplyblno())
            .append("remark", getRemark())
            .append("version", getVersion())
            .append("crtime", getCrtime())
            .append("cruser", getCruser())
            .append("crusername", getCrusername())
            .append("del", getDel())
            .toString();
    }
}
