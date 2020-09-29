package com.ruoyi.stations_management.report.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 驾驶员信息 对象 s_mt_master
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
@ApiModel("驾驶员信息")
public class MtMaster extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    private Long pId;

    // 主键key
    private Long key;



    /**
     * 驾驶员代码
     */
    @ApiModelProperty("驾驶员代码")
    @Excel(name = "驾驶员代码")
    private String id;


    public void setKey(Long key) {
        this.key = key;
    }

    public Long getKey() {
        return key;
    }
    /**
     * 驾驶员名称
     */
    @ApiModelProperty("驾驶员名称")
    @Excel(name = "驾驶员名称")
    private String name;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("pId", getpId()).append("id", getId()).append("name", getName()).toString();
    }
}
