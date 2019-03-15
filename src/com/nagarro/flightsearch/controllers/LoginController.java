package com.nagarro.flightsearch.controllers;

import javax.validation.Valid;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.jboss.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.flightsearch.model.FlightSearchParameter;
import com.nagarro.flightsearch.model.User;
import com.nagarro.flightsearch.service.Service;

/*
 * @author Pooja
 */
@Controller
public class LoginController {
	Logger logger = Logger.getLogger(ThisReference.class);
	final  ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	final Service service = appContext.getBean("service", Service.class);
	final ModelAndView modelView = new ModelAndView();
	
	@RequestMapping(value="/login",method= RequestMethod.POST)
	public ModelAndView login(Model model,@RequestParam("email") final String email, @RequestParam("password") final String password) {
		User user = service.login(email, password);
		if(user==null) {
			logger.info("No User");
			modelView.setViewName("index.jsp");
			modelView.addObject("invalidUser",true);
		} else {
			model.addAttribute("flightSearchParameter",new FlightSearchParameter());
			modelView.setViewName("dashboard.jsp");
			modelView.addObject("userEmail",user.getEmail());
		}
		return modelView;
	}
	
	
	@RequestMapping(value="/logout",method= RequestMethod.GET)
	public ModelAndView logout() {
			modelView.setViewName("index.jsp");
			return modelView;
	}
	
	@RequestMapping(value="/search",method= RequestMethod.POST)
	public ModelAndView login2(@Valid @ModelAttribute("flightSearchParameter") FlightSearchParameter flightParameter, BindingResult result) {
		logger.info("In search");
		if(result.hasErrors()) {
			modelView.setViewName("dashboard.jsp");
		}
		modelView.addObject("flights",service.getSearchedFlights(flightParameter));
		return modelView;
	}
	
}
