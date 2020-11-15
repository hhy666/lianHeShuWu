package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Item;

public interface ItemDao {
    public List<Item> selectAllItems(String orderId);
    public void insertItem(Item item);
}
