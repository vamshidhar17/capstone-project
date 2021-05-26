package org.simplilearn.workshop.controller;

import java.io.IOException;
import java.util.List;

import org.simplilearn.workshop.model.Bankuser;
import org.simplilearn.workshop.model.Transaction;
import org.simplilearn.workshop.service.Bankuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
	
	
	@Autowired
	private Bankuserservice bankuserservice;
	
	@RequestMapping("profile/{cid}")
	public ModelAndView profile(ModelAndView model, @PathVariable("cid") int cid)
			throws IOException {
		//System.out.println(cid);
		
		List<Bankuser> dl1 =bankuserservice.getbal(String.valueOf(cid));
		
		model.addObject("th", dl1);
		model.setViewName("profile");
		
		return model;
	}
}
