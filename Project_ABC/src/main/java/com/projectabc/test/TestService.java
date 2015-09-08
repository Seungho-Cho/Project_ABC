package com.projectabc.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value="todoTest.do")
	public void todoTest(
			@RequestParam("test")String test
			)throws Exception{
		System.out.println(test);
	}
}
