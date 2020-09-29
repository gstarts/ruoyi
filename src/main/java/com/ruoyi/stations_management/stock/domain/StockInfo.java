package com.ruoyi.stations_management.stock.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;

/**
 * 库存信息对象 s_stock_info
 *
 * @author qishuai
 * @date 2020-03-31
 */
@ApiModel("库存信息对象")
public class StockInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * $column.columnComment
     */
    private Long id;
    /**
     *  仓库id
     */
    private String warehouseId;
    /**
     * 仓库名称
     */
    @Excel(name = "仓库ID")
    private String warehouseName;
    /**
     * 仓库ID
     */
    private String enterpriseId;
    /**
     * 货运企业名称
     */
    @Excel(name = "货运企业")
    private String enterpriseName;

    /**
     * 入库重量
     */
    @Excel(name = "入库重量")
    private String iWeight;
    /**
     * 出库重量
     */
    @Excel(name = "出库重量")
    private String eWeight;
    /**
     * 期间
     */
    private String period;
    /**
     * 统计时间
     */
    private String time;
    /**
     * 操作时间
     */
    private String optime;
    private String direction;
    /**
     * 库存重量
     */
    private String zWeingt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getiWeight() {
        return iWeight;
    }

    public void setiWeight(String iWeight) {
        this.iWeight = iWeight;
    }

    public String geteWeight() {
        return eWeight;
    }

    public void seteWeight(String eWeight) {
        this.eWeight = eWeight;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOptime() {
        return optime;
    }

    public void setOptime(String optime) {
        this.optime = optime;
    }

    public String getzWeingt() {
        return zWeingt;
    }

    public void setzWeingt(String zWeingt) {
        this.zWeingt = zWeingt;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "id=" + id +
                ", warehouseId='" + warehouseId + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", iWeight='" + iWeight + '\'' +
                ", eWeight='" + eWeight + '\'' +
                ", period='" + period + '\'' +
                ", time='" + time + '\'' +
                ", optime='" + optime + '\'' +
                ", zWeingt='" + zWeingt + '\'' +
                '}';
    }
}
