package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageFinreserVo;
import com.kh.sseudam.mypage.board.vo.MypageReserVo;
import com.kh.sseudam.mypage.dao.MypageFinreserDao;

public class MypageFinreserService {

	public List<MypageFinreserVo> selectList(String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageFinreserVo> selectList = MypageFinreserDao.selectList(num,conn);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

}
