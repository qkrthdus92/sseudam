package com.kh.sseudam.stress.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.common.JDBCTemplate;

import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.stress.vo.StressVo;

public class StressDao {

	// 테스트점수 회원정보 저장
	public int myScore(Connection conn, MemberVo vo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "UPDATE MEMBER SET TEST_SCORE = ? WHERE NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getTestScore());
			pstmt.setString(2, vo.getNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 테스트점수에 따라 컨텐츠 추천
	public static List<StressVo> suggestContent(Connection conn, int testScore) {

		String sql = "SELECT C_NUM, TITLE, STRESS, IMG_PATH, LINK, MODIFY_DATE FROM OUTSIDE WHERE STRESS BETWEEN (?-2) AND (?+2) UNION SELECT  C_NUM, TITLE, STRESS, IMG_PATH, LINK, MODIFY_DATE FROM INSIDE WHERE STRESS BETWEEN (?-2) AND (?+2) ORDER  BY STRESS DESC";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StressVo> suggestList = new ArrayList<StressVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, testScore);
			pstmt.setInt(2, testScore);
			pstmt.setInt(3, testScore);
			pstmt.setInt(4, testScore);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String cNum = rs.getString("C_NUM");
				String title = rs.getString("TITLE");
				int stress = rs.getInt("STRESS");
				String imgPath = rs.getString("IMG_PATH");
				String link = rs.getString("LINK");
				String modifyDate = rs.getString("MODIFY_DATE");

				StressVo suggest = new StressVo();
				suggest.setcNum(cNum);
				suggest.setTitle(title);
				suggest.setStress(stress);
				suggest.setImgPath(imgPath);
				suggest.setLink(link);
				suggest.setModifyDate(modifyDate);
				suggestList.add(suggest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return suggestList;

	}

	
	
	
	
	
	
	
	
}//dao
