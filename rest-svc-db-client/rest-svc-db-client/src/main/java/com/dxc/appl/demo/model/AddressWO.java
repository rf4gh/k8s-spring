package com.dxc.appl.demo.model;

import com.dxc.appl.demo.db.entities.Address;

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
public class AddressWO extends WebObject {

	private static final long serialVersionUID = -5609060932799540921L;

	protected int addressId;
	protected String address;
	protected String address2;
	protected String district;
	protected String postal_code;
	protected int city_id;

	public AddressWO(final Address address) {
		super();
		this.addressId = address.getAddressId();
		this.address = address.getAddress();
		this.address2 = address.getAddress2();
		this.district = address.getDistrict();
		this.postal_code = address.getPostalCode();
		this.city_id = address.getCity().getCityId();
	}
}
