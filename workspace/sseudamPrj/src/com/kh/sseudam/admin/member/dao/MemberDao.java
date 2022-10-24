package com.kh.sseudam.admin.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.member.vo.MemberVo;

public class MemberDao {

	public int selectCntAll(Connection conn) {
		String sql = "SELECT COUNT(*) FROM MEMBER";
		
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

	public List selectListAll(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM MEMBER ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> memberList = new ArrayList<MemberVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String nick = rs.getString("NICK");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String testScore = rs.getString("TEST_SCORE");
				String joinDate = rs.getString("JOIN_DATE");
				String quitYn = rs.getString("QUIT_YN");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				MemberVo vo = new MemberVo();
				vo.setNo(no);
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setNick(nick);
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setTestScore(testScore);
				vo.setJoinDate(joinDate);
				vo.setQuitYn(quitYn);
				vo.setModifyDate(modifyDate);
				
				memberList.add(vo);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return memberList;
	}

}
