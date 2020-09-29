package com.ruoyi.stations_management.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 提（运）单数据对象 i_rmft4406_consignment
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
public class Rmft4406Consignment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 报文编号 */
    @Excel(name = "报文编号")
    private String messageId;

    /** $column.columnComment */
    @Excel(name = "报文编号")
    private String governmentProcedure;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
    }

    public String getMessageId()
    {
        return messageId;
    }
    public void setGovernmentProcedure(String governmentProcedure)
    {
        this.governmentProcedure = governmentProcedure;
    }

    public String getGovernmentProcedure()
    {
        return governmentProcedure;
    }

    @Override
    public String toString() {
        return "Rmft4406Consignment{" +
                "id=" + id +
                ", messageId='" + messageId + '\'' +
                ", governmentProcedure='" + governmentProcedure + '\'' +
                '}';
    }
}
