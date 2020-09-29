package com.ruoyi.stations_management.waybill.controller;

import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.security.service.TokenService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.stations_management.waybill.domain.Waybill;
import com.ruoyi.stations_management.waybill.domain.WaybillBody;
import com.ruoyi.stations_management.waybill.domain.WaybillHead;
import com.ruoyi.stations_management.waybill.service.IWaybillBodyService;
import com.ruoyi.stations_management.waybill.service.IWaybillHeadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提运单申报Controller
 *
 * @author qishuai
 * @date 2020-03-02
 */
@Api("提运单申报")
@RestController
@RequestMapping("/waybill/declare")
public class WaybillController extends BaseController {
    @Autowired
    private IWaybillHeadService sWaybillHeadService;
    @Autowired
    private IWaybillBodyService sWaybillBodyService;
    @Autowired
    private TokenService tokenService;

    /**
     * 查询提运单申报列表
     */
    @ApiOperation("查询提运单申报列表")
    @ApiImplicitParam(name = "waybillHead", value = "查询提运单申报列表", dataType = "WaybillHead")
    @PreAuthorize("@ss.hasPermi('waybill:declare:list')")
    @GetMapping("/head/list")
    public TableDataInfo list(WaybillHead waybillHead) {
        startPage();
        List<WaybillHead> list = sWaybillHeadService.selectSWaybillHeadList(waybillHead);
        return getDataTable(list);
    }

    /**
     * 获取提运单头部申报详细信息
     */
    @ApiOperation("获取提运单头部申报详细信息+")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('waybill:declare:query')")
    @GetMapping(value = "/head/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        WaybillHead head = sWaybillHeadService.selectSWaybillHeadById(id);
        List<WaybillBody> list = sWaybillBodyService.selectSWaybillBodyList(id);
        Map<String, Object> map = new HashMap<>();
        map.put("info", head);
        map.put("rows", list);
        return AjaxResult.success(map);
    }

    /**
     * 新增提运单申报
     */
    @ApiOperation("新增提运单申报")
    @ApiImplicitParam(name = "waybillHead", value = "新增提运单申报", dataType = "WaybillHead")
    @PreAuthorize("@ss.hasPermi('waybill:head:add')")
    @Log(title = "提运单申报", businessType = BusinessType.INSERT)
    @PostMapping("/head")
    public AjaxResult add(@RequestBody WaybillHead waybillHead) {

        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        waybillHead.setCruser(userName);
        // 查询 基础信息是否存在
        WaybillHead head = sWaybillHeadService.selectSWaybillHeadById(waybillHead.getId());

        if (head != null) {
            int updateRows = sWaybillHeadService.updateSWaybillHead(waybillHead);
            if (updateRows > 0) {
                return AjaxResult.success("修改成功");
            } else {
                return AjaxResult.error("修改失败");
            }
        } else {
            int addRows = sWaybillHeadService.insertSWaybillHead(waybillHead);
            if (addRows > 0) {

                return AjaxResult.success("新增成功");
            } else {
                return  AjaxResult.success("新增失败");
            }
        }
    }

    /**
     * 修改提运单申报
     */
    @ApiOperation("修改提运单申报")
    @ApiImplicitParam(name = "waybillHead", value = "修改提运单申报", dataType = "WaybillHead")
    @PreAuthorize("@ss.hasPermi('waybill:head:edit')")
    @Log(title = "提运单申报", businessType = BusinessType.UPDATE)
    @PutMapping("/head")
    public AjaxResult edit(@RequestBody WaybillHead waybillHead) {
        return toAjax(sWaybillHeadService.updateSWaybillHead(waybillHead));
    }

    /**
     * 提运单批量申报
     */
    @ApiOperation("提运单批量申报")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('waybill:declare:declare')")
    @Log(title = "提运单批量申报", businessType = BusinessType.UPDATE)
    @DeleteMapping("/head/{ids}")
    public AjaxResult declaration(@PathVariable Long[] ids) throws JAXBException {
        return toAjax(sWaybillHeadService.decSWaybillHeadByIds(ids));
    }

    /**
     * 查询提运表体列表
     */
    @ApiOperation("查询提运表体列表")
    @ApiImplicitParam(name = "waybillBody", value = "查询提运表体列表", dataType = "WaybillBody")
    @GetMapping("/body/list")
    public TableDataInfo list(WaybillBody waybillBody) {
        startPage();
        List<WaybillBody> list = sWaybillBodyService.selectSWaybillBodyList(waybillBody.getHeadId());
        return getDataTable(list);
    }

    /**
     * 新增提运单表体信息
     */
    @ApiOperation("新增提运单表体信息")
    @ApiImplicitParam(name = "waybillBody", value = "新增提运单表体信息", dataType = "WaybillBody")
    @PreAuthorize("@ss.hasPermi('waybill:body:add')")
    @Log(title = "提运单申报", businessType = BusinessType.INSERT)
    @PostMapping("/body")
    public AjaxResult add(@RequestBody WaybillBody waybillBody) {
        WaybillHead waybillHead = sWaybillHeadService.selectSWaybillHeadById(waybillBody.getHeadId());
        if (waybillHead == null) {
            return AjaxResult.error("请先保存该记录的基础信息");
        }
        int rows = sWaybillBodyService.insertSWaybillBody(waybillBody);
        if (rows == 0) {
            return AjaxResult.error("新增失败");

        } else if (rows == -1) {
            return AjaxResult.error("新增失败,请先添加通关单信息");

        } else if (rows == -2) {
            return AjaxResult.error("新增失败,提货重量大于剩余重量");
        }
        return AjaxResult.success("新增成功");
    }

