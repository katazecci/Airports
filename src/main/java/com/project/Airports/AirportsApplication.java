package com.project.Airports;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.project.Airports.domain.Airport;
import com.project.Airports.domain.AirportRepository;
import com.project.Airports.domain.AppUser;
import com.project.Airports.domain.AppUserRepository;
import com.project.Airports.domain.Flight;
import com.project.Airports.domain.FlightRepository;

@SpringBootApplication
public class AirportsApplication {

	private static final Logger log = LoggerFactory.getLogger(AirportsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AirportsApplication.class, args);
	}

	@Bean
	public CommandLineRunner airports(AirportRepository airportRepository, FlightRepository flightRepository,
			AppUserRepository userRepository) {
		return (args) -> {

			// Create and save airports and flights

			Airport losAngelesAirport = airportRepository.save(new Airport("LAX", "Los Angeles International Airport"));
			Airport dubaiAirport = airportRepository.save(new Airport("DXB", "Dubai International Airport"));
			Airport beijingAirport = airportRepository
					.save(new Airport("PEK", "Beijing Capital International Airport"));
			Airport sydneyAirport = airportRepository.save(new Airport("SYD", "Sydney Airport"));
			Airport torontoAirport = airportRepository
					.save(new Airport("YYZ", "Toronto Pearson International Airport"));
			Airport singaporeAirport = airportRepository.save(new Airport("SIN", "Singapore Changi Airport"));
			Airport frankfurtAirport = airportRepository.save(new Airport("FRA", "Frankfurt Airport"));

			// Flights from Los Angeles Airport
			flightRepository.save(new Flight("American Airlines", losAngelesAirport, "AA456",
					LocalDateTime.of(2023, 3, 15, 11, 30), "A1"));
			flightRepository.save(new Flight("Delta Air Lines", losAngelesAirport, "DL789",
					LocalDateTime.of(2023, 3, 15, 13, 45), "B2"));
			flightRepository.save(new Flight("United Airlines", losAngelesAirport, "UA321",
					LocalDateTime.of(2023, 3, 15, 16, 20), "C3"));
			flightRepository.save(new Flight("Southwest Airlines", losAngelesAirport, "WN654",
					LocalDateTime.of(2023, 3, 15, 18, 10), "D4"));
			flightRepository.save(new Flight("JetBlue Airways", losAngelesAirport, "B6521",
					LocalDateTime.of(2023, 3, 15, 21, 5), "E5"));

			// Flights from Dubai International Airport
			flightRepository
					.save(new Flight("Emirates", dubaiAirport, "EK123", LocalDateTime.of(2023, 3, 15, 8, 30), "A1"));
			flightRepository.save(
					new Flight("Etihad Airways", dubaiAirport, "EY456", LocalDateTime.of(2023, 3, 15, 12, 45), "B2"));
			flightRepository
					.save(new Flight("Flydubai", dubaiAirport, "FZ789", LocalDateTime.of(2023, 3, 15, 15, 20), "C3"));
			flightRepository
					.save(new Flight("Air Arabia", dubaiAirport, "G9123", LocalDateTime.of(2023, 3, 15, 17, 10), "D4"));
			flightRepository
					.save(new Flight("Gulf Air", dubaiAirport, "GF321", LocalDateTime.of(2023, 3, 15, 22, 5), "E5"));

			// Flights from Beijing Capital International Airport
			flightRepository
					.save(new Flight("Air China", beijingAirport, "CA123", LocalDateTime.of(2023, 3, 15, 9, 30), "A1"));
			flightRepository.save(new Flight("China Eastern Airlines", beijingAirport, "MU456",
					LocalDateTime.of(2023, 3, 15, 12, 45), "B2"));
			flightRepository.save(new Flight("China Southern Airlines", beijingAirport, "CZ789",
					LocalDateTime.of(2023, 3, 15, 16, 20), "C3"));
			flightRepository.save(new Flight("Hainan Airlines", beijingAirport, "HU654",
					LocalDateTime.of(2023, 3, 15, 18, 10), "D4"));
			flightRepository.save(new Flight("Xiamen Airlines", beijingAirport, "MF6521",
					LocalDateTime.of(2023, 3, 15, 21, 5), "E5"));

			// Flights for Sydney Airport
			flightRepository
					.save(new Flight("Qantas", sydneyAirport, "QF112", LocalDateTime.of(2023, 3, 15, 8, 45), "Gate 1"));
			flightRepository.save(new Flight("Virgin Australia", sydneyAirport, "VA547",
					LocalDateTime.of(2023, 3, 15, 11, 15), "Gate 2"));
			flightRepository.save(
					new Flight("Jetstar", sydneyAirport, "JQ202", LocalDateTime.of(2023, 3, 15, 14, 30), "Gate 3"));
			flightRepository.save(
					new Flight("Emirates", sydneyAirport, "EK414", LocalDateTime.of(2023, 3, 15, 18, 20), "Gate 4"));
			flightRepository.save(new Flight("Singapore Airlines", sydneyAirport, "SQ221",
					LocalDateTime.of(2023, 3, 15, 21, 5), "Gate 5"));

			// Flights for Toronto Airport
			flightRepository.save(
					new Flight("Air Canada", torontoAirport, "AC123", LocalDateTime.of(2023, 3, 15, 9, 10), "Gate 6"));
			flightRepository.save(
					new Flight("WestJet", torontoAirport, "WS456", LocalDateTime.of(2023, 3, 15, 12, 30), "Gate 7"));
			flightRepository.save(new Flight("United Airlines", torontoAirport, "UA789",
					LocalDateTime.of(2023, 3, 15, 15, 45), "Gate 8"));
			flightRepository.save(new Flight("American Airlines", torontoAirport, "AA246",
					LocalDateTime.of(2023, 3, 15, 19, 0), "Gate 9"));
			flightRepository.save(new Flight("Delta Air Lines", torontoAirport, "DL369",
					LocalDateTime.of(2023, 3, 15, 22, 15), "Gate 10"));

			// Flights for Singapore Airport
			flightRepository.save(new Flight("Singapore Airlines", singaporeAirport, "SQ319",
					LocalDateTime.of(2023, 3, 15, 6, 0), "Gate 11"));
			flightRepository.save(new Flight("Qatar Airways", singaporeAirport, "QR841",
					LocalDateTime.of(2023, 3, 15, 10, 20), "Gate 12"));
			flightRepository.save(new Flight("Emirates", singaporeAirport, "EK402",
					LocalDateTime.of(2023, 3, 15, 14, 15), "Gate 13"));
			flightRepository.save(new Flight("Cathay Pacific", singaporeAirport, "CX712",
					LocalDateTime.of(2023, 3, 15, 18, 30), "Gate 14"));
			flightRepository.save(new Flight("Thai Airways", singaporeAirport, "TG424",
					LocalDateTime.of(2023, 3, 15, 22, 45), "Gate 15"));

			// Flights for Frankfurt Airport
			flightRepository.save(new Flight("Lufthansa", frankfurtAirport, "LH456",
					LocalDateTime.of(2023, 3, 15, 7, 30), "Gate 23"));
			flightRepository.save(new Flight("United Airlines", frankfurtAirport, "UA555",
					LocalDateTime.of(2023, 3, 15, 11, 0), "Gate 32"));
			flightRepository.save(new Flight("British Airways", frankfurtAirport, "BA678",
					LocalDateTime.of(2023, 3, 15, 15, 10), "Gate 42"));
			flightRepository.save(new Flight("Air France", frankfurtAirport, "AF901",
					LocalDateTime.of(2023, 3, 15, 19, 15), "Gate 51"));
			flightRepository.save(new Flight("Emirates", frankfurtAirport, "EK884",
					LocalDateTime.of(2023, 3, 15, 23, 30), "Gate 57"));
			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN");

			userRepository.save(user1);
			userRepository.save(user2);

			log.info("fetch all flights from the database");
			for (Flight flight : flightRepository.findAll()) {
				System.out.println("Flight: " + flight.toString());
			}

		};

	}
}
