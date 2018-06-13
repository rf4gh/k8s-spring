package com.dxc.appl.demo.db.entities;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="city")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	// https://vladmihalcea.com/why-should-not-use-the-auto-jpa-generationtype-with-mysql-and-hibernate/
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name="city_id", unique=true, nullable=false)
	private int cityId;

	@Column(nullable=false, length=50)
	private String city;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="city")
	private List<Address> addresses;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country_id", nullable=false)
	private Country country;

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setCity(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCity(null);

		return address;
	}
}