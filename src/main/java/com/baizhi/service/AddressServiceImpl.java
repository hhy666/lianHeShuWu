package com.baizhi.service;

import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtils;

public class AddressServiceImpl implements AddressService {

	@Override
	public List<Address> queryAllByUser() {
		User user =(User)ServletActionContext.getRequest().getSession().getAttribute("user");
		AddressDao dao = MybatisUtils.getSqlSession().getMapper(AddressDao.class);
		List<Address> selectAllByUser = dao.selectAllByUser(user.getUserId());
		MybatisUtils.close();
		return selectAllByUser;
	}

	@Override
	public Address queryOne(String addressId) {
		AddressDao dao = MybatisUtils.getSqlSession().getMapper(AddressDao.class);
		Address selectOne = dao.selectOne(addressId);
		MybatisUtils.close();
		return selectOne;
	}
	/*@Override
	public void addAddress(Address address) {
		AddressDao dao = MybatisUtils.getSqlSession().getMapper(AddressDao.class);
		if(address.getAddressId()==null || address.getAddressId().equals("")){
			String id = UUID.randomUUID().toString();
			address.setAddressId(id);
			dao.insertAddress(address);
		}else{
			dao.updateAddress(address);
		}
		MybatisUtils.commit();
	}*/
}
