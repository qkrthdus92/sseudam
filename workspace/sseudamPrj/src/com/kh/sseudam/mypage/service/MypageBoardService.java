package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageBoardVo;
import com.kh.sseudam.mypage.dao.MypageBoardDao;

public class MypageBoardService {

	//목록조회
	public List<MypageBoardVo> selectList(String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageBoardVo> selectList = MypageBoardDao.selectList(num,conn);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

}
