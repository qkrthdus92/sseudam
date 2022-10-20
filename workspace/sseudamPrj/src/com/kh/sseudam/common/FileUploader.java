package com.kh.sseudam.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.Part;

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

}
