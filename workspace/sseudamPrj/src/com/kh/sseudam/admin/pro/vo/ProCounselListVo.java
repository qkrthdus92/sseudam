package com.kh.sseudam.admin.pro.vo;

public class ProCounselListVo {
	
	
	
	public ProCounselListVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProCounselListVo(String no, String adviceDate, String payDate, String id, String price, String star,
			String status) {
		super();
		this.no = no;
		this.adviceDate = adviceDate;
		this.payDate = payDate;
		this.id = id;
		this.price = price;
		this.star = star;
		this.status = status;
	}

	private String no;
	private String adviceDate;
	private String payDate;
	private String id;
	private String price;
	private String star;
	private String status;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getAdviceDate() {
		return adviceDate;
	}
	public void setAdviceDate(String adviceDate) {
		this.adviceDate = adviceDate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProCounselListVo [no=" + no + ", adviceDate=" + adviceDate + ", payDate=" + payDate + ", id=" + id
				+ ", price=" + price + ", star=" + star + ", status=" + status + "]";
	}
	
	

}
