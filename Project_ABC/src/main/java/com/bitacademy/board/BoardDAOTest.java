package com.bitacademy.board;

import java.util.List;

import org.junit.Test;


public class BoardDAOTest {
	@Test
	public void testSelectBoard()
			 throws Exception{
		BoardDAO boardDAO=new BoardDAO();

		List<Board> boardList=boardDAO.selectBoardList(1, 5);

		System.out.println("boardList:"+
				boardList);
	}

}
