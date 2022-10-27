package com.kh.sseudam.admin.freeBoard.vo;

public class AdminFreeBoardVo {
	
	
	
	public AdminFreeBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AdminFreeBoardVo(String no, String title, String nick, String enrollDate, String view, String cmtCnt,
			String modifyDate, String deleteYn, String content) {
		super();
		this.no = no;
		this.title = title;
		this.nick = nick;
		this.enrollDate = enrollDate;
		this.view = view;
		this.cmtCnt = cmtCnt;
		this.modifyDate = modifyDate;
		this.deleteYn = deleteYn;
		this.content = content;
	}


	private String no;
	private String title;
	private String nick;
	private String enrollDate;
	private String view;
	private String cmtCnt;
	private String modifyDate;
	private String deleteYn;
	private String content;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getCmtCnt() {
		return cmtCnt;
	}
	public void setCmtCnt(String cmtCnt) {
		this.cmtCnt = cmtCnt;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "AdminFreeBoardVo [no=" + no + ", title=" + title + ", nick=" + nick + ", enrollDate=" + enrollDate
				+ ", view=" + view + ", cmtCnt=" + cmtCnt + ", modifyDate=" + modifyDate + ", deleteYn=" + deleteYn
				+ ", content=" + content + "]";
	}
	
	
	

}
