package com.zzp.e_bike.controller;

import com.zzp.e_bike.DTO.OwnUnique;
import com.zzp.e_bike.mapper.*;
import com.zzp.e_bike.pojo.*;
import com.zzp.e_bike.util.ReturnMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 控制欠账管理的service
 *
 * @author ho
 * @create 2017-07-20 8:57
 */
@Controller
public class OwnController {

    private OwnMapper ownMapper;
    private BikeMapper bikeMapper;
    private AddressMapper addressMapper;
    private OwnMessageMapper ownMessageMapper;
    private LogMessageMapper logMessageMapper;
    private ColorMapper colorMapper;

    @RequestMapping("/own")
    public ModelAndView own(@ModelAttribute("str") String str, @ModelAttribute("order") String order) {
        ModelAndView mav = new ModelAndView("own");
        if ((str == null || str.equals("")) && (order == null || order.equals(""))) {
            List<OwnUnique> list = ownMapper.getOwns(null, null, 0);
            mav.addObject("list", list);
        }
        return mav;
    }

    @RequestMapping("/{str}/searchOwn")
    public String search(@PathVariable("str") String str, RedirectAttributes redirectAttributes) {
        List<OwnUnique> list = ownMapper.getOwns(str, null, 0);
        redirectAttributes.addFlashAttribute("list", list);
        redirectAttributes.addFlashAttribute("str", str);
        return "redirect:/own.do";
    }

    @RequestMapping(value = "/addOwn", method = RequestMethod.POST)
    @ResponseBody
    public String addOwn(Own own) {
        ownMapper.addOwn(own);
        StringBuffer sb = new StringBuffer();
        String str = "  ";
        String address = addressMapper.getAdd(own.getAddressId());
        String bike = bikeMapper.getBike(own.getBikeId());
        String color = colorMapper.getColor(own.getColorId());
        sb.append("添加欠款:").append(own.getName()).append(str).append(bike).append(str).append(color).append(str).append(own.getMoney()).append(str).append(address);
        LogMessage logMessage = new LogMessage();
        logMessage.setContent(sb.toString());
        logMessage.setSetDate(new Date());
        logMessageMapper.add(logMessage);
        return ReturnMessage.TRUE;
    }

    @RequestMapping("/deleteOwn")
    @ResponseBody
    public String delete(Integer ownId) {
        int result = ownMapper.delete(ownId);
        if (result == 0) {
            return ReturnMessage.USER_NOT_EXISTS;
        }
        Own own = ownMapper.getOwn(ownId);
        StringBuffer sb = new StringBuffer();
        String str = "  ";
        String address = addressMapper.getAdd(own.getAddressId());
        String bike = bikeMapper.getBike(own.getBikeId());
        String color = colorMapper.getColor(own.getColorId());
        sb.append("删除欠款：").append(own.getName()).append(str).append(bike).append(str).append(color).append(str).append(own.getMoney()).append(str).append(address);
        LogMessage logMessage = new LogMessage();
        logMessage.setContent(sb.toString());
        logMessage.setSetDate(new Date());
        logMessageMapper.add(logMessage);
        return ReturnMessage.TRUE;
    }

    @RequestMapping(value = "/setOwn", method = RequestMethod.POST)
    @ResponseBody
    public String setOwn(Own own) {
        Own ownBefore = ownMapper.getOwn(own.getId());
        String addressBefore = addressMapper.getAdd(ownBefore.getAddressId());
        StringBuffer sb = new StringBuffer();
        String str = "：";
        String str2 = "、";
        boolean b = false;
        sb.append("信息修改：").append(addressBefore).append("的")
                .append(ownBefore.getName()).append("<br>");
        sb.append("修改内容：");
        if (!own.getName().equals(ownBefore.getName())) {
            sb.append(ownBefore.getName()).append(str).append(own.getName()).append(str2);
            b = true;
        }
        if (own.getMoney() != ownBefore.getMoney()) {
            sb.append(ownBefore.getMoney()).append(str).append(own.getMoney()).append(str2);
            b = true;
        }
        if (own.getAddressId() != ownBefore.getAddressId()) {
            String address = addressMapper.getAdd(own.getAddressId());
            sb.append(addressBefore).append(str).append(address).append(str2);
            b = true;
        }
        if (own.getBikeId() != ownBefore.getBikeId()) {
            String bikeBefore = bikeMapper.getBike(ownBefore.getBikeId());
            String bike = bikeMapper.getBike(own.getBikeId());
            sb.append(bikeBefore).append(str).append(bike).append(str2);
            b = true;
        }
        if (own.getColorId() != ownBefore.getColorId()) {
            String colorBefore = colorMapper.getColor(ownBefore.getColorId());
            String color = colorMapper.getColor(own.getColorId());
            sb.append(colorBefore).append(str).append(color).append(str2);
            b = true;
        }
        if (!own.getRemark().equals(ownBefore.getRemark()) && !(own.getRemark().equals("") && ownBefore.getRemark() ==null )) {
            sb.append(ownBefore.getRemark()).append(str).append(own.getRemark()).append(str2);
            b = true;
        }
        if (!own.getPhone().equals(ownBefore.getPhone())) {
            sb.append(ownBefore.getPhone()).append(str).append(own.getPhone()).append(str2);
            b = true;
        }
        if (b) {
            LogMessage logMessage = new LogMessage();
            logMessage.setContent(sb.toString());
            logMessage.setSetDate(new Date());
            logMessageMapper.add(logMessage);
            ownMapper.setOwn(own);
        }
        return ReturnMessage.TRUE;
    }

