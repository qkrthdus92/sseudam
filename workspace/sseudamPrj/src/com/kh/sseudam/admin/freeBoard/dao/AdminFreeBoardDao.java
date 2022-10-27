package com.kh.sseudam.admin.freeBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardVo;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class AdminFreeBoardDao {

	//모든게시글 카운트
	public int getCntFreeAll(Connection conn) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//게시완료 카운트
	public int getCntFreeF(Connection conn) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD WHERE DELETE_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//게시취소 카운트
	public int getCntFreeC(Connection conn) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD WHERE DELETE_YN = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//제목+모든 카운트
	public int getCntFreeTitleAll(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD WHERE TITLE LIKE ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//제목+완료 카운트
	public int getCntFreeTitleF(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD WHERE TITLE LIKE ? AND DELETE_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//제목+취소 카운트
	public int getCntFreeTitleC(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD WHERE TITLE LIKE ? AND DELETE_YN = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//내용+모든 카운트
	public int getCntFreeContentAll(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD WHERE CONTENT LIKE ? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//내용+완료 카운트
	public int getCntFreeContentF(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD WHERE CONTENT LIKE ? AND DELETE_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//내용+취소 카운트
	public int getCntFreeContentC(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD WHERE CONTENT LIKE ? AND DELETE_YN = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//작성자+모든 카운트
	public int getCntFreeWriterAll(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD F JOIN MEMBER M ON F.WRITER_NO = M.NO WHERE NICK LIKE ? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//작성자+완료 카운트
	public int getCntFreeWriterF(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD F JOIN MEMBER M ON F.WRITER_NO = M.NO WHERE NICK LIKE ? AND DELETE_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//작성자+취소 카운트
	public int getCntFreeWriterC(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM FREE_BOARD F JOIN MEMBER M ON F.WRITER_NO = M.NO WHERE NICK LIKE ? AND DELETE_YN = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}
	

	//게시글 번호로 댓글 수 얻기
	public String getCntCmtByNo(Connection conn, String no) {
		
		String sql = "SELECT COUNT(*) FROM FREE_BOARD_CMT WHERE DELETE_YN = 'N' AND FREE_BOARD_NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String cnt = "";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getString("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//모든 게시글 리스트 조회
	public List getFreeAll(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT F.NO, F.TITLE,F.CONTENT, M.NICK, F.WRITE_DATE, F.VIEWS, F.MODIFY_DATE, F.DELETE_YN FROM FREE_BOARD F JOIN MEMBER M ON F.WRITER_NO = M.NO ) T ) WHERE RNUM BETWEEN ? AND ?	";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AdminFreeBoardVo> list = new ArrayList<AdminFreeBoardVo>();
		
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String nick = rs.getString("NICK");
				String writeDate = rs.getString("WRITE_DATE");
				String views = rs.getString("VIEWS");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				String cmtCnt = getCntCmtByNo(conn, no);
				
				AdminFreeBoardVo vo = new AdminFreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setNick(nick);
				vo.setEnrollDate(writeDate);
				vo.setView(views);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				vo.setCmtCnt(cmtCnt);
				
				list.add(vo);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return list;
	}
	

	//게시완료 게시글 리스트 조회
	public List getFreeF(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT F.NO, F.TITLE,F.CONTENT, M.NICK, F.WRITE_DATE, F.VIEWS, F.MODIFY_DATE, F.DELETE_YN FROM FREE_BOARD F JOIN MEMBER M ON F.WRITER_NO = M.NO WHERE DELETE_YN = 'N') T ) WHERE RNUM BETWEEN ? AND ?	";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AdminFreeBoardVo> list = new ArrayList<AdminFreeBoardVo>();
		
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String nick = rs.getString("NICK");
				String writeDate = rs.getString("WRITE_DATE");
				String views = rs.getString("VIEWS");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				String cmtCnt = getCntCmtByNo(conn, no);
				
				AdminFreeBoardVo vo = new AdminFreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setNick(nick);
				vo.setEnrollDate(writeDate);
				vo.setView(views);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				vo.setCmtCnt(cmtCnt);
				
				list.add(vo);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return list;
	}

	public List getFreeC(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT F.NO, F.TITLE,F.CONTENT, M.NICK, F.WRITE_DATE, F.VIEWS, F.MODIFY_DATE, F.DELETE_YN FROM FREE_BOARD F JOIN MEMBER M ON F.WRITER_NO = M.NO WHERE DELETE_YN = 'Y') T ) WHERE RNUM BETWEEN ? AND ?	";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AdminFreeBoardVo> list = new ArrayList<AdminFreeBoardVo>();
		
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String nick = rs.getString("NICK");
				String writeDate = rs.getString("WRITE_DATE");
				String views = rs.getString("VIEWS");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				String cmtCnt = getCntCmtByNo(conn, no);
				
				AdminFreeBoardVo vo = new AdminFreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setNick(nick);
				vo.setEnrollDate(writeDate);
				vo.setView(views);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				vo.setCmtCnt(cmtCnt);
				
				list.add(vo);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return list;
	}

	//제목+모든 게시글 조회
	public List getFreeTitleAll(Connection conn, PageVo pv, String search) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT F.NO, F.TITLE,F.CONTENT, M.NICK, F.WRITE_DATE, F.VIEWS, F.MODIFY_DATE, F.DELETE_YN FROM FREE_BOARD F JOIN MEMBER M ON F.WRITER_NO = M.NO WHERE F.TITLE LIKE ?) T ) WHERE RNUM BETWEEN ? AND ?	";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AdminFreeBoardVo> list = new ArrayList<AdminFreeBoardVo>();
		
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String nick = rs.getString("NICK");
				String writeDate = rs.getString("WRITE_DATE");
				String views = rs.getString("VIEWS");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				String cmtCnt = getCntCmtByNo(conn, no);
				
				AdminFreeBoardVo vo = new AdminFreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setNick(nick);
				vo.setEnrollDate(writeDate);
				vo.setView(views);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				vo.setCmtCnt(cmtCnt);
				
				list.add(vo);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return list;
	}

	//제목+완료 게시글 조회
	public List getFreeTitleF(Connection conn, PageVo pv, String search) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT F.NO, F.TITLE,F.CONTENT, M.NICK, F.WRITE_DATE, F.VIEWS, F.MODIFY_DATE, F.DELETE_YN FROM FREE_BOARD F JOIN MEMBER M ON F.WRITER_NO = M.NO WHERE F.TITLE LIKE ? AND DELETE_YN = 'N') T ) WHERE RNUM BETWEEN ? AND ?	";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AdminFreeBoardVo> list = new ArrayList<AdminFreeBoardVo>();
		
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String nick = rs.getString("NICK");
				String writeDate = rs.getString("WRITE_DATE");
				String views = rs.getString("VIEWS");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				String cmtCnt = getCntCmtByNo(conn, no);
				
				AdminFreeBoardVo vo = new AdminFreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setNick(nick);
				vo.setEnrollDate(writeDate);
				vo.setView(views);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				vo.setCmtCnt(cmtCnt);
				
				list.add(vo);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return list;
	}

	//제목+취소 게시글 조회
	public List getFreeTitleC(Connection conn, PageVo pv, String search) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT F.NO, F.TITLE,F.CONTENT, M.NICK, F.WRITE_DATE, F.VIEWS, F.MODIFY_DATE, F.DELETE_YN FROM FREE_BOARD F JOIN MEMBER M ON F.WRITER_NO = M.NO WHERE F.TITLE LIKE ? AND DELETE_YN = 'Y') T ) WHERE RNUM BETWEEN ? AND ?	";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AdminFreeBoardVo> list = new ArrayList<AdminFreeBoardVo>();
		
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String nick = rs.getString("NICK");
				String writeDate = rs.getString("WRITE_DATE");
				String views = rs.getString("VIEWS");
				String modifyDate = rs.getString("MODIFY_DATE");
				String deleteYn = rs.getString("DELETE_YN");
				
				String cmtCnt = getCntCmtByNo(conn, no);
				
				AdminFreeBoardVo vo = new AdminFreeBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setNick(nick);
				vo.setEnrollDate(writeDate);
				vo.setView(views);
				vo.setModifyDate(modifyDate);
				vo.setDeleteYn(deleteYn);
				vo.setCmtCnt(cmtCnt);
				
				list.add(vo);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return list;
	}

}
