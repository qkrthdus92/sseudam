package com.kh.sseudam.admin.counselPay.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.counselPay.dao.AdminCounselPayDao;
import com.kh.sseudam.admin.counselPay.vo.CounselPayVo;
import com.kh.sseudam.admin.counselPay.vo.SearchVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class AdminCounselPayService {

	public int getCntCounselAll(SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminCounselPayDao().getCntCounselAll(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int getCntCounselF(SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminCounselPayDao().getCntCounselF(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int getCntCounselC(SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminCounselPayDao().getCntCounselC(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int getCntCounselMemAll(SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminCounselPayDao().getCntCounselMemAll(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int getCntCounselMemF(SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminCounselPayDao().getCntCounselMemF(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int getCntCounselMemC(SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminCounselPayDao().getCntCounselMemC(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int getCntCounselProAll(SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminCounselPayDao().getCntCounselProAll(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int getCntCounselProF(SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminCounselPayDao().getCntCounselProF(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int getCntCounselProC(SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminCounselPayDao().getCntCounselProC(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<CounselPayVo> getCounselAll(PageVo pv, SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminCounselPayDao().getCounselAll(conn, vo, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<CounselPayVo> getCounselF(PageVo pv, SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminCounselPayDao().getCounselF(conn, vo, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<CounselPayVo> getCounselC(PageVo pv, SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminCounselPayDao().getCounselC(conn, vo, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<CounselPayVo> getCounselMemAll(PageVo pv, SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminCounselPayDao().getCounselMemAll(conn, vo, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<CounselPayVo> getCounselMemF(PageVo pv, SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminCounselPayDao().getCounselMemF(conn, vo, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<CounselPayVo> getCounselMemC(PageVo pv, SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminCounselPayDao().getCounselMemC(conn, vo, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<CounselPayVo> getCounselProAll(PageVo pv, SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminCounselPayDao().getCounselProAll(conn, vo, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<CounselPayVo> getCounselProF(PageVo pv, SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminCounselPayDao().getCounselProF(conn, vo, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public List<CounselPayVo> getCounselProC(PageVo pv, SearchVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminCounselPayDao().getCounselProC(conn, vo, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

}
