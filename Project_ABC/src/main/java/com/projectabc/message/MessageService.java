package com.projectabc.message;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;
import com.projectabc.member.MemberDAO;


@Controller
public class MessageService {
	@RequestMapping(value="sendMessgeForm.do")
	public ModelAndView sendMessageForm()throws Exception{
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/message/sendMessageForm");		
		return mav;
	}
	
	@RequestMapping(value="replyForm.do")
	public ModelAndView replyForm(
			@RequestParam("mesgno")String mesgno
			)throws Exception{
		
		MessageDAO mesDAO = new MessageDAO();

		Message message=mesDAO.selectMessageByNo(mesgno);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/message/replyForm");
		mav.addObject("MESSAGE",message);
		return mav;
	}
	
	@RequestMapping(value="sendMessage.do")
	public ModelAndView sendMessage(
			Message message
			//, @RequestParam("id")String memid
			)throws Exception{
			
		MessageDAO mesDAO = new MessageDAO();
		mesDAO.insertMessage(message);
			
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/message/showMessageList");		
		return mav;
		
	}
	
	@RequestMapping(value="showMessageList.do")
	public ModelAndView showMessageList(
			//@RequestParam("id")String id,
			HttpSession session
			)throws Exception{
		
		Member member = (Member)session.getAttribute("MEMBER");
		MessageDAO mesDAO = new MessageDAO();
		
		List<Message> mesList = (List<Message>)
				mesDAO. selectMessageListByRecvid(member.getId());
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/message/showMessageList");
		mav.addObject("MESSAGE_LIST",mesList);
		return mav;
		
	}

	@RequestMapping(value="messagePage.do")
	public ModelAndView messagePage(
			@RequestParam("mesgno")String mesgno
			)throws Exception{
		
		MessageDAO mesDAO = new MessageDAO();

		Message message=mesDAO.selectMessageByNo(mesgno);	
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/message/messagePage");
		mav.addObject("MESSAGE",message);
		return mav;
		
	}

}
