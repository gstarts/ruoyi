package com.ruoyi.stations_management.monitor.service.impl;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.domain.TreeSelect;
import com.ruoyi.project.system.domain.SysDictData;
import com.ruoyi.stations_management.monitor.domain.ChnlInfo;
import com.ruoyi.stations_management.monitor.mapper.ChnlInfoMapper;
import com.ruoyi.stations_management.monitor.service.IChnlInfoService;
import com.ruoyi.stations_management.common.domain.StationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 通道配置Service业务层处理
 *
 * @author qishuai
 * @date 2020-03-24
 */
@Service
public class ChnlInfoServiceImpl implements IChnlInfoService
{
    @Autowired
    private ChnlInfoMapper chnlInfoMapper;

    /**
     * 查询通道配置
     *
     * @param id 通道配置ID
     * @return 通道配置
     */
    @Override
    public ChnlInfo selectChnlInfoById(Long id)
    {
        return chnlInfoMapper.selectChnlInfoById(id);
    }

    /**
     * 查询通道配置列表
     *
     * @param chnlInfo 通道配置
     * @return 通道配置
     */
    @Override
    public List<ChnlInfo> selectChnlInfoList(ChnlInfo chnlInfo)
    {
        return chnlInfoMapper.selectChnlInfoList(chnlInfo);
    }


    /**
     * 新增通道配置
     *
     * @param chnlInfo 通道配置
     * @return 结果
     */
    @Override
    public int insertChnlInfo(ChnlInfo chnlInfo)
    {
        return chnlInfoMapper.insertChnlInfo(chnlInfo);
    }

    /**
     * 修改通道配置
     *
     * @param chnlInfo 通道配置
     * @return 结果
     */
    @Override
    public int updateChnlInfo(ChnlInfo chnlInfo)
    {
        return chnlInfoMapper.updateChnlInfo(chnlInfo);
    }

    /**
     * 批量删除通道配置
     *
     * @param ids 需要删除的通道配置ID
     * @return 结果
     */
    @Override
    public int deleteChnlInfoByIds(Long[] ids)
    {
        return chnlInfoMapper.deleteChnlInfoByIds(ids);
    }

    /**
     * 删除通道配置信息
     *
     * @param id 通道配置ID
     * @return 结果
     */
    @Override
    public int deleteChnlInfoById(Long id)
    {
        return chnlInfoMapper.deleteChnlInfoById(id);
    }

    @Override
    public List<TreeSelect> buildChnlTreeSelect(List<ChnlInfo> chnl) {
        List<ChnlInfo> chnlTree = buildChnlTree(chnl);
        return chnlTree.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    @Override
    public List<TreeSelect> buildStationTree(List<StationInfo> list) {
        ChnlInfo cn=new ChnlInfo();
        for (StationInfo info : list) {
            cn.setStationId(info.getId());
            info.setChildren(chnlInfoMapper.selectChnlInfoList(cn));
        }
        return list.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    @Override
    public List<ChnlInfo> buildChnlTree(List<ChnlInfo> chnl) {
        List<ChnlInfo> returnList = new ArrayList<ChnlInfo>();
        List<Long> tempList = new ArrayList<Long>();
        for (ChnlInfo info : chnl)
        {
            tempList.add(info.getId());
        }
        for (Iterator<ChnlInfo> iterator = chnl.iterator(); iterator.hasNext();)
        {
            ChnlInfo info = (ChnlInfo) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(info.getStationId()))
            {
                recursionFn(chnl, info);
                returnList.add(info);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = chnl;
        }
        return returnList;
    }

    @Override
    public List<SysDictData> getChnlOptions() {
        return chnlInfoMapper.getChnlOptions();
    }

    @Override
    public ChnlInfo getCChnlType(String chnlInfo) {
        return chnlInfoMapper.getCChnlType(chnlInfo);
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<ChnlInfo> list, ChnlInfo t)
    {
        // 得到子节点列表
        List<ChnlInfo> childList = getChildList(list, t);
        t.setChildren(childList);
        for (ChnlInfo tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                // 判断是否有子节点
                Iterator<ChnlInfo> it = childList.iterator();
                while (it.hasNext())
                {
                    ChnlInfo n = (ChnlInfo) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    private List<ChnlInfo> getChildList(List<ChnlInfo> list, ChnlInfo t)
    {
        List<ChnlInfo> tlist = new ArrayList<ChnlInfo>();
        Iterator<ChnlInfo> it = list.iterator();
        while (it.hasNext())
        {
            ChnlInfo n = (ChnlInfo) it.next();
            if (StringUtils.isNotNull(n.getStationId()) && n.getStationId().longValue() == t.getId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<ChnlInfo> list, ChnlInfo t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
