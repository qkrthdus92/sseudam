package com.kh.sseudam.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageLikeVo;

public class MypageLikeDao {
//혼자서냠냠 좋아요 조회
public static List<MypageLikeVo> selectList(String num, Connection conn,PageVo pv) {
		
		String sql ="SELECT * FROM ( SELECT ROWNUM AS RNUM, T.* FROM(SELECT E.NO ,E.C_NUM ,E.NAME ,E.ADDRESS ,E.PHONE ,E.LINK ,E.IMG_PATH ,E.WRITE_DATE ,E.MODIFY_DATE ,E.DELETE_YN FROM EAT_ALONE E LEFT JOIN EAT_LIKE EL ON E.NO = EL.EAT_ALONE_NO WHERE EL.MEMBER_NO=?)T ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MypageLikeVo> voList = new ArrayList<MypageLikeVo>();

		
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
//상세조회
public static MypageLikeVo selectLikeOne(Connection conn, String no) {
	
	String sql="SELECT E.NO ,E.C_NUM ,E.NAME ,E.ADDRESS ,E.PHONE ,E.LINK ,E.IMG_PATH ,E.WRITE_DATE ,E.MODIFY_DATE ,E.DELETE_YN FROM EAT_ALONE E LEFT JOIN EAT_LIKE EL ON E.NO = EL.EAT_ALONE_NO WHERE E.NO=?";
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MypageLikeVo vo = null;
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, no);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String num = rs.getString("NO"); 
			String c_num = rs.getString("C_NUM"); 
			String name = rs.getString("NAME");
			String address = rs.getString("ADDRESS");
			String phone = rs.getString("PHONE");
			String link = rs.getString("LINK");
			String img_path = rs.getString("IMG_PATH");
			String write_date = rs.getString("WRITE_DATE");
			String modify_date = rs.getString("MODIFY_DATE");
			String delete_yn = rs.getString("DELETE_YN");

			vo = new MypageLikeVo();
			vo.setNo(num);
			vo.setC_num(c_num);
			vo.setName(name);
			vo.setAddress(address);
			vo.setPhone(phone);
			vo.setLink(link);
			vo.setImg_path(img_path);
			vo.setWrite_date(write_date);
			vo.setDelete_yn(delete_yn);
			vo.setModify_date(modify_date);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(rs);
		JDBCTemplate.close(pstmt);
	}
	
	return vo;
	

}
//삭제
public static int delete(Connection conn, String no) {
	
	String sql="DELETE FROM EAT_LIKE WHERE EAT_ALONE_NO =? ";
	
	
	PreparedStatement pstmt = null;
    int result = 0;

    try {
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, no);
        
        result = pstmt.executeUpdate();
     
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {            
        JDBCTemplate.close(pstmt);
    }
    return result;
    
    
}
//겟수조회
public static int selectCount(Connection conn, String num) {
	
	String sql ="SELECT COUNT(*) AS CNT FROM (SELECT E.NO ,E.C_NUM ,E.NAME ,E.ADDRESS ,E.PHONE ,E.LINK ,E.IMG_PATH ,E.WRITE_DATE ,E.MODIFY_DATE ,E.DELETE_YN FROM EAT_ALONE E LEFT JOIN EAT_LIKE EL ON E.NO = EL.EAT_ALONE_NO WHERE EL.MEMBER_NO=?)";

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
