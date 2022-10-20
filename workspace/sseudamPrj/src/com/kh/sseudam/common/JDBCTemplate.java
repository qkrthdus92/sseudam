package com.kh.sseudam.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			
			//프로퍼티즈 파일 읽기
			Properties prop = new Properties(); //Map 계열 컬렉션
			
			//프로젝트의 최상단 경로 얻어오기
			String filePath = JDBCTemplate.class.getResource("/db/info.properties").getPath();
			
			prop.load(new FileInputStream(filePath));
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[ERROR] getConnection 중 에러발생");
		}
		
		return conn;
	}
	
	//commit
		public static void commit(Connection conn) {
			try {
				if(conn!=null && !conn.isClosed())conn.commit();
			} catch (SQLException e) {
				System.out.println("[ERROR] JDBCTemplate");
				e.printStackTrace();
			}
		}
		
		//rollback
		public static void rollback(Connection conn) {
			try {
				if(conn!=null && !conn.isClosed())conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//close : conn, stmt, rs
		public static void close(Connection conn) {
			try {
				if(conn!=null && !conn.isClosed())conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void close(Statement stmt) {
			try {
				if(stmt!=null && !stmt.isClosed())stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void close(ResultSet rs) {
			try {
				if(rs!=null && !rs.isClosed())rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

}
