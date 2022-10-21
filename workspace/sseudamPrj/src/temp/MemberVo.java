package temp;

import java.security.Timestamp;

public class MemberVo {

	private int no;
	private String id;
	private String pwd;
	private String name;
	private String nick;
	private String phone;
	private String email;
	private int testScore;
	private Timestamp joinDate;
	private String quitYn;
	private Timestamp modifyDate;
	
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVo(int no, String id, String pwd, String name, String nick, String phone, String email, int testScore,
			Timestamp joinDate, String quitYn, Timestamp modifyDate) {
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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
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

	public int getTestScore() {
		return testScore;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}

	public Timestamp getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	public String getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", nick=" + nick + ", phone="
				+ phone + ", email=" + email + ", testScore=" + testScore + ", joinDate=" + joinDate + ", quitYn="
				+ quitYn + ", modifyDate=" + modifyDate + "]";
	}
	
	
}
