package com.ruoyi.stations_management.report.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.report.mapper.Rmft4406HeadMapper;
import com.ruoyi.stations_management.report.domain.Rmft4406Head;
import com.ruoyi.stations_management.report.service.IRmft4406HeadService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author songxiangyang
 * @date 2020-07-27
 */
@Service
public class Rmft4406HeadServiceImpl implements IRmft4406HeadService 
{
    @Autowired
    private Rmft4406HeadMapper rmft4406HeadMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param messageid 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Rmft4406Head selectRmft4406HeadById(String messageid)
    {
        return rmft4406HeadMapper.selectRmft4406HeadById(messageid);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param rmft4406Head 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Rmft4406Head> selectRmft4406HeadList(Rmft4406Head rmft4406Head)
    {
        return rmft4406HeadMapper.selectRmft4406HeadList(rmft4406Head);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param rmft4406Head 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertRmft4406Head(Rmft4406Head rmft4406Head)
    {
        return rmft4406HeadMapper.insertRmft4406Head(rmft4406Head);
    }

//    /**
//     * 修改【请填写功能名称】
//     *
//     * @param rmft4406Head 【请填写功能名称】
//     * @return 结果
//     */
//    @Override
//    public int updateRmft4406Head(Rmft4406Head rmft4406Head)
//    {
//        return rmft4406HeadMapper.updateRmft4406Head(rmft4406Head);
//    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param messageids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRmft4406HeadByIds(String[] messageids)
    {
        return rmft4406HeadMapper.deleteRmft4406HeadByIds(messageids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param messageid 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteRmft4406HeadById(String messageid)
    {
        return rmft4406HeadMapper.deleteRmft4406HeadById(messageid);
    }
}
