package com.ruoyi.stations_management.emptycar.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 装货地信息对象 i_mt_loading_06
 * 
 * @author songqingchuan
 * @date 2020-06-15
 */
public class IMtLoading06 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long key;

    /** 装货地代码 */
    @Excel(name = "装货地代码")
    private String id;

    /** $column.columnComment */
    @Excel(name = "装货地代码")
    private Long pId;

    public void setKey(Long key) 
    {
        this.key = key;
    }

    public Long getKey() 
    {
        return key;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setpId(Long pId) 
    {
        this.pId = pId;
    }

    public Long getpId() 
    {
        return pId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("key", getKey())
            .append("id", getId())
            .append("pId", getpId())
            .toString();
    }
}
