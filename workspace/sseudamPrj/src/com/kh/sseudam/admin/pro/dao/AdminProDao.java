package com.kh.sseudam.admin.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.admin.pro.vo.ProCounselListVo;
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

	public int updateOneWithImg(Connection conn, ProVo vo, AttachmentVo aVo) {
		String sql = "UPDATE PRO_MEMBER SET NAME = ?, GENDER = ?, ID =?, PWD = ?, COUNSEL_TYPE_NO = ?, EMAIL = ?, PHONE = ?, EDUCATION = ?, PRICE = ?, IMG = ?, INTRODUCE = ?, MODIFY_DATE = SYSDATE WHERE NO = ? ";
		PreparedStatement pstmt = null;
		int result = 0;
		
		String x = "";
		switch(vo.getCounselType()) {
		case "청소년상담" :
			x = "1";
			break;
		case "가족심리상담" :
			x = "2";
			break;
		case "우울증상담" :
			x = "3";
			break;
		case "취업/진로상담" :
			x = "4";
			break;	
		}
		
		String y = null;
		if(!vo.getPrice().equals("미정")) {
			y= vo.getPrice();
		}
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getId());
			pstmt.setString(4, vo.getPwd());
			pstmt.setString(5, x);
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getPhone());
			pstmt.setString(8, vo.getEducation());
			pstmt.setString(9, y);
			pstmt.setString(10, aVo.getChangeName());
			pstmt.setString(11, vo.getIntroduce());
			pstmt.setString(12, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateOneWithoutImg(Connection conn, ProVo vo) {
		String sql = "UPDATE PRO_MEMBER SET NAME = ?, GENDER = ?, ID =?, PWD = ?, COUNSEL_TYPE_NO = ?, EMAIL = ?, PHONE = ?, EDUCATION = ?, PRICE = ?, INTRODUCE = ?, MODIFY_DATE = SYSDATE WHERE NO = ? ";
		PreparedStatement pstmt = null;
		int result = 0;
		
		int x = 0;
		switch(vo.getCounselType()) {
		case "청소년상담" :
			x = 1;
			break;
		case "가족심리상담" :
			x = 2;
			break;
		case "우울증상담" :
			x = 3;
			break;
		case "취업/진로상담" :
			x = 4;
			break;	
		}
		
		String y = null;
		if(!vo.getPrice().equals("미정")) {
			y= vo.getPrice();
		}
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getId());
			pstmt.setString(4, vo.getPwd());
			pstmt.setInt(5, x);
			pstmt.setString(6, vo.getEmail());
			pstmt.setString(7, vo.getPhone());
			pstmt.setString(8, vo.getEducation());
			pstmt.setString(9, y);
			pstmt.setString(10, vo.getIntroduce());
			pstmt.setString(11, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//전문가 승인 업데이트
	public int okOne(Connection conn, String mno) {
		String sql = "UPDATE PRO_MEMBER SET PRO_STATUS = 'J' WHERE NO = ?";
		
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

	//전문가 승인취소 업데이트
	public int cancelOne(Connection conn, String mno) {
		String sql = "UPDATE PRO_MEMBER SET PRO_STATUS = 'W' WHERE NO = ?";
		
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

	public int insertCerOne(Connection conn, CertificateVo cv, AttachmentVo aVo) {
		String sql = "INSERT INTO CERTIFICATE VALUES(SEQ_CERTIFICATE_NO.NEXTVAL, ?,?,?,?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cv.getNo());
			pstmt.setString(2, cv.getName());
			pstmt.setString(3, cv.getNum());
			pstmt.setString(4, aVo.getChangeName());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteCer(Connection conn, String img) {
		String sql = "DELETE FROM CERTIFICATE WHERE IMG_PATH = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, img);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public String getProfit(Connection conn, String mno) {
		String sql = "SELECT SUM(PAY) FROM PRO_APPOINT WHERE PRO_NO = ?";
		
		PreparedStatement pstmt = null;
		String result = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("SUM(PAY)");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
	
		return result;
	}

	public String getAvgStar(Connection conn, String mno) {
		String sql = "SELECT TO_CHAR(AVG(STAR),'fm0.0') AVG_STAR FROM PRO_APPOINT WHERE PRO_NO = ?";
		
		PreparedStatement pstmt = null;
		String result = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("AVG_STAR");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
	
		return result;
	}

	public String getFinishCnt(Connection conn, String mno) {
		String sql = "SELECT COUNT(*) FROM PRO_APPOINT WHERE PRO_NO = ? AND ADVICE_DATE < SYSDATE";
		
		PreparedStatement pstmt = null;
		String result = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("COUNT(*)");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
	
		return result;
	}

	public String getWaitCnt(Connection conn, String mno) {
		String sql = "SELECT COUNT(*) FROM PRO_APPOINT WHERE PRO_NO = ? AND ADVICE_DATE >= SYSDATE";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString("COUNT(*)");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
	
		return result;
	}

	public List<ProCounselListVo> getCounselList(Connection conn, String mno) {
		String sql = "SELECT P.NO, P.ADVICE_DATE, P.PAY_DATE, M.ID, P.PAY, P.STAR ,CASE WHEN P.ADVICE_DATE >= SYSDATE THEN '대기' ELSE '완료' END \"상담상태\" FROM PRO_APPOINT P JOIN MEMBER M ON P.MEMBER_NO = M.NO WHERE PRO_NO = ? ORDER BY ADVICE_DATE DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ProCounselListVo> list = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String adviceDate = rs.getString("ADVICE_DATE");
				String payDate = rs.getString("PAY_DATE");
				String id = rs.getString("ID");
				String price = rs.getString("PAY");
				String star = rs.getString("STAR");
				String status = rs.getString("상담상태");
				
				ProCounselListVo vo = new ProCounselListVo();
				vo.setNo(no);
				vo.setAdviceDate(adviceDate);
				vo.setPayDate(payDate);
				vo.setId(id);
				vo.setPrice(price);
				vo.setStar(star);
				vo.setStatus(status);
				
				list.add(vo);
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
