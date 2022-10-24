package com.kh.sseudam.mypage.board.vo;

public class MypageTestscoreVo {

	private int test_score;

	public MypageTestscoreVo(int test_score) {
		super();
		this.test_score = test_score;
	}

	public MypageTestscoreVo() {
		super();
	}

	public int getTest_score() {
		return test_score;
	}

	public void setTest_score(int test_score) {
		this.test_score = test_score;
	}

	@Override
	public String toString() {
		return "MypageTestscoreVo [test_score=" + test_score + "]";
	}


	
	
}
