package com.ruoyi.stations_management.measurement.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 计量单对象 s_measurement_sheet
 * 
 * @author lanzhenyuan
 * @date 2020-08-17
 */
public class MeasurementSheet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 末检时间 */
    @Excel(name = "末检时间")
    private String finalInspectionTime;

    /** 计量号 */
    @Excel(name = "计量号")
    private String measurementNum;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String plateNum;

    /** 货物名称 */
    @Excel(name = "货物名称")
    private String goodsName;

    /** 规格 */
    @Excel(name = "规格")
    private String specification;

    /** 承运人 */
    @Excel(name = "承运人")
    private String carrier;

    /** 皮重 */
    @Excel(name = "皮重")
    private Long tare;

    /** 毛重 */
    @Excel(name = "毛重")
    private Long grossWeight;

    /** 净重 */
    @Excel(name = "净重")
    private Long netWeight;

    /** 供货单位 */
    @Excel(name = "供货单位")
    private String deliveryUnit;

    /** 收货单位 */
    @Excel(name = "收货单位")
    private String receivingUnit;

    /** 流向 */
    @Excel(name = "流向")
    private String flowDirection;

    /** 计量员 */
    @Excel(name = "计量员")
    private String measurer;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFinalInspectionTime(String finalInspectionTime) 
    {
        this.finalInspectionTime = finalInspectionTime;
    }

    public String getFinalInspectionTime() 
    {
        return finalInspectionTime;
    }
    public void setMeasurementNum(String measurementNum) 
    {
        this.measurementNum = measurementNum;
    }

    public String getMeasurementNum() 
    {
        return measurementNum;
    }
    public void setPlateNum(String plateNum) 
    {
        this.plateNum = plateNum;
    }

    public String getPlateNum() 
    {
        return plateNum;
    }
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setSpecification(String specification) 
    {
        this.specification = specification;
    }

    public String getSpecification() 
    {
        return specification;
    }
    public void setCarrier(String carrier) 
    {
        this.carrier = carrier;
    }

    public String getCarrier() 
    {
        return carrier;
    }
    public void setTare(Long tare) 
    {
        this.tare = tare;
    }

    public Long getTare() 
    {
        return tare;
    }
    public void setGrossWeight(Long grossWeight) 
    {
        this.grossWeight = grossWeight;
    }

    public Long getGrossWeight() 
    {
        return grossWeight;
    }
    public void setNetWeight(Long netWeight) 
    {
        this.netWeight = netWeight;
    }

    public Long getNetWeight() 
    {
        return netWeight;
    }
    public void setDeliveryUnit(String deliveryUnit) 
    {
        this.deliveryUnit = deliveryUnit;
    }

    public String getDeliveryUnit() 
    {
        return deliveryUnit;
    }
    public void setReceivingUnit(String receivingUnit) 
    {
        this.receivingUnit = receivingUnit;
    }

    public String getReceivingUnit() 
    {
        return receivingUnit;
    }
    public void setFlowDirection(String flowDirection) 
    {
        this.flowDirection = flowDirection;
    }

    public String getFlowDirection() 
    {
        return flowDirection;
    }
    public void setMeasurer(String measurer) 
    {
        this.measurer = measurer;
    }

    public String getMeasurer() 
    {
        return measurer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("finalInspectionTime", getFinalInspectionTime())
            .append("measurementNum", getMeasurementNum())
            .append("plateNum", getPlateNum())
            .append("goodsName", getGoodsName())
            .append("specification", getSpecification())
            .append("carrier", getCarrier())
            .append("tare", getTare())
            .append("grossWeight", getGrossWeight())
            .append("netWeight", getNetWeight())
            .append("deliveryUnit", getDeliveryUnit())
            .append("receivingUnit", getReceivingUnit())
            .append("flowDirection", getFlowDirection())
            .append("measurer", getMeasurer())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
