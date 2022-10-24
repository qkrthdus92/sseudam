package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageBoardVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.dao.MypageBoardDao;
import com.kh.sseudam.mypage.dao.MypageLikeDao;

public class MypageLikeService {

	public List<MypageLikeVo> selectList(String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageLikeVo> selectList = MypageLikeDao.selectList(num,conn);
		
		JDBCTemplate.close(conn);
		
		return selectList;
		
	}

}
