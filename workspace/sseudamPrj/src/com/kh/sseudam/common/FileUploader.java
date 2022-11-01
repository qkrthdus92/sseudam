package com.kh.sseudam.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.Part;

import com.kh.sseudam.board.vo.ReviewBoardImgVo;

public class FileUploader {
	
	public static AttachmentVo uploadFile(Part f, String rootPath, String filePath) throws IOException {
		
		String originName = f.getSubmittedFileName(); //사용자가 제출한 파일 이름 알아내기
		String ext = originName.substring(originName.lastIndexOf("."), originName.length());
		String changeName = System.currentTimeMillis() + "_" + (Math.random()*99999 + 1) +ext;
		
		//String filePath = "upload/img"; 
		String path = rootPath + filePath + "/"; // 최상단경로
		File target = new File(path + changeName);
		
		BufferedInputStream bis = new BufferedInputStream(f.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
		
		byte[] buf = new byte[1024]; 
		
		int size = 0;
		
		while((size = bis.read(buf)) != -1) {
			
			bos.write(buf, 0, size);
		}
		bos.flush();
		bis.close();
		bos.close();
		
		AttachmentVo vo = new AttachmentVo();
		vo.setChangeName(changeName);
		vo.setOriginName(originName);
		vo.setFilePath(filePath);
		
		return vo;
		
	}


	public static ReviewBoardImgVo uploadReviewBoard(Part f, String rootPath, String filePath) throws IOException {
		
		String originName = f.getSubmittedFileName(); //사용자가 제출한 파일 이름 알아내기
		String ext = originName.substring(originName.lastIndexOf("."), originName.length());
		String changeName = System.currentTimeMillis() + "_" + (Math.random()*99999 + 1) +ext;
		
		//String filePath = "upload/img"; 
		String path = rootPath + filePath + "/"; // 최상단경로
		File target = new File(path + changeName);
		
		BufferedInputStream bis = new BufferedInputStream(f.getInputStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
		
		byte[] buf = new byte[1024]; 
		
		int size = 0;
		
		while((size = bis.read(buf)) != -1) {
			
			bos.write(buf, 0, size);
		}
		bos.flush();
		bis.close();
		bos.close();
		
		ReviewBoardImgVo imgVo = new ReviewBoardImgVo();
		imgVo.setChangeName(changeName);
		imgVo.setOriginName(originName);
		imgVo.setFilePath(filePath);
		
		return imgVo;
		
	}
	
	
	
	
	
	/*
	 * public static ReviewBoardImgVo uploadFile(Part f, String rootPath) throws
	 * IOException { //0. 준비 String originName = f.getSubmittedFileName(); String
	 * ext = originName.substring(originName.lastIndexOf("."), originName.length());
	 * String changeName =System.currentTimeMillis() + "_" + (Math.random()*9999 +
	 * 1) + ext;
	 * 
	 * //1. 파일 객체 준비 (경로 + 파일명) WebContent/upload/img String filePath =
	 * "upload/img"; String path = rootPath + filePath + "/"; File target = new
	 * File(path + changeName); // "경로/파일명"
	 * 
	 * //2. 데이터 넣기 (클라파일 > 자바 > 타켓파일 ) BufferedInputStream bis = new
	 * BufferedInputStream(f.getInputStream()); BufferedOutputStream bos = new
	 * BufferedOutputStream(new FileOutputStream(target));
	 * 
	 * byte[] buf = new byte[1024];
	 * 
	 * //첨부된 파일을 끝까지 읽어들이고, 다시 내보내는 반복문 int size = 0; while((size = bis.read(buf))
	 * != -1) { bos.write(buf, 0, size); }
	 * 
	 * bos.flush(); bis.close(); bos.close();
	 * 
	 * ReviewBoardImgVo imgVo = new ReviewBoardImgVo();
	 * imgVo.setChangeName(changeName); imgVo.setOriginName(originName);
	 * imgVo.setFilePath(filePath);
	 * 
	 * return imgVo; }
	 */

}
