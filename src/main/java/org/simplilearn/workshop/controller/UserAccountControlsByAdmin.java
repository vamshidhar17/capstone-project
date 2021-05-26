package org.simplilearn.workshop.controller;



import java.util.List;

import org.simplilearn.workshop.model.Bankuser;
import org.simplilearn.workshop.service.Bankuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAccountControlsByAdmin {
	@Autowired
	private Bankuserservice bankuserservice;
	
	@RequestMapping(value = "admintrans/{cid}/{trans}")
	public ModelAndView AccountControls(ModelAndView model,@PathVariable("cid") String cid,@PathVariable("trans") String tran) {
		//System.out.println(cid);
		//System.out.println(cid);
		if(tran.equals("deny")) {
			tran="allow";
		}else {
			tran="deny";
		}
		bankuserservice.accountControl(cid, tran);
		
		model.setViewName("Adminmenu");
		return model;
	}
	
	@RequestMapping(value = "admintrans/deposite/{cid}/{trans}")
	public ModelAndView AccountDeposit(ModelAndView model,@PathVariable("cid") String cid,@PathVariable("trans") String tran) {
		//System.out.println(cid);
		//System.out.println(cid);
		if(tran.equals("deny")) {
			tran="allow";
		}else {
			tran="deny";
		}
		bankuserservice.depositeControl(cid, tran);
		model.setViewName("Adminmenu");
		
		return model;
	}
	
	@RequestMapping(value = "admintrans/block/{cid}/{trans}")
	public ModelAndView AccountBlock(ModelAndView model,@PathVariable("cid") String cid,@PathVariable("trans") String tran) {
		//System.out.println(cid);
		//System.out.println(cid);
		if(tran.equals("block")) {
			tran="ublock";
		}else {
			tran="block";
		}
		bankuserservice.block(cid, tran);
		model.setViewName("Allusers");
		
		return model;
	}
	
	

	@RequestMapping(value = "/request")
	public ModelAndView AccountBlock(ModelAndView model) {
		List<Bankuser> dl=bankuserservice.getchequerequestusers();
		model.addObject("th", dl);
		model.setViewName("chequeRequestControl");
		
		return model;

	}
	
	@RequestMapping(value = "/cheque/{cid}")
	public ModelAndView chequereq(ModelAndView model, @PathVariable("cid") String cid) {
		
		
		int a=bankuserservice.chequegrant(cid);
		model.setViewName("chequeRequestControl");
		
		return model;

	}
	
	
	
	
	
	
}