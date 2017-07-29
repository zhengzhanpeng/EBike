package com.zzp.e_bike.mapper;

import com.zzp.e_bike.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用于管理用户表
 *
 * @author ho
 * @create 2017-07-21 11:17
 */
public interface UserMapper {
    User get(@Param("userName") String userName, @Param("id") Integer id);
    int add(User user);
    int set(User user);
}
