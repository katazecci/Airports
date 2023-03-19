package com.project.Airports.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String flightNumber;
	private String airline;
	private LocalDateTime departureTime;
	private String gate;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "airportid") //
	private Airport airport;

	public Flight() {
	}

	public Flight(String airline, Airport airport, String flightNumber, LocalDateTime departureTime, String gate) {
		super();
		this.flightNumber = flightNumber;
		this.airport = airport;
		this.airline = airline;
		this.departureTime = departureTime;
		this.gate = gate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getGate() {
		return gate;
	}

	public void setGate(String gate) {
		this.gate = gate;
	}

	public static List<String> getAllAirports(List<Flight> flights) {
		List<String> airports = new ArrayList<>();
		for (Flight flight : flights) {
			if (!airports.contains(flight.getAirport().getName())) {
				airports.add(flight.getAirport().getName());
			}
		}
		return airports;
	}

	@Override
	public String toString() {
		if (this.airport != null)
			return "Flight [id=" + id + ", airline=" + airline + ", airport=" + this.getAirport() + ", flight number="
					+ flightNumber + ", departure time=" + departureTime + ", gate=" + gate + "]";

		return "Flight [id=" + id + ", airline=" + airline + ", airport=" + airport + ", flight number=" + flightNumber
				+ ", departure time=" + departureTime + ", gate=" + gate + "]";
	}

}
