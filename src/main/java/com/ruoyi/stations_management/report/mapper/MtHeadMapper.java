package com.ruoyi.stations_management.report.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.stations_management.report.domain.*;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
public interface MtHeadMapper {
    /**
     * 查询【确报表头详细信息】
     *

     */
    public Rmft4406Head selectMtHeadById(String messageId);

    public Rmft4406Head select();

    public List<Rmft4406Head> selectXml();

    public List<Rmft4406Transportequipment> selectRmft4406Transportequipment(String messageid);
    public List<Rmft4406Bordertransportequipment> selectRmft4406Bordertransportequipment(String messageid);

    // 查询挂车集合
    public List<Rmft4406Bordertransportequipment> selectMtTransportById(Long borderTransportMeansId);

    // 查询挂车当前行信息
    public Rmft4406Bordertransportequipment MtTransportByIdDetail(Long id);

    // 查询集装箱集合
    public List<Rmft4406Transportequipment> selectCoaltById(Long consignmentId);

    //查询集装箱当前行信息
    public Rmft4406Transportequipment getCoalDetail(Long id);

//    // 修改挂车信息
//    public int updateMtTransport(Rmft4406Head rmft4406Head);

    // 修改集装箱信息
    public int updateMtCoal(MtCoal mtCoal);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param mtHead 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Rmft4406Head> selectMtHeadList(Rmft4406Head rmft4406Head);

    /**
     * 新增【请填写功能名称】
     *
     *
     */
    public int insertMtHead(Rmft4406Head rmft4406Head);

    /**
     * 修改【表头修改】
     *
     * @param mtHead 【请填写功能名称】
     * @return 结果
     */
    public int updateMtHead(Rmft4406Head rmft4406Head);

    /**
     * 修改【异常修改页面表头信息】
     *
     * @param rmft4406Head 【请填写功能名称】
     * @return 结果
     */
    public int updateRmft4406Head(Rmft4406Head rmft4406Head);

    /**
     * 修改【申报前改状态】
     *
     * @param rmft4406Head
     * @return 结果
     */
    public int updateRmft4406Declare(Rmft4406Head rmft4406Head);

    /**
     * 修改【申报后并回复成功的状态】
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


    public int updateMtBorderTransport (MtBorderTransport mtBorderTransport);


    public int updateMtCarrier (MtCarrier mtCarrier);

    public int updateMtLoading (MtLoading mtLoading);

    public int updateMtMaster (MtMaster mtMaster);

    public int updateMtRepresen (MtRepresen mtRepresen);

    public int updateIMtGovernmentprocedure(IMtGovernmentprocedure iMtGovernmentprocedure);

    /**
     * 删除【请填写功能名称】
     *
     * @param pid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteMtHeadById(Long pid);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param pids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMtHeadByIds(Long[] pids);
}
