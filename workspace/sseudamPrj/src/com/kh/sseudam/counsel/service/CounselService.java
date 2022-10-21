package com.kh.sseudam.counsel.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.counsel.dao.CounselDao;
import com.kh.sseudam.counsel.pro.vo.ProVo;

public class CounselService {

	//상담하기 : 전문가 목록 조회
	public List<ProVo> selectList() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	//상담하기 : 이름으로 전문가 목록 조회
	public List<ProVo> selectListByName(String proName) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByName(conn, proName);
	
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListByVal(String[] counselTypeArr, String[] proLevel, String gender, String certificate) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByVal(conn, counselTypeArr, proLevel, gender, certificate);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListByLatest() {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByLatest(conn);
		
		JDBCTemplate.close(conn);
		
		return proList;
		
	}

	public List<ProVo> selectListByStar() {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByStar(conn);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListByReview() {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByReview(conn);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListByMaxPrice() {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByMaxPrice(conn);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListByMinPrice() {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectListByMinPrice(conn);
		
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

}
