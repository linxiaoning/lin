package cn.com.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.bean.Address;
import cn.com.bean.Customer;
import cn.com.service.IAddressService;
import cn.com.service.ICustomerService;


@Controller
@RequestMapping("/film")
public class filmController {
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IAddressService addressService;
	
	//验证登录信息的模块
	@RequestMapping("/toLogin")
	public String toLogin(Customer customer,HttpServletRequest request){
//		System.out.println(customer.getFirst_name());
		if(customerService.SelectCustomer(customer)!=null){
			request.getSession().setAttribute("name",customer.getFirst_name());
			return "redirect:/film/toAll";
		}else {
//			System.out.println("11111");
			return "/login2";
		}
	}
	
	//获取所有数据的模块
	@RequestMapping("/toAll")
	public String toAll(Customer customer,HttpServletRequest request){
		Map<String , Object> map=new HashMap<String, Object>();
		map.put("customer", customer);
		return "/customer2";
	}
	
	
	
	
	//添加用户信息的模块
	@RequestMapping("/toAdd")
	public String addCustomer(Customer customer){
		System.out.println("!!!!!"+customer);
		//定义一个时间戳，来记录当前时间
		customer.setCreate_date(new Timestamp(System.currentTimeMillis()));
		customer.setLast_update(new Timestamp(System.currentTimeMillis()));
		customer.setStore_id((byte)1);
		customerService.addCustomer(customer);
		return "redirect:/film/toAll";
	}
	
	//删除用户信息的模块，其中@ResponseBody表示该方法的返回结果直接写入HTTP response body中
	
	@RequestMapping("/toDelete")
	@ResponseBody
	public void delete(short customer_id) {
		System.out.println("进入后台删除");
		Customer customer = new Customer();
		customer.setCustomer_id(customer_id);
		customerService.delete(customer.getCustomer_id());
	}

	//修改用户信息的模块
	@RequestMapping("/toUpdate")
	public String updateCustomer(Customer customer,HttpServletRequest request){
		ArrayList<Address> addressList= (ArrayList<Address>) addressService.selectAddress();
		request.setAttribute("addressList11", addressList);	
		Customer cus ;
		cus = customerService.SelectCustomerByID(customer.getCustomer_id());
		System.out.println(cus+"qqqqq");
		System.out.println(cus.getFirst_name());
		cus.setFirst_name(customer.getFirst_name());
		cus.setLast_name(customer.getLast_name());
		cus.setAddress_id(addressService.selectAddressByID(customer.getAddress_id().getAddress_id()));
		System.out.println(customer.getEmail()+"jjjjjjj");
		cus.setEmail(customer.getEmail());
		System.out.println(cus.getEmail()+"aaaaaaaaaa");
		customerService.updateCustomer(cus);		
		return "redirect:/film/toAll";
	}
	
	//查询所有地址信息模块
	@RequestMapping("/toAllAddress")
	public String selectAllAddress(HttpServletRequest request){
		ArrayList<Address> addressList = (ArrayList<Address>) addressService.selectAddress();
		request.setAttribute("list", addressList);		
		return "/newcustomer";	
	}
	
	//实现地址模块对前台ajax交互模块
	@RequestMapping("/toSelectAllAddressAjax")
	@ResponseBody
	public ArrayList<Address> selectAllAddress2(){
		ArrayList<Address> addressList = (ArrayList<Address>) addressService.selectAddress();
		return addressList;	
	}
	
//主界面实现分页模块
	@RequestMapping("/toAjaxPaget")
	@ResponseBody
	public Map<String,Object> ajaxPaget(HttpServletRequest request) {
		 Map<String, Object> map=new HashMap<String, Object>();
		 ArrayList<Customer> customerList = new ArrayList<Customer>();
//当前所在的页数
		 int page = Integer.parseInt(request.getParameter("page"));
		 System.out.println(page); 
		 System.out.println("----------------------");
		 customerList = (ArrayList<Customer>) customerService.selectCustomerPage(page, 20);
//获取每页有多少条数据
		 int size = 20;
		 System.out.println("customerList======"+customerList.size());
		 System.out.println("customer000======"+customerList.get(0));
		 //获取数据库总共的数据
		 int num = customerService.SelectAllnumber();
		 //计算出共有多少页
		 int totalPage;
		 if(num%size==0){
			 totalPage =num/size;
		 }else {
			 totalPage =(num/size)+1 ;
		}
		 System.out.println("totalPage=="+totalPage);
		 map.put("customerList", customerList);
		 map.put("page", page);
		 map.put("totalPage", totalPage);
		 return map;
	}


	}

	

