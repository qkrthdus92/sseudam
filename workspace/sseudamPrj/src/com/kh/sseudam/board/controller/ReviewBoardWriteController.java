package com.kh.sseudam.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
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
import com.kh.sseudam.common.AttachmentVo;
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

		// 세션 가져오기
		HttpSession s = req.getSession();

		// 로그인멤버 가져오기
		MemberVo loginMember = (MemberVo) s.getAttribute("loginMember");
		// 인코딩 >>필터에서 작업
		// req.setCharacterEncoding("UTF-8");

		// 데이터 꺼내기
		String category = req.getParameter("category");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Part f = req.getPart("f");

		AttachmentVo attachmentVo = null;

		// -----------파일업로드 start-----------------
		// 업로드한 파일 정보 디비에 저장
		String rootPath = req.getServletContext().getRealPath("/");

		if (f.getSubmittedFileName().length() > 0) {
			ReviewB = FileUploader.uploadFile(f, rootPath);
			// AttVo 데이터 뭉치기 (위에랑 같은식)
			// attachmentVo = new AttachmentVo();
			// AttachmentVo.setBoardNo(게시글번호) 게시글이 먼저 등록되어야 값을 알 수 있음
			// attachmentVo.setChangeName(changeName);
			// attachmentVo.setOriginName(originName);
			// attachmentVo.setFilePath(filePath);
		}

		// req.getServletContext() : 최상단경로 얻어오는거

		// -----------파일업로드 end-----------------

		// 데이터 뭉치기
		ReviewBoardVo rvo = new ReviewBoardVo();
		rvo.setTitle(title);
		rvo.setContent(content);
		rvo.setWriterNo(loginMember.getNo());

		// 디비 다녀오기
		int result = ReviewBoardService.write(rvo, attachmentVo);

		// 최상단경로 구하는거 변수에 담기

		// 화면선택
		if (result == 1) {
			// 게시글 작성 성공 => 알람 + 게시글 목록 1번페이지로 이동
			s.setAttribute("alertMsg", "게시글 작성 성공!");
			resp.sendRedirect("/semi/board/list?pno=1");
		} else {
			// 게시글 작성실패 => 업로드된 파일 삭제, 알람, 에러페이지,
			if (attachmentVo != null) {
				String savePath = rootPath + attachmentVo.getFilePath() + "/" + attachmentVo.getChangeName();
				new File(savePath).delete();
			}
			req.setAttribute("msg", "게시글 작성 실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}

	}

}
