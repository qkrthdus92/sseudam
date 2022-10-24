package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageBoardVo;

public class MypageBoardDao {

	public static List<MypageBoardVo> selectList(String num, Connection conn) {
		
		String sql = "SELECT NO, WRITER_NO, TITLE, CONTENT, WRITE_DATE, DELETE_YN, MODIFY_DATE, VIEWS, '자유게시판' \"게시판\" FROM FREE_BOARD WHERE WRITER_NO =? UNION SELECT NO, WRITER_NO, TITLE, CONTENT, WRITE_DATE, DELETE_YN, MODIFY_DATE, VIEWS, '후기게시판' \"게시판\" FROM REVIEW_BOARD WHERE WRITER_NO =?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageBoardVo> voList = new ArrayList<MypageBoardVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			pstmt.setString(2, num);
			
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

}
