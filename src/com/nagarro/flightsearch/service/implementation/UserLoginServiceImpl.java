package com.nagarro.flightsearch.service.implementation;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.nagarro.flightsearch.dao.UserLoginDAO;
import com.nagarro.flightsearch.model.User;
import com.nagarro.flightsearch.service.UserLoginService;

public class UserLoginServiceImpl implements UserLoginService{
	private UserLoginDAO dao;
	ResteasyClient client = new ResteasyClientBuilder().build();
	//http://localhost:8080/flightsearch/webapi/searchFlight?parameter=DEL_MUB_2019-08-2016
	ResteasyWebTarget target = client.target("http://localhost:8080/flightsearch/webapi");
	public void setDao(final UserLoginDAO dao) {
		this.dao = dao;
	}

	@Override
	public User login(User user) {
		Response response = target.path("/login").request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(user, MediaType.APPLICATION_JSON));
		return response.readEntity(User.class);
	}

	

}
