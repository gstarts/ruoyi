package com.ruoyi.stations_management.index.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class IndexDao extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private int firstNum;
    private int secondNum;
    private int thirdNum;
    private int fourthNum;

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public int getThirdNum() {
        return thirdNum;
    }

    public void setThirdNum(int thirdNum) {
        this.thirdNum = thirdNum;
    }

    public int getFourthNum() {
        return fourthNum;
    }

    public void setFourthNum(int fourthNum) {
        this.fourthNum = fourthNum;
    }
}
