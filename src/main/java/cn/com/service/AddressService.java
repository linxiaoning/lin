package cn.com.service;

import java.util.List;

import cn.com.bean.Address;
import cn.com.dao.AddressMapper;
import cn.com.service.IAddressService;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AddressService implements IAddressService {

	@Resource
	private AddressMapper addressMapper;
	public List<Address> selectAddress() {
		return addressMapper.selectAddress();
	}

	public Address selectAddressByID(Short id) {
		return addressMapper.selectAddressByID(id);
	}


}
