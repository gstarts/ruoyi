package com.ruoyi.stations_management.beltscale.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 皮带秤对象 s_belt_scale
 *
 * @author qishuai
 * @date 2020-07-24
 */
public class BeltScale extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private String id;

    /**
     * 品名
     */
    @Excel(name = "品名")
    private String name;

    /**
     * 班组
     */
    @Excel(name = "班组")
    private String team;

    /**
     * 值班日期
     */
    @Excel(name = "值班日期", width = 30, dateFormat = "yyyy-MM-dd")
    private String time;

    /**
     * 重量
     */
    @Excel(name = "重量")
    private String weight;
    /**
     * 所属仓库id
     */
    private String warehouseId;

    /**
     * 所属企业id
     */
    private String enterpriseId;

    /**
     * 删除标识
     */
    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("team", getTeam())
                .append("time", getTime())
                .append("weight", getWeight())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("warehouseId",getWarehouseId())
                .append("enterpriseId",getEnterpriseId())
                .toString();
    }
}
