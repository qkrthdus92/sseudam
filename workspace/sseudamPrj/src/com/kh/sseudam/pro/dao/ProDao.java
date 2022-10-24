package com.kh.sseudam.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.pro.join.vo.ProJoinPage1Vo;
import com.kh.sseudam.pro.join.vo.ProJoinPage2Vo;
import com.kh.sseudam.pro.join.vo.ProJoinPage3Vo;

public class ProDao {

	public int proInsertOne(Connection conn, ProJoinPage1Vo page1vo, ProJoinPage2Vo page2vo, ProJoinPage3Vo page3vo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO PRO_MEMBER (NO, ID, NAME, PWD, GENDER, PHONE, EMAIL, EDUCATION, COUNSEL_TYPE_NO) VALUES ( SEQ_PRO_MEMBER_NO.NEXTVAL, ? , ? , ? , ? , ? , ? , ? , ? )";
		
		try {
			//전문가 정보
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, page1vo.getId());
			pstmt.setString(2, page1vo.getName());
			pstmt.setString(3, page1vo.getPwd());
			pstmt.setString(4, page1vo.getGender());
			pstmt.setString(5, page1vo.getPhone());
			pstmt.setString(6, page1vo.getEmail());
			pstmt.setString(7, page2vo.getEducation());
			pstmt.setString(8, page3vo.getCounselType());
			
			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int projoinlicense(Connection conn, ProJoinPage2Vo page2vo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String prosql = "INSERT INTO CERTIFICATE VALUES ( SEQ_CERTIFICATE_NO.NEXTVAL , (SELECT NO FROM PRO_MEMBER ORDER BY NO DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY) , ? , ? , ? )";
		
		try {
			
			//전문가 자격정보
			pstmt = conn.prepareStatement(prosql);
			
			pstmt.setString(1, page2vo.getCertificateName());
			pstmt.setString(2, page2vo.getCertificateNum());
			pstmt.setString(3, page2vo.getImgPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
}
