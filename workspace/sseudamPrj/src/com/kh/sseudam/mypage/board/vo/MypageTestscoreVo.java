package com.kh.sseudam.mypage.board.vo;

public class MypageTestscoreVo {

	private int test_score;
	private String nick;
	public MypageTestscoreVo(int test_score, String nick) {
		super();
		this.test_score = test_score;
		this.nick = nick;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public String toString() {
		return "MypageTestscoreVo [test_score=" + test_score + ", nick=" + nick + "]";
	}
	
	

	
	
	
}
