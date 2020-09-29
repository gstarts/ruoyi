package com.ruoyi.stations_management.container.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.framework.security.service.TokenService;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.stations_management.coal.domain.CoalNumber;
import com.ruoyi.stations_management.container.domain.MbContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.container.mapper.MhContainerMapper;
import com.ruoyi.stations_management.container.domain.MhContainer;
import com.ruoyi.stations_management.container.service.IMhContainerService;

/**
 * 集装箱管理HeadService业务层处理
 * 
 * @author songxiangyang
 * @date 2020-06-11
 */
@Service
public class MhContainerServiceImpl implements IMhContainerService 
{
    @Autowired
    private MhContainerMapper mhContainerMapper;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询集装箱管理Head
     *
     * @param id 集装箱管理HeadID
     * @return 集装箱管理Head
     */
    @Override
    public MhContainer selectMhContainerById(Long id)
    {

        return mhContainerMapper.selectMhContainerById(id);
    }

    /**
     * 查询集装箱管理Head列表
     * 
     * @param mhContainer 集装箱管理Head
     * @return 集装箱管理Head
     */
    @Override
    public List<MhContainer> selectMhContainerList(MhContainer mhContainer)
    {
        return mhContainerMapper.selectMhContainerList(mhContainer);
    }

    /**
     * 新增集装箱管理Head
     * 
     * @param mhContainer 集装箱管理Head
     * @return 结果
     */
    @Override
    public int insertMhContainer(MhContainer mhContainer)
    {
        return mhContainerMapper.insertMhContainer(mhContainer);
    }

    /**
     * 修改集装箱管理Head
     * 
     * @param mhContainer 集装箱管理Head
     * @return 结果
     */
    @Override
    public int updateMhContainer(MhContainer mhContainer)
    {
        return mhContainerMapper.updateMhContainer(mhContainer);
    }

    /**
     * 批量删除集装箱管理Head
     * 
     * @param ids 需要删除的集装箱管理HeadID
     * @return 结果
     */
    @Override
    public int deleteMhContainerByIds(Long[] ids)
    {
        return mhContainerMapper.deleteMhContainerByIds(ids);
    }

    /**
     * 删除集装箱管理Head信息
     * 
     * @param id 集装箱管理HeadID
     * @return 结果
     */
    @Override
    public int deleteMhContainerById(Long id)
    {
        return mhContainerMapper.deleteMhContainerById(id);
    }

    /**
     * 初始化页面
     *
     * @return
     */
    @Override
    public MhContainer init() {
        Date date = new Date();
        MhContainer mhContainer = new MhContainer();
        //获取当前登录用户名
        String Username = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        //set进实体类录入人
        mhContainer.setOperator(Username);
        mhContainer.setId(date.getTime());
        return mhContainer;
    }
}
