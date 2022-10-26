package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageBoardVo;
import com.kh.sseudam.mypage.board.vo.MypageCommentVo;
import com.kh.sseudam.mypage.board.vo.MypageCommentVo2;
import com.kh.sseudam.mypage.dao.MypageBoardDao;
import com.kh.sseudam.mypage.dao.MypageCommentDao;
import com.kh.sseudam.mypage.dao.MypageFinreserDao;

public class MypageCommentService {

	public List<MypageCommentVo> selectList(PageVo pv,String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageCommentVo> selectList = MypageCommentDao.selectList(num,conn,pv);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

	public List<MypageCommentVo2> selectList2(PageVo pv,String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageCommentVo2> selectList2 = MypageCommentDao.selectList2(num,conn,pv);
		
		JDBCTemplate.close(conn);
		
		return selectList2;
	}

	public int selectCount(String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageCommentDao.selectCount(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
