package com.kh.sseudam.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.board.service.FreeBoardService;
import com.kh.sseudam.board.vo.FreeBoardCmtVo;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/board/freeBoardCmtDelete")
public class FreeBoardCmtDeleteController extends HttpServlet {

	// 댓글 삭제
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 데이터 꺼내기
		String bno = req.getParameter("bno");
		String cmtNo = req.getParameter("cmtNo");
		System.out.println("게시글 번호 : " + bno);/////////////////////
		System.out.println("댓글 번호 : " + cmtNo);///////////////////////
		
		
		// 디비 다녀오기
		FreeBoardCmtVo cmtVo = new FreeBoardService().cmtList(cmtNo);
		//삭제하려는 댓글번호 가지고 작성자번호, 작성자닉네임 가져와서 객체로 만듬
		
		// 댓글 작성자 여부 확인
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo) s.getAttribute("loginMember");
		if(req.getSession().getAttribute("loginMember") == null){
			req.setAttribute("msg", "로그인 후 이용해주세요.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
			
		boolean isWriter = (loginMember != null) && loginMember.getNick().equals(cmtVo.getWriterNo());
		System.out.println("cmtvo : " + cmtVo);/////////////////////////
		System.out.println("로그인멤버 닉네임 : " + loginMember.getNick());////////////
		System.out.println("댓글작성자 닉네임 : " + cmtVo.getWriterNo());////////////////
		if (isWriter) {
			int result = new FreeBoardService().cmtDelete(cmtNo);
			// 화면선택
			if (result == 1) {
				req.getSession().setAttribute("alertMsg", "댓글이 삭제되었습니다.");
				resp.sendRedirect("/sseudam/board/freeBoardDetail?bno="+bno+"&cmtPno=1");
			}else {
				req.setAttribute("msg", "댓글 삭제 실패.");
				req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("msg", "작성자만 삭제가 가능합니다.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			return;
		}
	}

}
