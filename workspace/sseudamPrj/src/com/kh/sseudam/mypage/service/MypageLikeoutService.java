package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeoutVo;
import com.kh.sseudam.mypage.dao.MypageLikeDao;
import com.kh.sseudam.mypage.dao.MypageLikeoutDao;

public class MypageLikeoutService {

	public List<MypageLikeoutVo> selectList(PageVo pv,String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageLikeoutVo> selectList = MypageLikeoutDao.selectList(num,conn,pv);
		
		System.out.println(selectList);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

	//상세조회
	public MypageLikeoutVo selectLikeOne(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		MypageLikeoutVo vo = null;
		
		vo = MypageLikeoutDao.selectLikeOne(conn , no);
		
		JDBCTemplate.close(conn);
		
		return vo;
		
	}

	//삭제
	public int delete(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageLikeoutDao.delete(conn , no);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//갯수조회
	public int selectCount(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageLikeoutDao.selectCount(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
