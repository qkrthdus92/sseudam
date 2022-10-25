package com.kh.sseudam.pro.vo;

public class ProMemberJoinVo {

	private String no;
	private String counselTypeNo;
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
	private String proMemberNo;
	private String certificateName;
	private String certificateNum;
	private String imgPath;
	
	public ProMemberJoinVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProMemberJoinVo(String no, String counselTypeNo, String id, String pwd, String name, String gender,
			String phone, String email, String education, String price, String proStatus, String img, String joinDate,
			String modifyDate, String introduce, String proMemberNo, String certificateName, String certificateNum,
			String imgPath) {
		super();
		this.no = no;
		this.counselTypeNo = counselTypeNo;
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
		this.proMemberNo = proMemberNo;
		this.certificateName = certificateName;
		this.certificateNum = certificateNum;
		this.imgPath = imgPath;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getCounselTypeNo() {
		return counselTypeNo;
	}

	public void setCounselTypeNo(String counselTypeNo) {
		this.counselTypeNo = counselTypeNo;
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

	public String getProMemberNo() {
		return proMemberNo;
	}

	public void setProMemberNo(String proMemberNo) {
		this.proMemberNo = proMemberNo;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String certificateNum) {
		this.certificateNum = certificateNum;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "ProMemberJoinVo [no=" + no + ", counselTypeNo=" + counselTypeNo + ", id=" + id + ", pwd=" + pwd
				+ ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", education="
				+ education + ", price=" + price + ", proStatus=" + proStatus + ", img=" + img + ", joinDate="
				+ joinDate + ", modifyDate=" + modifyDate + ", introduce=" + introduce + ", proMemberNo=" + proMemberNo
				+ ", certificateName=" + certificateName + ", certificateNum=" + certificateNum + ", imgPath=" + imgPath
				+ "]";
	}
	
	
	
	
	
}
