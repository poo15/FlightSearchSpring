package com.nagarro.flightsearch.dao.implementation;

import java.util.Comparator;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import com.nagarro.flightsearch.dao.DAO;
import com.nagarro.flightsearch.hibernate.util.Hibernateutil;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.FlightSearchParameter;
import com.nagarro.flightsearch.model.User;

public class DaoImplementation implements DAO{
	
	 Session session=null;
	 List<Flight> searchedFlight = null;
	 final Logger logger = Logger.getLogger(ThisReference.class);
	
	@Override
	public User login(final String email,final String password) {
		logger.info("In Dao Layer");
		createSession();
		final Query<User> query = session.createQuery("FROM User WHERE email= '"+email+"' AND password= '"+password+"'",User.class);
		return query.uniqueResult();
	}

	public void createSession() {
		try{
			session = Hibernateutil.getSessionFactory().openSession();	
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public List<Flight> getSearchedFlights(final FlightSearchParameter flightSearchParameter) {
		createSession();
		final Query<Flight> query = session.createQuery("FROM Flight WHERE Departure_Location= '"+flightSearchParameter.getDepartureLocation()
							+"' AND Arrival_Location= '"+flightSearchParameter.getArrivalLocation()+"' "
									+ "AND Flight_Class LIKE '%"+flightSearchParameter.getFlightclass()+"%' "
											+ "AND Avalability='Y'"
									+" AND valid_Till >= '"+flightSearchParameter.getFlightDate()+" 00:00:00'",Flight.class);
		
		searchedFlight = query.getResultList();
		resultOutputPreferences(flightSearchParameter.getOutputPreference());
		return searchedFlight;
	}
	
	private void resultOutputPreferences(final String outputPreference){
			
			if(outputPreference.equals("fare")){
				searchedFlight.sort(Comparator.comparing(Flight::getFare));
			} else {
				searchedFlight.sort(Comparator.comparing(Flight::getFlightDuration).thenComparing(Flight::getFare));
			}	
		}
}
