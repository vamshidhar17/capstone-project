package org.simplilearn.workshop.controller;



import org.simplilearn.workshop.model.Bankuser;
import org.simplilearn.workshop.service.Bankuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminRegistrationcontroller {
	@Autowired
	private Bankuserservice bankuserservice;
	
	@RequestMapping(value = "/adminregistration", method = RequestMethod.POST)
	public ModelAndView createUser(@RequestParam("acc") String acc,@RequestParam("type") String type,@RequestParam("fname") String fname,@RequestParam("uname") String uname,
			@RequestParam("pass") String pass, @RequestParam("gender") String gender,@RequestParam("phnum") String phnum,@RequestParam("email") String email,@RequestParam("caddress") String caddress,@RequestParam("country") String country,@RequestParam("aadhar") String aadhar,@RequestParam("date") String date,ModelAndView mv) {
		Bankuser user= new Bankuser();
		user.setAadhar(aadhar);
		user.setAcc_num(acc);
		user.setAddress(caddress);
		user.setCountry(country);
		user.setDob(date);
		user.setEmail(email);
		user.setFullname(fname);
		user.setGender(gender);
		user.setPassword(pass);
		user.setPhone(phnum);
		user.setType(type);
		user.setUsername(uname);
		int s= bankuserservice.userregister(user);
		 if (s > 0)
         {
           mv.addObject("msg", "User Registered successfully.Please login.");
           mv.setViewName("adminlogin");
         } 
        else {
          mv.addObject("msg", "Error- check the console log.");
          mv.setViewName("adminlogin");
         }

          return mv;
	}

}
