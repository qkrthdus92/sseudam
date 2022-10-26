package com.kh.sseudam.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.board.vo.FreeBoardCmtVo;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class FreeBoardDao {

	// 자유게시판 게시글 갯수 조회
	public static int selectCount(Connection conn) {
		String sql = "SELECT COUNT(*) AS CNT FROM FREE_BOARD WHERE DELETE_YN = 'N'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("CNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return result;
	}
	
	// 자유게시판 댓글 갯수 조회
	public static int selectCountCmt(Connection conn, String bno) {
		String sql = "SELECT COUNT(*) AS CNT FROM FREE_BOARD_CMT WHERE FREE_BOARD_NO = ? AND DELETE_YN = 'N'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
	
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt("CNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	// 자유게시판 게시글 리스트 불러오기
	public static List<FreeBoardVo> selectList(Connection conn, PageVo pv) {

		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM (SELECT B.NO, B.TITLE, M.NICK AS WRITER_NO, TO_CHAR(B.WRITE_DATE, 'yyyy-mm-dd') AS WRITE_DATE, B.VIEWS FROM FREE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE DELETE_YN = 'N' ORDER BY NO DESC) T) WHERE RNUM BETWEEN ? AND ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardVo> voList = new ArrayList<FreeBoardVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String writerNo = rs.getString("WRITER_NO");
				String writeDate = rs.getString("WRITE_DATE");
				String views = rs.getString("VIEWS");

				FreeBoardVo vo = new FreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setWriterNo(writerNo);
				vo.setViews(views);
				vo.setWriteDate(writeDate);
				voList.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return voList;

	}
	
	//자유게시판 댓글조회
	public static List<FreeBoardCmtVo> selectCmt(Connection conn, PageVo pv, String bno) {

		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM (SELECT C.NO, C.FREE_BOARD_NO, C.CMT, M.NICK AS WRITER_NO, TO_CHAR(C.MODIFY_DATE, 'yyyy-mm-dd') AS MODIFY_DATE,C.DELETE_YN FROM FREE_BOARD_CMT C JOIN MEMBER M ON C.WRITER_NO = M.NO WHERE DELETE_YN = 'N' AND FREE_BOARD_NO = ? ORDER BY NO DESC) T) WHERE RNUM BETWEEN ? AND ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardCmtVo> cmtList = new ArrayList<FreeBoardCmtVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;

			pstmt.setString(1, bno);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("NO");
				String freeBoardNo = rs.getString("FREE_BOARD_NO");
				String cmt = rs.getString("CMT");
				String writerNo = rs.getString("WRITER_NO");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");

				FreeBoardCmtVo cmtVo = new FreeBoardCmtVo();
				cmtVo.setNo(no);
				cmtVo.setFreeBoardNo(freeBoardNo);
				cmtVo.setCmt(cmt);
				cmtVo.setWriterNo(writerNo);
				cmtVo.setModifyDate(modifyDate);
				cmtVo.setDeleteYn(deleteYn);
				cmtList.add(cmtVo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return cmtList;
	}

	// 자유게시판 상세조회
	public static FreeBoardVo detail(Connection conn, String bno) {
		String sql = "SELECT B.NO, B.TITLE ,B.CONTENT ,B.VIEWS, TO_CHAR(B.WRITE_DATE, 'yyyy-mm-dd') AS WRITE_DATE, TO_CHAR(B.MODIFY_DATE, 'yyyy-mm-dd') AS MODIFY_DATE, B.DELETE_YN, M.NICK AS WRITER_NO FROM FREE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE B.NO = ? AND B.DELETE_YN = 'N'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FreeBoardVo vo = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String views = rs.getString("VIEWS");
				String writeDate = rs.getString("WRITE_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				String writerNo = rs.getString("WRITER_NO");
				

				vo = new FreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setViews(views);
				vo.setWriteDate(writeDate);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				vo.setWriterNo(writerNo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return vo;
	}

	// 자유게시판 게시글 조회수 증가
	public static int increaseViews(Connection conn, String bno) {
		String sql = "UPDATE FREE_BOARD SET VIEWS = VIEWS + 1 WHERE NO = ? AND DELETE_YN = 'N'";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bno);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);

		}
		return result;
	}

	// 자유게시판 게시글 작성
	public static int write(Connection conn, FreeBoardVo vo) {
		String sql = "INSERT INTO FREE_BOARD(NO, WRITER_NO, TITLE, CONTENT) VALUES(SEQ_FREE_BOARD_NO.NEXTVAL, ?, ?, ?)";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getWriterNo());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public static int delete(Connection conn, String no) {
		// 자유게시판 게시글 삭제
		String sql = "UPDATE FREE_BOARD SET DELETE_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, no);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	//자유게시판 게시글 수정
	public static int edit(Connection conn, FreeBoardVo vo) {

		String sql = "UPDATE FREE_BOARD SET TITLE = ?, CONTENT = ?, MODIFY_DATE = SYSDATE WHERE NO = ?";

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	//자유게시판 제목으로 검색
	public static List<FreeBoardVo> searchTitle(Connection conn, PageVo pv) {
		
		//제목으로 검색 '%제목%'
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM (SELECT B.NO, B.TITLE, M.NICK AS WRITER_NO, TO_CHAR(B.WRITE_DATE, 'yyyy-mm-dd') AS WRITE_DATE, B.VIEWS FROM FREE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE DELETE_YN = 'N' ORDER BY NO DESC) T) WHERE TITLE LIKE ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardVo> voList = new ArrayList<FreeBoardVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			//int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			//int end = start + pv.getBoardLimit() - 1;

			pstmt.setString(1, "'%" + rs.getString("TITLE") + "%'");
			//pstmt.setInt(2, end);

			System.out.println(rs.getString("TITLE"));
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String writerNo = rs.getString("WRITER_NO");
				String writeDate = rs.getString("WRITE_DATE");
				String views = rs.getString("VIEWS");

				FreeBoardVo vo = new FreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setWriterNo(writerNo);
				vo.setViews(views);
				vo.setWriteDate(writeDate);
				voList.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return voList;	
	}
	
	//자유게시판 내용으로 검색
	public static List<FreeBoardVo> searchContent(Connection conn, PageVo pv) {
			
		//내용으로 검색 '%내용%'
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM (SELECT B.NO, B.TITLE, B.CONTENT, M.NICK AS WRITER_NO, TO_CHAR(B.WRITE_DATE, 'yyyy-mm-dd') AS WRITE_DATE, B.VIEWS FROM FREE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE DELETE_YN = 'N' ORDER BY NO DESC) T) WHERE \"CONTENT\" LIKE ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardVo> voList = new ArrayList<FreeBoardVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String writerNo = rs.getString("WRITER_NO");
				String writeDate = rs.getString("WRITE_DATE");
				String views = rs.getString("VIEWS");

				FreeBoardVo vo = new FreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setWriterNo(writerNo);
				vo.setViews(views);
				vo.setWriteDate(writeDate);
				voList.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return voList;	
	}
	
	//자유게시판 작성자로 검색
	public static List<FreeBoardVo> searchWriter(Connection conn, PageVo pv) {
			
		//작성자로 검색 '%작성자%'
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM (SELECT B.NO, B.TITLE, M.NICK AS WRITER_NO, TO_CHAR(B.WRITE_DATE, 'yyyy-mm-dd') AS WRITE_DATE, B.VIEWS FROM FREE_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE DELETE_YN = 'N' ORDER BY NO DESC) T) WHERE WRITER_NO LIKE ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardVo> voList = new ArrayList<FreeBoardVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String writerNo = rs.getString("WRITER_NO");
				String writeDate = rs.getString("WRITE_DATE");
				String views = rs.getString("VIEWS");

				FreeBoardVo vo = new FreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setWriterNo(writerNo);
				vo.setViews(views);
				vo.setWriteDate(writeDate);
				voList.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return voList;	
	}



}
