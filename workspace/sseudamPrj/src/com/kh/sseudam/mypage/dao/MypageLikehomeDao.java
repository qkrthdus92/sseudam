package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeoutVo;
import com.kh.sseudam.mypage.board.vo.MypageLikehomeVo;

public class MypageLikehomeDao {

	public static List<MypageLikehomeVo> selectList(String num, Connection conn) {
		
		String sql="SELECT E.NO ,E.C_NUM ,E.TITLE ,E.INFO_A ,E.INFO_B ,E.STRESS ,E.LINK ,E.IMG_PATH ,E.WRITE_DATE ,E.MODIFY_DATE ,E.DELETE_YN FROM INSIDE E LEFT JOIN INSIDE_LIKE EL ON E.NO = EL.INSIDE_NO WHERE EL.MEMBER_NO=?";
	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageLikehomeVo> voList = new ArrayList<MypageLikehomeVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("NO"); 
				String c_num = rs.getString("C_NUM");
				String title = rs.getString("TITLE");
				String info_a = rs.getString("INFO_A");
				String info_b = rs.getString("INFO_B");
				String stress = rs.getString("STRESS");
				String link = rs.getString("LINK");
				String img_path = rs.getString("IMG_PATH");
				String write_date = rs.getString("WRITE_DATE");
				String modify_date = rs.getString("MODIFY_DATE");
				String delete_yn = rs.getString("DELETE_YN");


				MypageLikehomeVo vo = new MypageLikehomeVo();
				vo.setNo(no);
				vo.setC_num(c_num);
				vo.setTitle(title);
				vo.setInfo_a(info_a);
				vo.setInfo_b(info_b);
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
