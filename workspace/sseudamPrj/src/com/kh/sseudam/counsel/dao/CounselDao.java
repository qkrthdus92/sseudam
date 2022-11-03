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
import com.kh.sseudam.counsel.pro.vo.CertificateVo;
import com.kh.sseudam.counsel.pro.vo.CounselCnt;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.counsel.pro.vo.ReserveVo;

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
	public List<ProVo> selectListByName(Connection conn, String proName, PageVo pv) {
		
		//String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' AND M.NAME LIKE ?";
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' AND M.NAME LIKE ? ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		
		List<ProVo> proList = new ArrayList<ProVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+proName+"%");
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1;
			int end = start + pv.getBoardLimit() - 1;
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
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
	
	//상담분야, 상세조건으로 전문가 수 조회
	public int cntProByVal(Connection conn, String[] counselTypeArr, String[] proLevel, String g,
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
		//String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' AND T.CLASS IN ("+counselTypeQuery+") AND M.GENDER IN ("+genderQuery+") AND M.PRICE IN ("+certificateQuery+") ) T ) WHERE RNUM BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProVo> proList = new ArrayList<ProVo>();
		int cnt = 0;
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
				cnt += 1;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		
	
		return cnt;

	}

	//상담분야, 상세조건으로 전문가 목록 조회
	public List<ProVo> selectListByVal(Connection conn, String[] counselTypeArr, String[] proLevel, String g,
			String certificate, PageVo pv) {

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
		
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,"
				+ "M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' AND T.CLASS IN ("+counselTypeQuery+") AND M.GENDER IN ("+genderQuery+") AND M.PRICE IN ("+certificateQuery+") "
						+ "ORDER BY M.NO) T ) WHERE RNUM BETWEEN ? AND ?";
		if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level3")) {
			System.out.println("마스터 쿼리문 시작!");
			sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT M.NO, TO_CHAR(AVG(A.STAR),'fm0.0') AVG_STAR,  T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,"
					+ "M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE, C.COUNSEL_CNT\r\n"
					+ "FROM PRO_MEMBER M \r\n"
					+ "JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO\r\n"
					+ "LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO\r\n"
					+ "JOIN COUNSEL_CNT C ON C.PRO_NO = M.NO\r\n"
					+ "WHERE PRO_STATUS = 'J' AND M.PRICE = 50000 AND COUNSEL_CNT >= 10  AND M.NO IN (SELECT M.NO\r\n"
					+ "FROM PRO_MEMBER M \r\n"
					+ "JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO\r\n"
					+ "WHERE PRO_STATUS = 'J' AND T.CLASS IN ("+counselTypeQuery+") AND M.GENDER IN ("+genderQuery+") AND M.PRICE IN ("+certificateQuery+"))\r\n"
					+ "GROUP BY M.NO, T.CLASS ,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE, C.COUNSEL_CNT\r\n"
					+ "HAVING AVG(A.STAR) >= 4.5\r\n"
					+ "ORDER BY M.NO ) T ) WHERE RNUM BETWEEN ? AND ?";
		}
		if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level2")) {
			System.out.println("전문 쿼리문 시작!");
			sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( \r\n"
					+ "SELECT *\r\n"
					+ "FROM NOT_MASTER\r\n"
					+ "WHERE ((PRICE = 50000) OR ((COUNSEL_CNT >= 10) AND (AVG_STAR >= 4.5))) AND COUNSEL_TYPE IN ("+counselTypeQuery+") AND GENDER IN ("+genderQuery+") AND PRICE IN ("+certificateQuery+") ORDER BY NO) T ) "
							+ "WHERE RNUM BETWEEN ? AND ?";
		}
		if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level1")) {
			System.out.println("일반 쿼리문 시작!");
			sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT *\r\n"
					+ "FROM LEVEL1\r\n"
					+ "WHERE COUNSEL_TYPE IN ("+counselTypeQuery+") AND GENDER IN ("+genderQuery+") AND PRICE IN ("+certificateQuery+") ORDER BY NO) T ) WHERE RNUM BETWEEN ? AND ?";
		}
		if(proLevel != null && proLevel.length == 2 && Arrays.asList(proLevel).contains("level3") && Arrays.asList(proLevel).contains("level2")) {
			System.out.println("마스터+전문 쿼리문 시작!");	
			sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT * FROM LEVEL2AND3 WHERE COUNSEL_TYPE IN ("+counselTypeQuery+") AND GENDER IN ("+genderQuery+") AND PRICE IN ("+certificateQuery+") ORDER BY NO ) T ) "
					+ "WHERE RNUM BETWEEN ? AND ?";
		}
		if(proLevel != null && proLevel.length == 2 && Arrays.asList(proLevel).contains("level3") && Arrays.asList(proLevel).contains("level1")) {
			System.out.println("마스터+일반 쿼리문 시작!");
			sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT *\r\n"
					+ "FROM LEVEL1AND3\r\n"
					+ "WHERE COUNSEL_TYPE IN ("+counselTypeQuery+") AND GENDER IN ("+genderQuery+") AND PRICE IN ("+certificateQuery+") ORDER BY NO) T ) WHERE RNUM BETWEEN ? AND ?";
		}
		if(proLevel != null && proLevel.length == 2 && Arrays.asList(proLevel).contains("level2") && Arrays.asList(proLevel).contains("level1")) {
			System.out.println("전문+일반 쿼리문 시작!");
			sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT *\r\n"
					+ "FROM LEVEL1AND2\r\n"
					+ "WHERE COUNSEL_TYPE IN ("+counselTypeQuery+") AND GENDER IN ("+genderQuery+") AND PRICE IN ("+certificateQuery+") ORDER BY NO) T ) WHERE RNUM BETWEEN ? AND ?";
		}
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
				System.out.println("전문가번호: " + no);
				
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
				
