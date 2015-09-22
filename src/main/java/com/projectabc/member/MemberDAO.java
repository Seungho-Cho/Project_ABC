package com.projectabc.member;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MemberDAO {
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
	
	public List<Member> selectMemberListByTodono(String todono){
		SqlSession session=sqlMapper.openSession(true);
		List<Member> memberList=session.selectList("selectMemberListByTodono",todono);
		session.close();
		return memberList;
	}	
	
	public void updateMember(Member member) {
		SqlSession session=sqlMapper.openSession(true);
		session.update("updateMember",member);
		session.close();
		
	}
	
	public void deleteMember (String id) {
		SqlSession session=sqlMapper.openSession(true);
		session.delete("deleteMember",id);
		session.close();
	}
	
	public void insertMember(Member member){
		SqlSession session=sqlMapper.openSession(true);
		session.insert("insertMember",member);
		session.close();
	}

}







