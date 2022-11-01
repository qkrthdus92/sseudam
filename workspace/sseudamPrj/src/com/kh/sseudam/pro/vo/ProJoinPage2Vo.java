package com.kh.sseudam.pro.vo;

import java.sql.Array;

import javax.servlet.http.Part;

public class ProJoinPage2Vo {

	
	private String proMemberNo;
	private String education;
	private String[] certificateName;
	private String[] certificateNum;
	private String imgPath;
	
	public ProJoinPage2Vo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProJoinPage2Vo(String proMemberNo, String education, String[] certificateName, String[] certificateNum,
			String imgPath) {
		super();
		this.proMemberNo = proMemberNo;
		this.education = education;
		this.certificateName = certificateName;
		this.certificateNum = certificateNum;
		this.imgPath = imgPath;
	}

	public String getProMemberNo() {
		return proMemberNo;
	}

	public void setProMemberNo(String proMemberNo) {
		this.proMemberNo = proMemberNo;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String[] getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String[] cerNameArr) {
		this.certificateName = cerNameArr;
	}

	public String[] getCertificateNum() {
		return certificateNum;
	}

	public void setCertificateNum(String[] cerNumArr) {
		this.certificateNum = cerNumArr;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "ProJoinPage2Vo [proMemberNo=" + proMemberNo + ", education=" + education + ", certificateName="
				+ certificateName + ", certificateNum=" + certificateNum + ", imgPath=" + imgPath + "]";
	}



	
}
