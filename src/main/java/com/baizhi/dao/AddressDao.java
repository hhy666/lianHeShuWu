package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressDao {
    public List<Address> selectAllByUser(String userId);
    public Address selectOne(String addressId);
    public void insertAddress(Address address);
    public void updateAddress(Address address);
}
