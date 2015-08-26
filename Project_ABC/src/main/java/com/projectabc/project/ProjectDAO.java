package com.projectabc.project;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ProjectDAO {
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
	
	public ProjectDAO()throws Exception{
		
	}

	public Project selectMemberById(String projno){
		SqlSession session=sqlMapper.openSession(true);
		Project project=session.selectOne("selectProjectByProjno",projno);
		return project;
	}
	
	public void insertProject(Project project){
		SqlSession session=sqlMapper.openSession(true);
		session.insert("insertProject",project);
	}
}
