package com.kh.sseudam.admin.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.vo.MemberVo;

public class AdminProDao {

	//모든전문가수 카운드
	public int selectCntAll(Connection conn) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//모든전문가 조회
	public List selectListAll(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM PRO_MEMBER P JOIN COUNSEL_TYPE C ON P.COUNSEL_TYPE_NO = C.NO ORDER BY P.NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String id = rs.getString("ID");
				String counselType = rs.getString("CLASS");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String status = rs.getString("STATUS");
			
				
				ProVo vo = new ProVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setGender(gender);
				vo.setId(id);
				vo.setCounselType(counselType);
				vo.setEmail(email);
				vo.setPhone(phone);
				vo.setEducation(education);
				vo.setPrice(price);
				vo.setProStatus(status);
				
				proList.add(vo);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return proList;
	}

	//승인대기 전문가수 카운트
	public int selectCntW(Connection conn) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER WHERE STATUS = 'W'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//승인완료 전문가수 카운트
	public int selectCntJ(Connection conn) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER WHERE STATUS = 'J'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//탈퇴전문가수 카운트
	public int selectCntQ(Connection conn) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER WHERE STATUS = 'Q'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

	//승인대기 전문가 목록 조회
	public List selectListW(Connection conn, PageVo pv) {
	String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM PRO_MEMBER P JOIN COUNSEL_TYPE C ON P.COUNSEL_TYPE_NO = C.NO WHERE P.PRO_STATUS = 'W' ORDER BY P.NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String id = rs.getString("ID");
				String counselType = rs.getString("CLASS");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String status = rs.getString("STATUS");
			
				
				ProVo vo = new ProVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setGender(gender);
				vo.setId(id);
				vo.setCounselType(counselType);
				vo.setEmail(email);
				vo.setPhone(phone);
				vo.setEducation(education);
				vo.setPrice(price);
				vo.setProStatus(status);
				
				proList.add(vo);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return proList;
	}

}
