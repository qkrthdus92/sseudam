package com.kh.sseudam.admin.common;

public class AdminVo {
	
	
	public AdminVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public AdminVo(String no, String id, String pwd) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
	}



	private String no;
	private String id;
	private String pwd;
	public String getId() {
		return id;
	}
	
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	@Override
	public String toString() {
		return "AdminVo [no=" + no + ", id=" + id + ", pwd=" + pwd + "]";
	}

	
	

}
