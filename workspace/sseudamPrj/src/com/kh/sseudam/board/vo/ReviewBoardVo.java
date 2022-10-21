package com.kh.sseudam.board.vo;

public class ReviewBoardVo {

	private String no;
	private String writerNo;
	private String title;
	private String content;
	private String writeDate;
	private String deleteYn;
	private String modifyDate;
	private String views;
	public ReviewBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewBoardVo(String no, String writerNo, String title, String content, String writeDate, String deleteYn,
			String modifyDate, String views) {
		super();
		this.no = no;
		this.writerNo = writerNo;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.deleteYn = deleteYn;
		this.modifyDate = modifyDate;
		this.views = views;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "ReviewBoardBo [no=" + no + ", writerNo=" + writerNo + ", title=" + title + ", content=" + content
				+ ", writeDate=" + writeDate + ", deleteYn=" + deleteYn + ", modifyDate=" + modifyDate + ", views="
				+ views + "]";
	}
	
	
}

