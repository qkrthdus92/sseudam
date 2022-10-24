package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageAllreserVo;
import com.kh.sseudam.mypage.board.vo.MypageBoardVo;

public class MypageAllreserDao {

	public static List<MypageAllreserVo> selectList(String num, Connection conn) {
		
		String sql = "SELECT * FROM PRO_APPOINT WHERE MEMBER_NO=?";
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageAllreserVo> voList = new ArrayList<MypageAllreserVo>();
		
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
			
				
				MypageAllreserVo vo = new MypageAllreserVo();
				vo.setNo(no);
				vo.setMember_no(member_no);
				vo.setPro_no(pro_no);
				vo.setAdvice_date(advice_date);
				vo.setPay(pay);
				vo.setPay_date(pay_date);
				vo.setStar(star);
				
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