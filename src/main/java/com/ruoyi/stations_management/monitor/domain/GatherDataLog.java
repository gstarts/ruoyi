package com.ruoyi.stations_management.monitor.domain;

import com.ruoyi.stations_management.montroller.domain.IcInfo;
import com.ruoyi.stations_management.montroller.domain.VeRfid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;
import java.util.List;

/**
 * 数据监控对象 g_gatherdata_log
 *
 * @author qishuai
 * @date 2020-03-30
 */
@ApiModel("数据监控对象")
public class GatherDataLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报文序列号 */
    @ApiModelProperty("报文序列号")
    private String sessionId;

    /** 场站代码 */
    @ApiModelProperty("场站代码")
    @Excel(name = "场站代码")
    private String areaId;

    /** 卡口代码 */
    @ApiModelProperty("卡口代码")
    @Excel(name = "卡口代码")
    private String chnlNo;

    /** 通道名称 */
    @ApiModelProperty("通道名称")
    private String chnlName;

    /** 进出标志 */
    @ApiModelProperty("进出标志")
    @Excel(name = "进出标志")
    private String iEFlag;

    /** 采集标志 */
    @ApiModelProperty("采集标志")
    @Excel(name = "采集标志")
    private String getherMode;

    /** 驾驶员编号 */
    @ApiModelProperty("驾驶员编号")
    @Excel(name = "驾驶员编号")
    private String drCustomsNo;

    /** 车辆海关编号 */
    @ApiModelProperty("车辆海关编号")
    @Excel(name = "车辆海关编号")
    private String veCustomsNo;

    /** 车牌识别车牌号 */
    @ApiModelProperty("车牌识别车牌号")
    @Excel(name = "车牌识别车牌号")
    private String veLicenseNo;

    /** 箱数 */
    @ApiModelProperty("箱数")
    @Excel(name = "箱数")
    private String contaId;

    /** 电子关锁号(安全智能锁号) */
    @ApiModelProperty("电子关锁号")
    @Excel(name = "电子关锁号(安全智能锁号)")
    private String esealId;

    /** 地磅称重 */
    @ApiModelProperty("地磅称重")
    @Excel(name = "地磅称重")
    private String grossWt;

    /** 操作关员 */
    @ApiModelProperty("操作关员")
    @Excel(name = "操作关员")
    private String operatorId;

    /** 操作时间 */
    @ApiModelProperty("操作时间")
    @Excel(name = "操作时间")
    private String operateTime;

    /** 验放列表类型 */
    @ApiModelProperty("验放列表类型")
    @Excel(name = "验放列表类型")
    private String rellistType;

    /** 验放列表id类型 */
    @ApiModelProperty("验放列表id类型")
    @Excel(name = "验放列表id类型")
    private String rellistIdType;

    /** 验放列表id */
    @ApiModelProperty("验放列表id")
    @Excel(name = "验放列表id")
    private String rellistId;

    /** 后台核放时间 */
    @ApiModelProperty("后台核放时间")
    @Excel(name = "后台核放时间")
    private String feedbackTime;

    /** 最终处理结果：y为放行，n为报警，m为待人工确认 */
    @ApiModelProperty("最终处理结果")
    @Excel(name = "最终处理结果：y为放行，n为报警，m为待人工确认")
    private String checkResult;

    /** 后台对前端的敏感设备操作 */
    @ApiModelProperty("后台对前端的敏感设备操作")
    @Excel(name = "后台对前端的敏感设备操作")
    private String instruction;

    /** 海关业务方面对返回结果代码，返回给关员 */
    @ApiModelProperty("海关业务方面对返回结果代码")
    @Excel(name = "海关业务方面对返回结果代码，返回给关员")
    private String procErrorCode;

    /** 业务逻辑错误解释 */
    @ApiModelProperty("业务逻辑错误解释")
    @Excel(name = "业务逻辑错误解释")
    private String procErrorDescription;

    /** 技术错误码 */
    @ApiModelProperty("技术错误码")
    @Excel(name = "技术错误码")
    private String techErrorCode;

    /** 技术错误解释 */
    @ApiModelProperty("技术错误解释")
    @Excel(name = "技术错误解释")
    private String techErrorDescription;

    /** 铅封号 */
    @ApiModelProperty("铅封号")
    @Excel(name = "铅封号")
    private String sealId;

    /** 单证总件数 */
    @ApiModelProperty("单证总件数")
    @Excel(name = "单证总件数")
    private String packNo;

    /** 舱单总件数 */
    @ApiModelProperty("舱单总件数")
    @Excel(name = "舱单总件数")
    private String declPack;

    /** 舱单货物总重量 */
    @ApiModelProperty("舱单货物总重量")
    @Excel(name = "舱单货物总重量")
    private String declGoodsWeight;

    /** 核放结果详细信息（布控、地磅等) */
    @ApiModelProperty("核放结果详细信息")
    @Excel(name = "核放结果详细信息", readConverterExp = "核放结果详细信息（布控、地磅等)")
    private String opHint;

    /** led操作提示 */
    @ApiModelProperty("led操作提示")
    @Excel(name = "led操作提示")
    private String ledHint;

    /** 扩展内容 */
    @ApiModelProperty("扩展内容")
    @Excel(name = "扩展内容")
    private String extendedContent;

    /** 进出时间 */
    @ApiModelProperty("进出时间")
    @Excel(name = "进出时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date inoutTime;

    private String x81Command;

    private  String x82Command;

    /** 采集到所有数据0:采集未发送81,1:81发送完成未接到82回复，2:接收到82回复未执行，3执行完成 */
    @ApiModelProperty("采集到所有数据0")
    @Excel(name = "采集到所有数据0:采集未发送81,1:81发送完成未接到82回复，2:接收到82回复未执行，3执行完成")
    private String gatheralldataFlg;
    /**
     * 照片
     */
    @ApiModelProperty("照片")
    private List<Photo> photoList;

    /**
     * 电子车牌实体类
     */
    private VeRfid rfid;

    /** ic卡实体类 */
    private IcInfo Info;

    /** ic卡号 */
    private String icNo;

    /** 传回后台电子车牌 */
    private String No;

    // 卡口类型标识
    private  String rpbType;


    public String getRpbType() {
        return rpbType;
    }

    public void setRpbType(String rpbType) {
        this.rpbType = rpbType;
    }


    public String getX81Command() {
        return x81Command;
    }

    public void setX81Command(String x81Command) {
        this.x81Command = x81Command;
    }

    public String getX82Command() {
        return x82Command;
    }

    public void setX82Command(String x82Command) {
        this.x82Command = x82Command;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getIcNo() {
        return icNo;
    }

    public void setIcNo(String icNo) {
        this.icNo = icNo;
    }

    public VeRfid getRfid() {
        return rfid;
    }

    public void setRfid(VeRfid rfid) {
        this.rfid = rfid;
    }

    public IcInfo getInfo() {
        return Info;
    }

    public void setInfo(IcInfo info) {
        Info = info;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public void setSessionId(String sessionId)
    {
        this.sessionId = sessionId;
    }

    public String getSessionId()
    {
        return sessionId;
    }
    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getAreaId()
    {
        return areaId;
    }
    public void setChnlNo(String chnlNo)
    {
        this.chnlNo = chnlNo;
    }

    public String getChnlNo()
    {
        return chnlNo;
    }
    public void setiEFlag(String iEFlag)
    {
        this.iEFlag = iEFlag;
    }

    public String getChnlName() {
        return chnlName;
    }
    public void setChnlName(String chnlName) {
        this.chnlName = chnlName;
    }
    public String getiEFlag()
    {
        return iEFlag;
    }
    public void setGetherMode(String getherMode)
    {
        this.getherMode = getherMode;
    }

    public String getGetherMode()
    {
        return getherMode;
    }
    public void setDrCustomsNo(String drCustomsNo)
    {
        this.drCustomsNo = drCustomsNo;
    }

    public String getDrCustomsNo()
    {
        return drCustomsNo;
    }
    public void setVeCustomsNo(String veCustomsNo)
    {
        this.veCustomsNo = veCustomsNo;
    }

    public String getVeCustomsNo()
    {
        return veCustomsNo;
    }
    public void setVeLicenseNo(String veLicenseNo)
    {
        this.veLicenseNo = veLicenseNo;
    }

    public String getVeLicenseNo()
    {
        return veLicenseNo;
    }
    public void setContaId(String contaId)
    {
        this.contaId = contaId;
    }

    public String getContaId()
    {
        return contaId;
    }
    public void setEsealId(String esealId)
    {
        this.esealId = esealId;
    }

    public String getEsealId()
    {
        return esealId;
    }
    public void setGrossWt(String grossWt)
    {
        this.grossWt = grossWt;
    }

    public String getGrossWt()
    {
        return grossWt;
    }
    public void setOperatorId(String operatorId)
    {
        this.operatorId = operatorId;
    }

    public String getOperatorId()
    {
        return operatorId;
    }
    public void setOperateTime(String operateTime)
    {
        this.operateTime = operateTime;
    }

    public String getOperateTime()
    {
        return operateTime;
    }
    public void setRellistType(String rellistType)
    {
        this.rellistType = rellistType;
    }

    public String getRellistType()
    {
        return rellistType;
    }
    public void setRellistIdType(String rellistIdType)
    {
        this.rellistIdType = rellistIdType;
    }

    public String getRellistIdType()
    {
        return rellistIdType;
    }
    public void setRellistId(String rellistId)
    {
        this.rellistId = rellistId;
    }

    public String getRellistId()
    {
        return rellistId;
    }
    public void setFeedbackTime(String feedbackTime)
    {
        this.feedbackTime = feedbackTime;
    }

    public String getFeedbackTime()
    {
        return feedbackTime;
    }
    public void setCheckResult(String checkResult)
    {
        this.checkResult = checkResult;
    }

    public String getCheckResult()
    {
        return checkResult;
    }
    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    public String getInstruction()
    {
        return instruction;
    }
    public void setProcErrorCode(String procErrorCode)
    {
        this.procErrorCode = procErrorCode;
    }

    public String getProcErrorCode()
    {
        return procErrorCode;
    }
    public void setProcErrorDescription(String procErrorDescription)
    {
        this.procErrorDescription = procErrorDescription;
    }

    public String getProcErrorDescription()
    {
        return procErrorDescription;
    }
    public void setTechErrorCode(String techErrorCode)
    {
        this.techErrorCode = techErrorCode;
    }

    public String getTechErrorCode()
    {
        return techErrorCode;
    }
    public void setTechErrorDescription(String techErrorDescription)
    {
        this.techErrorDescription = techErrorDescription;
    }

    public String getTechErrorDescription()
    {
        return techErrorDescription;
    }
    public void setSealId(String sealId)
    {
        this.sealId = sealId;
    }

    public String getSealId()
    {
        return sealId;
    }
    public void setPackNo(String packNo)
    {
        this.packNo = packNo;
    }

    public String getPackNo()
    {
        return packNo;
    }
    public void setDeclPack(String declPack)
    {
        this.declPack = declPack;
    }

    public String getDeclPack()
    {
        return declPack;
    }
    public void setDeclGoodsWeight(String declGoodsWeight)
    {
        this.declGoodsWeight = declGoodsWeight;
    }

    public String getDeclGoodsWeight()
    {
        return declGoodsWeight;
    }
    public void setOpHint(String opHint)
    {
        this.opHint = opHint;
    }

    public String getOpHint()
    {
        return opHint;
    }
    public void setLedHint(String ledHint)
    {
        this.ledHint = ledHint;
    }

    public String getLedHint()
    {
        return ledHint;
    }
    public void setExtendedContent(String extendedContent)
    {
        this.extendedContent = extendedContent;
    }

    public void setInoutTime(Date inoutTime)
    {
        this.inoutTime = inoutTime;
    }

    public Date getInoutTime()
    {
        return inoutTime;
    }
    public void setGatheralldataFlg(String gatheralldataFlg)
    {
        this.gatheralldataFlg = gatheralldataFlg;
    }

    public String getGatheralldataFlg()
    {
        return gatheralldataFlg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sessionId", getSessionId())
            .append("areaId", getAreaId())
            .append("chnlNo", getChnlNo())
            .append("iEFlag", getiEFlag())
            .append("getherMode", getGetherMode())
            .append("drCustomsNo", getDrCustomsNo())
            .append("veCustomsNo", getVeCustomsNo())
            .append("veLicenseNo", getVeLicenseNo())
            .append("contaId", getContaId())
            .append("esealId", getEsealId())
            .append("grossWt", getGrossWt())
            .append("operatorId", getOperatorId())
            .append("operateTime", getOperateTime())
            .append("rellistType", getRellistType())
            .append("rellistIdType", getRellistIdType())
            .append("rellistId", getRellistId())
            .append("feedbackTime", getFeedbackTime())
            .append("checkResult", getCheckResult())
            .append("instruction", getInstruction())
            .append("procErrorCode", getProcErrorCode())
            .append("procErrorDescription", getProcErrorDescription())
            .append("techErrorCode", getTechErrorCode())
            .append("techErrorDescription", getTechErrorDescription())
            .append("sealId", getSealId())
            .append("packNo", getPackNo())
            .append("declPack", getDeclPack())
            .append("declGoodsWeight", getDeclGoodsWeight())
            .append("opHint", getOpHint())
            .append("ledHint", getLedHint())
            .append("inoutTime", getInoutTime())
            .append("gatheralldataFlg", getGatheralldataFlg())
            .toString();
    }
}
