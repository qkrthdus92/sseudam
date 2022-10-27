package com.kh.sseudam.board.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns = "/board/freeBoardDetail")
public class FreeBoardDetailController extends HttpServlet {

	// 자유게시판 게시글 상세조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩
		req.setCharacterEncoding("UTF-8");

		// 데이터 꺼내기
		String bno = req.getParameter("bno");
		String cmtNo = req.getParameter("cmtNo");

///////////////////////댓글 페이징처리/////////////////////
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;

		int maxPage;
		int startPage;
		int endPage;

		// 댓글 갯수 조회
		listCount = new FreeBoardService().selectCountCmt(bno);

		System.out.println("디테일컨틀러 cmtPno : "+req.getParameter("cmtPno"));///////////
		currentPage = Integer.parseInt(req.getParameter("cmtPno"));
		pageLimit = 5; // 5페이지씩 볼수있게 설정하는곳
		boardLimit = 5; // 한페이지당 10개씩 볼수 있게 설정하는곳
		maxPage = (int) Math.ceil((double) listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		PageVo cmtPv = new PageVo();
		cmtPv.setListCount(listCount);
		cmtPv.setCurrentPage(currentPage);
		cmtPv.setPageLimit(pageLimit);
		cmtPv.setBoardLimit(boardLimit);
		cmtPv.setMaxPage(maxPage);
		cmtPv.setStartPage(startPage);
		cmtPv.setEndPage(endPage);
/////////////////////댓글 페이징처리/////////////////////

		// 디비다녀오기
		List<FreeBoardCmtVo> cmtVo = null;

		// 댓글 내용 가져오기
		cmtVo = new FreeBoardService().selectCmt(cmtPv, bno, cmtNo);
		req.setAttribute("cmtVo", cmtVo);

		// 게시글 내용 가져오기
		FreeBoardVo vo = new FreeBoardService().detail(bno);
		req.setAttribute("vo", vo);
		req.setAttribute("cmtPv", cmtPv);

		// 화면선택
		req.getRequestDispatcher("/views/board/freeBoard/freeBoardDetail.jsp").forward(req, resp);
	}

	// 댓글 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩
		req.setCharacterEncoding("UTF-8");

		// 로그인멤버 가져오기
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo) s.getAttribute("loginMember");
		
		if(req.getSession().getAttribute("loginMember") == null){
			req.setAttribute("msg", "로그인 후 이용해주세요.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			return;
		}

		// 데이터 꺼내기
		String bno = req.getParameter("bno");
		String cmtContent = req.getParameter("cmtContent");

		// 데이터 뭉치기
		FreeBoardCmtVo cmtVo = new FreeBoardCmtVo();
		cmtVo.setFreeBoardNo(bno);
		cmtVo.setWriterNo(loginMember.getNo());
		cmtVo.setCmt(cmtContent);

		// 디비 다녀오기
		int result = FreeBoardService.writeCmt(cmtVo);

		// 화면선택
		if (result == 1) {
			// 게시글 작성 성공 => 알람 + 게시글 목록 1번페이지로 이동
			s.setAttribute("alertMsg", "댓글 등록이 완료되었습니다.");
			resp.sendRedirect("/sseudam/board/freeBoardDetail?bno="+bno+"&cmtPno=1");
		} else {
			req.setAttribute("msg", "댓글 등록 실패.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}

	}

}
