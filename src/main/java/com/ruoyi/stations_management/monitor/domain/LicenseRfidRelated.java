package com.ruoyi.stations_management.monitor.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车牌号与电子车牌号对照对象 g_license_rfid_related
 * 
 * @author lanzhenyuan
 * @date 2021-02-05
 */
public class LicenseRfidRelated extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 电子车牌 */
    @Excel(name = "电子车牌")
    private String rfId;

    /** 车牌 */
    @Excel(name = "车牌")
    private String veNo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRfId(String rfId) 
    {
        this.rfId = rfId;
    }

    public String getRfId() 
    {
        return rfId;
    }
    public void setVeNo(String veNo) 
    {
        this.veNo = veNo;
    }

    public String getVeNo() 
    {
        return veNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("rfId", getRfId())
            .append("veNo", getVeNo())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
