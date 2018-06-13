package com.dxc.appl.demo.svc.entitysvc;

import java.util.List;

import com.dxc.appl.demo.model.ActorWO;

public interface ActorService {
	ActorWO findById(int id);

	void saveActor(ActorWO userWO);

	void updateActor(ActorWO userWO);

	void deleteActorById(int id);

	List<ActorWO> findAllActors();
}
