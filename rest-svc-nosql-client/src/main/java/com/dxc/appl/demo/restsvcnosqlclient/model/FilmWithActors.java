package com.dxc.appl.demo.restsvcnosqlclient.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
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
@Document(collection="films")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmWithActors {
	
	@Id
	private Long id;
	
	@Field("Title")
	private String title;
	
	@Field("Description")
	private String description;
	
	@Field("Length")
	private Integer length;
	
	@Field("Rating")
	private String rating; // TODO DXCRFE Enum type !
	
	@Field("Special Features")
	private String specialFeatures;
	
	@Field("Rental Duration")
	private Integer rentalDuration;
	
	@Field("Replacement Cost")
	private BigDecimal replacementCost;
	
	@Field("Category")
	private String category;
	
	@Field("Actors")
	private List<Actor> actors;
	
//	@PersistenceConstructor
//	private FilmWithActors(Long id, String title, String description, Integer length, String rating, String specialFeatures, Integer rentalDuration, BigDecimal replacementCost, String category, List<Actor> actors) {
//		this.id=id;		
//		this.title=title;
//		this.description=description;
//		this.length=length;
//		this.rating=rating;
//		this.specialFeatures=specialFeatures;
//		this.rentalDuration=rentalDuration;
//		this.replacementCost=replacementCost;
//		this.category=category;
//		this.actors=actors;
//	}
	/*
	 _id: 19
Title: "AMADEUS HOLY"
Description: "A Emotional Display of a Pioneer And a Technical Writer who must Battl..."
Length: "113"
Rating: "PG"
Special Features: "Commentaries,Deleted Scenes,Behind the Scenes"
Rental Duration: "6"
Replacement Cost: "20.99"
Category: "Action"
Actors: Array
0:
Object
	actorId: 5
	Last name: "LOLLOBRIGIDA"
	First name: "JOHNNY"
	 */
}
