package com.ruoyi.stations_management.inout.mapper;

import com.ruoyi.stations_management.inout.domain.InoutGoodsInfo;
import java.util.List;

/**
 * 进出场货物Mapper接口
 * 
 * @author qishuai
 * @date 2020-01-02
 */
public interface InoutGoodsInfoMapper 
{
    /**
     * 查询进出场货物
     * 
     * @param id 进出场货物ID
     * @return 进出场货物
     */
    public InoutGoodsInfo selectInoutGoodsInfoById(Long id);

    /**
     * 查询进出场货物列表
     * 
     * @param inoutGoodsInfo 进出场货物
     * @return 进出场货物集合
     */
    public List<InoutGoodsInfo> selectInoutGoodsInfoList(InoutGoodsInfo inoutGoodsInfo);

    /**
     * 新增进出场货物
     * 
     * @param inoutGoodsInfo 进出场货物
     * @return 结果
     */
    public int insertInoutGoodsInfo(InoutGoodsInfo inoutGoodsInfo);

    /**
     * 修改进出场货物
     * 
     * @param inoutGoodsInfo 进出场货物
     * @return 结果
     */
    public int updateInoutGoodsInfo(InoutGoodsInfo inoutGoodsInfo);

    /**
     * 删除进出场货物
     * 
     * @param id 进出场货物ID
     * @return 结果
     */
    public int deleteInoutGoodsInfoById(Long id);

    /**
     * 批量删除进出场货物
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteInoutGoodsInfoByIds(Long[] ids);
    /**
     * 同意申请
     *
     * @param id 需要同意的数据ID
     * @return 结果
     */
    public  int consentApply(Long id);
    /**
     * 撤销同意申请
     *
     * @param id 需要撤销的数据ID
     * @return 结果
     */
    public  int cancellationApply(Long id);
}
