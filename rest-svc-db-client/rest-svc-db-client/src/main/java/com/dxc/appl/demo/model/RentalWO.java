package com.dxc.appl.demo.model;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.dxc.appl.demo.db.entities.Rental;

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
public class RentalWO extends WebObject {

	private static final long serialVersionUID = 8434565351233283495L;

	protected int inventoryId;
	protected int customerId;
	protected int staffId;
	protected LocalDateTime rentalDate;
	protected LocalDateTime returnDate;
	protected LocalDateTime lastUpdate;
	
	public RentalWO(final Rental rental) {
		super();
		this.inventoryId=rental.getRentalId();
		this.customerId=rental.getCustomer().getCustomerId();
		this.staffId=rental.getStaff().getStaffId();
		this.rentalDate= LocalDateTime.ofInstant(rental.getRentalDate().toInstant(), ZoneId.systemDefault());
		this.returnDate= rental.getReturnDate()!=null ? LocalDateTime.ofInstant(rental.getReturnDate().toInstant(), ZoneId.systemDefault()) : null;
		this.lastUpdate= rental.getLastUpdate()!=null ? LocalDateTime.ofInstant(rental.getLastUpdate().toInstant(), ZoneId.systemDefault()) : null;
	}
}
