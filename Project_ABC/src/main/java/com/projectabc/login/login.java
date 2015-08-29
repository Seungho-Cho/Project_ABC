package com.projectabc.login;

import java.sql.*;

public class login {

	String id; // Member id
	String password; // Member password
	String name; // Member name
	Date logintime; // login time
	Timestamp nowtime; // what time is it now
	
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public Date getLogintime(){
		return logintime;
	}
	public void setLogintime(Date logintime){
		this.logintime=logintime;
	}
	
	public Timestamp getNowtime(){
		return nowtime;
	}
	public void setNowtime(Timestamp nowtime){
		this.nowtime=nowtime;
	}
}
