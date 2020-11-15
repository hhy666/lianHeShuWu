package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
    public List<Address> queryAllByUser();
    public Address queryOne(String addressId);
    //public void addAddress(Address address);
}
