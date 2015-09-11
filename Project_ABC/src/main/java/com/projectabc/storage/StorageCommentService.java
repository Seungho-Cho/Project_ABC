package com.projectabc.storage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StorageCommentService {
	@RequestMapping("addStorageComment.do")
	public ModelAndView addStorageComment(StorageComment storageComment,HttpServletRequest request)throws Exception{
		String clientIp=request.getRemoteAddr();
		storageComment.setMemid(clientIp);//���̵� �����ͼ� �ִ°ɷ� �����ؾ���
		StorageCommentDAO storageCommentDAO=new StorageCommentDAO();
		storageCommentDAO.insertStorageComment(storageComment);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/viewStorageBoard.do");
		mav.addObject("BOARDNO", storageComment.getBoardno());
		
		return mav;
	}
}
