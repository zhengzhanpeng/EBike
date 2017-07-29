package com.zzp.e_bike.mapper;

import com.zzp.e_bike.pojo.OwnMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ho on 2017/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OwnMessageMapperTest {
    
    @Resource
    private OwnMessageMapper ownMessageMapper;
    
    @Test
    public void getOwnMessage() throws Exception {
        List<OwnMessage> list = ownMessageMapper.get(1);
        System.out.println("");
    }

}