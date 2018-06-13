package com.dxc.appl.demo.svc.entitysvc;

import java.util.List;

import com.dxc.appl.demo.model.CustomerWO;

public interface CustomerService {

	List<CustomerWO> findAllCustomers();
	
	CustomerWO findById(int id);

	void saveCustomer(CustomerWO customerWO);

	void updateCustomer(CustomerWO customerWO);

	void deleteCustomerById(int id);

	

}