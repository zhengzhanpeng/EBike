package com.zzp.e_bike.controller;

import com.zzp.e_bike.DTO.PasswordDTO;
import com.zzp.e_bike.mapper.UserMapper;
import com.zzp.e_bike.pojo.User;
import com.zzp.e_bike.util.EncryptionUtil;
import com.zzp.e_bike.util.ReturnMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 密码Controller
 *
 * @author ho
 * @create 2017-07-27 9:01
 */
@Controller
@SessionAttributes("userId")
public class PasswordController {

    private UserMapper userMapper;

    @RequestMapping(value = "/setPassword", method = RequestMethod.GET)
    public String setPassword() {
        return "setPassword";
    }

    @RequestMapping(value = "/setPassword", method = RequestMethod.POST)
    @ResponseBody
    public String setPassword(PasswordDTO passwordDTO, @ModelAttribute("userId") int userId) {
        if (!passwordDTO.getPassword1().equals(passwordDTO.getPassword2())) {
            return ReturnMessage.PASSWORD_NOT_SAME;
        }
        User user = userMapper.get(null, userId);
        passwordDTO.setPassword(EncryptionUtil.getHash(passwordDTO.getPassword() + user.getRandom(), "MD5"));
        if (!user.getPassword().equals(passwordDTO.getPassword())) {
            return ReturnMessage.PASSWORD_WRONG;
        }
        user.setPassword(EncryptionUtil.getHash(passwordDTO.getPassword1() + user.getRandom(), "MD5"));
        user.setRandom(null);
        user.setUserName(null);
        userMapper.set(user);
        return ReturnMessage.TRUE;
    }

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
