package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageLikeoutVo;

public class MypageLikeoutDao {

	public static List<MypageLikeoutVo> selectList(String num, Connection conn) {
		
		String sql ="SELECT E.NO ,E.C_NUM ,E.TITLE ,E.\"DATE\" ,E.ADDRESS ,E.PHONE ,E.STRESS ,E.LINK ,E.IMG_PATH ,E.WRITE_DATE ,E.MODIFY_DATE ,E.DELETE_YN FROM OUTSIDE E LEFT JOIN OUTSIDE_LIKE EL ON E.NO = EL.OUTSIDE_NO WHERE EL.MEMBER_NO=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageLikeoutVo> voList = new ArrayList<MypageLikeoutVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO"); 
				String c_num = rs.getString("C_NUM");
				String title = rs.getString("TITLE");
				String date = rs.getString("DATE");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				String stress = rs.getString("STRESS");
				String link = rs.getString("LINK");
				String img_path = rs.getString("IMG_PATH");
				String write_date = rs.getString("WRITE_DATE");
				String modify_date = rs.getString("MODIFY_DATE");
				String delete_yn = rs.getString("DELETE_YN");
				
				MypageLikeoutVo vo = new MypageLikeoutVo();
				vo.setNo(no);
				vo.setC_num(c_num);
				vo.setTitle(title);
				vo.setDate(date);
				vo.setAddress(address);
				vo.setPhone(phone);
				vo.setStress(stress);
				vo.setLink(link);
				vo.setImg_path(img_path);
				vo.setWrite_date(write_date);
				vo.setModify_date(modify_date);
				vo.setDelete_yn(delete_yn);
				
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
