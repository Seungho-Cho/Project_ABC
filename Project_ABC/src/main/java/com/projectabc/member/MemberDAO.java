package com.projectabc.member;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MemberDAO {
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
	
	public MemberDAO()throws Exception{
		
	}

	public Member selectMemberById(String id){
		SqlSession session=sqlMapper.openSession(true);
		Member member=session.selectOne("selectMemberById",id);
		session.close();
		return member;
	}
	
	public List<Member> selectMemberListByProjno(String projno){
		SqlSession session=sqlMapper.openSession(true);
		List<Member> memberList=session.selectList("selectMemberListByProjno",projno);
		session.close();
		return memberList;
	}
	
	public void insertMember(Member member){
		SqlSession session=sqlMapper.openSession(true);
		session.insert("insertMember",member);
		session.close();
	}

}







