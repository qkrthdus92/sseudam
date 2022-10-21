package com.kh.sseudam.counsel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;

public class CounselDao {

	//상담하기 : 전문가 목록 조회(관리자가 승인한 전문가만 조회)
	public List<ProVo> selectList(Connection conn) {
		
		String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY M.NO";
		
		//String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY M.NO ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
//			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
//			int end = start + pv.getBoardLimit() - 1;
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String counselType = rs.getString("COUNSEL_TYPE");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String proStatus = rs.getString("PRO_STATUS");
				String img = rs.getString("IMG");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String introduce = rs.getString("INTRODUCE");
				
				ProVo proVo = new ProVo();
				proVo.setNo(no);
				proVo.setCounselType(counselType);
				proVo.setId(id);
				proVo.setPwd(pwd);
				proVo.setName(name);
				proVo.setGender(gender);
				proVo.setPhone(phone);
				proVo.setEmail(email);
				proVo.setEducation(education);
				proVo.setPrice(price);
				proVo.setProStatus(proStatus);
				proVo.setImg(img);
				proVo.setJoinDate(joinDate);
				proVo.setModifyDate(modifyDate);
				proVo.setIntroduce(introduce);
				
				//평균별점 set하기 (별점받은게 하나도 없다면 null이므로 평점없음으로 널처리했음)
				String avgStar = getAvgStar(conn, no);
				if(avgStar == null) {
					avgStar = "평점없음";
				}
				proVo.setAvgStar(avgStar);
				
				//상담횟수 set하기
				String counselCnt = getCounselCnt(conn, no);
				proVo.setCounselCnt(counselCnt);
				
				proList.add(proVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return proList;
	}
	
	//평균별점 구하기
	public String getAvgStar(Connection conn, String no) {
		
		//평균별점이 2라면 2.0 이런식으로 나오게 하기 위해서 TO_CHAR(숫자컬럼,'fm0.0')을 적용했다
		String sql = "SELECT M.NO, TO_CHAR(AVG(A.STAR),'fm0.0') AVG_STAR FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' AND M.NO = ? GROUP BY M.NO";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String avgStar = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				avgStar = rs.getString("AVG_STAR");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return avgStar;
	}
	
	//상담횟수 구하기(결제가 됐어도 상담날짜가 오늘날짜보다 미래라면 상담을 아직 안한것이므로 상담횟수에 카운트되지않음!)
	public String getCounselCnt(Connection conn, String no) {
		
		String sql = "SELECT NO PRO_NO, SUM(CNT) COUNSEL_CNT FROM ( SELECT M.NO, 0 CNT FROM PRO_MEMBER M LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' GROUP BY M.NO UNION ALL SELECT M.NO, COUNT(A.PRO_NO) CNT FROM PRO_MEMBER M LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' AND A.ADVICE_DATE < SYSDATE GROUP BY M.NO ) WHERE NO = ? GROUP BY NO";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String counselCnt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				counselCnt = rs.getString("COUNSEL_CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return counselCnt;
		
	}

	//상담하기 : 이름으로 전문가 목록 조회
	public List<ProVo> selectListByName(Connection conn, String proName) {
		
		String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' AND M.NAME LIKE ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		List<ProVo> proList = new ArrayList<ProVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+proName+"%");
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				String no = rs.getString("NO");
				
				String counselType = rs.getString("COUNSEL_TYPE");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
	
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String proStatus = rs.getString("PRO_STATUS");
				String img = rs.getString("IMG");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String introduce = rs.getString("INTRODUCE");
				
				ProVo proVo = new ProVo();
				proVo.setNo(no);
				proVo.setCounselType(counselType);
				proVo.setId(id);
				proVo.setPwd(pwd);
				proVo.setName(name);
				proVo.setGender(gender);
				proVo.setPhone(phone);
				proVo.setEmail(email);
				proVo.setEducation(education);
				proVo.setPrice(price);
				proVo.setProStatus(proStatus);
				proVo.setImg(img);
				proVo.setJoinDate(joinDate);
				proVo.setModifyDate(modifyDate);
				proVo.setIntroduce(introduce);
				
				//평균별점 set하기 (별점받은게 하나도 없다면 null이므로 평점없음으로 널처리했음)
				String avgStar = getAvgStar(conn, no);
				if(avgStar == null) {
					avgStar = "평점없음";
				}
				proVo.setAvgStar(avgStar);
				
				//상담횟수 set하기
				String counselCnt = getCounselCnt(conn, no);
				proVo.setCounselCnt(counselCnt);
				
				proList.add(proVo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		
		return proList;
	}

	//상담분야, 상세조건으로 전문가 목록 조회
	public List<ProVo> selectListByVal(Connection conn, String[] counselTypeArr, String[] proLevel, String g,
			String certificate) {

		//기본값
		String counselTypeQuery = "'청소년상담','가족심리상담','우울증상담','취업/진로상담'";
		String genderQuery = "'M','F'";
		String certificateQuery = "'50000','40000','30000'";
		
		//상담분야를 아무것도 선택하지 않으면 null이 들어오므로 널체크함
		if(counselTypeArr != null && counselTypeArr.length >= 1 && counselTypeArr.length <= 3) {
			counselTypeQuery = String.join("','", counselTypeArr);
			counselTypeQuery = "'" + counselTypeQuery + "'";
			
		}
		
		if(g.equals("M")) {
			genderQuery = "'M'";
		}
		
		if(g.equals("F")) {
			genderQuery = "'F'";
		}
		
		if(certificate.equals("2")) {
			certificateQuery = "'40000','30000'";
		}
		
		if(certificate.equals("1")) {
			certificateQuery = "'50000'";
		}
		
		String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' AND T.CLASS IN ("+counselTypeQuery+") AND M.GENDER IN ("+genderQuery+") AND M.PRICE IN ("+certificateQuery+")";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProVo> proList = new ArrayList<ProVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				
				//평균별점 set하기 (별점받은게 하나도 없다면 null이므로 평점없음으로 널처리했음)
				String avgStar = getAvgStar(conn, no);
				if(avgStar == null) {
					avgStar = "평점없음";
				}
				
				//상담횟수 set하기
				String counselCnt = getCounselCnt(conn, no);
				
				String price = rs.getString("PRICE");
				
				//상담사 등급 체크하기
				int priceNum = Integer.parseInt(price);
				int counselCntNum = Integer.parseInt(counselCnt);
				double avgStarNum = 0;
				if(!avgStar.equals("평점없음")) {
					avgStarNum = Double.parseDouble(avgStar);	
				}
				
				boolean isLevel3 = (priceNum == 50000 && counselCntNum >= 10 && avgStarNum >= 4.5);
				boolean isLevel2 = (priceNum == 50000 || (counselCntNum >= 10 && avgStarNum >= 4.5));
				boolean isLevel1 = (!isLevel3 && !isLevel2);
				
				boolean isContainLevel3 = false;
				boolean isContainLevel2 = false;
				boolean isContainLevel1 = false;
				if(proLevel != null) {
					isContainLevel3 = Arrays.asList(proLevel).contains("level3");
					isContainLevel2 = Arrays.asList(proLevel).contains("level2");
					isContainLevel1 = Arrays.asList(proLevel).contains("level1");
				}
				
				//마스터 1개만 포함
				if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level3") && !isLevel3) {
					continue;
				}
				//전문 1개만 포함
				if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level2") && !isLevel2) {
					continue;
				}
				
				//일반 1개만 포함
				if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level1") && !isLevel1) {
					continue;
				}
				//전문+일반 포함
				if(proLevel != null && proLevel.length == 2 && !isContainLevel3 && (!isLevel2 || !isLevel1)) {
					continue;
				}
				//마스터+일반 포함
				if(proLevel != null && proLevel.length == 2 && !isContainLevel2 && (!isLevel3 || !isLevel1)) {
					continue;
				}
				//마스터+전문 포함
				if(proLevel != null && proLevel.length == 2 && !isContainLevel1 && (!isLevel3 || !isLevel2)) {
					continue;
				}
				
				String counselType = rs.getString("COUNSEL_TYPE");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String proStatus = rs.getString("PRO_STATUS");
				String img = rs.getString("IMG");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String introduce = rs.getString("INTRODUCE");
				
				ProVo proVo = new ProVo();
				proVo.setNo(no);
				proVo.setCounselType(counselType);
				proVo.setId(id);
				proVo.setPwd(pwd);
				proVo.setName(name);
				proVo.setGender(gender);
				proVo.setPhone(phone);
				proVo.setEmail(email);
				proVo.setEducation(education);
				proVo.setPrice(price);
				proVo.setProStatus(proStatus);
				proVo.setImg(img);
				proVo.setJoinDate(joinDate);
				proVo.setModifyDate(modifyDate);
				proVo.setIntroduce(introduce);
				
				proVo.setAvgStar(avgStar);
				
				proVo.setCounselCnt(counselCnt);
				
				proList.add(proVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		System.out.println(proList);
		return proList;
	}

	//최근등록순
	public List<ProVo> selectListByLatest(Connection conn) {
		String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY JOIN_DATE DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String counselType = rs.getString("COUNSEL_TYPE");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String proStatus = rs.getString("PRO_STATUS");
				String img = rs.getString("IMG");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String introduce = rs.getString("INTRODUCE");
				
				ProVo proVo = new ProVo();
				proVo.setNo(no);
				proVo.setCounselType(counselType);
				proVo.setId(id);
				proVo.setPwd(pwd);
				proVo.setName(name);
				proVo.setGender(gender);
				proVo.setPhone(phone);
				proVo.setEmail(email);
				proVo.setEducation(education);
				proVo.setPrice(price);
				proVo.setProStatus(proStatus);
				proVo.setImg(img);
				proVo.setJoinDate(joinDate);
				proVo.setModifyDate(modifyDate);
				proVo.setIntroduce(introduce);
				
				//평균별점 set하기 (별점받은게 하나도 없다면 null이므로 평점없음으로 널처리했음)
				String avgStar = getAvgStar(conn, no);
				if(avgStar == null) {
					avgStar = "평점없음";
				}
				proVo.setAvgStar(avgStar);
				
				//상담횟수 set하기
				String counselCnt = getCounselCnt(conn, no);
				proVo.setCounselCnt(counselCnt);
				
				proList.add(proVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return proList;
	}

	//평점순
	public List<ProVo> selectListByStar(Connection conn) {
		String sql = "SELECT M.NO, TO_CHAR(AVG(A.STAR),'fm0.0') AVG_STAR FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' GROUP BY M.NO ORDER BY AVG_STAR DESC NULLS LAST";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				
				ProVo proVo = selectListByNo(conn, no);
				
				proList.add(proVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return proList;
	}
	
	//전문가번호로 1명 select
	public ProVo selectListByNo(Connection conn, String num) {
		
		String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' AND M.NO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProVo proVo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String no = rs.getString("NO");
				String counselType = rs.getString("COUNSEL_TYPE");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String proStatus = rs.getString("PRO_STATUS");
				String img = rs.getString("IMG");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String introduce = rs.getString("INTRODUCE");
				
				proVo = new ProVo();
				proVo.setNo(no);
				proVo.setCounselType(counselType);
				proVo.setId(id);
				proVo.setPwd(pwd);
				proVo.setName(name);
				proVo.setGender(gender);
				proVo.setPhone(phone);
				proVo.setEmail(email);
				proVo.setEducation(education);
				proVo.setPrice(price);
				proVo.setProStatus(proStatus);
				proVo.setImg(img);
				proVo.setJoinDate(joinDate);
				proVo.setModifyDate(modifyDate);
				proVo.setIntroduce(introduce);
				
				//평균별점 set하기 (별점받은게 하나도 없다면 null이므로 평점없음으로 널처리했음)
				String avgStar = getAvgStar(conn, no);
				if(avgStar == null) {
					avgStar = "평점없음";
				}
				proVo.setAvgStar(avgStar);
				
				//상담횟수 set하기
				String counselCnt = getCounselCnt(conn, no);
				proVo.setCounselCnt(counselCnt);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return proVo;
	}

	//상담횟수순
	public List<ProVo> selectListByReview(Connection conn) {
		String sql = "SELECT NO PRO_NO, SUM(CNT) COUNSEL_CNT FROM ( SELECT M.NO, 0 CNT FROM PRO_MEMBER M LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' GROUP BY M.NO UNION ALL SELECT M.NO, COUNT(A.PRO_NO) CNT FROM PRO_MEMBER M LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' AND A.ADVICE_DATE < SYSDATE GROUP BY M.NO ) GROUP BY NO ORDER BY COUNSEL_CNT DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("PRO_NO");
				
				ProVo proVo = selectListByNo(conn, no);
				
				proList.add(proVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return proList;
	}

	//높은가격순
	public List<ProVo> selectListByMaxPrice(Connection conn) {
		String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY M.PRICE DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String counselType = rs.getString("COUNSEL_TYPE");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String proStatus = rs.getString("PRO_STATUS");
				String img = rs.getString("IMG");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String introduce = rs.getString("INTRODUCE");
				
				ProVo proVo = new ProVo();
				proVo.setNo(no);
				proVo.setCounselType(counselType);
				proVo.setId(id);
				proVo.setPwd(pwd);
				proVo.setName(name);
				proVo.setGender(gender);
				proVo.setPhone(phone);
				proVo.setEmail(email);
				proVo.setEducation(education);
				proVo.setPrice(price);
				proVo.setProStatus(proStatus);
				proVo.setImg(img);
				proVo.setJoinDate(joinDate);
				proVo.setModifyDate(modifyDate);
				proVo.setIntroduce(introduce);
				
				//평균별점 set하기 (별점받은게 하나도 없다면 null이므로 평점없음으로 널처리했음)
				String avgStar = getAvgStar(conn, no);
				if(avgStar == null) {
					avgStar = "평점없음";
				}
				proVo.setAvgStar(avgStar);
				
				//상담횟수 set하기
				String counselCnt = getCounselCnt(conn, no);
				proVo.setCounselCnt(counselCnt);
				
				proList.add(proVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return proList;
	}

	//낮은가격순
	public List<ProVo> selectListByMinPrice(Connection conn) {
		String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY M.PRICE";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProVo> proList = new ArrayList<ProVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String counselType = rs.getString("COUNSEL_TYPE");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String price = rs.getString("PRICE");
				String proStatus = rs.getString("PRO_STATUS");
				String img = rs.getString("IMG");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String introduce = rs.getString("INTRODUCE");
				
				ProVo proVo = new ProVo();
				proVo.setNo(no);
				proVo.setCounselType(counselType);
				proVo.setId(id);
				proVo.setPwd(pwd);
				proVo.setName(name);
				proVo.setGender(gender);
				proVo.setPhone(phone);
				proVo.setEmail(email);
				proVo.setEducation(education);
				proVo.setPrice(price);
				proVo.setProStatus(proStatus);
				proVo.setImg(img);
				proVo.setJoinDate(joinDate);
				proVo.setModifyDate(modifyDate);
				proVo.setIntroduce(introduce);
				
				//평균별점 set하기 (별점받은게 하나도 없다면 null이므로 평점없음으로 널처리했음)
				String avgStar = getAvgStar(conn, no);
				if(avgStar == null) {
					avgStar = "평점없음";
				}
				proVo.setAvgStar(avgStar);
				
				//상담횟수 set하기
				String counselCnt = getCounselCnt(conn, no);
				proVo.setCounselCnt(counselCnt);
				
				proList.add(proVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return proList;
	}

	public int cntProAll(Connection conn) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY M.NO";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return result;
	}

	public int cntProByName(Connection conn, String proName) {
		String sql = "SELECT COUNT(*) FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' AND M.NAME LIKE ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, proName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return result;
	}

}
