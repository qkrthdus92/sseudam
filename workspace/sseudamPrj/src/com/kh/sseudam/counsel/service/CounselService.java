package com.kh.sseudam.counsel.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.counsel.dao.CounselDao;
import com.kh.sseudam.counsel.pro.vo.CertificateVo;
import com.kh.sseudam.counsel.pro.vo.CounselCnt;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.counsel.pro.vo.ReserveVo;

public class CounselService {

	//상담하기 : 전문가 목록 조회
	public List<ProVo> selectList() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	//상담하기 : 이름으로 전문가 목록 조회
	public List<ProVo> selectListByName(String proName, PageVo pv) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByName(conn, proName, pv);
	
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListByVal(String[] counselTypeArr, String[] proLevel, String gender, String certificate, PageVo pv) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByVal(conn, counselTypeArr, proLevel, gender, certificate, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListByLatest(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByLatest(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
		
	}

	public List<ProVo> selectListByStar(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByStar(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListByReview(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByReview(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListByMaxPrice(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByMaxPrice(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListByMinPrice(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByMinPrice(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	//전문가수 카운트
	public int cntProAll() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new CounselDao().cntProAll(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//이름으로 전문가수 카운트
	public int cntProByName(String proName) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new CounselDao().cntProByName(conn, proName);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//전문가 번호로 select
	public ProVo selectListByNo(String bno) {
		Connection conn = JDBCTemplate.getConnection();
		
		ProVo vo = new CounselDao().selectListByNo(conn, bno);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

	public List<CertificateVo> selectCerByNo(String bno) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<CertificateVo> cerList = new CounselDao().selectCerByNo(conn, bno);
		
		JDBCTemplate.close(conn);
		
		return cerList;
	}

	public List<CounselCnt> selectDateListByNo(String bno) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<CounselCnt> dateList = new CounselDao().selectDateListByNo(conn, bno);
		
		JDBCTemplate.close(conn);
		
		return dateList;
	}

	public int insertReserve(ReserveVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new CounselDao().insertReserve(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public int cntProByVal(String[] counselTypeArr, String[] proLevel, String gender, String certificate) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new CounselDao().cntProByVal(conn, counselTypeArr, proLevel, gender, certificate);
		
		JDBCTemplate.close(conn);
		return cnt;
	}

	public int cntLevel3(String[] counselTypeArr, String[] proLevel, String gender, String certificate) {
		Connection conn = JDBCTemplate.getConnection();
		int cnt = new CounselDao().cntLevel3(conn, counselTypeArr, proLevel, gender, certificate);
		JDBCTemplate.close(conn);
		return cnt;
	}

}
