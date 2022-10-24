package com.kh.sseudam.mypage.board.vo;

public class MypageBoardVo {

	private String no;
	private String writeNo;
	private String title;
	private String content;
	private String writeDate;
	private String deleteYn;
	private String modifyDate;
	private String views;
	private String type;
	
	public MypageBoardVo() {
		super();
	}

	public MypageBoardVo(String no, String writeNo, String title, String content, String writeDate, String deleteYn,
			String modifyDate, String views, String type) {
		super();
		this.no = no;
		this.writeNo = writeNo;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.deleteYn = deleteYn;
		this.modifyDate = modifyDate;
		this.views = views;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "MypageBoardVo [no=" + no + ", writeNo=" + writeNo + ", title=" + title + ", content=" + content
				+ ", writeDate=" + writeDate + ", deleteYn=" + deleteYn + ", modifyDate=" + modifyDate + ", views="
				+ views + ", type=" + type + "]";
	}
	
	
	
	
	
	
	
}
