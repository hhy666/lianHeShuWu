package com.baizhi.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;
import com.baizhi.util.MybatisUtils;

public class CartServiceImpl implements CartService {

	@Override
	public void registCart(String bookId) {
		try {
			//获得购物车session
			HttpServletRequest request = ServletActionContext .getRequest();
			HttpSession session = request.getSession();
			Cart cart = (Cart)session.getAttribute("cart");
			//判断当前session中是否有购物车实体
			
			if(cart == null){
				//如果为空,说明没有购物车实体
				//添加第一本书创建新购物项,添加进购物车实体map集合
				Cart cart2 = new Cart();
				Map<String, CartItem> cartItems = new HashMap<String,CartItem>();
				CartItem cartItem = new CartItem();
				BookDao bookDao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
				Book book = bookDao.queryBookById(bookId);
				cartItem.setCartItemId(bookId);
				cartItem.setBook(book);
				cartItem.setCount(1);
				cartItem.setSum(book.getDprice());
				cartItems.put(bookId, cartItem);
				cart2.setCartItems(cartItems);
				Cart calculate = calculate(cart2);
				 //装进session中
				ServletActionContext.getRequest().getSession().setAttribute("cart", calculate);
				
			}else{
				//如果有,说明已经不是第一次创建,需要判断当前添加的图书是否在订单里
				Map<String,CartItem> cartItems = cart.getCartItems();
				CartItem cartItem = cartItems.get(bookId);
				if(cartItem == null){
				//说明没有图书 创建新购物项,添加进map集合
				CartItem cartItem1 = new CartItem();
			    BookDao bookDao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
			    Book book = bookDao.queryBookById(bookId);
			    cartItem1.setCartItemId(bookId);
			    cartItem1.setBook(book);
			    cartItem1.setCount(1);
			    cartItem1.setSum(book.getDprice());
			    cartItems.put(bookId, cartItem1);
			    cart.setCartItems(cartItems);
			    Cart calculate = calculate(cart);
			    //装进session中
			    ServletActionContext.getRequest().getSession().setAttribute("cart", calculate);	
				}else{
				    //说明当前有书,添加过这本书,数量+1
				    cartItem.setCount(cartItem.getCount()+1);
				    cartItem.setSum(cartItem.getCount()*cartItem.getBook().getDprice());
				    cartItems.put(bookId, cartItem);
				    cart.setCartItems(cartItems);
				    Cart calculate = calculate(cart);
				    //装进session中
				    ServletActionContext.getRequest().getSession()
				    .setAttribute("cart", calculate);
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			MybatisUtils.rollback();
		}
	}
    //计算一共和节省
	public Cart calculate(Cart cart){
		Double savePrice = 0.0;
		Double totalPrice = 0.0;
		Map<String, CartItem> cartItems = cart.getCartItems();
		Set<String> keySet = cartItems.keySet();
		for (String string : keySet) {
			CartItem cartItem = cartItems.get(string);
			savePrice+=(cartItem.getBook().getPrice()-cartItem.getBook()
					.getDprice())*cartItem.getCount();
			totalPrice+=cartItem.getBook().getDprice()*cartItem.getCount();
		}
		cart.setSavePrice(savePrice);
		cart.setTotalPrice(totalPrice);
		return cart;
	}
	@Override
	public void updateCart(String bookId,Integer count) {
		 try {
			//获得购物车
			 Cart cart =(Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");	
			 //获得购物项集合
			 Map<String, CartItem> cartItems = cart.getCartItems();
			 //获得指定购物项
			 CartItem cartItem = cartItems.get(bookId);
			 //更改数量
			 cartItem.setCount(count);
			 //更改小计
			 cartItem.setSum(cartItem.getCount()*cartItem.getBook().getDprice());
			 cartItems.put(bookId, cartItem);
			 cart.setCartItems(cartItems);
			 //计算节省与总价
			 Cart calculate = calculate(cart);
			 //装进session
			 ServletActionContext.getRequest().getSession().setAttribute("cart", calculate);
		} catch (Exception e) {
			
			e.printStackTrace();
			MybatisUtils.rollback();
		}
	}

	@Override
	public void deleteCart(String bookId) {
		try {
			Cart cart =(Cart)ServletActionContext.getRequest().getSession()
					.getAttribute("cart");
			Map<String, CartItem> cartItems = cart.getCartItems();
			CartItem cartItem = cartItems.get(bookId);
			cartItems.remove(bookId, cartItem);
			cart.setCartItems(cartItems);
			Cart calculate = calculate(cart);
			ServletActionContext.getRequest().getSession().setAttribute("cart", calculate);
		} catch (Exception e) {
			
			e.printStackTrace();
			MybatisUtils.rollback();
		}
	}

}
