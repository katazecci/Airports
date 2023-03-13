package com.project.Airports;

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

			// Create and save airports
			Airport newYorkAirport = new Airport("JFK", "John F. Kennedy International Airport");
			airportRepository.save(newYorkAirport);

			Airport londonAirport = new Airport("LHR", "Heathrow Airport");
			airportRepository.save(londonAirport);

			Airport parisAirport = new Airport("CDG", "Charles de Gaulle Airport");
			airportRepository.save(parisAirport);

			Airport losAngelesAirport = new Airport("LAX", "Los Angeles International Airport");
			airportRepository.save(losAngelesAirport);

			Airport dubaiAirport = new Airport("DXB", "Dubai International Airport");
			airportRepository.save(dubaiAirport);

			Airport beijingAirport = new Airport("PEK", "Beijing Capital International Airport");
			airportRepository.save(beijingAirport);

			Airport sydneyAirport = new Airport("SYD", "Sydney Airport");
			airportRepository.save(sydneyAirport);

			Airport torontoAirport = new Airport("YYZ", "Toronto Pearson International Airport");
			airportRepository.save(torontoAirport);

			Airport singaporeAirport = new Airport("SIN", "Singapore Changi Airport");
			airportRepository.save(singaporeAirport);

			Airport frankfurtAirport = new Airport("FRA", "Frankfurt Airport");
			airportRepository.save(frankfurtAirport);

			Airport tokyoAirport = new Airport("HND", "Haneda Airport");
			airportRepository.save(tokyoAirport);

			Airport istanbulAirport = new Airport("IST", "Istanbul Airport");
			airportRepository.save(istanbulAirport);

			Airport amsterdamAirport = new Airport("AMS", "Amsterdam Airport Schiphol");
			airportRepository.save(amsterdamAirport);

			// Create and save flights
			Flight flight1 = new Flight("British Airways", newYorkAirport, "BA123");
			flightRepository.save(flight1);

			Flight flight2 = new Flight("American Airlines", newYorkAirport, "AA456");
			flightRepository.save(flight2);

			Flight flight3 = new Flight("Virgin Atlantic", londonAirport, "VS789");
			flightRepository.save(flight3);

			Flight flight4 = new Flight("Emirates", dubaiAirport, "EK124");
			flightRepository.save(flight4);

			Flight flight5 = new Flight("Lufthansa", frankfurtAirport, "LH234");
			flightRepository.save(flight5);

			Flight flight6 = new Flight("Qantas", sydneyAirport, "QF345");
			flightRepository.save(flight6);

			Flight flight7 = new Flight("United Airlines", losAngelesAirport, "UA678");
			flightRepository.save(flight7);

			Flight flight8 = new Flight("Air France", parisAirport, "AF901");
			flightRepository.save(flight8);

			Flight flight9 = new Flight("Singapore Airlines", singaporeAirport, "SQ567");
			flightRepository.save(flight9);

			Flight flight10 = new Flight("Turkish Airlines", istanbulAirport, "TK789");
			flightRepository.save(flight10);

			Flight flight11 = new Flight("KLM", amsterdamAirport, "KL901");
			flightRepository.save(flight11);

			Flight flight12 = new Flight("ANA", tokyoAirport, "NH345");
			flightRepository.save(flight12);

			Flight flight13 = new Flight("Air Canada", torontoAirport, "AC678");
			flightRepository.save(flight13);

			Flight flight14 = new Flight("China Southern Airlines", beijingAirport, "CZ123");
			flightRepository.save(flight14);

			Flight flight15 = new Flight("Delta Air Lines", losAngelesAirport, "DL456");
			flightRepository.save(flight15);
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
