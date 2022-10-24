package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageAllreserVo;
import com.kh.sseudam.mypage.dao.MypageAllreserDao;

public class MypageAllreserService {

	public List<MypageAllreserVo> selectList(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageAllreserVo> selectList = MypageAllreserDao.selectList(num,conn);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

}
