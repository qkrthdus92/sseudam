package com.kh.sseudam.admin.pro.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.member.dao.AdminMemberDao;
import com.kh.sseudam.admin.pro.dao.AdminProDao;
import com.kh.sseudam.common.AttachmentVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.counsel.pro.vo.CertificateVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.vo.MemberVo;

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

	//승인완료 전문가 조회
	public List<ProVo> selectListJ(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List proList = new AdminProDao().selectListJ(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListQ(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List proList = new AdminProDao().selectListQ(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public int selectCntSearch(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminProDao().selectCntSearch(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<ProVo> selectListSearch(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		List proList = new AdminProDao().selectListSearch(conn, pv, search);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public int insertOne(ProVo vo, AttachmentVo aVo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminProDao().insertOne(conn, vo, aVo);
		
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result; 
	}

	//전문가 1명 개인정보 받아오기
	public ProVo selectOneByNo(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		ProVo vo = new AdminProDao().selectOneByNo(conn, mno);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//전문가 1명의 자격정보 받아오기
	public List<CertificateVo> selectCerByBo(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		List voList=new AdminProDao().selectCerByNo(conn, mno);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public boolean checkNotChange(String no, String id) {
		Connection conn = JDBCTemplate.getConnection();
		
		boolean isNotChange = new AdminProDao().checkNotChange(conn, no, id);
		
		JDBCTemplate.close(conn);
		
		return isNotChange;
	}

	public boolean checkDup(String id) {
		Connection conn = JDBCTemplate.getConnection();
		
		boolean isIdDup = new AdminProDao().checkDup(conn, id);
		
		JDBCTemplate.close(conn);
		
		return isIdDup;
	}

	public int quitOne(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminProDao().quitOne(conn, mno);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

}
