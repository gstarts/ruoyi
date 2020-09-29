package com.ruoyi.stations_management.common.domain;

import com.ruoyi.stations_management.monitor.domain.ChnlInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 场站的基本信息对象 s_station_info
 *
 * @author qishuai
 * @date 2020-03-27
 */
@ApiModel("场站的基本信息对象")
public class StationInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty("$column.columnComment")
    private Long id;

    /** 场站名字 */
    @ApiModelProperty("场站名字")
    @Excel(name = "场站名")
    private String stationName;

    /** 申报地海关 */
    @ApiModelProperty("申报地海关")
    @Excel(name = "申报地海关")
    private String customsmaster;

    /** 组织机构代码 */
    @ApiModelProperty("组织机构代码")
    @Excel(name = "组织机构代码")
    private String contractorcode;

    /** 统一社会信用代码 */
    @ApiModelProperty("统一社会信用代码")
    @Excel(name = "统一社会信用代码")
    private String contractorcodescc;

    /** 作业场所编号 */
    @ApiModelProperty("作业场所编号")
    @Excel(name = "作业场所编号")
    private String supvloctcode;

    /** 操作人ID */
    @ApiModelProperty("操作人ID")
    @Excel(name = "操作人ID")
    private String opuserid;

    /** 发送ID */
    @ApiModelProperty("发送ID")
    @Excel(name = "发送ID")
    private String senderid;

    /** 接收ID */
    @ApiModelProperty("接收ID")
    @Excel(name = "接收ID")
    private String receiverid;

    /** 接口协议版本号 */
    @ApiModelProperty("接口协议版本号")
    @Excel(name = "接口协议版本号")
    private String version;
    /**场站子通道*/
    @ApiModelProperty("场站子通道")
    private List<ChnlInfo> children = new ArrayList<ChnlInfo>();

    /** 进出境承运确报传输人数据 */
    private String StationPersonName ;

    public String getStationPersonName() {
        return StationPersonName;
    }

    public void setStationPersonName(String stationPersonName) {
        StationPersonName = stationPersonName;
    }

    public List<ChnlInfo> getChildren() {
        return children;
    }

    public void setChildren(List<ChnlInfo> children) {
        this.children = children;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setStationName(String stationName)
    {
        this.stationName = stationName;
    }

    public String getStationName()
    {
        return stationName;
    }
    public void setCustomsmaster(String customsmaster)
    {
        this.customsmaster = customsmaster;
    }

    public String getCustomsmaster()
    {
        return customsmaster;
    }
    public void setContractorcode(String contractorcode)
    {
        this.contractorcode = contractorcode;
    }

    public String getContractorcode()
    {
        return contractorcode;
    }
    public void setContractorcodescc(String contractorcodescc)
    {
        this.contractorcodescc = contractorcodescc;
    }

    public String getContractorcodescc()
    {
        return contractorcodescc;
    }
    public void setSupvloctcode(String supvloctcode)
    {
        this.supvloctcode = supvloctcode;
    }

    public String getSupvloctcode()
    {
        return supvloctcode;
    }
    public void setOpuserid(String opuserid)
    {
        this.opuserid = opuserid;
    }

    public String getOpuserid()
    {
        return opuserid;
    }
    public void setSenderid(String senderid)
    {
        this.senderid = senderid;
    }

    public String getSenderid()
    {
        return senderid;
    }
    public void setReceiverid(String receiverid)
    {
        this.receiverid = receiverid;
    }

    public String getReceiverid()
    {
        return receiverid;
    }
    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getVersion()
    {
        return version;
    }

    @Override
    public String toString() {
        return "StationInfo{" + "id=" + id + ", stationName='" + stationName + '\'' + ", customsmaster='" + customsmaster + '\'' + ", contractorcode='" + contractorcode + '\'' + ", contractorcodescc='" + contractorcodescc + '\'' + ", supvloctcode='" + supvloctcode + '\'' + ", opuserid='" + opuserid + '\'' + ", senderid='" + senderid + '\'' + ", receiverid='" + receiverid + '\'' + ", version='" + version + '\'' + ", children=" + children + ", StationPersonName='" + StationPersonName + '\'' + '}';
    }
}
