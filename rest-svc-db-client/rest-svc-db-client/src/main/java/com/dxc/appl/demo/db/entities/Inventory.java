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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="inventory")
@NamedQuery(name="Inventory.findAll", query="SELECT i FROM Inventory i")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	// https://vladmihalcea.com/why-should-not-use-the-auto-jpa-generationtype-with-mysql-and-hibernate/
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="inventory_id", unique=true, nullable=false)
	private int inventoryId;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	//bi-directional many-to-one association to Film
	@ManyToOne
	@JoinColumn(name="film_id", nullable=false)
	private Film film;

	//bi-directional many-to-one association to Store
	@ManyToOne
	@JoinColumn(name="store_id", nullable=false)
	private Store store;

	//bi-directional many-to-one association to Rental
	@OneToMany(mappedBy="inventory")
	private List<Rental> rentals;

	public Rental addRental(Rental rental) {
		getRentals().add(rental);
		rental.setInventory(this);

		return rental;
	}

	public Rental removeRental(Rental rental) {
		getRentals().remove(rental);
		rental.setInventory(null);

		return rental;
	}
}