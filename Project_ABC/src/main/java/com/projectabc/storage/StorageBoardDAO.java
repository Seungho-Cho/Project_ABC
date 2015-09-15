package com.projectabc.storage;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StorageBoardDAO {
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
		
		public StorageBoardDAO () throws Exception{
			
		}
  public StorageBoard selectStorageBoardByNo(String boardno)throws Exception{
	  SqlSession session=
				sqlMapper.openSession(true);
	  StorageBoard searchBoard=
			  session.selectOne("selectStorageBoardByNo",boardno);
	  session.close();
	  return searchBoard;
  }
  public List<StorageBoard> selectStorageBoardList(
		  int startIndex,int endIndex)throws Exception{
	  SqlSession session=
				sqlMapper.openSession(true);
		RowBounds bound=
				new RowBounds(startIndex,endIndex);
		List<StorageBoard> boardList=
				session.selectList(
						"selectStorageBoardList"
						,null,bound);
		session.close();
		return boardList;	  
  }
  public List<StorageBoard> searchStorageBoardList(StorageBoard sb,int startIndex,int endIndex)
   throws Exception{
	  SqlSession session=
				sqlMapper.openSession(true);
		RowBounds bound=
				new RowBounds(startIndex,endIndex);
		List<StorageBoard> boardList=
				session.selectList(
						"searchStorageBoardList"
						,sb,bound);
		session.close();
		return boardList;	
  }
  public int selectStorageBoardCount()throws Exception{
	  SqlSession session=
				sqlMapper.openSession(true);
	  int boardCount=
			  session.selectOne("selectStorageBoardCount");
	  session.close();
	  return boardCount;
  }
  public int searchStorageBoardCount(StorageBoard sb)throws Exception{
	  SqlSession session=
				sqlMapper.openSession(true);
	  int boardCount=
			  session.selectOne("searchStorageBoardCount",sb);
	  session.close();
	  return boardCount;
  }
  
  public List<StorageBoard> selectStorageBoardListBySuperboard(String superboard)
   throws Exception{
		SqlSession session=sqlMapper.openSession(true);
		List<StorageBoard> boardList=
		session.selectList("selectStorageBoardListBySuperboard",superboard);
		session.close();
		return boardList;
  }
  
  public void updateStorageBoard(StorageBoard sb) {
		SqlSession session=sqlMapper.openSession(true);
		session.update("updateStorageBoard",sb);
		session.close();
  }  
  public StorageBoard insertBoard(StorageBoard sb)throws Exception {
	  SqlSession session=
				sqlMapper.openSession(true);
	  session.insert("insertStorageBoard",sb);
	  return sb;
  }
  public void deleteStorageBoard (String boardno) {
		SqlSession session=sqlMapper.openSession(true);
		session.delete("deleteStorageBoard",boardno);
		session.close();
	}
}
