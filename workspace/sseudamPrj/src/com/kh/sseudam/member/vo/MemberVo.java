package com.kh.sseudam.member.vo;

public class MemberVo {

	private String no;
	private String id;
	private String pwd;
	private String name;
	private String nick;
	private String phone;
	private String email;
	private String testScore;
	private String joinDate;
	private String quitYn;
	private String modifyDate;
	
	public MemberVo() {
	}

	public MemberVo(String no, String id, String pwd, String name, String nick, String phone, String email,
			String testScore, String joinDate, String quitYn, String modifyDate) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nick = nick;
		this.phone = phone;
		this.email = email;
		this.testScore = testScore;
		this.joinDate = joinDate;
		this.quitYn = quitYn;
		this.modifyDate = modifyDate;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
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

	public String getTestScore() {
		return testScore;
	}

	public void setTestScore(String testScore) {
		this.testScore = testScore;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", nick=" + nick + ", phone="
				+ phone + ", email=" + email + ", testScore=" + testScore + ", joinDate=" + joinDate + ", quitYn="
				+ quitYn + ", modifyDate=" + modifyDate + "]";
	}

	
	
}
