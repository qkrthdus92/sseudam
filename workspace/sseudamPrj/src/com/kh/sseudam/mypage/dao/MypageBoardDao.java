package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageBoardVo;

public class MypageBoardDao {

	public static List<MypageBoardVo> selectList(String num, Connection conn, PageVo pv) {
		
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM(SELECT NO, WRITER_NO, TITLE, CONTENT, WRITE_DATE, DELETE_YN, MODIFY_DATE, VIEWS, '자유게시판' \"게시판\" FROM FREE_BOARD WHERE WRITER_NO =? UNION SELECT NO, WRITER_NO, TITLE, CONTENT, WRITE_DATE, DELETE_YN, MODIFY_DATE, VIEWS, '후기게시판' \"게시판\" FROM REVIEW_BOARD WHERE WRITER_NO =?)T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageBoardVo> voList = new ArrayList<MypageBoardVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1 ;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setString(1, num);
			pstmt.setString(2, num);
			pstmt.setInt(3,start);
			pstmt.setInt(4, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String writer_no = rs.getString("WRITER_NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String write_date = rs.getString("WRITE_DATE");
				String delete_yn = rs.getString("DELETE_YN");
				String modify_date = rs.getString("MODIFY_DATE");
				String views = rs.getString("VIEWS");
				String type = rs.getString("게시판");
				
				MypageBoardVo vo = new MypageBoardVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriteNo(writer_no);
				vo.setDeleteYn(delete_yn);
				vo.setModifyDate(modify_date);
				vo.setWriteDate(write_date);
				vo.setViews(views);
				vo.setType(type);
				
				voList.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return voList;
	}

	//게시글 갯수 조회
	public static int selectCount(Connection conn, String num) {
	
		String sql="SELECT COUNT(*) AS CNT FROM (SELECT NO, WRITER_NO, TITLE, CONTENT, WRITE_DATE, DELETE_YN, MODIFY_DATE, VIEWS, '자유게시판' \"게시판\" FROM FREE_BOARD WHERE WRITER_NO =? UNION SELECT NO, WRITER_NO, TITLE, CONTENT, WRITE_DATE, DELETE_YN, MODIFY_DATE, VIEWS, '후기게시판' \"게시판\" FROM REVIEW_BOARD WHERE WRITER_NO =?)";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			pstmt.setString(2, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("CNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

}
