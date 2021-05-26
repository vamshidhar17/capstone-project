package org.simplilearn.workshop.controller;

import java.io.IOException;
import java.util.List;

import org.simplilearn.workshop.model.Bankuser;
import org.simplilearn.workshop.service.Bankuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminTransactionController {
	
	@Autowired
	private Bankuserservice bankuserservice;
	
	@RequestMapping(value="/transactioncontrol")
	public ModelAndView Transcontrol(ModelAndView model) throws IOException {
		
		List<Bankuser> dl=bankuserservice.getallusers();
		model.addObject("th", dl);
		model.setViewName("Allusers");
		
		return model;
		
	}

}
