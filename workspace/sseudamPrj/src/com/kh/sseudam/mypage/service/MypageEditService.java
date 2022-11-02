package com.kh.sseudam.mypage.service;

import java.sql.Connection;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.dao.MemberDao;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.mypage.board.vo.MypageFinreserVo;
import com.kh.sseudam.mypage.dao.MypageEditDao;
import com.kh.sseudam.pro.dao.ProDao;
import com.kh.sseudam.pro.vo.ProMemberJoinVo;

public class MypageEditService {

	//일반회원정보수정
	public MemberVo edit(MemberVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MypageEditDao().updateOneByNo(conn, vo);
		
		MemberVo updatedMember = null;
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
			updatedMember = new MypageEditDao().selectOne(conn, vo);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return updatedMember;
	}
	
	//프로회원정보수정
	public ProMemberJoinVo proedit(ProMemberJoinVo vo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MypageEditDao().proUpdateOneByNo(conn, vo);
		
		ProMemberJoinVo updatedMember = null;
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
			updatedMember = new MypageEditDao().proSelectOne(conn, vo);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		JDBCTemplate.close(conn);
		return updatedMember;
		
	}

	//별점 평균 조회
	public String updatestar(String num) {
		
		System.out.println("service넘어옴");
		
		Connection conn = JDBCTemplate.getConnection();
		
		String result = new MypageEditDao().proUpdateStar(conn, num);
		
		System.out.println(result);//확인용
		
		if(result != null) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		
		return result;
		
		
	}

	//회원탈퇴
	public int quit(String no) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result= new MypageEditDao().quit(conn, no);
		
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	
	
	}

	//전문가회원 탈퇴
	public int proquit(String no) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result= new MypageEditDao().proquit(conn, no);
		
		if(result ==1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	
		
	}

	/*
	 * //프로필 사진 첨부 public int profileUpload(ProMemberJoinVo vo) {
	 * 
	 * Connection conn = JDBCTemplate.getConnection();
	 * 
	 * 
	 * int result = MypageEditDao.imgUpdate(conn,vo);
	 * 
	 * if(result == 1) { JDBCTemplate.commit(conn); }else {
	 * JDBCTemplate.rollback(conn); }
	 * 
	 * JDBCTemplate.close(conn);
	 * 
	 * return result; }
	 */
	
}//class
