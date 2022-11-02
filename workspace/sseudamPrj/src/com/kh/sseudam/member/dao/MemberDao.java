package com.kh.sseudam.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.member.vo.MemberVo;

public class MemberDao {

	Connection conn = null;
	
	//회원가입
	public int insertOne(Connection conn, MemberVo vo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO MEMBER ( NO , ID , PWD , NAME , NICK , PHONE , EMAIL ) VALUES ( SEQ_MEMBER_NO.NEXTVAL , ? , ? , ? , ? , ? , ? )";
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNick());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}
	
	//일반회원 로그인
	public MemberVo selectOne(Connection conn, MemberVo vo) {
			
		String sql = "SELECT NO , ID , PWD , NAME , NICK , PHONE , EMAIL , TEST_SCORE , JOIN_DATE , QUIT_YN , MODIFY_DATE FROM MEMBER WHERE ID = ? AND PWD = ? AND QUIT_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMember = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String nick = rs.getString("NICK");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				int testScore = rs.getInt("TEST_SCORE");
				String joinDate = rs.getString("JOIN_DATE");
				String quiYyn = rs.getString("QUIT_YN");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				loginMember = new MemberVo();
				loginMember.setNo(no);
				loginMember.setId(id);
				loginMember.setPwd(pwd);
				loginMember.setName(name);
				loginMember.setNick(nick);
				loginMember.setPhone(phone);
				loginMember.setEmail(email);
				loginMember.setTestScore(testScore);
				loginMember.setJoinDate(joinDate);
				loginMember.setQuitYn(quiYyn);
				loginMember.setModifyDate(modifyDate);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return loginMember;
	}
	
	//아이디 중복체크 
	public boolean checkDup(Connection conn, String checkId) {
		String sql = "SELECT ID FROM MEMBER WHERE ID = ? UNION SELECT ID FROM PRO_MEMBER WHERE ID = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isIdDup = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			pstmt.setString(2, checkId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isIdDup = true; //중복
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return isIdDup;
		
	}

	//아이디 찾기
	public String findMemberId(Connection conn, MemberVo findvo) {
		
		String sql = "SELECT ID FROM MEMBER WHERE NAME = ? AND EMAIL = ? AND QUIT_YN = 'N' UNION SELECT ID FROM PRO_MEMBER WHERE NAME = ? AND EMAIL = ? AND PRO_STATUS != 'Q'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String foundId = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, findvo.getName());
			pstmt.setString(2, findvo.getEmail());
			pstmt.setString(3, findvo.getName());
			pstmt.setString(4, findvo.getEmail());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				foundId = rs.getString("id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return foundId;
		
	}

	//비밀번호 찾기
	public String findMemberPwd(Connection conn, MemberVo findpwdvo) {
		
		String sql = "SELECT PWD FROM MEMBER WHERE NAME = ? AND ID = ? AND EMAIL = ? AND QUIT_YN = 'N' UNION SELECT PWD FROM PRO_MEMBER WHERE NAME = ? AND ID = ? AND EMAIL = ? AND PRO_STATUS != 'Q'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String foundPwd = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, findpwdvo.getName());
			pstmt.setString(2, findpwdvo.getId());
			pstmt.setString(3, findpwdvo.getEmail());
			pstmt.setString(4, findpwdvo.getName());
			pstmt.setString(5, findpwdvo.getId());
			pstmt.setString(6, findpwdvo.getEmail());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				foundPwd = rs.getString("pwd");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return foundPwd;
	}
}























