package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageFinreserVo;
import com.kh.sseudam.mypage.board.vo.MypageReserVo;
import com.kh.sseudam.mypage.dao.MypageEditDao;
import com.kh.sseudam.mypage.dao.MypageFinreserDao;
import com.kh.sseudam.mypage.dao.MypageReserDao;

public class MypageFinreserService {

	public List<MypageFinreserVo> selectList(PageVo pv,String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageFinreserVo> selectList = MypageFinreserDao.selectList(num,conn,pv);
		
		JDBCTemplate.close(conn);
		
		return selectList;
	}
	
	//예약 갯수 조회
	public int selectCount(String num) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageFinreserDao.selectCount(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//별점주기
	public int updateStar(MypageFinreserVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageFinreserDao.updateStar(vo,conn);
		
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}	

}
