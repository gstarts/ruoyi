package com.ruoyi.stations_management.report.mapper;

import java.util.List;
import com.ruoyi.stations_management.report.domain.Rmft4406Bordertransportmeans;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
public interface Rmft4406BordertransportmeansMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Rmft4406Bordertransportmeans selectRmft4406BordertransportmeansById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param rmft4406Bordertransportmeans 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Rmft4406Bordertransportmeans> selectRmft4406BordertransportmeansList(Rmft4406Bordertransportmeans rmft4406Bordertransportmeans);

    /**
     * 新增【请填写功能名称】
     * 
     * @param rmft4406Bordertransportmeans 【请填写功能名称】
     * @return 结果
     */
    public int insertRmft4406Bordertransportmeans(Rmft4406Bordertransportmeans rmft4406Bordertransportmeans);

    /**
     * 修改【请填写功能名称】
     * 
     * @param rmft4406Bordertransportmeans 【请填写功能名称】
     * @return 结果
     */
    public int updateRmft4406Bordertransportmeans(Rmft4406Bordertransportmeans rmft4406Bordertransportmeans);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteRmft4406BordertransportmeansById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRmft4406BordertransportmeansByIds(Long[] ids);
}
