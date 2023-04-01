package com.project.Airports;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.project.Airports.domain.Airport;
import com.project.Airports.domain.AirportRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AirportRepositoryTest {

	@Autowired
	private AirportRepository airportRepository;

	@Test
	public void findByNameShouldReturnCode() {
		List<Airport> airports = airportRepository.findByName("Sydney Airport");

		assertThat(airports).hasSize(1);
		assertThat(airports.get(0).getCode()).isEqualTo("SYD");
	}

	@Test
	public void createNewAirport() {
		Airport airport = new Airport("HEL", "Helsinki Airport");
		airportRepository.save(airport);
		assertThat(airport.getId()).isNotNull();
	}

	@Test
	public void updateAirport() {
		Optional<Airport> airport = airportRepository.findById((long) 1);
		assertNotEquals(airport.get().getId(), null);
		airport.get().setName("testi");
		List<Airport> airports = airportRepository.findByName("testi");
		assertThat(airports).hasSize(1);

	}

	@Test
	public void deleteAirport() {
		List<Airport> airports = airportRepository.findByName("Los Angeles International Airport");
		Airport airport = airports.get(0);
		airportRepository.delete(airport);
		List<Airport> newAirports = airportRepository.findByName("Los Angeles International Airport");
		assertThat(newAirports).hasSize(0);
	}

}
