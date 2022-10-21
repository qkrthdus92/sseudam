package com.kh.sseudam.board.vo;

public class ReviewBoardImgVo {

	private String img_no;
	private String reviewBoardNo;
	private String originName;
	private String changeName;
	private String filePath;
	private String enrollDate;
	private String thumbYn;
	private String status;
	public ReviewBoardImgVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewBoardImgVo(String img_no, String reviewBoardNo, String originName, String changeName, String filePath,
			String enrollDate, String thumbYn, String status) {
		super();
		this.img_no = img_no;
		this.reviewBoardNo = reviewBoardNo;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.enrollDate = enrollDate;
		this.thumbYn = thumbYn;
		this.status = status;
	}
	public String getImg_no() {
		return img_no;
	}
	public void setImg_no(String img_no) {
		this.img_no = img_no;
	}
	public String getReviewBoardNo() {
		return reviewBoardNo;
	}
	public void setReviewBoardNo(String reviewBoardNo) {
		this.reviewBoardNo = reviewBoardNo;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getThumbYn() {
		return thumbYn;
	}
	public void setThumbYn(String thumbYn) {
		this.thumbYn = thumbYn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReviewBoardImgVo [img_no=" + img_no + ", reviewBoardNo=" + reviewBoardNo + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", enrollDate=" + enrollDate + ", thumbYn="
				+ thumbYn + ", status=" + status + "]";
	}
	
	
}
