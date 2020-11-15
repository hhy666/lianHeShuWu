package com.baizhi.service;

import java.util.List;

import com.baizhi.dao.ItemDao;
import com.baizhi.entity.Item;
import com.baizhi.util.MybatisUtils;

public class ItemServiceImpl implements ItemService {

	@Override
	public List<Item> queryAllItem(String orderId) {
		ItemDao dao = MybatisUtils.getSqlSession().getMapper(ItemDao.class);
		List<Item> selectAllItems = dao.selectAllItems(orderId);
		MybatisUtils.close();
		return selectAllItems;
	}

}
