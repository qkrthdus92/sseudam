package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageProreserVo;
import com.kh.sseudam.mypage.dao.MypageLikehomeDao;
import com.kh.sseudam.mypage.dao.MypageProreserDao;

public class MypageProreserService {

	public List<MypageProreserVo> selectList(PageVo pv,String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageProreserVo> selectList = MypageProreserDao.selectList(num,conn,pv);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

	//갯수 조회
	public int selectCount(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageProreserDao.selectCount(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
