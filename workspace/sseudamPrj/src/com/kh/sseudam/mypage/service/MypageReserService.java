package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageReserVo;
import com.kh.sseudam.mypage.dao.MypageReserDao;

public class MypageReserService {

	//예약 목록 조회
	public List<MypageReserVo> selectList(PageVo pv,String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageReserVo> selectList = MypageReserDao.selectList(num,conn,pv);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

	//전체 예약 갯수 조회
	public int selectCountAll(String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageReserDao.selectCountAll(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//완료된 예약 갯수 조회
	public int selectCountFin(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageReserDao.selectCountFin(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int selectCount(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageReserDao.selectCount(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
