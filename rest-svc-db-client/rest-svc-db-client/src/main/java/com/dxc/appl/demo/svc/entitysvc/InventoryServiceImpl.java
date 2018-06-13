package com.dxc.appl.demo.svc.entitysvc;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.appl.demo.db.entities.Film;
import com.dxc.appl.demo.db.entities.Inventory;
import com.dxc.appl.demo.db.entities.Store;
import com.dxc.appl.demo.db.repositories.FilmRepository;
import com.dxc.appl.demo.db.repositories.InventoryRepository;
import com.dxc.appl.demo.db.repositories.StoreRepository;
import com.dxc.appl.demo.model.InventoryWO;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private StoreRepository storeRepository;

	// log
	private static final Log log = LogFactory.getLog(InventoryServiceImpl.class);

	// find all inventories
	@Override
	public List<InventoryWO> findAllInventories() {
		List<InventoryWO> inventories = new LinkedList<InventoryWO>();
		for (Inventory inventory : inventoryRepository.findAll()) {
			inventories.add(new InventoryWO(inventory));
			log.debug("Add inventory with id : " + inventory.getInventoryId());
		}
		return inventories;
	}

	// find by id
	@Override
	public InventoryWO findById(int id) {
		log.debug("Find inventory with id : " + id);
//		Inventory inventory = inventoryRepository.findOne(id);
		Optional<Inventory> optInv = inventoryRepository.findById(id);

		if (optInv.isPresent()) {
			return new InventoryWO(optInv.get());
		}
		return null;
	}

	// save inventory
	@Override
	public void saveInventory(InventoryWO inventoryWO) {
		Inventory inventory = new Inventory();
//		Film film = filmRepository.findOne(inventoryWO.getFilm())
		Optional<Film> optFilm = filmRepository.findById(inventoryWO.getFilm());
//		Store store = storeRepository.findOne((byte) inventoryWO.getStore());
		Optional<Store> optStore = storeRepository.findById((byte) inventoryWO.getStore());

		inventory.setFilm(optFilm.get());
		inventory.setStore(optStore.get());
		inventory.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		inventoryRepository.save(inventory);
	}

	// update inventory
	@Override
	public void updateInventory(InventoryWO inventoryWO) {
//		Inventory inventory = inventoryRepository.findOne(inventoryWO.getInventoryId());
//		Film film = filmRepository.findOne(inventoryWO.getFilm());
//		Store store = storeRepository.findOne((byte) inventoryWO.getStore());
		Optional<Inventory> optInv = inventoryRepository.findById(inventoryWO.getInventoryId());
		Optional<Film> optFilm = filmRepository.findById(inventoryWO.getFilm());
		Optional<Store> optStore = storeRepository.findById((byte) inventoryWO.getStore());

		optInv.get().setFilm(optFilm.get());
		optInv.get().setStore(optStore.get());
		optInv.get().setLastUpdate(new Timestamp(System.currentTimeMillis()));
		inventoryRepository.save(optInv.get());
	}

	// delete inventory
	@Override
	public void deleteInventoryById(int id) {
		inventoryRepository.deleteById(id);
	}

	// find by store id
	@Override
	public List<InventoryWO> findInventoriesByStore(int storeId) {
		List<InventoryWO> inventories = new LinkedList<InventoryWO>();
		for (Inventory inventory : inventoryRepository.findAll()) {
			if (inventory.getStore().getStoreId() == storeId) {
				inventories.add(new InventoryWO(inventory));
				log.debug("Add inventory with id : " + inventory.getInventoryId());
			}
		}
		return inventories;
	}

	// find by film id
	@Override
	public List<InventoryWO> findInventoriesByFilm(int filmId) {
		List<InventoryWO> inventories = new LinkedList<InventoryWO>();
		Optional<Film> optFilm = filmRepository.findById(filmId);
		for (Inventory inventory : inventoryRepository.findAllInventoriesByFilm(optFilm.get())) {
			inventories.add(new InventoryWO(inventory));
		}
		return inventories;
	}

}
