package com.projectabc.project;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;
import com.projectabc.member.MemberDAO;
import com.projectabc.todo.Todo;
import com.projectabc.todo.TodoDAO;
import com.projectabc.todo.TodoList;
import com.projectabc.todo.TodoListDAO;

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
			//@RequestParam("id")String id,
			HttpSession session
			)throws Exception{
		
		Member member = (Member)session.getAttribute("MEMBER");
		ProjectDAO projDAO = new ProjectDAO();
		
		List<Project> projList = (List<Project>)
				projDAO.selectProjectListById(member.getId());
		
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
		MemberDAO memDAO =new MemberDAO();
		TodoDAO todoDAO = new TodoDAO();
		TodoListDAO todoListDAO = new TodoListDAO();
		
		String todoString = "";
		
		Project project=projDAO.selectProjectByNo(projno);	
		List<Member> memList=memDAO.selectMemberListByProjno(projno);	
		
		List<TodoList> todoList = 
				todoListDAO.selectTodolistListByProjno(projno);
		
		List<List<Todo>> todo = new ArrayList<List<Todo>>();
		
		for(int i=0; i<todoList.size(); i++)
		{
			todo.add(todoDAO.selectTodoListByListno(todoList.get(i).getListno()));
		}
		
		for(int i=0; i<todo.size(); i++)
		{
			for(int j=0; j<todo.get(i).size(); j++)
			{
				todoString += todo.get(i).get(j).getTodono()
						+"@"+todo.get(i).get(j).getTodoname();
				
				if(j+1!=todo.get(i).size()) todoString += ",";
			}
			if(i+1!=todo.size()) todoString += "|";
		}
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/project/projectPage");
		mav.addObject("PROJECT",project);
		mav.addObject("MEM_LIST", memList);
		mav.addObject("TODO",todo);
		mav.addObject("TODO_LIST", todoList);
		mav.addObject("TODO_STRING",todoString);
		
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
