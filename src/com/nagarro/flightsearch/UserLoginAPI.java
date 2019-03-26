package com.nagarro.flightsearch;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nagarro.flightsearch.dao.UserLoginDAO;
import com.nagarro.flightsearch.dao.impl.LoginDaoImpl;
import com.nagarro.flightsearch.model.User;
@Path("/login")
public class UserLoginAPI {
	UserLoginDAO dao = new LoginDaoImpl();
		
		@POST
	    @Produces(MediaType.APPLICATION_JSON)
		public User getIt(User user) {
	        return dao.login(user);
	    }
}
