package com.kh.sseudam.mypage.board.vo;

public class MypageProreserVo {

	private String no;
	private String member_no;
	private String pro_no;
	private String advice_date;
	private String pay_method;
	private String pay;
	private String pay_date;
	private String star;
	private String name;
	private String phone;
	public MypageProreserVo(String no, String member_no, String pro_no, String advice_date, String pay_method,
			String pay, String pay_date, String star, String name, String phone) {
		super();
		this.no = no;
		this.member_no = member_no;
		this.pro_no = pro_no;
		this.advice_date = advice_date;
		this.pay_method = pay_method;
		this.pay = pay;
		this.pay_date = pay_date;
		this.star = star;
		this.name = name;
		this.phone = phone;
	}
	public MypageProreserVo() {
		super();
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	public String getPro_no() {
		return pro_no;
	}
	public void setPro_no(String pro_no) {
		this.pro_no = pro_no;
	}
	public String getAdvice_date() {
		return advice_date;
	}
	public void setAdvice_date(String advice_date) {
		this.advice_date = advice_date;
	}
	public String getPay_method() {
		return pay_method;
	}
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "MypageProreserVo [no=" + no + ", member_no=" + member_no + ", pro_no=" + pro_no + ", advice_date="
				+ advice_date + ", pay_method=" + pay_method + ", pay=" + pay + ", pay_date=" + pay_date + ", star="
				+ star + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
