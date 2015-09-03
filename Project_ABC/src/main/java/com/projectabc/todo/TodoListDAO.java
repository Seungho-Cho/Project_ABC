package com.projectabc.todo;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TodoListDAO {
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
	
	public TodoListDAO()throws Exception{
		
	}

	public List<TodoList> selectTodolistListByProjno(String projno){
		SqlSession session=sqlMapper.openSession(true);
		List<TodoList> todolistList=session.selectList("selectTodolistListByProjno",projno);
		session.close();
		return todolistList;
	}
	
	public TodoList selectTodolistByListno(String listno){
		SqlSession session=sqlMapper.openSession(true);
		TodoList todolist=session.selectOne("selectTodolistByListno",listno);
		session.close();
		return todolist;
	}
	
	public void updateTodolist(TodoList todolist) {
		SqlSession session=sqlMapper.openSession(true);
		session.update("updateTodolist",todolist);
		session.close();
		
	}
	
	public void deleteTodolist (String listno) {
		SqlSession session=sqlMapper.openSession(true);
		session.delete("deleteTodolist",listno);
		session.close();
	}
	
	public void insertTodolist(TodoList todoList){
		SqlSession session=sqlMapper.openSession(true);
		session.insert("insertTodolist",todoList);
		session.close();
	}
}
