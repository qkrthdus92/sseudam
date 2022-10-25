package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageAllreserVo;
import com.kh.sseudam.mypage.dao.MypageAllreserDao;
import com.kh.sseudam.mypage.dao.MypageReserDao;

public class MypageAllreserService {

	public List<MypageAllreserVo> selectList(PageVo pv,String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageAllreserVo> selectList = MypageAllreserDao.selectList(num,conn,pv);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

	//예약 갯수 조회
	public int selectCount(String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageAllreserDao.selectCount(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}
}
