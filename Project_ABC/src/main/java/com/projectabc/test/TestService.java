package com.projectabc.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;
import com.projectabc.member.MemberDAO;
import com.projectabc.project.Project;
import com.projectabc.project.ProjectDAO;
import com.projectabc.todo.Todo;
import com.projectabc.todo.TodoDAO;
import com.projectabc.todo.TodoList;
import com.projectabc.todo.TodoListDAO;

@Controller
public class TestService {
	@RequestMapping(value="listTest.do")
	public ModelAndView listTest()throws Exception{
	
		String projno = "81";
		
		ProjectDAO projDAO = new ProjectDAO();
		MemberDAO memDAO =new MemberDAO();
		TodoDAO todoDAO = new TodoDAO();
		TodoListDAO todoListDAO = new TodoListDAO();
		
		Project project=projDAO.selectProjectByNo(projno);	
		List<Member> memList=memDAO.selectMemberListByProjno(projno);	
		
		List<TodoList> todoList = 
				todoListDAO.selectTodolistListByProjno(projno);
		
		List<List<Todo>> todo = new ArrayList<List<Todo>>();
		
		for(int i=0; i<todoList.size(); i++)
		{
			todo.add(todoDAO.selectTodoListByListno(todoList.get(i).getListno()));
		}
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/example/csh/test/1/test");
		mav.addObject("PROJECT",project);
		mav.addObject("MEM_LIST", memList);
		mav.addObject("TODO",todo);
		mav.addObject("TODO_LIST", todoList);
		
		return mav;
	
	}
}
