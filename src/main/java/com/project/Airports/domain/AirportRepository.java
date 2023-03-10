package com.project.Airports.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Long> {

	List<Airport> findByIata(String iataCode);

}
