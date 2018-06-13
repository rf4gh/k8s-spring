package com.dxc.appl.demo.model;

import com.dxc.appl.demo.db.entities.City;

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
public class CityWO extends WebObject {

	private static final long serialVersionUID = -1657829440489768802L;

	protected int cityId;
	protected String city;
	protected int country_id;

	public CityWO(final City city) {
		super();
		this.cityId = city.getCityId();
		this.city = city.getCity();
		this.country_id = city.getCountry().getCountryId();
	}
}
