package com.zzp.e_bike.mapper;

import com.zzp.e_bike.DTO.OwnUnique;
import com.zzp.e_bike.controller.OwnController;
import com.zzp.e_bike.mapper.OwnMapper;
import com.zzp.e_bike.pojo.Own;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ho
 * @create 2017-07-19 9:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OwnMapperTest {

    @Resource
    private OwnMapper ownMapper;

    @Test
    public void testOwnMapper() {
        OwnController controller = new OwnController();
        controller.addOwn(new Own());
    }
}
