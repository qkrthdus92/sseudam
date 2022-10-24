package com.kh.sseudam.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.pro.vo.ProJoinPage1Vo;
import com.kh.sseudam.pro.vo.ProJoinPage2Vo;
import com.kh.sseudam.pro.vo.ProJoinPage3Vo;

public class ProDao {

	public int proInsertOne(Connection conn, ProJoinPage1Vo page1vo, ProJoinPage2Vo page2vo, ProJoinPage3Vo page3vo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "INSERT INTO PRO_MEMBER (NO, ID, NAME, PWD, GENDER, PHONE, EMAIL, EDUCATION, COUNSEL_TYPE_NO) VALUES ( SEQ_PRO_MEMBER_NO.NEXTVAL, ? , ? , ? , ? , ? , ? , ? , ? )";
		
		try {
			//전문가 정보
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, page1vo.getId());
			pstmt.setString(2, page1vo.getName());
			pstmt.setString(3, page1vo.getPwd());
			pstmt.setString(4, page1vo.getGender());
			pstmt.setString(5, page1vo.getPhone());
			pstmt.setString(6, page1vo.getEmail());
			pstmt.setString(7, page2vo.getEducation());
			pstmt.setString(8, page3vo.getCounselType());
			
			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int projoinlicense(Connection conn, ProJoinPage2Vo page2vo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String prosql = "INSERT INTO CERTIFICATE VALUES ( SEQ_CERTIFICATE_NO.NEXTVAL , (SELECT NO FROM PRO_MEMBER ORDER BY NO DESC OFFSET 0 ROWS FETCH NEXT 1 ROWS ONLY) , ? , ? , ? )";
		
		try {
			
			//전문가 자격정보
			pstmt = conn.prepareStatement(prosql);
			
			pstmt.setString(1, page2vo.getCertificateName());
			pstmt.setString(2, page2vo.getCertificateNum());
			pstmt.setString(3, page2vo.getImgPath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public ProJoinPage1Vo prologin(Connection conn, ProJoinPage1Vo page1vo) {
		
		String sql = "SELECT P.NO , P.COUNSEL_TYPE_NO , P.ID , P.PWD , P.NAME , P.GENDER , P.PHONE , P.EMAIL , P.EDUCATION , P.PRICE , P.PRO_STATUS , P.IMG , P.JOIN_DATE , P.MODIFY_DATE , P.INTRODUCE , C.NO , C.PRO_MEMBER_NO , C.CERTIFICATE_NAME , C.CERTIFICATE_NUM , C.IMG_PATH FROM PRO_MEMBER P FULL OUTER JOIN CERTIFICATE C ON P.NO = C.NO WHERE ID = ? AND PWD = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProJoinPage1Vo prologinpage1 = null;
		ProJoinPage2Vo prologinpage2 = null;
		ProJoinPage3Vo prologinpage3 = null;
		ProVo provo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, page1vo.getId());
			pstmt.setString(2, page1vo.getPwd());
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				//provo
				String price = rs.getString("PRICE");
				String proStatus = rs.getString("PRO_STATUS");
				String joinDate = rs.getString("JOIN_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				
				//prologinpage1
				String no = rs.getString("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				
				//prologinpage2
				String education = rs.getString("EDUCATION");
				String certificateName = rs.getString("CERTIFICATE_NAME");
				String certificateNum = rs.getString("CERTIFICATE_NUM");
				String imgPath = rs.getString("IMG_PATH");
				String proMemberNo = rs.getString("PRO_MEMBER_NO");
				

				//prologinpage3
				String counselYypeNo = rs.getString("COUNSEL_TYPE_NO");
				String img = rs.getString("IMG");
				String introduce = rs.getString("INTRODUCE");

				
				provo = new ProVo();
				provo.setPrice(price);
				provo.setProStatus(proStatus);
				provo.setJoinDate(joinDate);
				provo.setModifyDate(modifyDate);
				
				
				prologinpage1 = new ProJoinPage1Vo();
				prologinpage1.setNo(no);
				prologinpage1.setId(id);
				prologinpage1.setPwd(pwd);
				prologinpage1.setName(name);
				prologinpage1.setGender(gender);
				prologinpage1.setPhone(phone);
				prologinpage1.setEmail(email);
				
				prologinpage2 = new ProJoinPage2Vo();
				prologinpage2.setEducation(education);
				prologinpage2.setCertificateName(certificateName);
				prologinpage2.setCertificateNum(certificateNum);
				prologinpage2.setImgPath(imgPath);
				prologinpage2.setProMemberNo(proMemberNo);
				
				prologinpage3 = new ProJoinPage3Vo();
				prologinpage3.setImg(img);
				prologinpage3.setCounselType(counselYypeNo);
				prologinpage3.setIntroduce(introduce);

			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return prologinpage1;
		
	}
	
}
