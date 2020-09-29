package com.ruoyi.stations_management.coal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;


import java.util.List;


/**
 * 大提煤单对象 s_coal_number
 *
 * @author songqingchuan
 * @date 2020-06-02
 */
@ApiModel("大提煤单对象")
public class CoalNumber extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 提煤单号
     */
    @ApiModelProperty("提煤单号")
    @Excel(name = "提煤单号")
    private String coalNumber;

    /**
     * 收货单位
     */
    @ApiModelProperty("收货单位")
    @Excel(name = "收货单位")
    private String receivingUnit;

    /**
     * 客户
     */
    @ApiModelProperty("客户")
    @Excel(name = "客户")
    private String custom;

    /**
     * 货物名称
     */
    @ApiModelProperty("货物名称")
    @Excel(name = "货物名称")
    private String variety;

    /**
     * 合同号
     */
    @ApiModelProperty("合同号")
    @Excel(name = "合同号")
    private String contract;

    /**
     * 提煤量
     */
    @ApiModelProperty("提煤量")
    @Excel(name = "提煤量")
    private String weight;

    /**
     * 录入时间
     */
    @ApiModelProperty("录入时间")
    @Excel(name = "录入时间")
    private String dateTime;

    /**
     * 录入人
     */
    @ApiModelProperty("录入人")
    @Excel(name = "录入人")
    private String operator;

    /**
     * 作废标示
     */
    @ApiModelProperty("作废标示")
//    @Excel(name = "作废标示")
    private String spoilt;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
//    @Excel(name = "作废标示")
    private String securityKey;

    /**
     * 执行完成标示
     */
    @ApiModelProperty("执行完成标示")
//    @Excel(name = "执行完成标示")
    private String finished;

    /**
     * 小提煤单
     */
    @ApiModelProperty("小提煤单")
    private List<CoalNumberPlate> cNumberPlate;

    /**
     * 小提煤单车号
     */
    @ApiModelProperty("小提煤单车号")
    private String plate;


    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public List<CoalNumberPlate> getcNumberPlate() {
        return cNumberPlate;
    }

    public void setcNumberPlate(List<CoalNumberPlate> cNumberPlate) {
        this.cNumberPlate = cNumberPlate;
    }

    public void setCoalNumber(String coalNumber) {
        this.coalNumber = coalNumber;
    }

    public String getCoalNumber() {
        return coalNumber;
    }

    public void setReceivingUnit(String receivingUnit) {
        this.receivingUnit = receivingUnit;
    }

    public String getReceivingUnit() {
        return receivingUnit;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getCustom() {
        return custom;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getVariety() {
        return variety;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getContract() {
        return contract;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setSpoilt(String spoilt) {
        this.spoilt = spoilt;
    }

    public String getSpoilt() {
        return spoilt;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return "CoalNumber{" + "coalNumber='" + coalNumber + '\'' + ", receivingUnit='" + receivingUnit + '\'' + ", custom='" + custom + '\'' + ", variety='" + variety + '\'' + ", contract='" + contract + '\'' + ", weight='" + weight + '\'' + ", dateTime='" + dateTime + '\'' + ", operator='" + operator + '\'' + ", spoilt='" + spoilt + '\'' + ", securityKey='" + securityKey + '\'' + ", finished='" + finished + '\'' + ", cNumberPlate=" + cNumberPlate + '}';
    }
}
