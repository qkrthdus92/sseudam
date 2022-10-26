package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageCommentVo;
import com.kh.sseudam.mypage.board.vo.MypageCommentVo2;

public class MypageCommentDao {

	public static List<MypageCommentVo> selectList(String num, Connection conn,PageVo pv) {
		
		String sql ="SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM(SELECT NO, FREE_BOARD_NO, WRITER_NO, CMT, CMT_DATE, DELETE_YN, MODIFY_DATE , '자유게시판' \"게시판\" FROM FREE_BOARD_CMT WHERE WRITER_NO =? UNION SELECT NO, REVIEW_BOARD_NO, WRITER_NO, CMT, CMT_DATE, DELETE_YN, MODIFY_DATE,'후기게시판' \"게시판\"FROM REVIEW_BOARD_CMT WHERE WRITER_NO =?)T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageCommentVo> voList = new ArrayList<MypageCommentVo>();

		
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
				String board_no = rs.getString("FREE_BOARD_NO"); 
				String writer_no = rs.getString("WRITER_NO"); 
				String cmt = rs.getString("CMT"); 
				String cmt_date = rs.getString("CMT_DATE"); 
				String delete_yn = rs.getString("DELETE_YN"); 
				String modify_date = rs.getString("MODIFY_DATE"); 
				String type = rs.getString("게시판");
				
				if(type.equals("자유게시판")) {
					MypageCommentVo vo = new MypageCommentVo();
					vo.setNo(no);
					vo.setFree_board_no(board_no);
					vo.setWriter_no(writer_no);
					vo.setCmt(cmt);
					vo.setCmt_date(cmt_date);
					vo.setDelete_yn(delete_yn);
					vo.setModify_date(modify_date);
					vo.setType(type);
					
					voList.add(vo);
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return voList;
	}

	public static List<MypageCommentVo2> selectList2(String num, Connection conn,PageVo pv) {
	
String sql ="SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM(SELECT NO, FREE_BOARD_NO, WRITER_NO, CMT, CMT_DATE, DELETE_YN, MODIFY_DATE , '자유게시판' \"게시판\" FROM FREE_BOARD_CMT WHERE WRITER_NO =? UNION SELECT NO, REVIEW_BOARD_NO, WRITER_NO, CMT, CMT_DATE, DELETE_YN, MODIFY_DATE,'후기게시판' \"게시판\"FROM REVIEW_BOARD_CMT WHERE WRITER_NO =?)T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageCommentVo2> voList = new ArrayList<MypageCommentVo2>();

		
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
				String board_no = rs.getString("FREE_BOARD_NO"); 
				String writer_no = rs.getString("WRITER_NO"); 
				String cmt = rs.getString("CMT"); 
				String cmt_date = rs.getString("CMT_DATE"); 
				String delete_yn = rs.getString("DELETE_YN"); 
				String modify_date = rs.getString("MODIFY_DATE"); 
				String type = rs.getString("게시판");
				
				if(type.equals("후기게시판")) {
					MypageCommentVo2 vo = new MypageCommentVo2();
					vo.setNo(no);
					vo.setFree_board_no(board_no);
					vo.setWriter_no(writer_no);
					vo.setCmt(cmt);
					vo.setCmt_date(cmt_date);
					vo.setDelete_yn(delete_yn);
					vo.setModify_date(modify_date);
					vo.setType(type);
					
					voList.add(vo);
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return voList;
	}

	public static int selectCount(Connection conn, String num) {
		
		String sql="SELECT COUNT(*) AS CNT FROM (SELECT NO, FREE_BOARD_NO, WRITER_NO, CMT, CMT_DATE, DELETE_YN, MODIFY_DATE , '자유게시판' \"게시판\" FROM FREE_BOARD_CMT WHERE WRITER_NO =? UNION SELECT NO, REVIEW_BOARD_NO, WRITER_NO, CMT, CMT_DATE, DELETE_YN, MODIFY_DATE,'후기게시판' \"게시판\"FROM REVIEW_BOARD_CMT WHERE WRITER_NO =?)";
		
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
