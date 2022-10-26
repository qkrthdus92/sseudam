package com.kh.sseudam.admin.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.AttachmentVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.counsel.pro.vo.CertificateVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.vo.MemberVo;

public class AdminProDao {

	//모든전문가수 카운드
	public int selectCntAll(Connection conn) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER";
		
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

	//모든전문가 조회
	public List selectListAll(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM PRO_MEMBER P JOIN COUNSEL_TYPE C ON P.COUNSEL_TYPE_NO = C.NO ORDER BY P.NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String id = rs.getString("ID");
				String counselType = rs.getString("CLASS");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String status = rs.getString("PRO_STATUS");
			
				
				ProVo vo = new ProVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setGender(gender);
				vo.setId(id);
				vo.setCounselType(counselType);
				vo.setEmail(email);
				vo.setPhone(phone);
				vo.setEducation(education);
				vo.setPrice(price);
				vo.setProStatus(status);
				
				proList.add(vo);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return proList;
	}

	//승인대기 전문가수 카운트
	public int selectCntW(Connection conn) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER WHERE PRO_STATUS = 'W'";
		
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

	//승인완료 전문가수 카운트
	public int selectCntJ(Connection conn) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER WHERE PRO_STATUS = 'J'";
		
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

	//탈퇴전문가수 카운트
	public int selectCntQ(Connection conn) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER WHERE PRO_STATUS = 'Q'";
		
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

	//승인대기 전문가 목록 조회
	public List selectListW(Connection conn, PageVo pv) {
	String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM PRO_MEMBER P JOIN COUNSEL_TYPE C ON P.COUNSEL_TYPE_NO = C.NO WHERE P.PRO_STATUS = 'W' ORDER BY P.NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String id = rs.getString("ID");
				String counselType = rs.getString("CLASS");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String status = rs.getString("PRO_STATUS");
			
				
				ProVo vo = new ProVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setGender(gender);
				vo.setId(id);
				vo.setCounselType(counselType);
				vo.setEmail(email);
				vo.setPhone(phone);
				vo.setEducation(education);
				vo.setPrice(price);
				vo.setProStatus(status);
				
				proList.add(vo);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return proList;
	}

	public List selectListJ(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM PRO_MEMBER P JOIN COUNSEL_TYPE C ON P.COUNSEL_TYPE_NO = C.NO WHERE P.PRO_STATUS = 'J' ORDER BY P.NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String id = rs.getString("ID");
				String counselType = rs.getString("CLASS");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String status = rs.getString("PRO_STATUS");
			
				
				ProVo vo = new ProVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setGender(gender);
				vo.setId(id);
				vo.setCounselType(counselType);
				vo.setEmail(email);
				vo.setPhone(phone);
				vo.setEducation(education);
				vo.setPrice(price);
				vo.setProStatus(status);
				
				proList.add(vo);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return proList;
	}

	public List selectListQ(Connection conn, PageVo pv) {
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM PRO_MEMBER P JOIN COUNSEL_TYPE C ON P.COUNSEL_TYPE_NO = C.NO WHERE P.PRO_STATUS = 'Q' ORDER BY P.NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String id = rs.getString("ID");
				String counselType = rs.getString("CLASS");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String status = rs.getString("PRO_STATUS");
			
				
				ProVo vo = new ProVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setGender(gender);
				vo.setId(id);
				vo.setCounselType(counselType);
				vo.setEmail(email);
				vo.setPhone(phone);
				vo.setEducation(education);
				vo.setPrice(price);
				vo.setProStatus(status);
				
				proList.add(vo);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return proList;
	}

	public int selectCntSearch(Connection conn, String search) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER WHERE NAME LIKE ? OR ID LIKE ?";
		
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
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM PRO_MEMBER P JOIN COUNSEL_TYPE C ON P.COUNSEL_TYPE_NO = C.NO WHERE NAME LIKE ? OR ID LIKE ? ORDER BY P.NO DESC) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
		int end = start + pv.getBoardLimit() - 1;
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setString(2, "%"+search+"%");
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String id = rs.getString("ID");
				String counselType = rs.getString("CLASS");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String status = rs.getString("PRO_STATUS");
			
				
				ProVo vo = new ProVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setGender(gender);
				vo.setId(id);
				vo.setCounselType(counselType);
				vo.setEmail(email);
				vo.setPhone(phone);
				vo.setEducation(education);
				vo.setPrice(price);
				vo.setProStatus(status);
				
				proList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return proList;
	}

	public int insertOne(Connection conn, ProVo vo, AttachmentVo aVo) {
		String sql = "INSERT INTO PRO_MEMBER (NO, COUNSEL_TYPE_NO, ID, PWD, NAME, GENDER, PHONE, EMAIL, EDUCATION, PRO_STATUS, IMG, INTRODUCE )VALUES (SEQ_PRO_MEMBER_NO.NEXTVAL,?,?,?,?,?,?,?,?,'W',?,? )";
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println(vo);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCounselType());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getName());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getPhone());
			pstmt.setString(7, vo.getEmail());
			pstmt.setString(8, vo.getEducation());
			pstmt.setString(9, aVo.getChangeName());
			pstmt.setString(10, vo.getIntroduce());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ProVo selectOneByNo(Connection conn, String mno) {
		String sql = "SELECT * FROM PRO_MEMBER P JOIN COUNSEL_TYPE C ON P.COUNSEL_TYPE_NO = C.NO WHERE P.NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String no = rs.getString("NO");
				String counselType = rs.getString("CLASS");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String status = rs.getString("PRO_STATUS");
				String img = rs.getString("IMG");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String introduce = rs.getString("INTRODUCE");
				
				vo = new ProVo();
				vo.setNo(no);
				vo.setCounselType(counselType);
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setGender(gender);
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setEducation(education);
				vo.setPrice(price);
				vo.setProStatus(status);
				vo.setImg(img);
				vo.setJoinDate(joinDate);
				vo.setModifyDate(modifyDate);
				vo.setIntroduce(introduce);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return vo;
	}

	public List<CertificateVo> selectCerByNo(Connection conn, String mno) {
		String sql = "SELECT * FROM CERTIFICATE WHERE PRO_MEMBER_NO = ? ORDER BY NO";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List voList = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String pno = rs.getString("PRO_MEMBER_NO");
				String name = rs.getString("CERTIFICATE_NAME");
				String num = rs.getString("CERTIFICATE_NUM");
				String img = rs.getString("IMG_PATH");
				
				CertificateVo vo = new CertificateVo();
				vo.setNo(no);
				vo.setProNo(pno);
				vo.setName(name);
				vo.setNum(num);
				vo.setImg(img);
				
				voList.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return voList;
	}

	public boolean checkDup(Connection conn, String id) {
		String sql = "SELECT * FROM PRO_MEMBER WHERE ID = ?  AND PRO_STATUS != 'Q'";
		
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
		String sql = "SELECT * FROM PRO_MEMBER WHERE NO = ? AND ID = ? ";
		
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

	public int quitOne(Connection conn, String mno) {
		String sql = "UPDATE PRO_MEMBER SET PRO_STATUS ='Q' WHERE NO = ?";
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
