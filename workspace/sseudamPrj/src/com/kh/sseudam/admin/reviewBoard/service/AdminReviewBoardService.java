package com.kh.sseudam.admin.reviewBoard.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.freeBoard.dao.AdminFreeBoardDao;
import com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardCmtVo;
import com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardVo;
import com.kh.sseudam.admin.reviewBoard.dao.AdminReviewBoardDao;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class AdminReviewBoardService {
	
	//모든게시글 카운트
	public int getCntFreeAll() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeAll(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//게시완료 카운트
	public int getCntFreeF() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeF(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//게시취소 카운트
	public int getCntFreeC() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeC(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//제목+모든 카운트
	public int getCntFreeTitleAll(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeTitleAll(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public int getCntFreeTitleF(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeTitleF(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//제목+취소 카운트
	public int getCntFreeTitleC(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeTitleC(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//내용+모든 카운트
	public int getCntFreeContentAll(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeContentAll(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//내용+완료 카운트
	public int getCntFreeContentF(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeContentF(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//내용+취소 카운트
	public int getCntFreeContentC(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeContentC(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//작성자+모든 카운트
	public int getCntFreeWriterAll(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeWriterAll(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//작성자+완료 카운트
	public int getCntFreeWriterF(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeWriterF(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//작성자+취소 카운트
	public int getCntFreeWriterC(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeWriterC(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//모든게시글 리스트 조회
	public List<AdminFreeBoardVo> getFreeAll(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminReviewBoardDao().getFreeAll(conn, pv);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//게시완료 게시글 조회
	public List<AdminFreeBoardVo> getFreeF(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminReviewBoardDao().getFreeF(conn, pv);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//게시취소 게시글 조회
	public List<AdminFreeBoardVo> getFreeC(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminReviewBoardDao().getFreeC(conn, pv);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//제목+모든 게시글 조회
	public List<AdminFreeBoardVo> getFreeTitleAll(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminReviewBoardDao().getFreeTitleAll(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//제목+완료 게시글 조회
	public List<AdminFreeBoardVo> getFreeTitleF(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminReviewBoardDao().getFreeTitleF(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//제목+취소 게시글 조회
	public List<AdminFreeBoardVo> getFreeTitleC(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		List list = new AdminReviewBoardDao().getFreeTitleC(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//내용+모든 게시글 조회
	public List<AdminFreeBoardVo> getFreeContentAll(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		List list = new AdminReviewBoardDao().getFreeContentAll(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//내용+완료 게시글 조회
	public List<AdminFreeBoardVo> getFreeContentF(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		List list = new AdminReviewBoardDao().getFreeContentF(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//내용+취소 게시글 조회
	public List<AdminFreeBoardVo> getFreeContentC(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		List list = new AdminReviewBoardDao().getFreeContentC(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//작성자+모든 게시글 조회
	public List<AdminFreeBoardVo> getFreeWriterAll(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		List list = new AdminReviewBoardDao().getFreeWriterAll(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//작성자+완료 게시글 조회
	public List<AdminFreeBoardVo> getFreeWriterF(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		List list = new AdminReviewBoardDao().getFreeWriterF(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//작성자+취소 게시글 조회
	public List<AdminFreeBoardVo> getFreeWriterC(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		List list = new AdminReviewBoardDao().getFreeWriterC(conn, pv, search);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//자유게시판 글 작성
	public int insertFreeBoard(AdminFreeBoardVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminReviewBoardDao().insertFreeBoard(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//자유게시판 글번호로 글 상세조회
	public AdminFreeBoardVo selectFreeBoardDetailByNo(String bno) {
		Connection conn = JDBCTemplate.getConnection();
		
		AdminFreeBoardVo freeBoardVo = new AdminReviewBoardDao().selectFreeBoardDetailByNo(conn, bno);
		
		JDBCTemplate.close(conn);
		
		return freeBoardVo;
	}

	//자유게시판 글번호로 댓글리스트 조회
	public List<AdminFreeBoardCmtVo> selectFreeBoardCmtByNo(String bno, PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<AdminFreeBoardCmtVo> list = new AdminReviewBoardDao().selectFreeBoardCmtByNo(conn, bno, pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int editFreeBoardDetail(AdminFreeBoardVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminReviewBoardDao().editFreeBoardDetail(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int deleteFreeBoardDetail(String bno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminReviewBoardDao().deleteFreeBoardDetail(conn, bno);
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	//글번호랑 댓글번호로 댓글내용 업데이트
	public int editFreeBoardCmt(AdminFreeBoardCmtVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminReviewBoardDao().editFreeBoardCmt(conn, vo);
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int deleteFreeBoardCmt(String bno, String cno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminReviewBoardDao().deleteFreeBoardCmt(conn, bno, cno);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int insertFreeBoardCmt(String bno, String cmt) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminReviewBoardDao().insertFreeBoardCmt(conn, bno, cmt);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int getCntFreeCmt(String bno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminReviewBoardDao().getCntFreeCmt(conn, bno);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

}
