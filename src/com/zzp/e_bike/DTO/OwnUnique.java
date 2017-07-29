package com.zzp.e_bike.DTO;

import com.zzp.e_bike.pojo.OwnMessage;

import java.util.Date;
import java.util.List;

/**
 * 联合其他表生成的总的类
 *
 * @author ho
 * @create 2017-07-18 20:11
 */
public class OwnUnique {
    private int id;
    private int bikeId;
    private int colorId;
    private int addressId;
    private String bikeType;
    private String bikeColor;
    private String addressName;
    private List<OwnMessage> ownMessages;
    private String name;
    private String phone;
    private int money;
    private String remark;
    private Date sellDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public List<OwnMessage> getOwnMessages() {
        return ownMessages;
    }

    public void setOwnMessages(List<OwnMessage> ownMessages) {
        this.ownMessages = ownMessages;
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

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getBikeColor() {
        return bikeColor;
    }

    public void setBikeColor(String bikeColor) {
        this.bikeColor = bikeColor;
    }
}
