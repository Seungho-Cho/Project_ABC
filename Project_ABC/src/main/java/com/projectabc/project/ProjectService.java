package com.projectabc.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;

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
			//, @RequestParam("id")String memid
			)throws Exception{
			
		ProjectDAO projDAO = new ProjectDAO();
		projDAO.insertProject(project, "0");
		//projDAO.insertJoinProject(projno, memid, 0);
			
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/showProjectList.do?id="+project.getManagerid());		
		return mav;
		
	}
	
	@RequestMapping(value="showProjectList.do")
	public ModelAndView showProjectList(
			@RequestParam("id")String id
			)throws Exception{

		ProjectDAO projDAO = new ProjectDAO();
		
		List<Project> projList = (List<Project>)
				projDAO.selectProjectListById(id);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/project/showProjectList");
		mav.addObject("PROJ_LIST",projList);
		return mav;
		
	}
	
}
