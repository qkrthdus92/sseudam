package com.kh.sseudam.counsel.pro.vo;

public class ProVo {
	
	public ProVo() {
		
	}
	
	

	public ProVo(String no, String counselType, String id, String pwd, String name, String gender, String phone,
			String email, String education, String price, String proStatus, String img, String joinDate,
			String modifyDate, String introduce, String avgStar, String counselCnt) {
		super();
		this.no = no;
		this.counselType = counselType;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.education = education;
		this.price = price;
		this.proStatus = proStatus;
		this.img = img;
		this.joinDate = joinDate;
		this.modifyDate = modifyDate;
		this.introduce = introduce;
		this.avgStar = avgStar;
		this.counselCnt = counselCnt;
	}



	private String no;
	private String counselType;
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String phone;
	private String email;
	private String education;
	private String price;
	private String proStatus;
	private String img;
	private String joinDate;
	private String modifyDate;
	private String introduce;
	private String avgStar;
	private String counselCnt;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCounselType() {
		return counselType;
	}
	public void setCounselType(String counselType) {
		this.counselType = counselType;
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
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProStatus() {
		return proStatus;
	}
	public void setProStatus(String proStatus) {
		this.proStatus = proStatus;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getAvgStar() {
		return avgStar;
	}
	public void setAvgStar(String avgStar) {
		this.avgStar = avgStar;
	}
	public String getCounselCnt() {
		return counselCnt;
	}
	public void setCounselCnt(String counselCnt) {
		this.counselCnt = counselCnt;
	}
	@Override
	public String toString() {
		return "ProVo [no=" + no + ", counselType=" + counselType + ", id=" + id + ", pwd=" + pwd + ", name=" + name
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", education=" + education
				+ ", price=" + price + ", proStatus=" + proStatus + ", img=" + img + ", joinDate=" + joinDate
				+ ", modifyDate=" + modifyDate + ", introduce=" + introduce + ", avgStar=" + avgStar + ", counselCnt="
				+ counselCnt + "]";
	}
	
	


}
