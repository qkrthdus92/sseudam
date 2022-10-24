package com.kh.sseudam.mypage.board.vo;

public class MypageLikehomeVo {

	private String no;
	private String c_num;
	private String title;
	private String info_a;
	private String info_b;
	private String stress;
	private String link;
	private String img_path;
	private String write_date;
	private String modify_date;
	private String delete_yn;
	public MypageLikehomeVo(String no, String c_num, String title, String info_a, String info_b, String stress,
			String link, String img_path, String write_date, String modify_date, String delete_yn) {
		super();
		this.no = no;
		this.c_num = c_num;
		this.title = title;
		this.info_a = info_a;
		this.info_b = info_b;
		this.stress = stress;
		this.link = link;
		this.img_path = img_path;
		this.write_date = write_date;
		this.modify_date = modify_date;
		this.delete_yn = delete_yn;
	}
	public MypageLikehomeVo() {
		super();
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo_a() {
		return info_a;
	}
	public void setInfo_a(String info_a) {
		this.info_a = info_a;
	}
	public String getInfo_b() {
		return info_b;
	}
	public void setInfo_b(String info_b) {
		this.info_b = info_b;
	}
	public String getStress() {
		return stress;
	}
	public void setStress(String stress) {
		this.stress = stress;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getModify_date() {
		return modify_date;
	}
	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}
	public String getDelete_yn() {
		return delete_yn;
	}
	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}
	@Override
	public String toString() {
		return "MypageLikehomeVo [no=" + no + ", c_num=" + c_num + ", title=" + title + ", info_a=" + info_a
				+ ", info_b=" + info_b + ", stress=" + stress + ", link=" + link + ", img_path=" + img_path
				+ ", write_date=" + write_date + ", modify_date=" + modify_date + ", delete_yn=" + delete_yn + "]";
	}

	
	
	

	
}
