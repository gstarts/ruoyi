package com.ruoyi.stations_management.declare.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.stations_management.common.domain.StationInfo;
import com.ruoyi.stations_management.common.service.IStationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.declare.mapper.ContainerHeadMapper;
import com.ruoyi.stations_management.declare.domain.ContainerHead;
import com.ruoyi.stations_management.declare.service.IContainerHeadService;

/**
 * 集装箱头Service业务层处理
 *
 * @author songqingchuan
 * @date 2020-04-07
 */
@Service
public class ContainerHeadServiceImpl implements IContainerHeadService
{
    @Autowired
    private ContainerHeadMapper containerHeadMapper;
    @Autowired
    private IStationInfoService stationInfoService;

    /**
     * 查询集装箱头
     *
     * @param id 集装箱头ID
     * @return 集装箱头
     */
    @Override
    public ContainerHead selectContainerHeadById(Long id)
    {
        return containerHeadMapper.selectContainerHeadById(id);
    }

    /**
     * 查询集装箱头列表
     *
     * @param containerHead 集装箱头
     * @return 集装箱头
     */
    @Override
    public List<ContainerHead> selectContainerHeadList(ContainerHead containerHead)
    {
        return containerHeadMapper.selectContainerHeadList(containerHead);
    }

    /**
     * 新增集装箱头
     *
     * @param containerHead 集装箱头
     * @return 结果
     */
    @Override
    public int insertContainerHead(ContainerHead containerHead)
    {
        return containerHeadMapper.insertContainerHead(containerHead);
    }

    /**
     * 修改集装箱头
     *
     * @param containerHead 集装箱头
     * @return 结果
     */
    @Override
    public int updateContainerHead(ContainerHead containerHead)
    {
        return containerHeadMapper.updateContainerHead(containerHead);
    }

    /**
     * 批量删除集装箱头
     *
     * @param ids 需要删除的集装箱头ID
     * @return 结果
     */
    @Override
    public int declareContainers(Long[] ids)
    {
        return containerHeadMapper.declareContainers(ids);
    }

    /**
     * 删除集装箱头信息
     *
     * @param id 集装箱头ID
     * @return 结果
     */
    @Override
    public int deleteContainerHeadById(Long id)
    {
        return containerHeadMapper.deleteContainerHeadById(id);
    }

    @Override
    public ContainerHead init(String stationId) {
        ContainerHead head = new ContainerHead();
        StationInfo station = stationInfoService.selectStationInfoById(Long.valueOf(stationId));
        if(null!=station){
            head.setCustomscode(station.getCustomsmaster());
            head.setSupvloctcode(station.getSupvloctcode());
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(d);
        head.setId(d.getTime());
       head.setDecldate(str);
        return head;
    }

}
