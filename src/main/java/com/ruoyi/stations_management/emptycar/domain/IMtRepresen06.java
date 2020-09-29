package com.ruoyi.stations_management.emptycar.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 i_mt_represen_06
 * 
 * @author songqingchuan
 * @date 2020-06-15
 */
public class IMtRepresen06 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long key;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long pId;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String name;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("key", getKey())
            .append("pId", getpId())
            .append("name", getName())
            .toString();
    }
}
