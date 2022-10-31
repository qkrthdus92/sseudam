package com.kh.sseudam.board.controller;

import java.io.File;
import java.io.IOException;

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
@MultipartConfig(
			fileSizeThreshold = 1024 * 1024, //한번에 핸들링 가능한 최대 사이즈
			maxFileSize = 1024 * 1024 * 5,	//파일 1개에 최대 크기 
			maxRequestSize = 1024 * 1024 * 50 * 5	
		)
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

		// 로그인멤버 가져오기
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo) s.getAttribute("loginMember");

		// 데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Part f = req.getPart("f");
		
		ReviewBoardImgVo imgVo = null;

		//-----------파일업로드 start-----------------
		//업로드한 파일 정보 디비에 저장
		String rootPath = req.getServletContext().getRealPath("/");
		
		if(f.getSubmittedFileName().length() > 0) {
			imgVo = FileUploader.uploadFile(f, rootPath);		
		}
		
		
		
		//-----------파일업로드 end-----------------
		
		// 데이터 뭉치기
		ReviewBoardVo vo = new ReviewBoardVo();
		vo.setWriterNo(loginMember.getNo());
		vo.setTitle(title);
		vo.setContent(content);
		
		// 디비 다녀오기
		int result = ReviewBoardService.write(vo, imgVo);

		// 화면선택
		if (result == 1) {
			// 게시글 작성 성공 => 알람 + 게시글 목록 1번페이지로 이동
			s.setAttribute("alertMsg", "게시글 등록이 완료되었습니다.");
			resp.sendRedirect("/sseudam/board/reviewBoardList?pno=1");
		}else {
			//게시글 작성실패 => 업로드된 파일 삭제, 알람, 에러페이지, 
			if(imgVo != null) {
				String savePath = rootPath + imgVo.getFilePath() + "/" + imgVo.getChangeName();
				new File(savePath).delete();				
			}
			req.setAttribute("msg", "게시글 작성 실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}

	}

}
