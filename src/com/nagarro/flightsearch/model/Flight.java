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
	@Column(name="Flight_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightId;
	@Column(name="Flight_No")
	private String flightNo;
	@Column(name="Departure_Location")
	private String departureLoc;
	@Column(name="Arrival_Location")
	private String arrivalLoc;
	@Column(name="valid_Till")
	private Date validTill;
	@Column(name="Flight_Time")
	private String flightTime;
	@Column(name="Duration")
	private String flightDuration;
	@Column(name="Fare")
	private double fare;
	@Column(name="Avalability")
	private char seatAvalability;
	@Column(name="Flight_Class")
	private String flightClass;
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepartureLoc() {
		return departureLoc;
	}
	public void setDepartureLoc(String departureLoc) {
		this.departureLoc = departureLoc;
	}
	public String getArrivalLoc() {
		return arrivalLoc;
	}
	public void setArrivalLoc(String arrivalLoc) {
		this.arrivalLoc = arrivalLoc;
	}
	public Date getValidTill() {
		return validTill;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public String getFlightDuration() {
		return flightDuration;
	}
	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public char getSeatAvalability() {
		return seatAvalability;
	}
	public void setSeatAvalability(char seatAvalability) {
		this.seatAvalability = seatAvalability;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightNo=" + flightNo + ", departureLoc=" + departureLoc
				+ ", arrivalLoc=" + arrivalLoc + ", validTill=" + validTill + ", flightTime=" + flightTime
				+ ", flightDuration=" + flightDuration + ", fare=" + fare + ", seatAvalability=" + seatAvalability
				+ ", flightClass=" + flightClass + "]";
	}

}
