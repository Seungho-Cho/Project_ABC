package com.projectabc.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;
import com.projectabc.member.MemberDAO;

@Controller
public class TodoService {
	
	@RequestMapping(value="addProjectTodoList.do")
	public ModelAndView addProjectTodoList(
			TodoList todoList
			)throws Exception{

		TodoListDAO todoListDAO = new TodoListDAO();
		todoListDAO.insertTodolist(todoList);
			
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/projectPage.do");
		mav.addObject("projno",todoList.getProjno());
		return mav;
	}
	
	@RequestMapping(value="addProjectTodo.do")
	public ModelAndView addProjectTodo(
			Todo todo,
			@RequestParam(value="projno")String projno
			)throws Exception{

		System.out.println("list no:"+todo.getListno());
		TodoDAO todoDAO = new TodoDAO();
		todoDAO.insertTodo(todo);
			
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/projectPage.do");
		mav.addObject("projno",projno);
		return mav;
	}
	
	@RequestMapping(value="updateTodo.do")
	public void updateTodo(
			@RequestParam(value="todoString")String todoString,
			@RequestParam(value="projno")String projno
			)throws Exception{

		TodoDAO todoDAO = new TodoDAO();
		TodoListDAO todoListDAO = new TodoListDAO();
		
		List<TodoList> todoList = todoListDAO.selectTodolistListByProjno(projno);	
		List<List<Todo>> todo = new ArrayList<List<Todo>>();

		//System.out.println(todoString);
		String todos[] = todoString.split(":");
		String temp[] = null;
		//dumpArray(todos);
		for(int i=0; i<todos.length; i++)
		{
			
			temp = todos[i].split(",");
			//System.out.println("temp :"+i);
			//dumpArray(temp);
			for(int j=0; j<temp.length; j++)
			{
				//System.out.println(temp[j]);
				todoDAO.updateTodoListno(temp[j],todoList.get(i).getListno());
			}
		}
	
	
	}
	
	@RequestMapping(value="showTodo.do")
	public ModelAndView showTodo (
			Todo todo
			)throws Exception{
		TodoDAO todoDAO = new TodoDAO();
		MemberDAO memDAO = new MemberDAO();
		TodoCommentDAO commDAO = new TodoCommentDAO();
		
		todo = todoDAO.selectTodoByTodono(todo.getTodono());
		List<Member> memList = new ArrayList<Member>();
		//List<Member> memList = memDAO().
		List<TodoComment> commList = 
				commDAO.selectTodoCommentListByTodono(todo.getTodono());
		
				
		ModelAndView mav=new ModelAndView();
		mav.setViewName("todo/showTodo");
		mav.addObject("TODO",todo);
		mav.addObject("TODO_MEM_LIST",memList);
		mav.addObject("COMM_LIST",commList);
		return mav;		
	}
	
	@RequestMapping(value="addTodoComment.do")
	public void addTodoComment (
			Todo todo,
			TodoComment comm
			)throws Exception{
		comm.setTodono(todo.getTodono());
		TodoCommentDAO commDAO = new TodoCommentDAO();
		commDAO.insertTodoComment(comm);
	}
	
}
