package org.simplilearn.workshop.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;


import org.simplilearn.workshop.model.Bankuser;
import org.simplilearn.workshop.model.Transaction;
import org.simplilearn.workshop.service.Bankuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankcashDeposit {
	@Autowired
	private Bankuserservice bankuserservice;
	
	@RequestMapping("/Depositm/{cid}")
	public ModelAndView createUser( ModelAndView mv,@PathVariable("cid") String cid) {
		//int bal=0;
		int counter1 = bankuserservice.deposit(cid,-1);
		if(counter1==2) {
			mv.addObject("msg", "This Control is Blocked by Admin");
			mv.setViewName("Mainmenu");
			return mv;
		}
		mv.setViewName("Deposit");
		return mv;
	}
	

	@RequestMapping(value = "/bankdeposit", method = RequestMethod.POST)
	public ModelAndView createUser(@RequestParam("aid") String aid,@RequestParam("pass") String pass,@RequestParam("amount") int amount, ModelAndView mv) {
		int bal=0;
		int counter1 = bankuserservice.deposit(aid,-1);
		if(counter1==2) {
			mv.addObject("msg", "This Control is Blocked by Admin");
			mv.setViewName("Mainmenu");
			return mv;
		}
		String cid=null,atype=null;
		 Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");   
         String d = dateFormat.format(date);  	
         DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
         LocalDateTime now=LocalDateTime.now();
         String time= d+" "+dtf.format(now);
		Bankuser user = new Bankuser();
		user.setUsername(aid);
		user.setPassword(pass);
		List<Bankuser> dl = bankuserservice.getbal(aid);
		for (Bankuser x:dl)
		{
			bal=x.getBalance();
			cid=x.getAcc_num();
			atype=x.getType();
		}
		int y=bal+amount;
		//System.out.println(y);
		user.setBalance(y);
		int counter = bankuserservice.deposit(aid,y);
		Random r1 = new Random();
		int n1 = r1.nextInt(999999);
		Transaction trans =new Transaction();
		trans.setTid(n1);
		trans.setAcctype("primary");
		trans.setAmount(amount);
		trans.setBal(bal);
		trans.setDate(time);
		trans.setFaccno(cid);
		trans.setTaccno("self");
		trans.setTranstype("online");
		
		if (counter> 0) {
			mv.addObject("msg", "Amount Deposit successful.");
			List<Bankuser> l = bankuserservice.getbal(aid);
			for (Bankuser x:l)
			{
				bal=x.getBalance();
			}
			trans.setBal(bal);
			int value = bankuserservice.inserttrans(trans);   
			mv.addObject("bal",bal);
			mv.setViewName("Mainmenu");
		}
		else {
			mv.addObject("msg", "Error in depositing amount");
			mv.setViewName("Moneytransfer");
		}
		
		
		
		
		return mv;
		
		
	}

}
