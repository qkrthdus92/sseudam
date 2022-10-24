package com.kh.sseudam.admin.member.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.member.dao.MemberDao;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.member.vo.MemberVo;

public class MemberService {

	//전체 사용자 수 카운트
	public int selectCntAll() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new MemberDao().selectCntAll(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<MemberVo> selectListAll(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List memberList = new MemberDao().selectListAll(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return memberList;
	}

}
