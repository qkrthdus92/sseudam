package com.kh.sseudam.admin.freeBoard.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.freeBoard.dao.AdminFreeBoardDao;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class AdminFreeBoardService {

	//모든게시글 카운트
	public int getCntFreeAll() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeAll(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//게시완료 카운트
	public int getCntFreeF() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeF(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//게시취소 카운트
	public int getCntFreeC() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeC(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//제목+모든 카운트
	public int getCntFreeTitleAll(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeTitleAll(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int getCntFreeTitleF(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeTitleF(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//제목+취소 카운트
	public int getCntFreeTitleC(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeTitleC(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//내용+모든 카운트
	public int getCntFreeContentAll(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeContentAll(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//내용+완료 카운트
	public int getCntFreeContentF(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeContentF(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//내용+취소 카운트
	public int getCntFreeContentC(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeContentC(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//작성자+모든 카운트
	public int getCntFreeWriterAll(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeWriterAll(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//작성자+완료 카운트
	public int getCntFreeWriterF(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeWriterF(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//작성자+취소 카운트
	public int getCntFreeWriterC(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminFreeBoardDao().getCntFreeWriterC(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//모든게시글 리스트 조회
	public List<FreeBoardVo> getFreeAll(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminFreeBoardDao().getFreeAll(conn, pv);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//게시완료 게시글 조회
	public List<FreeBoardVo> getFreeF(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminFreeBoardDao().getFreeF(conn, pv);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//게시취소 게시글 조회
	public List<FreeBoardVo> getFreeC(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminFreeBoardDao().getFreeC(conn, pv);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//제목+모든 게시글 조회
	public List<FreeBoardVo> getFreeTitleAll(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminFreeBoardDao().getFreeTitleAll(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//제목+완료 게시글 조회
	public List<FreeBoardVo> getFreeTitleF(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminFreeBoardDao().getFreeTitleF(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//제목+취소 게시글 조회
	public List<FreeBoardVo> getFreeTitleC(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminFreeBoardDao().getFreeTitleC(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

}
