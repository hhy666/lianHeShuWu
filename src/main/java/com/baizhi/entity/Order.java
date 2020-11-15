package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
    private String orderId;
    private String orderNo;
    private Double total;
    private Date createDate;
    private String status;
    private String addressId;
    private String userId;
    private Address address;
	public Order() {
		super();
	}
	public Order(String orderId, String orderNo, Double total, Date createDate,
			String status, String addressId, String userId, Address address) {
		super();
		this.orderId = orderId;
		this.orderNo = orderNo;
		this.total = total;
		this.createDate = createDate;
		this.status = status;
		this.addressId = addressId;
		this.userId = userId;
		this.address = address;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNo=" + orderNo
				+ ", total=" + total + ", createDate=" + createDate
				+ ", status=" + status + ", addressId=" + addressId
				+ ", userId=" + userId + ", address=" + address + "]";
	}
	
}