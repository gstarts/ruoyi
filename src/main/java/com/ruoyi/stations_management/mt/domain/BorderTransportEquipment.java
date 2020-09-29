package com.ruoyi.stations_management.mt.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 托架或拖挂车信息对象
 * 
 * @author songqingchuan
 * @date 2020-07-27
 */
public class BorderTransportEquipment extends BaseEntity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBorderTransportMeansId() {
        return borderTransportMeansId;
    }

    public void setBorderTransportMeansId(Long borderTransportMeansId) {
        this.borderTransportMeansId = borderTransportMeansId;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(String tareWeight) {
        this.tareWeight = tareWeight;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Override
    public String toString() {
        return "BorderTransportEquipment{" +
                "id=" + id +
                ", borderTransportMeansId=" + borderTransportMeansId +
                ", transportId='" + transportId + '\'' +
                ", tareWeight='" + tareWeight + '\'' +
                ", typeCode='" + typeCode + '\'' +
                '}';
    }
}
