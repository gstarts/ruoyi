package com.ruoyi.stations_management.report.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 装货地信息对象 s_mt_loading
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
@ApiModel("装货地信息对象")
public class MtLoading extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 装货地代码
     */
    @ApiModelProperty("装货地代码")
    private String id;

    // 主键key
    private Long key;


    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long pId;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getpId() {
        return pId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("pId", getpId()).toString();
    }
}
