package com.kh.sseudam.mypage.board.vo;

public class MypageTestscoreVo {

	private String test_score;

	public MypageTestscoreVo(String test_score) {
		super();
		this.test_score = test_score;
	}

	public MypageTestscoreVo() {
		super();
	}

	public String getTest_score() {
		return test_score;
	}

	public void setTest_score(String test_score) {
		this.test_score = test_score;
	}

	@Override
	public String toString() {
		return "MypageTestscoreVo [test_score=" + test_score + "]";
	}
	
	
}
