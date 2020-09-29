package com.ruoyi.stations_management.coal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 小提煤单对象 s_coal_number_plate
 *
 * @author songqingchuan
 * @date 2020-06-02
 */
@ApiModel("小提煤单对象")
public class CoalNumberPlate extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 大提煤单号
     */
    @ApiModelProperty("大提煤单号")
    @Excel(name = "大提煤单号")
    private String coalNumber;

    /**
     * 车号
     */
    @ApiModelProperty("车号")
    @Excel(name = "车号")
    private String plate;

    /**
     * 承运单位
     */
    @ApiModelProperty("承运单位")
    @Excel(name = "承运单位")
    private String carryingUnit;

    /**
     * 是否称重完成标示
     */
    @ApiModelProperty("是否称重完成标示")
    @Excel(name = "是否称重完成标示")
    private String finished;

    /**
     * 录入时间
     */
    @ApiModelProperty("录入时间")
    @Excel(name = "录入时间")
    private String dateTime;

    /**
     * 完成称重时间
     */
    @ApiModelProperty("完成称重时间")
    @Excel(name = "完成称重时间")
    private String dateTimeFinished;

    /**
     * 称重重量-实际
     */
    @ApiModelProperty("称重重量-实际")
    @Excel(name = "称重重量-实际")
    private String weight;

    /**
     * 打印次数
     */
    @ApiModelProperty("打印次数")
    @Excel(name = "打印次数")
    private String printTimes;

    /**
     * 作废标示
     */
    @ApiModelProperty("作废标示")
    @Excel(name = "作废标示")
    private String spoilt;

    /**
     * 司机姓名
     */
    @ApiModelProperty("司机姓名")
    @Excel(name = "司机姓名")
    private String driver;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    @Excel(name = "电话")
    private String phone;

    /**
     * 装载地点
     */
    @ApiModelProperty("装载地点")
    @Excel(name = "装载地点")
    private String loadPlace;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    @Excel(name = "装载地点")
    private String sn;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remarks;

    public String getDriveNum() {
        return driveNum;
    }

    public void setDriveNum(String driveNum) {
        this.driveNum = driveNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 驱动数(0:单桥 1:双桥)
     */
    @Excel(name = "驱动数")
    private String driveNum;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

    /**
     * 录入人
     */
    @Excel(name = "录入人")
    private String operator;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCoalNumber(String coalNumber) {
        this.coalNumber = coalNumber;
    }

    public String getCoalNumber() {
        return coalNumber;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public void setCarryingUnit(String carryingUnit) {
        this.carryingUnit = carryingUnit;
    }

    public String getCarryingUnit() {
        return carryingUnit;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getFinished() {
        return finished;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTimeFinished(String dateTimeFinished) {
        this.dateTimeFinished = dateTimeFinished;
    }

    public String getDateTimeFinished() {
        return dateTimeFinished;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setPrintTimes(String printTimes) {
        this.printTimes = printTimes;
    }

    public String getPrintTimes() {
        return printTimes;
    }

    public void setSpoilt(String spoilt) {
        this.spoilt = spoilt;
    }

    public String getSpoilt() {
        return spoilt;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setLoadPlace(String loadPlace) {
        this.loadPlace = loadPlace;
    }

    public String getLoadPlace() {
        return loadPlace;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("coalNumber", getCoalNumber()).append("plate", getPlate()).append("carryingUnit", getCarryingUnit()).append("finished", getFinished()).append("dateTime", getDateTime()).append("dateTimeFinished", getDateTimeFinished()).append("weight", getWeight()).append("printTimes", getPrintTimes()).append("spoilt", getSpoilt()).append("driver", getDriver()).append("phone", getPhone()).append("loadPlace", getLoadPlace()).append("sn", getSn()).append("remarks", getRemarks()).append("operator", getOperator()).toString();
    }
}
