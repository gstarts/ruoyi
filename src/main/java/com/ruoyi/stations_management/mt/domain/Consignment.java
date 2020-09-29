package com.ruoyi.stations_management.mt.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 提（运）单数据对象
 *
 * @author songqingchuan
 * @date 2020-07-27
 */
public class Consignment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 报文编号
     */
    @Excel(name = "报文编号")
    private String messageId;

    /**
     * $column.columnComment
     */
    @Excel(name = "报文编号")
    private String governmentProcedure;

    private BorderTransportEquipment borderTransportEquipment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getGovernmentProcedure() {
        return governmentProcedure;
    }

    public void setGovernmentProcedure(String governmentProcedure) {
        this.governmentProcedure = governmentProcedure;
    }

    public BorderTransportEquipment getBorderTransportEquipment() {
        return borderTransportEquipment;
    }

    public void setBorderTransportEquipment(BorderTransportEquipment borderTransportEquipment) {
        this.borderTransportEquipment = borderTransportEquipment;
    }

}
