package com.ruoyi.stations_management.montroller.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 车辆通关时电子车牌信息对象 g_ve_rfid
 * 
 * @author songxiangyang
 * @date 2020-06-28
 */
public class VeRfid extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 会话编号 */
    @Excel(name = "会话编号")
    private String sessionId;

    /** 电子车牌标签号 */
    @Excel(name = "电子车牌标签号")
    private String rfidId;

    /** 电子车牌车牌号 */
    @Excel(name = "电子车牌车牌号")
    private String veLicenseNo;

    /** 海关车辆编号 */
    @Excel(name = "海关车辆编号")
    private String veCustomsNo;

    /** 车辆称重 */
    @Excel(name = "车辆称重")
    private String veWt;

    /** 车辆所属公司 */
    @Excel(name = "车辆所属公司")
    private String veCompany;

    /** 单位时间读卡次数 */
    @Excel(name = "单位时间读卡次数")
    private String vePerformance;

    /** 境外或港澳车牌号 */
    @Excel(name = "境外或港澳车牌号")
    private String veLicenseNo2;

    /** 托架号 */
    @Excel(name = "托架号")
    private String trailerId;

    /** 地磅误差 */
    @Excel(name = "地磅误差")
    private String weightDiff;

    /** 地磅称重 */
    @Excel(name = "地磅称重")
    private String channelWeight;

    /** 车辆理论总重量 */
    @Excel(name = "车辆理论总重量")
    private String grossWeight;

    /** 车辆自重 */
    @Excel(name = "车辆自重")
    private String vehicleWeight;

    /** 司机海关编号 */
    @Excel(name = "司机海关编号")
    private String drCustomsNo;

    /** 司机姓名 */
    @Excel(name = "司机姓名")
    private String drName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSessionId(String sessionId) 
    {
        this.sessionId = sessionId;
    }

    public String getSessionId() 
    {
        return sessionId;
    }
    public void setRfidId(String rfidId) 
    {
        this.rfidId = rfidId;
    }

    public String getRfidId() 
    {
        return rfidId;
    }
    public void setVeLicenseNo(String veLicenseNo) 
    {
        this.veLicenseNo = veLicenseNo;
    }

    public String getVeLicenseNo() 
    {
        return veLicenseNo;
    }
    public void setVeCustomsNo(String veCustomsNo) 
    {
        this.veCustomsNo = veCustomsNo;
    }

    public String getVeCustomsNo() 
    {
        return veCustomsNo;
    }
    public void setVeWt(String veWt) 
    {
        this.veWt = veWt;
    }

    public String getVeWt() 
    {
        return veWt;
    }
    public void setVeCompany(String veCompany) 
    {
        this.veCompany = veCompany;
    }

    public String getVeCompany() 
    {
        return veCompany;
    }
    public void setVePerformance(String vePerformance) 
    {
        this.vePerformance = vePerformance;
    }

    public String getVePerformance() 
    {
        return vePerformance;
    }
    public void setVeLicenseNo2(String veLicenseNo2) 
    {
        this.veLicenseNo2 = veLicenseNo2;
    }

    public String getVeLicenseNo2() 
    {
        return veLicenseNo2;
    }
    public void setTrailerId(String trailerId) 
    {
        this.trailerId = trailerId;
    }

    public String getTrailerId() 
    {
        return trailerId;
    }
    public void setWeightDiff(String weightDiff) 
    {
        this.weightDiff = weightDiff;
    }

    public String getWeightDiff() 
    {
        return weightDiff;
    }
    public void setChannelWeight(String channelWeight) 
    {
        this.channelWeight = channelWeight;
    }

    public String getChannelWeight() 
    {
        return channelWeight;
    }
    public void setGrossWeight(String grossWeight) 
    {
        this.grossWeight = grossWeight;
    }

    public String getGrossWeight() 
    {
        return grossWeight;
    }
    public void setVehicleWeight(String vehicleWeight) 
    {
        this.vehicleWeight = vehicleWeight;
    }

    public String getVehicleWeight() 
    {
        return vehicleWeight;
    }
    public void setDrCustomsNo(String drCustomsNo) 
    {
        this.drCustomsNo = drCustomsNo;
    }

    public String getDrCustomsNo() 
    {
        return drCustomsNo;
    }
    public void setDrName(String drName) 
    {
        this.drName = drName;
    }

    public String getDrName() 
    {
        return drName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sessionId", getSessionId())
            .append("rfidId", getRfidId())
            .append("veLicenseNo", getVeLicenseNo())
            .append("veCustomsNo", getVeCustomsNo())
            .append("veWt", getVeWt())
            .append("veCompany", getVeCompany())
            .append("vePerformance", getVePerformance())
            .append("veLicenseNo2", getVeLicenseNo2())
            .append("trailerId", getTrailerId())
            .append("weightDiff", getWeightDiff())
            .append("channelWeight", getChannelWeight())
            .append("grossWeight", getGrossWeight())
            .append("vehicleWeight", getVehicleWeight())
            .append("drCustomsNo", getDrCustomsNo())
            .append("drName", getDrName())
            .toString();
    }
}
