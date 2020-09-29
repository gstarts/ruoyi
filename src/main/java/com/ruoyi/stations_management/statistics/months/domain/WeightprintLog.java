package com.ruoyi.stations_management.statistics.months.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 打印日志对象 s_weightprint_log
 *
 * @author songqingchuan
 * @date 2020-05-20
 */
@ApiModel("打印日志对象")
public class WeightprintLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    private Long id;

    /**
     * 车牌号
     */
    @ApiModelProperty("车牌号")
    @Excel(name = "车牌号")
    private String vehicleNo;

    /**
     * 计量号
     */
    @ApiModelProperty("计量号")
    @Excel(name = "计量号")
    private String calculateNum;

    /**
     * 货物名称
     */
    @ApiModelProperty("货物名称")
    @Excel(name = "货物名称")
    private String goodsName;

    /**
     * 规格
     */
    @ApiModelProperty("规格")
    @Excel(name = "规格")
    private String format;

    /**
     * 毛重
     */
    @ApiModelProperty("毛重")
    @Excel(name = "毛重")
    private Long grossWeight;

    /**
     * 皮重
     */
    @ApiModelProperty("皮重")
    @Excel(name = "皮重")
    private Long tareWeight;

    /**
     * 净重
     */
    @ApiModelProperty("净重")
    @Excel(name = "净重")
    private Long netWeight;

    /**
     * 承运人
     */
    @ApiModelProperty("承运人")
    @Excel(name = "承运人")
    private String carrier;

    /**
     * 供货单位
     */
    @ApiModelProperty("供货单位")
    @Excel(name = "供货单位")
    private String deliveryCompany;

    /**
     * 收获单位
     */
    @ApiModelProperty("收获单位")
    @Excel(name = "收获单位")
    private String receiptCompany;

    /**
     * 流向(默认调入)
     */
    @ApiModelProperty("流向(默认调入)")
    @Excel(name = "流向(默认调入)")
    private String flow;

    /**
     * 计量员名称
     */
    @ApiModelProperty("计量员名称")
    @Excel(name = "计量员名称")
    private String calculateName;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String remarke;

    /**
     * 末检时间
     */
    @ApiModelProperty("末检时间")
    @Excel(name = "末检时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date mjTime;

    /**
     * 0、代表只打印了进场磅单，1代表打印了出场磅单
     */
    @ApiModelProperty("0、代表只打印了进场磅单，1代表打印了出场磅单")
    @Excel(name = "0、代表只打印了进场磅单，1代表打印了出场磅单")
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setCalculateNum(String calculateNum) {
        this.calculateNum = calculateNum;
    }

    public String getCalculateNum() {
        return calculateNum;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setGrossWeight(Long grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Long getGrossWeight() {
        return grossWeight;
    }

    public void setTareWeight(Long tareWeight) {
        this.tareWeight = tareWeight;
    }

    public Long getTareWeight() {
        return tareWeight;
    }

    public void setNetWeight(Long netWeight) {
        this.netWeight = netWeight;
    }

    public Long getNetWeight() {
        return netWeight;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setReceiptCompany(String receiptCompany) {
        this.receiptCompany = receiptCompany;
    }

    public String getReceiptCompany() {
        return receiptCompany;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getFlow() {
        return flow;
    }

    public void setCalculateName(String calculateName) {
        this.calculateName = calculateName;
    }

    public String getCalculateName() {
        return calculateName;
    }

    public void setRemarke(String remarke) {
        this.remarke = remarke;
    }

    public String getRemarke() {
        return remarke;
    }

    public void setMjTime(Date mjTime) {
        this.mjTime = mjTime;
    }

    public Date getMjTime() {
        return mjTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("vehicleNo", getVehicleNo()).append("calculateNum", getCalculateNum()).append("goodsName", getGoodsName()).append("format", getFormat()).append("grossWeight", getGrossWeight()).append("tareWeight", getTareWeight()).append("netWeight", getNetWeight()).append("carrier", getCarrier()).append("deliveryCompany", getDeliveryCompany()).append("receiptCompany", getReceiptCompany()).append("flow", getFlow()).append("calculateName", getCalculateName()).append("remarke", getRemarke()).append("mjTime", getMjTime()).append("status", getStatus()).toString();
    }
}
