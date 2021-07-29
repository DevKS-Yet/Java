package com.site.mBoard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.mBoard.dao.BoardDao;

public class BServiceWrite implements PService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BServiceWrite - 시작");
		
		BoardDao boardDao = new BoardDao();
		try {
			int size = 10 * 1024 * 1024;
			String path = "c:/upload";
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			String bname = multi.getParameter("bname");
			String btitle = multi.getParameter("btitle");
			String bcontent = multi.getParameter("bcontent");
			String bupload = multi.getFilesystemName("bupload");
			System.out.println("BServiceWrite - boardOneInsert()");
			int result = boardDao.boardOneInsert(btitle, bcontent, bname, bupload);
			request.setAttribute("resultWrite", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("BServiceWrite - 끝");
	}

}
