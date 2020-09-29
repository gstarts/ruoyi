package com.ruoyi.stations_management.coal.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.security.service.TokenService;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.stations_management.coal.domain.CoalNumberPlate;
import com.ruoyi.stations_management.coal.mapper.CoalNumberPlateMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.coal.mapper.CoalNumberMapper;
import com.ruoyi.stations_management.coal.domain.CoalNumber;
import com.ruoyi.stations_management.coal.service.ICoalNumberService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 大提煤单 Service业务层处理
 *
 * @author songqingchuan
 * @date 2020-06-02
 */
@Service
public class CoalNumberServiceImpl implements ICoalNumberService {
    @Autowired
    private CoalNumberMapper coalNumberMapper;
    @Autowired
    private CoalNumberPlateMapper coalNumberPlateMapper;
    @Autowired
    private TokenService tokenService;

    /**
     * 根据单号 查询
     *
     * @param coalNumber 单号
     * @return 结果
     */
    @Override
    public CoalNumber selectCoalNumberById(String coalNumber) {
        return coalNumberMapper.selectCoalNumberById(coalNumber);
    }

    /**
     * 查询列表
     *
     * @param coalNumber 单号
     * @return 结果
     */
    @Override
    public List<CoalNumber> selectCoalNumberList(CoalNumber coalNumber) {


        if (2 == Integer.parseInt(coalNumber.getSpoilt())) {
            return coalNumberMapper.selectCoalNumber(coalNumber);

        } else {
            return coalNumberMapper.selectCoalNumberList(coalNumber);
        }

    }

    /**
     * 新增大提煤单
     *
     * @param coalNumber 大提煤单实体类
     * @return 结果
     */
    @Override
    public int insertCoalNumber(CoalNumber coalNumber) {
        //查询是否有大提煤单 不等于0则提煤单重复 不新增
        if(coalNumberMapper.selectCoalNumberAll(coalNumber).size() == 0){
            return coalNumberMapper.insertCoalNumber(coalNumber);
        }
        throw new CustomException("增加失败,大提煤单号重复");
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param coalNumber 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateCoalNumber(CoalNumber coalNumber) {
        return coalNumberMapper.updateCoalNumber(coalNumber);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param coalNumbers 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCoalNumberByIds(String[] coalNumbers) {
        return coalNumberMapper.deleteCoalNumberByIds(coalNumbers);
    }

    /**
     * 作废【大提煤单信息】
     *
     * @param coalNumber
     * @return
     */

    @Override
    @Transactional
    public int updateCoalNumberByIds(String coalNumber) {
        int row = 0;
        String[] str = {coalNumber};
        try {
            row = coalNumberPlateMapper.updateCoalNumberPlateByNum(str);
            row = coalNumberMapper.updateCoalNumberByIds(coalNumber);

        } catch (Exception e) {
            throw new RuntimeException();
        }

        return row;
    }


    /**
     * 执行完成
     *
     * @param ids
     * @return
     */
    @Override
    @Transactional
    public int updateCoalNumberPlateByNum(String[] ids) {
        int row = 0;
        try {
            row = coalNumberPlateMapper.updateCoalNumberPlateByNum(ids);
            row = coalNumberMapper.updateCoalNumberByNum(ids);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return row;
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param coalNumber 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteCoalNumberById(String coalNumber) {
        return coalNumberMapper.deleteCoalNumberById(coalNumber);
    }

    /**
     * 初始化页面
     *
     * @return
     */
    @Override
    public CoalNumber init() {
        CoalNumber coalNumber = new CoalNumber();
        //获取当前登录用户名
        String Username = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        //set进实体类录入人
        coalNumber.setOperator(Username);
        //获取当前系统时间
        Date date = new Date();
        //转换时间格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //set进实体类 录入时间
        coalNumber.setDateTime(sdf.format(date));
//        //查询小提煤单列表
//        List<CoalNumberPlate>list=coalNumberPlateMapper.selectCoalNumberPlateById(coalNumber.getCoalNumber());
//
//       for(CoalNumberPlate Number :list){
//        if(Number.getCoalNumber() !=null){
//
//        }
//       }
        return coalNumber;
    }
}
