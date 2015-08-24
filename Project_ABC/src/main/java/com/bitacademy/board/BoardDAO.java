package com.bitacademy.board;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	String resource="sqlmap-config.xml";
	Reader sqlReader;
	SqlSessionFactory factory;
	public BoardDAO()throws Exception{
		sqlReader=
				Resources.getResourceAsReader(
						resource);
		factory=
				new SqlSessionFactoryBuilder()
				.build(sqlReader);
	}
  public Board selectBoard(String num)throws Exception{
	  //1.	num이 일치하는 레코드를 tb_board 테이블에서 조회해서 리턴한다
	  //실행할 쿼리 아이디 :selectBoard
	  SqlSession session=
				factory.openSession(true);
	  Board searchBoard=
			  session.selectOne("selectBoard",num);
	  session.close();
	  return searchBoard;
  }
  public List<Board> selectBoardList(
		  int startIndex,int endIndex)throws Exception{
	  //1.RowBounds 객체를 생성한다
	  //2.	1.	tb_board 테이블의 startIndex부터 endIndex 까지의 
	  //    레코드를 조회해서 List에 담아서 리턴한다.
	  //실행할 쿼리 아이디 :selectBoardList
	  //조회할 레코드의 시작인덱스와 끝인덱스 :1의 RowBounds 객체
	  SqlSession session=
				factory.openSession(true);
		RowBounds bound=
				new RowBounds(startIndex,endIndex);
		List<Board> boardList=
				session.selectList(
						"selectBoardList"
						,null,bound);
		session.close();
		return boardList;	  
  }
  public List<Board> searchBoardList(Board board,int startIndex,int endIndex)
   throws Exception{
	//1.RowBounds 객체를 생성한다
	  //2.	1.	tb_board 테이블의 startIndex부터 endIndex 까지의 
	  //    레코드를 검색해서 List에 담아서 리턴한다.
	  //실행할 쿼리 아이디 :searchBoardList
	  //조회할 레코드의 시작인덱스와 끝인덱스 :1의 RowBounds 객체
	  SqlSession session=
				factory.openSession(true);
		RowBounds bound=
				new RowBounds(startIndex,endIndex);
		List<Board> boardList=
				session.selectList(
						"searchBoardList"
						,board,bound);
		session.close();
		return boardList;	
  }
  public int selectBoardCount()throws Exception{
	  //tb_board 테이블에서 전체 게시물의 수를 조회하는 
	  //쿼리아이디 selectBoardCount를 실행해서 결과 int 를 리턴한다
	  SqlSession session=
				factory.openSession(true);
	  int boardCount=
			  session.selectOne("selectBoardCount");
	  session.close();
	  return boardCount;
  }
  public int searchBoardCount(Board board)throws Exception{
	  //tb_board 테이블에서 전체 게시물의 수를 조회하는 
	  //쿼리아이디 searchBoardCount를 실행해서 결과 int 를 리턴한다
	  SqlSession session=
				factory.openSession(true);
	  int boardCount=
			  session.selectOne("searchBoardCount",board);
	  session.close();
	  return boardCount;
  }
  public Board insertBoard(Board board)throws Exception {
	  SqlSession session=
				factory.openSession(true);
	  session.insert("insertBoard",board);
	  return board;
  }
}
