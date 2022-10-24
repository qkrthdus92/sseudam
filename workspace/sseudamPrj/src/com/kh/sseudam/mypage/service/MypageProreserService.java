package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageProreserVo;
import com.kh.sseudam.mypage.dao.MypageProreserDao;

public class MypageProreserService {

	public List<MypageProreserVo> selectList(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageProreserVo> selectList = MypageProreserDao.selectList(num,conn);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

}
