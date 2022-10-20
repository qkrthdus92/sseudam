package com.kh.sseudam.stress.service;

import java.sql.Connection;

import com.kh.sseudam.common.JDBCTemplate;

import temp.MemberDao;
import temp.MemberVo;

public class StressService {

	//테스트점수 회원정보 저장
	public int myScore(MemberVo vo) {

		Connection conn = JDBCTemplate.getConnection();

		// new MemberDao().insertOne(conn.vo);
		MemberDao dao = new MemberDao();
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
