package com.kh.sseudam.admin.pro.service;

import java.sql.Connection;
import java.util.List;

import com.kh.sseudam.admin.member.dao.AdminMemberDao;
import com.kh.sseudam.admin.pro.dao.AdminProDao;
import com.kh.sseudam.admin.pro.vo.ProCounselListVo;
import com.kh.sseudam.common.AttachmentVo;
import com.kh.sseudam.common.JDBCTemplate;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.counsel.pro.vo.CertificateVo;
import com.kh.sseudam.counsel.pro.vo.ProVo;
import com.kh.sseudam.member.vo.MemberVo;

public class AdminProService {

	//모든전문가수 카운트
	public int selectCntAll() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminProDao().selectCntAll(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//모든 전문가 조회
	public List<ProVo> selectListAll(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List proList = new AdminProDao().selectListAll(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	//승인대기전문가수 카운트
	public int selectCntW() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminProDao().selectCntW(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//승인완료전문가수 카운트
	public int selectCntJ() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminProDao().selectCntJ(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//탈퇴전문가수 카운트
	public int selectCntQ() {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminProDao().selectCntQ(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	//승인대기 전문가 조회
	public List<ProVo> selectListW(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List proList = new AdminProDao().selectListW(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	//승인완료 전문가 조회
	public List<ProVo> selectListJ(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List proList = new AdminProDao().selectListJ(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public List<ProVo> selectListQ(PageVo pv) {
		Connection conn = JDBCTemplate.getConnection();
		
		List proList = new AdminProDao().selectListQ(conn, pv);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public int selectCntSearch(String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = new AdminProDao().selectCntSearch(conn, search);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<ProVo> selectListSearch(PageVo pv, String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		List proList = new AdminProDao().selectListSearch(conn, pv, search);
		
		JDBCTemplate.close(conn);
		
		return proList;
	}

	public int insertOne(ProVo vo, AttachmentVo aVo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminProDao().insertOne(conn, vo, aVo);
		
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result; 
	}

	//전문가 1명 개인정보 받아오기
	public ProVo selectOneByNo(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		ProVo vo = new AdminProDao().selectOneByNo(conn, mno);
		
		JDBCTemplate.close(conn);
		
		return vo;
	}

	//전문가 1명의 자격정보 받아오기
	public List<CertificateVo> selectCerByBo(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		List voList=new AdminProDao().selectCerByNo(conn, mno);
		
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public boolean checkNotChange(String no, String id) {
		Connection conn = JDBCTemplate.getConnection();
		
		boolean isNotChange = new AdminProDao().checkNotChange(conn, no, id);
		
		JDBCTemplate.close(conn);
		
		return isNotChange;
	}

	public boolean checkDup(String id) {
		Connection conn = JDBCTemplate.getConnection();
		
		boolean isIdDup = new AdminProDao().checkDup(conn, id);
		
		JDBCTemplate.close(conn);
		
		return isIdDup;
	}

	public int quitOne(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminProDao().quitOne(conn, mno);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public int updateOneWithImg(ProVo vo, AttachmentVo aVo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminProDao().updateOneWithImg(conn, vo, aVo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result; 
	}

	public int updateOneWithoutImg(ProVo vo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminProDao().updateOneWithoutImg(conn, vo);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result; 
	}

	//전문가 승인 update
	public int okOne(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminProDao().okOne(conn, mno);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result; 
	}

	//전문가 승인취소 업데이트
	public int cancelOne(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminProDao().cancelOne(conn, mno);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result; 
	}

	public int insertCerOne(CertificateVo cv, AttachmentVo aVo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminProDao().insertCerOne2(conn, cv, aVo);
		
		if(result == 0) {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result; 
	}

	public int deleteCer(String img) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminProDao().deleteCer(conn, img);
		
		if(result == 0) {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result; 
	}

	//누적수익
	public String getProfit(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		String result = new AdminProDao().getProfit(conn, mno);
		JDBCTemplate.close(conn);
		
		if(result == null) {
			result = "0";
		}
		return result; 
	}

	public String getAvgStar(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		String result = new AdminProDao().getAvgStar(conn, mno);
		JDBCTemplate.close(conn);
		
		if(result == null) {
			result = "평점없음";
		}
		return result; 
	}

	public String getFinishCnt(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		String result = new AdminProDao().getFinishCnt(conn, mno);
		
		JDBCTemplate.close(conn);
		
		return result; 
	}

	public String getWaitCnt(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		String result = new AdminProDao().getWaitCnt(conn, mno);
		
		JDBCTemplate.close(conn);
		
		return result; 
	}

	public List<ProCounselListVo> getCounselList(String mno) {
		Connection conn = JDBCTemplate.getConnection();
		
		List<ProCounselListVo> counselList = new AdminProDao().getCounselList(conn, mno);
		
		JDBCTemplate.close(conn);
		
		return counselList; 
	}

}
