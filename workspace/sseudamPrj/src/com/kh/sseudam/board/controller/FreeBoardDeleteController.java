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

@WebServlet(urlPatterns = "/board/freeBoardDelete")
public class FreeBoardDeleteController extends HttpServlet {

	// 자유게시판 게시글 삭제
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터 꺼내기
		String no = req.getParameter("no"); //삭제하려는 게시글 번호
		
		// 디비 다녀오기
		FreeBoardVo vo = new FreeBoardService().detail(no);
		//삭제하려는 게시글번호 가지고 작성자번호, 작성자닉네임 가져와서 객체로 만듬
		
		// 작성자 여부 확인
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo) s.getAttribute("loginMember");
		boolean isWriter = (loginMember != null) && loginMember.getNick().equals(vo.getWriterNo());
		if (isWriter) {
			int result = new FreeBoardService().delete(no);
			// 화면선택
			if (result == 1) {
				// 성공 => 알람 + 리스트조회 화면으로 보내기
				req.getSession().setAttribute("alertMsg", "게시글이 삭제되었습니다.");
				resp.sendRedirect("/sseudam/board/freeBoardList?pno=1");
			} else {
				// 실패 => 메세지, 에러페이지
				req.setAttribute("msg", "게시글 삭제 실패");
				req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "작성자만 삭제가 가능합니다.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
	}

}
