package com.nagarro.flightsearch.dao;

import java.util.List;

import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameter;
import com.nagarro.flightsearch.model.User;

public interface DAO {
	
	User login(String email, String password);
	List<Flight> getSearchedFlights(FlightSearchParameter flightSearchParameter);
}
