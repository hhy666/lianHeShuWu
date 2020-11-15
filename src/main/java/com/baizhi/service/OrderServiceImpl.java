package com.baizhi.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.dao.BookDao;
import com.baizhi.dao.ItemDao;
import com.baizhi.dao.OrderDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.Book;
import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtils;
import com.baizhi.util.SnowFlake;

public class OrderServiceImpl implements OrderService {

	@Override
	public void addOrder(Address address) {
		System.out.println("+++++++++");
		System.out.println(address);
		try {
			User user =(User)ServletActionContext.getRequest().getSession().getAttribute("user");
			AddressDao addressDao = MybatisUtils.getSqlSession().getMapper(AddressDao.class);
			ItemDao itemDao = MybatisUtils.getSqlSession().getMapper(ItemDao.class);
			OrderDao orderDao = MybatisUtils.getSqlSession().getMapper(OrderDao.class);
			BookDao bookDao = MybatisUtils.getSqlSession().getMapper(BookDao.class);
			Book book =(Book)ServletActionContext.getRequest().getSession().getAttribute("book");
			List<Address> addresses = addressDao.selectAllByUser(user.getUserId());
			String id = UUID.randomUUID().toString();
			//判断是新地址还是旧地址
			if(addresses.size() == 0){
			//新地址直接入库
				address.setAddressId(id);
				address.setUserId(user.getUserId());
				addressDao.insertAddress(address);
			}else{
				// 判断新地址
				if(address.getAddressId().length()<10){
			    	address.setAddressId(id);
			    	address.setUserId(user.getUserId());
			    	addressDao.insertAddress(address);
				}else{
			    	//是旧地址,判断当前旧地址是否被更改
			    	for (Address address1 : addresses) {
						if(!address1.equals(address)){
							//修改了
							
							String i = address.getAddressId().substring(0,36);
							System.out.println(address.getAddressId()+"--------++++++++++++=");
							address.setAddressId(i);
							addressDao.updateAddress(address);
					    }   
			    	}
				}
			}
 	  //订单入库
			Order order = new  Order();
			order.setAddressId(address.getAddressId());
			System.out.println(address.getAddressId());
			order.setOrderId(UUID.randomUUID().toString());
			order.setUserId(user.getUserId());
			order.setOrderNo(new SnowFlake().getId());
			order.setCreateDate(new Date());
			order.setStatus("未付款");
			Cart cart =(Cart)ServletActionContext.getRequest().getSession().getAttribute("cart");
			order.setTotal(cart.getTotalPrice());
			orderDao.insertOrder(order);
			//订单项入库
			Item item = new Item();
			Map<String, CartItem> cartItems = cart.getCartItems();
			Set<String> keySet = cartItems.keySet();
			for (String string : keySet) {
				item.setItemId(UUID.randomUUID().toString());
			    item.setBookId(cartItems.get(string).getBook().getBookId());
			    item.setCount(cartItems.get(string).getCount());
			    item.setCreateDate(new Date());
			    item.setOrderId(order.getOrderId());
			    itemDao.insertItem(item);
			    book=cartItems.get(string).getBook();
				book.setAle(cartItems.get(string).getBook().getAle()+cartItems.get(string).getCount());
				book.setStock(cartItems.get(string).getBook().getStock()-cartItems.get(string).getCount());
				bookDao.updateBook(book);

			}
			MybatisUtils.commit();	
			//清除购物车session
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("order", order);
			session.getAttribute("cart");
			session.removeAttribute("cart");
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtils.rollback();
		}
		
	}
    
	@Override
	public List<Order> queryAllOrder() {
		OrderDao orderDao = MybatisUtils.getSqlSession().getMapper(OrderDao.class);
		List<Order> selectAllOrder = orderDao.selectAllOrder();
		MybatisUtils.close();
		return selectAllOrder;
	}

	@Override
	public Order queryOneOrder(String orderId) {
		OrderDao orderDao = MybatisUtils.getSqlSession().getMapper(OrderDao.class);
		Order selectOneOrder = orderDao.selectOneOrder(orderId);
		MybatisUtils.close();
		return selectOneOrder;
	}
 
}
