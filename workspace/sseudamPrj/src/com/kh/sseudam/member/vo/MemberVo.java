package com.kh.sseudam.member.vo;

public class MemberVo {

	private String no;
	private String id;
	private String pwd;
	private String name;
	private String nick;
	private String phone;
	private String email;
	private String test_score;
	private String join_date;
	private String quit_yn;
	private String modify_date;
	
	public MemberVo() {
	}

	public MemberVo(String no, String id, String pwd, String name, String nick, String phone, String email,
			String test_score, String join_date, String quit_yn, String modify_date) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.nick = nick;
		this.phone = phone;
		this.email = email;
		this.test_score = test_score;
		this.join_date = join_date;
		this.quit_yn = quit_yn;
		this.modify_date = modify_date;
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

	public String getTest_score() {
		return test_score;
	}

	public void setTest_score(String test_score) {
		this.test_score = test_score;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public String getQuit_yn() {
		return quit_yn;
	}

	public void setQuit_yn(String quit_yn) {
		this.quit_yn = quit_yn;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", nick=" + nick + ", phone="
				+ phone + ", email=" + email + ", test_score=" + test_score + ", join_date=" + join_date + ", quit_yn="
				+ quit_yn + ", modify_date=" + modify_date + "]";
	}
	
	
	
}
