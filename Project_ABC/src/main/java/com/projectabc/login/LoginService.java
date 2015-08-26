package com.projectabc.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginService {
	
	@RequestMapping(value="login.do")
	public ModelAndView login()throws Exception{
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/login/login");		
		return mav;
	}
	
	@RequestMapping(value="signup.do")
	public ModelAndView signup()throws Exception{
		
		//ModelAndView mav=new ModelAndView();
		//mav.setViewName("/member/signup");		
		//return mav;
		System.out.println("su");
		return null;
	}
}
