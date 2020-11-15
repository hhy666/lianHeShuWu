package com.baizhi.service;

import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;


public interface CartService {
     public void registCart(String bookId);
     public void updateCart(String bookId,Integer count);
     public void deleteCart(String bookId);
}
