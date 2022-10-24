package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageReserDetailVo;
import com.kh.sseudam.mypage.dao.MypageReserDetailDao;

public class MypageReserDetailService {

	public MypageReserDetailVo selectReserOne(String num,String no) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageReserDetailVo> selectList = MypageReserDetailDao.selectList(num,conn);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

}
