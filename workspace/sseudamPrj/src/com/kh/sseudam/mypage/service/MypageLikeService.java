package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageBoardVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.dao.MypageBoardDao;
import com.kh.sseudam.mypage.dao.MypageLikeDao;
import com.kh.sseudam.mypage.dao.MypageLikehomeDao;

public class MypageLikeService {

	public List<MypageLikeVo> selectList(PageVo pv ,String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageLikeVo> selectList = MypageLikeDao.selectList(num,conn,pv);
		
		JDBCTemplate.close(conn);
		
		return selectList;
		
	}

	//상세조회
	public MypageLikeVo selectLikeOne(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		MypageLikeVo vo = null;
		
		vo = MypageLikeDao.selectLikeOne(conn , no);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}
//삭제
	public int delete(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageLikeDao.delete(conn , no);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	

	//갯수조회
	public int selectCount(String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageLikeDao.selectCount(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}

}
