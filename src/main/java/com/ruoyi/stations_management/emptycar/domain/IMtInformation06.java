package com.ruoyi.stations_management.emptycar.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 i_mt_information_06
 * 
 * @author songqingchuan
 * @date 2020-06-15
 */
public class IMtInformation06 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long key;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long pId;

    /** 补充信息数据 */
    @Excel(name = "补充信息数据")
    private String content;

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
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("key", getKey())
            .append("pId", getpId())
            .append("content", getContent())
            .toString();
    }
}
