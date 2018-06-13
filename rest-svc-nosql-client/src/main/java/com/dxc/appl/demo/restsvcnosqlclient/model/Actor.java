package com.dxc.appl.demo.restsvcnosqlclient.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Actor {
	
	private Long actorId;
	
	@Field("First name")
	private String firstName;
	
	@Field("Last name")
	private String lastName;
}
