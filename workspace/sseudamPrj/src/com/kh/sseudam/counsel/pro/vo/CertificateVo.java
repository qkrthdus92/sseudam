package com.kh.sseudam.counsel.pro.vo;

public class CertificateVo {
	

	public CertificateVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CertificateVo(String no, String proNo, String name, String num, String img) {
		super();
		this.no = no;
		this.proNo = proNo;
		this.name = name;
		this.num = num;
		this.img = img;
	}


	private String no;
	private String proNo;
	private String name;
	private String num;
	private String img;
	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getProNo() {
		return proNo;
	}


	public void setProNo(String proNo) {
		this.proNo = proNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "CertificateVo [no=" + no + ", proNo=" + proNo + ", name=" + name + ", num=" + num + ", img=" + img
				+ "]";
	}
	
	

}
