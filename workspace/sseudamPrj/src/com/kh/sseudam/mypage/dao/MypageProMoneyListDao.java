package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageProMoneyListVo;
import com.kh.sseudam.mypage.board.vo.MypageProreserVo;

public class MypageProMoneyListDao {

	public static List<MypageProMoneyListVo> selectList(String num, Connection conn, PageVo pv) {
		
		String sql="SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM(SELECT PA.NO ,PA.MEMBER_NO ,PA.PRO_NO ,PA.ADVICE_DATE ,PA.PAY_METHOD ,PA.PAY ,PA.PAY_DATE ,PA.STAR ,M.NAME ,M.PHONE FROM PRO_APPOINT PA LEFT JOIN MEMBER M ON PA.MEMBER_NO = M.NO WHERE PRO_NO =?ORDER BY PA.PRO_NO ,PA.ADVICE_DATE)T) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageProMoneyListVo> voList = new ArrayList<MypageProMoneyListVo>();

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
				
				MypageProMoneyListVo vo = new MypageProMoneyListVo();
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

	//갯수조회
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
	//금액합계 조회
	public static List<MypageProMoneyListVo> paySum(Connection conn, String num) {
		
		String sql="SELECT * FROM (SELECT PA.NO ,PA.MEMBER_NO ,PA.PRO_NO ,PA.ADVICE_DATE ,PA.PAY_METHOD ,SUM(PA.PAY) OVER(ORDER BY PA.MEMBER_NO)AS PAY_SUM ,PA.PAY_DATE ,PA.STAR ,M.NAME ,M.PHONE FROM PRO_APPOINT PA LEFT JOIN MEMBER M ON PA.MEMBER_NO = M.NO WHERE PRO_NO =? ORDER BY ROWNUM DESC) WHERE ROWNUM = 1";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageProMoneyListVo> voList = new ArrayList<MypageProMoneyListVo>();
		
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
				String pay_sum = rs.getString("PAY_SUM");
				String pay_date = rs.getString("PAY_DATE");
				String star = rs.getString("STAR");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				
				MypageProMoneyListVo vo = new MypageProMoneyListVo();
				vo.setNo(no);
				vo.setMember_no(member_no);
				vo.setPro_no(pro_no);
				vo.setAdvice_date(advice_date);
				vo.setPay_method(pay_method);
				vo.setPay_sum(pay_sum);
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

	public static int updatesum(String withdrawbal, String num, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		String sql="SELECT PAY_SUM -? AS WITHDRAW FROM (SELECT * FROM (SELECT PA.NO ,PA.MEMBER_NO ,PA.PRO_NO ,PA.ADVICE_DATE ,PA.PAY_METHOD ,SUM(PA.PAY) OVER(ORDER BY PA.MEMBER_NO)AS PAY_SUM ,PA.PAY_DATE ,PA.STAR ,M.NAME ,M.PHONE FROM PRO_APPOINT PA LEFT JOIN MEMBER M ON PA.MEMBER_NO = M.NO WHERE PRO_NO =? ORDER BY ROWNUM DESC) WHERE ROWNUM = 1)";
		System.out.println("다오 넘어옴");//출력됨
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,withdrawbal);
			pstmt.setString(2,num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("withdraw");
				System.out.println(result);// 출력안됨
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
}
