package com.projectabc.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

		TodoDAO todoDAO = new TodoDAO();
		todoDAO.insertTodo(todo);
			
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/projectPage.do");
		mav.addObject("projno",projno);
		return mav;
	}
}
