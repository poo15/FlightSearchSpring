package com.nagarro.flightsearch.dao.impl;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;

import com.nagarro.flightsearch.dao.UserLoginDAO;
import com.nagarro.flightsearch.hibernate.util.Hibernateutil;
import com.nagarro.flightsearch.model.Flight;
import com.nagarro.flightsearch.model.User;

public class LoginDaoImpl implements UserLoginDAO{
	
	 Session session=null;
	 List<Flight> searchedFlight = null;
	 final Logger logger = Logger.getLogger(ThisReference.class);
	
	@Override
	public User login(User user) {
		logger.info("In Dao Layer");
		createSession();
		final Query<User> query = session.createQuery("FROM User WHERE email= '"+user.getEmail()+"' AND password= '"+user.getPassword()+"'",User.class);
		return query.uniqueResult();
	}

	public void createSession() {
		try{
			session = Hibernateutil.getSessionFactory().openSession();	
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

//	@Override
//	public List<Flight> getSearchedFlights(final String flightSearchParameter) {
//		createSession();
//		String[] parameters = flightSearchParameter.split("_");
////		Query<Flight> query = session.createQuery("FROM Flight WHERE departureLocation= '"+parameters[0]
////							+"' AND arrivalLocation= '"+parameters[1]+"' "
////									+ "AND flightClass LIKE '%"+parameters[3]+"%' "
////											+ "AND avalability='Y'"
////									+" AND validTill >= '"+parameters[2]+"'",Flight.class);
////		
////		searchedFlight = query.getResultList();
//		//if(searchedFlight.isEmpty()) {
//		//	logger.info("No flights");
////select a.Flight_No , a.Departure_Location, a.Arrival_Location,a.Flight_Time,((b.Flight_Time)-(a.Duration+a.Flight_Time)), b.Flight_No, b.Departure_Location, b.Arrival_Location, b.Flight_Time from flight a, flight b where a.Departure_Location="DEL" 
////		AND a.Arrival_Location = b.Departure_Location AND b.Arrival_Location="MUB" AND ((b.Flight_Time)-(a.Duration+a.Flight_Time) between 100 AND 1000);
//		Query<Flight> query = null;
//		TypedQuery<Flight> query1 = session.createQuery("SELECT F FROM Flight as F, Flight as B WHERE F.departureLocation= '"+parameters[0]
//					+"' AND F.arrivalLocation = B.departureLocation AND B.arrivalLocation='"+parameters[1]+"' ",Flight.class);
//			searchedFlight = query1.getResultList();
////			
////		Cr	iteriaBuilder builder = session.getCriteriaBuilder();
////		CriteriaQuery<Flight> criteria = builder.createQuery(Flight.class);
////		Root<Flight> root = criteria.from(Flight.class);
////		criteria.select(root);
////		criteria.where(builder.equal(root.get("departureLoc"), parameters[0]));
////		searchedFlight = session.createQuery(criteria).getResultList();
//		//}
//		System.out.println("Result fligts "+searchedFlight.get(0).getDepartureLoc());
//		//resultOutputPreferences(parameters[4]);
//		return searchedFlight;
//	}
//	
//	private void resultOutputPreferences(final String outputPreference){
//			
//			if(outputPreference.equals("fare")){
//				searchedFlight.sort(Comparator.comparing(Flight::getFare));
//			} else {
//				searchedFlight.sort(Comparator.comparing(Flight::getFlightDuration));
//			}	
//		}
}
