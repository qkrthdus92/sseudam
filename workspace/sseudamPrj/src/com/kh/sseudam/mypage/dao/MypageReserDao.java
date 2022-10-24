package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageReserVo;

public class MypageReserDao {

	public static List<MypageReserVo> selectList(String num, Connection conn) {
		
		String sql="SELECT * FROM PRO_APPOINT A LEFT JOIN PRO_MEMBER M  ON A.PRO_NO = M.NO WHERE MEMBER_NO=? AND ADVICE_DATE >= SYSDATE";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageReserVo> voList = new ArrayList<MypageReserVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO"); 
				String member_no = rs.getString("MEMBER_NO"); 
				String pro_no = rs.getString("PRO_NO"); 
				String advice_date = rs.getString("ADVICE_DATE");
				String pay_method = rs.getString("PAY_METHOD");
				String pay = rs.getString("PAY");
				String pay_date = rs.getString("PAY_DATE");
				String star = rs.getString("STAR");
//				String no_1 = rs.getString("NO_1");//프로멤버의NO이랑 APPOINT의 NO이랑 칼럼명 중복되서 NO_1로 칼럼명이 자동지정된건데 이게 문제인지... ?
				String counsel_type_no = rs.getString("COUNSEL_TYPE_NO"); 
				String id = rs.getString("ID"); 
				String pwd = rs.getString("PWD"); 
				String name = rs.getString("NAME"); 
				String gender = rs.getString("GENDER"); 
				String phone = rs.getString("PHONE"); 
				String email = rs.getString("EMAIL"); 
				String education = rs.getString("EDUCATION"); 
				String price = rs.getString("PRICE"); 
				String pro_status = rs.getString("PRO_STATUS"); 
				String img = rs.getString("IMG"); 
				String join_date = rs.getString("JOIN_DATE"); 
				String modify_date = rs.getString("MODIFY_DATE"); 
				String introduce = rs.getString("INTRODUCE"); 

				
				
				MypageReserVo vo = new MypageReserVo();
				vo.setNo(no);
				vo.setMember_no(member_no);
				vo.setPro_no(pro_no);
				vo.setAdvice_date(advice_date);
				vo.setPay_method(pay_method);
				vo.setPay(pay);
				vo.setPay_date(pay_date);
				vo.setStar(star);
//				vo.setNo_1(no_1);
				vo.setCounsel_type_no(counsel_type_no);
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setGender(gender);
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setEducation(education);
				vo.setPrice(price);
				vo.setPro_status(pro_status);
				vo.setImg(img);
				vo.setJoin_date(join_date);
				vo.setModify_date(modify_date);
				vo.setIntroduce(introduce);
				
				
				voList.add(vo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return voList;
		
	}

	//상세조회
	public static MypageReserVo selectReserOne(Connection conn, String no, String num) {
		
		String sql="SELECT A.NO AS \"예약번호\" ,A.MEMBER_NO ,A.PRO_NO ,A.ADVICE_DATE ,A.PAY_METHOD ,A.PAY ,A.PAY_DATE ,A.STAR ,M.NAME ,M.PHONE ,M.EMAIL ,M.INTRODUCE ,M.COUNSEL_TYPE_NO FROM PRO_APPOINT A FULL OUTER JOIN PRO_MEMBER M  ON A.PRO_NO = M.NO WHERE A.MEMBER_NO=? AND A.NO=? AND ADVICE_DATE >= SYSDATE";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MypageReserVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String a_no = rs.getString("예약번호"); 
				String member_no = rs.getString("MEMBER_NO"); 
				String pro_no = rs.getString("PRO_NO"); 
				String advice_date = rs.getString("ADVICE_DATE");
				String pay_method = rs.getString("PAY_METHOD");
				String pay = rs.getString("PAY");
				String pay_date = rs.getString("PAY_DATE");
				String star = rs.getString("STAR");
				String name = rs.getString("NAME"); 
				String phone = rs.getString("PHONE"); 
				String email = rs.getString("EMAIL"); 
				String introduce = rs.getString("INTRODUCE"); 
				String counsel_type_no = rs.getString("COUNSEL_TYPE_NO"); 
				
				vo = new MypageReserVo();
				
				
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
