package com.ruoyi.stations_management.enterprise.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 企业信息备案对象 s_enterprise_info
 * 
 * @author qishuai
 * @date 2020-01-02
 */
@ApiModel("企业备案实体")
public class SEnterpriseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("企业备案实体")
    private Long id;

    /** 公司名称 */
    @ApiModelProperty("公司名称")
    @Excel(name = "公司名称")
        private String eName;

    /** 公司性质（1、国企；2、私企；3、合同） */
    @ApiModelProperty("公司性质")
    @Excel(name = "公司性质", readConverterExp = "1=、国企；2、私企；3、合同")
    private String eType;

    /** 公司英文名称 */
    @ApiModelProperty("公司英文名称")
    @Excel(name = "公司英文名称")
    private String eEname;

    /** 公司简称 */
    @ApiModelProperty("用户ID")
    @Excel(name = "公司简称")
    private String eAbbreviation;

    /** 公司地址 */
    @ApiModelProperty("公司地址")
    @Excel(name = "公司地址")
    private String eAddress;

    /** 法人 */
    @ApiModelProperty("法人")
    @Excel(name = "法人")
    private String eLegalPerson;

    /** 法人电话 */
    @ApiModelProperty("法人电话")
    private String eLegalPersonPhone;

    /** 业务联系人 */
    @ApiModelProperty("业务联系人")
    private String eBusinessPerson;

    /** 业务联系人电话 */
    @ApiModelProperty("业务联系人电话")
    private String eBusinessPersonPhone;

    /** 注册时间 */
    @ApiModelProperty("注册时间")
    private Date eRegisterTime;

    /** 营业范围 */
    @ApiModelProperty("营业范围")
    private String eBusinessScope;

    /** 海关编号 */
    @ApiModelProperty("海关编号")
    private String eCustomsNo;

    /** 组织编号 */
    @ApiModelProperty("组织编号")
    private String eOrganizationNo;

    /** 是否会员 */
    @ApiModelProperty("是否会员")
    private String eIsMember;

    /** 是否货主 */
    @ApiModelProperty("是否货主")
    private String eIsCargoOwner;

    /** 是否货代 */
    @ApiModelProperty("用户ID")
    private String eIsForwarder;

    /** 是否拖车 */
    @ApiModelProperty("是否拖车")
    private String eIsTrailer;

    /** 备注信息 */
    @ApiModelProperty("备注信息")
    private String eRemarks;

    /** 系统：版本号 */
    @ApiModelProperty("版本号")
    private Long version;

    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date crtime;

    /** 创建人 */
    @ApiModelProperty("创建人")
    private String cruser;

    /** 创建人名称 */
    @ApiModelProperty("创建人名称")
    private String crusername;

    /** 是否删除状态 */
    @ApiModelProperty("是否删除状态")
    private Long del;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void seteName(String eName) 
    {
        this.eName = eName;
    }

    public String geteName() 
    {
        return eName;
    }
    public void seteType(String eType) 
    {
        this.eType = eType;
    }

    public String geteType() 
    {
        return eType;
    }
    public void seteEname(String eEname) 
    {
        this.eEname = eEname;
    }

    public String geteEname() 
    {
        return eEname;
    }
    public void seteAbbreviation(String eAbbreviation) 
    {
        this.eAbbreviation = eAbbreviation;
    }

    public String geteAbbreviation() 
    {
        return eAbbreviation;
    }
    public void seteAddress(String eAddress) 
    {
        this.eAddress = eAddress;
    }

    public String geteAddress() 
    {
        return eAddress;
    }
    public void seteLegalPerson(String eLegalPerson) 
    {
        this.eLegalPerson = eLegalPerson;
    }

    public String geteLegalPerson() 
    {
        return eLegalPerson;
    }
    public void seteLegalPersonPhone(String eLegalPersonPhone) 
    {
        this.eLegalPersonPhone = eLegalPersonPhone;
    }

    public String geteLegalPersonPhone() 
    {
        return eLegalPersonPhone;
    }
    public void seteBusinessPerson(String eBusinessPerson) 
    {
        this.eBusinessPerson = eBusinessPerson;
    }

    public String geteBusinessPerson() 
    {
        return eBusinessPerson;
    }
    public void seteBusinessPersonPhone(String eBusinessPersonPhone) 
    {
        this.eBusinessPersonPhone = eBusinessPersonPhone;
    }

    public String geteBusinessPersonPhone() 
    {
        return eBusinessPersonPhone;
    }
    public void seteRegisterTime(Date eRegisterTime) 
    {
        this.eRegisterTime = eRegisterTime;
    }

    public Date geteRegisterTime() 
    {
        return eRegisterTime;
    }
    public void seteBusinessScope(String eBusinessScope) 
    {
        this.eBusinessScope = eBusinessScope;
    }

    public String geteBusinessScope() 
    {
        return eBusinessScope;
    }
    public void seteCustomsNo(String eCustomsNo) 
    {
        this.eCustomsNo = eCustomsNo;
    }

    public String geteCustomsNo() 
    {
        return eCustomsNo;
    }
    public void seteOrganizationNo(String eOrganizationNo) 
    {
        this.eOrganizationNo = eOrganizationNo;
    }

    public String geteOrganizationNo() 
    {
        return eOrganizationNo;
    }
    public void seteIsMember(String eIsMember) 
    {
        this.eIsMember = eIsMember;
    }

    public String geteIsMember() 
    {
        return eIsMember;
    }
    public void seteIsCargoOwner(String eIsCargoOwner) 
    {
        this.eIsCargoOwner = eIsCargoOwner;
    }

    public String geteIsCargoOwner() 
    {
        return eIsCargoOwner;
    }
    public void seteIsForwarder(String eIsForwarder) 
    {
        this.eIsForwarder = eIsForwarder;
    }

    public String geteIsForwarder() 
    {
        return eIsForwarder;
    }
    public void seteIsTrailer(String eIsTrailer) 
    {
        this.eIsTrailer = eIsTrailer;
    }

    public String geteIsTrailer() 
    {
        return eIsTrailer;
    }
    public void seteRemarks(String eRemarks) 
    {
        this.eRemarks = eRemarks;
    }

    public String geteRemarks() 
    {
        return eRemarks;
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
            .append("eName", geteName())
            .append("eType", geteType())
            .append("eEname", geteEname())
            .append("eAbbreviation", geteAbbreviation())
            .append("eAddress", geteAddress())
            .append("eLegalPerson", geteLegalPerson())
            .append("eLegalPersonPhone", geteLegalPersonPhone())
            .append("eBusinessPerson", geteBusinessPerson())
            .append("eBusinessPersonPhone", geteBusinessPersonPhone())
            .append("eRegisterTime", geteRegisterTime())
            .append("eBusinessScope", geteBusinessScope())
            .append("eCustomsNo", geteCustomsNo())
            .append("eOrganizationNo", geteOrganizationNo())
            .append("eIsMember", geteIsMember())
            .append("eIsCargoOwner", geteIsCargoOwner())
            .append("eIsForwarder", geteIsForwarder())
            .append("eIsTrailer", geteIsTrailer())
            .append("eRemarks", geteRemarks())
            .append("version", getVersion())
            .append("crtime", getCrtime())
            .append("cruser", getCruser())
            .append("crusername", getCrusername())
            .append("del", getDel())
            .toString();
    }
}
