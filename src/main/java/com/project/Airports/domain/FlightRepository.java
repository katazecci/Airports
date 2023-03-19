package com.project.Airports.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {

	List<Flight> findByAirport(Long airportId);

	List<Flight> findByAirline(String airline);

	List<Flight> findByFlightNumber(String flightNumber);

}
