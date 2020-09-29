package com.ruoyi.stations_management.emptycar.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 托架或拖挂车信息 对象 i_mt_transport_06
 * 
 * @author songqingchuan
 * @date 2020-06-15
 */
public class IMtTransport06 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long key;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long pId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long id;

    /** 托架或拖挂车类型代码 */
    @Excel(name = "托架或拖挂车类型代码")
    private String typecode;

    /** 托架或拖挂车自重 */
    @Excel(name = "托架或拖挂车自重")
    private String tareweight;

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
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTypecode(String typecode) 
    {
        this.typecode = typecode;
    }

    public String getTypecode() 
    {
        return typecode;
    }
    public void setTareweight(String tareweight) 
    {
        this.tareweight = tareweight;
    }

    public String getTareweight() 
    {
        return tareweight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("key", getKey())
            .append("pId", getpId())
            .append("id", getId())
            .append("typecode", getTypecode())
            .append("tareweight", getTareweight())
            .toString();
    }
}
