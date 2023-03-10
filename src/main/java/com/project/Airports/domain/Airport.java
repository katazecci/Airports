package com.project.Airports.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String IATA;

}
