package com.zzp.e_bike.mapper;

import com.zzp.e_bike.pojo.Bike;

import java.util.List;

/**
 * 用于储存电动车的类型
 *
 * @author ho
 * @create 2017-07-19 18:07
 */
public interface BikeMapper {
    List<Bike> get(String str);
    int add(Bike bike);
    int delete(int id);
    int set(Bike bike);
    String getBike(int bikeId);
}
