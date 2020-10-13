package com.ruoyi.stations_management.index.domain;

import java.io.Serializable;

public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;
    private String licenseNo;
    private String inoutTime;

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getInoutTime() {
        return inoutTime;
    }

    public void setInoutTime(String inoutTime) {
        this.inoutTime = inoutTime;
    }
}
