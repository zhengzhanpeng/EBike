package com.zzp.e_bike.DTO;

import java.util.Date;

/**
 * 用于接收前台发送的Own，并转换Data类型
 *
 * @author ho
 * @create 2017-07-25 13:42
 */
public class OwnAccept {
    private int id;
    private int bikeId;
    private int addressId;
    private String name;
    private String phone;
    private int money;
    private String remark;
    private Date sellDate;
}
