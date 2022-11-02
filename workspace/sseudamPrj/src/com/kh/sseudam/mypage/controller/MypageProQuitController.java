/*
 * package com.kh.sseudam.mypage.controller;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import com.kh.sseudam.member.vo.MemberVo; import
 * com.kh.sseudam.mypage.service.MypageEditService; import
 * com.kh.sseudam.pro.vo.ProMemberJoinVo;
 * 
 * @WebServlet(urlPatterns = "/mypage/proquit") public class
 * MypageProQuitController extends HttpServlet{
 * 
 * @Override protected void doGet(HttpServletRequest req, HttpServletResponse
 * resp) throws ServletException, IOException {
 * 
 * HttpSession s = req.getSession();
 * 
 * //데이터꺼내기 ProMemberJoinVo proLoginMember =
 * (ProMemberJoinVo)s.getAttribute("proLoginMember"); String no =
 * proLoginMember.getNo();
 * 
 * int result = new MypageEditService().proquit(no);
 * 
 * if(result ==1) { s.invalidate();
 * resp.setContentType("text/html; charset=UTF-8");
 * req.getSession().setAttribute("alertMsg", "회원탈퇴완료");
 * resp.sendRedirect("/sseudam/main"); }
 * 
 * }
 * 
 * 
 * }
 */
