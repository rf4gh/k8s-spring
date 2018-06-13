package com.dxc.appl.demo.svc.entitysvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.appl.demo.db.entities.Rental;
import com.dxc.appl.demo.db.repositories.RentalRepository;
import com.dxc.appl.demo.model.RentalWO;

@Service("rentalService")
@Transactional
public class RentalServiceImpl implements RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	
	/* (non-Javadoc)
	 * @see com.dxc.appl.demo.svc.entitysvc.RentalService#findAllRentals()
	 */
	@Override
	public List<RentalWO> findAllRentals() {
		List<RentalWO> rentals = new LinkedList<RentalWO>();
		Iterable<Rental> findAll = rentalRepository.findAll();
		
		for( Rental rental : findAll) {
			rentals.add( new RentalWO(rental));
		}
		return rentals;
	}
	
	/* (non-Javadoc)
	 * @see com.dxc.appl.demo.svc.entitysvc.RentalService#findById(int)
	 */
	@Override
	public RentalWO findById(int id) {
		 Optional<Rental> optional = rentalRepository.findById(Integer.valueOf(id));
		 return optional.isPresent() ? new RentalWO(optional.get()) : null;
	}
	
//	@Override
//	public List<RentalWO> findByCustomerId(int id) {
//		
//	}
}
