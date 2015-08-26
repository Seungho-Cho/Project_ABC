package com.projectabc.member;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;
import com.projectabc.member.MemberDAO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@Controller
public class MemberService {

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
