package com.projectabc.project;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;
import com.projectabc.member.MemberDAO;

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
		projDAO.insertProject(project);
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
	
	@RequestMapping(value="projectPage.do")
	public ModelAndView projectPage(
			@RequestParam("projno")String projno
			)throws Exception{

		ProjectDAO projDAO = new ProjectDAO();
		Project project=projDAO.selectProjectByNo(projno);
		MemberDAO memDAO=new MemberDAO();
		List<Member> memList=memDAO.selectMemberListByProjno(projno);		
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/project/projectPage");
		mav.addObject("PROJECT",project);
		mav.addObject("MEM_LIST", memList);
		return mav;
		
	}
	
	@RequestMapping(value="addProjectMember.do")
	public ModelAndView addProjectMember(
			Project proj,
			@RequestParam("memberid")String memid
			)throws Exception{

		ProjectDAO projDAO = new ProjectDAO();
		projDAO.insertJoinProject(proj.getProjno(), memid, "1");
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/projectPage.do");
		mav.addObject("projno",proj.getProjno());
		return mav;
	}
	
}
