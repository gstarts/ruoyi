package com.ruoyi.stations_management.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 集装箱（器）信息对象 i_rmft4406_transportequipment
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
public class Rmft4406Transportequipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 提（运）单数据ID */
    @Excel(name = "提", readConverterExp = "运=")
    private Long consignmentId;

    /** 集装箱（器）尺寸和类型 */
    @Excel(name = "集装箱", readConverterExp = "器=")
    private String characteristicCode;

    /** 集装箱（器）重箱或者空箱标识代码 */
    @Excel(name = "集装箱", readConverterExp = "器=")
    private String fullnessCode;

    /** 集装箱（器）编号 */
    @Excel(name = "集装箱", readConverterExp = "器=")
    private String transportEquipmentId;

    /** 集装箱（器）封志号码、类型及施加封志人类型 */
    @Excel(name = "集装箱", readConverterExp = "器=")
    private String sealId;

    /** 集装箱（器）来源代码 */
    @Excel(name = "集装箱", readConverterExp = "器=")
    private String supplierPartyTypeCode;

    /** 集装箱（器）自重 */
    @Excel(name = "集装箱", readConverterExp = "器=")
    private String tareWeight;

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
    public void setCharacteristicCode(String characteristicCode)
    {
        this.characteristicCode = characteristicCode;
    }

    public String getCharacteristicCode()
    {
        return characteristicCode;
    }
    public void setFullnessCode(String fullnessCode)
    {
        this.fullnessCode = fullnessCode;
    }

    public String getFullnessCode()
    {
        return fullnessCode;
    }
    public void setTransportEquipmentId(String transportEquipmentId)
    {
        this.transportEquipmentId = transportEquipmentId;
    }

    public String getTransportEquipmentId()
    {
        return transportEquipmentId;
    }
    public void setSealId(String sealId)
    {
        this.sealId = sealId;
    }

    public String getSealId()
    {
        return sealId;
    }
    public void setSupplierPartyTypeCode(String supplierPartyTypeCode)
    {
        this.supplierPartyTypeCode = supplierPartyTypeCode;
    }

    public String getSupplierPartyTypeCode()
    {
        return supplierPartyTypeCode;
    }
    public void setTareWeight(String tareWeight)
    {
        this.tareWeight = tareWeight;
    }

    public String getTareWeight()
    {
        return tareWeight;
    }

    @Override
    public String toString() {
        return "Rmft4406Transportequipment{" +
                "id=" + id +
                ", consignmentId=" + consignmentId +
                ", characteristicCode='" + characteristicCode + '\'' +
                ", fullnessCode='" + fullnessCode + '\'' +
                ", transportEquipmentId='" + transportEquipmentId + '\'' +
                ", sealId='" + sealId + '\'' +
                ", supplierPartyTypeCode='" + supplierPartyTypeCode + '\'' +
                ", tareWeight='" + tareWeight + '\'' +
                '}';
    }
}
