package com.zzp.e_bike.DTO;

/**
 * 修改密码所用类
 *
 * @author ho
 * @create 2017-07-27 9:04
 */
public class PasswordDTO {
    private String password;
    private String password1;
    private String password2;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
