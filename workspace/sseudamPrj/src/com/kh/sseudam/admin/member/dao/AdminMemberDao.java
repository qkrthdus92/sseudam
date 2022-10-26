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

public class AdminMemberDao {
	

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
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM MEMBER ORDER BY NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		
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
				int testScore = rs.getInt("TEST_SCORE");
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

	public int selectCntN(Connection conn) {
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE QUIT_YN = 'N'";
		
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

	public int selectCntY(Connection conn) {
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE QUIT_YN = 'Y'";
		
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

	public List selectListN(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM MEMBER WHERE QUIT_YN = 'N' ORDER BY NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		
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
				int testScore = rs.getInt("TEST_SCORE");
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

	public List selectListY(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM MEMBER WHERE QUIT_YN = 'Y' ORDER BY NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		
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
				int testScore = rs.getInt("TEST_SCORE");
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

	public int selectCntSearch(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM MEMBER WHERE NAME LIKE ? OR ID LIKE ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setString(2, "%"+search+"%");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return cnt;
	}

	public List selectListSearch(Connection conn, PageVo pv, String search) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM MEMBER WHERE NAME LIKE ? OR ID LIKE ? ORDER BY NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		List<MemberVo> memberList = new ArrayList<MemberVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setString(2, "%"+search+"%");
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String nick = rs.getString("NICK");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				int testScore = rs.getInt("TEST_SCORE");
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

	public MemberVo selectOneByNo(Connection conn, String mno) {
		String sql = "SELECT * FROM MEMBER WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
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
				String quitYn = rs.getString("QUIT_YN");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				vo = new MemberVo();
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return vo;
	}

	public int updateMember(Connection conn, MemberVo vo) {
		String sql = "UPDATE MEMBER SET ID=?, PWD=?, NAME=?, NICK=?, PHONE=?, EMAIL=?, TEST_SCORE=?,MODIFY_DATE=SYSDATE WHERE NO=?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNick());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getEmail());
			pstmt.setInt(7, vo.getTestScore());
			pstmt.setString(8, vo.getNo());
			System.out.println("here2");
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertOne(Connection conn, MemberVo vo) {
		String sql = "INSERT INTO MEMBER (NO, ID, PWD, NAME, EMAIL, PHONE, NICK) VALUES (SEQ_MEMBER_NO.NEXTVAL,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getNick());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public boolean checkDup(Connection conn, String id) {
		String sql = "SELECT * FROM MEMBER WHERE ID = ?  AND QUIT_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isIdDup = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isIdDup = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return isIdDup;
	}

	public boolean checkNotChange(Connection conn, String no, String id) {
		String sql = "SELECT * FROM MEMBER WHERE NO = ? AND ID = ? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isNotChange = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isNotChange = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return isNotChange;
	}

	public boolean checkNotChangeNick(Connection conn, String no, String nick) {
		String sql = "SELECT * FROM MEMBER WHERE NO = ? AND NICK = ? ";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isNotChangeNick = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, nick);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isNotChangeNick = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return isNotChangeNick;
	}

	public boolean checkDupNick(Connection conn, String nick) {
		String sql = "SELECT * FROM MEMBER WHERE NICK = ?  AND QUIT_YN = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isIdDupNick = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isIdDupNick = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return isIdDupNick;
	}

	public int quitOne(Connection conn, String mno) {
		String sql = "UPDATE MEMBER SET QUIT_YN ='Y' WHERE NO = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
