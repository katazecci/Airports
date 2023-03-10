package com.project.Airports.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.Airports.domain.Airport;
import com.project.Airports.domain.AirportRepository;

@Controller
public class AirportController {
	private static final Logger log = LoggerFactory.getLogger(AirportController.class);

	@Autowired
	private AirportRepository airportRepository;

	// login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Show all airports
	@RequestMapping(value = { "/airportlist", "/" })
	public String showAirportlist(Model model) {
		log.info("get airports from db");
		model.addAttribute("airports", airportRepository.findAll());
		return "airportlist";
	}

	// Add a new book
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addairport")
	public String newAirport(Model model) {
		model.addAttribute("airport", new Airport());
		return "newairport";
	}

	// Save a new airport
	@PostMapping("saveairport")
	public String saveAirport(@Validated Airport airport, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("some validation error happened");
			return "newairport";
		}
		airportRepository.save(airport);
		return "redirect:/airportlist";
	}

	// Delete an airport
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("delete/{id}")
	public String deleteAirport(@PathVariable("id") Long id, Model model) {
		airportRepository.deleteById(id);
		return "redirect:/airportlist";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", airportRepository.findById(id));
		return "editBook";
	}

}