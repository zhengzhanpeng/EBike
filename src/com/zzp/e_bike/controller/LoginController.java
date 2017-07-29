package com.zzp.e_bike.controller;

import com.zzp.e_bike.mapper.UserMapper;
import com.zzp.e_bike.pojo.User;
import com.zzp.e_bike.util.EncryptionUtil;
import com.zzp.e_bike.util.ReturnMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;

/**
 * 用户登录service
 *
 * @author ho
 * @create 2017-07-20 9:11
 */
@Controller
@SessionAttributes("userId")
public class LoginController {

    private UserMapper userMapper;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String checkUser(User user, ModelMap m) {
        User userOrder = userMapper.get(user.getUserName(), null);
        if(userOrder == null) {
            return ReturnMessage.USER_NOT_EXISTS;
        }
        String str = user.getPassword() + userOrder.getRandom();
        user.setPassword(EncryptionUtil.getHash(str, "MD5"));
        if(!user.getPassword().equals(userOrder.getPassword())) {
            return ReturnMessage.PASSWORD_WRONG;
        }
        m.addAttribute("userId", userOrder.getId());
        return ReturnMessage.TRUE;
    }

    @RequestMapping("/exit")
    public String exit(ModelMap m) {
        m.addAttribute("userId", 0);
        return "redirect:login.do";
    }
    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
