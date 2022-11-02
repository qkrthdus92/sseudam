package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.mypage.board.vo.MypageAllreserVo;
import com.kh.sseudam.mypage.board.vo.MypageFinreserVo;
import com.kh.sseudam.pro.vo.ProMemberJoinVo;

public class MypageEditDao {

	//일반회원 정보수정
	public int updateOneByNo(Connection conn, MemberVo vo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET PWD = ? , NICK = ? , PHONE = ? , EMAIL = ? WHERE NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getNick());
			pstmt.setString(3, vo.getPhone());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	//일반회원 조회
	public MemberVo selectOne(Connection conn, MemberVo vo) {
		
		String sql = "SELECT NO ,ID ,PWD ,NAME,NICK ,PHONE ,EMAIL ,TEST_SCORE,JOIN_DATE ,QUIT_YN ,MODIFY_DATE FROM MEMBER WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMember = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String no = rs.getString("NO");
				String nick = rs.getString("NICK");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				int testscore = rs.getInt("TEST_SCORE");
				String joindate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String quityn = rs.getString("QUIT_YN");
				
				loginMember = new MemberVo();
				loginMember.setNo(no);
				loginMember.setId(id);
				loginMember.setPwd(pwd);
				loginMember.setName(name);
				loginMember.setNick(nick);
				loginMember.setPhone(phone);
				loginMember.setEmail(email);
				loginMember.setTestScore(testscore);
				loginMember.setJoinDate(joindate);
				loginMember.setModifyDate(modifyDate);
				loginMember.setQuitYn(quityn);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return loginMember;
		
	}

	//프로회원 정보수정
	public int proUpdateOneByNo(Connection conn, ProMemberJoinVo vo) {
		
		System.out.println("전문가 마이페이지 수정dao로 넘어옴"); //출력됨
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE PRO_MEMBER SET PWD =? , PHONE = ? , EMAIL = ?, INTRODUCE = ?, IMG=?  WHERE NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getIntroduce());
			pstmt.setString(5, vo.getImg());
			pstmt.setString(6, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		System.out.println(result);//출력됨 1
		return result;
		
	}
	
	//프로회원정보조회
	public ProMemberJoinVo proSelectOne(Connection conn, ProMemberJoinVo vo) {
		
		String sql = "SELECT NO ,COUNSEL_TYPE_NO,ID ,PWD ,NAME ,GENDER,PHONE ,EMAIL ,EDUCATION,PRICE,PRO_STATUS,IMG,JOIN_DATE ,INTRODUCE ,MODIFY_DATE FROM PRO_MEMBER WHERE ID = ? AND PWD = ? AND NOT PRO_STATUS = 'Q'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProMemberJoinVo loginMember = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String counsel_type_no = rs.getString("COUNSEL_TYPE_NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String pro_status = rs.getString("PRO_STATUS");
				String img = rs.getString("IMG");
				String joindate = rs.getString("JOIN_DATE");
				String introduce = rs.getString("INTRODUCE");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				
				
				loginMember = new ProMemberJoinVo();
				loginMember.setNo(no);
				loginMember.setCounselTypeNo(counsel_type_no);
				loginMember.setId(id);
				loginMember.setPwd(pwd);
				loginMember.setName(name);
				loginMember.setGender(gender);
				loginMember.setPhone(phone);
				loginMember.setEmail(email);
				loginMember.setEducation(education);
				loginMember.setPrice(price);
				loginMember.setProStatus(pro_status);
				loginMember.setImg(img);
				loginMember.setJoinDate(joindate);
				loginMember.setIntroduce(introduce);
				loginMember.setModifyDate(modifyDate);
				
				System.out.println(loginMember);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	}
	
	return loginMember;
		
	}

	//전문가 별점 평균 조회
	public static String proUpdateStar(Connection conn, String num) {
		System.out.println("평균 별점 조회 dao 넘어옴");
		
		String sql="SELECT AVG(STAR) AS STAR FROM PRO_APPOINT WHERE PRO_NO=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("STAR");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		System.out.println(result);//확인용
		
		return result;
		
	}
//일반회원 탈퇴
	public int quit(Connection conn, String no) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET QUIT_YN ='Y' WHERE NO = ?";
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int proquit(Connection conn, String no) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET QUIT_YN ='Y' WHERE NO = ?";
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	/*
	 * public static int imgUpdate(Connection conn,ProMemberJoinVo vo) {
	 * 
	 * PreparedStatement pstmt = null; int result = 0;
	 * 
	 * String sql="UPDATE PRO_MEMBER SET IMG ='?' WHERE NO =?"; try { pstmt =
	 * conn.prepareStatement(sql);
	 * 
	 * pstmt.setString(1, vo.getImg()); pstmt.setString(2, vo.getNo());
	 * 
	 * result = pstmt.executeUpdate();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } finally {
	 * JDBCTemplate.close(pstmt); }
	 * 
	 * return result;
	 * 
	 * }
	 */


	
	
	
}//class
