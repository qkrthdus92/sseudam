package com.kh.sseudam.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.board.service.FreeBoardService;
import com.kh.sseudam.board.vo.FreeBoardVo;
import com.kh.sseudam.common.PageVo;

@WebServlet(urlPatterns = "/board/freeBoardList")
public class FreeBoardListController extends HttpServlet {

	// 자유게시판 리스트
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
		listCount = new FreeBoardService().selectCount();
		currentPage = Integer.parseInt(req.getParameter("pno"));
		pageLimit = 10; // 5페이지씩 볼수있게 설정하는곳
		boardLimit = 10; // 한페이지당 10개씩 볼수 있게 설정하는곳

		maxPage = (int) Math.ceil((double) listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageVo pv = new PageVo();
		pv.setListCount(listCount);
		pv.setCurrentPage(currentPage);
		pv.setPageLimit(pageLimit);
		pv.setBoardLimit(boardLimit);
		pv.setMaxPage(maxPage);
		pv.setStartPage(startPage);
		pv.setEndPage(endPage);
		
		//댓글 갯수 받아오기
		
		
		
		
		// 디비 다녀오기
		List<FreeBoardVo> x = new FreeBoardService().selectList(pv);
		
		req.setAttribute("voList", x);
		req.setAttribute("pv", pv);

		// 화면선택
		req.getRequestDispatcher("/views/board/freeBoard/freeBoardList.jsp").forward(req, resp);

	}
}
