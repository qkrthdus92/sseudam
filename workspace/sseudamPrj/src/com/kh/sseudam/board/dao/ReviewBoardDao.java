package com.kh.sseudam.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.board.vo.ReviewBoardCmtVo;
import com.kh.sseudam.board.vo.ReviewBoardVo;
import com.kh.sseudam.board.vo.ReviewBoardCmtVo;
import com.kh.sseudam.board.vo.ReviewBoardImgVo;
import com.kh.sseudam.board.vo.ReviewBoardVo;
import com.kh.sseudam.board.vo.ReviewBoardVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class ReviewBoardDao {

	// 후기게시판 게시글 갯수 조회
	public static int selectCount(Connection conn) {

		String sql = "SELECT COUNT(*) AS CNT FROM REVIEW_BOARD WHERE DELETE_YN = 'N'";

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

	// 후기게시판 게시글 목록 조회
	public static List<ReviewBoardVo> selectList(Connection conn, PageVo rpv) {

		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM ( SELECT B.NO ,B.TITLE ,B.VIEWS, TO_CHAR(B.WRITE_DATE, 'yyyy-mm-dd') AS WRITE_DATE ,M.NICK AS WRITER_NO, I.ORIGIN_NAME, I.CHANGE_NAME, I.FILE_PATH FROM REVIEW_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO JOIN REVIEW_BOARD_IMG I ON B.NO = I.REVIEW_BOARD_NO WHERE B.DELETE_YN = 'N' AND I.THUMB_YN = 'Y' ORDER BY B.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewBoardVo> rvoList = new ArrayList<ReviewBoardVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			int start = (rpv.getCurrentPage() - 1) * rpv.getBoardLimit() + 1;
			int end = start + rpv.getBoardLimit() - 1;

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String views = rs.getString("VIEWS");
				String writeDate = rs.getString("WRITE_DATE");
				String writerNo = rs.getString("WRITER_NO");
				String originName = rs.getString("ORIGIN_NAME");
				String changeName = rs.getString("CHANGE_NAME");
				String filePath = rs.getString("FILE_PATH");

				int cmtCount = selectCountCmt(conn, no);

				ReviewBoardVo rvo = new ReviewBoardVo();
				rvo.setNo(no);
				rvo.setTitle(title);
				rvo.setViews(views);
				rvo.setWriteDate(writeDate);
				rvo.setWriterNo(writerNo);
				rvo.setOriginName(originName);
				rvo.setChangeName(changeName);
				rvo.setFilePath(filePath);
				rvo.setCmtCount(cmtCount);
				rvoList.add(rvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return rvoList;
	}

	// 후기게시판 댓글 갯수 조회
	public static int selectCountCmt(Connection conn, String bno) {
		String sql = "SELECT COUNT(*) AS CNT FROM REVIEW_BOARD_CMT WHERE REVIEW_BOARD_NO = ? AND DELETE_YN = 'N'";

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

	// 후기게시판 상세조회 (제목,내용)
	public static ReviewBoardVo detail(Connection conn, String bno) {
		String sql = "SELECT B.NO, B.TITLE ,B.CONTENT ,B.VIEWS, TO_CHAR(B.WRITE_DATE, 'yyyy-mm-dd') AS WRITE_DATE, TO_CHAR(B.MODIFY_DATE, 'yyyy-mm-dd') AS MODIFY_DATE, B.DELETE_YN, M.NICK AS WRITER_NO FROM REVIEW_BOARD B JOIN MEMBER M ON B.WRITER_NO = M.NO WHERE B.NO = ? AND B.DELETE_YN = 'N'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewBoardVo rvo = null;

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

				rvo = new ReviewBoardVo();
				rvo.setNo(no);
				rvo.setTitle(title);
				rvo.setContent(content);
				rvo.setViews(views);
				rvo.setWriteDate(writeDate);
				rvo.setModifyDate(modifyDate);
				rvo.setDeleteYn(deleteYn);
				rvo.setWriterNo(writerNo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return rvo;
	}

	// 후기게시판 상세조회 (업로드파일)
	public static List<ReviewBoardImgVo> selectAttachment(Connection conn, String bno) {

		String sql = "SELECT * FROM REVIEW_BOARD_IMG WHERE STATUS = 'O' AND REVIEW_BOARD_NO = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewBoardImgVo> imgList = new ArrayList<ReviewBoardImgVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bno);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String imgNo = rs.getString("IMG_NO");
				String reviewBoardNo = rs.getString("REVIEW_BOARD_NO");
				String originName = rs.getString("ORIGIN_NAME");
				String changeName = rs.getString("CHANGE_NAME");
				String filePath = rs.getString("FILE_PATH");
				String enrollDate = rs.getString("ENROLL_DATE");
				String thumbYn = rs.getString("THUMB_YN");
				String status = rs.getString("STATUS");

				ReviewBoardImgVo imgVo = new ReviewBoardImgVo();
				imgVo.setImgNo(imgNo);
				;
				imgVo.setReviewBoardNo(reviewBoardNo);
				imgVo.setOriginName(originName);
				imgVo.setChangeName(changeName);
				imgVo.setFilePath(filePath);
				imgVo.setEnrollDate(enrollDate);
				imgVo.setThumbYn(thumbYn);
				imgVo.setStatus(status);
				imgList.add(imgVo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return imgList;
	}

	// 후기게시판 댓글조회
	public static List<ReviewBoardCmtVo> selectCmt(Connection conn, PageVo cmtPv, String bno) {

		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM , T.* FROM (SELECT C.NO, C.REVIEW_BOARD_NO, C.CMT, M.NICK AS WRITER_NO, TO_CHAR(C.MODIFY_DATE, 'yyyy-mm-dd') AS MODIFY_DATE,C.DELETE_YN FROM REVIEW_BOARD_CMT C JOIN MEMBER M ON C.WRITER_NO = M.NO WHERE DELETE_YN = 'N' AND REVIEW_BOARD_NO = ? ORDER BY NO DESC) T) WHERE RNUM BETWEEN ? AND ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewBoardCmtVo> cmtList = new ArrayList<ReviewBoardCmtVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			int start = (cmtPv.getCurrentPage() - 1) * cmtPv.getBoardLimit() + 1;
			int end = start + cmtPv.getBoardLimit() - 1;

			pstmt.setString(1, bno);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("NO");
				String ReviewBoardNo = rs.getString("REVIEW_BOARD_NO");
				String cmt = rs.getString("CMT");
				String writerNo = rs.getString("WRITER_NO");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");

				ReviewBoardCmtVo cmtVo = new ReviewBoardCmtVo();
				cmtVo.setNo(no); // 댓글번호
				cmtVo.setReviewBoardNo(ReviewBoardNo); // 게시글번호
				cmtVo.setCmt(cmt); // 댓글내용
				cmtVo.setWriterNo(writerNo); // 작성자번호 닉네임으로 가져오기
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

	// 후기게시판 게시글 조회수 증가
	public static int increaseViews(Connection conn, String bno) {

		String sql = "UPDATE REVIEW_BOARD SET VIEWS = VIEWS + 1 WHERE NO = ? AND DELETE_YN = 'N'";

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

	// 후기게시판 게시글 작성
	public static int write(Connection conn, ReviewBoardVo rvo) {
		String sql = "INSERT INTO REVIEW_BOARD(NO, WRITER_NO, TITLE, CONTENT) VALUES(SEQ_REVIEW_BOARD_NO.NEXTVAL, ?, ?, ?)";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, rvo.getWriterNo());
			pstmt.setString(2, rvo.getTitle());
			pstmt.setString(3, rvo.getContent());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	// 후기게시판 썸네일 추가
	public int insertThumbImg(Connection conn, ReviewBoardImgVo imgVo) {

		// SQL 준비, 완성, 실행

		String sql = "INSERT INTO REVIEW_BOARD_IMG(IMG_NO ,REVIEW_BOARD_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMB_YN) VALUES( SEQ_REVIEW_BOARD_IMG_NO.NEXTVAL , SEQ_REVIEW_BOARD_NO.CURRVAL , ? , ? , ? , ?)";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, imgVo.getOriginName());
			pstmt.setString(2, imgVo.getChangeName());
			pstmt.setString(3, imgVo.getFilePath());
			pstmt.setString(4, "Y");

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	// 후기게시판 첨부파일 insert
	public static int insertImg(Connection conn, ReviewBoardImgVo imgVo) {
		// SQL 준비, 완성, 실행

		String sql = "INSERT INTO REVIEW_BOARD_IMG(IMG_NO ,REVIEW_BOARD_NO ,ORIGIN_NAME ,CHANGE_NAME ,FILE_PATH, THUMB_YN) VALUES( SEQ_REVIEW_BOARD_IMG_NO.NEXTVAL , SEQ_REVIEW_BOARD_NO.CURRVAL , ? , ? , ? , ?)";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, imgVo.getOriginName());
			pstmt.setString(2, imgVo.getChangeName());
			pstmt.setString(3, imgVo.getFilePath());
			pstmt.setString(4, "N");

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	// 후기게시판 게시글 수정
	public static int edit(Connection conn, ReviewBoardVo rvo) {
		String sql = "UPDATE REVIEW_BOARD SET TITLE = ?, CONTENT = ?, MODIFY_DATE = SYSDATE WHERE NO = ?";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rvo.getTitle());
			pstmt.setString(2, rvo.getContent());
			pstmt.setString(3, rvo.getNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	// 수정을 위한 이미지들 불러오기
	public List<Integer> selectImgNo(Connection conn, String no) {
		String sql = "SELECT * FROM REVIEW_BOARD_IMG WHERE REVIEW_BOARD_NO = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewBoardImgVo imgVo = new ReviewBoardImgVo();

		List<Integer> imgNoList = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, no);

			rs = pstmt.executeQuery();
			
			imgNoList = new ArrayList<Integer>();

			while (rs.next()) {

				int imgNo = rs.getInt("IMG_NO");
				imgNoList.add(imgNo);
				
//				String reviewBoardNo = rs.getString("REVIEW_BOARD_NO");
//				String originName = rs.getString("ORIGIN_NAME");
//				String changeName = rs.getString("CHANGE_NAME");
//				String filePath = rs.getString("FILE_PATH");
//				String enrollDate = rs.getString("ENROLL_DATE");
//				String thumbYn = rs.getString("THUMB_YN");
//				String status = rs.getString("STATUS");

				// ReviewBoardImgVo imgVo = new ReviewBoardImgVo();
//				imgVo.setImgNo(imgNo);
//				imgVo.setReviewBoardNo(reviewBoardNo);
//				imgVo.setOriginName(originName);
//				imgVo.setChangeName(changeName);
//				imgVo.setFilePath(filePath);
//				imgVo.setEnrollDate(enrollDate);
//				imgVo.setThumbYn(thumbYn);
//				imgVo.setStatus(status);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return imgNoList;
	}

	// 썸네일 수정
	public int editThumbImg(Connection conn, ReviewBoardImgVo imgVo, int imgNo) {
		String sql = "UPDATE REVIEW_BOARD_IMG SET ORIGIN_NAME=?, CHANGE_NAME=? ,FILE_PATH=?, THUMB_YN='Y' WHERE IMG_NO=?";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, imgVo.getOriginName());
			pstmt.setString(2, imgVo.getChangeName());
			pstmt.setString(3, imgVo.getFilePath());
			pstmt.setInt(4, imgNo);
			System.out.println(imgVo);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int editImg(Connection conn, ReviewBoardImgVo imgVo, int imgNo) {

		String sql = "UPDATE REVIEW_BOARD_IMG SET ORIGIN_NAME=?, CHANGE_NAME=? ,FILE_PATH=?, THUMB_YN='N' WHERE IMG_NO=?";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, imgVo.getOriginName());
			pstmt.setString(2, imgVo.getChangeName());
			pstmt.setString(3, imgVo.getFilePath());
			pstmt.setInt(4, imgNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	// 후기게시판 댓글 작성
	public static int writeCmt(Connection conn, ReviewBoardCmtVo cmtVo) {

		String sql = "INSERT INTO REVIEW_BOARD_CMT (NO, REVIEW_BOARD_NO, WRITER_NO, CMT) VALUES (SEQ_REVIEW_BOARD_CMT_NO.NEXTVAL, ?,  ?, ?)";

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cmtVo.getReviewBoardNo());
			pstmt.setString(2, cmtVo.getWriterNo());
			pstmt.setString(3, cmtVo.getCmt());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	// 댓글 삭제를 위한 리스트 조회
	public static ReviewBoardCmtVo cmtList(Connection conn, String cmtNo) {

		String sql = "SELECT C.NO, M.NICK AS WRITER_NO FROM REVIEW_BOARD_CMT C JOIN MEMBER M ON C.WRITER_NO = M.NO WHERE C.NO=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewBoardCmtVo cmtVo = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cmtNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("NO");
				String writerNo = rs.getString("WRITER_NO");

				cmtVo = new ReviewBoardCmtVo();
				cmtVo.setNo(no);
				cmtVo.setWriterNo(writerNo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return cmtVo;
	}

	// 댓글 삭제
	public static int cmtDelete(Connection conn, String cmtNo) {

		String sql = "UPDATE REVIEW_BOARD_CMT SET DELETE_YN = 'Y' WHERE NO = ?";
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cmtNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	public static int delete(Connection conn, String no) {

		String sql = "UPDATE REVIEW_BOARD SET DELETE_YN = 'Y' WHERE NO = ?";
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

}