    @RequestMapping("/{order}/orderOwn")
    public String selectOwnUnique(@PathVariable("order") Integer order, RedirectAttributes redirectAttributes) {
        List<OwnUnique> list = ownMapper.getOwns(null, order, 0);
        redirectAttributes.addFlashAttribute("list", list);
        redirectAttributes.addFlashAttribute("order", order);
        return "redirect:/own.do";
    }

    @RequestMapping("/{order}/{str}/orderOwn")
    public String selectOwnUnique(@PathVariable("str") String str, @PathVariable("order") Integer order, RedirectAttributes redirectAttributes) {
        List<OwnUnique> list = ownMapper.getOwns(str, order, 0);
        redirectAttributes.addFlashAttribute("list", list);
        redirectAttributes.addFlashAttribute("str", str);
        redirectAttributes.addFlashAttribute("order", order);
        return "redirect:/own.do";
    }

    @RequestMapping("/updateModel")
    public ModelAndView getUpdateModel() {
        ModelAndView mav = new ModelAndView("updateModel");
        List<Address> addressList = addressMapper.getAddress();
        List<Bike> bikeList = bikeMapper.get(null);
        List<Color> colorList = colorMapper.get(null);
        mav.addObject("addressList", addressList);
        mav.addObject("bikeList", bikeList);
        mav.addObject("colorList", colorList);
        return mav;
    }

    @RequestMapping(value = "/addOwnMessage", method = RequestMethod.POST)
    @ResponseBody
    public synchronized String addOwnMessage(OwnMessage ownMessage) {
        int result1 = ownMessageMapper.add(ownMessage);
        int result2 = ownMapper.repayMoney(ownMessage.getOwnId(), ownMessage.getMoney());
        Own own = ownMapper.getOwn(ownMessage.getOwnId());
        StringBuffer sb = new StringBuffer();
        String str = "  ";
        String address = addressMapper.getAdd(own.getAddressId());
        String bike = bikeMapper.getBike(own.getBikeId());
        String color = colorMapper.getColor(own.getColorId());
        sb.append("欠账人还款：").append(address).append(str).append(own.getName()).append("还钱").append(ownMessage.getMoney())
                .append("。<br>车型：").append(bike).append(" ").append(color).append("<br>备注：").append(ownMessage.getRemark());
        LogMessage logMessage = new LogMessage();
        logMessage.setContent(sb.toString());
        logMessage.setSetDate(new Date());
        logMessageMapper.add(logMessage);
        return ReturnMessage.TRUE;
    }

    @Resource
    public void setOwnMapper(OwnMapper ownMapper) {
        this.ownMapper = ownMapper;
    }
    @Resource
    public void setBikeMapper(BikeMapper bikeMapper) {
        this.bikeMapper = bikeMapper;
    }
    @Resource
    public void setAddressMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }
    @Resource
    public void setOwnMessageMapper(OwnMessageMapper ownMessageMapper) {
        this.ownMessageMapper = ownMessageMapper;
    }
    @Resource
    public void setLogMessageMapper(LogMessageMapper logMessageMapper) {
        this.logMessageMapper = logMessageMapper;
    }
    @Resource
    public void setColorMapper(ColorMapper colorMapper) {
        this.colorMapper = colorMapper;
    }
}
