package com.ruoyi.stations_management.emptycar.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 运输工具信息 对象 i_mt_border_transport_06
 *
 * @author songqingchuan
 * @date 2020-06-15
 */
public class IMtBorderTransport06 extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long key;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long pId;

    /**
     * 运输工具抵达关境内第一个目的港的日期和时间
     */
    @Excel(name = "运输工具抵达关境内第一个目的港的日期和时间")
    private String arrivaldatetime;

    /**
     * 运输工具代码
     */
    @Excel(name = "运输工具代码")
    private String id;

    /**
     * 运输工具名称
     */
    @Excel(name = "运输工具名称")
    private String name;

    /**
     * 运输方式代码
     */
    @Excel(name = "运输方式代码")
    private String typecode;

    /**
     * s_mt_head
     */
    private IMtHead06 iMtHead06;

    public IMtHead06 getiMtHead06() {
        return iMtHead06;
    }

    public void setiMtHead06(IMtHead06 iMtHead06) {
        this.iMtHead06 = iMtHead06;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Long getKey() {
        return key;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getpId() {
        return pId;
    }

    public void setArrivaldatetime(String arrivaldatetime) {
        this.arrivaldatetime = arrivaldatetime;
    }

    public String getArrivaldatetime() {
        return arrivaldatetime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypecode() {
        return typecode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("key", getKey()).append("pId", getpId()).append("arrivaldatetime", getArrivaldatetime()).append("id", getId()).append("name", getName()).append("typecode", getTypecode()).toString();
    }
}
