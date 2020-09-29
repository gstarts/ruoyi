package com.ruoyi.stations_management.declare.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.stations_management.common.domain.StationInfo;
import com.ruoyi.stations_management.common.service.IStationInfoService;
import com.ruoyi.stations_management.declare.mapper.AnimalsBodyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.declare.mapper.AnimalsHeadMapper;
import com.ruoyi.stations_management.declare.domain.AnimalsHead;
import com.ruoyi.stations_management.declare.service.IAnimalsHeadService;

/**
 * 动物头Service业务层处理
 *
 * @author qishuai
 * @date 2020-04-07
 */
@Service
public class AnimalsHeadServiceImpl implements IAnimalsHeadService
{
    @Autowired
    private AnimalsHeadMapper animalsHeadMapper;

    @Autowired
    private AnimalsBodyMapper animalsBodyMapper;

    @Autowired
    private IStationInfoService stationInfoService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询动物头
     *
     * @param id 动物头ID
     * @return 动物头
     */
    @Override
    public AnimalsHead selectAnimalsHeadById(Long id)
    {
        return animalsHeadMapper.selectAnimalsHeadById(id);
    }

    /**
     * 查询动物头列表
     *
     * @param animalsHead 动物头
     * @return 动物头
     */
    @Override
    public List<AnimalsHead> selectAnimalsHeadList(AnimalsHead animalsHead)
    {
        return animalsHeadMapper.selectAnimalsHeadList(animalsHead);
    }

    /**
     * 新增动物头
     *
     * @param animalsHead 动物头
     * @return 结果
     */
    @Override
    public int insertAnimalsHead(AnimalsHead animalsHead)
    {
        return animalsHeadMapper.insertAnimalsHead(animalsHead);
    }

    /**
     * 修改动物头
     *
     * @param animalsHead 动物头
     * @return 结果
     */
    @Override
    public int updateAnimalsHead(AnimalsHead animalsHead)
    {
        return animalsHeadMapper.updateAnimalsHead(animalsHead);
    }

    /**
     * 动植物批量申报
     *
     * @param ids 申报数据ID
     * @return 结果
     */
    @Override
    public int declareAnimals(Long[] ids)
    {   // 需要check 是否有表体

        return animalsHeadMapper.declareAnimals(ids);
    }

    /**
     * 删除动物头信息
     *
     * @param id 动物头ID
     * @return 结果
     */
    @Override
    public int deleteAnimalsHeadById(Long id)
    {
        return animalsHeadMapper.deleteAnimalsHeadById(id);
    }

    @Override
    public AnimalsHead init(String stationId) {

        AnimalsHead head = new AnimalsHead();
        StationInfo station = stationInfoService.selectStationInfoById(Long.valueOf(stationId));
        if(null != station){
            head.setCustomscode(station.getCustomsmaster());
            head.setSupvloctcode(station.getSupvloctcode());
        }

        LocalDateTime currentTime = LocalDateTime.now();
        // 获取当前时间 转为YYYY-MM-DD HH:mm:ss
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowDate = sdf.format(new Date());
        head.setDecldate(nowDate);
        //获取当前登录用户名
        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        head.setCruser(userName);
        head.setId(new Date().getTime());
        return head;
    }

}
