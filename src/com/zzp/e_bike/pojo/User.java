package com.zzp.e_bike.pojo;

/**
 * 用户信息类
 *
 * @author ho
 * @create 2017-07-20 12:11
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String random;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }
}
