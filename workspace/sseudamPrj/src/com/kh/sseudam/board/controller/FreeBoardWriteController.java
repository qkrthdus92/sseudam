package com.kh.sseudam.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.board.service.FreeBoardService;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/board/freeBoardWrite")
public class FreeBoardWriteController extends HttpServlet{
	
	//자유게시판 게시글 작성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//로그인여부 확인
		if(req.getSession().getAttribute("loginMember") == null){
			req.setAttribute("msg", "로그인 후 이용해주세요.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			return;
		}		
	
		//화면선택
		req.getRequestDispatcher("/views/board/freeBoard/freeBoardWrite.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//인코딩
		req.setCharacterEncoding("UTF-8");

		//로그인멤버 가져오기
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		System.out.println(loginMember);
				
		//데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		//데이터 뭉치기
		FreeBoardVo vo = new FreeBoardVo();
		vo.setWriterNo(loginMember.getNo());
		vo.setTitle(title);
		vo.setContent(content);
		
		//디비 다녀오기
		int result = FreeBoardService.write(vo);
		
		//화면선택
		if(result ==1) {
			//게시글 작성 성공 => 알람 + 게시글 목록 1번페이지로 이동
			s.setAttribute("alertMsg", "게시글 등록이 완료되었습니다.");
			resp.sendRedirect("/sseudam/board/freeBoardList?pno=1");
		}else {
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}
