package com.kh.sseudam.stress.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.sseudam.common.JDBCTemplate;

import temp.MemberVo;

public class StressDao {

	//테스트점수 회원정보 저장
		public int myScore(Connection conn, MemberVo vo) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String sql = "UPDATE MEMBER SET TEST_SCORE = ? WHERE ID = 'bk5991'";
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, vo.getTestScore());
				//pstmt.setString(2, vo.getId());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
		}
}
