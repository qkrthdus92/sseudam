package com.kh.sseudam.mypage.service;

import java.sql.Connection;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.dao.MemberDao;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.mypage.dao.MypageEditDao;

public class MypageEditService {

	//일반회원정보수정
	public MemberVo edit(MemberVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MypageEditDao().updateOneByNo(conn, vo);
		
		MemberVo updatedMember = null;
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
			updatedMember = new MypageEditDao().selectOne(conn, vo);
			return updatedMember;
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return updatedMember;
	}
	
	//프로회원정보수정
	public ProVo proedit(ProVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MypageEditDao().proUpdateOneByNo(conn, vo);
		
		ProVo updatedMember = null;
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
			updatedMember = new MypageEditDao().proSelectOne(conn, vo);
			return updatedMember;
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return updatedMember;
		
	}
	
}//class
