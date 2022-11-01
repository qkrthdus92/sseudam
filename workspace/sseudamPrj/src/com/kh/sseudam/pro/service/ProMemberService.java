package com.kh.sseudam.pro.service;

import java.sql.Connection;

import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.counsel.pro.vo.CertificateVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.dao.MemberDao;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.pro.dao.ProDao;
import com.kh.sseudam.pro.vo.ProJoinPage1Vo;
import com.kh.sseudam.pro.vo.ProJoinPage2Vo;
import com.kh.sseudam.pro.vo.ProJoinPage3Vo;
import com.kh.sseudam.pro.vo.ProMemberJoinVo;

public class ProMemberService {

	//회원가입
	public int projoin(ProJoinPage1Vo proVo1, ProJoinPage2Vo proVo2, ProJoinPage3Vo proVo3) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ProDao prodao = new ProDao();
		int result = prodao.proInsertOne(conn, proVo1, proVo2, proVo3);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	//자격증 첨부파일
	public int projoinlicense(CertificateVo cv, ProJoinPage2Vo proVo2) {

		Connection conn = JDBCTemplate.getConnection();
		
		ProDao prodao = new ProDao();
		int result = prodao.projoinlicense(conn, cv, proVo2);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	//프로필 첨부파일
	public int profileimg(ProJoinPage3Vo proVo3) {

		Connection conn = JDBCTemplate.getConnection();
		
		ProDao prodao = new ProDao();
		int result = prodao.proInsertOne(conn, null, null, proVo3);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	//로그인
	public ProMemberJoinVo prologin(MemberVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		ProMemberJoinVo proMemberLogin = new ProDao().prologin(conn, vo);
		JDBCTemplate.close(conn);
		
		return proMemberLogin;
	}		

	//전문가 아이디 중복 확인
	public boolean proIdDup(String proIdCheck) {
		Connection conn = JDBCTemplate.getConnection();
		boolean isProIdDup = new ProDao().proIdDup(conn, proIdCheck);
		JDBCTemplate.close(conn);
		return isProIdDup;
	}
	
}
