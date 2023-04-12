package com.project.Airports;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.Airports.domain.Airport;
import com.project.Airports.domain.AirportRepository;
import com.project.Airports.domain.Flight;
import com.project.Airports.domain.FlightRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FlightRepositoryTest {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	AirportRepository airportRepository;

	@Test
	public void findFlightByAirlineReturnsFlightnumber() {
		List<Flight> flights = flightRepository.findByAirline("American Airlines");
		assertThat(flights).hasSizeGreaterThanOrEqualTo(1);
		assertThat(flights.get(0).getFlightNumber()).isEqualTo("AA404");
	}

	@Test
	public void findFlightByFlightnumberReturnsCode() {
		List<Flight> flights = flightRepository.findByFlightNumber("KE1616");
		assertThat(flights).hasSize(1);
		assertThat(flights.get(0).getAirport().getCode()).isEqualTo("SYD");
	}

	@Test
	public void saveFlight() {
		List<Airport> airports = airportRepository.findByName("Los Angeles International Airport");
		Airport airport = airports.get(0);
		Flight flight = new Flight(airport, "Finnair", "AY178", LocalDateTime.of(2023, 3, 15, 11, 30), "B88");
		flightRepository.save(flight);
		assertNotEquals(flight.getId(), null);
	}

	@Test
	public void editFlight() {
		Optional<Flight> flight = flightRepository.findById((long) 2);
		assertThat(flight.get().getId()).isNotNull();
		flight.get().setFlightNumber("AA222");
		List<Flight> flights = flightRepository.findByFlightNumber("UA202");
		assertThat(flights).hasSize(0);
	}

	@Test
	public void deleteFlight() {
		List<Flight> flights = flightRepository.findByFlightNumber("EK2222");
		Flight flight = flights.get(0);
		flightRepository.delete(flight);
		List<Flight> newFlights = flightRepository.findByFlightNumber("EK2222");
		assertThat(newFlights).hasSize(0);
	}
}