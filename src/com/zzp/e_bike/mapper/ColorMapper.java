package com.zzp.e_bike.mapper;

import com.zzp.e_bike.pojo.Color;

import java.util.List;

/**
 * 用于储存电动车的类型
 *
 * @author ho
 * @create 2017-07-19 18:07
 */
public interface ColorMapper {
    List<Color> get(String str);
    int add(Color color);
    int delete(int id);
    int set(Color color);
    String getColor(int colorId);
}
