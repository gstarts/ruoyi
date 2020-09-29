package com.ruoyi.stations_management.depot.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 仓库合同对象 s_warehouse_contract
 *
 * @author qishuai
 * @date 2020-01-04
 */
@ApiModel("仓库合同")
public class SWarehouseContract extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long id;

    /** 仓库ID */
    @ApiModelProperty("仓库ID")
    @Excel(name = "仓库ID")
    private Long cWarehouseId;

    /** 仓库名称 */
    @ApiModelProperty("仓库名称")
    private  String cWarehouseName;

    /** 企业ID */
    @ApiModelProperty("企业ID")
    @Excel(name = "企业ID")
    private Long cEnterpriseId;

    /** 仓库类型*/
    @ApiModelProperty("仓库类型")
    private String cWType;

    /** 费用 */
    @ApiModelProperty("费用")
    @Excel(name = "费用")
    private Long cPrice;

    /** 定金 */
    @ApiModelProperty("定金")
    @Excel(name = "定金")
    private Long cEarnest;

    /** 用途 */
    @ApiModelProperty("用途")
    @Excel(name = "用途")
    private String cPurpose;

    /** 租赁结束时间 */
    @ApiModelProperty("租赁结束时间")
    @Excel(name = "租赁结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cEndTime;

    /** 是否已经支付 */
    @ApiModelProperty("是否已经支付")
    @Excel(name = "是否已经支付")
    private String cIsPay;

    /** 备注 */
    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String cRemarks;

    /** 系统：版本号 */
    @ApiModelProperty("版本号")
    private Long version;

    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date crtime;

    /** 创建人 */
    @ApiModelProperty("创建人")
    private String cruser;

    /** 创建人名称 */
    @ApiModelProperty("创建人名称")
    private String crusername;

    /** 是否删除状态 */
    @ApiModelProperty("是否删除状态")
    private Long del;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setcWarehouseId(Long cWarehouseId)
    {
        this.cWarehouseId = cWarehouseId;
    }

    public Long getcWarehouseId()
    {
        return cWarehouseId;
    }
    public void setcEnterpriseId(Long cEnterpriseId)
    {
        this.cEnterpriseId = cEnterpriseId;
    }

    public Long getcEnterpriseId()
    {
        return cEnterpriseId;
    }
    public void setcPrice(Long cPrice)
    {
        this.cPrice = cPrice;
    }

    public Long getcPrice()
    {
        return cPrice;
    }
    public void setcEarnest(Long cEarnest)
    {
        this.cEarnest = cEarnest;
    }

    public Long getcEarnest()
    {
        return cEarnest;
    }
    public void setcPurpose(String cPurpose)
    {
        this.cPurpose = cPurpose;
    }

    public String getcPurpose()
    {
        return cPurpose;
    }
    public void setcEndTime(Date cEndTime)
    {
        this.cEndTime = cEndTime;
    }

    public Date getcEndTime()
    {
        return cEndTime;
    }
    public void setcIsPay(String cIsPay)
    {
        this.cIsPay = cIsPay;
    }

    public String getcIsPay()
    {
        return cIsPay;
    }
    public void setcRemarks(String cRemarks)
    {
        this.cRemarks = cRemarks;
    }

    public String getcRemarks()
    {
        return cRemarks;
    }
    public void setVersion(Long version)
    {
        this.version = version;
    }

    public Long getVersion()
    {
        return version;
    }
    public void setCrtime(Date crtime)
    {
        this.crtime = crtime;
    }

    public Date getCrtime()
    {
        return crtime;
    }
    public void setCruser(String cruser)
    {
        this.cruser = cruser;
    }

    public String getCruser()
    {
        return cruser;
    }
    public void setCrusername(String crusername)
    {
        this.crusername = crusername;
    }

    public String getCrusername()
    {
        return crusername;
    }
    public void setDel(Long del)
    {
        this.del = del;
    }

    public Long getDel()
    {
        return del;
    }
    public String getcWarehouseName() {
        return cWarehouseName;
    }

    public void setcWarehouseName(String cWarehouseName) {
        this.cWarehouseName = cWarehouseName;
    }

    public String getcWType() {
        return cWType;
    }

    public void setcWType(String cWType) {
        this.cWType = cWType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cWarehouseId", getcWarehouseId())
            .append("cEnterpriseId", getcEnterpriseId())
            .append("cPrice", getcPrice())
            .append("cEarnest", getcEarnest())
            .append("cPurpose", getcPurpose())
            .append("cEndTime", getcEndTime())
            .append("cIsPay", getcIsPay())
            .append("cRemarks", getcRemarks())
            .append("version", getVersion())
            .append("crtime", getCrtime())
            .append("cruser", getCruser())
            .append("crusername", getCrusername())
            .append("del", getDel())
            .toString();
    }
}
