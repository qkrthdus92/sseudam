package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageLikehomeVo;
import com.kh.sseudam.mypage.board.vo.MypageTestscoreVo;
import com.kh.sseudam.mypage.dao.MypageLikehomeDao;
import com.kh.sseudam.mypage.dao.MypageTestscoreDao;

public class MypageTestscoreService {

	public List<MypageTestscoreVo> selectList(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageTestscoreVo> selectList = MypageTestscoreDao.selectList(num,conn);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

}
