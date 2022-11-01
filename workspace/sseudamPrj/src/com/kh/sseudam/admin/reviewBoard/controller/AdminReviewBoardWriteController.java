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
import com.kh.sseudam.admin.freeBoard.vo.AdminFreeBoardVo;
import com.kh.sseudam.admin.pro.service.AdminProService;
import com.kh.sseudam.admin.reviewBoard.service.AdminReviewBoardService;
import com.kh.sseudam.common.AttachmentVo;
import com.kh.sseudam.common.FileUploader;
import com.kh.sseudam.counsel.pro.vo.CertificateVo;

@WebServlet(urlPatterns = "/admin/reviewBoard/write")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 , 
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 * 5
		)
public class AdminReviewBoardWriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//취소버튼 누를시에 바로 이전페이지로 이동하기위해서 이전페이지 정보 받아옴
		String pno = req.getParameter("pno");
		String search = req.getParameter("search");
		String searchType = req.getParameter("searchType");
		String status = req.getParameter("status");
		
		req.setAttribute("pno", pno);
		req.setAttribute("search", search);
		req.setAttribute("searchType", searchType);
		req.setAttribute("status", status);
		req.getRequestDispatcher("/views/admin/reviewBoard/add.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		List<Part> parts = (List<Part>)req.getParts();
		
		AdminFreeBoardVo vo = new AdminFreeBoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		
		List<AttachmentVo> list = new ArrayList<AttachmentVo>();
		int imgResult = 0;
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

		int result = new AdminReviewBoardService().insertReviewBoard(vo, list);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "후기게시판 게시글 작성 완료");
			resp.sendRedirect("/sseudam/admin/reviewBoard/list?pno=1&status=all&searchType=title&search=");
		}else {
			req.setAttribute("msg", "관리자페이지 후기게시판 게시글 작성 실패!");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}

}
