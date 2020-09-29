package com.ruoyi.stations_management.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.report.mapper.Rmft4406BordertransportmeansMapper;
import com.ruoyi.stations_management.report.domain.Rmft4406Bordertransportmeans;
import com.ruoyi.stations_management.report.service.IRmft4406BordertransportmeansService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
@Service
public class Rmft4406BordertransportmeansServiceImpl implements IRmft4406BordertransportmeansService 
{
    @Autowired
    private Rmft4406BordertransportmeansMapper rmft4406BordertransportmeansMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Rmft4406Bordertransportmeans selectRmft4406BordertransportmeansById(Long id)
    {
        return rmft4406BordertransportmeansMapper.selectRmft4406BordertransportmeansById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param rmft4406Bordertransportmeans 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Rmft4406Bordertransportmeans> selectRmft4406BordertransportmeansList(Rmft4406Bordertransportmeans rmft4406Bordertransportmeans)
    {
        return rmft4406BordertransportmeansMapper.selectRmft4406BordertransportmeansList(rmft4406Bordertransportmeans);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param rmft4406Bordertransportmeans 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRmft4406Bordertransportmeans(Rmft4406Bordertransportmeans rmft4406Bordertransportmeans)
    {
        return rmft4406BordertransportmeansMapper.insertRmft4406Bordertransportmeans(rmft4406Bordertransportmeans);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param rmft4406Bordertransportmeans 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateRmft4406Bordertransportmeans(Rmft4406Bordertransportmeans rmft4406Bordertransportmeans)
    {
        return rmft4406BordertransportmeansMapper.updateRmft4406Bordertransportmeans(rmft4406Bordertransportmeans);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRmft4406BordertransportmeansByIds(Long[] ids)
    {
        return rmft4406BordertransportmeansMapper.deleteRmft4406BordertransportmeansByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRmft4406BordertransportmeansById(Long id)
    {
        return rmft4406BordertransportmeansMapper.deleteRmft4406BordertransportmeansById(id);
    }
}
