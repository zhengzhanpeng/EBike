package com.zzp.e_bike.pojo;

/**
 * 用来保存电动车的型号
 *
 * @author ho
 * @create 2017-07-18 17:36
 */
public class Bike {
    private int id;
    private String bikeType;

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
}
