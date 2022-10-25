package com.kh.sseudam.admin.pro.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.member.dao.AdminMemberDao;
import com.kh.sseudam.admin.pro.dao.AdminProDao;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;

public class AdminProService {

	//모든전문가수 카운트
	public int selectCntAll() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminProDao().selectCntAll(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//모든 전문가 조회
	public List<ProVo> selectListAll(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List proList = new AdminProDao().selectListAll(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	//승인대기전문가수 카운트
	public int selectCntW() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminProDao().selectCntW(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//승인완료전문가수 카운트
	public int selectCntJ() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminProDao().selectCntJ(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//탈퇴전문가수 카운트
	public int selectCntQ() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminProDao().selectCntQ(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//승인대기 전문가 조회
	public List<ProVo> selectListW(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List proList = new AdminProDao().selectListW(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

}
