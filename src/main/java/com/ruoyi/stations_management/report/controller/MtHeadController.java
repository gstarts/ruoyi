package com.ruoyi.stations_management.report.controller;

import java.util.List;
import java.util.Map;

import com.ruoyi.stations_management.report.domain.*;
import com.ruoyi.stations_management.report.service.IRmft4406BordertransportequipmentService;
import com.ruoyi.stations_management.report.service.IRmft4406TransportequipmentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.stations_management.report.service.IMtHeadService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author songqingchuan
 * @date 2020-06-09
 */
@RestController
@RequestMapping("/report/head")
public class MtHeadController extends BaseController {
    @Autowired
    private IMtHeadService mtHeadService;
    @Autowired
    private IRmft4406BordertransportequipmentService rmft4406BordertransportequipmentService;
    @Autowired
    private IRmft4406TransportequipmentService rmft4406TransportequipmentService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('report:head:query')")
    @GetMapping("/list")
    public TableDataInfo list(Rmft4406Head rmft4406Head) {
        startPage();
        List<Rmft4406Head> list = mtHeadService.selectMtHeadList(rmft4406Head);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('report:head:export')")
    @Log(title = "【导出请填写功能名称列表】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Rmft4406Head rmft4406Head) {
        List<Rmft4406Head> list = mtHeadService.selectMtHeadList(rmft4406Head);
        ExcelUtil<Rmft4406Head> util = new ExcelUtil<Rmft4406Head>(Rmft4406Head.class);
        return util.exportExcel(list, "head");
    }

    /**
     * 获取【确报表头详细信息】详细信息
     */
    @PreAuthorize("@ss.hasPermi('report:head:query')")
    @GetMapping(value = "/{messageId}")
    public AjaxResult getInfo(@PathVariable("messageId") String messageId) {


        return AjaxResult.success(mtHeadService.selectMtHeadById(messageId));
    }

    /**
     * 新增页面获取【确报表头详细信息】详细信息
     */
    @PreAuthorize("@ss.hasPermi('report:head:query')")
    @GetMapping("/info")
    public AjaxResult getInfoHead() {


        return AjaxResult.success(mtHeadService.select());
    }


    /**
     * 获取托架或拖挂车信息 详细信息
     */
    @PreAuthorize("@ss.hasPermi('report:transport:query')")
    @GetMapping(value = "/transport/{borderTransportMeansId}")
    public TableDataInfo getInfoMt(@PathVariable("borderTransportMeansId") Long borderTransportMeansId) {
        List<Rmft4406Bordertransportequipment> list = mtHeadService.selectMtTransportById(borderTransportMeansId);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('report:transport:query')")
    @GetMapping(value = "/transportDetail/{id}")
    public AjaxResult getInfoMtDetail(@PathVariable("id") Long id) {
        return AjaxResult.success(mtHeadService.MtTransportByIdDetail(id));
    }

    /**
     * 获取集装箱信息 详细信息
     */
    @PreAuthorize("@ss.hasPermi('report:transport:query')")
    @GetMapping(value = "/coal/{consignmentId}")
    public AjaxResult getInfoCoal(@PathVariable("consignmentId") Long consignmentId) {
        return AjaxResult.success(mtHeadService.selectCoaltById(consignmentId));
    }


    @PreAuthorize("@ss.hasPermi('report:transport:query')")
    @GetMapping(value = "/coalDetail/{id}")
    public AjaxResult getCoalDetail(@PathVariable("id") Long id) {
        return AjaxResult.success(mtHeadService.getCoalDetail(id));
    }


    /**
     * 新增【head信息】
     */

    @PreAuthorize("@ss.hasPermi('report:head:add')")
    @Log(title = "【新增head信息】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Rmft4406Head rmft4406Head) {

//        // 查询 基础信息是否存在
//        Rmft4406Head rmft = mtHeadService.selectMtHeadById(rmft4406Head.getMessageid());
//        if (rmft != null) {
//            int updateRows = mtHeadService.updateMtHead(rmft4406Head);
//            if (updateRows > 0) {
//                return AjaxResult.success("修改成功");
//            } else {
//                return AjaxResult.error("修改失败");
//            }
//        } else {
        Map map = mtHeadService.insertMtHead(rmft4406Head);
        if (map != null) {
            return AjaxResult.success("新增成功", map);
        } else {
            return AjaxResult.error("新增失败");
        }
//        }

    }

    /**
     * 修改【确保表头信息】
     */
    @PreAuthorize("@ss.hasPermi('report:head:edit')")
    @Log(title = "【修改确保表头信息】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Rmft4406Head rmft4406Head) {
        return toAjax(mtHeadService.updateMtHead(rmft4406Head));
    }


    /**
     * 修改【需要申报信息】
     */
    @PreAuthorize("@ss.hasPermi('report:head:declare')")
    @Log(title = "【修改需要申报信息】", businessType = BusinessType.UPDATE)
    @PutMapping("/updateDeclare")
    public AjaxResult updateDeclare(@RequestBody Rmft4406Head rmft4406Head) {
        if (null == rmft4406Head.getMessageId()) {
            return AjaxResult.error("请先新增表头信息");
        } else {
            return toAjax(mtHeadService.updateRmft4406Declare(rmft4406Head));
        }
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('report:head:remove')")
    @Log(title = "【删除】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{pids}")
    public AjaxResult remove(@PathVariable Long[] pids) {
        return toAjax(mtHeadService.deleteMtHeadByIds(pids));
    }


    /**
     * 修改托架或拖挂车信息
     */
    @PreAuthorize("@ss.hasPermi('report:transport:edit')")
    @Log(title = "托架或拖挂车信息 ", businessType = BusinessType.UPDATE)
    @PutMapping("/transportInfor")
    public AjaxResult editTransport(@RequestBody Rmft4406Bordertransportequipment rmft4406Bordertransportequipment) {

        if (null == rmft4406Bordertransportequipment.getBorderTransportMeansId()) {
            return AjaxResult.error("请先双击要修改的信息");
        } else {
            return toAjax(rmft4406BordertransportequipmentService.updateRmft4406Bordertransportequipment(rmft4406Bordertransportequipment));
        }

    }


    /**
     * 修改集装箱信息
     */
    @PreAuthorize("@ss.hasPermi('report:coal:edit')")
    @Log(title = "【修改集装箱信息】", businessType = BusinessType.UPDATE)
    @PutMapping("/updateCoalInfor")
    public AjaxResult editCoalInfor(@RequestBody Rmft4406Transportequipment rmft4406Transportequipment) {
        if (null == rmft4406Transportequipment.getConsignmentId()) {
            return AjaxResult.error("请先双击要修改的信息");
        } else {
            return toAjax(rmft4406TransportequipmentService.updateRmft4406Transportequipment(rmft4406Transportequipment));
        }

    }


        /**
         * 新增页新增托架或拖挂车信息
         */
    @PreAuthorize("@ss.hasPermi('report:transport:add')")
    @Log(title = "托架或拖挂车信息 ", businessType = BusinessType.UPDATE)
    @PutMapping("/transport")
    public AjaxResult edit(@RequestBody Rmft4406Bordertransportequipment rmft4406Bordertransportequipment) {
        // 根据传回的条件查询是否已经有数据，判断进行update还是insert
        List<Rmft4406Bordertransportequipment> list = rmft4406BordertransportequipmentService.selectRmft4406BordertransportequipmentByBordertransportmeansId(rmft4406Bordertransportequipment.getBorderTransportMeansId());
        if (null == rmft4406Bordertransportequipment.getBorderTransportMeansId()) {
            return AjaxResult.error("请先新增表头信息");
        } else {
            for (Rmft4406Bordertransportequipment rmft : list) {
                if (list.size() == 1 && rmft.getTareWeight() == "" && rmft.getTransportId() == "" && rmft.getTypeCode() == "") {
                    return toAjax(rmft4406BordertransportequipmentService.updateRmft4406Bordertransportequipment(rmft4406Bordertransportequipment));
                }
            }
            rmft4406BordertransportequipmentService.deleteRmft4406BordertransportequipmentById(rmft4406Bordertransportequipment.getBorderTransportMeansId());
            return toAjax(rmft4406BordertransportequipmentService.insertRmft4406Bordertransportequipment(rmft4406Bordertransportequipment));


        }

    }


    /**
     * 新增页新增集装箱信息
     */
    @PreAuthorize("@ss.hasPermi('report:coal:add')")
    @Log(title = "【修改集装箱信息】", businessType = BusinessType.UPDATE)
    @PutMapping("/updateCoal")
    public AjaxResult editCoal(@RequestBody Rmft4406Transportequipment rmft4406Transportequipment) {
        // 根据传回的条件查询是否已经有数据，判断进行update还是insert
        List<Rmft4406Transportequipment> list = rmft4406TransportequipmentService.selectRmft4406TransportequipmentByConsignmentId(rmft4406Transportequipment.getConsignmentId());
        if (null == rmft4406Transportequipment.getConsignmentId()) {
            return AjaxResult.error("请先新增表头信息");
        } else {
            for (Rmft4406Transportequipment rmft : list) {
                if (list.size() == 1 && rmft.getCharacteristicCode() == "" && rmft.getSupplierPartyTypeCode() == "" && rmft.getTareWeight() == "" && rmft.getTransportEquipmentId() == "" && rmft.getFullnessCode() == "") {
                    return toAjax(rmft4406TransportequipmentService.updateRmft4406Transportequipment(rmft4406Transportequipment));
                }
            }
            rmft4406TransportequipmentService.deleteRmft4406TransportequipmentById(rmft4406Transportequipment.getConsignmentId());
            return toAjax(rmft4406TransportequipmentService.insertRmft4406Transportequipment(rmft4406Transportequipment));
        }

    }


}
