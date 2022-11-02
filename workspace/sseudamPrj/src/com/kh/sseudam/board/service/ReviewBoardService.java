package com.kh.sseudam.board.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.board.dao.FreeBoardDao;
import com.kh.sseudam.board.dao.ReviewBoardDao;
import com.kh.sseudam.board.dao.ReviewBoardDao;
import com.kh.sseudam.board.vo.ReviewBoardCmtVo;
import com.kh.sseudam.board.vo.ReviewBoardVo;
import com.kh.sseudam.board.vo.ReviewBoardCmtVo;
import com.kh.sseudam.board.vo.ReviewBoardImgVo;
import com.kh.sseudam.board.vo.ReviewBoardVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class ReviewBoardService {

	// 후기게시판 게시글 갯수 조회
	public int selectCount() {
		Connection conn = JDBCTemplate.getConnection();

		int result = ReviewBoardDao.selectCount(conn);

		JDBCTemplate.close(conn);

		return result;
	}

	// 후기게시판 댓글 갯수 조회
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

	// 댓글 삭제를 위한 리스트 조회

	// 후기게시판 댓글 조회
	public List<ReviewBoardCmtVo> selectCmt(PageVo cmtPv, String bno, String cmtNo) {
		Connection conn = JDBCTemplate.getConnection();

		List<ReviewBoardCmtVo> x = ReviewBoardDao.selectCmt(conn, cmtPv, bno);

		JDBCTemplate.close(conn);

		return x;
	}

	// 후기게시판 게시글 상세조회 (게시글)
	public ReviewBoardVo detail(String bno) {

		Connection conn = JDBCTemplate.getConnection();

		int result = ReviewBoardDao.increaseViews(conn, bno);

		ReviewBoardVo rvo = null;
		if (result == 1) {
			JDBCTemplate.commit(conn);
			rvo = ReviewBoardDao.detail(conn, bno);
		}
		JDBCTemplate.close(conn);

		return rvo;
	}

	// 후기게시판 게시글 상세조회 (업로드파일)
	public List<ReviewBoardImgVo> selectAttachment(String bno) {

		Connection conn = JDBCTemplate.getConnection();

		List<ReviewBoardImgVo> imgList = ReviewBoardDao.selectAttachment(conn, bno);

		JDBCTemplate.close(conn);

		return imgList;

	}

	// 후기게시판 게시글 작성
	public static int write(ReviewBoardVo rvo, List<ReviewBoardImgVo> imgList) {
		Connection conn = JDBCTemplate.getConnection();
		// 게시글 작성
		int result = ReviewBoardDao.write(conn, rvo);

		// 첨부파일 insert
		int result2 = 1;
		if (imgList != null) {
			result2 = new ReviewBoardDao().insertThumbImg(conn, imgList.get(0));
			for (int i = 1; i < imgList.size(); i++) {
				result2 = new ReviewBoardDao().insertImg(conn, imgList.get(i));
			}
		}

		if (result * result2 == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result * result2;
	}

	// 후기게시판 게시글 수정
	public static int edit(ReviewBoardVo rvo, List<ReviewBoardImgVo> imgList) {
		Connection conn = JDBCTemplate.getConnection();
		// 게시글 작성
		int result = ReviewBoardDao.edit(conn, rvo);

		// 첨부파일 insert
		int result2 = 1;
		if (imgList != null) {
			result2 = new ReviewBoardDao().editThumbImg(conn, imgList.get(0));
			for (int i = 1; i < imgList.size(); i++) {
				result2 = new ReviewBoardDao().editImg(conn, imgList.get(i));
			}
		}

		if (result * result2 == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result * result2;

	}

	//후기게시판 댓글 작성
	public static int writeCmt(ReviewBoardCmtVo cmtVo) {
		Connection conn = JDBCTemplate.getConnection();

		int result = ReviewBoardDao.writeCmt(conn, cmtVo);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	//댓글 삭제를 위한 리스트 조회
	public ReviewBoardCmtVo cmtList(String cmtNo) {
		
		Connection conn = JDBCTemplate.getConnection();

		ReviewBoardCmtVo cmtVo = ReviewBoardDao.cmtList(conn, cmtNo);

		JDBCTemplate.close(conn);

		return cmtVo;
	}

	//댓글 삭제
	public int cmtDelete(String cmtNo) {

		Connection conn = JDBCTemplate.getConnection();

		int result = ReviewBoardDao.cmtDelete(conn, cmtNo);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	//후기게시판 게시글 삭제
	public int delete(String no) {

		Connection conn = JDBCTemplate.getConnection();

		int result = ReviewBoardDao.delete(conn, no);

		if (result == 1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

}
