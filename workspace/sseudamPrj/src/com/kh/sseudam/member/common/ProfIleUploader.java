package com.kh.sseudam.member.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.Part;

import com.kh.sseudam.pro.vo.ProJoinPage2Vo;

public class ProfIleUploader {

	public static String profileUploadFile(Part img, String rootPath) throws IOException {
		
		// 0. 데이터 준비
		String profileImgName = img.getSubmittedFileName();	//업로드한 파일 이름 구해서 cerImgName에 넣음
		
		System.out.println(profileImgName);
		
		// 1. 파일 객체 준비 (경로+파일명)
		String profilePath = "resources/upload/profile";
		String path = rootPath + profilePath + "/";	//최상단경로
		File target = new File(path + profileImgName);
		
		// 2. 데이터 넣기 (클라파일 -> 자바 -> 타겟파일)
		// 읽고
		BufferedInputStream bis = new BufferedInputStream(img.getInputStream());
		// 내보냄
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
		
		byte[] buf = new byte[1024];
		
		int size = 0;
		while((size = bis.read(buf)) != -1){
			bos.write(buf, 0, size);
		  //bos.write(byte 크기, 몇 개 건너 뛸 건지, 내보낼 크기)
		}
		
		bos.flush();	//write에 저장된 값을 출력함과 동시에 비워줌
		bis.close();
		bos.close();
		
		ProJoinPage2Vo vo = new ProJoinPage2Vo();
		vo.setImgPath(profileImgName);
		
		return profileImgName;
				
		
	}
	
}
