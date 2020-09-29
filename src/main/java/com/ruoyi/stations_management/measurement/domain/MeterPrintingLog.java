package com.ruoyi.stations_management.measurement.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 计量单打印日志对象 s_meter_printing_log
 * 
 * @author lanzhenyuan
 * @date 2020-08-28
 */
public class MeterPrintingLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 计量号 */
    @Excel(name = "计量号")
    private String measurementNum;

    /** 打印时间 */
    @Excel(name = "打印时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date printTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMeasurementNum(String measurementNum) 
    {
        this.measurementNum = measurementNum;
    }

    public String getMeasurementNum() 
    {
        return measurementNum;
    }
    public void setPrintTime(Date printTime) 
    {
        this.printTime = printTime;
    }

    public Date getPrintTime() 
    {
        return printTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("measurementNum", getMeasurementNum())
            .append("printTime", getPrintTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
