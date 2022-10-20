package com.kh.sseudam.counsel.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.counsel.dao.CounselDao;
import com.kh.sseudam.counsel.pro.vo.ProVo;

public class CounselService {

	//상담하기 : 전문가 목록 조회
	public List<ProVo> selectList() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProVo> proList = new CounselDao().selectList(conn);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

}
