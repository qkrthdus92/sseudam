package com.kh.sseudam.member.service;

import java.sql.Connection;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.member.dao.MemberDao;
import com.kh.sseudam.member.vo.MemberVo;

public class MemberService {

	//(일반) 회원가입
	public int join(MemberVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		int result = dao.insertOne(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}
	
}
