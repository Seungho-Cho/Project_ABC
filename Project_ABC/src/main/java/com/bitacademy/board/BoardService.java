package com.bitacademy.board;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.comment.Comment;
import com.bitacademy.comment.CommentDAO;
import com.bitacademy.util.PageUtil;

@Controller
public class BoardService {
	//한페이지당 보여줄 게시물 개수 
	public static final int length=5;
	@RequestMapping("viewBoardList.do")
	public ModelAndView viewBoardList(
			@RequestParam(value="page", required=false,defaultValue="1")
			int page)throws Exception{
	/*
	1.한페이지에 보여줄 게시물의 시작인덱스  (page-1)*length 를 변수에 저장
	3.BoardDAO 객체 생성해서 변수에 저장	
	3.	3객체.selectBoardList(1변수,length)호출해서 페이지에 보여줄 게시물 정보를 조회해서 변수에 저장
	4.  3객체.selectBoardCount() 호출해서 전체 게시물의 수를 변수에 저장
	5.다른페이지로 이동하는 링크를 만들어 주는 
	PageUtil.generate(page, 4변수,length, "viewBoardList.do")
	를 호출해서 리턴값을 변수에 저장
	6.	ModelAndView 객체 생성
	7.	3의 게시물 정보를 6 객체에 저장 (속성명:BOARD_LIST)
	7.	5 를  6객체에 저장 (속성명:PAGE_LINK)
	4.	/board/viewBoardList.jsp로 이동하도록6객체의 setViewName에 /board/viewBoardList저장
	5.	6객체 리턴
	*/
		int startIndex=(page-1)*length;
		BoardDAO boardDAO=new BoardDAO();
		
		List<Board> boardList=boardDAO.selectBoardList(startIndex, length);
		int boardCount=boardDAO.selectBoardCount();
		
		String pageLink=PageUtil.generate(page,boardCount,length, "viewBoardList.do");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("BOARD_LIST", boardList);
		mav.addObject("PAGE_LINK", pageLink);
		mav.setViewName("/board/viewBoardList");
		
		return mav;
	}
	
