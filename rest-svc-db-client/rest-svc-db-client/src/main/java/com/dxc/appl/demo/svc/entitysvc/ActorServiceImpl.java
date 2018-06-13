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

import com.dxc.appl.demo.db.entities.Actor;
import com.dxc.appl.demo.db.repositories.ActorRepository;
import com.dxc.appl.demo.model.ActorWO;


@Service("actorService")
@Transactional
public class ActorServiceImpl implements ActorService {

	
	@Autowired
	private ActorRepository actorRepository;
	
	private static final Log log = LogFactory.getLog(ActorServiceImpl.class);
	
	
	
	@Override
	public ActorWO findById(int id) {
		
		log.debug(String.format("Looking for user by Id %s", id));
//		Actor actor = actorRepository.findOne(id);
		Optional<Actor> optActor = actorRepository.findById(id);
		
		if(optActor.isPresent()){
			return new ActorWO(optActor.get());
		}
		return null;
	}

	@Override
	public void saveActor(ActorWO userWO) {

		Actor actor = new Actor();
		actor.setLastName(userWO.getLastName());
		actor.setFirstName(userWO.getFirstName());
		actor.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		actorRepository.save(actor);
	}

	@Override
	public void updateActor(ActorWO userWO) {

//		Actor actor2update = actorRepository.findOne(userWO.getActorId());
		Optional<Actor> optActor = actorRepository.findById(userWO.getActorId());
		optActor.get().setLastName(userWO.getLastName());
		optActor.get().setFirstName(userWO.getFirstName());
		optActor.get().setLastUpdate(new Timestamp(System.currentTimeMillis()));
		actorRepository.save(optActor.get());
	}

	@Override
	public void deleteActorById(int id) {
		actorRepository.deleteById(id);
	}

	@Override
	public List<ActorWO> findAllActors() {

		List<ActorWO> actors = new LinkedList<ActorWO>();
		
		for (Actor actor : actorRepository.findAll()) {
			actors.add(new ActorWO(actor));
			log.debug("Adding " + actor);
		}
		
		return actors;
	}

}
