package com.projectabc.storage;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StorageFolderDAO {
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
		
		public StorageFolderDAO () throws Exception{
			
		}
  public StorageFolder selectStorageFolderByNo(String folderno)throws Exception{
	  SqlSession session=
				sqlMapper.openSession(true);
	  StorageFolder searchBoard=
			  session.selectOne("selectStorageFolderByNo",folderno);
	  session.close();
	  return searchBoard;
  }
  public List<StorageFolder> selectStorageFolderList(
		  int startIndex,int endIndex)throws Exception{
	  SqlSession session=
				sqlMapper.openSession(true);
		RowBounds bound=
				new RowBounds(startIndex,endIndex);
		List<StorageFolder> boardList=
				session.selectList(
						"selectStorageFolderList"
						,null,bound);
		session.close();
		return boardList;	  
  }
  public List<StorageFolder> searchStorageFolderList(StorageFolder sb,int startIndex,int endIndex)
   throws Exception{
	  SqlSession session=
				sqlMapper.openSession(true);
		RowBounds bound=
				new RowBounds(startIndex,endIndex);
		List<StorageFolder> boardList=
				session.selectList(
						"searchStorageFolderList"
						,sb,bound);
		session.close();
		return boardList;	
  }
  public int selectStorageFolderCount()throws Exception{
	  SqlSession session=
				sqlMapper.openSession(true);
	  int boardCount=
			  session.selectOne("selectStorageFolderCount");
	  session.close();
	  return boardCount;
  }
  public int searchStorageFolderCount(StorageFolder sb)throws Exception{
	  SqlSession session=
				sqlMapper.openSession(true);
	  int boardCount=
			  session.selectOne("searchStorageFolderCount",sb);
	  session.close();
	  return boardCount;
  }
  
  public List<StorageFolder> selectStorageFolderListBySuperboard(String superboard)
   throws Exception{
		SqlSession session=sqlMapper.openSession(true);
		List<StorageFolder> boardList=
		session.selectList("selectStorageFolderListBySuperboard",superboard);
		session.close();
		return boardList;
  }
  
  public void updateStorageFolder(StorageFolder sf) {
		SqlSession session=sqlMapper.openSession(true);
		session.update("updateStorageFolder",sf);
		session.close();
  }  
  public StorageFolder insertBoard(StorageFolder sf)throws Exception {
	  SqlSession session=
				sqlMapper.openSession(true);
	  session.insert("insertStorageFolder",sf);
	  return sf;
  }
  public void deleteStorageFolder (String folderno) {
		SqlSession session=sqlMapper.openSession(true);
		session.delete("deleteStorageFolder",folderno);
		session.close();
	}
}
