package com.kh.sseudam.admin.counselPay.vo;

public class CounselPayVo {
	
	
	
	public CounselPayVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CounselPayVo(String no, String adviceDate, String payDate, String proId, String proName, String memberId,
			String memberName, String price, String payway, String star, String status) {
		super();
		this.no = no;
		this.adviceDate = adviceDate;
		this.payDate = payDate;
		this.proId = proId;
		this.proName = proName;
		this.memberId = memberId;
		this.memberName = memberName;
		this.price = price;
		this.payway = payway;
		this.star = star;
		this.status = status;
	}

	private String no;
	private String adviceDate;
	private String payDate;
	private String proId;
	private String proName;
	private String memberId;
	private String memberName;
	private String price;
	private String payway;
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
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
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
		return "CounselPayVo [no=" + no + ", adviceDate=" + adviceDate + ", payDate=" + payDate + ", proId=" + proId
				+ ", proName=" + proName + ", memberId=" + memberId + ", memberName=" + memberName + ", price=" + price
				+ ", payway=" + payway + ", star=" + star + ", status=" + status + "]";
	}
	
	
	

}
