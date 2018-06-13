package com.dxc.appl.demo.model;

import com.dxc.appl.demo.db.entities.Inventory;

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
public class InventoryWO extends WebObject {

	private static final long serialVersionUID = -7656398276192460889L;

	private int inventoryId;
	private int film;
	private int store;

	public InventoryWO(Inventory inventory) {
		super();
		this.inventoryId = inventory.getInventoryId();
		if (inventory.getFilm() != null) {
			this.film = inventory.getFilm().getFilmId();
		}
		if (inventory.getStore() != null) {
			this.store = inventory.getStore().getStoreId();
		}
	}
}
