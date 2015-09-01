package com.projectabc.todo;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TodoCommentDAO {
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
	private static SqlSessionFactory sqlMapper =
			new SqlSessionFactoryBuilder().build(
					sqlReader);
	
	public TodoCommentDAO()throws Exception{
		
	}

	public List<TodoComment> selectTodoCommentListByTodono(String todono){
		SqlSession session=sqlMapper.openSession(true);
		List<TodoComment> todocommentList=session.selectList("selectTodoCommentListByTodono",todono);
		session.close();
		return todocommentList;
	}
	
	public void insertTodoComment(TodoComment todocomment){
		SqlSession session=sqlMapper.openSession(true);
		session.insert("insertTodoComment",todocomment);
		session.close();
	}
}
