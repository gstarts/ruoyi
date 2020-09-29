package com.ruoyi.stations_management.monitor.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 通道配置对象 s_chnl_info
 *
 * @author qishuai
 * @date 2020-03-24
 */
@ApiModel("通道配置对象实体")
public class ChnlInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("用户ID")
    private Long id;

    /**
     * 所属场站ID
     */
    @ApiModelProperty("所属场站ID")
    @Excel(name = "所属场站ID")
    private Long stationId;

    /**
     * 通道编号
     */
    @ApiModelProperty("通道编号")
    @Excel(name = "通道编号")
    private String cChnlNo;

    /**
     * 通道名称
     */
    @ApiModelProperty("通道名称")
    @Excel(name = "通道名称")
    private String cChnlName;

    /**
     * 车道类型：0、货运进口车道；1、货运出口车道；2、行政进口车道；3、行政出口车道
     */
    @ApiModelProperty("车道类型")
    @Excel(name = "车道类型：0、货运车道；1、行政车道；")
    private String cChnlType;

    @ApiModelProperty("车道方向")
    @Excel(name ="车道方向: I、进场；O 出场")
    private  String cChnlDirection;
    /**
     * 系统：版本号
     */
    @ApiModelProperty("版本号")
    @Excel(name = "系统：版本号")
    private Long version;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date crtime;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    @Excel(name = "创建人")
    private String cruser;

    /**
     * 创建人名称
     */
    @ApiModelProperty("创建人名称")
    @Excel(name = "创建人名称")
    private String crusername;
    /**
     * 使用状态
     */
    @ApiModelProperty("使用状态")
    private String status;
    /**
     * 是否删除状态
     */
    @ApiModelProperty("是否删除状态")
    @Excel(name = "是否删除状态")
    private Long del;
    /** 子通道 */
    private List<ChnlInfo> children = new ArrayList<ChnlInfo>();

    public List<ChnlInfo> getChildren() {
        return children;
    }

    public void setChildren(List<ChnlInfo> children) {
        this.children = children;
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

    public void setcChnlNo(String cChnlNo) {
        this.cChnlNo = cChnlNo;
    }

    public String getcChnlNo() {
        return cChnlNo;
    }

    public void setcChnlName(String cChnlName) {
        this.cChnlName = cChnlName;
    }

    public String getcChnlName() {
        return cChnlName;
    }

    public void setcChnlType(String cChnlType) {
        this.cChnlType = cChnlType;
    }

    public String getcChnlType() {
        return cChnlType;
    }

    public String getcChnlDirection() {
        return cChnlDirection;
    }

    public void setcChnlDirection(String cChnlDirection) {
        this.cChnlDirection = cChnlDirection;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCrusername(String crusername) {
        this.crusername = crusername;
    }

    public String getCrusername() {
        return crusername;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDel(Long del) {
        this.del = del;
    }

    public Long getDel() {
        return del;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("stationId", getStationId())
                .append("cChnlNo", getcChnlNo())
                .append("cChnlName", getcChnlName())
                .append("cChnlType", getcChnlType())
                .append("version", getVersion())
                .append("crtime", getCrtime())
                .append("cruser", getCruser())
                .append("crusername", getCrusername())
                .append("del", getDel())
                .toString();
    }
}
