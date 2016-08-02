

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.bean.Customer;
import cn.com.service.ICustomerService;

public class test {
	
	public static void main(String[] args) {
    	ApplicationContext f = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//*    	ICustomerDao customerDao = (ICustomerDao) f.getBean("customerDao");
    	/*Customer s = new Customer();
    	s.setFirst_name("PATRICIA");
    	s.setLast_name("JOHNSON");
    	Customer ss = customerDao.SelectCustomer(s);
    	System.out.println(ss);*/
  /*  	int j = customerDao.SelectAllnumber();
    	System.out.println(j);*/
/*    	ICustomerService cs = (ICustomerService) f.getBean("customerService");
    	Customer cus = new Customer();
    	cus.setFirst_name("dsd");
    	cus.setLast_name("sdsd");
    	cus = cs.selectCustomer(cus);
    	System.out.println(cus.getFirst_name());
    	cs.delete(cus);*/
    	
    	
	}
}
