package com.ruoyi.stations_management.report.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 运输工具信息 对象 s_mt_border_transport
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
@ApiModel("运输工具信息 对象")
public class MtBorderTransport extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    private Long pId;


    // 主键key
    private Long key;

    /**
     * 运输工具抵达关境内第一个目的港的日期和时间
     */
    @ApiModelProperty("运输工具抵达关境内第一个目的港的日期和时间")
    @Excel(name = "运输工具抵达关境内第一个目的港的日期和时间")
    private String arrivaldatetime;

    /**
     * 运输工具代码
     */
    @ApiModelProperty("运输工具代码")
    @Excel(name = "运输工具代码")
    private String id;

    /**
     * 运输工具名称
     */
    @ApiModelProperty("运输工具名称")
    @Excel(name = "运输工具名称")
    private String name;

    /**
     * 运输方式代码
     */
    @ApiModelProperty("运输方式代码")
    @Excel(name = "运输方式代码")
    private String typecode;

    /**
     * s_mt_head
     */
    @ApiModelProperty("s_mt_head")
    private MtHead mtHead;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }


    public MtHead getMtHead() {
        return mtHead;
    }

    public void setMtHead(MtHead mtHead) {
        this.mtHead = mtHead;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("pId", getpId()).append("arrivaldatetime", getArrivaldatetime()).append("id", getId()).append("name", getName()).append("typecode", getTypecode()).toString();
    }
}
