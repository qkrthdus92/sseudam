package com.kh.sseudam.stress.service;

import java.sql.Connection;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.stress.dao.StressDao;

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

}
