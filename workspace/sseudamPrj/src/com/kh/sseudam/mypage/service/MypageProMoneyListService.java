package com.kh.sseudam.mypage.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.mypage.board.vo.MypageProMoneyListVo;
import com.kh.sseudam.mypage.dao.MypageEditDao;
import com.kh.sseudam.mypage.dao.MypageProMoneyListDao;
import com.kh.sseudam.mypage.dao.MypageProreserDao;

public class MypageProMoneyListService {

	public List<MypageProMoneyListVo> selectList(PageVo pv, String num) {
		Connection conn = JDBCTemplate.getConnection();

		List<MypageProMoneyListVo> selectList = MypageProMoneyListDao.selectList(num,conn,pv);

		JDBCTemplate.close(conn);
		
		return selectList;
		
	}

	//갯수조회
	public int selectCount(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = MypageProMoneyListDao.selectCount(conn,num);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//금액합계 조회
	public List<MypageProMoneyListVo> paysum(String num) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<MypageProMoneyListVo> sum = MypageProMoneyListDao.paySum(conn,num);
		
		JDBCTemplate.close(conn);
		
		return sum;
	}

	//출금하가(총액 수정)
	public int withdraw(String num, String withdrawbal) {
		
		Connection conn = JDBCTemplate.getConnection();

		int updatesum = MypageProMoneyListDao.updatesum(num,withdrawbal,conn);

		JDBCTemplate.close(conn);
		
		return updatesum;
	}

}
