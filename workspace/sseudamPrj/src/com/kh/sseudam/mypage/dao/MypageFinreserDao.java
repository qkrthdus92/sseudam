package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageFinreserVo;

public class MypageFinreserDao {

	public static List<MypageFinreserVo> selectList(String num, Connection conn, PageVo pv) {
		
		String sql="SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM(SELECT A.NO AS \"예약번호\" ,A.MEMBER_NO ,A.PRO_NO ,A.ADVICE_DATE ,A.PAY_METHOD ,A.PAY ,A.PAY_DATE ,A.STAR ,M.NAME, M.IMG FROM PRO_APPOINT A FULL OUTER JOIN PRO_MEMBER M  ON A.PRO_NO = M.NO WHERE MEMBER_NO=? AND ADVICE_DATE < SYSDATE)T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageFinreserVo> voList = new ArrayList<MypageFinreserVo>();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pv.getCurrentPage() - 1) * pv.getBoardLimit() + 1 ;
			int end = start + pv.getBoardLimit() - 1;
			
			pstmt.setString(1, num);
			pstmt.setInt(2,start);
			pstmt.setInt(3, end);
			
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
				String img = rs.getString("IMG"); 
				
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
				vo.setImg(img);
				
				
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

	public static int selectCount(Connection conn, String num) {
		
		
		//SQL
		String sql ="SELECT COUNT(*) AS CNT FROM (SELECT A.NO AS \"예약번호\" ,A.MEMBER_NO ,A.PRO_NO ,A.ADVICE_DATE ,A.PAY_METHOD ,A.PAY ,A.PAY_DATE ,A.STAR ,M.NAME FROM PRO_APPOINT A FULL OUTER JOIN PRO_MEMBER M  ON A.PRO_NO = M.NO WHERE MEMBER_NO=? AND ADVICE_DATE < SYSDATE)";
		
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

	//별점업데이트
	public static int updateStar(MypageFinreserVo vo, Connection conn) {
		
		
		String sql="UPDATE PRO_APPOINT SET STAR = ? WHERE NO = ? AND MEMBER_NO=?";
	
		PreparedStatement pstmt = null;
	    int result = 0;
	    
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, vo.getStar());
	        pstmt.setString(2, vo.getA_no());
	        pstmt.setString(3, vo.getMember_no());
	        
	        result = pstmt.executeUpdate();
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {            
	        JDBCTemplate.close(pstmt);
	    }
	    return result;
	
	}


}
