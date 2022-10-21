package temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.sseudam.common.JDBCTemplate;

public class MemberDao {

	public MemberVo selectOne(Connection conn, MemberVo vo) {

		// 테스트용 로그인멤버
		String sql = "SELECT NO ,ID ,PWD ,NAME ,NICK ,PHONE ,EMAIL ,TEST_SCORE ,JOIN_DATE ,QUIT_YN ,MODIFY_DATE FROM MEMBER WHERE ID='bk5991' AND PWD='1234'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVo loginMember = null;

		try {
			if (rs.next()) {
				int no = rs.getInt("NO");
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String nick = rs.getString("NICK");
				String phone = rs.getString("PHONE");
				String email = rs.getString("EMAIL");
				int testScore = rs.getInt("TEST_SCORE");

				loginMember = new MemberVo();
				loginMember.setNo(no);
				loginMember.setId(id);
				loginMember.setPwd(pwd);
				loginMember.setName(name);
				loginMember.setNick(nick);
				loginMember.setPhone(phone);
				loginMember.setEmail(email);
				loginMember.setTestScore(testScore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return loginMember;
	}

	//테스트점수 회원정보 저장
	public int myScore(Connection conn, MemberVo vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE MEMBER SET TEST_SCORE = ? WHERE ID = 'bk5991'";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getTestScore());
			//pstmt.setString(2, vo.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
}
