package com.zzp.e_bike.controller;

import com.zzp.e_bike.mapper.BikeMapper;
import com.zzp.e_bike.pojo.Bike;
import com.zzp.e_bike.util.ReturnMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 车型控制类
 *
 * @author ho
 * @create 2017-07-26 17:08
 */
@Controller
public class BikeController {

    private BikeMapper bikeMapper;

    @RequestMapping("/bike")
    public ModelAndView getBike() {
        List<Bike> list = bikeMapper.get(null);
        ModelAndView mav = new ModelAndView("bike");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping("/setBike")
    @ResponseBody
    public String setBike(Bike bike) {
        System.out.println(bike.getBikeType());
        bikeMapper.set(bike);
        return ReturnMessage.TRUE;
    }

    @RequestMapping("/addBike")
    @ResponseBody
    public String addBike(Bike bike) {
        bikeMapper.add(bike);
        return ReturnMessage.TRUE;
    }

    @RequestMapping("/deleteBike")
    @ResponseBody
    public String deleteBike(int bikeId) {
        bikeMapper.delete(bikeId);
        return ReturnMessage.TRUE;
    }

    @Resource
    public void setBikeMapper(BikeMapper bikeMapper) {
        this.bikeMapper = bikeMapper;
    }
}
