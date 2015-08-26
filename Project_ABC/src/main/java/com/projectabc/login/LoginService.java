package com.projectabc.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;

@Controller
public class LoginService {
	
	@RequestMapping(value="login.do")
	public ModelAndView login()throws Exception{
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/login/login");		
		return mav;
	}
	
	@RequestMapping(value="tryLogin.do")
	public ModelAndView tryLogin(
			Member member
			)throws Exception{
		
		System.out.println(member.getId());
		System.out.println(member.getPassword());
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/login/login");		
		return mav;
	}
	@RequestMapping(value="signup.do")
	public ModelAndView signup()throws Exception{
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/member/addMemberForm");		
		return mav;
		
	}
}
