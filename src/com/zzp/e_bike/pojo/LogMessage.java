package com.zzp.e_bike.pojo;

import java.util.Date;

/**
 * 记录数据增删改查日志
 *
 * @author ho
 * @create 2017-07-18 17:16
 */
public class LogMessage {
    private int id;
    private String content;
    private Date setDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSetDate() {
        return setDate;
    }

    public void setSetDate(Date setDate) {
        this.setDate = setDate;
    }
}
