package com.projectabc.todo;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TodoDAO {
	//1.Mybatis ������ �ִ� ���� �̸�
	private static   String resource=
			  "sqlmap-config.xml";
	//1�� ������ ���� ��ü ����
	private static Reader sqlReader=null;
	static{
		 try{	
		  sqlReader=Resources.getResourceAsReader(
								resource);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}				
	//SqlSession ��ü-DB �α����ϰ� ������ ������ ��ü
	//�� ���带 ��ü�� SqlSessionFactory 
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
	
	public void updateTodo(Todo todo) {
		SqlSession session=sqlMapper.openSession(true);
		session.update("updateTodo",todo);
		session.close();
	}
	
	public void updateTodoListno(String todono, String listno) {
		SqlSession session=sqlMapper.openSession(true);
		Todo todo=session.selectOne("selectTodoByTodono", todono);
		todo.setListno(listno);
		session.update("updateTodo",todo);
		session.close();
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
	
	public void deleteTodo (String todono) {
		SqlSession session=sqlMapper.openSession(true);
		session.delete("deleteTodo",todono);
		session.close();
	}
	
	public void deleteJoinTodo (JoinTodo joinTodo) {
		SqlSession session=sqlMapper.openSession(true);
		session.delete("deleteJoinTodo",joinTodo);
		session.close();
	}
}
