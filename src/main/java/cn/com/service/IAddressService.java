package cn.com.service;

import java.util.List;

import cn.com.bean.Address;

public interface IAddressService {
	public List<Address> selectAddress();
	
	public Address selectAddressByID(Short id);
}
