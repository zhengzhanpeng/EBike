package com.zzp.e_bike.controller;

import com.zzp.e_bike.mapper.LogMessageMapper;
import com.zzp.e_bike.pojo.LogMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日志
 *
 * @author ho
 * @create 2017-07-27 11:29
 */
@Controller
public class LogMessageController {
    private LogMessageMapper logMessageMapper;

    @RequestMapping("/logMessage")
    public ModelAndView logMessage() {
        ModelAndView mav = new ModelAndView("logMessage");
        List<LogMessage> list = logMessageMapper.get(null);
        mav.addObject("list", list);
        return mav;
    }

    @Resource
    public void setLogMessageMapper(LogMessageMapper logMessageMapper) {
        this.logMessageMapper = logMessageMapper;
    }
}
