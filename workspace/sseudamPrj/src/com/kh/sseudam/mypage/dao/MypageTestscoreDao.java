package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageLikehomeVo;
import com.kh.sseudam.mypage.board.vo.MypageTestscoreVo;

public class MypageTestscoreDao {

	public static List<MypageTestscoreVo> selectList(String num, Connection conn) {
	
		String sql="SELECT TEST_SCORE FROM MEMBER WHERE NO=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageTestscoreVo> voList = new ArrayList<MypageTestscoreVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String test_score = rs.getString("TEST_SCORE");
				
				MypageTestscoreVo vo= new MypageTestscoreVo();
				vo.setTest_score(test_score);
				
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
