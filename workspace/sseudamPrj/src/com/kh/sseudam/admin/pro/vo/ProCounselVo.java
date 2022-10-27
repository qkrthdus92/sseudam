package com.kh.sseudam.admin.pro.vo;

public class ProCounselVo {
	
	
	
	public ProCounselVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProCounselVo(String no, String profit, String avgStar, String finishCnt, String waitCnt) {
		super();
		this.no = no;
		this.profit = profit;
		this.avgStar = avgStar;
		this.finishCnt = finishCnt;
		this.waitCnt = waitCnt;
	}

	private String no;
	private String profit;
	private String avgStar;
	private String finishCnt;
	private String waitCnt;
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getAvgStar() {
		return avgStar;
	}

	public void setAvgStar(String avgStar) {
		this.avgStar = avgStar;
	}

	public String getFinishCnt() {
		return finishCnt;
	}

	public void setFinishCnt(String finishCnt) {
		this.finishCnt = finishCnt;
	}

	public String getWaitCnt() {
		return waitCnt;
	}

	public void setWaitCnt(String waitCnt) {
		this.waitCnt = waitCnt;
	}

	@Override
	public String toString() {
		return "ProCounselVo [no=" + no + ", profit=" + profit + ", avgStar=" + avgStar + ", finishCnt=" + finishCnt
				+ ", waitCnt=" + waitCnt + "]";
	}
	
	

}
