package com.bitacademy.customer;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class CustomerDAO {
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
	
	public CustomerDAO()throws Exception{
		
	}
	
	/*쿼리아이디 selectCustomerById를 실행한다
	 매개변수 id:조회할 회원 아이디
	 */
	public Customer selectCustomerById(String id){
		SqlSession session=sqlMapper.openSession(true);
		Customer customer=session.selectOne("selectCustomerById",id);
		return customer;
	}
	
	public void insertCustomer(Customer customer){
		// 쿼리 아이디 insertCustomer 쿼리를 실행한다
		//session.insert("insertCustomer",customer);
		SqlSession session=sqlMapper.openSession(true);
		session.insert("insertCustomer",customer);
	}

}







