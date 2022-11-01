package com.kh.sseudam.admin.reviewBoard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.sseudam.admin.freeBoard.service.AdminFreeBoardService;
import com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardCmtVo;
import com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardVo;
import com.kh.sseudam.admin.reviewBoard.service.AdminReviewBoardService;
import com.kh.sseudam.common.AttachmentVo;
import com.kh.sseudam.common.FileUploader;
import com.kh.sseudam.common.PageVo;
import com.kh.sseudam.common.Paging;

@WebServlet(urlPatterns = "/admin/reviewBoard/edit")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 , 
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 * 5
		)
public class AdminReviewBoardEditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String bno = req.getParameter("bno");
		String pno = req.getParameter("pno");
		String dno = req.getParameter("dno");
		String status = req.getParameter("status");
		String search = req.getParameter("search");
		String searchType = req.getParameter("searchType");
		
	
		
		//후기게시판 글번호에 해당하는 상세정보 받아오기
		AdminFreeBoardVo freeBoardVo = new AdminReviewBoardService().selectFreeBoardDetailByNo(bno);
		
		//후기게시판 글번호에 해당하는 이미지 받아오기
		List imgList = new AdminReviewBoardService().selectReviewBoardImgByNo(bno);
		
		List<AdminFreeBoardCmtVo> freeBoardCmtList = null;
		int currentPage = Integer.parseInt(req.getParameter("dno"));
		int pageLimit = 5;
		int boardLimit = 5;
		int listCount = 0;
		
		//후기게시판 글번호에 해당하는 댓글목록 받아오기
		if(freeBoardVo != null) {
			listCount = new AdminReviewBoardService().getCntFreeCmt(bno);
			PageVo pv = Paging.paging(listCount, currentPage, pageLimit, boardLimit);
			req.setAttribute("pv", pv);
			freeBoardCmtList = new AdminReviewBoardService().selectFreeBoardCmtByNo(bno, pv);
		}
		
		if(freeBoardCmtList != null) {
			req.setAttribute("pno", pno);
			req.setAttribute("search", search);
			req.setAttribute("searchType", searchType);
			req.setAttribute("status", status);
			req.setAttribute("bno", bno);
			req.setAttribute("dno", dno);
			
			req.setAttribute("imgList", imgList);
			req.setAttribute("freeBoardVo", freeBoardVo);
			req.setAttribute("freeBoardCmtList", freeBoardCmtList);
			req.getRequestDispatcher("/views/admin/reviewBoard/edit.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "관리자페이지 후기게시판 글 수정단계 진행 중 에러발생");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String bno = req.getParameter("bno");
		String pno = req.getParameter("pno");
		String dno = req.getParameter("dno");
		String status = req.getParameter("status");
		String search = req.getParameter("search");
		String searchType = req.getParameter("searchType");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		List<Part> parts = (List<Part>)req.getParts();
		
		AdminFreeBoardVo vo = new AdminFreeBoardVo();
		vo.setNo(bno);
		vo.setTitle(title);
		vo.setContent(content);
		
		List<AttachmentVo> list = new ArrayList<AttachmentVo>();
		
		for(int i=0; i<parts.size(); i++) {
		
			Part part = parts.get(i);
			if(!part.getName().equals("f")) continue; //f로 들어온 Part가 아니면 스킵
			if(part.getSubmittedFileName().equals("")) continue; //업로드 된 파일 이름이 없으면 스킵
			
			String rootPath = req.getServletContext().getRealPath("/");
			
			AttachmentVo aVo = null;
			if(part.getSubmittedFileName().length() > 0) {
				aVo = FileUploader.uploadFile(part, rootPath, "resources/upload/afterBoard");
			}
			list.add(aVo);
			
		}
		
		
		
		
		//디비에 제목,내용 업데이트
		int result = new AdminReviewBoardService().editFreeBoardDetail(vo, list);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "후기게시판 게시글 수정 완료");
			req.getSession().setAttribute("bno2", bno);
			req.getSession().setAttribute("pno2", pno);
			req.getSession().setAttribute("dno2", dno);
			req.getSession().setAttribute("status2", status);
			req.getSession().setAttribute("search2", search);
			req.getSession().setAttribute("searchType2", searchType);
			resp.sendRedirect("/sseudam/admin/reviewBoard/detail?pno="+pno+"&bno="+bno+"&dno="+dno+"&search"+search+"&searchType"+searchType+"&status"+status);
			
		}else {
			req.setAttribute("msg", "관리자페이지 후기게시판 글 수정 실패!");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
		
	}
}
