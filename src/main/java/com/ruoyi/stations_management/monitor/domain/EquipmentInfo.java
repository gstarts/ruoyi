package com.ruoyi.stations_management.monitor.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 设备
 * 对象 e_equipment_info
 *
 * @author qishuai
 * @date 2020-03-26
 */
@ApiModel("设备对象实体")
public class EquipmentInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 通道id
     */
    @ApiModelProperty("通道id")
    @Excel(name = "通道id")
    private Long chnlId;
    /**
     * 场站id
     */
    @ApiModelProperty("场站id")
    private Long stationId;
    /**
     * 通道名称
     */
    @ApiModelProperty("通道名称")
    private String chnlName;

    /**
     * 设备类型
     * 1：车牌识别
     * 2：电子车牌
     * 3：集装箱识别
     * 4：称重采集
     * 5：IC卡识别
     * 6：电子栏杆识别
     * 7：地感线圈识别
     * 8：LED引导屏
     * 9：LED指示屏
     * 10：防跟车系统
     */
    @ApiModelProperty("设备类型")
    @Excel(name = "设备类型 1：车牌识别 2：电子车牌 3：集装箱识别 4：称重采集 5：IC卡识别 6：电子栏杆识别 7：地感线圈识别 8：LED引导屏 9：LED指示屏 10：防跟车系统")
    private String equipmentType;

    /**
     * 设备地址
     */
    @ApiModelProperty("设备地址")
    @Excel(name = "设备地址")
    private String equipmentAddr;

    /**
     * 设备状态   0：正常、1：异常、2：启动中
     */
    @ApiModelProperty("设备状态")
    @Excel(name = "设备状态   0：正常、1：异常、2：启动中")
    private String equipmentStatus;

    /**
     * 设备参数
     */
    @ApiModelProperty("设备参数")
    @Excel(name = "设备参数")
    private String equipmentParm;

    /**
     * 设备品牌
     */
    @ApiModelProperty("设备品牌")
    @Excel(name = "设备品牌")
    private String equipmentBrand;

    /**
     * 设备值
     */
    @ApiModelProperty("设备值")
    @Excel(name = "设备值")
    private String equipmentValue1;

    /**
     * 设备值
     */
    @ApiModelProperty("设备值")
    @Excel(name = "设备值")
    private String equipmentValue2;

    /**
     * 串口模拟器等待时间
     */
    @ApiModelProperty("串口模拟器等待时间")
    @Excel(name = "串口模拟器输入口")
    private String moxai;
    /**
     * 串口模拟器等待时间
     */
    @ApiModelProperty("串口模拟器等待时间")
    @Excel(name = "串口模拟器输入口")
    private String moxao;
    /**
     * 串口模拟器等待时间
     */
    @ApiModelProperty("串口模拟器等待时间")
    @Excel(name = "串口模拟器等待时间")
    private String dwtimeout;

    /**
     * 串口模拟器密码
     */
    @ApiModelProperty("串口模拟器密码")
    @Excel(name = "串口模拟器密码")
    private String password;

    /**
     * 电子车牌HOSTIP地址
     */
    @ApiModelProperty("电子车牌HOSTIP地址")
    @Excel(name = "电子车牌HOSTIP地址")
    private String hostip;

    /**
     * 电子车牌HOST端口号
     */
    @ApiModelProperty("电子车牌HOST端口号")
    @Excel(name = "电子车牌HOST端口号")
    private String hostport;

    /**
     * 地秤参数
     */
    @ApiModelProperty("地秤参数")
    @Excel(name = "地秤参数")
    private String parity;

    /**
     * 地秤等待时间
     */
    @ApiModelProperty("地秤等待时间")
    @Excel(name = "地秤等待时间")
    private String wtwaittime;

    /**
     * 摄像头账号
     */
    @ApiModelProperty("摄像头账号")
    @Excel(name = "摄像头账号")
    private String veuser;

    /**
     * 摄像头密码
     */
    @ApiModelProperty("摄像头密码")
    @Excel(name = "摄像头密码")
    private String vepwd;

    /**
     * 摄像头等待时间
     */
    @ApiModelProperty("摄像头等待时间")
    @Excel(name = "摄像头等待时间")
    private String vetimeout;

    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    @Excel(name = "图片地址")
    private String veimagedir;

    public String getMoxai() {
        return moxai;
    }

    public void setMoxai(String moxai) {
        this.moxai = moxai;
    }

    public String getMoxao() {
        return moxao;
    }

    public void setMoxao(String moxao) {
        this.moxao = moxao;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getDwtimeout() {
        return dwtimeout;
    }

    public void setDwtimeout(String dwtimeout) {
        this.dwtimeout = dwtimeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostip() {
        return hostip;
    }

    public void setHostip(String hostip) {
        this.hostip = hostip;
    }

    public String getHostport() {
        return hostport;
    }

    public void setHostport(String hostport) {
        this.hostport = hostport;
    }

    public String getParity() {
        return parity;
    }

    public void setParity(String parity) {
        this.parity = parity;
    }

    public String getWtwaittime() {
        return wtwaittime;
    }

    public void setWtwaittime(String wtwaittime) {
        this.wtwaittime = wtwaittime;
    }

    public String getVeuser() {
        return veuser;
    }

    public void setVeuser(String veuser) {
        this.veuser = veuser;
    }

    public String getVepwd() {
        return vepwd;
    }

    public void setVepwd(String vepwd) {
        this.vepwd = vepwd;
    }

    public String getVetimeout() {
        return vetimeout;
    }

    public void setVetimeout(String vetimeout) {
        this.vetimeout = vetimeout;
    }

    public String getVeimagedir() {
        return veimagedir;
    }

    public void setVeimagedir(String veimagedir) {
        this.veimagedir = veimagedir;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getChnlName() {
        return chnlName;
    }

    public void setChnlName(String chnlName) {
        this.chnlName = chnlName;
    }

    public void setChnlId(Long chnlId) {
        this.chnlId = chnlId;
    }

    public Long getChnlId() {
        return chnlId;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentAddr(String equipmentAddr) {
        this.equipmentAddr = equipmentAddr;
    }

    public String getEquipmentAddr() {
        return equipmentAddr;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentParm(String equipmentParm) {
        this.equipmentParm = equipmentParm;
    }

    public String getEquipmentParm() {
        return equipmentParm;
    }

    public void setEquipmentBrand(String equipmentBrand) {
        this.equipmentBrand = equipmentBrand;
    }

    public String getEquipmentBrand() {
        return equipmentBrand;
    }

    public void setEquipmentValue1(String equipmentValue1) {
        this.equipmentValue1 = equipmentValue1;
    }

    public String getEquipmentValue1() {
        return equipmentValue1;
    }

    public void setEquipmentValue2(String equipmentValue2) {
        this.equipmentValue2 = equipmentValue2;
    }

    public String getEquipmentValue2() {
        return equipmentValue2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("chnlId", getChnlId())
                .append("equipmentType", getEquipmentType())
                .append("equipmentAddr", getEquipmentAddr())
                .append("equipmentStatus", getEquipmentStatus())
                .append("equipmentParm", getEquipmentParm())
                .append("equipmentBrand", getEquipmentBrand())
                .append("equipmentValue1", getEquipmentValue1())
                .append("equipmentValue2", getEquipmentValue2())
                .toString();
    }
}
