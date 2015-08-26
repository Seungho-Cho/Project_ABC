package com.project_abc.member;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MemberService {
	@RequestMapping(value="addMemberForm.do")
	public ModelAndView addMemberForm () throws Exception{
	//1.CollegeDAO.selectCollegeList()를 호출해서 리턴된 전체 학과 정보를 List에 저장
		CollegeDAO collegeDAO=new CollegeDAO();
		List<College> collegeList=collegeDAO.selectCollegeList();
	//2. DepartmentDAO.selectStudentList(100)메서드를 호출하고 
	//리턴된 단과대학 100의 전체 학과정보를  List에 저장
		DeptDAO deptDAO=new DeptDAO();
		List<Dept> deptList=deptDAO.selectDeptList("100");
	//3.ModelAndView 객체 생성
		ModelAndView mav=new ModelAndView();
	//4. 1의 전체단대리스트를 3객체에 저장 : 이름: COLLEGE_LIST
		mav.addObject("COLLEGE_LIST", collegeList);
	//5. 2의 단대 100의 전체학과리스트를 3객체에 저장 이름:DEPT_LIST
		mav.addObject("DEPT_LIST", deptList);
	//6. 3객체의 이동할 페이지는 /Member/addMemberForm.jsp 로 이동하도록 3객체의 setViewName에 /Member/addMemberForm 대입
		mav.setViewName("/Member/addMemberForm");
	//7.3객체 리턴
		return mav;
	}
	
	@RequestMapping("/idcheck.do")
	public void  idchek(HttpServletResponse response,
			@RequestParam("id") String id) throws Exception{
		String result=null;
		MemberDAO MemberDAO=new MemberDAO();
		Member member=MemberDAO.selectMemberById(id);
		if(member==null) {
			result="사용가능한 아이디입니다";
		} else {
			result="이미 사용중인 아이디입니다";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}

	@RequestMapping(value="addMember.do")
	public ModelAndView addMember(Member member) throws Exception{
		//1.MemberDAO.insertMember() 호출
		MemberDAO MemberDAO=new MemberDAO();
		MemberDAO.insertMember(member);
		//2.ModelAndView 객체 생성
		ModelAndView mav=new ModelAndView();
		//3. 2객체의 이동할 페이지로 forward:/viewBoardList.do 설정
		mav.setViewName("forward:/viewBoardList.do");
		//4.2객체 리턴
		return mav;
	}

}
