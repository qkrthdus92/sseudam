package com.kh.sseudam.admin.counselPay.vo;

public class SearchVo {
	

	public SearchVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SearchVo(String search, String startDate, String endDate) {
		super();
		this.search = search;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	private String search;
	private String startDate;
	private String endDate;
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "SearchVo [search=" + search + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
}
