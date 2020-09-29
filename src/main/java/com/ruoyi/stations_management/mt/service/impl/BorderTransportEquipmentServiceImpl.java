package com.ruoyi.stations_management.mt.service.impl;

import com.ruoyi.stations_management.mt.domain.BorderTransportEquipment;
import com.ruoyi.stations_management.mt.mapper.IBorderTransportEquipmentMapper;
import com.ruoyi.stations_management.mt.service.IBorderTransportEquipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 托架或拖挂车信息Service业务层处理
 *
 * @author songqingchuan
 * @date 2020-07-27
 */
@Service
public class BorderTransportEquipmentServiceImpl implements IBorderTransportEquipmentService {
    @Resource
    private IBorderTransportEquipmentMapper iBorderTransportEquipmentMapper;

    /**
     * 查询托架或拖挂车信息
     *
     * @param id 托架或拖挂车信息ID
     * @return 托架或拖挂车信息
     */
    @Override
    public BorderTransportEquipment selectBorderTransportEquipmentById(Long id) {
        return iBorderTransportEquipmentMapper.selectBorderTransportEquipmentById(id);
    }

    /**
     * 查询托架或拖挂车信息列表
     *
     * @param Lid 关联ID
     * @return 托架或拖挂车信息
     */
    @Override
    public List<BorderTransportEquipment> selectBorderTransportEquipmentList(Long Lid) {
        return iBorderTransportEquipmentMapper.selectBorderTransportEquipmentList(Lid);
    }

    /**
     * 新增托架或拖挂车信息
     *
     * @param borderTransportEquipment 托架或拖挂车信息
     * @return 结果
     */
    @Override
    public int insertBorderTransportEquipment(BorderTransportEquipment borderTransportEquipment) {
        int row;
        try {
            row = iBorderTransportEquipmentMapper.insertBorderTransportEquipment(borderTransportEquipment);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return row;
    }

    /**
     * 修改托架或拖挂车信息
     *
     * @param borderTransportEquipment 托架或拖挂车信息
     * @return 结果
     */
    @Override
    public int updateBorderTransportEquipment(BorderTransportEquipment borderTransportEquipment) {
        return iBorderTransportEquipmentMapper.updateBorderTransportEquipment(borderTransportEquipment);
    }

    /**
     * 批量删除托架或拖挂车信息
     *
     * @param ids 需要删除的托架或拖挂车信息ID
     * @return 结果
     */
    @Override
    public int deleteBorderTransportEquipmentByIds(Long[] ids) {
        return iBorderTransportEquipmentMapper.deleteBorderTransportEquipmentByIds(ids);
    }

}
