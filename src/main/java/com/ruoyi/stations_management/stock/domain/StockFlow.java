package com.ruoyi.stations_management.stock.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 库存流水对象 s_stock_flow
 *
 * @author qishuai
 * @date 2020-07-24
 */
public class StockFlow extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 仓库ID
     */
    @Excel(name = "仓库ID")
    private String warehouseId;

    /**
     * 货运企业
     */
    @Excel(name = "货运企业ID")
    private String enterpriseId;
    /**
     * 仓库ID名称
     */
    @Excel(name = "仓库名称")
    private String warehouseName;

    /**
     * 货运企业名称
     */
    @Excel(name = "货运企业")
    private String enterpriseName;
    /**
     * 来源id
     */
    private String sourceId;

    /**
     * 品名
     */
    @Excel(name = "品名")
    private String name;

    /**
     * 货运车牌号
     */
    @Excel(name = "货运车牌号")
    private String veLicenseNo;

    /**
     * 进出方向
     */
    @Excel(name = "进出方向")
    private String direction;

    /**
     * 重量
     */
    @Excel(name = "重量")
    private String weight;

    /**
     * 操作时间
     */
    @Excel(name = "操作时间")
    private String optime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVeLicenseNo(String veLicenseNo) {
        this.veLicenseNo = veLicenseNo;
    }

    public String getVeLicenseNo() {
        return veLicenseNo;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setOptime(String optime) {
        this.optime = optime;
    }

    public String getOptime() {
        return optime;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    @Override
    public String toString() {
        return "StockFlow{" +
                "id=" + id +
                ", warehouseId=" + warehouseId +
                ", enterpriseId=" + enterpriseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", name='" + name + '\'' +
                ", veLicenseNo='" + veLicenseNo + '\'' +
                ", direction='" + direction + '\'' +
                ", weight='" + weight + '\'' +
                ", optime='" + optime + '\'' +
                '}';
    }
}
