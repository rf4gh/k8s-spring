package com.dxc.appl.demo.db.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the staff database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="staff")
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	// https://vladmihalcea.com/why-should-not-use-the-auto-jpa-generationtype-with-mysql-and-hibernate/
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="staff_id", unique=true, nullable=false)
	private byte staffId;

	@Column(nullable=false)
	private byte active;

	@Column(length=50)
	private String email;

	@Column(name="first_name", nullable=false, length=45)
	private String firstName;

	@Column(name="last_name", nullable=false, length=45)
	private String lastName;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	@Column(length=40)
	private String password;

	@Lob
	private byte[] picture;

	@Column(nullable=false, length=16)
	private String username;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="staff")
	private List<Payment> payments;

	//bi-directional many-to-one association to Rental
	@OneToMany(mappedBy="staff")
	private List<Rental> rentals;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address_id", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Store
	@ManyToOne
	@JoinColumn(name="store_id", nullable=false)
	private Store store;

	//bi-directional many-to-one association to Store
	@OneToMany(mappedBy="staff")
	private List<Store> stores;

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setStaff(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setStaff(null);

		return payment;
	}

	public Rental addRental(Rental rental) {
		getRentals().add(rental);
		rental.setStaff(this);

		return rental;
	}

	public Rental removeRental(Rental rental) {
		getRentals().remove(rental);
		rental.setStaff(null);

		return rental;
	}

	public Store addStore(Store store) {
		getStores().add(store);
		store.setStaff(this);

		return store;
	}

	public Store removeStore(Store store) {
		getStores().remove(store);
		store.setStaff(null);

		return store;
	}
}