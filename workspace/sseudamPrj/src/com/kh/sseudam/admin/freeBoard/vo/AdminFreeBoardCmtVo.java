package com.kh.sseudam.admin.freeBoard.vo;

public class AdminFreeBoardCmtVo {
	
	
	public AdminFreeBoardCmtVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AdminFreeBoardCmtVo(String no, String freeBoardNo, String nick, String cmt, String enrollDate,
			String modifyDate, String deleteYn) {
		super();
		this.no = no;
		this.freeBoardNo = freeBoardNo;
		this.nick = nick;
		this.cmt = cmt;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.deleteYn = deleteYn;
	}


	private String no;
	private String freeBoardNo;
	private String nick;
	private String cmt;
	private String enrollDate;
	private String modifyDate;
	private String deleteYn;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getFreeBoardNo() {
		return freeBoardNo;
	}
	public void setFreeBoardNo(String freeBoardNo) {
		this.freeBoardNo = freeBoardNo;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
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
	@Override
	public String toString() {
		return "AdminFreeBoardCmtVo [no=" + no + ", freeBoardNo=" + freeBoardNo + ", nick=" + nick + ", cmt=" + cmt
				+ ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", deleteYn=" + deleteYn + "]";
	}
	
	

}
