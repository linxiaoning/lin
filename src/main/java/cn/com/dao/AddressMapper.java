package cn.com.dao;

import java.util.List;

import cn.com.bean.Address;

public interface AddressMapper {
    
	public List<Address> selectAddress();
	
	public Address selectAddressByID(Short id);
}