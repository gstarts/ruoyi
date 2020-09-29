package com.ruoyi.stations_management.monitor.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 车辆通关图片信息对象 g_photo
 * 
 * @author qishuai
 * @date 2020-04-08
 */
@ApiModel("photo实体")
public class Photo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @ApiModelProperty("ID")
    private Long id;

    /** 会话编号 */
    @Excel(name = "会话编号")
    @ApiModelProperty("会话编号")
    private String sessionId;

    /** 唯一编号1、箱号图片：存储箱号图片名称前缀（不包含文件扩展名），如：09060070018001120003_20181119152430686502_;2、车牌图片：存储车牌图片名称，如：辽b9897h_2018-11-19_15-17-00.jpg */
    @ApiModelProperty("唯一编号")
    @Excel(name = "唯一编号1、箱号图片：存储箱号图片名称前缀", readConverterExp = "不=包含文件扩展名")
    private String photoGuid;

    /** 图像视角1、箱号图片：conta;2、车牌图片：licenseplate */
    @ApiModelProperty("图像视角")
    @Excel(name = "图像视角1、箱号图片：conta;2、车牌图片：licenseplate")
    private String photoPerspective;

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
    public void setPhotoGuid(String photoGuid) 
    {
        this.photoGuid = photoGuid;
    }

    public String getPhotoGuid() 
    {
        return photoGuid;
    }
    public void setPhotoPerspective(String photoPerspective) 
    {
        this.photoPerspective = photoPerspective;
    }

    public String getPhotoPerspective() 
    {
        return photoPerspective;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sessionId", getSessionId())
            .append("photoGuid", getPhotoGuid())
            .append("photoPerspective", getPhotoPerspective())
            .toString();
    }
}
