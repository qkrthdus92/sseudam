package com.kh.sseudam.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.sseudam.board.service.ReviewBoardService;
import com.kh.sseudam.board.vo.ReviewBoardImgVo;
import com.kh.sseudam.board.vo.ReviewBoardVo;
import com.kh.sseudam.common.FileUploader;
import com.kh.sseudam.member.vo.MemberVo;

@WebServlet(urlPatterns = "/board/reviewBoardWrite")
//파일첨부할때 제한 설정하는거..
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 한번에 핸들링 가능한 최대 사이즈
		maxFileSize = 1024 * 1024 * 5, // 파일 1개에 최대 크기
		maxRequestSize = 1024 * 1024 * 50 * 5)
public class ReviewBoardWriteController extends HttpServlet {

	// 후기게시판 게시글 작성
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 로그인여부 확인
		if (req.getSession().getAttribute("loginMember") == null) {
			req.setAttribute("msg", "로그인 후 이용해주세요.");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
			return;
		}

		// 화면선택
		req.getRequestDispatcher("/views/board/reviewBoard/reviewBoardWrite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 req.setCharacterEncoding("UTF-8");

		// 세션 가져오기
		HttpSession s = req.getSession();

		// 로그인멤버 가져오기
		MemberVo loginMember = (MemberVo) s.getAttribute("loginMember");

		// 데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		List<Part> parts = (List<Part>)req.getParts();

		System.out.println("타이틀 : " + req.getParameter("title"));
		System.out.println("컨텐트 : " + req.getParameter("content"));

		// 데이터 뭉치기 (게시글)
		ReviewBoardVo rvo = new ReviewBoardVo();
		rvo.setTitle(title);
		rvo.setContent(content);
		rvo.setWriterNo(loginMember.getNo());

		//데이터 뭉치기 (업로드파일)
		List<ReviewBoardImgVo> imgList = new ArrayList<ReviewBoardImgVo>();
	    int imgResult = 0;

		// -----------파일업로드 start-----------------
	
		for(int i=0; i<parts.size(); i++) {
		      
	         Part part = parts.get(i);
	         if(!part.getName().equals("f")) continue; //f로 들어온 Part가 아니면 스킵
	         if(part.getSubmittedFileName().equals("")) continue; //업로드 된 파일 이름이 없으면 스킵
	         
	         String rootPath = req.getServletContext().getRealPath("/"); // 업로드한 파일 정보 디비에 저장
	         System.out.println(rootPath);
	         
	         ReviewBoardImgVo imgVo = null;
	         if(part.getSubmittedFileName().length() > 0) {
	        	 imgVo = FileUploader.uploadReviewBoard(part, rootPath, "resources/upload/afterBoard");
	         }
	         imgList.add(imgVo);
	         
	      }

		System.out.println(rvo);
		System.out.println(imgList);
	      int result = new ReviewBoardService().write(rvo, imgList);
	      
	      if(result == 1) {
	         req.getSession().setAttribute("alertMsg", "게시글 작성 완료");
	         resp.sendRedirect("/sseudam/board/reviewBoardList?pno=1");
	      }else {
	         req.setAttribute("msg", "게시글 작성 실패!");
	         req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
	      }
	}


}
