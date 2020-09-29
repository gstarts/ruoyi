package com.ruoyi.stations_management.stock.domain;

import com.ruoyi.stations_management.enterprise.domain.SEnterpriseInfo;
import com.ruoyi.stations_management.waybill.domain.CustomsClearance;
import com.ruoyi.stations_management.waybill.domain.WaybillBody;
import com.ruoyi.stations_management.waybill.domain.WaybillHead;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 进出场货物对象 s_goods_info
 *
 * @author qishuai
 * @date 2020-04-14
 */
@ApiModel("进出场货物对象")
public class SGoodsInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 车牌号
     */
    @ApiModelProperty("车牌号")
    @Excel(name = "车牌号")
    private String gVeLicense;

    /**
     * 电子车牌号
     */
    @ApiModelProperty("电子车牌号")
    @Excel(name = "电子车牌号")
    private String gWaLicense;

    /**
     * 集装箱号
     */
    @ApiModelProperty("集装箱号")
    @Excel(name = "集装箱号")
    private String gContaNo;

    /**
     * 核放单号
     */
    @ApiModelProperty("核放单号")
    @Excel(name = "核放单号")
    private String gWaybillNo;

    /**
     * 通关单号
     */
    @ApiModelProperty("通关单号")
    @Excel(name = "通关单号")
    private String gCustomsNum;

    /**
     * 通关单批次号
     */
    @ApiModelProperty("通关单批次号")
    @Excel(name = "通关单批次号")
    private String gCustomsBatchNum;

    /**
     * 货物名称
     */
    @ApiModelProperty("货物名称")
    @Excel(name = "货物名称")
    private String gName;

    /**
     * 批次号
     */
    @ApiModelProperty("批次号")
    @Excel(name = "批次号")
    private String gBatchNo;

    /**
     * 提运单号
     */
    @ApiModelProperty("提运单号")
    @Excel(name = "提运单号")
    private String gDeliveryNo;

    /**
     * 货物单位
     */
    @ApiModelProperty("货物单位")
    @Excel(name = "货物单位")
    private String gUnit;

    /**
     * 货物重量
     */
    @ApiModelProperty("货物重量")
    @Excel(name = "货物重量")
    private Long gWeight;

    /**
     * 货物体积
     */
    @ApiModelProperty("货物体积")
    @Excel(name = "货物体积")
    private String gVolume;

    /**
     * 货物数量
     */
    @ApiModelProperty("货物数量")
    @Excel(name = "货物数量")
    private Long gNumber;

    /**
     * 货物所属仓库
     */
    @ApiModelProperty("货物所属仓库")
    @Excel(name = "货物所属仓库")
    private Long gWarehouseId;

    /**
     * 货物状态（1、入库；2、出库）
     */
    @ApiModelProperty("货物状态（1、入库；2、出库）")
    @Excel(name = "货物状态", readConverterExp = "1=、入库；2、出库")
    private String gIEStatus;

    /**
     * 记录完成情况：0、未完成，1、处理中，2、已完成
     */
    @ApiModelProperty("记录完成情况：0、未完成，1、处理中，2、已完成")
    @Excel(name = "记录完成情况：0、未完成，1、处理中，2、已完成")
    private String gStatus;

    /**
     * 运货车辆进场记录ID
     */
    @ApiModelProperty("运货车辆进场记录ID")
    @Excel(name = "运货车辆进场记录ID")
    private String gILogId;

    /**
     * 运货车辆出场记录ID
     */
    @ApiModelProperty("运货车辆出厂记录ID")
    @Excel(name = "运货车辆出场记录ID")
    private String gELogId;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @Excel(name = "备注")
    private String gRemarks;

    /**
     * 系统：版本号
     */
    @ApiModelProperty("系统:版本号")
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
     * 货物类型
     */
    @ApiModelProperty("货物类型")
    private String sgoodsType;

    /**
     * 出库
     */
    @ApiModelProperty("出库")
    private List<WaybillBody> listBody;

    /**
     * 标识
     */
    @ApiModelProperty("标识")
    private String flag;

    /**
     * 通关单新增
     */
    @ApiModelProperty("通关单新增")
    private CustomsClearance customsClearance;

    /**
     * 所属公司对象
     */
    @ApiModelProperty("所属公司对象")
    private SEnterpriseInfo enterpriseInfo;

    /**
     * 所属公司
     */
    @ApiModelProperty("所属公司")
    private String g_corporation;

    /**
     * 是否删除状态
     */
    @ApiModelProperty("是否删除状态")
    @Excel(name = "是否删除状态")
    private Long del;

    public String getSgoodsType() {
        return sgoodsType;
    }

    public void setSgoodsType(String sgoodsType) {
        this.sgoodsType = sgoodsType;
    }

    public String getG_corporation() {
        return g_corporation;
    }

    public void setG_corporation(String g_corporation) {
        this.g_corporation = g_corporation;
    }


    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<WaybillBody> getListBody() {
        return listBody;
    }

    public void setListBody(List<WaybillBody> listBody) {
        this.listBody = listBody;
    }


    public CustomsClearance getCustomsClearance() {
        return customsClearance;
    }

    public void setCustomsClearance(CustomsClearance customsClearance) {
        this.customsClearance = customsClearance;
    }

    public SEnterpriseInfo getEnterpriseInfo() {
        return enterpriseInfo;
    }

    public void setEnterpriseInfo(SEnterpriseInfo enterpriseInfo) {
        this.enterpriseInfo = enterpriseInfo;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setgVeLicense(String gVeLicense) {
        this.gVeLicense = gVeLicense;
    }

    public String getgVeLicense() {
        return gVeLicense;
    }

    public void setgWaLicense(String gWaLicense) {
        this.gWaLicense = gWaLicense;
    }

    public String getgWaLicense() {
        return gWaLicense;
    }

    public void setgContaNo(String gContaNo) {
        this.gContaNo = gContaNo;
    }

    public String getgContaNo() {
        return gContaNo;
    }

    public void setgWaybillNo(String gWaybillNo) {
        this.gWaybillNo = gWaybillNo;
    }

    public String getgWaybillNo() {
        return gWaybillNo;
    }

    public void setgCustomsNum(String gCustomsNum) {
        this.gCustomsNum = gCustomsNum;
    }

    public String getgCustomsNum() {
        return gCustomsNum;
    }

    public void setgCustomsBatchNum(String gCustomsBatchNum) {
        this.gCustomsBatchNum = gCustomsBatchNum;
    }

    public String getgCustomsBatchNum() {
        return gCustomsBatchNum;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgName() {
        return gName;
    }

    public void setgBatchNo(String gBatchNo) {
        this.gBatchNo = gBatchNo;
    }

    public String getgBatchNo() {
        return gBatchNo;
    }

    public void setgDeliveryNo(String gDeliveryNo) {
        this.gDeliveryNo = gDeliveryNo;
    }

    public String getgDeliveryNo() {
        return gDeliveryNo;
    }

    public void setgUnit(String gUnit) {
        this.gUnit = gUnit;
    }

    public String getgUnit() {
        return gUnit;
    }

    public void setgWeight(Long gWeight) {
        this.gWeight = gWeight;
    }

    public Long getgWeight() {
        return gWeight;
    }

    public void setgVolume(String gVolume) {
        this.gVolume = gVolume;
    }

    public String getgVolume() {
        return gVolume;
    }

    public void setgNumber(Long gNumber) {
        this.gNumber = gNumber;
    }

    public Long getgNumber() {
        return gNumber;
    }

    public void setgWarehouseId(Long gWarehouseId) {
        this.gWarehouseId = gWarehouseId;
    }

    public Long getgWarehouseId() {
        return gWarehouseId;
    }

    public void setgIEStatus(String gIEStatus) {
        this.gIEStatus = gIEStatus;
    }

    public String getgIEStatus() {
        return gIEStatus;
    }

    public void setgStatus(String gStatus) {
        this.gStatus = gStatus;
    }

    public String getgStatus() {
        return gStatus;
    }

    public void setgILogId(String gILogId) {
        this.gILogId = gILogId;
    }

    public String getgILogId() {
        return gILogId;
    }

    public void setgELogId(String gELogId) {
        this.gELogId = gELogId;
    }

    public String getgELogId() {
        return gELogId;
    }

    public void setgRemarks(String gRemarks) {
        this.gRemarks = gRemarks;
    }

    public String getgRemarks() {
        return gRemarks;
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

    public void setDel(Long del) {
        this.del = del;
    }

    public Long getDel() {
        return del;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("gVeLicense", getgVeLicense()).append("gWaLicense", getgWaLicense()).append("gContaNo", getgContaNo()).append("gWaybillNo", getgWaybillNo()).append("gCustomsNum", getgCustomsNum()).append("gCustomsBatchNum", getgCustomsBatchNum()).append("gName", getgName()).append("gBatchNo", getgBatchNo()).append("gDeliveryNo", getgDeliveryNo()).append("gUnit", getgUnit()).append("gWeight", getgWeight()).append("gVolume", getgVolume()).append("gNumber", getgNumber()).append("gWarehouseId", getgWarehouseId()).append("gIEStatus", getgIEStatus()).append("gStatus", getgStatus()).append("gILogId", getgILogId()).append("gELogId", getgELogId()).append("gRemarks", getgRemarks()).append("version", getVersion()).append("crtime", getCrtime()).append("cruser", getCruser()).append("crusername", getCrusername()).append("del", getDel()).append("g_corporation", getG_corporation()).append("sgoodsType", getSgoodsType()).toString();
    }
}
