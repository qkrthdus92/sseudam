package com.kh.sseudam.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.board.service.ReviewBoardService;
import com.kh.sseudam.board.vo.ReviewBoardImgVo;
import com.kh.sseudam.board.vo.ReviewBoardVo;
import com.kh.sseudam.common.PageVo;

@WebServlet(urlPatterns = "/board/reviewBoardList")
public class ReviewBoardListController extends HttpServlet {

	// 후기게시판 리스트
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩
		req.setCharacterEncoding("UTF-8");

		// 페이징처리
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;

		int maxPage;
		int startPage;
		int endPage;

		// 게시글 갯수 조회

		System.out.println("피에노" + req.getParameter("pno"));

		listCount = new ReviewBoardService().selectCount();
		currentPage = Integer.parseInt(req.getParameter("pno"));
		pageLimit = 10; // 10페이지씩 볼수있게 설정하는곳
		boardLimit = 8; // 한페이지당 10개씩 볼수 있게 설정하는곳

		maxPage = (int) Math.ceil((double) listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		PageVo rpv = new PageVo();
		rpv.setListCount(listCount);
		rpv.setCurrentPage(currentPage);
		rpv.setPageLimit(pageLimit);
		rpv.setBoardLimit(boardLimit);
		rpv.setMaxPage(maxPage);
		rpv.setStartPage(startPage);
		rpv.setEndPage(endPage);

		// 디비 다녀오기
		List<ReviewBoardVo> x = new ReviewBoardService().selectList(rpv);

		
		
		//ReviewBoardImgVo imgVo = new ReviewBoardService().selectThumb(bno);
		//String bno = req.getParameter("bno");
		//System.out.println("비에노" + req.getParameter("bno"));
		
		

		req.setAttribute("rvoList", x);
		req.setAttribute("rpv", rpv);

		// 화면선택
		req.getRequestDispatcher("/views/board/reviewBoard/reviewBoardList.jsp").forward(req, resp);

	}
}
