package com.projectabc.storage;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StorageBoardDAO {
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
