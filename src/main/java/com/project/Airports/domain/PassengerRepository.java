package com.project.Airports.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {

	List<Passenger> findByName(String name);

}