package com.ruoyi.stations_management.enterprise.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excels;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 企业资质管理对象 s_qualifications_info
 * 
 * @author qishuai
 * @date 2020-01-02
 */
@ApiModel("企业资质管理实体")
public class SQualificationsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long id;

    /** 企业信息备案表ID */
    @ApiModelProperty("企业信息备案表ID")
    @Excel(name = "企业信息备案表ID")
    private Long qEnterpriseInfoId;

    /** 公司账号 */
    @ApiModelProperty("公司账号")
    @Excel(name = "公司账号")
    private String qEnterpriseAccount;

    /** 资质名称 */
    @ApiModelProperty("资质名称")
    @Excel(name = "资质名称")
    private String qQualificationsNam;

    /** 资质编号 */
    @ApiModelProperty("资质编号")
    @Excel(name = "资质编号")
    private String qQualificationsNo;

    /** 证书编号 */
    @ApiModelProperty("证书编号")
    @Excel(name = "证书编号")
    private String qCertificateNo;

    /** 系统：版本号 */
    @ApiModelProperty("版本号")
    @Excel(name = "系统：版本号")
    private Long version;

    /** 创建时间 */
    @ApiModelProperty("创建时间")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
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

    /** 企业对象 */
    @ApiModelProperty("企业对象")
    @Excels({
            @Excel(name = "企业名称", targetAttr = "eName", type = Excel.Type.EXPORT)
    })
    private SEnterpriseInfo enterpriseInfo;


    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setqEnterpriseInfoId(Long qEnterpriseInfoId) 
    {
        this.qEnterpriseInfoId = qEnterpriseInfoId;
    }

    public Long getqEnterpriseInfoId() 
    {
        return qEnterpriseInfoId;
    }
    public void setqEnterpriseAccount(String qEnterpriseAccount) 
    {
        this.qEnterpriseAccount = qEnterpriseAccount;
    }

    public String getqEnterpriseAccount() 
    {
        return qEnterpriseAccount;
    }
    public void setqQualificationsNam(String qQualificationsNam) 
    {
        this.qQualificationsNam = qQualificationsNam;
    }

    public String getqQualificationsNam() 
    {
        return qQualificationsNam;
    }
    public void setqQualificationsNo(String qQualificationsNo) 
    {
        this.qQualificationsNo = qQualificationsNo;
    }

    public String getqQualificationsNo() 
    {
        return qQualificationsNo;
    }
    public void setqCertificateNo(String qCertificateNo) 
    {
        this.qCertificateNo = qCertificateNo;
    }

    public String getqCertificateNo() 
    {
        return qCertificateNo;
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

    public SEnterpriseInfo getEnterpriseInfo()
    {
        return enterpriseInfo;
    }

    public void setEnterpriseInfo(SEnterpriseInfo enterpriseInfo)
    {
        this.enterpriseInfo = enterpriseInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("qEnterpriseInfoId", getqEnterpriseInfoId())
            .append("qEnterpriseAccount", getqEnterpriseAccount())
            .append("qQualificationsNam", getqQualificationsNam())
            .append("qQualificationsNo", getqQualificationsNo())
            .append("qCertificateNo", getqCertificateNo())
            .append("version", getVersion())
            .append("crtime", getCrtime())
            .append("cruser", getCruser())
            .append("crusername", getCrusername())
            .append("del", getDel())
            .append("enterpriseInfo", getEnterpriseInfo())
            .toString();
    }
}
