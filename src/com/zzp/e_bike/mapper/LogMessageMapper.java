package com.zzp.e_bike.mapper;

import com.zzp.e_bike.pojo.LogMessage;

import java.util.List;

/**
 * 记录所有的操作信息
 *
 * @author ho
 * @create 2017-07-19 18:20
 */
public interface LogMessageMapper {
    int add(LogMessage logMessage);
    List<LogMessage> get(String str);
}
