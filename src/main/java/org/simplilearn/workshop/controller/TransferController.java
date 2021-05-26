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
public class TransferController {
	@Autowired
	private Bankuserservice bankuserservice;
	
	@RequestMapping("/Money/{cid}")
	public ModelAndView CheckUser(ModelAndView mv,@PathVariable("cid") String cid) {
		List<Bankuser> dl = bankuserservice.getbal(cid);
		System.out.println(dl.get(0).getTrans_status());
		if(dl.get(0).getTrans_status().equals("allow")) {
			mv.addObject("msg", "This Control is Blocked by Admin");
			mv.setViewName("Mainmenu");
			return mv;
		}
		mv.setViewName("Moneytransfer");
		return mv;
	}
	
	
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public ModelAndView createUser(@RequestParam("s_acc") String s_acc,@RequestParam("pass") String pass,@RequestParam("r_acc") String r_acc,@RequestParam("type") String type,@RequestParam("name") String name,@RequestParam("amount") int amount, ModelAndView mv)
	{	
		int bal=0,kl=0;
		String cid = null;
		 Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");   
         String d = dateFormat.format(date);  	
         DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
         LocalDateTime now=LocalDateTime.now();
         String time=d+" "+dtf.format(now);
      
		Bankuser user = new Bankuser();
		user.setUsername(s_acc);
		user.setPassword(pass);
		List<Bankuser> dl = bankuserservice.getbal(s_acc);
		for (Bankuser x:dl)
		{
			bal=x.getBalance();
			cid=x.getAcc_num();
		}
		Random r1 = new Random();
		int n1 = r1.nextInt(999999);
		
		if(bal>=amount)
		{
		int y=bal-amount;
		user.setBalance(y);
		
		int counter = bankuserservice.balwithdraw(s_acc,pass,y);    
		int j=bankuserservice.deposit(r_acc,amount);
		Transaction trans =new Transaction();
		trans.setTid(n1);
		trans.setAcctype(type);
		trans.setAmount(amount);
		trans.setBal(y);
		trans.setDate(time);
		trans.setFaccno(s_acc);
		trans.setTaccno(r_acc);
		trans.setTranstype("online");
		if (counter> 0) {
			int value = bankuserservice.inserttrans(trans);   

			if(value>0)
			{
				mv.addObject("msg", "Amount Transferes successful.");
				mv.setViewName("Moneytransfer");
			}
		} else {
			System.out.println("No");
	}
	}
		
		return mv;
		
	}
}
