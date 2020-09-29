package com.ruoyi.stations_management.mt.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.mt.domain.BorderTransportEquipment;
import com.ruoyi.stations_management.mt.domain.Head;
import com.ruoyi.stations_management.mt.service.IHeadService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 报文头信息Controller
 *
 * @author lanzhenyuan
 * @date 2020-07-27
 */
@RestController
@RequestMapping("/newemptycar/head")
public class HeadController extends BaseController {
    @Resource
    private IHeadService HeadService;

    /**
     * 查询空载信息列表
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:head:list')")
    @GetMapping("/list")
    public TableDataInfo list(Head head) {
        startPage();
        List<Head> list = HeadService.selectHeadList(head);
        return getDataTable(list);
    }

    /**
     * 查询异常车辆
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:head:err')")
    @GetMapping("/Err")
    public TableDataInfo ErrList(Head head) {
        startPage();
        List<Head> ErrList = HeadService.selectErrList(head);
        return getDataTable(ErrList);
    }

    /**
     * 获取空车表头详细信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:head:query')")
    @GetMapping(value = "/{messageid}")
    public AjaxResult getAllById(@PathVariable("messageid") String messageid) {
        return AjaxResult.success(HeadService.selectIMtHead06ById(messageid));
    }

    /**
     * 新增页 初始化
     *
     * @return 结果
     */
    @GetMapping("/init")
    public AjaxResult init() {

        return AjaxResult.success(HeadService.init());
    }
    /**
     * 导出报文头信息列表
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:head:export')")
    @Log(title = "报文头信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Head head) {
        List<Head> list = HeadService.selectHeadList(head);
        ExcelUtil<Head> util = new ExcelUtil<>(Head.class);
        return util.exportExcel(list, "head");
    }

    /**
     * 修改报文头信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:head:edit')")
    @Log(title = "空载表头修改", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Head head) {
        return toAjax(HeadService.updateHead(head));
    }

    /**
     * 修改报文申报状态
     * @param head 头信息
     * @return 结果
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:head:code')")
    @PutMapping("/updateCode")
    public AjaxResult updateCode(@RequestBody(required = false) Head head){
        if(head.getMessageId()==null){
            return AjaxResult.error("申报失败,请先添加确报信息");
        }
      return toAjax(HeadService.updateCode(head));
    }
    /**
     * 新增空载表头
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:head:add')")
    @PutMapping("/insertemptyCar")
    public AjaxResult insert(@RequestBody Head head) {
        //接收到的是一个map 里面存的是与挂车数据库关联字段和messageid 返回到前台 用做关联
        return AjaxResult.success(HeadService.insertHead(head));
    }

    /**
     * 查询托架或拖挂车信息列表
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportequipment:list')")
    @GetMapping("/transportDetail/{bordertransportmeansId}")
    public TableDataInfo list(@PathVariable("bordertransportmeansId") Long bordertransportmeansId) {
        startPage();
        List<BorderTransportEquipment> list = HeadService.selectCarById(bordertransportmeansId);
        return getDataTable(list);
    }

    /**
     * 修改托架或拖挂车信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportequipment:edit')")
    @Log(title = "托架或拖挂车信息", businessType = BusinessType.UPDATE)
    @PutMapping("/updateCarall")
    public AjaxResult edit(@RequestBody BorderTransportEquipment borderTransportEquipment) {
        if (null == borderTransportEquipment.getId()) {
            return AjaxResult.error("请先双击要修改的信息");
        } else {
            return toAjax(HeadService.updateCarById(borderTransportEquipment));
        }
    }

    /**
     * 查询空载详细
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportequipment:edit')")
    @GetMapping("/transport/{id}")
    public AjaxResult selectedCar(@PathVariable("id") Long id) {
        return AjaxResult.success(HeadService.selectCarAllById(id));
    }

    /**
     * 删除报文头信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:head:remove')")
    @Log(title = "报文头信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{messageIds}")
    public AjaxResult remove(@PathVariable String[] messageIds) {
        return toAjax(HeadService.deleteHeadByIds(messageIds));
    }
}
