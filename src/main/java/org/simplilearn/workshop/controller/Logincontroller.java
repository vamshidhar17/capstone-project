package org.simplilearn.workshop.controller;




import org.simplilearn.workshop.model.Bankuser;
import org.simplilearn.workshop.service.Bankuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Logincontroller {
	@Autowired
	private Bankuserservice bankuserservice;
	
	
	@RequestMapping("/")
	public String login() {
		return "welcome";
	}
	@RequestMapping(value="/logging", method = RequestMethod.POST)
		public ModelAndView createUser(@RequestParam("cid") String cid,@RequestParam("pass") String pass, ModelAndView mv) {

			Bankuser user = new Bankuser();
			user.setAcc_num(cid);
			user.setPassword(pass);
			int counter = bankuserservice.checklogin(cid,pass);
			if (counter== 2) {
				mv.addObject("msg", "Your account is locked please contact admin");
				mv.addObject("cid",cid);
				mv.setViewName("login");
				return mv;
			}
			if (counter> 0) {
				mv.addObject("msg", "Login registration successful.");
				mv.addObject("cid",cid);
				mv.setViewName("Mainmenu");
			} else {
				mv.addObject("msg", "Invalid login Credentails");
				mv.setViewName("welcome");
			}
			return mv;
		
		
		
		
		
	}

}
