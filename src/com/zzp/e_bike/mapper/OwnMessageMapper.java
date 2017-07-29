package com.zzp.e_bike.mapper;

import com.zzp.e_bike.pojo.OwnMessage;

import java.util.List;

/**
 * @author ho
 * @create 2017-07-18 18:02
 */
public interface OwnMessageMapper {
    List<OwnMessage> get(int ownId);
    int add(OwnMessage om);
}
