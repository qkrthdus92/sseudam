package com.kh.sseudam.admin.common;

import java.sql.Connection;

import com.kh.sseudam.common.JDBCTemplate;

public class AdminService {

	public AdminVo login(AdminVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		AdminVo loginAdmin = new AdminDao().login(conn, vo);
		
		JDBCTemplate.close(conn);
		
		return loginAdmin;
	}

}
