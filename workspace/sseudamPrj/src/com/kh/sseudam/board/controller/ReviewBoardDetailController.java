package com.kh.sseudam.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.board.service.FreeBoardService;
import com.kh.sseudam.board.service.ReviewBoardService;
import com.kh.sseudam.board.vo.FreeBoardCmtVo;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.board.vo.ReviewBoardCmtVo;
import com.kh.sseudam.board.vo.ReviewBoardVo;
import com.kh.sseudam.common.AttachmentVo;
import com.kh.sseudam.common.PageVo;
@WebServlet(urlPatterns = "/board/reviewBoardDetail")
public class ReviewBoardDetailController extends HttpServlet{

	//후기게시판 상세조회
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
		listCount = new ReviewBoardService().selectCountCmt(bno);


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
		List<ReviewBoardCmtVo> cmtVo = null;

		// 댓글 내용 가져오기
		cmtVo = new ReviewBoardService().selectCmt(cmtPv, bno, cmtNo);
		req.setAttribute("cmtVo", cmtVo);

		// 게시글 내용 가져오기
		ReviewBoardVo rvo = new ReviewBoardService().detail(bno);
		req.setAttribute("rvo", rvo);
		req.setAttribute("cmtPv", cmtPv);

		// 화면선택
		req.getRequestDispatcher("/views/board/reviewBoard/reviewBoardDetail.jsp").forward(req, resp);
	}

}
