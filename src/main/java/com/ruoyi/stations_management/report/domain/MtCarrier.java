package com.ruoyi.stations_management.report.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 承运人信息对象 s_mt_carrier
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
@ApiModel("承运人信息对象")
public class MtCarrier extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    private Long pId;


    // 主键key
    private Long key;

    /**
     * 承运人数据
     */
    @ApiModelProperty("承运人数据")
    @Excel(name = "承运人数据")
    private String id;
    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }


    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getpId() {
        return pId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("pId", getpId()).append("id", getId()).toString();
    }
}
