package com.bitacademy.comment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentService {
	@RequestMapping(value="addComment.do")
	public ModelAndView addComment(Comment comment,HttpServletRequest request)throws Exception{
		// 1.클라이언트의 아이피를 알아내서 String 변수에 저장
		//클라이언트의 아이피는 request.getRemoteAddr() 로 알아낼수 있음
		String clientIp=request.getRemoteAddr();
		//2. 1을 매개변수 comment의 ip속성에 저장
		comment.setWriteip(clientIp);		
		//3.CommentDAO.insertComment() 호출
		CommentDAO commentDAO=new CommentDAO();
		commentDAO.insertComment(comment);
		//4.ModelAndView 객체 생성
		ModelAndView mav=new ModelAndView();
		//5. 4객체의 이동할 페이지로 forward:/viewBoard.do?num=게시물번호  설정 게시물번호는 comment의 num 속성에 저장되있음
		mav.setViewName("forward:/viewBoard.do");
		mav.addObject("num", comment.getNum());
		//6.4객체 리턴
		return mav;
	}

}
