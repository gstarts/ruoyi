package com.ruoyi.stations_management.waybill.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.stations_management.enterprise.domain.SEnterpriseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 通关单对象 s_customs_clearance
 *
 * @author qishuai
 * @date 2020-02-25
 */
@ApiModel("通关单对象")
public class CustomsClearance extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 通关单号
     */
    @ApiModelProperty("通关单号")
    @Excel(name = "通关单号")
    private String ccCustomsNumber;

    /**
     * 通关单批次号
     */
    @ApiModelProperty("通关单批次号")
    @Excel(name = "通关单批次号")
    private String ccCustomsBatchNumber;

    /**
     * 通关单重量
     */
    @ApiModelProperty("通关单重量")
    @Excel(name = "通关单重量")
    private String ccCustomsWieght;

    /**
     * 使用重量
     */
    @ApiModelProperty("使用重量")
    private int useWieght;
    /**
     * 通关单剩余重量
     */
    @ApiModelProperty("通关单剩余重量")
    private String ccLastWieght;

    /**
     * 所属公司
     */
    @ApiModelProperty("所属公司")
    private int ccCorporation;

    /**
     * 所属公司对象
     */
    private SEnterpriseInfo enterpriseInfo;

    /**
     * 系统：版本号
     */
    @ApiModelProperty("版本号")
    private Long version;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date crtime;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String cruser;

    /**
     * 创建人名称
     */
    @ApiModelProperty("创建人名称")
    private String crusername;

    /**
     * 是否删除状态
     */
    @ApiModelProperty("是否删除状态")
    private Long del;
    //列表排序
    private String order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCcCustomsNumber() {
        return ccCustomsNumber;
    }

    public void setCcCustomsNumber(String ccCustomsNumber) {
        this.ccCustomsNumber = StringUtils.trim(ccCustomsNumber);
    }

    public String getCcCustomsBatchNumber() {
        return ccCustomsBatchNumber;
    }

    public void setCcCustomsBatchNumber(String ccCustomsBatchNumber) {
        this.ccCustomsBatchNumber = StringUtils.trim(ccCustomsBatchNumber);
    }

    public String getCcCustomsWieght() {
        return ccCustomsWieght;
    }

    public void setCcCustomsWieght(String ccCustomsWieght) {
        this.ccCustomsWieght = StringUtils.trim(ccCustomsWieght);
    }

    public int getUseWieght() {
        return useWieght;
    }

    public void setUseWieght(int useWieght) {
        this.useWieght = useWieght;
    }

    public String getCcLastWieght() {
        return ccLastWieght;
    }

    public void setCcLastWieght(String ccLastWieght) {
        this.ccLastWieght = ccLastWieght;
    }

    public int getCcCorporation() {
        return ccCorporation;
    }

    public void setCcCorporation(int ccCorporation) {
        this.ccCorporation = ccCorporation;
    }

    public SEnterpriseInfo getEnterpriseInfo() {
        return enterpriseInfo;
    }

    public void setEnterpriseInfo(SEnterpriseInfo enterpriseInfo) {
        this.enterpriseInfo = enterpriseInfo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public String getCrusername() {
        return crusername;
    }

    public void setCrusername(String crusername) {
        this.crusername = crusername;
    }

    public Long getDel() {
        return del;
    }

    public void setDel(Long del) {
        this.del = del;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("ccCustomsNumber", getCcCustomsNumber())
                .append("ccCustomsBatchNumber", getCcCustomsBatchNumber())
                .append("ccCustomsWieght", getCcCustomsWieght())
                .append("ccCorporation", getCcCorporation())
                .append("version", getVersion())
                .append("crtime", getCrtime())
                .append("cruser", getCruser())
                .append("crusername", getCrusername())
                .append("del", getDel())
                .toString();
    }
}
