package com.ruoyi.stations_management.declare.service.impl;

import java.util.List;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.stations_management.declare.domain.AnimalsBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.stations_management.declare.mapper.ContainerBodyMapper;
import com.ruoyi.stations_management.declare.domain.ContainerBody;
import com.ruoyi.stations_management.declare.service.IContainerBodyService;

/**
 * 集装箱体Service业务层处理
 * 
 * @author songqingchaun
 * @date 2020-04-07
 */
@Service
public class ContainerBodyServiceImpl implements IContainerBodyService 
{
    @Autowired
    private ContainerBodyMapper containerBodyMapper;

    /**
     * 查询集装箱体
     * 
     * @param id 集装箱体ID
     * @return 集装箱体
     */
    @Override
    public ContainerBody selectContainerBodyById(Long id)
    {
        return containerBodyMapper.selectContainerBodyById(id);
    }

    /**
     * 查询集装箱体列表
     * 
     * @param containerBody 集装箱体
     * @return 集装箱体
     */
    @Override
    public List<ContainerBody> selectContainerBodyList(ContainerBody containerBody)
    {
        return containerBodyMapper.selectContainerBodyList(containerBody);
    }

    /**
     * 新增集装箱体
     * 
     * @param containerBody 集装箱体
     * @return 结果
     */
    @Override
    public int insertContainerBody(ContainerBody containerBody)
    {
        return containerBodyMapper.insertContainerBody(containerBody);
    }

    /**
     * 修改集装箱体
     * 
     * @param containerBody 集装箱体
     * @return 结果
     */
    @Override
    public int updateContainerBody(ContainerBody containerBody)
    {
        return containerBodyMapper.updateContainerBody(containerBody);
    }

    /**
     * 批量删除集装箱体
     * 
     * @param ids 需要删除的集装箱体ID
     * @return 结果
     */
    @Override
    public int deleteContainerBodyByIds(Long[] ids)
    {
        return containerBodyMapper.deleteContainerBodyByIds(ids);
    }

    /**
     * 删除集装箱体信息
     * 
     * @param id 集装箱体ID
     * @return 结果
     */
    @Override
    public int deleteContainerBodyById(Long id)
    {
        return containerBodyMapper.deleteContainerBodyById(id);
    }

    /**
     * 批量插入集装箱信息
     * @param list
     * @param headId
     * @return
     */

    @Override
    public String importContainer(List<ContainerBody> list, Long headId) {
        String errMsg = validationRules(list);
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        if(StringUtils.isEmpty(errMsg)){
            for (ContainerBody containerBody:list){
                containerBody.setHeadId(headId);
            }try{
                containerBodyMapper.insertContainerBodys(list);
                successMsg.append("数据导入成功").toString();
            } catch(Exception e){
                failureMsg.append("导入失败");
                failureMsg.append(e.getMessage());
                throw new CustomException(failureMsg.toString());
            }
        } else {
            return failureMsg.append(errMsg).toString();
        }
        return successMsg.toString();
    }



    public String validationRules(List<ContainerBody> list) {
        StringBuilder failureMsg = new StringBuilder();
        String[] comment = {"集装箱号","集装箱尺寸","箱位代码","内外贸标识","装载状态","进场时间","当前状态",};
        if (StringUtils.isNull(list) || list.size() == 0) {
            return failureMsg.append("导入数据不能为空").toString();
        }
        int row = 1;
        for (ContainerBody containerBody : list){
            if(StringUtils.isEmpty(containerBody.getContaid())){
                failureMsg.append("第" + row + "行数据不正确" + comment[0] + "不能为空");
            }
            if (StringUtils.isEmpty(containerBody.getContatypecode())){
                failureMsg.append("第" + row + "行数据不正确" + comment[1] + "不能为空");
            }
            if (StringUtils.isEmpty(containerBody.getSeat())){
                failureMsg.append("第" + row + "行数据不正确" + comment[2] + "不能为空");
            }
            if (StringUtils.isEmpty(containerBody.getTrademark())){
                failureMsg.append("第" + row + "行数据不正确" + comment[3] + "不能为空");
            }
            if (StringUtils.isEmpty(containerBody.getLoadmark())){
                failureMsg.append("第" + row + "行数据不正确" + comment[4] + "不能为空");
            }
            if (StringUtils.isEmpty(containerBody.getEntrancedate())){
                failureMsg.append("第" + row + "行数据不正确" + comment[5] + "不能为空");
            }
            if (StringUtils.isEmpty(containerBody.getWorkmark())){
                failureMsg.append("第" + row + "行数据不正确" + comment[6] + "不能为空");
            }
            if (!containerBody.getDatadealflag().equals("A") && (!containerBody.getDatadealflag().equals("M")) && (!containerBody.getDatadealflag().equals("D"))) {
                failureMsg.append("第" + row + "行数据不正确" + comment[5] + "无效" + "有效为：A:增加；M:修改；D:删除");
            }
            if(StringUtils.isNotEmpty(failureMsg.toString())){
                failureMsg.append("<br/>");
            }
            row++;
        }

            if(StringUtils.isNotEmpty(failureMsg.toString())){
                failureMsg.insert(0, "很抱歉，导入失败！ 数据格式不正确，错误如下：<br/>");
            }
            return failureMsg.toString();
        }
}
