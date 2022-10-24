package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;

public class MypageLikeDao {

public static List<MypageLikeVo> selectList(String num, Connection conn) {
		
		String sql ="SELECT E.NO ,E.C_NUM ,E.NAME ,E.ADDRESS ,E.PHONE ,E.LINK ,E.IMG_PATH ,E.WRITE_DATE ,E.MODIFY_DATE ,E.DELETE_YN FROM EAT_ALONE E LEFT JOIN EAT_LIKE EL ON E.NO = EL.EAT_ALONE_NO WHERE EL.MEMBER_NO=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageLikeVo> voList = new ArrayList<MypageLikeVo>();

		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO"); 
				String c_num = rs.getString("C_NUM"); 
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				String phone = rs.getString("PHONE");
				String link = rs.getString("LINK");
				String img_path = rs.getString("IMG_PATH");
				String write_date = rs.getString("WRITE_DATE");
				String modify_date = rs.getString("MODIFY_DATE");
				String delete_yn = rs.getString("DELETE_YN");

				MypageLikeVo vo = new MypageLikeVo();
				vo.setNo(no);
				vo.setC_num(c_num);
				vo.setName(name);
				vo.setAddress(address);
				vo.setPhone(phone);
				vo.setLink(link);
				vo.setImg_path(img_path);
				vo.setWrite_date(write_date);
				vo.setDelete_yn(delete_yn);
				vo.setModify_date(modify_date);
				
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
