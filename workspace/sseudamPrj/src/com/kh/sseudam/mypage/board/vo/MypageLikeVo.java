package com.kh.sseudam.mypage.board.vo;

public class MypageLikeVo {

	private String no;
	private String c_num; 
	private String name; 
	private String address;
	private String phone; 
	private String link; 
	private String img_path; 
	private String write_date; 
	private String modify_date; 
	private String delete_yn; 
	private String el_no; 
	private String member_no;
	public MypageLikeVo(String no, String c_num, String name, String address, String phone, String link,
			String img_path, String write_date, String modify_date, String delete_yn, String el_no, String member_no) {
		super();
		this.no = no;
		this.c_num = c_num;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.link = link;
		this.img_path = img_path;
		this.write_date = write_date;
		this.modify_date = modify_date;
		this.delete_yn = delete_yn;
		this.el_no = el_no;
		this.member_no = member_no;
	}
	public MypageLikeVo() {
		super();
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	public String getEl_no() {
		return el_no;
	}
	public void setEl_no(String el_no) {
		this.el_no = el_no;
	}
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	@Override
	public String toString() {
		return "MypageLikeVo [no=" + no + ", c_num=" + c_num + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", link=" + link + ", img_path=" + img_path + ", write_date=" + write_date + ", modify_date="
				+ modify_date + ", delete_yn=" + delete_yn + ", el_no=" + el_no + ", member_no=" + member_no + "]";
	}
}

