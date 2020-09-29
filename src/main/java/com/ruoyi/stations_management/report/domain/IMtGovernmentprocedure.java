package com.ruoyi.stations_management.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 海关货物通关代码对象 i_mt_governmentprocedure
 * 
 * @author songqingchuan
 * @date 2020-06-12
 */
public class IMtGovernmentprocedure extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long key;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long pId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String currentcode;

    public void setKey(Long key) 
    {
        this.key = key;
    }

    public Long getKey() 
    {
        return key;
    }
    public void setpId(Long pId) 
    {
        this.pId = pId;
    }

    public Long getpId() 
    {
        return pId;
    }
    public void setCurrentcode(String currentcode) 
    {
        this.currentcode = currentcode;
    }

    public String getCurrentcode() 
    {
        return currentcode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("key", getKey())
            .append("pId", getpId())
            .append("currentcode", getCurrentcode())
            .toString();
    }
}
