package com.ruoyi.stations_management.inout.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.inout.mapper.InoutGoodsInfoMapper;
import com.ruoyi.stations_management.inout.domain.InoutGoodsInfo;
import com.ruoyi.stations_management.inout.service.IInoutGoodsInfoService;

/**
 * 进出场货物Service业务层处理
 * 
 * @author qishuai
 * @date 2020-01-02
 */
@Service
public class InoutGoodsInfoServiceImpl implements IInoutGoodsInfoService 
{
    @Autowired
    private InoutGoodsInfoMapper inoutGoodsInfoMapper;

    /**
     * 查询进出场货物
     * 
     * @param id 进出场货物ID
     * @return 进出场货物
     */
    @Override
    public InoutGoodsInfo selectInoutGoodsInfoById(Long id)
    {
        return inoutGoodsInfoMapper.selectInoutGoodsInfoById(id);
    }

    /**
     * 查询进出场货物列表
     * 
     * @param inoutGoodsInfo 进出场货物
     * @return 进出场货物
     */
    @Override
    public List<InoutGoodsInfo> selectInoutGoodsInfoList(InoutGoodsInfo inoutGoodsInfo)
    {
        return inoutGoodsInfoMapper.selectInoutGoodsInfoList(inoutGoodsInfo);
    }

    /**
     * 新增进出场货物
     * 
     * @param inoutGoodsInfo 进出场货物
     * @return 结果
     */
    @Override
    public int insertInoutGoodsInfo(InoutGoodsInfo inoutGoodsInfo)
    {
        return inoutGoodsInfoMapper.insertInoutGoodsInfo(inoutGoodsInfo);
    }

    /**
     * 修改进出场货物
     * 
     * @param inoutGoodsInfo 进出场货物
     * @return 结果
     */
    @Override
    public int updateInoutGoodsInfo(InoutGoodsInfo inoutGoodsInfo)
    {
        return inoutGoodsInfoMapper.updateInoutGoodsInfo(inoutGoodsInfo);
    }

    /**
     * 批量删除进出场货物
     * 
     * @param ids 需要删除的进出场货物ID
     * @return 结果
     */
    @Override
    public int deleteInoutGoodsInfoByIds(Long[] ids)
    {
        return inoutGoodsInfoMapper.deleteInoutGoodsInfoByIds(ids);
    }

    /**
     * 删除进出场货物信息
     * 
     * @param id 进出场货物ID
     * @return 结果
     */
    @Override
    public int deleteInoutGoodsInfoById(Long id)
    {
        return inoutGoodsInfoMapper.deleteInoutGoodsInfoById(id);
    }
    /**
     * 同意申请
     *
     * @param id 进出场货物ID
     * @return 结果
     */
    @Override
    public int consentApply(Long id) {
        return inoutGoodsInfoMapper.consentApply(id);
    }
    /**
     * 同意申请
     *
     * @param id 进出场货物ID
     * @return 结果
     */
    @Override
    public int cancellationApply(Long id) {
        return inoutGoodsInfoMapper.cancellationApply(id);
    }
}
