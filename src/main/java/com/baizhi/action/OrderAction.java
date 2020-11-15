package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;
import com.baizhi.service.OrderService;
import com.baizhi.service.OrderServiceImpl;

public class OrderAction {
    private Order order;
    private List<Order> orders;
    private Address address;
    private OrderService orderService = new OrderServiceImpl();
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String addOrder(){
		System.out.println("---------");
		System.out.println(address);
		orderService.addOrder(address);
		return"addOrderOk";
	}
	public String queryAllOrder(){
		orders = orderService.queryAllOrder();
		return"queryAllOrderOk";
	}
}
