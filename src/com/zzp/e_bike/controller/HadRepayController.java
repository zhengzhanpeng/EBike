package com.zzp.e_bike.controller;

import com.zzp.e_bike.DTO.OwnUnique;
import com.zzp.e_bike.mapper.AddressMapper;
import com.zzp.e_bike.mapper.BikeMapper;
import com.zzp.e_bike.mapper.OwnMapper;
import com.zzp.e_bike.mapper.OwnMessageMapper;
import com.zzp.e_bike.pojo.Own;
import com.zzp.e_bike.util.ReturnMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
 * 已经还清的账单
 *
 * @author ho
 * @create 2017-07-26 13:29
 */
@Controller
public class HadRepayController {
    private OwnMapper ownMapper;
    private BikeMapper bikeMapper;
    private AddressMapper addressMapper;
    private OwnMessageMapper ownMessageMapper;

    @RequestMapping("/hadRepay")
    public ModelAndView own(@ModelAttribute("str") String str, @ModelAttribute("order") String order) {
        ModelAndView mav = new ModelAndView("hadRepay");
        if ((str == null || str.equals("")) && (order == null || order.equals(""))) {
            List<OwnUnique> list = ownMapper.getOwns(null, null, 1);
            mav.addObject("list", list);
        }
        return mav;
    }

    @RequestMapping("/{str}/searchHadRepay")
    public String search(@PathVariable("str") String str, RedirectAttributes redirectAttributes) {
        List<OwnUnique> list = ownMapper.getOwns(str, null, 1);
        redirectAttributes.addFlashAttribute("list", list);
        redirectAttributes.addFlashAttribute("str", str);
        return "redirect:/hadRepay.do";
    }

    @RequestMapping("/deleteHadRepay")
    @ResponseBody
    public String delete(Integer ownId) {
        int result = ownMapper.delete(ownId);
        if (result == 0) {
            return ReturnMessage.USER_NOT_EXISTS;
        }
        return ReturnMessage.TRUE;
    }

    @RequestMapping(value = "/setHadRepay", method = RequestMethod.POST)
    @ResponseBody
    public String setOwn(Own own) {
        ownMapper.setOwn(own);
        return ReturnMessage.TRUE;
    }

    @RequestMapping("/{order}/orderHadRepay")
    public String selectOwnUnique(@PathVariable("order") Integer order, RedirectAttributes redirectAttributes) {
        List<OwnUnique> list = ownMapper.getOwns(null, order, 1);
        redirectAttributes.addFlashAttribute("list", list);
        redirectAttributes.addFlashAttribute("order", order);
        return "redirect:/hadRepay.do";
    }

    @RequestMapping("/{order}/{str}/orderHadRepay")
    public String selectOwnUnique(@PathVariable("str") String str, @PathVariable("order") Integer order, RedirectAttributes redirectAttributes) {
        List<OwnUnique> list = ownMapper.getOwns(str, order, 1);
        redirectAttributes.addFlashAttribute("list", list);
        redirectAttributes.addFlashAttribute("str", str);
        redirectAttributes.addFlashAttribute("order", order);
        return "redirect:/hadRepay.do";
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
}
