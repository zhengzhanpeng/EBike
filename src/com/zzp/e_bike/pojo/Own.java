package com.zzp.e_bike.pojo;

import java.util.Date;

/**
 * 电动车欠账主类
 *
 * @author ho
 * @create 2017-07-18 16:40
 */
public class Own {
    private int id;
    private int bikeId;
    private int colorId;
    private int addressId;
    private String name;
    private String phone;
    private int money;
    private int deleteState;
    private String remark;
    private Date sellDate;
    private String sellDateStr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

    public String getSellDateStr() {
        return sellDateStr;
    }

    public void setSellDateStr(String sellDateStr) {
        this.sellDateStr = sellDateStr;
    }

    public int getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(int deleteState) {
        this.deleteState = deleteState;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
}
