package temp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLoginController extends HttpServlet{

	//테스트용 로그인멤버
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVo vo = new MemberVo();
		vo.setId("bk5991");
		vo.setPwd("1234");
		
		MemberVo loginMember = new MemberService().login(vo);
		
		if(loginMember != null) {
			//로그인 성공
			HttpSession s = req.getSession();
			s.setAttribute("loginMember", loginMember);
		} else {
			//로그인 실패
			req.setAttribute("msg", "로그인실패");
		}
	}
}
