package org.simplilearn.workshop.controller;

import org.simplilearn.workshop.service.Bankuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestChequeBookController {
	
	@Autowired
	private Bankuserservice bankuserservice;
	
	
	
	
	@RequestMapping(value="/requestcheques", method = RequestMethod.POST)
	public ModelAndView ReqCheque(ModelAndView model, @RequestParam("cid") String cid) {
		
		int x=bankuserservice.reqcheque(cid);
		System.out.println(x);
		if(x==2) {
			model.addObject("msg","Request Pending");
			model.setViewName("requestcheque");
			return model;
		}
		if(x==1) {
			model.addObject("msg","Request Sent");
		}
		else {
			model.addObject("msg","Something went wrong...please try again");
		}
		model.setViewName("requestcheque");
		return model;
	}
	

}
