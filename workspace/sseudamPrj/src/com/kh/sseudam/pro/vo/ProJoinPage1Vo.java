package com.kh.sseudam.pro.vo;

public class ProJoinPage1Vo {

	private String no;
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String phone;
	private String email;
	
	public ProJoinPage1Vo() {
		super();
	}

	public ProJoinPage1Vo(String no, String id, String pwd, String name, String gender, String phone, String email) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getId() {
		return id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ProJoinPage1Vo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender
				+ ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	
}
