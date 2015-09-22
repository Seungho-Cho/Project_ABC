package com.projectabc.login;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;
import com.projectabc.project.Project;
import com.projectabc.project.ProjectDAO;

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
			Member member,HttpSession session
			)throws Exception{
		
		//System.out.println(member.getId());
		//System.out.println(member.getPassword());
		
		session.setAttribute("LOGIN_MEMBER", member);
		ModelAndView mav=new ModelAndView();
		mav.addObject("id",member.getId());
		mav.addObject("password",member.getPassword());
		mav.setViewName("/login/tryLogin");		
		return mav;
		
		
		
		/*ProjectDAO projDAO = new ProjectDAO();
		
		List<Project> projList = (List<Project>)
				projDAO.selectProjectListById(member.getId());
		

		System.out.println(""+projList.size());
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/project/showProjectList");
		mav.addObject("PROJ_LIST",projList);
		return mav;*/
		
	}
	
	@RequestMapping(value="tryLogout.do")
	public ModelAndView tryLogout(
			HttpSession session
			)throws Exception{
		
		session.invalidate();
		
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
	/*@RequestMapping(value="showProjectList.do")
	public ModelAndView showProjectList(
			Member member
			)throws Exception{
	
		
		ProjectDAO projDAO = new ProjectDAO();
		
		List<Project> projList = (List<Project>)
				projDAO.selectProjectListById(member.getId());
		

		System.out.println(""+projList.size());
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/project/showProjectList");
		mav.addObject("PROJ_LIST",projList);
		return mav;
		
	}*/
}
