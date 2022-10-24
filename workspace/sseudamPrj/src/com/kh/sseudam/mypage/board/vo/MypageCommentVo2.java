package com.kh.sseudam.mypage.board.vo;

public class MypageCommentVo2 {

	private String no;
	private String review_board_no;
	private String free_board_no;
	private String writer_no;
	private String cmt;
	private String cmt_date;
	private String delete_yn;
	private String modify_date;
	private String type;
	public MypageCommentVo2(String no, String review_board_no, String free_board_no, String writer_no, String cmt,
			String cmt_date, String delete_yn, String modify_date, String type) {
		super();
		this.no = no;
		this.review_board_no = review_board_no;
		this.free_board_no = free_board_no;
		this.writer_no = writer_no;
		this.cmt = cmt;
		this.cmt_date = cmt_date;
		this.delete_yn = delete_yn;
		this.modify_date = modify_date;
		this.type = type;
	}
	public MypageCommentVo2() {
		super();
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getReview_board_no() {
		return review_board_no;
	}
	public void setReview_board_no(String review_board_no) {
		this.review_board_no = review_board_no;
	}
	public String getFree_board_no() {
		return free_board_no;
	}
	public void setFree_board_no(String free_board_no) {
		this.free_board_no = free_board_no;
	}
	public String getWriter_no() {
		return writer_no;
	}
	public void setWriter_no(String writer_no) {
		this.writer_no = writer_no;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getCmt_date() {
		return cmt_date;
	}
	public void setCmt_date(String cmt_date) {
		this.cmt_date = cmt_date;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MypageCommentVo2 [no=" + no + ", review_board_no=" + review_board_no + ", free_board_no="
				+ free_board_no + ", writer_no=" + writer_no + ", cmt=" + cmt + ", cmt_date=" + cmt_date
				+ ", delete_yn=" + delete_yn + ", modify_date=" + modify_date + ", type=" + type + "]";
	}
	
	
}
