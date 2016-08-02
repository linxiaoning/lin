package cn.com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.bean.Customer;
import cn.com.dao.CustomerMapper;
import cn.com.service.ICustomerService;

@Service
@Transactional
public class CustomerService implements ICustomerService {

	@Resource
	private CustomerMapper customerMapper;

	public Customer SelectCustomer(Customer customer) {
		Customer cus;
		if (customerMapper.SelectCustomer(customer) == null) {
			System.out.println("1");
			cus = null;
		} else {
			System.out.println("2");
			cus = customerMapper.SelectCustomer(customer);
		}
		return cus;
	}

	public Customer SelectCustomerByID(Short id) {
		return customerMapper.SelectCustomerByID(id);
	}

	public int SelectAllnumber() {
		return customerMapper.SelectAllnumber();
	}

	public List<Customer> selectCustomerPage(int page, int j) {
		int size = (page - 1) * j;
		return customerMapper.selectCustomerPage(size, j);
	}

	public void addCustomer(Customer cus) {
		customerMapper.addCustomer(cus);

	}

	public int delete(Short id) {
		return customerMapper.delete(id);
	}

	public int updateCustomer(Customer cus) {
		return customerMapper.updateCustomer(cus);
	}
}