//				//마스터 1개만 포함
//				if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level3") && !isLevel3) {
//				
//					continue;
//				}
//				//전문 1개만 포함
//				if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level2") && !isLevel2) {
//					continue;
//				}
//				
//				//일반 1개만 포함
//				if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level1") && !isLevel1) {
//					continue;
//				}
//				//전문+일반 포함
//				if(proLevel != null && proLevel.length == 2 && !isContainLevel3 && (!isLevel2 || !isLevel1)) {
//					continue;
//				}
//				//마스터+일반 포함
//				if(proLevel != null && proLevel.length == 2 && !isContainLevel2 && (!isLevel3 || !isLevel1)) {
//					continue;
//				}
//				//마스터+전문 포함
//				if(proLevel != null && proLevel.length == 2 && !isContainLevel1 && (!isLevel3 || !isLevel2)) {
//					continue;
//				}
				
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
		

		return proList;
	}

	//최근등록순
	public List<ProVo> selectListByLatest(Connection conn,PageVo pv) {
		//String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY JOIN_DATE DESC";
		
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY M.NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
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
	public List<ProVo> selectListByStar(Connection conn, PageVo pv) {
		//String sql = "SELECT M.NO, TO_CHAR(AVG(A.STAR),'fm0.0') AVG_STAR FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' GROUP BY M.NO ORDER BY AVG_STAR DESC NULLS LAST";
		
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT M.NO, TO_CHAR(AVG(A.STAR),'fm0.0') AVG_STAR FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' GROUP BY M.NO ORDER BY AVG_STAR DESC NULLS LAST ) T ) WHERE RNUM BETWEEN ? AND ?";
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
	public List<ProVo> selectListByReview(Connection conn, PageVo pv) {
		//String sql = "SELECT NO PRO_NO, SUM(CNT) COUNSEL_CNT FROM ( SELECT M.NO, 0 CNT FROM PRO_MEMBER M LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' GROUP BY M.NO UNION ALL SELECT M.NO, COUNT(A.PRO_NO) CNT FROM PRO_MEMBER M LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' AND A.ADVICE_DATE < SYSDATE GROUP BY M.NO ) GROUP BY NO ORDER BY COUNSEL_CNT DESC";
		
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT NO PRO_NO, SUM(CNT) COUNSEL_CNT FROM ( SELECT M.NO, 0 CNT FROM PRO_MEMBER M LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' GROUP BY M.NO UNION ALL SELECT M.NO, COUNT(A.PRO_NO) CNT FROM PRO_MEMBER M LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO WHERE PRO_STATUS = 'J' AND A.ADVICE_DATE < SYSDATE GROUP BY M.NO ) GROUP BY NO ORDER BY COUNSEL_CNT DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
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
	public List<ProVo> selectListByMaxPrice(Connection conn, PageVo pv) {
		//String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY M.PRICE DESC";
		
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY M.PRICE DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
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
	public List<ProVo> selectListByMinPrice(Connection conn, PageVo pv) {
		//String sql = "SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY M.PRICE";
		
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM ( SELECT M.NO, T.CLASS COUNSEL_TYPE,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE FROM PRO_MEMBER M JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO WHERE PRO_STATUS = 'J' ORDER BY M.PRICE ) T ) WHERE RNUM BETWEEN ? AND ?";
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

	//승인된 전문가수 카운트
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
			pstmt.setString(1, "%"+proName+"%");
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

	//전문가 번호로 자격증 리스트 select
	public List selectCerByNo(Connection conn, String bno) {
		String sql = "SELECT * FROM CERTIFICATE WHERE PRO_MEMBER_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List cerList = new ArrayList();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO");
				String proNo = rs.getString("PRO_MEMBER_NO");
				String name = rs.getString("CERTIFICATE_NAME");
				String num = rs.getString("CERTIFICATE_NUM");
				String img = rs.getString("IMG_PATH");
				
				CertificateVo vo = new CertificateVo();
				vo.setNo(no);
				vo.setProNo(proNo);
				vo.setName(name);
				vo.setNum(num);
				vo.setImg(img);
				
				cerList.add(vo);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		return cerList;
	}

	public List<CounselCnt> selectDateListByNo(Connection conn, String bno) {
		
		//String sql = "SELECT PRO_NO, ADVICE_DATE, COUNT(PRO_NO) FROM PRO_APPOINT GROUP BY PRO_NO, ADVICE_DATE HAVING PRO_NO = ? AND COUNT(PRO_NO) >= 3 AND ADVICE_DATE > SYSDATE";
		
		String sql = "SELECT PRO_NO, ADVICE_DATE, COUNT(PRO_NO), EXTRACT (YEAR FROM ADVICE_DATE) ||'-'|| EXTRACT (MONTH FROM ADVICE_DATE) ||'-'|| EXTRACT (DAY FROM ADVICE_DATE) AS DATE_FORMAT FROM PRO_APPOINT GROUP BY PRO_NO, ADVICE_DATE HAVING PRO_NO = ? AND COUNT(PRO_NO) >= 3 AND ADVICE_DATE > SYSDATE";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List dateList = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String proNo = rs.getString("PRO_NO");
				String counselDate = rs.getString("DATE_FORMAT");
				String cnt = rs.getString("COUNT(PRO_NO)");
				
				CounselCnt vo = new CounselCnt();
				vo.setProNo(proNo);
				vo.setCounselDate(counselDate);
				vo.setCnt(cnt);
				
				dateList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return dateList;
	}

	public int insertReserve(Connection conn, ReserveVo vo) {
		
		String sql = "INSERT INTO PRO_APPOINT (NO, MEMBER_NO, PRO_NO, ADVICE_DATE, PAY_METHOD, PAY, PAY_DATE) VALUES (SEQ_PRO_APPOINT_NO.NEXTVAL,?,?,?,?,?,SYSDATE)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberNo());
			pstmt.setString(2, vo.getProNo());
			pstmt.setString(3, vo.getCounselDate());
			pstmt.setString(4, vo.getPayway());
			pstmt.setString(5, vo.getPrice());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int cntLevel3(Connection conn, String[] counselTypeArr, String[] proLevel, String g,
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
		
		String sql = "";
		if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level3")) {
			sql = "SELECT COUNT(DISTINCT(M.NO))\r\n"
					+ "FROM PRO_MEMBER M \r\n"
					+ "JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO\r\n"
					+ "LEFT JOIN PRO_APPOINT A ON M.NO = A.PRO_NO\r\n"
					+ "JOIN COUNSEL_CNT C ON C.PRO_NO = M.NO\r\n"
					+ "WHERE PRO_STATUS = 'J' AND M.PRICE = 50000 AND COUNSEL_CNT >= 10  AND M.NO IN (SELECT M.NO\r\n"
					+ "FROM PRO_MEMBER M \r\n"
					+ "JOIN COUNSEL_TYPE T ON M.COUNSEL_TYPE_NO = T.NO\r\n"
					+ "WHERE PRO_STATUS = 'J' AND T.CLASS IN ("+counselTypeQuery+") AND M.GENDER IN ("+genderQuery+") AND M.PRICE IN ("+certificateQuery+"))\r\n"
					+ "GROUP BY M.NO, T.CLASS ,M.ID,M.PWD, M.NAME, M.GENDER,M.PHONE, M.EMAIL,M.EDUCATION,M.PRICE,M.PRO_STATUS,M.IMG,M.JOIN_DATE,M.MODIFY_DATE,M.INTRODUCE, C.COUNSEL_CNT\r\n"
					+ "HAVING AVG(A.STAR) >= 4.5\r\n"
					+ "ORDER BY M.NO";
		}
		if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level2")) {
			sql = "SELECT COUNT(*)\r\n"
					+ "FROM NOT_MASTER\r\n"
					+ "WHERE ((PRICE = 50000) OR ((COUNSEL_CNT >= 10) AND (AVG_STAR >= 4.5))) AND COUNSEL_TYPE IN ("+counselTypeQuery+") AND GENDER IN ("+genderQuery+") AND PRICE IN ("+certificateQuery+")";
		}
		if(proLevel != null && proLevel.length == 1 && proLevel[0].equals("level1")) {
			sql = "SELECT COUNT(*)\r\n"
					+ "FROM LEVEL1\r\n"
					+ "WHERE COUNSEL_TYPE IN ("+counselTypeQuery+") AND GENDER IN ("+genderQuery+") AND PRICE IN ("+certificateQuery+")";
		}
		if(proLevel != null && proLevel.length == 2 && Arrays.asList(proLevel).contains("level3") && Arrays.asList(proLevel).contains("level2")) {
			sql = "SELECT COUNT(*)\r\n"
					+ "FROM LEVEL2AND3\r\n"
					+ "WHERE COUNSEL_TYPE IN ("+counselTypeQuery+") AND GENDER IN ("+genderQuery+") AND PRICE IN ("+certificateQuery+")";
		}
		if(proLevel != null && proLevel.length == 2 && Arrays.asList(proLevel).contains("level3") && Arrays.asList(proLevel).contains("level1")) {
			sql = "SELECT COUNT(*)\r\n"
					+ "FROM LEVEL1AND3\r\n"
					+ "WHERE COUNSEL_TYPE IN ("+counselTypeQuery+") AND GENDER IN ("+genderQuery+") AND PRICE IN ("+certificateQuery+")";
		}
		if(proLevel != null && proLevel.length == 2 && Arrays.asList(proLevel).contains("level2") && Arrays.asList(proLevel).contains("level1")) {
			sql = "SELECT COUNT(*)\r\n"
					+ "FROM LEVEL1AND2\r\n"
					+ "WHERE COUNSEL_TYPE IN ("+counselTypeQuery+") AND GENDER IN ("+genderQuery+") AND PRICE IN ("+certificateQuery+")";
		}
		
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

	

}
