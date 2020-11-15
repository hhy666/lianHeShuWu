package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import com.baizhi.service.AddressServiceImpl;

public class AddressAction {
	private List<Address> addresses;
	private Address address;
	private String addressId;
	private AddressService addressService = new AddressServiceImpl();
	
    public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
    
	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
    
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String queryAllByUser(){
		//调用service获取全部用户下的地址
		addresses = addressService.queryAllByUser();
    	return "queryAllByUserOk";
    }
	public String queryOne(){
		address = addressService.queryOne(addressId);
		addresses = addressService.queryAllByUser();
		return"queryOneOk";
	}
	/*public String addAddress(){
		addressService.addAddress(address);
		return"addAddressOk";
	}*/
}
