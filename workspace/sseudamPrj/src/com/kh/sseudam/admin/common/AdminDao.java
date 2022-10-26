package com.kh.sseudam.admin.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.sseudam.common.JDBCTemplate;

public class AdminDao {

	public AdminVo login(Connection conn, AdminVo vo) {
		String sql = "SELECT * FROM ADMIN WHERE ID = ? AND PWD = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminVo loginAdmin = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				
				loginAdmin = new AdminVo();
				loginAdmin.setNo(no);
				loginAdmin.setId(id);
				loginAdmin.setPwd(pwd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return loginAdmin;
	}

}
