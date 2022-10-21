package temp;

import java.sql.Connection;

import com.kh.sseudam.common.JDBCTemplate;

public class MemberService {

	public MemberVo login(MemberVo vo) {

		Connection conn = JDBCTemplate.getConnection();
		MemberVo loginMember = new MemberDao().selectOne(conn, vo);
		JDBCTemplate.close(conn);
		
		return loginMember;

	}

}
