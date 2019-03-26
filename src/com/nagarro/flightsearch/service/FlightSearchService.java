package com.nagarro.flightsearch.service;

import java.util.List;

import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameter;

public interface FlightSearchService {
	List<Flight> getSearchedFlights(FlightSearchParameter flightParameter);
}
