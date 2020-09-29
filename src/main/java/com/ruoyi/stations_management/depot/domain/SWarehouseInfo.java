package com.ruoyi.stations_management.depot.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 仓库管理对象 s_warehouse_info
 * 
 * @author qishuai
 * @date 2020-01-01
 */
@ApiModel("仓库实体")
public class SWarehouseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long id;

    /** 仓库名称 */
    @ApiModelProperty("仓库名称")
    @Excel(name = "仓库名称")
    private String wName;

    /** 仓库类型（） */
    @ApiModelProperty("仓库类型")
    @Excel(name = "仓库类型", readConverterExp = "仓库类型（）")
    private String wType;

    /** 仓库面积 */
    @ApiModelProperty("仓库面积")
    @Excel(name = "仓库面积")
    private String wMeasure;

    /** 仓库地点 */
    @ApiModelProperty("仓库地点")
    @Excel(name = "仓库地点")
    private String wAddr;

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

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setwName(String wName) 
    {
        this.wName = wName;
    }

    public String getwName() 
    {
        return wName;
    }
    public void setwType(String wType) 
    {
        this.wType = wType;
    }

    public String getwType() 
    {
        return wType;
    }
    public void setwMeasure(String wMeasure) 
    {
        this.wMeasure = wMeasure;
    }

    public String getwMeasure() 
    {
        return wMeasure;
    }
    public void setwAddr(String wAddr) 
    {
        this.wAddr = wAddr;
    }

    public String getwAddr() 
    {
        return wAddr;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("wName", getwName())
            .append("wType", getwType())
            .append("wMeasure", getwMeasure())
            .append("wAddr", getwAddr())
            .append("version", getVersion())
            .append("crtime", getCrtime())
            .append("cruser", getCruser())
            .append("crusername", getCrusername())
            .append("del", getDel())
            .toString();
    }
}
