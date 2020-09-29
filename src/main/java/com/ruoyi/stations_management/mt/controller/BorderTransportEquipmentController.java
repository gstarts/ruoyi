package com.ruoyi.stations_management.mt.controller;

import java.util.List;

import com.ruoyi.stations_management.mt.domain.BorderTransportEquipment;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.ruoyi.stations_management.mt.service.IBorderTransportEquipmentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;

import javax.annotation.Resource;

/**
 * 托架或拖挂车信息Controller
 *
 * @author songqingchuan
 * @date 2020-07-27
 */
@RestController
@RequestMapping("/newemptycar/bordertransportequipment")
public class BorderTransportEquipmentController extends BaseController {
    @Resource
    private IBorderTransportEquipmentService borderTransportEquipmentService;

    /**
     * 查询托架或拖挂车信息列表
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportequipment:list')")
    @GetMapping(value = "/add/{Lid}")
    public TableDataInfo list(@PathVariable Long Lid) {
        startPage();
        List<BorderTransportEquipment> list = borderTransportEquipmentService.selectBorderTransportEquipmentList(Lid);
        return getDataTable(list);
    }


    /**
     * 获取托架或拖挂车信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportequipment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(borderTransportEquipmentService.selectBorderTransportEquipmentById(id));
    }

    /**
     * 新增托架或拖挂车信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportequipment:add')")
    @Log(title = "托架或拖挂车信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BorderTransportEquipment borderTransportEquipment) {
        if (borderTransportEquipment.getBorderTransportMeansId() == null) {
            return AjaxResult.error("新增失败,请先保存表头信息");
        }
        return toAjax(borderTransportEquipmentService.insertBorderTransportEquipment(borderTransportEquipment));
    }

    /**
     * 修改托架或拖挂车信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportequipment:edit')")
    @Log(title = "托架或拖挂车信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BorderTransportEquipment borderTransportEquipment) {
        return toAjax(borderTransportEquipmentService.updateBorderTransportEquipment(borderTransportEquipment));
    }

    /**
     * 删除托架或拖挂车信息
     */
    @PreAuthorize("@ss.hasPermi('newemptycar:bordertransportequipment:remove')")
    @Log(title = "托架或拖挂车信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(borderTransportEquipmentService.deleteBorderTransportEquipmentByIds(ids));
    }
}
