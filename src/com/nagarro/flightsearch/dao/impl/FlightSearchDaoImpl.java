package com.nagarro.flightsearch.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import com.nagarro.flightsearch.dao.FlightSearchDAO;
import com.nagarro.flightsearch.hibernate.util.Hibernateutil;
import com.nagarro.flightsearch.model.Flight;

public class FlightSearchDaoImpl implements FlightSearchDAO {
	private static int size=0;
	 Session session=null;
	 static List<Flight> searchedFlight = null;
	 final Logger logger = Logger.getLogger(ThisReference.class);
	public void createSession() {
		try{
			session = Hibernateutil.getSessionFactory().openSession();	
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public List<Flight> getSearchedFlights(final String flightSearchParameter) {
		createSession();
		DateFormat df = new SimpleDateFormat("HHmm");
		Date dateobj = new Date();
		String time = df.format(dateobj);
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj2 = new Date();
		String date = df2.format(dateobj2);
		String[] parameters = flightSearchParameter.split("_");
		Query<Flight> query = session.createQuery("FROM Flight WHERE departureLocation= '"+parameters[0]
							+"' AND arrivalLocation= '"+parameters[1]+"' "
							+ "AND flightClass LIKE '%"+parameters[3]+"%' "
							+ "AND avalability='Y'"
							+" AND (validTill > '"+parameters[2] +"' OR (('"+parameters[2]+"'= validTill AND flightTime > '"+time+"') OR ('"+date+"' < validTill)))"
							+" AND flightNo LIKE '"+parameters[4]+"%'",Flight.class);		
		searchedFlight = query.getResultList();
		//OR (validTill = '"+date+"' AND flightTime > '"+time+"')
		//if(searchedFlight.isEmpty()) {
		//	logger.info("No flights");
//select a.Flight_No , a.Departure_Location, a.Arrival_Location,a.Flight_Time,((b.Flight_Time)-(a.Duration+a.Flight_Time)), b.Flight_No, b.Departure_Location, b.Arrival_Location, b.Flight_Time from flight a, flight b where a.Departure_Location="DEL" 
//		AND a.Arrival_Location = b.Departure_Location AND b.Arrival_Location="MUB" AND ((b.Flight_Time)-(a.Duration+a.Flight_Time) between 100 AND 1000);
		//Query<Flight> query = null;
		//TypedQuery<Flight> query1 = session.createQuery("SELECT F FROM Flight as F, Flight as B WHERE F.departureLocation= '"+parameters[0]
		//			+"' AND F.arrivalLocation = B.departureLocation AND B.arrivalLocation='"+parameters[1]+"' ",Flight.class);
		//	searchedFlight = query1.getResultList();
//			
//		Cr	iteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Flight> criteria = builder.createQuery(Flight.class);
//		Root<Flight> root = criteria.from(Flight.class);
//		criteria.select(root);
//		criteria.where(builder.equal(root.get("departureLoc"), parameters[0]));
//		searchedFlight = session.createQuery(criteria).getResultList();
		//}
		//System.out.println("Result fligts "+searchedFlight.get(0).getDepartureLoc());
		resultOutputPreferences(parameters[4]);
		return getPaginationFlights();
	}
	
	private static List<Flight> getPaginationFlights(){
		size = size+2;
		return searchedFlight.subList(size-2, size);
	}
	
	private void resultOutputPreferences(final String outputPreference){
			
			if(outputPreference.equals("fare")){
				searchedFlight.sort(Comparator.comparing(Flight::getFare));
			} else {
				searchedFlight.sort(Comparator.comparing(Flight::getFlightDuration));
			}	
		}
	
}
