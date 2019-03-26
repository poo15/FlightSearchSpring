package com.nagarro.flightsearch.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="Flight")
@DynamicUpdate
public class Flight {
	@Id
	@Column(name="flightId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightId;
	@Column(name="flightNo")
	private String flightNo;
	@Column(name="departureLocation")
	private String departureLocation;
	@Column(name="arrivalLocation")
	private String arrivalLocation;
	@Column(name="validTill")
	private String validTill;
	@Column(name="flightTime")
	private String flightTime;
	@Column(name="duration")
	private String duration;
	@Column(name="fare")
	private double fare;
	@Column(name="avalability")
	private char avalability;
	@Column(name="flightClass")
	private String flightClass;
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepartureLoc() {
		return departureLocation;
	}
	public void setDepartureLoc(String departureLoc) {
		this.departureLocation = departureLoc;
	}
	public String getArrivalLoc() {
		return arrivalLocation;
	}
	public void setArrivalLoc(String arrivalLoc) {
		this.arrivalLocation = arrivalLoc;
	}
	public String getValidTill() {
		return validTill;
	}
	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public String getFlightDuration() {
		return duration;
	}
	public void setFlightDuration(String flightDuration) {
		this.duration = flightDuration;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public char getSeatAvalability() {
		return avalability;
	}
	public void setSeatAvalability(char seatAvalability) {
		this.avalability = seatAvalability;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	@Override
	public String toString() {
		return "Flight [FlightId=" + flightId + ", FlightNo=" + flightNo + ", DepartureLocation=" + departureLocation
				+ ", ArrivalLocation=" + arrivalLocation + ", validTill=" + validTill + ", FlightTime=" + flightTime
				+ ", Duration=" + duration + ", Fare=" + fare + ", Avalability=" + avalability + ", FlightClass="
				+ flightClass + "]";
	}
	

}
