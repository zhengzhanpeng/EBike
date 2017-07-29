package com.zzp.e_bike.mapper;

import com.zzp.e_bike.pojo.Address;

import java.util.List;

/**
 * 管理欠账的用户的地址的mapper
 *
 * @author ho
 * @create 2017-07-19 17:56
 */
public interface AddressMapper {
    List<Address> getAddress();
    int deleteAddress(int id);
    int setAddress(Address address);
    int addAddress(Address address);
    String getAdd(int addressId);
}
