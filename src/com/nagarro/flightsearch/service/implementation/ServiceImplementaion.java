package com.nagarro.flightsearch.service.implementation;

import java.util.List;

import com.nagarro.flightsearch.dao.DAO;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameter;
import com.nagarro.flightsearch.model.User;
import com.nagarro.flightsearch.service.Service;

public class ServiceImplementaion implements Service{
	private DAO dao;
	
	public void setDao(final DAO dao) {
		this.dao = dao;
	}

	@Override
	public User login(final String email,final String password) {
		
		return dao.login(email, password);
	}

	@Override
	public List<Flight> getSearchedFlights(final FlightSearchParameter flightParameter) {
		return dao.getSearchedFlights(flightParameter);
	}

}
