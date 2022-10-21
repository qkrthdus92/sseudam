package com.kh.sseudam.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.member.vo.MemberVo;

public class MemberDao {

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
	
}
