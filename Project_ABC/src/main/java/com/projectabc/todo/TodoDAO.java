package com.projectabc.todo;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TodoDAO {
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
	
	public TodoDAO()throws Exception{
		
	}

	public Todo selectTodoByTodono(String todono){
		SqlSession session=sqlMapper.openSession(true);
		Todo todo=session.selectOne("selectTodoByTodono",todono);
		session.close();
		return todo;
	}
	
	public List<Todo> selectTodoListByListno(String listno){
		SqlSession session=sqlMapper.openSession(true);
		List<Todo> todoList=session.selectList("selectTodoListByListno",listno);
		session.close();
		return todoList;
	}
	
	public void insertTodo(Todo todo){
		SqlSession session=sqlMapper.openSession(true);
		session.insert("insertTodo",todo);
		session.close();
	}
	
	public void insertJoinTodo(String memid, String todono){
		SqlSession session=sqlMapper.openSession(true);
		JoinTodo jt = new JoinTodo();
		jt.setMemid(memid);
		jt.setTodono(todono);
		session.insert("insertJoinTodo",jt);
		session.close();
	}
}
