package com.kh.sseudam.pro.join.vo;

public class ProJoinPage2Vo {

	private String education;
	private String certificateName;
	private String certificateNum;
	private String imgPath;
	
	public ProJoinPage2Vo() {
		super();
	}

	public ProJoinPage2Vo(String education, String certificateName, String certificateNum, String imgPath) {
		super();
		this.education = education;
		this.certificateName = certificateName;
		this.certificateNum = certificateNum;
		this.imgPath = imgPath;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
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
		return "ProJoinPage2Vo [education=" + education + ", certificateName=" + certificateName + ", certificateNum="
				+ certificateNum + ", imgPath=" + imgPath + "]";
	}

	
	
}
