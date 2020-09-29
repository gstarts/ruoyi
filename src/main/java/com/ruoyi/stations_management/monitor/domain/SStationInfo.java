package com.ruoyi.stations_management.monitor.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 s_station_info
 * 
 * @author qishuai
 * @date 2020-06-11
 */
public class SStationInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 场站名称 */
    @Excel(name = "场站名称")
    private String stationName;

    /** 申报地海关 */
    @Excel(name = "申报地海关")
    private String customsmaster;

    /** 组织机构代码 */
    @Excel(name = "组织机构代码")
    private String contractorcode;

    /** 统一社会信用代码 */
    @Excel(name = "统一社会信用代码")
    private String contractorcodescc;

    /** 作业场所编号 */
    @Excel(name = "作业场所编号")
    private String supvloctcode;

    /** 操作人ID */
    @Excel(name = "操作人ID")
    private String opuserid;

    /** 发送ID */
    @Excel(name = "发送ID")
    private String senderid;

    /** 接收ID */
    @Excel(name = "接收ID")
    private String receiverid;

    /** 接口协议版本号 */
    @Excel(name = "接口协议版本号")
    private String version;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStationName(String stationName) 
    {
        this.stationName = stationName;
    }

    public String getStationName() 
    {
        return stationName;
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
    public void setSupvloctcode(String supvloctcode) 
    {
        this.supvloctcode = supvloctcode;
    }

    public String getSupvloctcode() 
    {
        return supvloctcode;
    }
    public void setOpuserid(String opuserid) 
    {
        this.opuserid = opuserid;
    }

    public String getOpuserid() 
    {
        return opuserid;
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
    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getVersion() 
    {
        return version;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stationName", getStationName())
            .append("customsmaster", getCustomsmaster())
            .append("contractorcode", getContractorcode())
            .append("contractorcodescc", getContractorcodescc())
            .append("supvloctcode", getSupvloctcode())
            .append("opuserid", getOpuserid())
            .append("senderid", getSenderid())
            .append("receiverid", getReceiverid())
            .append("version", getVersion())
            .toString();
    }
}
