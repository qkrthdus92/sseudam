package com.kh.sseudam.board.vo;

public class FreeBoardVo {

	private String no;
	private String writeNo;
	private String title;
	private String content;
	private String writeDate;
	private String deleteYn;
	private String modifyDate;
	private String views;
	public FreeBoardVo(String no, String writeNo, String title, String content, String writeDate, String deleteYn,
			String modifyDate, String views) {
		super();
		this.no = no;
		this.writeNo = writeNo;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.deleteYn = deleteYn;
		this.modifyDate = modifyDate;
		this.views = views;
	}
	public FreeBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getWriteNo() {
		return writeNo;
	}
	public void setWriteNo(String writeNo) {
		this.writeNo = writeNo;
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
		return "FreeBoardVo [no=" + no + ", writeNo=" + writeNo + ", title=" + title + ", content=" + content
				+ ", writeDate=" + writeDate + ", deleteYn=" + deleteYn + ", modifyDate=" + modifyDate + ", views="
				+ views + "]";
	}
	
	
}
