package com.nagarro.flightsearch.dao;

import java.util.List;

import com.nagarro.flightsearch.model.Flight;

public interface FlightSearchDAO {
	List<Flight> getSearchedFlights(String flightSearchParameter);
}
