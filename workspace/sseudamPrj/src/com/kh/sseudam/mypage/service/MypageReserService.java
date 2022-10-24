package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.board.vo.MypageReserVo;
import com.kh.sseudam.mypage.dao.MypageLikeDao;
import com.kh.sseudam.mypage.dao.MypageReserDao;

public class MypageReserService {

	public List<MypageReserVo> selectList(PageVo pv,String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageReserVo> selectList = MypageReserDao.selectList(num,conn,pv);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

	public int selectCount() {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageReserDao.selectCount(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
