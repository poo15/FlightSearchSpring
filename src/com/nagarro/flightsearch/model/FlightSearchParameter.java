package com.nagarro.flightsearch.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class FlightSearchParameter {
	
	@NotEmpty(message="Please Enter Departure Location")
	@Size(min=3,max=3,message="Enter 3 characters")
	private String departureLocation;
	@NotEmpty(message="Please Enter Arrival Location")
	@Size(min=3,max=3,message="Enter 3 characters")
	private String arrivalLocation;
	private String flightclass;
	private String flightDate;
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	private String outputPreference;
	
	public String getDepartureLocation() {
		return departureLocation;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public String getFlightclass() {
		return flightclass;
	}
	public void setFlightclass(String flightclass) {
		this.flightclass = flightclass;
	}
	public String getOutputPreference() {
		return outputPreference;
	}
	public void setOutputPreference(String outputPreference) {
		this.outputPreference = outputPreference;
	}
	@Override
	public String toString() {
		return "FlightSearchParameter [departureLocation=" + departureLocation + ", arrivalLocation=" + arrivalLocation
				+ ", flightclass=" + flightclass + ", flightDate=" + flightDate + ", outputPreference="
				+ outputPreference + "]";
	}
	
	
	
	
}
