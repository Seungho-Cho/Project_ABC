package com.projectabc.storage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;

@Controller
public class StorageCommentService {
	@RequestMapping("addStorageComment.do")
	public ModelAndView addStorageComment(StorageComment storageComment,HttpSession session)throws Exception{
		Member member=(Member)session.getAttribute("LOGIN_MEMBER");
		storageComment.setMemid(member.getId());//���̵� �����ͼ� �ִ°ɷ� �����ؾ���
		StorageCommentDAO storageCommentDAO=new StorageCommentDAO();
		storageCommentDAO.insertStorageComment(storageComment);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/viewStorageBoard.do?num="+storageComment.getBoardno());
		//mav.addObject("BOARDNO", );
		
		return mav;
	}
}
