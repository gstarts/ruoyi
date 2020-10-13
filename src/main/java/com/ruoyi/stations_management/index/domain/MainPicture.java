package com.ruoyi.stations_management.index.domain;

import java.io.Serializable;

public class MainPicture implements Serializable {
    private static final long serialVersionUID = 1L;
    private String hour;
    private int freightVehicle;
    private int administrativeVehicle;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getFreightVehicle() {
        return freightVehicle;
    }

    public void setFreightVehicle(int freightVehicle) {
        this.freightVehicle = freightVehicle;
    }

    public int getAdministrativeVehicle() {
        return administrativeVehicle;
    }

    public void setAdministrativeVehicle(int administrativeVehicle) {
        this.administrativeVehicle = administrativeVehicle;
    }
}
