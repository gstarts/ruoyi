package com.ruoyi.stations_management.enterprise.domain;

import com.ruoyi.stations_management.common.domain.StationInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 场站配置 对象 s_station_config
 *
 * @author qishuai
 * @date 2020-04-30
 */
@ApiModel("")
public class SStationConfig extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("$column.columnComment")
    private Long id;

    /**
     * 场站id
     */
    @ApiModelProperty("场站id")
    @Excel(name = "场站id")
    private Long stationId;

    /**
     * 是否自动申报(0:否 1:是)
     */
    @ApiModelProperty("")
    @Excel(name = "是否自动申报(0:否 1:是)")
    private String isDeclare;

    /**
     * 是否自动录入(0:否 1:是)
     */
    @ApiModelProperty("是否自动录入(0:否 1:是)")
    @Excel(name = "是否自动录入(0:否 1:是)")
    private String isEntry;

    /**
     * 散杂货是否申报(0:否 1:是)
     */
    @ApiModelProperty("散杂货是否申报(0:否 1:是)")
    @Excel(name = "散杂货是否申报(0:否 1:是)")
    private String isDeclareGoods;

    @ApiModelProperty("atationinfo")
    private StationInfo atationinfo;

    public StationInfo getAtationinfo() {
        return atationinfo;
    }

    public void setAtationinfo(StationInfo atationinfo) {
        this.atationinfo = atationinfo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setIsDeclare(String isDeclare) {
        this.isDeclare = isDeclare;
    }

    public String getIsDeclare() {
        return isDeclare;
    }

    public void setIsEntry(String isEntry) {
        this.isEntry = isEntry;
    }

    public String getIsEntry() {
        return isEntry;
    }

    public void setIsDeclareGoods(String isDeclareGoods) {
        this.isDeclareGoods = isDeclareGoods;
    }

    public String getIsDeclareGoods() {
        return isDeclareGoods;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("stationId", getStationId()).append("isDeclare", getIsDeclare()).append("isEntry", getIsEntry()).append("isDeclareGoods", getIsDeclareGoods()).toString();
    }
}
