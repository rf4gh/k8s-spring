package com.dxc.appl.demo.svc.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.appl.demo.model.CustomerWO;
import com.dxc.appl.demo.model.RentalWO;
import com.dxc.appl.demo.svc.entitysvc.CustomerService;
import com.dxc.appl.demo.svc.entitysvc.RentalService;

@RestController
public class RentalRestController {

	@Autowired
	private RentalService rentalService;
	
	@Autowired
	private CustomerService customerService;
	
//	@Autowired
//	private InventoryService inventoryService;
	
	// List All Customer
	@RequestMapping(value = "/rentals/", method = RequestMethod.GET)
	public ResponseEntity<List<RentalWO>> listAllRentals() {
	
		List<RentalWO> rentals = rentalService.findAllRentals();
		
		if (rentals.isEmpty()) {
			return new ResponseEntity<List<RentalWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RentalWO>>(rentals, HttpStatus.OK);
	}

	// Get Rentals By CustomerId
	@RequestMapping(value = "/rentalsByCustomer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RentalWO>> getRentalsByCustomer(@PathVariable("id") int id) {
		
		System.out.println("Fetching rentals for Customer with id " + id);
		
		CustomerWO customerWO = customerService.findById(id);
		if (customerWO == null) {
			System.out.println("Customer with id " + id + " not found");
			return new ResponseEntity<List<RentalWO>>(HttpStatus.NOT_FOUND);
		}

		List<RentalWO> list = new LinkedList<RentalWO>();
		// TODOD DXCRFE implement the findByCustomerId query !
//		rentalService.findById(id)
		
		return new ResponseEntity<List<RentalWO>>(list, HttpStatus.NO_CONTENT);
	}

}
