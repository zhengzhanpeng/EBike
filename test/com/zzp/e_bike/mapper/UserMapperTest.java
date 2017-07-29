package com.zzp.e_bike.mapper;

import com.zzp.e_bike.pojo.User;
import com.zzp.e_bike.util.EncryptionUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by ho on 2017/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserMapperTest {

    private UserMapper userMapper;
    @Test
    public void get() throws Exception {
        User user = userMapper.get("zqb", null);
        System.out.println(user.getPassword());
    }

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setUserName("zxx");
        user.setRandom(EncryptionUtil.getRandom());
        String password = "18231956188";
        password = EncryptionUtil.getHash(password + user.getRandom(), "MD5");
        user.setPassword(password);
        userMapper.add(user);
    }

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}