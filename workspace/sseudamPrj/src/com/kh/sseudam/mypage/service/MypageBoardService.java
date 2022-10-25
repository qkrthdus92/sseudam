package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageBoardVo;
import com.kh.sseudam.mypage.dao.MypageBoardDao;
import com.kh.sseudam.mypage.dao.MypageReserDao;

public class MypageBoardService {

	//목록조회
	public List<MypageBoardVo> selectList(PageVo pv,String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageBoardVo> selectList = MypageBoardDao.selectList(num,conn,pv);
		
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}

	public int selectCount(String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageBoardDao.selectCount(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
