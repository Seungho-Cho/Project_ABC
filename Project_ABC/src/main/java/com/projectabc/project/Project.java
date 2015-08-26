package com.projectabc.project;

public class Project {
	int projno;			//프로젝트 번호 (자동생성)
	String projname;	//프로젝트 이름
	String projcont;	//프로젝트 설명
	String makedate;	//프로젝트 생성일
	String managerid;	//프로젝트 매니저 ID
	
	public int getProjno() {
		return projno;
	}
	public void setProjno(int projno) {
		this.projno = projno;
	}
	public String getProjname() {
		return projname;
	}
	public void setProjname(String projname) {
		this.projname = projname;
	}
	public String getProjcont() {
		return projcont;
	}
	public void setProjcont(String projcont) {
		this.projcont = projcont;
	}
	public String getMakedate() {
		return makedate;
	}
	public void setMakedate(String makedate) {
		this.makedate = makedate;
	}
	public String getManagerid() {
		return managerid;
	}
	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

}
