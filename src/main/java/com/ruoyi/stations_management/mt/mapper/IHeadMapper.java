package com.ruoyi.stations_management.mt.mapper;

import java.util.List;


import com.ruoyi.stations_management.mt.domain.*;

/**
 * 报文头信息Mapper接口
 *
 * @author lanzhenyuan
 * @date 2020-07-27
 */
public interface IHeadMapper {

    /**
     * 查询空载信息列表
     *
     * @param head 报文头信息
     * @return 信息列表
     */
    List<Head> selectHeadList(Head head);


    /**
     * 查询异常车辆信息
     *
     * @param head 运输工具信息
     * @return 异常车辆信息 集合
     */
    List<Head> selectErrList(Head head);

    /**
     * 查询空车表头信息
     *
     * @param messageId 唯一id
     * @return 结果
     */
    Head selectHeadById(String messageId);

    /**
     * 新增报文头信息
     *
     * @param head 报文头信息
     * @return 结果
     */
    int insertHead(Head head);

    /**
     * 修改报文头部信息
     *
     * @param head 报文头信息
     * @return 结果
     */
    int updateHead(Head head);

    /**
     * 修提运单数据信息
     *
     * @param consignment 提运单数据
     * @return 结果
     */
    int updateConsignment(Consignment consignment);

    /**
     * 修改驾驶员信息
     *
     * @param borderTransportMeans 驾驶员信息
     * @return 结果
     */
    int updateBorderTransportMeans(BorderTransportMeans borderTransportMeans);

    /**
     * 报文头信息
     *
     * @param head 头信息
     * @return 结果
     */
    int updateCode(Head head);

    /**
     * 查询空载列表
     *
     * @param borderTransportMeansId 报文编号
     * @return 结果
     */
    List<BorderTransportEquipment> selectCarById(Long borderTransportMeansId);

    /**
     * 查询空载详细
     *
     * @param id 运载设备主键
     * @return 结果
     */
    BorderTransportEquipment selectCarAllById(Long id);

    /**
     * 修改挂车信息
     *
     * @param borderTransportEquipment 运输设备
     * @return 结果
     */
    int updateCarById(BorderTransportEquipment borderTransportEquipment);

    /**
     * 删除报文头信息
     *
     * @param messageId 报文头信息ID
     * @return 结果
     */
    int deleteHeadById(String messageId);

    /**
     * 批量删除报文头信息
     *
     * @param messageIds 需要删除的数据ID
     * @return 结果
     */
    int deleteHeadByIds(String[] messageIds);

    /**
     * 查询需要上传的XML
     *
     * @return 结果
     */
    List<Head> ConfirmationXML();

    /**
     * 修改上传结束后的确报状态
     *
     * @return 结果
     */
    int updateEmptyCarCode(String messageId);

    /**
     * 修改报文解析后状态
     *
     * @param head 头信息
     * @return 结果
     */
    int updateStatus(Head head);
}
