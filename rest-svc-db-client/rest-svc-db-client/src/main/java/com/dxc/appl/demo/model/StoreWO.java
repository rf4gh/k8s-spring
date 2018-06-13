package com.dxc.appl.demo.model;

import java.util.LinkedList;
import java.util.List;

import com.dxc.appl.demo.db.entities.Customer;
import com.dxc.appl.demo.db.entities.Inventory;
import com.dxc.appl.demo.db.entities.Staff;
import com.dxc.appl.demo.db.entities.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StoreWO extends WebObject {

	private static final long serialVersionUID = -5899560033222587890L;

	private int storeId;
	private int adress;
	private List<Integer> customers;
	private List<Integer> inventories;
	private int managerStaff;
	private List<Integer> staffs;

	public StoreWO(Store store) {
		super();
		this.storeId = store.getStoreId();
		if (store.getAddress() != null) {
			this.adress = store.getAddress().getAddressId();
		}
		if (store.getCustomers() != null) {
			List<Integer> customersId = new LinkedList<Integer>();
			for (Customer customer : store.getCustomers()) {
				customersId.add(customer.getCustomerId());
			}
			this.customers = customersId;
		}
		if (store.getInventories() != null) {
			List<Integer> inventoriesId = new LinkedList<Integer>();
			for (Inventory inventory : store.getInventories()) {
				inventoriesId.add(inventory.getInventoryId());
			}
			this.inventories = inventoriesId;
		}
		if (store.getStaff() != null) {
			this.managerStaff = store.getStaff().getStaffId();
		}
		if (store.getStaffs() != null) {
			List<Integer> staffsId = new LinkedList<Integer>();
			for (Staff staff : store.getStaffs()) {
				staffsId.add((int) staff.getStaffId());
			}
			this.staffs = staffsId;
		}
	}
}
