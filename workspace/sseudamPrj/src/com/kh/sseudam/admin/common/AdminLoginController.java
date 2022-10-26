package com.kh.sseudam.admin.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/admin/login")
public class AdminLoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/admin/common/login.jsp").forward(req, resp);;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		AdminVo vo = new AdminVo();
		vo.setId(id);
		vo.setPwd(pwd);
		
		AdminVo loginAdmin = new AdminService().login(vo);
		
		if(loginAdmin != null) {
			req.getSession().setAttribute("loginAdmin", loginAdmin);
			resp.sendRedirect("/sseudam/admin/member/list?pno=1&quitYn=both");
		}else {
			req.setAttribute("msg", "관리자로그인실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
	}
}
