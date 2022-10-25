package com.kh.sseudam.stress.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.board.dao.FreeBoardDao;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.stress.dao.StressDao;
import com.kh.sseudam.stress.vo.StressVo;
import com.kh.sseudam.member.vo.MemberVo;

public class StressService {

	//테스트점수 회원정보 저장
	public int myScore(MemberVo vo) {

		Connection conn = JDBCTemplate.getConnection();

		StressDao dao = new StressDao();
		int result = dao.myScore(conn, vo);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	//테스트점수에 따라 컨텐츠 추천
	public List<StressVo> suggestContent(int testScore) {

		Connection conn = JDBCTemplate.getConnection();

		List<StressVo> suggest = StressDao.suggestContent(conn, testScore);

		JDBCTemplate.close(conn);

		return suggest;
		
	}
	


}
