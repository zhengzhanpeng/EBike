package com.zzp.e_bike.pojo;

/**
 * 用于保存周边的地理信息
 *
 * @author ho
 * @create 2017-07-18 17:39
 */
public class Address {
    private int id;
    private String addressName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}
