package com.projectabc.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoService {
	
	@RequestMapping(value="addProjectTodoList.do")
	public ModelAndView addProjectTodoList(
			@RequestParam("projno")String projno
			)throws Exception{
		
		// inserttodo
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/projectPage.do");
		mav.addObject("projno",projno);
		return mav;
	}
}
