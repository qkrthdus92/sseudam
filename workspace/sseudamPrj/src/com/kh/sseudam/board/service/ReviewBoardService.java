package com.kh.sseudam.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.board.dao.FreeBoardDao;
import com.kh.sseudam.board.dao.ReviewBoardDao;
import com.kh.sseudam.board.vo.FreeBoardCmtVo;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.board.vo.ReviewBoardCmtVo;
import com.kh.sseudam.board.vo.ReviewBoardImgVo;
import com.kh.sseudam.board.vo.ReviewBoardVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class ReviewBoardService {
	
	//후기게시판 게시글 갯수 조회
	public int selectCount() {
		Connection conn = JDBCTemplate.getConnection();

		int result = ReviewBoardDao.selectCount(conn);

		JDBCTemplate.close(conn);

		return result;
	}
	
	//후기게시판 댓글 갯수 조회
	public int selectCountCmt(String bno) {
		Connection conn = JDBCTemplate.getConnection();

		int result = ReviewBoardDao.selectCountCmt(conn, bno);

		JDBCTemplate.close(conn);

		return result;
	}

	// 후기게시판 게시글 목록 조회
	public List<ReviewBoardVo> selectList(PageVo rpv) {
		Connection conn = JDBCTemplate.getConnection();

		List<ReviewBoardVo> x = ReviewBoardDao.selectList(conn, rpv);

		JDBCTemplate.close(conn);

		return x;
	}
	
	//댓글 삭제를 위한 리스트 조회
	
	//후기게시판 댓글 조회
	public List<ReviewBoardCmtVo> selectCmt(PageVo cmtPv, String bno, String cmtNo) {
		Connection conn = JDBCTemplate.getConnection();

		List<ReviewBoardCmtVo> x = ReviewBoardDao.selectCmt(conn, cmtPv, bno);

		JDBCTemplate.close(conn);

		return x;
	}
	
	//후기게시판 게시글 상세조회
	public ReviewBoardVo detail(String bno) {
		
		Connection conn = JDBCTemplate.getConnection();
		ReviewBoardVo rvo = null;
		
		int result = ReviewBoardDao.increaseViews(conn, bno);
		if(result == 1) {
			JDBCTemplate.commit(conn);
			rvo = ReviewBoardDao.detail(conn, bno);	
		}
		JDBCTemplate.close(conn);
		
		return rvo;
	}

	//후기게시판 게시글 작성
	public static int write(ReviewBoardVo vo, ReviewBoardImgVo imgVo) {
		Connection conn = JDBCTemplate.getConnection();
		//게시글 작성
		int result = ReviewBoardDao.write(conn, vo);
		
		//첨부파일 insert
		int result2 = 1;
		if(imgVo != null) {
			result = ReviewBoardDao.insertImg(conn, imgVo);
		}
		
		if(result * result2 == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result * result2;
	}

	//후기게시판 게시글 수정
	public int edit(ReviewBoardVo rvo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = ReviewBoardDao.edit(conn, rvo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;	
	}







	
	
	
	
	
	/*
	 * //후기게시판 썸네일 조회 public ReviewBoardImgVo selectThumb(String bno) { Connection
	 * conn = JDBCTemplate.getConnection();
	 * 
	 * ReviewBoardImgVo imgVo = ReviewBoardDao.selectThumb(conn, bno);
	 * 
	 * JDBCTemplate.close(conn);
	 * 
	 * return imgVo; }
	 */

	//후기게시판 게시글 작성

	
	



}
