package com.kh.sseudam.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.member.vo.MemberVo;

public class MemberDao {

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
	
	public MemberVo selectOne(Connection conn, MemberVo vo) {
			
		String sql = "SELECT NO , ID , PWD , NAME , NICK , PHONE , EMAIL , TEST_SCORE , JOIN_DATE , QUIT_YN , MODIFY_DATE FROM MEMBER WHERE ID = ? AND PWD = ?";
		
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
				String testscore = rs.getString("TEST_SCORE");
				String joindate = rs.getString("JOIN_DATE");
				String quityn = rs.getString("QUIT_YN");
				String modifydate = rs.getString("MODIFY_DATE");
				
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
				loginMember.setQuitYn(quityn);
				loginMember.setModifyDate(modifydate);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return loginMember;
		
	}
	
}
























