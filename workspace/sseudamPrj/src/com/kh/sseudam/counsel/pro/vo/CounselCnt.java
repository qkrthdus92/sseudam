package com.kh.sseudam.counsel.pro.vo;

public class CounselCnt {
	
	public CounselCnt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CounselCnt(String proNo, String counselDate, String cnt) {
		super();
		this.proNo = proNo;
		this.counselDate = counselDate;
		this.cnt = cnt;
	}


	private String proNo;
	private String counselDate;
	private String cnt;
	public String getProNo() {
		return proNo;
	}


	public void setProNo(String proNo) {
		this.proNo = proNo;
	}


	public String getCounselDate() {
		return counselDate;
	}


	public void setCounselDate(String counselDate) {
		this.counselDate = counselDate;
	}


	public String getCnt() {
		return cnt;
	}


	public void setCnt(String cnt) {
		this.cnt = cnt;
	}


	@Override
	public String toString() {
		return "CounselCnt [proNo=" + proNo + ", counselDate=" + counselDate + ", cnt=" + cnt + "]";
	}
	
	
	

}
