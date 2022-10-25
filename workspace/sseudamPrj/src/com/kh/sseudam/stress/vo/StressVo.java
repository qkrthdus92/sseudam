package com.kh.sseudam.stress.vo;

public class StressVo {
	private String cNum;
	private String title;
	private int stress;
	private String imgPath;
	private String link;
	private String modifyDate;
	public StressVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StressVo(String cNum, String title, int stress, String imgPath, String link, String modifyDate) {
		super();
		this.cNum = cNum;
		this.title = title;
		this.stress = stress;
		this.imgPath = imgPath;
		this.link = link;
		this.modifyDate = modifyDate;
	}
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getStress() {
		return stress;
	}
	public void setStress(int stress) {
		this.stress = stress;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "StressVo [cNum=" + cNum + ", title=" + title + ", stress=" + stress + ", imgPath=" + imgPath + ", link="
				+ link + ", modifyDate=" + modifyDate + "]";
	}
	
}
