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
	
	//로그인
	public MemberVo login(MemberVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		MemberVo loginMember = new MemberDao().selectOne(conn, vo);
		JDBCTemplate.close(conn);
		
		return loginMember;
		
	}

	//아이디 중복 확인
	public boolean checkDup(String idCheck) {
		Connection conn = JDBCTemplate.getConnection();
		boolean isIdDup = new MemberDao().checkDup(conn, idCheck);
		JDBCTemplate.close(conn);
		return isIdDup;
		
	}

	public String findMemberId(MemberVo findvo) {
		Connection conn = JDBCTemplate.getConnection();
		String findId = new MemberDao().findMemberId(conn, findvo);
		JDBCTemplate.close(conn);
		return findId;
	
	}
	

	
}
