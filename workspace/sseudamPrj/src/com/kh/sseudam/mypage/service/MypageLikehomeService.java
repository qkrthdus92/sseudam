package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.board.vo.MypageLikehomeVo;
import com.kh.sseudam.mypage.dao.MypageLikeDao;
import com.kh.sseudam.mypage.dao.MypageLikehomeDao;

public class MypageLikehomeService {

	public List<MypageLikehomeVo> selectList(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageLikehomeVo> selectList = MypageLikehomeDao.selectList(num,conn);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

}
