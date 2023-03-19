package com.project.Airports.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Airports.domain.Flight;
import com.project.Airports.domain.FlightRepository;

@RestController
public class RestAirportController {

	private static final Logger log = LoggerFactory.getLogger(RestAirportController.class);

	@Autowired
	private FlightRepository flightRepository;

	// returns list of flights
	@GetMapping("/flights")
	public Iterable<Flight> getFlights() {
		log.info("//fetch and return flights");
		return flightRepository.findAll();
	}

	@GetMapping("/flights/{id}")
	public Optional<Flight> getFlightById(@PathVariable Long id) {
		log.info("fetch flight by id = " + id);
		return flightRepository.findById(id);
	}

	// add a new flight
	@PostMapping("flights")
	Flight newFlight(@RequestBody Flight newFlight) {
		log.info("save new flight " + newFlight);
		return flightRepository.save(newFlight);
	}

	// edit existing flight info
	@PutMapping("/flights/{id}")
	Flight editFlight(@RequestBody Flight editedFlight, @PathVariable Long id) {
		log.info("edit flight " + editedFlight);
		editedFlight.setId(id);
		return flightRepository.save(editedFlight);
	}

	// delete flight
	@DeleteMapping("/flights/{id}")
	public Iterable<Flight> deleteFlight(@PathVariable Long id) {
		log.info("delete flight, id = " + id);
		flightRepository.deleteById(id);
		return flightRepository.findAll();
	}

}