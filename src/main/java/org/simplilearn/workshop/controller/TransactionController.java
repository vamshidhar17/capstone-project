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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionController {
	
	@Autowired
	private Bankuserservice bankuserservice;
	
	@RequestMapping(value = "transhistory/{cid}")
	public ModelAndView transHis(ModelAndView model, @PathVariable("cid") String cid)
			throws IOException {
		//System.out.println(cid);
		List<Transaction> dl =bankuserservice.transactionhistory(cid);
		List<Bankuser> dl1 =bankuserservice.getbal(cid);
		model.addObject("th", dl);
		model.addObject("th1", dl1.get(0).getBalance());
		model.setViewName("Transhis");
		
		return model;
	}
	

}
