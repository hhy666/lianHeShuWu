package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.service.ItemService;
import com.baizhi.service.ItemServiceImpl;
import com.baizhi.service.OrderService;
import com.baizhi.service.OrderServiceImpl;

public class ItemAction {
    private List<Item> items;
    private String orderId;
    private Order order;
    private OrderService orderService = new OrderServiceImpl();
    private ItemService itemService = new ItemServiceImpl();
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
    public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String queryAllItem(){
		order = orderService.queryOneOrder(orderId);
    	items = itemService.queryAllItem(orderId);
    	return"queryAllItemOk";
    }
}
