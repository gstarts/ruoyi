package com.ruoyi.stations_management.container.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 s_mb_container
 * 
 * @author songxiangyang
 * @date 2020-06-11
 */
public class MbContainer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 集装箱管理head表id(表关联使用) */
    @Excel(name = "集装箱管理head表id(表关联使用)")
    private Long headId;

    /** 集装箱尺寸 */
    @Excel(name = "集装箱尺寸")
    private String sizeCode;

    /** 来源 */
    @Excel(name = "来源")
    private String fromCode;

    /** 自重 */
    @Excel(name = "自重")
    private String weight;

    /** 进场时间 */
    @Excel(name = "进场时间")
    private String inTime;

    /** 出场时间 */
    @Excel(name = "出场时间")
    private String outTime;

    /** 是否在场(0 在场 、1出场) */
    @Excel(name = "是否在场(0 在场 、1出场)")
    private String status;

    /** 车辆 */
    private MhContainer mhContainer;

    /** 集装箱号 */
    private String code;

    /** 车牌号 */
    private String plate;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MhContainer getMhContainer() {
        return mhContainer;
    }

    public void setMhContainer(MhContainer mhContainer) {
        this.mhContainer = mhContainer;
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

    public Long getHeadId() 
    {
        return headId;
    }
    public void setSizeCode(String sizeCode) 
    {
        this.sizeCode = sizeCode;
    }

    public String getSizeCode() 
    {
        return sizeCode;
    }
    public void setFromCode(String fromCode) 
    {
        this.fromCode = fromCode;
    }

    public String getFromCode() 
    {
        return fromCode;
    }
    public void setWeight(String weight) 
    {
        this.weight = weight;
    }

    public String getWeight() 
    {
        return weight;
    }
    public void setInTime(String inTime) 
    {
        this.inTime = inTime;
    }

    public String getInTime() 
    {
        return inTime;
    }
    public void setOutTime(String outTime) 
    {
        this.outTime = outTime;
    }

    public String getOutTime() 
    {
        return outTime;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return "MbContainer{" +
                "id=" + id +
                ", headId=" + headId +
                ", sizeCode='" + sizeCode + '\'' +
                ", fromCode='" + fromCode + '\'' +
                ", weight='" + weight + '\'' +
                ", inTime='" + inTime + '\'' +
                ", outTime='" + outTime + '\'' +
                ", status='" + status + '\'' +
                ", mhContainer=" + mhContainer +
                ", code='" + code + '\'' +
                '}';
    }
}
