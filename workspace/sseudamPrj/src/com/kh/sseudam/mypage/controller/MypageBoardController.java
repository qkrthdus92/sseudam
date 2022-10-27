package com.kh.sseudam.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.member.vo.MemberVo;
import com.kh.sseudam.mypage.board.vo.MypageBoardVo;
import com.kh.sseudam.mypage.service.MypageBoardService;
import com.kh.sseudam.mypage.service.MypageReserService;

@WebServlet(urlPatterns = "/mypage/boardcheck")
public class MypageBoardController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession s = req.getSession();
		
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		String num = loginMember.getNo();
		
		//페이징 처리
		int listCount; 			//총 ㅐ시글 갯수
		int currentPage; 		//현재페이지
		int pageLimit;			//페이징 바 최대갯수
		int boardLimit;			//게시글 최대갯수
		int maxPage;			//가장 마지막 페이지
		int startPage;			//페이징바 시작 페이지
		int endPage;			//페이징바 종료 페이지
		
		
		listCount = new MypageBoardService().selectCount(num);//회원번호 임의지정
		
		currentPage = Integer.parseInt(req.getParameter("pno")) ;
		pageLimit = 5;   //임의로 정함
		boardLimit = 10; //임의로 정함
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit); 

		startPage =(currentPage-1) / pageLimit * pageLimit +1;

		endPage = startPage + pageLimit - 1;
	      
	      if(endPage > maxPage) {
	         endPage = maxPage;
	      }
	   PageVo pv =  new PageVo();
		pv.setListCount(listCount);
		pv.setCurrentPage(currentPage);
		pv.setPageLimit(pageLimit);
		pv.setBoardLimit(boardLimit);
		pv.setMaxPage(maxPage);
		pv.setStartPage(startPage);
		pv.setEndPage(endPage);
	      
	
		
		List<MypageBoardVo> MypageBoardList = new MypageBoardService().selectList(pv,num);
		

		
		req.setAttribute("pv", pv);
		req.setAttribute("MypageBoardList", MypageBoardList);
		req.getRequestDispatcher("/views/mypage/boardcheck.jsp").forward(req, resp);
	}
}
