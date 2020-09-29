package com.ruoyi.stations_management.declare.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 动物体对象 i_animals_body
 *
 * @author qishuai
 * @date 2020-04-07
 */
@ApiModel("动物体对象")
public class AnimalsBody extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 外键
     */
    @ApiModelProperty("外键")
    private Long headId;

    /**
     * 商品类别01：进口肉类02：进口冰鲜水产品03：进境食用水生动物04：进境水果05：进境植物种苗06：进境粮食07：进境原木08：进境宠物
     */
    @ApiModelProperty("商品类别01")
    @Excel(name = "商品类别")
    private String goodsclassify;

    /**
     * 商品子类01001：猪肉01002：猪副产品01003：羊肉及副产品01004：牛肉及副产品01005：禽肉及副产品01006：其他肉类
     */
    @ApiModelProperty("商品子类01001")
    @Excel(name = "商品子类")
    private String goodssubclass;

    /**
     * 商品编号hs编码
     */
    @ApiModelProperty("商品编号hs编码")
    @Excel(name = "商品编号hs编码")
    private String goodscode;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    @Excel(name = "商品名称")
    private String goodsname;

    /**
     * 规格型号
     */
    @ApiModelProperty("规格型号")
    @Excel(name = "规格型号")
    private String goodsmodel;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    @Excel(name = "数量")
    private String quantity;

    /**
     * 单位kg（固定）
     */
    @ApiModelProperty("单位kg")
    @Excel(name = "单位kg")
    private String unit;

    /**
     * 集装箱号
     */
    @ApiModelProperty("集装箱号")
    @Excel(name = "集装箱号")
    private String contaid;

    /**
     * 进场时间yyyy-mm-dd hh:mm:ss
     */
    @ApiModelProperty("进场时间")
    @Excel(name = "进场时间yyyy-mm-dd hh:mm:ss")
    private String entrancedate;

    /**
     * 数据处理标识a:增加；m:修改；d:删除（全量数据申报报文默认写a）
     */
    @ApiModelProperty("数据处理标识")
    @Excel(name = "数据处理标识")
    private String datadealflag;

    /**
     * 商品对应的提单号,多个单号使用英文逗号分割
     */
    @ApiModelProperty("商品对应的提单号")
    @Excel(name = "商品对应的提单号,多个单号使用英文逗号分割")
    private String billno;

    /**
     * 报关单号，多个单号使用英文逗号分割
     */
    @ApiModelProperty("用户ID")
    @Excel(name = "报关单号，多个单号使用英文逗号分割")
    private String entryid;

    /**
     * 转关单号，多个单号使用英文逗号分割
     */
    @ApiModelProperty("转关单号")
    @Excel(name = "转关单号，多个单号使用英文逗号分割")
    private String preno;

    /**
     * 多式联运单号，多个单号使用英文逗号分割
     */
    @ApiModelProperty("多式联运单号")
    @Excel(name = "多式联运单号，多个单号使用英文逗号分割")
    private String mtapplyblno;

    /**
     * 系统：版本号
     */
    @ApiModelProperty("系统")
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
     * 是否删除状态
     */
    @ApiModelProperty("是否删除状态")
    @Excel(name = "是否删除状态")
    private Long del;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setHeadId(Long headId) {
        this.headId = headId;
    }

    public Long getHeadId() {
        return headId;
    }

    public void setGoodsclassify(String goodsclassify) {
        this.goodsclassify = goodsclassify;
    }

    public String getGoodsclassify() {
        return goodsclassify;
    }

    public void setGoodssubclass(String goodssubclass) {
        this.goodssubclass = goodssubclass;
    }

    public String getGoodssubclass() {
        return goodssubclass;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode;
    }

    public String getGoodscode() {
        return goodscode;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsmodel(String goodsmodel) {
        this.goodsmodel = goodsmodel;
    }

    public String getGoodsmodel() {
        return goodsmodel;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setContaid(String contaid) {
        this.contaid = contaid;
    }

    public String getContaid() {
        return contaid;
    }

    public void setEntrancedate(String entrancedate) {
        this.entrancedate = entrancedate;
    }

    public String getEntrancedate() {
        return entrancedate;
    }

    public void setDatadealflag(String datadealflag) {
        this.datadealflag = datadealflag;
    }

    public String getDatadealflag() {
        return datadealflag;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public String getBillno() {
        return billno;
    }

    public void setEntryid(String entryid) {
        this.entryid = entryid;
    }

    public String getEntryid() {
        return entryid;
    }

    public void setPreno(String preno) {
        this.preno = preno;
    }

    public String getPreno() {
        return preno;
    }

    public void setMtapplyblno(String mtapplyblno) {
        this.mtapplyblno = mtapplyblno;
    }

    public String getMtapplyblno() {
        return mtapplyblno;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("headId", getHeadId())
                .append("goodsclassify", getGoodsclassify())
                .append("goodssubclass", getGoodssubclass())
                .append("goodscode", getGoodscode())
                .append("goodsname", getGoodsname())
                .append("goodsmodel", getGoodsmodel())
                .append("quantity", getQuantity())
                .append("unit", getUnit())
                .append("contaid", getContaid())
                .append("entrancedate", getEntrancedate())
                .append("datadealflag", getDatadealflag())
                .append("billno", getBillno())
                .append("entryid", getEntryid())
                .append("preno", getPreno())
                .append("mtapplyblno", getMtapplyblno())
                .append("remark", getRemark())
                .append("version", getVersion())
                .append("crtime", getCrtime())
                .append("cruser", getCruser())
                .append("crusername", getCrusername())
                .append("del", getDel())
                .toString();
    }
}
