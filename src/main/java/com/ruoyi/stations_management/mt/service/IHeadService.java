package com.ruoyi.stations_management.mt.service;

import com.ruoyi.stations_management.mt.domain.BorderTransportEquipment;
import com.ruoyi.stations_management.mt.domain.Head;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 报文头信息Service接口
 *
 * @author lanzhenyuan
 * @date 2020-07-27
 */
public interface IHeadService {


    /**
     * 查询报文头信息列表
     *
     * @param head 报文头信息
     * @return 报文头信息集合
     */
    List<Head> selectHeadList(Head head);

    /**
     * 空载车辆异常查询
     *
     * @param head 头
     * @return 异常车辆集合
     */
    List<Head> selectErrList(Head head);

    /**
     * 查询空车表头信息
     *
     * @param messageId 唯一标识
     * @return 结果
     */
    Head selectIMtHead06ById(String messageId);

    /**
     * 新增初始化
     *
     * @return 结果
     */
    Head init();

    /**
     * 新增报文头信息
     *
     * @param head 报文头信息
     * @return 结果
     */
    Map<String, String> insertHead(Head head);

    /**
     * 修改报文头信息
     *
     * @param head 报文头信息
     * @return 结果
     */
    int updateHead(Head head);

    /**
     * 修改报文申报状态
     *
     * @param head head
     * @return 结果
     */
    int updateCode(Head head);

    /**
     * 查询空载挂车信息
     *
     * @param borderTransportMeansId 空载信息
     * @return 结果
     */
    List<BorderTransportEquipment> selectCarById(Long borderTransportMeansId);

    /**
     * 查询空载详细
     *
     * @param id 车辆id
     * @return 结果
     */
    BorderTransportEquipment selectCarAllById(Long id);

    /**
     * 修改空包车信息
     *
     * @param borderTransportEquipment 运载设备
     * @return 结果
     */
    int updateCarById(BorderTransportEquipment borderTransportEquipment);

    /**
     * 批量删除报文头信息
     *
     * @param messageIds 需要删除的报文头信息ID
     * @return 结果
     */
    int deleteHeadByIds(String[] messageIds);

    /**
     * 查询空载确报XML数据
     *
     * @return 结果
     */
    List<Head> selectConfirmation();

    /**
     * 生成空载确报XML
     *
     * @param head 头信息
     */
    void ConfirmationXML(Head head);

    /**
     * 解析XML 储存到数据库
     *
     * @throws IOException       io异常
     * @throws DocumentException xml 异常
     */
    void addQBXml() throws IOException, DocumentException;
}
