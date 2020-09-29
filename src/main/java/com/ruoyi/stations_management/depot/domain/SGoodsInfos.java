package com.ruoyi.stations_management.depot.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excels;
import com.ruoyi.stations_management.vehicle.domain.SVehicleInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 仓库货物对象 s_goods_info
 *
 * @author qishuai
 * @date 2020-01-01
 */
@ApiModel("仓库货物")
public class SGoodsInfos extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**ID*/
    @ApiModelProperty("ID")
    private Long id;

    /**车辆ID*/
    @ApiModelProperty("车辆ID")
    @Excel(name = "车辆ID")
    private Long gVehicleId;

    /**货物名称 */
    @ApiModelProperty("货物名称")
    @Excel(name = "货物名称")
    private String gName;

    /** 货物单位 */
    @ApiModelProperty("货物单位")
    @Excel(name = "货物单位")
    private String gUnit;

    /** 货物重量 */
    @ApiModelProperty("货物重量")
    @Excel(name = "货物重量")
    private Long gWeight;

    /** 货物体积 */
    @ApiModelProperty("货物体积")
    @Excel(name = "货物体积")
    private String gVolume;

    /** 货物数量 */
    @ApiModelProperty("货物数量")
    @Excel(name = "货物数量")
    private Long gNumber;

    /** 货物所属仓库 */
    @ApiModelProperty("货物所属仓库")
    @Excel(name = "货物所属仓库")
    private Long gWarehouseId;

    /** 货物状态（1、入库；2、出库） */
    @ApiModelProperty("货物状态")
    @Excel(name = "货物状态", readConverterExp = "1=、入库；2、出库")
    private String gIEStatus;

    /** 备注 */
    @ApiModelProperty("备注")
    private String gRemarks;

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
    /** 车辆对象 */
    @Excels({
            @Excel(name = "车牌号", targetAttr = "vLicense", type = Excel.Type.EXPORT)
    })
    @ApiModelProperty("车辆对象")
    private SVehicleInfo vehicle;

    /** 仓库对象 */
    @Excels({
            @Excel(name = "仓库名称", targetAttr = "wName", type = Excel.Type.EXPORT)
    })
    @ApiModelProperty("仓库对象")
    private SWarehouseInfo warehouse;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setgVehicleId(Long gVehicleId)
    {
        this.gVehicleId = gVehicleId;
    }

    public Long getgVehicleId()
    {
        return gVehicleId;
    }
    public void setgName(String gName)
    {
        this.gName = gName;
    }

    public String getgName()
    {
        return gName;
    }
    public void setgUnit(String gUnit)
    {
        this.gUnit = gUnit;
    }

    public String getgUnit()
    {
        return gUnit;
    }
    public void setgWeight(Long gWeight)
    {
        this.gWeight = gWeight;
    }

    public Long getgWeight()
    {
        return gWeight;
    }
    public void setgVolume(String gVolume)
    {
        this.gVolume = gVolume;
    }

    public String getgVolume()
    {
        return gVolume;
    }
    public void setgNumber(Long gNumber)
    {
        this.gNumber = gNumber;
    }

    public Long getgNumber()
    {
        return gNumber;
    }
    public void setgWarehouseId(Long gWarehouseId)
    {
        this.gWarehouseId = gWarehouseId;
    }

    public Long getgWarehouseId()
    {
        return gWarehouseId;
    }
    public void setgIEStatus(String gIEStatus)
    {
        this.gIEStatus = gIEStatus;
    }

    public String getgIEStatus()
    {
        return gIEStatus;
    }
    public void setgRemarks(String gRemarks)
    {
        this.gRemarks = gRemarks;
    }

    public String getgRemarks()
    {
        return gRemarks;
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

    public SVehicleInfo getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(SVehicleInfo vehicle)
    {
        this.vehicle = vehicle;
    }

    public SWarehouseInfo getWarehouse()
    {
        return warehouse;
    }

    public void setWarehouse(SWarehouseInfo warehouse)
    {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gVehicleId", getgVehicleId())
            .append("gName", getgName())
            .append("gUnit", getgUnit())
            .append("gWeight", getgWeight())
            .append("gVolume", getgVolume())
            .append("gNumber", getgNumber())
            .append("gWarehouseId", getgWarehouseId())
            .append("gIEStatus", getgIEStatus())
            .append("gRemarks", getgRemarks())
            .append("version", getVersion())
            .append("crtime", getCrtime())
            .append("cruser", getCruser())
            .append("crusername", getCrusername())
            .append("del", getDel())
            .append("vehicle", getVehicle())
            .append("warehouse", getWarehouse())
            .toString();
    }
}
