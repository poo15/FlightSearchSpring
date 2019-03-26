package com.nagarro.flightsearch;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.nagarro.flightsearch.dao.FlightSearchDAO;
import com.nagarro.flightsearch.dao.impl.FlightSearchDaoImpl;
import com.nagarro.flightsearch.model.Flight;


@Path("search")
public class FlightSearchAPI {
	FlightSearchDAO dao = new FlightSearchDaoImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Flight> getFlights(@QueryParam(value="parameters") String searchParameter){
		return dao.getSearchedFlights(searchParameter);
	}
	
}
