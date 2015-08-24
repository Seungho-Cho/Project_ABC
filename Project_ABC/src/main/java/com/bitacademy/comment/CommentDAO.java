package com.bitacademy.comment;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CommentDAO {
	
	//1.Mybatis 설정이 있는 문서 이름
	private static   String resource=
			  "sqlmap-config.xml";
	//1의 문서를 읽을 객체 생성
	private static Reader sqlReader=null;
	static{
		 try{	
		  sqlReader=Resources.getResourceAsReader(
								resource);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}				
	//SqlSession 객체-DB 로그인하고 쿼리를 실행할 객체
	//를 만드를 객체가 SqlSessionFactory 
	private static SqlSessionFactory factory =
			new SqlSessionFactoryBuilder().build(
					sqlReader);
	
	public CommentDAO()throws Exception{
		
	}
	
	public void insertComment(Comment comment) {
		SqlSession session=factory.openSession(true);
		session.insert("insertComment",comment);
	}
	
	public List<Comment> selectCommentList(String num){
		//쿼리 아이디 selectCommentList 실행해서 커맨트 리스트를 변수에 담고 커맨트 리스트 리턴
		//session.selectList("selectCommentList",num);
		SqlSession session=factory.openSession(true);
		List<Comment> commentList=session.selectList("selectCommentList",num);
		return commentList;
	}
}







