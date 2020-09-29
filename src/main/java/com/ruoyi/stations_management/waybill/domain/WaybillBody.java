package com.ruoyi.stations_management.waybill.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 提运单申报对象 s_waybill_body
 *
 * @author qishuai
 * @date 2020-03-03
 */
@ApiModel("提运单申报对象")
public class WaybillBody extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty("ID")
    private Long id;

    /** 表体序号 */
    @ApiModelProperty("表体序号")
    private  int gno;

    /** $column.columnComment */
    @ApiModelProperty("headId")
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long headId;

    /** 绑定对象类型:C:集装箱、B:提单、T:转关单、VC:车辆海关编号、VN:车辆车牌 */
    @ApiModelProperty("绑定对象类型")
    @Excel(name = "绑定对象类型:C:集装箱、B:提单、T:转关单、VC:车辆海关编号、VN:车辆车牌")
    private String bindobjtype;

    /** 绑定对象ID:集装箱号/转关单号/车辆海关编号/车辆车牌时必填；进口时提单号必填，出口时提单号不必填 */
    @ApiModelProperty("绑定对象ID")
    @Excel(name = "绑定对象ID:集装箱号/转关单号/车辆海关编号/车辆车牌时必填；进口时提单号必填，出口时提单号不必填")
    private String bindobjid;

    /** 进出方向:I:进厂、E:出厂 */
    @ApiModelProperty("进出方向")
    @Excel(name = "进出方向:I:进厂、E:出厂")
    private String iedirection;

    /** 船名(海运时必填) */
    @ApiModelProperty("船名")
    @Excel(name = "船名(海运时必填)")
    private String transportid;

    /** 航次/货物运输批次号航次/货物运输批次号（海运时为航次号，公路时为货物运输批次号） */
    @ApiModelProperty("航次")
    @Excel(name = "航次/货物运输批次号航次/货物运输批次号", readConverterExp = "海=运时为航次号，公路时为货物运输批次号")
    private String voyageno;

    /** $column.columnComment */
    @ApiModelProperty("航次")
    @Excel(name = "航次/货物运输批次号航次/货物运输批次号", readConverterExp = "$column.readConverterExp()")
    private String rdcode;

    /** 提单类型（对象类型为提单时有效，1一程舱单，2二程舱单）（仅提单有用，必填） */
    @ApiModelProperty("提单类型")
    @Excel(name = "提单类型", readConverterExp = "对=象类型为提单时有效，1一程舱单，2二程舱单")
    private String billtype;

    /** 本次提货重量（仅提单有用，必填） */
    @ApiModelProperty("本次提货重量")
    @Excel(name = "本次提货重量", readConverterExp = "仅=提单有用，必填")
    private String goodswt;

    /** 集装箱号1 */
    @ApiModelProperty("集装箱号1")
    @Excel(name = "集装箱号1")
    private String contaid1;

    /** 集装箱号2 */
    @ApiModelProperty("集装箱号2")
    @Excel(name = "集装箱号2")
    private String contaid2;

    /** 安全智能锁号1 */
    @ApiModelProperty("安全智能锁号1")
    @Excel(name = "安全智能锁号1")
    private String esealid1;

    /** 安全智能锁号2 */
    @ApiModelProperty("安全智能锁号2")
    @Excel(name = "安全智能锁号2")
    private String esealid2;

    /** 实际运输重量 */
    @ApiModelProperty("实际运输重量")
    @Excel(name = "实际运输重量")
    private String outRealityWt;

    /** $column.columnComment */
    @ApiModelProperty("版本号")
    @Excel(name = "实际运输重量")
    private Long version;

    /** $column.columnComment */
    @ApiModelProperty("次数")
    @Excel(name = "实际运输重量", width = 30, dateFormat = "yyyy-MM-dd")
    private Date crtime;

    /** 创建人 */
    @ApiModelProperty("创建人")
    @Excel(name = "创建人")
    private String cruser;

    /** 创建人名称 */
    @ApiModelProperty("创建人名称")
    @Excel(name = "创建人名称")
    private String crusername;

    /** 是否删除状态 */
    @ApiModelProperty("是否删除状态")
    @Excel(name = "是否删除状态")
    private Long del;
    /**
     * 所属仓库id
     */
    @ApiModelProperty("所属仓库id")
    @Excel(name = "所属仓库id")
    private  Long warehouseId;
    /**
     * 货物名称
     */
    @ApiModelProperty("货物名称")
    @Excel(name = "货物名称")
    private String goodsName;
    /**
     * waybillHead
     */
    private WaybillHead waybillHead;

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public WaybillHead getWaybillHead() {
        return waybillHead;
    }

    public void setWaybillHead(WaybillHead waybillHead) {
        this.waybillHead = waybillHead;
    }

    public WaybillBody() {
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setHeadId(Long headId)
    {
        this.headId = headId;
    }

    public int getGno() {
        return gno;
    }

    public void setGno(int gno) {
        this.gno = gno;
    }

    public Long getHeadId()
    {
        return headId;
    }
    public void setBindobjtype(String bindobjtype)
    {
        this.bindobjtype = bindobjtype;
    }

    public String getBindobjtype()
    {
        return bindobjtype;
    }
    public void setBindobjid(String bindobjid)
    {
        this.bindobjid = bindobjid;
    }

    public String getBindobjid()
    {
        return bindobjid;
    }
    public void setIedirection(String iedirection)
    {
        this.iedirection = iedirection;
    }

    public String getIedirection()
    {
        return iedirection;
    }
    public void setTransportid(String transportid)
    {
        this.transportid = transportid;
    }

    public String getTransportid()
    {
        return transportid;
    }
    public void setVoyageno(String voyageno)
    {
        this.voyageno = voyageno;
    }

    public String getVoyageno()
    {
        return voyageno;
    }
    public void setRdcode(String rdcode)
    {
        this.rdcode = rdcode;
    }

    public String getRdcode()
    {
        return rdcode;
    }
    public void setBilltype(String billtype)
    {
        this.billtype = billtype;
    }

    public String getBilltype()
    {
        return billtype;
    }
    public void setGoodswt(String goodswt)
    {
        this.goodswt = goodswt;
    }

    public String getGoodswt()
    {
        return goodswt;
    }
    public void setContaid1(String contaid1)
    {
        this.contaid1 = contaid1;
    }

    public String getContaid1()
    {
        return contaid1;
    }
    public void setContaid2(String contaid2)
    {
        this.contaid2 = contaid2;
    }

    public String getContaid2()
    {
        return contaid2;
    }
    public void setEsealid1(String esealid1)
    {
        this.esealid1 = esealid1;
    }

    public String getEsealid1()
    {
        return esealid1;
    }
    public void setEsealid2(String esealid2)
    {
        this.esealid2 = esealid2;
    }

    public String getEsealid2()
    {
        return esealid2;
    }
    public void setOutRealityWt(String outRealityWt)
    {
        this.outRealityWt = outRealityWt;
    }

    public String getOutRealityWt()
    {
        return outRealityWt;
    }
    public void setVersion(Long version)
    {
        this.version = version;
    }

    public Long getVersion()
    {
        return version;
    }
    public void setCrtime(Date crtime)
    {
        this.crtime = crtime;
    }

    public Date getCrtime()
    {
        return crtime;
    }
    public void setCruser(String cruser)
    {
        this.cruser = cruser;
    }

    public String getCruser()
    {
        return cruser;
    }
    public void setCrusername(String crusername)
    {
        this.crusername = crusername;
    }

    public String getCrusername()
    {
        return crusername;
    }
    public void setDel(Long del)
    {
        this.del = del;
    }

    public Long getDel()
    {
        return del;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("headId", getHeadId())
                .append("bindobjtype", getBindobjtype())
                .append("bindobjid", getBindobjid())
                .append("iedirection", getIedirection())
                .append("transportid", getTransportid())
                .append("voyageno", getVoyageno())
                .append("rdcode", getRdcode())
                .append("billtype", getBilltype())
                .append("goodswt", getGoodswt())
                .append("contaid1", getContaid1())
                .append("contaid2", getContaid2())
                .append("esealid1", getEsealid1())
                .append("esealid2", getEsealid2())
                .append("remark", getRemark())
                .append("outRealityWt", getOutRealityWt())
                .append("version", getVersion())
                .append("crtime", getCrtime())
                .append("cruser", getCruser())
                .append("crusername", getCrusername())
                .append("del", getDel())
                .toString();
    }
}
