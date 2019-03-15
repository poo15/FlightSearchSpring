package com.nagarro.flightsearch.service;

import java.util.List;

import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameter;
import com.nagarro.flightsearch.model.User;
/*
 * @author Pooja
 */
public interface Service {
	
	User login(String email, String password);
	
	List<Flight> getSearchedFlights(FlightSearchParameter flightParameter);
}