    /**
     * 修改提运单表体
     */
    @ApiOperation("修改提运单表体")
    @ApiImplicitParam(name = "waybillBody", value = "修改提运单表体", dataType = "WaybillBody")
    @PreAuthorize("@ss.hasPermi('waybill:body:edit')")
    @Log(title = "提运单申报", businessType = BusinessType.UPDATE)
    @PutMapping("/body")
    public AjaxResult edit(@RequestBody WaybillBody waybillBody) {
        return toAjax(sWaybillBodyService.updateSWaybillBody(waybillBody));
    }

    /**
     * 删除提运单申报
     */
    @ApiOperation("删除提运单申报")
    @ApiImplicitParam(name = "ids", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('waybill:body:remove')")
    @Log(title = "提运单申报", businessType = BusinessType.DELETE)
    @DeleteMapping("/body/{ids}")
    public AjaxResult removeBody(@PathVariable Long[] ids) {
        return toAjax(sWaybillBodyService.deleteSWaybillBodyByIds(ids));
    }

    /**
     * 获取提运单体详细信息
     */
    @ApiOperation("获取提运单体详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @GetMapping(value = "/body/{id}")
    public AjaxResult getBodyInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sWaybillBodyService.selectSWaybillBodyById(id));
    }

    /**
     * 新增提运单整体信息
     */
    @ApiOperation("新增提运单整体信息")
    @ApiImplicitParam(name = "waybill", value = "新增提运单整体信息", dataType = "Waybill")
    @PostMapping("/all")
    public AjaxResult addWaybill(@RequestBody Waybill waybill) {

        return AjaxResult.success(sWaybillHeadService.insertSWaybill(waybill));
    }

    /**
     * 删除提运单信息
     */
    @ApiOperation("删除提运单信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    @PreAuthorize("@ss.hasPermi('waybill:declare:remove')")
    @Log(title = "提运单申报删除", businessType = BusinessType.UPDATE)
    @DeleteMapping(value = "/del/{id}")
    public AjaxResult del(@PathVariable("id") Long id) {
        int rows = sWaybillHeadService.deleteSWaybillHeadById(id);
        if (rows == 1) {
            return AjaxResult.success("删除成功");
        } else {
            return AjaxResult.error("删除失败，该记录不可删除");
        }
    }

    /**
     * 初始化页面信息
     *
     * @return 结果
     */
    @GetMapping("/init")
    @ApiOperation("初始化页面信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int", paramType = "path")
    public AjaxResult init() {
        // 获取用户的的场站id
//        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        String stationId = "1";
        WaybillHead head = sWaybillHeadService.init(Long.valueOf(stationId));
        return AjaxResult.success(head);
    }

    /**
     * 根据用户信息查看信息 给货运企业使用
     *
     * @param waybillHead 核放单基础信息
     * @return 结果
     */
    @ApiOperation("根据用户信息查看信息 给货运企业使用")
    @ApiImplicitParam(name = "waybillHead", value = "根据用户信息查看信息 给货运企业使用", dataType = "WaybillHead")
    @PreAuthorize("@ss.hasPermi('waybill:wayview:list')")
    @GetMapping("/waybillList")
    public TableDataInfo getWaybillByUserId(WaybillHead waybillHead) {
        startPage();
        String userName = tokenService.getLoginUser(ServletUtils.getRequest()).getUser().getUserName();
        waybillHead.setCruser(userName);
        List<WaybillHead> list = sWaybillHeadService.selectSWaybillHeadList(waybillHead);
        return getDataTable(list);
    }

    /**
     * 校验车辆是否可以进行录入
     *
     * @param vehicleNo 车牌号
     * @return 校验结果
     */
    @ApiOperation("校验车辆是否可以进行录入")
    @ApiImplicitParam(name = "vehicleNo", value = "车牌号", required = true, dataType = "String", paramType = "path")
    @GetMapping("/check/{vehicleNo}/{headId}")
    public AjaxResult vehicleNoCheck(@PathVariable("vehicleNo") String vehicleNo, @PathVariable("headId") Long headId) {
        return AjaxResult.success(sWaybillHeadService.vehicleNoCheck(vehicleNo, headId));
    }

    /**
     * 驳回操作
     */
    @GetMapping("/reject/{id}/{message}")
    public AjaxResult reject(@PathVariable("id") String id, @PathVariable("message") String message) {
        return AjaxResult.success(sWaybillHeadService.reject(id, message));
    }

    /**
     * 人工办结
     */

    @GetMapping("/artificial/{id}")
    @PreAuthorize("@ss.hasPermi('waybill:declare:artificial')")
    public AjaxResult artificial(@PathVariable("id") String id) {
        return AjaxResult.success(sWaybillHeadService.artificial(id));
    }
}
