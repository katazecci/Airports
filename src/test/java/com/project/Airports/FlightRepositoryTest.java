package com.project.Airports;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.Airports.domain.Airport;
import com.project.Airports.domain.Flight;
import com.project.Airports.domain.FlightRepository;

@DataJpaTest
public class FlightRepositoryTest {

	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void findFlightByAirlineReturnsFlightnumber() {

		List<Flight> flights = flightRepository.findByAirline("American Airlines");

		assertThat(flights).hasSizeGreaterThanOrEqualTo(1);
		assertThat(flights.get(0).getFlightNumber()).isEqualTo("AA456");
	}

	@Test
	public void findFlightByFlightnumberReturnsCode() {

		List<Flight> flights = flightRepository.findByFlightNumber("DL789");

		assertThat(flights).hasSize(1);
		assertThat(flights.get(0).getAirport().getCode()).isEqualTo("LAX");
	}

	@Test
	public void saveFlight() {
		Flight flight = new Flight("Finnair", new Airport("HEL", "Helsinki"), "AY178",
				LocalDateTime.of(2023, 3, 15, 11, 30), "B88");
		flightRepository.save(flight);
		assertThat(flight.getId()).isNotNull();
	}

	@Test
	public void editFlight() {
		Optional<Flight> flight = flightRepository.findById((long) 1);
		assertNotEquals(flight.get().getId(), null);
		flight.get().setFlightNumber("AA222");
		List<Flight> flights = flightRepository.findByFlightNumber("AA222");
		assertThat(flights).hasSize(1);
	}

	@Test
	public void deleteFlight() {
		List<Flight> flights = flightRepository.findByFlightNumber("DL789");
		Flight flight = flights.get(0);
		flightRepository.delete(flight);
		List<Flight> newFlights = flightRepository.findByFlightNumber("DL789");
		assertThat(newFlights).hasSize(0);
	}
}