package com.kh.sseudam.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.board.dao.FreeBoardDao;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class FreeBoardService {

	// 자유게시판 게시글 갯수 조회
	public int selectcount() {
		Connection conn = JDBCTemplate.getConnection();

		int result = FreeBoardDao.selectCount(conn);

		JDBCTemplate.close(conn);

		return result;
	}

	// 자유게시판 게시글 목록 조회
	public List<FreeBoardVo> selectList(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();

		List<FreeBoardVo> x = FreeBoardDao.selectList(conn, pv);

		JDBCTemplate.close(conn);

		return x;
	}

	// 자유게시판 게시글 상세조회
	public FreeBoardVo detail(String bno) {
		Connection conn = JDBCTemplate.getConnection();
		FreeBoardVo vo = null;
		
		int result = FreeBoardDao.increaseViews(conn, bno);
		if(result == 1) {
			JDBCTemplate.commit(conn);
			vo = FreeBoardDao.detail(conn, bno);	
		}
		JDBCTemplate.close(conn);
		
		return vo;
	}

	// 자유게시판 게시글 작성
	public static int write(FreeBoardVo vo) {
		Connection conn = JDBCTemplate.getConnection();

		int result = FreeBoardDao.write(conn, vo);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	// 자유게시판 게시글 삭제
	public int delete(String no) {
		Connection conn = JDBCTemplate.getConnection();

		int result = FreeBoardDao.delete(conn, no);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	//자유게시판 게시글 수정
	public int edit(FreeBoardVo vo) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = FreeBoardDao.edit(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;	
	}

	//자유게시판 제목으로 검색
	public List<FreeBoardVo> searchTitle(PageVo pv) {

		Connection conn = JDBCTemplate.getConnection();

		List<FreeBoardVo> x = FreeBoardDao.searchTitle(conn, pv);

		JDBCTemplate.close(conn);

		return x;	
	}
	
	//자유게시판 내용으로 검색
	public List<FreeBoardVo> searchContent(PageVo pv) {

		Connection conn = JDBCTemplate.getConnection();

		List<FreeBoardVo> x = FreeBoardDao.searchContent(conn, pv);

		JDBCTemplate.close(conn);

		return x;	
	}
	
	//자유게시판 작성자로 검색
	public List<FreeBoardVo> searchWriter(PageVo pv) {

		Connection conn = JDBCTemplate.getConnection();

		List<FreeBoardVo> x = FreeBoardDao.searchWriter(conn, pv);

		JDBCTemplate.close(conn);

		return x;	
	}

}
