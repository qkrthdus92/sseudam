package com.kh.sseudam.counsel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.counsel.pro.vo.ProVo;

public class CounselDao {

	//상담하기 : 전문가 목록 조회
	public List<ProVo> selectList(Connection conn) {
		
		String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String counselType = rs.getString("COUNSEL_TYPE");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String proStatus = rs.getString("PRO_STATUS");
				String img = rs.getString("IMG");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String introduce = rs.getString("INTRODUCE");
				
				ProVo proVo = new ProVo();
				proVo.setNo(no);
				proVo.setCounselType(counselType);
				proVo.setId(id);
				proVo.setPwd(pwd);
				proVo.setName(name);
				proVo.setGender(gender);
				proVo.setPhone(phone);
				proVo.setEmail(email);
				proVo.setEducation(education);
				proVo.setPrice(price);
				proVo.setProStatus(proStatus);
				proVo.setImg(img);
				proVo.setJoinDate(joinDate);
				proVo.setModifyDate(modifyDate);
				proVo.setIntroduce(introduce);
				
				//평균별점 set하기
				String avgStar = getAvgStar(conn, no);
				if(avgStar.equals("10")) {
					avgStar = "평점없음";
				}
				proVo.setAvgStar(avgStar);
				
				//상담횟수 set하기
				String counselCnt = getCounselCnt(conn, no);
				proVo.setCounselCnt(counselCnt);
				
				proList.add(proVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return proList;
	}
	
	//평균별점 구하기
	public String getAvgStar(Connection conn, String no) {
		
		String sql = "SELECT M.NO, NVL(AVG(A.STAR),10) AVG_STAR FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' AND M.NO = ? GROUP BY M.NO";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String avgStar = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				avgStar = rs.getString("AVG_STAR");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return avgStar;
	}
	
	//상담횟수 구하기
	public String getCounselCnt(Connection conn, String no) {
		
		String sql = "SELECT NO PRO_NO, SUM(CNT) COUNSEL_CNT FROM ( SELECT M.NO, 0 CNT FROM PRO_MEMBER M LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' GROUP BY M.NO UNION ALL SELECT M.NO, COUNT(A.PRO_NO) CNT FROM PRO_MEMBER M LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' AND A.ADVICE_DATE < SYSDATE GROUP BY M.NO ) WHERE NO = ? GROUP BY NO";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String counselCnt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				counselCnt = rs.getString("COUNSEL_CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return counselCnt;
		
	}

}
