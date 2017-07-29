package com.zzp.e_bike.pojo;

import java.util.Date;

/**
 * 用于保存账单的还款记录
 *
 * @author ho
 * @create 2017-07-18 17:14
 */
public class OwnMessage {
    private int id;
    private int ownId;
    private String remark;
    private int money;
    private Date setDate;
    private String setDateStr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getSetDate() {
        return setDate;
    }

    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }

    public String getSetDateStr() {
        return setDateStr;
    }

    public void setSetDateStr(String setDateStr) {
        this.setDateStr = setDateStr;
    }

    public int getOwnId() {
        return ownId;
    }

    public void setOwnId(int ownId) {
        this.ownId = ownId;
    }
}
