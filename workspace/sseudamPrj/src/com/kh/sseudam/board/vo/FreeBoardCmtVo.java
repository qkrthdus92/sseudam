package com.kh.sseudam.board.vo;

public class FreeBoardCmtVo {

	private String no;
	private String freeBoardNo;
	private String writerNo;
	private String cmt;
	private String cmtDate;
	private String deleteYn;
	private String modifyDate;
	public FreeBoardCmtVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FreeBoardCmtVo(String no, String freeBoardNo, String writerNo, String cmt, String cmtDate, String deleteYn,
			String modifyDate) {
		super();
		this.no = no;
		this.freeBoardNo = freeBoardNo;
		this.writerNo = writerNo;
		this.cmt = cmt;
		this.cmtDate = cmtDate;
		this.deleteYn = deleteYn;
		this.modifyDate = modifyDate;
	}
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
	public String getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(String writerNo) {
		this.writerNo = writerNo;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getCmtDate() {
		return cmtDate;
	}
	public void setCmtDate(String cmtDate) {
		this.cmtDate = cmtDate;
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
	@Override
	public String toString() {
		return "FreeBoardCmtVo [no=" + no + ", freeBoardNo=" + freeBoardNo + ", writerNo=" + writerNo + ", cmt=" + cmt
				+ ", cmtDate=" + cmtDate + ", deleteYn=" + deleteYn + ", modifyDate=" + modifyDate + "]";
	}
	
}
