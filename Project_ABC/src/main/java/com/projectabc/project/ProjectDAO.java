package com.projectabc.project;

import java.io.Reader;
import java.util.List;

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

	public Project selectProjectByNo(String projno){
		SqlSession session=sqlMapper.openSession(true);
		Project project=session.selectOne("selectProjectByNo",projno);
		session.close();
		return project;
	}
	
	public List<Project> selectProjectListById(String userid){
		SqlSession session=sqlMapper.openSession(true);
		List<Project> projectList=session.selectList("selectProjectListById",userid);
		session.close();
		return projectList;
	}
	
	public String selectPositionByJoinProject(JoinProject jp) {
		SqlSession session=sqlMapper.openSession(true);
		String position=session.selectOne("selectPositionByJoinProject",jp);
		session.close();		
		return position;
	}
	
	public void updateProject(Project project) {
		SqlSession session=sqlMapper.openSession(true);
		session.update("updateProject",project);
		session.close();
		
	}
	
	public void deleteProject (String projno) {
		SqlSession session=sqlMapper.openSession(true);
		session.delete("deleteProject",projno);
		session.close();
	}
	
	public void updateJoinProject(JoinProject joinproject) {
		SqlSession session=sqlMapper.openSession(true);
		session.update("updateJoinProject",joinproject);
		session.close();
	}
	
	public void deleteJoinProject (JoinProject joinproject) {
		SqlSession session=sqlMapper.openSession(true);
		session.delete("deleteJoinProject",joinproject);
		session.close();
	}
	
	public void insertProject(Project project){
		SqlSession session=sqlMapper.openSession(true);
		session.insert("insertProject",project);
		String projSeq=session.selectOne("selectProjectSeq");
		insertJoinProject(projSeq, project.managerid, "0");
		session.close();
	}
	
	public void insertJoinProject(String projno, String memid, String position){
		SqlSession session=sqlMapper.openSession(true);
		JoinProject jp = new JoinProject();
		jp.setMemid(memid);
		jp.setProjno(projno);
		jp.setPosition(position);
		session.insert("insertJoinProject",jp);
		session.close();
	}
}
