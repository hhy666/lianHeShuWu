package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;

public interface OrderService {
     public void addOrder(Address address);
     public List<Order> queryAllOrder();
     public Order queryOneOrder(String orderId);
}
