package com.kh.sseudam.admin.counselPay.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.admin.counselPay.vo.CounselPayVo;
import com.kh.sseudam.admin.counselPay.vo.SearchVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;

public class AdminCounselPayDao {

	public int getCntCounselAll(Connection conn, SearchVo vo) {
		String sql = "SELECT COUNT(P.NO) FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStartDate());
			pstmt.setString(2, vo.getEndDate()+" 23:59:59");
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

	public int getCntCounselF(Connection conn, SearchVo vo) {
		String sql = "SELECT COUNT(P.NO) FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE < SYSDATE AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStartDate());
			pstmt.setString(2, vo.getEndDate()+" 23:59:59");
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

	public int getCntCounselC(Connection conn, SearchVo vo) {
		String sql = "SELECT COUNT(P.NO) FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE >= SYSDATE AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStartDate());
			pstmt.setString(2, vo.getEndDate()+" 23:59:59");
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

	public int getCntCounselMemAll(Connection conn, SearchVo vo) {
		String sql = "SELECT COUNT(P.NO) FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE (M.ID LIKE ? OR M.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			
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

	public int getCntCounselMemF(Connection conn, SearchVo vo) {
		String sql = "SELECT COUNT(P.NO) FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE < SYSDATE AND (M.ID LIKE ? OR M.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			
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

	public int getCntCounselMemC(Connection conn, SearchVo vo) {
		String sql = "SELECT COUNT(P.NO) FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE >= SYSDATE AND (M.ID LIKE ? OR M.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			
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

	public int getCntCounselProAll(Connection conn, SearchVo vo) {
		String sql = "SELECT COUNT(P.NO) FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE (PRO.ID LIKE ? OR PRO.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			
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

	public int getCntCounselProF(Connection conn, SearchVo vo) {
		String sql = "SELECT COUNT(P.NO) FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE < SYSDATE AND (PRO.ID LIKE ? OR PRO.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			
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

	public int getCntCounselProC(Connection conn, SearchVo vo) {
		String sql = "SELECT COUNT(P.NO) FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE >= SYSDATE AND (PRO.ID LIKE ? OR PRO.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			
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

	public List<CounselPayVo> getCounselAll(Connection conn, SearchVo vo, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT P.NO, P.PAY_DATE, P.ADVICE_DATE, PRO.ID PRO_ID, PRO.NAME PRO_NAME, M.ID MEM_ID, M.NAME MEM_NAME, PAY, PAY_METHOD, STAR, CASE WHEN P.ADVICE_DATE >= SYSDATE THEN '대기' ELSE '완료' END \"상담상태\" FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		List<CounselPayVo> list = new ArrayList<CounselPayVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStartDate());
			pstmt.setString(2, vo.getEndDate()+" 23:59:59");
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String no = rs.getString("NO");
				String payDate = rs.getString("PAY_DATE");
				String adviceDate = rs.getString("ADVICE_DATE");
				String proId = rs.getString("PRO_ID");
				String proName = rs.getString("PRO_NAME");
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String price = rs.getString("PAY");
				String payway = rs.getString("PAY_METHOD");
				String star = rs.getString("STAR");
				String status = rs.getString("상담상태");
				
				CounselPayVo cvo = new CounselPayVo();
				cvo.setNo(no);
				cvo.setPayDate(payDate);
				cvo.setAdviceDate(adviceDate);
				cvo.setProId(proId);
				cvo.setProName(proName);
				cvo.setMemberId(memId);
				cvo.setMemberName(memName);
				cvo.setPrice(price);
				cvo.setPayway(payway);
				cvo.setStar(star);
				cvo.setStatus(status);
				
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}

	public List getCounselF(Connection conn, SearchVo vo, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT P.NO, P.PAY_DATE, P.ADVICE_DATE, PRO.ID PRO_ID, PRO.NAME PRO_NAME, M.ID MEM_ID, M.NAME MEM_NAME, PAY, PAY_METHOD, STAR, CASE WHEN P.ADVICE_DATE >= SYSDATE THEN '대기' ELSE '완료' END \"상담상태\" FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE < SYSDATE AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		List<CounselPayVo> list = new ArrayList<CounselPayVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStartDate());
			pstmt.setString(2, vo.getEndDate()+" 23:59:59");
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String no = rs.getString("NO");
				String payDate = rs.getString("PAY_DATE");
				String adviceDate = rs.getString("ADVICE_DATE");
				String proId = rs.getString("PRO_ID");
				String proName = rs.getString("PRO_NAME");
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String price = rs.getString("PAY");
				String payway = rs.getString("PAY_METHOD");
				String star = rs.getString("STAR");
				String status = rs.getString("상담상태");
				
				CounselPayVo cvo = new CounselPayVo();
				cvo.setNo(no);
				cvo.setPayDate(payDate);
				cvo.setAdviceDate(adviceDate);
				cvo.setProId(proId);
				cvo.setProName(proName);
				cvo.setMemberId(memId);
				cvo.setMemberName(memName);
				cvo.setPrice(price);
				cvo.setPayway(payway);
				cvo.setStar(star);
				cvo.setStatus(status);
				
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}

	public List getCounselC(Connection conn, SearchVo vo, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT P.NO, P.PAY_DATE, P.ADVICE_DATE, PRO.ID PRO_ID, PRO.NAME PRO_NAME, M.ID MEM_ID, M.NAME MEM_NAME, PAY, PAY_METHOD, STAR, CASE WHEN P.ADVICE_DATE >= SYSDATE THEN '대기' ELSE '완료' END \"상담상태\" FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE >= SYSDATE AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		List<CounselPayVo> list = new ArrayList<CounselPayVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStartDate());
			pstmt.setString(2, vo.getEndDate()+" 23:59:59");
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String no = rs.getString("NO");
				String payDate = rs.getString("PAY_DATE");
				String adviceDate = rs.getString("ADVICE_DATE");
				String proId = rs.getString("PRO_ID");
				String proName = rs.getString("PRO_NAME");
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String price = rs.getString("PAY");
				String payway = rs.getString("PAY_METHOD");
				String star = rs.getString("STAR");
				String status = rs.getString("상담상태");
				
				CounselPayVo cvo = new CounselPayVo();
				cvo.setNo(no);
				cvo.setPayDate(payDate);
				cvo.setAdviceDate(adviceDate);
				cvo.setProId(proId);
				cvo.setProName(proName);
				cvo.setMemberId(memId);
				cvo.setMemberName(memName);
				cvo.setPrice(price);
				cvo.setPayway(payway);
				cvo.setStar(star);
				cvo.setStatus(status);
				
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}

	public List getCounselMemAll(Connection conn, SearchVo vo, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT P.NO, P.PAY_DATE, P.ADVICE_DATE, PRO.ID PRO_ID, PRO.NAME PRO_NAME, M.ID MEM_ID, M.NAME MEM_NAME, PAY, PAY_METHOD, STAR, CASE WHEN P.ADVICE_DATE >= SYSDATE THEN '대기' ELSE '완료' END \"상담상태\" FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE (M.ID LIKE ? OR M.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		List<CounselPayVo> list = new ArrayList<CounselPayVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String no = rs.getString("NO");
				String payDate = rs.getString("PAY_DATE");
				String adviceDate = rs.getString("ADVICE_DATE");
				String proId = rs.getString("PRO_ID");
				String proName = rs.getString("PRO_NAME");
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String price = rs.getString("PAY");
				String payway = rs.getString("PAY_METHOD");
				String star = rs.getString("STAR");
				String status = rs.getString("상담상태");
				
				CounselPayVo cvo = new CounselPayVo();
				cvo.setNo(no);
				cvo.setPayDate(payDate);
				cvo.setAdviceDate(adviceDate);
				cvo.setProId(proId);
				cvo.setProName(proName);
				cvo.setMemberId(memId);
				cvo.setMemberName(memName);
				cvo.setPrice(price);
				cvo.setPayway(payway);
				cvo.setStar(star);
				cvo.setStatus(status);
				
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}

	public List getCounselMemF(Connection conn, SearchVo vo, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT P.NO, P.PAY_DATE, P.ADVICE_DATE, PRO.ID PRO_ID, PRO.NAME PRO_NAME, M.ID MEM_ID, M.NAME MEM_NAME, PAY, PAY_METHOD, STAR, CASE WHEN P.ADVICE_DATE >= SYSDATE THEN '대기' ELSE '완료' END \"상담상태\" FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE < SYSDATE AND (M.ID LIKE ? OR M.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		List<CounselPayVo> list = new ArrayList<CounselPayVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String no = rs.getString("NO");
				String payDate = rs.getString("PAY_DATE");
				String adviceDate = rs.getString("ADVICE_DATE");
				String proId = rs.getString("PRO_ID");
				String proName = rs.getString("PRO_NAME");
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String price = rs.getString("PAY");
				String payway = rs.getString("PAY_METHOD");
				String star = rs.getString("STAR");
				String status = rs.getString("상담상태");
				
				CounselPayVo cvo = new CounselPayVo();
				cvo.setNo(no);
				cvo.setPayDate(payDate);
				cvo.setAdviceDate(adviceDate);
				cvo.setProId(proId);
				cvo.setProName(proName);
				cvo.setMemberId(memId);
				cvo.setMemberName(memName);
				cvo.setPrice(price);
				cvo.setPayway(payway);
				cvo.setStar(star);
				cvo.setStatus(status);
				
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}

	public List getCounselMemC(Connection conn, SearchVo vo, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT P.NO, P.PAY_DATE, P.ADVICE_DATE, PRO.ID PRO_ID, PRO.NAME PRO_NAME, M.ID MEM_ID, M.NAME MEM_NAME, PAY, PAY_METHOD, STAR, CASE WHEN P.ADVICE_DATE >= SYSDATE THEN '대기' ELSE '완료' END \"상담상태\" FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE >= SYSDATE AND (M.ID LIKE ? OR M.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		List<CounselPayVo> list = new ArrayList<CounselPayVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String no = rs.getString("NO");
				String payDate = rs.getString("PAY_DATE");
				String adviceDate = rs.getString("ADVICE_DATE");
				String proId = rs.getString("PRO_ID");
				String proName = rs.getString("PRO_NAME");
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String price = rs.getString("PAY");
				String payway = rs.getString("PAY_METHOD");
				String star = rs.getString("STAR");
				String status = rs.getString("상담상태");
				
				CounselPayVo cvo = new CounselPayVo();
				cvo.setNo(no);
				cvo.setPayDate(payDate);
				cvo.setAdviceDate(adviceDate);
				cvo.setProId(proId);
				cvo.setProName(proName);
				cvo.setMemberId(memId);
				cvo.setMemberName(memName);
				cvo.setPrice(price);
				cvo.setPayway(payway);
				cvo.setStar(star);
				cvo.setStatus(status);
				
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}

	public List getCounselProAll(Connection conn, SearchVo vo, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT P.NO, P.PAY_DATE, P.ADVICE_DATE, PRO.ID PRO_ID, PRO.NAME PRO_NAME, M.ID MEM_ID, M.NAME MEM_NAME, PAY, PAY_METHOD, STAR, CASE WHEN P.ADVICE_DATE >= SYSDATE THEN '대기' ELSE '완료' END \"상담상태\" FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE  (PRO.ID LIKE ? OR PRO.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		List<CounselPayVo> list = new ArrayList<CounselPayVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String no = rs.getString("NO");
				String payDate = rs.getString("PAY_DATE");
				String adviceDate = rs.getString("ADVICE_DATE");
				String proId = rs.getString("PRO_ID");
				String proName = rs.getString("PRO_NAME");
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String price = rs.getString("PAY");
				String payway = rs.getString("PAY_METHOD");
				String star = rs.getString("STAR");
				String status = rs.getString("상담상태");
				
				CounselPayVo cvo = new CounselPayVo();
				cvo.setNo(no);
				cvo.setPayDate(payDate);
				cvo.setAdviceDate(adviceDate);
				cvo.setProId(proId);
				cvo.setProName(proName);
				cvo.setMemberId(memId);
				cvo.setMemberName(memName);
				cvo.setPrice(price);
				cvo.setPayway(payway);
				cvo.setStar(star);
				cvo.setStatus(status);
				
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}

	public List getCounselProF(Connection conn, SearchVo vo, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT P.NO, P.PAY_DATE, P.ADVICE_DATE, PRO.ID PRO_ID, PRO.NAME PRO_NAME, M.ID MEM_ID, M.NAME MEM_NAME, PAY, PAY_METHOD, STAR, CASE WHEN P.ADVICE_DATE >= SYSDATE THEN '대기' ELSE '완료' END \"상담상태\" FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE < SYSDATE AND (PRO.ID LIKE ? OR PRO.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		List<CounselPayVo> list = new ArrayList<CounselPayVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String no = rs.getString("NO");
				String payDate = rs.getString("PAY_DATE");
				String adviceDate = rs.getString("ADVICE_DATE");
				String proId = rs.getString("PRO_ID");
				String proName = rs.getString("PRO_NAME");
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String price = rs.getString("PAY");
				String payway = rs.getString("PAY_METHOD");
				String star = rs.getString("STAR");
				String status = rs.getString("상담상태");
				
				CounselPayVo cvo = new CounselPayVo();
				cvo.setNo(no);
				cvo.setPayDate(payDate);
				cvo.setAdviceDate(adviceDate);
				cvo.setProId(proId);
				cvo.setProName(proName);
				cvo.setMemberId(memId);
				cvo.setMemberName(memName);
				cvo.setPrice(price);
				cvo.setPayway(payway);
				cvo.setStar(star);
				cvo.setStatus(status);
				
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}

	public List getCounselProC(Connection conn, SearchVo vo, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT P.NO, P.PAY_DATE, P.ADVICE_DATE, PRO.ID PRO_ID, PRO.NAME PRO_NAME, M.ID MEM_ID, M.NAME MEM_NAME, PAY, PAY_METHOD, STAR, CASE WHEN P.ADVICE_DATE >= SYSDATE THEN '대기' ELSE '완료' END \"상담상태\" FROM PRO_APPOINT P JOIN MEMBER M ON M.NO = P.MEMBER_NO JOIN PRO_MEMBER PRO ON PRO.NO = P.PRO_NO WHERE P.ADVICE_DATE >= SYSDATE AND (PRO.ID LIKE ? OR PRO.NAME LIKE ?) AND PAY_DATE >= ? AND PAY_DATE <= ? ORDER BY P.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		
		List<CounselPayVo> list = new ArrayList<CounselPayVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+vo.getSearch()+"%");
			pstmt.setString(2, "%"+vo.getSearch()+"%");
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate()+" 23:59:59");
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String no = rs.getString("NO");
				String payDate = rs.getString("PAY_DATE");
				String adviceDate = rs.getString("ADVICE_DATE");
				String proId = rs.getString("PRO_ID");
				String proName = rs.getString("PRO_NAME");
				String memId = rs.getString("MEM_ID");
				String memName = rs.getString("MEM_NAME");
				String price = rs.getString("PAY");
				String payway = rs.getString("PAY_METHOD");
				String star = rs.getString("STAR");
				String status = rs.getString("상담상태");
				
				CounselPayVo cvo = new CounselPayVo();
				cvo.setNo(no);
				cvo.setPayDate(payDate);
				cvo.setAdviceDate(adviceDate);
				cvo.setProId(proId);
				cvo.setProName(proName);
				cvo.setMemberId(memId);
				cvo.setMemberName(memName);
				cvo.setPrice(price);
				cvo.setPayway(payway);
				cvo.setStar(star);
				cvo.setStatus(status);
				
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}

}
