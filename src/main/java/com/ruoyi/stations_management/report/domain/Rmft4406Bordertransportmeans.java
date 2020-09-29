package com.ruoyi.stations_management.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 i_rmft4406_bordertransportmeans
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
public class Rmft4406Bordertransportmeans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 提（运）单数据ID */
    @Excel(name = "提", readConverterExp = "运=")
    private Long consignmentId;

    /** 运输工具抵达关境内第一个目的港的日期和时间 */
    @Excel(name = "运输工具抵达关境内第一个目的港的日期和时间")
    private String arrivalDateTime;

    /** 运输工具代码 */
    @Excel(name = "运输工具代码")
    private String borderId;

    /** 运输工具名称 */
    @Excel(name = "运输工具名称")
    private String name;

    /** 运输方式代码 */
    @Excel(name = "运输方式代码")
    private String typeCode;

    /** 驾驶员信息 */
    @Excel(name = "驾驶员信息")
    private String masterId;

    /** 驾驶员名称 */
    @Excel(name = "驾驶员名称")
    private String masterName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setConsignmentId(Long consignmentId) 
    {
        this.consignmentId = consignmentId;
    }

    public Long getConsignmentId() 
    {
        return consignmentId;
    }
    public void setArrivalDateTime(String arrivalDateTime)
    {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getArrivalDateTime()
    {
        return arrivalDateTime;
    }
    public void setBorderId(String borderId) 
    {
        this.borderId = borderId;
    }

    public String getBorderId() 
    {
        return borderId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTypeCode(String typeCode)
    {
        this.typeCode = typeCode;
    }

    public String getTypeCode()
    {
        return typeCode;
    }
    public void setMasterId(String masterId) 
    {
        this.masterId = masterId;
    }

    public String getMasterId() 
    {
        return masterId;
    }
    public void setMasterName(String masterName) 
    {
        this.masterName = masterName;
    }

    public String getMasterName() 
    {
        return masterName;
    }

    @Override
    public String toString() {
        return "Rmft4406Bordertransportmeans{" +
                "id=" + id +
                ", consignmentId=" + consignmentId +
                ", arrivalDateTime='" + arrivalDateTime + '\'' +
                ", borderId='" + borderId + '\'' +
                ", name='" + name + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", masterId='" + masterId + '\'' +
                ", masterName='" + masterName + '\'' +
                '}';
    }
}
