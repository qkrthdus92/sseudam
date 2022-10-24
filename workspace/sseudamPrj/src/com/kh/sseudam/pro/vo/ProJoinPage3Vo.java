package com.kh.sseudam.pro.vo;

public class ProJoinPage3Vo {

	private String img;
	private String counselType;
	private String introduce;
	
	public ProJoinPage3Vo() {
		super();
	}

	public ProJoinPage3Vo(String img, String counselType, String introduce) {
		super();
		this.img = img;
		this.counselType = counselType;
		this.introduce = introduce;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCounselType() {
		return counselType;
	}

	public void setCounselType(String counselType) {
		this.counselType = counselType;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Override
	public String toString() {
		return "ProJoinPage3Vo [img=" + img + ", counselType=" + counselType + ", introduce=" + introduce + "]";
	}
	
	
	
}
