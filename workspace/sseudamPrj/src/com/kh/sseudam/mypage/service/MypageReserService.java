package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.board.vo.MypageReserDetailVo;
import com.kh.sseudam.mypage.board.vo.MypageReserVo;
import com.kh.sseudam.mypage.dao.MypageLikeDao;
import com.kh.sseudam.mypage.dao.MypageReserDao;

public class MypageReserService {

	public List<MypageReserVo> selectList(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageReserVo> selectList = MypageReserDao.selectList(num,conn);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

	//상세조회
	public MypageReserVo selectReserOne(String num, String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		MypageReserVo vo = null;
		
		vo = MypageReserDao.selectReserOne(conn , no,num);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

}
