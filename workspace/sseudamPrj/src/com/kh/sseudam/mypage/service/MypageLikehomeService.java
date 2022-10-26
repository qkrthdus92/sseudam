package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.board.vo.MypageLikehomeVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeoutVo;
import com.kh.sseudam.mypage.dao.MypageLikeDao;
import com.kh.sseudam.mypage.dao.MypageLikehomeDao;
import com.kh.sseudam.mypage.dao.MypageLikeoutDao;
import com.kh.sseudam.mypage.dao.MypageReserDao;

public class MypageLikehomeService {

	public List<MypageLikehomeVo> selectList(PageVo pv,String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageLikehomeVo> selectList = MypageLikehomeDao.selectList(num,conn,pv);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

	//상세조회
	public MypageLikehomeVo selectLikeOne(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		MypageLikehomeVo vo = null;
		
		vo = MypageLikehomeDao.selectLikeOne(conn , no);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//삭제
	public int delete(String no) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageLikehomeDao.delete(conn , no);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//갯수조회
	public int selectCount(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageLikehomeDao.selectCount(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
