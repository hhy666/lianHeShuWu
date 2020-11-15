package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Order;

public interface OrderDao {
    public List<Order> selectAllOrder();
    public void insertOrder(Order order);
    public Order selectOneOrder(String orderId);
}
