package com.projectabc.project;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectService {
	@RequestMapping(value="makeProjectForm.do")
	public ModelAndView makeProjectForm()throws Exception{
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/project/makeProjectForm");		
		return mav;
		
	}
	@RequestMapping(value="makeProject.do")
	public ModelAndView makeProject(
			Project project
			)throws Exception{
		

		System.out.println("=====");
		System.out.println(project.projname);
		System.out.println(project.projcont);
		System.out.println(project.managerid);
		
		ProjectDAO projDAO = new ProjectDAO();
		projDAO.insertProject(project);
			
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/login/login");		
		return mav;
		
	}
	
	@RequestMapping(value="showProjectList.do")
	public ModelAndView showProjectList(
			@RequestParam("id")String id
			)throws Exception{

		ProjectDAO projDAO = new ProjectDAO();
		
		ArrayList<Project> projList = new ArrayList<Project>();
		//projList = projDAO.selectProjectList(id);
		
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/project/showProjectList");
		mav.addObject("PROJ_LIST",projList);
		return mav;
		
	}
	
}
