package com.baizhi.entity;

import java.io.Serializable;
import java.util.Map;

public class Cart implements Serializable {
    private String cartId;
    private Map<String, CartItem> cartItems;
    private Double savePrice;
    private Double totalPrice;
	public Cart() {
		super();
	}
	public Cart(String cartId, Map<String, CartItem> cartItems,
			Double savePrice, Double totalPrice) {
		super();
		this.cartId = cartId;
		this.cartItems = cartItems;
		this.savePrice = savePrice;
		this.totalPrice = totalPrice;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public Double getSavePrice() {
		return savePrice;
	}
	public void setSavePrice(Double savePrice) {
		this.savePrice = savePrice;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", cartItems=" + cartItems
				+ ", savePrice=" + savePrice + ", totalPrice=" + totalPrice
				+ "]";
	}
	
}
