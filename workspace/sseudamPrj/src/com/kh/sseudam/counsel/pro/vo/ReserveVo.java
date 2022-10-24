package com.kh.sseudam.counsel.pro.vo;

public class ReserveVo {

	public ReserveVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReserveVo(String no, String memberNo, String proNo, String counselDate, String payway, String price,
			String payDate, String star) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.proNo = proNo;
		this.counselDate = counselDate;
		this.payway = payway;
		this.price = price;
		this.payDate = payDate;
		this.star = star;
	}


	private String no;
	private String memberNo;
	private String proNo;
	private String counselDate;
	private String payway;
	private String price;
	private String payDate;
	private String star;
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

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

	public String getPayway() {
		return payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	@Override
	public String toString() {
		return "ReserveVo [no=" + no + ", memberNo=" + memberNo + ", proNo=" + proNo + ", counselDate=" + counselDate
				+ ", payway=" + payway + ", price=" + price + ", payDate=" + payDate + ", star=" + star + "]";
	}
	
	

}
