package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageFinreserVo;

public class MypageFinreserDao {

	public static List<MypageFinreserVo> selectList(String num, Connection conn) {
		
		String sql="SELECT A.NO AS \"예약번호\" ,A.MEMBER_NO ,A.PRO_NO ,A.ADVICE_DATE ,A.PAY_METHOD ,A.PAY ,A.PAY_DATE ,A.STAR ,M.NAME FROM PRO_APPOINT A FULL OUTER JOIN PRO_MEMBER M  ON A.PRO_NO = M.NO WHERE MEMBER_NO=? AND ADVICE_DATE < SYSDATE";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageFinreserVo> voList = new ArrayList<MypageFinreserVo>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String a_no = rs.getString("예약번호"); 
				String member_no = rs.getString("MEMBER_NO"); 
				String pro_no = rs.getString("PRO_NO"); 
				String advice_date = rs.getString("ADVICE_DATE"); 
				String pay_method = rs.getString("PAY_METHOD"); 
				String pay = rs.getString("PAY"); 
				String pay_date = rs.getString("PAY_DATE"); 
				String star = rs.getString("STAR"); 
				String name = rs.getString("NAME"); 
				
				MypageFinreserVo vo = new MypageFinreserVo();
				vo.setA_no(a_no);
				vo.setMember_no(member_no);
				vo.setPro_no(pro_no);
				vo.setAdvice_date(advice_date);
				vo.setPay_method(pay_method);
				vo.setPay(pay);
				vo.setPay_date(pay_date);
				vo.setStar(star);
				vo.setName(name);
				
				
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

}
