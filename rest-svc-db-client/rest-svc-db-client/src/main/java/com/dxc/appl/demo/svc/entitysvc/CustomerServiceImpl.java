package com.dxc.appl.demo.svc.entitysvc;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.appl.demo.db.entities.Address;
import com.dxc.appl.demo.db.entities.Customer;
import com.dxc.appl.demo.db.entities.Store;
import com.dxc.appl.demo.db.repositories.AddressRepository;
import com.dxc.appl.demo.db.repositories.CustomerRepository;
import com.dxc.appl.demo.db.repositories.StoreRepository;
import com.dxc.appl.demo.model.CustomerWO;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private StoreRepository storeRepository;

	// log
	private static final Log log = LogFactory.getLog(CustomerServiceImpl.class);

	// find all customers
	@Override
	public List<CustomerWO> findAllCustomers() {
		List<CustomerWO> customers = new LinkedList<CustomerWO>();

		for (Customer customer : customerRepository.findAll()) {
			customers.add(new CustomerWO(customer));
			log.debug("Adding " + customer);
		}

		return customers;
	}

	// find by id
	@Override
	public CustomerWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
//		Customer customer = customerRepository.findOne(id);
		Optional<Customer> optCust = customerRepository.findById(id);

		if (optCust.isPresent()) {
			return new CustomerWO(optCust.get());
		}
		return null;
	}

	// save customer
	@Override
	public void saveCustomer(CustomerWO customerWO) {
		Customer customer = new Customer();
		customer.setLastName(customerWO.getLastName());
		customer.setFirstName(customerWO.getFirstName());
		customer.setEmail(customerWO.getEmail());
		
//		Address address = addressRepository.findOne(customerWO.getAddress_id());
		Optional<Address> optAddr = addressRepository.findById(customerWO.getAddress_id());
		if(optAddr.isPresent()){
			customer.setAddress(optAddr.get());
		}
		
//		Store store = storeRepository.findOne((byte) customerWO.getStore_id());
		Optional<Store> optStore = storeRepository.findById((byte) customerWO.getStore_id());
		if(optStore.isPresent()){
			customer.setStore(optStore.get());
		}
		

		Date dateobj = new Date();
		customer.setCreateDate(dateobj);
		customer.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		customerRepository.save(customer);
	}

	// update customer
	@Override
	public void updateCustomer(CustomerWO customerWO) {
//		Customer customer2update = customerRepository.findOne(customerWO.getCustomerId());
		Optional<Customer> optCust = customerRepository.findById(customerWO.getCustomerId());
		optCust.get().setLastName(customerWO.getLastName());
		optCust.get().setFirstName(customerWO.getFirstName());
		
//		Address address = addressRepository.findOne(customerWO.getAddress_id());
		Optional<Address> optAddr = addressRepository.findById(customerWO.getAddress_id());
		if(optAddr.isPresent()){
			optCust.get().setAddress(optAddr.get());
		}
		
//		Store store = storeRepository.findOne((byte) customerWO.getStore_id());
		Optional<Store> optStore = storeRepository.findById((byte) customerWO.getStore_id());
		if(optStore.isPresent()){
			optCust.get().setStore(optStore.get());
		}
		
		
		optCust.get().setLastUpdate(new Timestamp(System.currentTimeMillis()));
		customerRepository.save(optCust.get());
	}
	
	// delete customer
	@Override
	public void deleteCustomerById(int id) {
		customerRepository.deleteById(id);
	}
}
