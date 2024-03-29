package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageProreserVo;
import com.kh.sseudam.mypage.board.vo.MypageReserVo;

public class MypageProreserDao {

	public static List<MypageProreserVo> selectList(String num, Connection conn,PageVo pv) {
		
		String sql="SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM(SELECT PA.NO ,PA.MEMBER_NO ,PA.PRO_NO ,PA.ADVICE_DATE ,PA.PAY_METHOD ,PA.PAY ,PA.PAY_DATE ,PA.STAR ,M.NAME ,M.PHONE FROM PRO_APPOINT PA LEFT JOIN MEMBER M ON PA.MEMBER_NO = M.NO WHERE PRO_NO =?)T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageProreserVo> voList = new ArrayList<MypageProreserVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1 ;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setString(1, num);
			pstmt.setInt(2,start);
			pstmt.setInt(3, end);
			
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
				String name = rs.getString("NAME"); 
				String phone = rs.getString("PHONE"); 
				
				MypageProreserVo vo = new MypageProreserVo();
				vo.setNo(no);
				vo.setMember_no(member_no);
				vo.setPro_no(pro_no);
				vo.setAdvice_date(advice_date);
				vo.setPay_method(pay_method);
				vo.setPay(pay);
				vo.setPay_date(pay_date);
				vo.setStar(star);
				vo.setName(name);
				vo.setPhone(phone);
				
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

	//갯수 조회
	public static int selectCount(Connection conn, String num) {
		
		String sql="SELECT COUNT(*) AS CNT FROM(SELECT PA.NO ,PA.MEMBER_NO ,PA.PRO_NO ,PA.ADVICE_DATE ,PA.PAY_METHOD ,PA.PAY ,PA.PAY_DATE ,PA.STAR ,M.NAME ,M.PHONE FROM PRO_APPOINT PA LEFT JOIN MEMBER M ON PA.MEMBER_NO = M.NO WHERE PRO_NO =?)";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("CNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

}
