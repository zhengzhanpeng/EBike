package com.zzp.e_bike.controller;

import com.zzp.e_bike.mapper.ColorMapper;
import com.zzp.e_bike.pojo.Color;
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
public class ColorController {

    private ColorMapper colorMapper;

    @RequestMapping("/color")
    public ModelAndView getColor() {
        List<Color> list = colorMapper.get(null);
        ModelAndView mav = new ModelAndView("color");
        mav.addObject("colorList", list);
        return mav;
    }

    @RequestMapping("/setColor")
    @ResponseBody
    public String setColor(Color color) {
        colorMapper.set(color);
        return ReturnMessage.TRUE;
    }

    @RequestMapping("/addColor")
    @ResponseBody
    public String addColor(Color color) {
        colorMapper.add(color);
        return ReturnMessage.TRUE;
    }

    @RequestMapping("/deleteColor")
    @ResponseBody
    public String deleteColor(int colorId) {
        colorMapper.delete(colorId);
        return ReturnMessage.TRUE;
    }

    @Resource
    public void setColorMapper(ColorMapper colorMapper) {
        this.colorMapper = colorMapper;
    }
}
