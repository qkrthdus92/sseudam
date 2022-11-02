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
@WebServlet(urlPatterns = "/board/reviewBoardEdit")
//파일첨부할때 제한 설정하는거..
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 한번에 핸들링 가능한 최대 사이즈
		maxFileSize = 1024 * 1024 * 5, // 파일 1개에 최대 크기
		maxRequestSize = 1024 * 1024 * 50 * 5)
public class ReviewBoardEditController extends HttpServlet{

	//자유게시판 게시글 수정하기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
			//데이터 꺼내기
			String no = req.getParameter("no");
			
			//디비 다녀오기
			ReviewBoardVo rvo = new ReviewBoardService().detail(no);
			List<ReviewBoardImgVo> imgList = new ReviewBoardService().selectAttachment(no);

			
			//작성자 여부 확인
			HttpSession s = req.getSession();
			MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
			boolean isWriter = (loginMember != null) && loginMember.getNick().equals(rvo.getWriterNo());
			
			if(isWriter) {
			//화면 선택
			req.setAttribute("rvo", rvo);
			req.setAttribute("imgList", imgList);
			req.getRequestDispatcher("/views/board/reviewBoard/reviewBoardEdit.jsp").forward(req, resp);
			
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
		List<Part> parts = (List<Part>)req.getParts();
		
		//데이터 뭉치기
		ReviewBoardVo rvo = new ReviewBoardVo();
		rvo.setTitle(title);
		rvo.setContent(content);
		rvo.setNo(no);
		
		List<ReviewBoardImgVo> imgList = new ArrayList<ReviewBoardImgVo>();
		
		//int imgResult = 0;
		
		
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
		
		
		//디비다녀오기
		int result = new ReviewBoardService().edit(rvo, imgList);
		
		//화면선택
		if(result == 1) {
			//성공 => 성공 알람 + 공지사항 상세조회 페이지로
			req.getSession().setAttribute("alertMsg", "게시글을 수정하였습니다.");
			resp.sendRedirect("/sseudam/board/reviewBoardDetail?bno=" + no + "&cmtPno=1"); //방금 수정한 게시글 상세페이지로 보내기
		}else {	
			//실패
			req.setAttribute("msg", "게시글 수정 실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}

}
