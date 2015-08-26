package com.projectabc.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectService {
	
	@RequestMapping(value="makeProject.do")
	public ModelAndView makeProject(
			Project project
			)throws Exception{
		

		System.out.println("=====");
		System.out.println(project.projname);
		System.out.println(project.projcont);
		System.out.println(project.managerid);
		
		
		/*ModelAndView mav=new ModelAndView();
		mav.setViewName("/login/login");		
		return mav;*/
		
		System.out.println("makeProj");
		return null;
	}
	
}
