package com.ruoyi.stations_management.report.service;

import java.util.List;
import com.ruoyi.stations_management.report.domain.Rmft4406Head;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
public interface IRmft4406HeadService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param messageid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Rmft4406Head selectRmft4406HeadById(String messageid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param rmft4406Head 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Rmft4406Head> selectRmft4406HeadList(Rmft4406Head rmft4406Head);

    /**
     * 新增【请填写功能名称】
     * 
     * @param rmft4406Head 【请填写功能名称】
     * @return 结果
     */
    public int insertRmft4406Head(Rmft4406Head rmft4406Head);

//    /**
//     * 修改【请填写功能名称】
//     *
//     * @param rmft4406Head 【请填写功能名称】
//     * @return 结果
//     */
//    public int updateRmft4406Head(Rmft4406Head rmft4406Head);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param messageids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRmft4406HeadByIds(String[] messageids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param messageid 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRmft4406HeadById(String messageid);
}
