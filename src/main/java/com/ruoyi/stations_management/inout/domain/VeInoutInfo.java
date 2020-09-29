package com.ruoyi.stations_management.inout.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 进出场查询对象 g_ve_inout
 *
 * @author qishuai
 * @date 2020-01-02
 */
@ApiModel("进出场查询对象")
public class VeInoutInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @ApiModelProperty("ID")
    private Long id;

    /** 车牌号 */
    @ApiModelProperty("车牌号")
    @Excel(name = "车牌号")
    private String veLicenseNo;

    /** 进场时间 */
    @ApiModelProperty("进场时间")
    @Excel(name = "进场时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String veInTime;

    /** 进场重量 */
    @ApiModelProperty("进场重量")
    @Excel(name = "进场重量")
    private String veInWeight;

    /** 出场时间 */
    @ApiModelProperty("出场时间")
    @Excel(name = "出场时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String veOutTime;

    /** 出场重量 */
    @ApiModelProperty("出场重量")
    @Excel(name = "出场重量")
    private String veOutWeight;

    public void setId(Long id)
    {
        this.id = id;
    }
    public Long getId()
    {
        return id;
    }

    public void setVeLicenseNo(String veLicenseNo)
    {
        this.veLicenseNo = veLicenseNo;
    }
    public String getVeLicenseNo()
    {
        return veLicenseNo;
    }

    public void setVeInTime(String veInTime)
    {
        this.veInTime = veInTime;
    }
    public String getVeInTime()
    {
        return veInTime;
    }

    public void setVeInWeight(String veInWeight)
    {
        this.veInWeight = veInWeight;
    }
    public String getVeInWeight()
    {
        return veInWeight;
    }

    public void setVeOutTime(String veOutTime)
    {
        this.veOutTime = veOutTime;
    }
    public String getVeOutTime()
    {
        return veOutTime;
    }

    public void setVeOutWeight(String veOutWeight)
    {
        this.veOutWeight = veOutWeight;
    }
    public String getVeOutWeight()
    {
        return veOutWeight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("veLicenseNo", getVeLicenseNo())
                .append("veInTime", getVeInTime())
                .append("veInWeight", getVeInWeight())
                .append("veOutTime", getVeOutTime())
                .append("veOutWeight", getVeOutWeight())
                .toString();
    }
}
