package com.ruoyi.stations_management.waybill.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description:
 * @author: start
 * @created: 2020/03/11 14:03
 */
@ApiModel("Waybill")
public class Waybill {
    @ApiModelProperty("head")
    private WaybillHead head;

    @ApiModelProperty("body")
    private WaybillBody body;

    public WaybillHead getHead() {
        return head;
    }

    public void setHead(WaybillHead head) {
        this.head = head;
    }

    public WaybillBody getBody() {
        return body;
    }

    public void setBody(WaybillBody body) {
        this.body = body;
    }
}
