package com.projectabc.storage;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.projectabc.member.Member;
import com.projectabc.util.PageUtil;

@Controller
public class StorageBoardService {
	public static final int length=15;
	@RequestMapping("viewStorageBoardList.do")
	public ModelAndView viewStorageBoardList(
			@RequestParam(value="page", required=false,defaultValue="1")
			int page,
			HttpSession session)throws Exception{
	
		Member member = (Member)session.getAttribute("MEMBER");
		
		int startIndex=(page-1)*length;
		StorageBoardDAO storageBoardDAO=new StorageBoardDAO();
		
		List<StorageBoard> storageBoardList=storageBoardDAO.selectStorageBoardList(startIndex, length);
		int storageBoardCount=storageBoardDAO.selectStorageBoardCount();
		
		String pageLink=PageUtil.generate(page, storageBoardCount, length, "viewStorageBoardList.do");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("STORAGEBOARD_LIST", storageBoardList);
		mav.addObject("PAGE_LINK", pageLink);
		mav.setViewName("/storage/viewStorageBoardList");
		
		return mav;
	}
	
	@RequestMapping("searchStorageBoardList.do")
	public ModelAndView searchStorageBoardList(
			@RequestParam(value="page", required=false,defaultValue="1")int page,
			@RequestParam(value="keyword", required=false)String keyword,
			@RequestParam(value="search", required=false)String search)throws Exception{
		int startIndex=(page-1)*length;
		StorageBoard storageBoard=null;
		if(search!=null&&search.trim().length()>=1){
			 storageBoard=new StorageBoard();
			 if("title".equals(keyword)){
				 storageBoard.setTitle(search);
			 }else if("content".equals(keyword)){
				 storageBoard.setContent(search);
			 }else if("filename".equals(keyword)){
				 storageBoard.setFilename(search);
			 }else if("memid".equals(keyword)){
				 storageBoard.setMemid(search);
			 }
		}
		
		StorageBoardDAO storageBoardDAO=new StorageBoardDAO();
		
		List<StorageBoard> storageBoardList=null;
		int totalCount=0;
		
		if(storageBoard==null){
			storageBoardList=storageBoardDAO.selectStorageBoardList(startIndex, length);
			totalCount=storageBoardDAO.selectStorageBoardCount();
		}else{
			storageBoardList=storageBoardDAO.searchStorageBoardList(storageBoard, startIndex, length);
			totalCount=storageBoardDAO.searchStorageBoardCount(storageBoard);
		}
		
		String pageLink=PageUtil.generate(page, totalCount, length, "searchStorageBoardList.do");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("STORAGEBOARD_LIST", storageBoardList);
		mav.addObject("PAGE_LINK", pageLink);
		mav.setViewName("/storage/viewStorageBoardList");
		
		return mav;
	}
	
	@RequestMapping("viewStorageBoard.do")
	public ModelAndView viewStorageBoard(
			@RequestParam(value="num")String num)throws Exception{
		StorageBoardDAO storageBoardDAO=new StorageBoardDAO();
		StorageBoard storageBoard=storageBoardDAO.selectStorageBoardByNo(num);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("STORAGEBOARD",storageBoard );
		mav.setViewName("/storage/viewStorageBoard");
		
		StorageCommentDAO storageCommentDAO=new StorageCommentDAO();
		List<StorageComment> storageCommentList=storageCommentDAO.selectStorageCommentListByBoardno(num);
		mav.addObject("STORAGECOMMENT_LIST", storageCommentList);
		
		return mav;
	}
	
	@RequestMapping(value="addStorageBoardForm.do")
	public ModelAndView addBoardForm()throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/storage/addStorageBoardForm");
		return mav;
	}
	
	@RequestMapping("addStorageBoard.do")
	public ModelAndView addStorageBoard(StorageBoard storageBoard,
			@RequestParam(value="file")MultipartFile file,
			HttpSession session)throws Exception{
		Member member = (Member)session.getAttribute("MEMBER");
		
		if(file!=null&&file.isEmpty()==false){
			File saveFile=new File("c:/upload/"+file.getOriginalFilename());
			int num=1;
			while(saveFile.exists()==true){
				String fileName=file.getOriginalFilename();
				int dotIndex=fileName.indexOf(".");
				if(dotIndex>=0){
					String onlyFileName=fileName.substring(0, dotIndex);
					String onlyExt=fileName.substring(dotIndex, fileName.length());
					saveFile=new File("c:/upload/"+onlyFileName+num+onlyExt);
				}else{
					saveFile=new File("c:/upload/"+fileName+num);
				}
				num++;
			}
			file.transferTo(saveFile);
			storageBoard.setFilename(file.getOriginalFilename());
			storageBoard.setRealfilename(saveFile.getName());
		}
		StorageBoardDAO storageBoardDAO=new StorageBoardDAO();
		storageBoardDAO.insertBoard(storageBoard);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/viewStorageBoard.do?num="+storageBoard.getBoardno());
		return mav;
	}
	
	@RequestMapping(value="downloadStorageBoard.do",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public void downloadStorageBoard(@RequestParam("num") String num,
			HttpServletResponse response)throws Exception{
		StorageBoardDAO storageBoardDAO=new StorageBoardDAO();
		StorageBoard storageBoard=storageBoardDAO.selectStorageBoardByNo(num);
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename="+storageBoard.getFilename());
		File downFile=new File("c:/download/"+storageBoard.getRealfilename());
		FileCopyUtils.copy(new FileInputStream(downFile), response.getOutputStream());
		response.flushBuffer();
	}
}
