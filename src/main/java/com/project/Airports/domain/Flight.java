package com.project.Airports.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "flightnumber cannot be empty.")
	@Size(min = 0, max = 10)
	@Column(name = "flight_number")
	private String flightNumber;

	@NotEmpty(message = "airline cannot be empty.")
	@Size(min = 0, max = 50)
	private String airline;

	@Column(name = "departure_time")
	private LocalDateTime departureTime;

	@NotEmpty(message = "gate cannot be empty.")
	private String gate;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "airportid") //
	private Airport airport;

	public Flight() {
		super();
	}

	public Flight(@NotEmpty(message = "flight has to have an arriving airport.") Airport airport, String airline,
			String flightNumber, LocalDateTime departureTime, String gate) {
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
