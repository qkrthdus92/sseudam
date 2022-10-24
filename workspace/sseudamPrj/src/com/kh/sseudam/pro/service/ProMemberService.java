package com.kh.sseudam.pro.service;

import java.sql.Connection;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.pro.dao.ProDao;
import com.kh.sseudam.pro.join.vo.ProJoinPage1Vo;
import com.kh.sseudam.pro.join.vo.ProJoinPage2Vo;
import com.kh.sseudam.pro.join.vo.ProJoinPage3Vo;

public class ProMemberService {

	public int projoin(ProJoinPage1Vo page1vo, ProJoinPage2Vo page2vo, ProJoinPage3Vo page3vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ProDao prodao = new ProDao();
		int result = prodao.proInsertOne(conn, page1vo, page2vo, page3vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int projoinlicense(ProJoinPage2Vo page2vo) {

		Connection conn = JDBCTemplate.getConnection();
		
		ProDao prodao = new ProDao();
		int result = prodao.projoinlicense(conn, page2vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
		


}
