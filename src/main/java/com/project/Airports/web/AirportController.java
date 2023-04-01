package com.project.Airports.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Airports.domain.Airport;
import com.project.Airports.domain.AirportRepository;
import com.project.Airports.domain.Flight;
import com.project.Airports.domain.FlightRepository;

import jakarta.validation.Valid;

@Controller
public class AirportController {
	private static final Logger log = LoggerFactory.getLogger(AirportController.class);
	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private AirportRepository airportRepository;

	// login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Show all flights
	@GetMapping({ "/", "/flightlist" })
	public String flightList(Model model) {
		log.info("Get all flights from database");
		List<Flight> flights = (List<Flight>) flightRepository.findAll();
		model.addAttribute("flights", flights);
		return "flightlist";
	}

	@GetMapping("/airport/{id}")
	public String getFlightsByAirport(@PathVariable("id") Long airportId, Model model) {
		Airport airport = airportRepository.findById(airportId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid airport Id:" + airportId));
		List<Flight> flights = airport.getFlights();
		model.addAttribute("flights", flights);
		return "airportflights";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/addflight")
	public String addFlight(Model model) {
		model.addAttribute("flight", new Flight());
		model.addAttribute("airports", airportRepository.findAll());
		return "addflight";
	}

	// Save new flight
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/saveflight")
	public String saveFlight(@Valid @ModelAttribute("flight") Flight flight, BindingResult bindingResult, Model model) {
		log.info("CONTROLLER: Saved some of the flight - check validation of flight: " + flight);
		// Check if there are errors based on validation
		if (bindingResult.hasErrors()) {
			System.out.println("Some validation error happened");
			return "/addflight";
		}
		flightRepository.save(flight);
		return "redirect:/flightlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/updateflight/{id}")
	public String updateFlight(@PathVariable("id") Long id, Model model) {
		Optional<Flight> flight = flightRepository.findById(id);
		model.addAttribute("flight", flight);
		model.addAttribute("airports", airportRepository.findAll());
		return "updateflight";
	}

	// Delete flight
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/deleteflight/{id}")
	public String deleteFlight(@PathVariable("id") Long flightId, Model model) {
		flightRepository.deleteById(flightId);
		return "redirect:../flightlist";
	}

	@GetMapping(value = "/airportlist")
	public String airportList(Model model) {
		log.info("Get all airports from database");
		model.addAttribute("airports", airportRepository.findAll());
		return "airportlist";
	}

	// Add new airport
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/addairport")
	public String addAirport(Model model) {
		model.addAttribute("airport", new Airport());
		return "addairport";
	}

	// Save new airport
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(value = "/saveairport")
	public String saveAirport(@Validated Airport airport, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Some validation error happened");
			return "/addairport";
		}
		airportRepository.save(airport);
		return "redirect:/airportlist";
	}

	// Update airport
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/updateairport/{id}")
	public String updateAirport(@PathVariable("id") Long airportId, Model model) {
		model.addAttribute("airport", airportRepository.findById(airportId));
		return "updateairport";
	}

	// Delete airport
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/deleteairport/{id}")
	public String deleteAirport(@PathVariable("id") Long airportId, Model model) {
		airportRepository.deleteById(airportId);
		return "redirect:/airportlist";
	}

	// Add new flight

	/*
	 * // Show all flights for a specific airport
	 *
	 * 
	 * // RESTful service to get all flights
	 * 
	 * @GetMapping(value = "/flights") public @ResponseBody List<Flight>
	 * flightListRest() { return (List<Flight>) flightRepository.findAll(); }
	 * 
	 * // RESTful service to get flight by id
	 * 
	 * @GetMapping(value = "/flight/{id}") public @ResponseBody Optional<Flight>
	 * findFlightRest(@PathVariable("id") Long flightId) { return
	 * flightRepository.findById(flightId); }
	 */

}
