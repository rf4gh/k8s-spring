package com.dxc.appl.demo.svc.entitysvc;

import java.sql.Timestamp;
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
import com.dxc.appl.demo.db.entities.Inventory;
import com.dxc.appl.demo.db.entities.Staff;
import com.dxc.appl.demo.db.entities.Store;
import com.dxc.appl.demo.db.repositories.AddressRepository;
import com.dxc.appl.demo.db.repositories.CustomerRepository;
import com.dxc.appl.demo.db.repositories.InventoryRepository;
import com.dxc.appl.demo.db.repositories.StaffRepository;
import com.dxc.appl.demo.db.repositories.StoreRepository;
import com.dxc.appl.demo.model.StoreWO;

@Service("storeService")
@Transactional
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Autowired
	private AddressRepository adressRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private CustomerRepository customerRepository;

	// log
	private static final Log log = LogFactory.getLog(StoreServiceImpl.class);

	// find by id
	@Override
	public StoreWO findById(int id) {
		log.debug("Find store with id : " + id);
//		Store store = storeRepository.findOne((byte) id);
		Optional<Store> optStore = storeRepository.findById((byte) id);

		if (optStore.isPresent()) {
			return new StoreWO(optStore.get());
		}

		return null;
	}

	// save store
	@Override
	public void saveStore(StoreWO storeWO) {

		Store store = new Store();

//		Address adress = adressRepository.findOne(storeWO.getAdress());
		Optional<Address> optAddr = adressRepository.findById(storeWO.getAdress());
		Iterable<Customer> customers = customerRepository.findAllById(storeWO.getCustomers());
		Iterable<Inventory> inventories = inventoryRepository.findAllById(storeWO.getInventories());
//		Staff staff = staffRepository.findOne(storeWO.getManagerStaff());
		Optional<Staff> optStaff = staffRepository.findById(storeWO.getManagerStaff());
		Iterable<Staff> staffs = staffRepository.findAllById(storeWO.getStaffs());

		store.setAddress(optAddr.get());
		store.setCustomers(toList(customers));
		store.setInventories(toList(inventories));
		store.setStaff(optStaff.get());
		store.setStaffs(toList(staffs));
		store.setLastUpdate(new Timestamp(System.currentTimeMillis()));

		storeRepository.save(store);
	}

	// update store
	@Override
	public void updateStore(StoreWO storeWO) {
//		Store store = storeRepository.findOne((byte) storeWO.getStoreId());
//		Address adress = adressRepository.findOne(storeWO.getAdress());
		Optional<Store> optStore = storeRepository.findById((byte) storeWO.getStoreId());
		Optional<Address> optAddr = adressRepository.findById(storeWO.getAdress());
		Iterable<Customer> customers = customerRepository.findAllById(storeWO.getCustomers());
		Iterable<Inventory> inventories = inventoryRepository.findAllById(storeWO.getInventories());
//		Staff staff = staffRepository.findOne(storeWO.getManagerStaff());
		Optional<Staff> optStaff = staffRepository.findById(storeWO.getManagerStaff());
		Iterable<Staff> staffs = staffRepository.findAllById(storeWO.getStaffs());

		optStore.get().setAddress(optAddr.get());
		optStore.get().setCustomers(toList(customers));
		optStore.get().setInventories(toList(inventories));
		optStore.get().setStaff(optStaff.get());
		optStore.get().setStaffs(toList(staffs));
		optStore.get().setLastUpdate(new Timestamp(System.currentTimeMillis()));

		storeRepository.save(optStore.get());
	}

	// delete by id
	@Override
	public void deleteStoreById(int id) {
		storeRepository.deleteById((byte) id);
	}

	// find all stores
	public List<StoreWO> findAllStores() {
		List<StoreWO> stores = new LinkedList<StoreWO>();
		for (Store store : storeRepository.findAll()) {
			stores.add(new StoreWO(store));
			log.debug("add store with id : " + store.getStoreId());
		}
		return stores;
	}

	// to list
	static <E> List<E> toList(Iterable<E> iterable) {
		if (iterable instanceof List) {
			return (List<E>) iterable;
		}
		List<E> list = new LinkedList<E>();
		if (iterable != null) {
			for (E e : iterable) {
				list.add(e);
			}
		}
		return list;
	}
}
