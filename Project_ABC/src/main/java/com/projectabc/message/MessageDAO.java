package com.projectabc.message;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MessageDAO {
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
	
	public MessageDAO()throws Exception{
		
	}
	
	public Message selectMessageByNo(String mesgno){
		SqlSession session=sqlMapper.openSession(true);
		Message message=session.selectOne("selectMessageByNo",mesgno);
		session.close();
		return message;
	}

	public List<Message> selectMessageListBySendid(String sendid){
		SqlSession session=sqlMapper.openSession(true);
		List<Message> mesgList=session.selectList("selectMessageListBySendid",sendid);
		session.close();
		return mesgList;
	}
	
	public List<Message> selectMessageListByRecvid(String recvid){
		SqlSession session=sqlMapper.openSession(true);
		List<Message> mesgList=session.selectList("selectMessageListByRecvid",recvid);
		session.close();
		return mesgList;
	}
	
	public void updateMessage(Message message) {
		SqlSession session=sqlMapper.openSession(true);
		session.update("updateMessage",message);
		session.close();
		
	}
	
	public void deleteMessage (String mesgno) {
		SqlSession session=sqlMapper.openSession(true);
		session.delete("deleteMessage",mesgno);
		session.close();
	}
	
	public void insertMessage(Message message){
		System.out.println("MessageDAO-insertMessage - message - "+message);
		SqlSession session=sqlMapper.openSession(true);
		session.insert("insertMessage",message);
		//session.close(); - 세션 test
	}
	
}
