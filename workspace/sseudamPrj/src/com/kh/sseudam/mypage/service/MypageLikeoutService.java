package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeoutVo;
import com.kh.sseudam.mypage.dao.MypageLikeDao;
import com.kh.sseudam.mypage.dao.MypageLikeoutDao;

public class MypageLikeoutService {

	public List<MypageLikeoutVo> selectList(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageLikeoutVo> selectList = MypageLikeoutDao.selectList(num,conn);
		
		System.out.println(selectList);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

}
