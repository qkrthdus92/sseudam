package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.mypage.board.vo.MypageFinreserVo;
import com.kh.sseudam.mypage.board.vo.MypageProreserVo;
import com.kh.sseudam.mypage.service.MypageEditService;
import com.kh.sseudam.pro.vo.ProMemberJoinVo;

@WebServlet(urlPatterns = "/mypage/starupdate")
public class MypageProStarController extends HttpServlet {

	//
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		
		ProMemberJoinVo proLoginMember = (ProMemberJoinVo)s.getAttribute("proLoginMember"); // proLoginMember
		
		String num = proLoginMember.getNo();

		System.out.println(num);  //확인용
		
		String updatestar =new MypageEditService().updatestar(num);
		
		
		
		System.out.println(updatestar); //확인용
		
		req.setAttribute("updatestar", updatestar);
		req.getRequestDispatcher("/views/mypage/promain.jsp").forward(req, resp);

		
	}
}
