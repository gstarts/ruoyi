package com.ruoyi.stations_management.report.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.stations_management.report.domain.*;

/**
 * 【请填写功能名称】Service接口
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
public interface IMtHeadService {
    /**
     * 查询【确报表头详细信息】
     *
     * @param messageId
     * @return 【表头对象】
     */
    public Rmft4406Head selectMtHeadById(String messageId);

    public Rmft4406Head select();

    public List<Rmft4406Head> selectXml();

    public List<Rmft4406Transportequipment> selectRmft4406Transportequipment(String messageid);

    public List<Rmft4406Bordertransportequipment> selectRmft4406Bordertransportequipment(String messageid);


    /**
     *
     * @param pid
     * @return
     */

    /**
     * 获取托架或拖挂车信息 详细信息
     *
     * @param pid
     * @return
     */
    public List<Rmft4406Bordertransportequipment> selectMtTransportById(Long borderTransportMeansId);

    public Rmft4406Bordertransportequipment MtTransportByIdDetail(Long id);

    /**
     * 获取集装箱信息 详细信息
     */
    public List<Rmft4406Transportequipment> selectCoaltById(Long consignmentId);


    public Rmft4406Transportequipment getCoalDetail(Long id);

    /**
     * 查询列表
     *
     * @param mtHead
     * @return 集合
     */
    public List<Rmft4406Head> selectMtHeadList(Rmft4406Head rmft4406Head);

    /**
     * 新增
     */
    public Map insertMtHead(Rmft4406Head rmft4406Head);

    /**
     * 修改【请填写功能名称】
     *
     * @param rmft4406Head
     * @return 结果
     */
    public int updateMtHead(Rmft4406Head rmft4406Head);

    /**
     * 修改【申报前修改状态】
     *
     * @param rmft4406Head
     * @return 结果
     */
    public int updateRmft4406Declare(Rmft4406Head rmft4406Head);

    /**
     * 修改【申报后，并回复成功的状态】
     *
     * @param rmft4406Head
     * @return 结果
     */
    public int updateRmft4406(Rmft4406Head rmft4406Head);

    /**
     * 修改【上传中的状态】
     *
     * @param rmft4406Head
     * @return 结果
     */
    public int updateRmft4406Statementcode(Rmft4406Head rmft4406Head);

    /**
     * 修改【异常修改页面表头信息】
     *
     * @param rmft4406Head
     * @return 结果
     */
    public int updateRmft4406Head(Rmft4406Head rmft4406Head);

//    /**
//     * 修改挂车信息
//     * @param mtTransport
//     * @return
//     */
//
//    public int updateMtTransport (MtTransport mtTransport);

    // 修改集装箱信息
    public int updateMtCoal(MtCoal mtCoal);

    /**
     * 批量删除
     *
     * @param pids 需要删除的ID
     * @return 结果
     */
    public int deleteMtHeadByIds(Long[] pids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param pid ID
     * @return 结果
     */
    public int deleteMtHeadById(Long pid);
}
