package com.projectabc.storage;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StorageCommentDAO {
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
	
	public StorageCommentDAO()throws Exception{
		
	}

	public List<StorageComment> selectStorageCommentListByBoardno(String boardno){
		SqlSession session=sqlMapper.openSession(true);
		List<StorageComment> StorageCommentList=session.selectList("selectStorageCommentListByBoardno",boardno);
		session.close();
		return StorageCommentList;
	}
	
	public void deleteStorageComment (String commno) {
		SqlSession session=sqlMapper.openSession(true);
		session.delete("deleteStorageComment",commno);
		session.close();
	}
	
	public void insertStorageComment(StorageComment storageComment){
		SqlSession session=sqlMapper.openSession(true);
		session.insert("insertStorageComment",storageComment);
		session.close();
	}
}
