package com.projectabc.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.todo.Todo;
import com.projectabc.todo.TodoDAO;
import com.projectabc.todo.TodoList;
import com.projectabc.todo.TodoListDAO;

@Controller
public class TestService {
	@RequestMapping(value="todoTest.do")
	public void todoTest(
			@RequestParam("test")String test
			)throws Exception{
		System.out.println(test);
	}
	
	@RequestMapping(value="calTest.do")
	public ModelAndView calTest(
			@RequestParam("projno")String projno
			)throws Exception{
		TodoDAO todoDAO=new TodoDAO();
		TodoListDAO todolistDAO=new TodoListDAO();
		List<TodoList> todolistList=todolistDAO.selectTodolistListByProjno(projno);
		List<Todo> todoList=new ArrayList();
		for(TodoList tdl:todolistList) {
			List<Todo> tdL=todoDAO.selectTodoListByListno(tdl.getListno());
			for(Todo todo:tdL) {
				todoList.add(todo);
			}
		}
		System.out.println(todoList);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("calendar/calendar");
		mav.addObject("TODO_LIST", todoList);
		return mav;
	}
}
