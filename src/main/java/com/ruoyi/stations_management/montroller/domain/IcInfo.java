package com.ruoyi.stations_management.montroller.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 车辆通关信息中ic卡信息对象 g_ic_info
 * 
 * @author songxiangyang
 * @date 2020-06-28
 */
public class IcInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 会话编号 */
    @Excel(name = "会话编号")
    private String sessionId;

    /** ic卡id号 */
    @Excel(name = "ic卡id号")
    private String icId;

    /** ic卡号 */
    @Excel(name = "ic卡号")
    private String icNo;

    /** ic卡类型 */
    @Excel(name = "ic卡类型")
    private String icType;

    /** 结构体 */
    @Excel(name = "结构体")
    private String icExtendedContent;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSessionId(String sessionId) 
    {
        this.sessionId = sessionId;
    }

    public String getSessionId() 
    {
        return sessionId;
    }
    public void setIcId(String icId) 
    {
        this.icId = icId;
    }

    public String getIcId() 
    {
        return icId;
    }
    public void setIcNo(String icNo) 
    {
        this.icNo = icNo;
    }

    public String getIcNo() 
    {
        return icNo;
    }
    public void setIcType(String icType) 
    {
        this.icType = icType;
    }

    public String getIcType() 
    {
        return icType;
    }
    public void setIcExtendedContent(String icExtendedContent) 
    {
        this.icExtendedContent = icExtendedContent;
    }

    public String getIcExtendedContent() 
    {
        return icExtendedContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sessionId", getSessionId())
            .append("icId", getIcId())
            .append("icNo", getIcNo())
            .append("icType", getIcType())
            .append("icExtendedContent", getIcExtendedContent())
            .toString();
    }
}
