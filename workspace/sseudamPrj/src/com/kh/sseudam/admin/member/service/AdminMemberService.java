package com.kh.sseudam.admin.member.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.member.dao.AdminMemberDao;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.member.vo.MemberVo;

public class AdminMemberService {
	
	//전체 사용자 수 카운트
	public int selectCntAll() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminMemberDao().selectCntAll(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<MemberVo> selectListAll(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List memberList = new AdminMemberDao().selectListAll(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return memberList;
	}

	public int selectCntN() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminMemberDao().selectCntN(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int selectCntY() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminMemberDao().selectCntY(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<MemberVo> selectListN(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List memberList = new AdminMemberDao().selectListN(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return memberList;
	}

	public List<MemberVo> selectListY(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List memberList = new AdminMemberDao().selectListY(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return memberList;
	}

	public int selectCntSearch(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminMemberDao().selectCntSearch(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<MemberVo> selectListSearch(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		List memberList = new AdminMemberDao().selectListSearch(conn, pv, search);
		
		JDBCTemplate.close(conn);
		
		return memberList;
	}

	public MemberVo selectOneByNo(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		MemberVo vo = new AdminMemberDao().selectOneByNo(conn, mno);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public int updateMember(MemberVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminMemberDao().updateMember(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int insertOne(MemberVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminMemberDao().insertOne(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public boolean checkDup(String id) {
		Connection conn = JDBCTemplate.getConnection();
		
		boolean isIdDup = new AdminMemberDao().checkDup(conn, id);
		
		JDBCTemplate.close(conn);
		
		return isIdDup;
	}

	public boolean checkNotChange(String no, String id) {
		Connection conn = JDBCTemplate.getConnection();
		
		boolean isNotChange = new AdminMemberDao().checkNotChange(conn, no, id);
		
		JDBCTemplate.close(conn);
		
		return isNotChange;
	}

	public boolean checkNotChangeNick(String no, String nick) {
		Connection conn = JDBCTemplate.getConnection();
		
		boolean isNotChangeNick = new AdminMemberDao().checkNotChangeNick(conn, no, nick);
		
		JDBCTemplate.close(conn);
		
		return isNotChangeNick;
	}

	public boolean checkDupNick(String nick) {
		Connection conn = JDBCTemplate.getConnection();
		
		boolean isIdDupNick = new AdminMemberDao().checkDupNick(conn, nick);
		
		JDBCTemplate.close(conn);
		
		return isIdDupNick;
	}

	public int quitOne(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminMemberDao().quitOne(conn, mno);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

}
