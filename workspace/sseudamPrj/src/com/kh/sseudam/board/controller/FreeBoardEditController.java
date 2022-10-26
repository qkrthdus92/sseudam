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
@WebServlet(urlPatterns = "/board/freeBoardEdit")
public class FreeBoardEditController extends HttpServlet{

	//자유게시판 게시글 수정하기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
			//데이터 꺼내기
			String no = req.getParameter("no");
			
			//디비 다녀오기
			FreeBoardVo vo = new FreeBoardService().detail(no);
			
			//작성자 여부 확인
			HttpSession s = req.getSession();
			MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
			boolean isWriter = (loginMember != null) && loginMember.getNick().equals(vo.getWriterNo());
			
			if(isWriter) {
			//화면 선택
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/board/freeBoard/freeBoardEdit.jsp").forward(req, resp);
			
		} else {
			req.setAttribute("msg", "작성자만 수정이 가능합니다.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		
		//데이터 뭉치기
		FreeBoardVo vo = new FreeBoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(no);
		
		//디비다녀오기
		int result = new FreeBoardService().edit(vo);
		
		//화면선택
		if(result == 1) {
			//성공 => 성공 알람 + 공지사항 상세조회 페이지로
			req.getSession().setAttribute("alertMsg", "게시글을 수정하였습니다.");
			resp.sendRedirect("/sseudam/board/freeBoardDetail?bno=" + no + "&cmtPno=1"); //방금 수정한 게시글 상세페이지로 보내기
			//resp.sendRedirect("/sseudam/board/freeBoardList?pno=1"); //1페이지로 보내기
		}else {
			
			//실패
			req.setAttribute("msg", "공지사항 수정 실패...");
			//req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}
