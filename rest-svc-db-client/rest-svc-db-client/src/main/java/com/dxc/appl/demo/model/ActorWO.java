package com.dxc.appl.demo.model;

import com.dxc.appl.demo.db.entities.Actor;

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
public class ActorWO extends WebObject {

	private static final long serialVersionUID = 4042292267310704934L;

	protected int actorId;
	protected String lastName;
	protected String firstName;

	public ActorWO(final Actor actor) {
		super();
		this.actorId = actor.getActorId();
		this.lastName = actor.getLastName();
		this.firstName = actor.getFirstName();
	}
}
