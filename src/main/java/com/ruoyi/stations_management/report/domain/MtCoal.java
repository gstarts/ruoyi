package com.ruoyi.stations_management.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 s_mt_coal
 * 
 * @author songqingchuan
 * @date 2020-06-09
 */
public class MtCoal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long pId;
    // 主键
    private  Long key;

    /** 箱号 */
    @Excel(name = "箱号")
    private String id;

    /** 尺寸类型 */
    @Excel(name = "尺寸类型")
    private String characteristiccode;

    /** 来源 */
    @Excel(name = "来源")
    private String supplierpartytypecode;

    /** 自重 */
    @Excel(name = "自重")
    private String tareweight;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public void setpId(Long pId)
    {
        this.pId = pId;
    }

    public Long getpId() 
    {
        return pId;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCharacteristiccode(String characteristiccode) 
    {
        this.characteristiccode = characteristiccode;
    }

    public String getCharacteristiccode() 
    {
        return characteristiccode;
    }
    public void setSupplierpartytypecode(String supplierpartytypecode) 
    {
        this.supplierpartytypecode = supplierpartytypecode;
    }

    public String getSupplierpartytypecode() 
    {
        return supplierpartytypecode;
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
            .append("pId", getpId())
            .append("id", getId())
            .append("characteristiccode", getCharacteristiccode())
            .append("supplierpartytypecode", getSupplierpartytypecode())
            .append("tareweight", getTareweight())
            .toString();
    }
}
