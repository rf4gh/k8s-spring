package com.dxc.appl.demo.model;

import com.dxc.appl.demo.db.entities.Customer;

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
public class CustomerWO extends WebObject {

	private static final long serialVersionUID = 8165014285796102933L;

	protected int customerId;
	protected String lastName;
	protected String firstName;
	protected String email;
	protected int address_id;
	protected int store_id;

	public CustomerWO(final Customer customer) {
		super();
		this.customerId = customer.getCustomerId();
		this.lastName = customer.getLastName();
		this.firstName = customer.getFirstName();
		this.email = customer.getEmail();
		this.address_id = customer.getAddress().getAddressId();
		this.store_id = customer.getStore().getStoreId();
	}
}
