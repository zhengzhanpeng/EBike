package com.zzp.e_bike.controller;

import com.zzp.e_bike.mapper.AddressMapper;
import com.zzp.e_bike.pojo.Address;
import com.zzp.e_bike.pojo.Bike;
import com.zzp.e_bike.util.ReturnMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 管理地址
 *
 * @author ho
 * @create 2017-07-26 17:40
 */
@Controller
public class AddressController {

    private AddressMapper addressMapper;

    @RequestMapping("/address")
    public ModelAndView getAddress() {
        List<Address> list = addressMapper.getAddress();
        ModelAndView mav = new ModelAndView("address");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping("/setAddress")
    @ResponseBody
    public String setBike(Address address) {
        System.out.println(address.getAddressName());
        addressMapper.setAddress(address);
        return ReturnMessage.TRUE;
    }

    @RequestMapping("/addAddress")
    @ResponseBody
    public String addBike(Address address) {
        addressMapper.addAddress(address);
        return ReturnMessage.TRUE;
    }

    @RequestMapping("/deleteAddress")
    @ResponseBody
    public String deleteBike(int addressId) {
        addressMapper.deleteAddress(addressId);
        return ReturnMessage.TRUE;
    }

    @Resource
    public void setAddressMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }
}
