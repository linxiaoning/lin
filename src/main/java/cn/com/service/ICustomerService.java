package cn.com.service;

import java.util.List;

import cn.com.bean.Customer;

public interface ICustomerService {
	
public Customer SelectCustomer(Customer customer);
	
	public Customer SelectCustomerByID(Short id);
	
	public int SelectAllnumber();
	
	public List<Customer> selectCustomerPage(int page,int j);
	
	public void addCustomer(Customer cus);
	
	public int delete(Short id);
	
	public int updateCustomer(Customer cus);
	
}

