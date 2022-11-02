package com.kh.sseudam.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.board.dao.FreeBoardDao;
import com.kh.sseudam.board.vo.FreeBoardCmtVo;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class FreeBoardService {

	// 자유게시판 게시글 갯수 조회
	public int selectCount() {
		Connection conn = JDBCTemplate.getConnection();

		int result = FreeBoardDao.selectCount(conn);

		JDBCTemplate.close(conn);

		return result;
	}
	
	// 자유게시판 댓글 갯수 조회
	public int selectCountCmt(String bno) {
		Connection conn = JDBCTemplate.getConnection();

		int result = FreeBoardDao.selectCountCmt(conn, bno);

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
	
	//댓글 삭제를 위한 리스트 조회
	public FreeBoardCmtVo cmtList(String cmtNo) {
		Connection conn = JDBCTemplate.getConnection();

		FreeBoardCmtVo cmtVo = FreeBoardDao.cmtList(conn, cmtNo);

		JDBCTemplate.close(conn);

		return cmtVo;
	}
	
	// 자유게시판 댓글 조회
	public List<FreeBoardCmtVo> selectCmt(PageVo pv, String bno, String cmtNo) {
		Connection conn = JDBCTemplate.getConnection();

		List<FreeBoardCmtVo> x = FreeBoardDao.selectCmt(conn, pv, bno);

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
	
	//댓글 작성
	public static int writeCmt(FreeBoardCmtVo cmtVo) {
		Connection conn = JDBCTemplate.getConnection();

		int result = FreeBoardDao.writeCmt(conn, cmtVo);

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
	
	//댓글 삭제
	public int cmtDelete(String cmtNo) {
	
		Connection conn = JDBCTemplate.getConnection();

		int result = FreeBoardDao.cmtDelete(conn, cmtNo);

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
