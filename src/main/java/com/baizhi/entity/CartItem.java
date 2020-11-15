package com.baizhi.entity;

import java.io.Serializable;

public class CartItem implements Serializable {
    private String cartItemId;
    private Book book;
    private Integer count;
    private Double sum;
	public CartItem() {
		super();
	}
	public CartItem(String cartItemId, Book book, Integer count, Double sum) {
		super();
		this.cartItemId = cartItemId;
		this.book = book;
		this.count = count;
		this.sum = sum;
	}
	public String getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		return "Cartltem [cartItemId=" + cartItemId + ", book=" + book
				+ ", count=" + count + ", sum=" + sum + "]";
	}
	
}
