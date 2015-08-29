package com.projectabc.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.commons.dbcp.BasicDataSource;
import com.projectabc.member.Member;

public class LoginCheck {
	BasicDataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	Member membersBean = new Member();
	boolean idcheck; //Member의 id를 check
	
	public LoginCheck(){
		
		try{
			Context init = new InitialContext();
			ds=(BasicDataSource) init.lookup ("java:comp/env/jdbc/OracleDB") ;
			}catch(Exception ex){
				return;
		} //member의 회원 db에 접근-연결 ....맞는지모르겠어요ㅠㅠ
	}
	
	public boolean MemberidCheck(String id){
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement("select * from MemberById where id=?"); 
			// 여기가 db에서 id check부분인데 select문이 맞는지 잘 모르겠어요
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(Exception e){
				 e.printStackTrace();
			}
		}
		return idcheck;
	}
}
		
		// member id check하는 부분
	//비밀번호는 id를 입력한 사용자의 비밀번호가
	//입력한 id의 레코드 비밀번호와 일치하는지를 확인해야하는데
	//그건 잘 모르겠어요 usebean으로 한번에 하면 좋을거같은데..
	//레코드를 beanㅍㅏ일에 담는걸 배웠었나요..ㅜㅜ