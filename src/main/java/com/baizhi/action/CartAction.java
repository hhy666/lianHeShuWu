package com.baizhi.action;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Cart;
import com.baizhi.service.CartService;
import com.baizhi.service.CartServiceImpl;

public class CartAction {
    private String bookId;
    private Integer count;
    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	private CartService cartService = new CartServiceImpl();
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String addCart(){
		cartService.registCart(bookId);
		return"addCartOk";
	}
	public String updateCart(){
		cartService.updateCart(bookId, count);
		return"updateCartOk";
	}
	public String deleteCart(){
		cartService.deleteCart(bookId);
		Cart cart =(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart.getCartItems().size() == 0){
		    ServletActionContext.getRequest().getSession().removeAttribute("cart");
		}
		return"deleteCartOk";
	}
}
