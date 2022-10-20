package com.kh.sseudam.mypage.service;

public class MypageEditService {

//	public MemberVo edit(MemberVo vo) {
//		
//		Connection conn = JDBCTemplate.getConnection();
//		
//		int result = new MemberDao().updateOneByNo(conn, vo);
//		
//		MemberVo updatedMember = null;
//		
//		if(result == 1) {
//			JDBCTemplate.commit(conn);
//			updatedMember = new MemberDao().selectOne(conn, vo);
//			return updatedMember;
//		}else {
//			JDBCTemplate.rollback(conn);
//		}
//		
//		JDBCTemplate.close(conn);
//		return updatedMember;
//	}
}//class
