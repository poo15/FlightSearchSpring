package com.nagarro.flightsearch.service.implementation;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.nagarro.flightsearch.dao.UserLoginDAO;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameter;
import com.nagarro.flightsearch.service.FlightSearchService;

public class FlightSearchServiceImpl implements FlightSearchService {
	private UserLoginDAO dao;
	public void setDao(final UserLoginDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<Flight> getSearchedFlights(final FlightSearchParameter flightParameter) {

		String searchParamter = flightParameter.getDepartureLocation()+"_"+flightParameter.getArrivalLocation()
								+"_"+flightParameter.getFlightDate()+"_"+flightParameter.getFlightclass()
								+"_"+flightParameter.getAirline()+"_"+flightParameter.getOutputPreference();
		System.out.println(searchParamter);
		URI uri = UriBuilder.fromUri("http://localhost:8080/flightsearch/webapi")
					.path("/search")
					.build();
		ResteasyClient client1 = new ResteasyClientBuilder().build();
		ResteasyWebTarget target1=client1.target(uri).queryParam("parameters", searchParamter);
		javax.ws.rs.client.Invocation.Builder builder = target1.request();
		builder.accept(MediaType.APPLICATION_JSON); 
		
		return builder.get(new GenericType<List<Flight>>() {});
	}
}
