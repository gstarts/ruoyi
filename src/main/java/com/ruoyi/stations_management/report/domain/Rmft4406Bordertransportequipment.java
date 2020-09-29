package com.ruoyi.stations_management.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 i_rmft4406_bordertransportequipment
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
public class Rmft4406Bordertransportequipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 运输工具信息ID */
    @Excel(name = "运输工具信息ID")
    private Long borderTransportMeansId;

    /** 托架或拖挂车编号 */
    @Excel(name = "托架或拖挂车编号")
    private String transportId;

    /** 托架或拖挂车自重 */
    @Excel(name = "托架或拖挂车自重")
    private String tareWeight;

    /** 托架或拖挂车类型代码 */
    @Excel(name = "托架或拖挂车类型代码")
    private String typeCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBorderTransportMeansId(Long borderTransportMeansId)
    {
        this.borderTransportMeansId = borderTransportMeansId;
    }

    public Long getBorderTransportMeansId()
    {
        return borderTransportMeansId;
    }
    public void setTransportId(String transportId) 
    {
        this.transportId = transportId;
    }

    public String getTransportId() 
    {
        return transportId;
    }
    public void setTareWeight(String tareWeight)
    {
        this.tareWeight = tareWeight;
    }

    public String getTareWeight()
    {
        return tareWeight;
    }
    public void setTypeCode(String typeCode)
    {
        this.typeCode = typeCode;
    }

    public String getTypeCode()
    {
        return typeCode;
    }

    @Override
    public String toString() {
        return "Rmft4406Bordertransportequipment{" +
                "id=" + id +
                ", borderTransportMeansId=" + borderTransportMeansId +
                ", transportId='" + transportId + '\'' +
                ", tareWeight='" + tareWeight + '\'' +
                ", typeCode='" + typeCode + '\'' +
                '}';
    }
}
