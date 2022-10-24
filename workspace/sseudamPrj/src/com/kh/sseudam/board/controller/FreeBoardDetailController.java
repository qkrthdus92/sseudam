package com.kh.sseudam.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.sseudam.board.service.FreeBoardService;
import com.kh.sseudam.board.vo.FreeBoardVo;
@WebServlet(urlPatterns = "/board/freeBoardDetail")
public class FreeBoardDetailController extends HttpServlet{

	//자유게시판 게시글 상세조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//데이터 꺼내기
		String no = req.getParameter("bno");
		
		//디비다녀오기
		FreeBoardVo vo = new FreeBoardService().detail(no);  
		//화면선택
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/views/board/freeBoard/freeBoardDetail.jsp").forward(req, resp);
	}
	
}