	@RequestMapping("searchBoardList.do")
	public ModelAndView serchBoardList(
			@RequestParam(value="page", required=false,defaultValue="1")
			int page,
			@RequestParam(value="keyword", required=false)String keyword,
			@RequestParam(value="search", required=false)String search)throws Exception{
	/*
	1.한페이지에 보여줄 게시물의 시작인덱스  (page-1)*length 를 변수에 저장
	
	3.Board board=null;
	4. 매개변수 search가 null 이 아니고 search.trim().length()가 1이상이면
	 4.1 Board 객체 생성해서 3변수에 대입 
	 4.1 매개변수 keyword의 값이  "title"이면 3객체의 title속성에 매개변수 search저장
	 4.2매개변수 keyword의 값이  "content"이면 3객체의 content속성에 매개변수 search저장
	 4.3 매개변수 filename 의 값이  "filename"이면 3객체의 content속성에 매개변수 search저장
	 -문자열이기 때문에  equals로 비교한다
	5.  BoardDAO 객체 생성해서 변수에 저장
    6.ArrayList<Board> boardList=null;	
	  int totalCount=0;
	7. 3의 board 가 null이면	
	   5객체.selectBoardList(1변수,length)호출해서 전체 게시물 정보를 조회해서 변수 boardList에 저장
	   5객체.selectBoardCount() 호출해서 전체 게시물의 수를 변수 totalCount 에 저장
	8. 3의 board가 null이 아니면
	   5객체.searchBoardList(board,1변수,length)호출해서 게시물 정보를 검색해서 변수 boardList에 저장
	   5객체.searchBoardCount(board) 호출해서 전체 검색게시물의 수를 변수 totalCount 에 저장
	9.다른페이지로 이동하는 링크를 만들어 주는 
	PageUtil.generate(page, totalCount,length, "searchBoardList.do")
	를 호출해서 리턴값을 변수에 저장
	10.	ModelAndView 객체 생성
	11.	6의 게시물 정보를 10 객체에 저장 (속성명:BOARD_LIST)
	11.	9 를  10객체에 저장 (속성명:PAGE_LINK)
	12.	/board/viewBoardList.jsp로 이동하도록6객체의 setViewName에 /board/viewBoardList저장
	13.	10객체 리턴
	*/
		int startIndex=(page-1)*length;
		Board board=null;
		if(search!=null && search.trim().length()>=1) {
			board=new Board();
			if("title".equals(keyword)){
				board.setTitle(search);
			}
			else if("content".equals(keyword)){
				board.setContent(search);
			}
			else if("filename".equals(keyword)){
				board.setFilename(search);
			}
		}
		
		BoardDAO boardDAO=new BoardDAO();
		
		List<Board> boardList=null;	
		int totalCount=0;

		if(board==null){
			boardList=boardDAO.selectBoardList(startIndex,length);
			totalCount=boardDAO.selectBoardCount();
		} else {
			boardList=boardDAO.searchBoardList(board,startIndex,length);
			totalCount=boardDAO.searchBoardCount(board);
		}
		
		String pageLink=PageUtil.generate(page, totalCount,length, "searchBoardList.do");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("BOARD_LIST", boardList);
		mav.addObject("PAGE_LINK", pageLink);
		mav.setViewName("/board/viewBoardList");
		
		return mav;
	}
	@RequestMapping("viewBoard.do")
	public ModelAndView viewBoard(
			@RequestParam(value="num")String num)throws Exception{
	/*	
	3.BoardDAO 객체 생성해서 변수에 저장	
	4.	3객체.selectBoardList(num) 매개변수 num과 번호가 일치하는 게시물 조회
	5.	ModelAndView 객체 생성
	6.	4의 게시물 정보를 5 객체에 저장 (속성명:BOARD)
	4.	/board/viewBoard.jsp로 이동하도록6객체의 setViewName에 /board/viewBoard저장
	5.	5객체 리턴
	*/
		BoardDAO boardDAO=new BoardDAO();
		Board board=boardDAO.selectBoard(num);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("BOARD",board);
		mav.setViewName("/board/viewBoard");
		
		CommentDAO commentDAO=new CommentDAO();
		List<Comment> commentList=commentDAO.selectCommentList(num);
		mav.addObject("COMMENT_LIST",commentList);
		
		return mav;
	}
	@RequestMapping(value="addBoardForm.do")
	public ModelAndView addBoardForm()throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/board/addBoardForm");
		return mav;
	}
	@RequestMapping(value="addBoard.do")
	public ModelAndView addBoard(Board board,
			@RequestParam(value="file")MultipartFile file)throws Exception {
		if(file!=null&&file.isEmpty()==false) {
			File saveFile=new File("c:/upload/"+file.getOriginalFilename());
			int num=1;
			while(saveFile.exists()==true){
				String filename=file.getOriginalFilename();
				int dotIndex=filename.indexOf(".");
				if(dotIndex>=0){
					String onlyFilename=filename.substring(0, dotIndex);
					String onlyExt=filename.substring(dotIndex,filename.length());
					saveFile=new File("c:/upload/"+onlyFilename+num+onlyExt);
				}
				else {
					saveFile=new File("c:/upload/"+filename+num);
				}
				num++;
			}			
			file.transferTo(saveFile);
			board.setFilename(file.getOriginalFilename());
			board.setRealfilename(saveFile.getName());
		}
		BoardDAO boardDAO=new BoardDAO();
		boardDAO.insertBoard(board);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("forward:/viewBoard.do?num="+board.getNum());
		return mav;
	}
	@RequestMapping(value="downloadBoard.do",produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public void downloadBoard(@RequestParam("num") String num,
			HttpServletResponse response)throws Exception {
		BoardDAO boardDAO=new BoardDAO();
		Board board=boardDAO.selectBoard(num);
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename="+board.getFilename());
		File downFile=new File("c:/upload/"+board.getRealfilename());
		FileCopyUtils.copy(new FileInputStream(downFile),response.getOutputStream());
		response.flushBuffer();
	}


}
