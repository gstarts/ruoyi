package com.ruoyi.stations_management.container.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 集装箱管理Head对象 s_mh_container
 * 
 * @author songxiangyang
 * @date 2020-06-11
 */
public class MhContainer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String plate;

    /** 承运单位 */
    @Excel(name = "承运单位")
    private String carryingUnit;

    /** 运输方式 */
    @Excel(name = "运输方式")
    private String shipCode;

    /** 录入人 */
    @Excel(name = "录入人")
    private String operator;

    /** 申报状态 */
    @Excel(name = "申报状态")
    private String decStatus;

    /** 进出场方向 */
    @Excel(name = "进出场方向")
    private String ieDirection;

    /** 集装箱对象 */
    private MbContainer mbContainer;

    /** 入场时间 */
    private String inTime;

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public MbContainer getMbContainer() {
        return mbContainer;
    }

    public void setMbContainer(MbContainer mbContainer) {
        this.mbContainer = mbContainer;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPlate(String plate) 
    {
        this.plate = plate;
    }

    public String getPlate() 
    {
        return plate;
    }
    public void setCarryingUnit(String carryingUnit) 
    {
        this.carryingUnit = carryingUnit;
    }

    public String getCarryingUnit() 
    {
        return carryingUnit;
    }
    public void setShipCode(String shipCode) 
    {
        this.shipCode = shipCode;
    }

    public String getShipCode() 
    {
        return shipCode;
    }
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
    }

    public String getDecStatus() {
        return decStatus;
    }

    public void setDecStatus(String decStatus) {
        this.decStatus = decStatus;
    }

    public String getIeDirection() {
        return ieDirection;
    }

    public void setIeDirection(String ieDirection) {
        this.ieDirection = ieDirection;
    }

    @Override
    public String toString() {
        return "MhContainer{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", carryingUnit='" + carryingUnit + '\'' +
                ", shipCode='" + shipCode + '\'' +
                ", operator='" + operator + '\'' +
                ", decStatus='" + decStatus + '\'' +
                ", ieDirection='" + ieDirection + '\'' +
                '}';
    }
}
