package com.ruoyi.stations_management.vehicle.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excels;
import com.ruoyi.stations_management.enterprise.domain.SEnterpriseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 车辆备案对象 s_vehicle_info
 *
 * @author qishuai
 * @date 2020-01-01
 */
@ApiModel("车辆备案对象")
public class SVehicleInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty("ID")
    private Long id;

    /** 车牌号 */
    @ApiModelProperty("车牌号")
    @Excel(name = "车牌号")
    private String vLicense;

    /** 车辆绑定的IC卡号 */
    @ApiModelProperty("车辆绑定的IC卡号")
    private String vICNo;

    /** 车辆类型（关联车辆类型表，有外键） */
    @ApiModelProperty("车辆类型")
    @Excel(name = "车辆类型", readConverterExp = "关=联车辆类型表，有外键")
    private Long vType;

    /** 所属企业信息备案ID */
    @ApiModelProperty("所属企业信息备案ID")
    @Excel(name = "所属企业信息备案ID")
    private Long vEnterpriseId;

    /** 车主 */
    @Excel(name = "车主")
    @ApiModelProperty("车主")
    private String vOwner;

    /**企业名称*/
    @ApiModelProperty("企业名称")
    private  String vName;

    /** 收费类型（关联车辆收费类型表，有外键） */
    @ApiModelProperty("收费类型")
    private Long vChargeTypeId;

    /** 拖车号 */
    @ApiModelProperty("拖车号")
    private String vTrailerNo;

    /** 前车架号 */
    @ApiModelProperty("前车架号")
    private String vFrontNumber;

    /** 后车架号 */
    @ApiModelProperty("后车架号")
    private String vRearNumber;

    /** 车头重量 */
    @ApiModelProperty("车头重量")
    private Long vHeadstockWeight;

    /** 备注 */
    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String vRemarks;

    /** 长期收费车辆有效期 */
    @ApiModelProperty("长期收费车辆有效期")
    private Date vPayTime;

    /** 系统：版本号 */
    @ApiModelProperty("版本号")
    private Long version;

    /** 创建时间 */
    @ApiModelProperty("创建时间")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
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

    /** 企业对象 */
    @ApiModelProperty("企业对象")
    @Excels({
            @Excel(name = "企业名称", targetAttr = "eName", type = Excel.Type.EXPORT)
    })
    private SEnterpriseInfo enterpriseInfo;



    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setvLicense(String vLicense)
    {
        this.vLicense = vLicense;
    }

    public String getvLicense()
    {
        return vLicense;
    }
    public void setvType(Long vType)
    {
        this.vType = vType;
    }

    public Long getvType()
    {
        return vType;
    }
    public void setvEnterpriseId(Long vEnterpriseId)
    {
        this.vEnterpriseId = vEnterpriseId;
    }

    public Long getvEnterpriseId()
    {
        return vEnterpriseId;
    }
    public void setvOwner(String vOwner)
    {
        this.vOwner = vOwner;
    }

    public String getvOwner()
    {
        return vOwner;
    }
    public void setvChargeTypeId(Long vChargeTypeId)
    {
        this.vChargeTypeId = vChargeTypeId;
    }

    public Long getvChargeTypeId()
    {
        return vChargeTypeId;
    }
    public void setvTrailerNo(String vTrailerNo)
    {
        this.vTrailerNo = vTrailerNo;
    }

    public String getvTrailerNo()
    {
        return vTrailerNo;
    }
    public void setvFrontNumber(String vFrontNumber)
    {
        this.vFrontNumber = vFrontNumber;
    }

    public String getvFrontNumber()
    {
        return vFrontNumber;
    }
    public void setvRearNumber(String vRearNumber)
    {
        this.vRearNumber = vRearNumber;
    }

    public String getvRearNumber()
    {
        return vRearNumber;
    }
    public void setvHeadstockWeight(Long vHeadstockWeight)
    {
        this.vHeadstockWeight = vHeadstockWeight;
    }

    public Long getvHeadstockWeight()
    {
        return vHeadstockWeight;
    }
    public void setvRemarks(String vRemarks)
    {
        this.vRemarks = vRemarks;
    }

    public String getvRemarks()
    {
        return vRemarks;
    }
    public void setvPayTime(Date vPayTime)
    {
        this.vPayTime = vPayTime;
    }

    public Date getvPayTime()
    {
        return vPayTime;
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

    public SEnterpriseInfo getEnterpriseInfo()
    {
        return enterpriseInfo;
    }

    public void setEnterpriseInfo(SEnterpriseInfo enterpriseInfo)
    {
        this.enterpriseInfo = enterpriseInfo;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }
    public String getvICNo() {
        return vICNo;
    }

    public void setvICNo(String vICNo) {
        this.vICNo = vICNo;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("vLicense", getvLicense())
            .append("vType", getvType())
            .append("vEnterpriseId", getvEnterpriseId())
            .append("vOwner", getvOwner())
            .append("vChargeTypeId", getvChargeTypeId())
            .append("vTrailerNo", getvTrailerNo())
            .append("vFrontNumber", getvFrontNumber())
            .append("vRearNumber", getvRearNumber())
            .append("vHeadstockWeight", getvHeadstockWeight())
            .append("vRemarks", getvRemarks())
            .append("vPayTime", getvPayTime())
            .append("version", getVersion())
            .append("crtime", getCrtime())
            .append("cruser", getCruser())
            .append("crusername", getCrusername())
            .append("del", getDel())
            .append("enterpriseInfo", getEnterpriseInfo())
            .toString();
    }
}
