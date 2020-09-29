package com.ruoyi.stations_management.waybill.domain;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.stations_management.enterprise.domain.SEnterpriseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 申报车辆对象 s_declaration_vehicle
 *
 * @author qishuai
 * @date 2020-03-01
 */
@ApiModel("申报车辆对象")
public class DeclarationVehicle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 车牌号码
     */
    @ApiModelProperty("车牌号码")
    @Excel(name = "车牌号码")
    private String dvLicense;

    /**
     * 净重
     */
    @ApiModelProperty("净重")
    @Excel(name = "净重")
    private Integer dvWeight;

    /**
     * 载重
     */
    @ApiModelProperty("载重")
    @Excel(name = "载重")
    private Integer dvLoad;

    /**
     * 运输次数
     */
    @ApiModelProperty("运输次数")
    @Excel(name = "运输次数")
    private Long dvTransportNumber;
    /**
     * 已完成次数
     */
    @ApiModelProperty("已完成次数")
    private Long dvOutTimes;

    /**
     * 所属公司
     */
    @ApiModelProperty("所属公司")
    private int dvCorporation;

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
    /**
     * 公司对象
     */
    private SEnterpriseInfo enterpriseInfo;

    public SEnterpriseInfo getEnterpriseInfo() {
        return enterpriseInfo;
    }

    public void setEnterpriseInfo(SEnterpriseInfo enterpriseInfo) {
        this.enterpriseInfo = enterpriseInfo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDvLicense(String dvLicense) {
        this.dvLicense = StringUtils.trim(dvLicense);
    }

    public String getDvLicense() {
        return dvLicense;
    }

    public void setDvWeight(Integer dvWeight) {
        this.dvWeight = dvWeight;
    }

    public Integer getDvWeight() {
        return dvWeight;
    }

    public void setDvLoad(Integer dvLoad) {
        this.dvLoad = dvLoad;
    }

    public Integer getDvLoad() {
        return dvLoad;
    }

    public void setDvTransportNumber(Long dvTransportNumber) {
        this.dvTransportNumber = dvTransportNumber;
    }

    public Long getDvTransportNumber() {
        return dvTransportNumber;
    }


    public Long getDvOutTimes() {
        return dvOutTimes;
    }

    public void setDvOutTimes(Long dvOutTimes) {
        this.dvOutTimes = dvOutTimes;
    }

    public int getDvCorporation() {
        return dvCorporation;
    }

    public void setDvCorporation(int dvCorporation) {
        this.dvCorporation = dvCorporation;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCrusername(String crusername) {
        this.crusername = crusername;
    }

    public String getCrusername() {
        return crusername;
    }

    public void setDel(Long del) {
        this.del = del;
    }

    public Long getDel() {
        return del;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("dvLicense", getDvLicense())
                .append("dvWeight", getDvWeight())
                .append("dvLoad", getDvLoad())
                .append("dvTransportNumber", getDvTransportNumber())
                .append("dvCorporation", getDvCorporation())
                .append("version", getVersion())
                .append("crtime", getCrtime())
                .append("cruser", getCruser())
                .append("crusername", getCrusername())
                .append("del", getDel())
                .append("enterpriseInfo", getEnterpriseInfo())
                .toString();
    }
}
