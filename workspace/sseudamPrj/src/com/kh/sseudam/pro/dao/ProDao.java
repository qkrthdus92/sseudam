package com.kh.sseudam.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.pro.vo.ProJoinPage1Vo;
import com.kh.sseudam.pro.vo.ProJoinPage2Vo;
import com.kh.sseudam.pro.vo.ProJoinPage3Vo;
import com.kh.sseudam.pro.vo.ProMemberJoinVo;

public class ProDao {

	//전문가 회원가입 + 프로필 사진 첨부파일
	public int proInsertOne(Connection conn, ProJoinPage1Vo proVo1, ProJoinPage2Vo proVo2, ProJoinPage3Vo proVo3) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO PRO_MEMBER (NO, ID, NAME, PWD, GENDER, PHONE, EMAIL, EDUCATION, COUNSEL_TYPE_NO, IMG) VALUES ( SEQ_PRO_MEMBER_NO.NEXTVAL, ? , ? , ? , ? , ? , ? , ? , ? ,?)";
		
		try {
			//전문가 정보
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, proVo1.getId());
			pstmt.setString(2, proVo1.getName());
			pstmt.setString(3, proVo1.getPwd());
			pstmt.setString(4, proVo1.getGender());
			pstmt.setString(5, proVo1.getPhone());
			pstmt.setString(6, proVo1.getEmail());
			pstmt.setString(7, proVo2.getEducation());
			pstmt.setString(8, proVo3.getCounselType());
			//프로필 사진 파일 업로드
			pstmt.setString(9, proVo3.getImg());
			
			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	//전문가 자격정보 + 자격증 첨부파일
	public int projoinlicense(Connection conn, ProJoinPage2Vo proVo2) {
		String prosql = "INSERT INTO CERTIFICATE (NO , PRO_MEMBER_NO , CERTIFICATE_NAME , CERTIFICATE_NUM , IMG_PATH) VALUES ( SEQ_CERTIFICATE_NO.NEXTVAL , (SELECT NO FROM PRO_MEMBER ORDER BY NO DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY) , ? , ? , ? )";

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			//전문가 자격정보
			pstmt = conn.prepareStatement(prosql);
			
			pstmt.setString(1, proVo2.getCertificateName());
			pstmt.setString(2, proVo2.getCertificateNum());
			//전문가 자격증 파일 업로드
			pstmt.setString(3, proVo2.getImgPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	//전문가 로그인
	public ProMemberJoinVo prologin(Connection conn, MemberVo vo) {
		
		String sql = "SELECT P.NO , P.COUNSEL_TYPE_NO , P.ID , P.PWD , P.NAME , P.GENDER , P.PHONE , P.EMAIL , P.EDUCATION , P.PRICE , P.PRO_STATUS , P.IMG , P.JOIN_DATE , P.MODIFY_DATE , P.INTRODUCE , C.NO , C.PRO_MEMBER_NO , C.CERTIFICATE_NAME , C.CERTIFICATE_NUM , C.IMG_PATH FROM PRO_MEMBER P FULL OUTER JOIN CERTIFICATE C ON P.NO = C.NO WHERE ID = ? AND PWD = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProMemberJoinVo proLoginMember = null;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				String price = rs.getString("PRICE");
				String proStatus = rs.getString("PRO_STATUS");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String no = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				String education = rs.getString("EDUCATION");
				String certificateName = rs.getString("CERTIFICATE_NAME");
				String certificateNum = rs.getString("CERTIFICATE_NUM");
				String imgPath = rs.getString("IMG_PATH");
				String proMemberNo = rs.getString("PRO_MEMBER_NO");
				String counselYypeNo = rs.getString("COUNSEL_TYPE_NO");
				String img = rs.getString("IMG");
				String introduce = rs.getString("INTRODUCE");

				proLoginMember = new ProMemberJoinVo();
				proLoginMember.setPrice(price);
				proLoginMember.setProStatus(proStatus);
				proLoginMember.setJoinDate(joinDate);
				proLoginMember.setModifyDate(modifyDate);
				proLoginMember.setNo(no);
				proLoginMember.setId(id);
				proLoginMember.setPwd(pwd);
				proLoginMember.setName(name);
				proLoginMember.setGender(gender);
				proLoginMember.setPhone(phone);
				proLoginMember.setEmail(email);
				proLoginMember.setEducation(education);
				proLoginMember.setCertificateName(certificateName);
				proLoginMember.setCertificateNum(certificateNum);
				proLoginMember.setImgPath(imgPath);
				proLoginMember.setProMemberNo(proMemberNo);
				proLoginMember.setImg(img);
				proLoginMember.setCounselTypeNo(counselYypeNo);;
				proLoginMember.setIntroduce(introduce);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return proLoginMember;
	}
	
	//전문가 아이디 중복 확인
	public boolean proIdDup(Connection conn, String proIdCheck) {
		
		String sql = "SELECT ID FROM MEMBER WHERE ID = ? UNION SELECT ID FROM PRO_MEMBER WHERE ID = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isProIdDup = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, proIdCheck);
			pstmt.setString(2, proIdCheck);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isProIdDup = true; //중복
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rs);
		}
		
		return isProIdDup;
	}

	
}
